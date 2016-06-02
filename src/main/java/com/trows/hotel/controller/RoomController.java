package com.trows.hotel.controller;

import com.alibaba.fastjson.JSON;
import com.trows.hotel.common.util.HotelMap;
import com.trows.hotel.entity.Room;
import com.trows.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Throws_exception on 2016/5/29.
 */
@Controller
public class RoomController {

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


    @RequestMapping("/getEmptyRoom.do")
    public void getEmptyRoom(HttpServletRequest request, HttpServletResponse response){
        String room_type = request.getParameter("room_type");
        String flag = request.getParameter("flag");
        if (room_type!=null || flag != null){
            String room_id = getRoom(room_type,flag);
            if (room_id == null){
                this.print(response,"empty");
            }else {
                this.print(response,room_id);
            }
        }
    }

    private String getRoom(String room_type,String flag){
        HashMap<String,Integer> roomMap = hotelMap.getRoomMap().get(room_type);
        int intFlag = Integer.parseInt(flag,2);
        for (Map.Entry<String,Integer> entry : roomMap.entrySet()){
                        if ((entry.getValue()&intFlag)==intFlag && (entry.getValue()-intFlag >0)) return entry.getKey();
        }
        return null;
    }

    @RequestMapping("/insertRoom.do")
    public void insertRoom(@RequestParam("room") String roomStr,HttpServletResponse response){
        Room room = JSON.parseObject(roomStr,Room.class);
        this.print(response,roomService.insert(room,"insertRoom"));
    }



}
