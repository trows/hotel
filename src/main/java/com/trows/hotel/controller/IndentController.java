package com.trows.hotel.controller;

import com.alibaba.fastjson.JSON;
import com.trows.hotel.common.util.HotelMap;
import com.trows.hotel.entity.Indent;
import com.trows.hotel.entity.Room;
import com.trows.hotel.service.IndentService;
import com.trows.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Throws_exception on 2016/5/29.
 */
@Controller
public class IndentController {

    @Autowired
    private IndentService indentService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private HotelMap hotelMap;

    private void print(HttpServletResponse response, String value) {
        try {
            response.getWriter().print(value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void print(HttpServletResponse response, int value) {
        try {
            response.getWriter().print(value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/initIndent.do")
    public void initIndent(@RequestParam("indent") String indentStr,@RequestParam("flag") String flag, HttpServletResponse response){
        Indent indent = JSON.parseObject(indentStr,Indent.class);
//        System.out.println(flag);
        int flagInt = Integer.parseInt(flag,2);
        Room room = roomService.getEntityByKey(indent.getRoom_id(),"getRoomByKey");
        room.setFlag(room.getFlag()-flagInt);
        indent.setRoom_price(room.getRoom_price());
        indent.setId_key(new Random().nextInt(800)+100);   //生成随机KEY
        indent.setFlag(flagInt);
//        System.out.println(indent);
        int result = indentService.insert(indent,"initIndent");
        if(indent.getIndent_state().equals("booking") && result == 1){
            this.print(response,indent.getIndent_id()+""+indent.getId_key());
        }else {
            this.print(response,result);
        }
        HashMap<String,Integer> roomMap = hotelMap.getRoomMap().get(room.getRoom_type());
        roomMap.put(room.getRoom_id(),room.getFlag());
        roomService.update(room,"setFlag");
    }

    @RequestMapping("/getMyBill.htm")
    public String getMyBill(HttpServletRequest request){
        Indent indent = new Indent();
        indent.setRoom_id(request.getParameter("room_id"));
        indent.setIndent_state("check_in");
        indent = indentService.getEntityByValue(indent,"getIndentByRoom");
        if (indent!=null && indent.getIndent_id()>10000){
            request.setAttribute("indent",indent);
            return "/settleAccounts";
        }
        return "redirect:/check_out.html?return_code=empty";
    }

    @RequestMapping("/settleAccount.do")
    public void settleAccount(HttpServletRequest request,HttpServletResponse response){
        int indent_id = Integer.parseInt(request.getParameter("indent_id"));
        float other_price = Float.parseFloat(request.getParameter("other_price"));
        Indent indent = indentService.getEntityByKey(indent_id,"getIndentByKey");
        indent.setOther_price(other_price);
        Room room = new Room();
        room.setRoom_id(indent.getRoom_id());
        room.setFlag(indent.getFlag());
        if (roomService.update(room,"resetRoom") == 1 && indentService.update(indent,"settleAccount") == 1){
         this.print(response,"success");
        }else {
            this.print(response,"error");
        }
    }

    @RequestMapping("/check_in.htm")
    public String check_in(HttpServletRequest request){
        String id = request.getParameter("id");
        if(id == null || id.length()!=8) return "redirect:/check_in.html?return_code=empty";

        Indent indent = new Indent();
        indent.setIndent_id(Integer.parseInt(id.substring(0,5)));
        indent.setId_key(Integer.parseInt(id.substring(5)));
//        System.out.println(indent.getIndent_id()+"---"+indent.getId_key());
        indent = indentService.getEntityByValue(indent,"getIndentById");
        if (indent!=null && "booking".equals(indent.getIndent_state())){
            request.setAttribute("room",roomService.getEntityByKey(indent.getRoom_id(),"getRoomByKey"));
            request.setAttribute("indent",indent);
            return "./indent_info";
        }else {
            return "redirect:/check_in.html?return_code=empty";
        }

    }

    @RequestMapping("/booking_in.do")
    public void booking_in(HttpServletRequest request,HttpServletResponse response){
        String id = request.getParameter("id");
        if(id == null || id.length()!=8){
            this.print(response,0);
        }else {
            Indent indent = new Indent();
            indent.setIndent_id(Integer.parseInt(id.substring(0,5)));
            indent.setId_key(Integer.parseInt(id.substring(5)));
            this.print(response,indentService.update(indent,"booking_in"));
        }
    }

    @RequestMapping("/delIndent.do")
    public void delIndent(HttpServletRequest request,HttpServletResponse response){
        String id = request.getParameter("id");
        if(id == null || id.length()!=8){
            this.print(response,0);
        }else {
            Indent indent = new Indent();
            indent.setIndent_id(Integer.parseInt(id.substring(0,5)));
            indent.setId_key(Integer.parseInt(id.substring(5)));
            indent = indentService.getEntityByValue(indent,"getIndentById");
            if(indent!=null){
                this.print(response,indentService.deleteByValue(indent,"delIndent"));
                Room room = new Room();
                room.setRoom_id(indent.getRoom_id());
                room.setFlag(indent.getFlag());
                roomService.update(room,"resetRoom");
            }else {
                this.print(response,0);
            }


        }
    }

}
