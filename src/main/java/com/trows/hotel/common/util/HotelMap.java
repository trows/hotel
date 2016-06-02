package com.trows.hotel.common.util;

import com.trows.hotel.entity.Room;
import com.trows.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Throws_exception on 2016/5/29.
 * 房间预订状态存储数据结构
 */
@Component
public class HotelMap {

    private HashMap<String,HashMap<String,Integer>> roomMap;
    @Autowired
    private RoomService roomService;
    private void initHotelMap (){
        System.out.println("房间数据开始初始化。。。。。。。。。。。。。");
        //获取现有参数
        List<Room> list = roomService.getListByKey("initRoom","initRoom");
        HashSet<String> set = new HashSet<String>();
        for (Room room : list){
            set.add(room.getRoom_type());
        }
        roomMap = new HashMap<String, HashMap<String,Integer>>();
        for(String type:set){
            roomMap.put(type,new HashMap<String, Integer>());
        }
        for (Room room : list){
            roomMap.get(room.getRoom_type()).put(room.getRoom_id(),room.getFlag());
        }
        System.out.println("数据初始化完毕。。。。。。。。。。。。。");
    }
    public HashMap<String,HashMap<String,Integer>> getRoomMap(){
        if(roomMap == null) initHotelMap();
        return roomMap;
    }

}
