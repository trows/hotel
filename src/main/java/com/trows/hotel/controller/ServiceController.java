package com.trows.hotel.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.trows.hotel.entity.Indent;
import com.trows.hotel.entity.Service;
import com.trows.hotel.service.IndentService;
import com.trows.hotel.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Throws_exception on 2016/6/3.
 */
@Controller
public class ServiceController {
    @Autowired
    private IndentService indentService;
    @Autowired
    private ServiceService serviceService;


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


    @RequestMapping("/getHotelService.htm")
    public String getHotelService(HttpServletRequest request){

        String room_id = request.getParameter("room_id");
        if (room_id == null){
            return "redirect:/hotel_service.html";
        }

//        Indent indent = indentService.getEntityByStr(room_id,"getCheck_inRoomByKey");
        List<Service> list = serviceService.getListByStr("1","getAllService");
        request.setAttribute("list",list);
        request.setAttribute("room_id",room_id);
        return "/service_list";
    }

    @RequestMapping("/subService.do")
    public void subService(HttpServletRequest request, HttpServletResponse response){
        String room_id = request.getParameter("room_id");
        String service = request.getParameter("service");
        Indent indent = indentService.getEntityByStr(room_id,"getCheck_inRoomByKey");
        if(room_id == null || service ==null || indent == null){
          this.print(response,0);
        }else {
            String sevStr = indent.getService_list();
//            System.out.println(sevStr.length());
            if(!"".equals(sevStr)){
                JSONObject now_json = JSON.parseObject(service);
                JSONObject per_json = JSON.parseObject(sevStr);

                for (Map.Entry<String, Object> entry : now_json.entrySet()) {
//                    System.out.println(entry.getKey() + ":" + entry.getValue());
                    if(per_json.getInteger(entry.getKey())!=null){
                        per_json.put(entry.getKey(),(per_json.getInteger(entry.getKey())+(Integer) entry.getValue()));
//                        ((Integer)entry.getValue()+5)
                    }else {
                        per_json.put(entry.getKey(),entry.getValue());
                    }
                }
                indent.setService_list(JSON.toJSONString(per_json));
            }else {
                indent.setService_list(service);
            }
            this.print(response,indentService.update(indent,"setServiceList"));
        }

    }

}
