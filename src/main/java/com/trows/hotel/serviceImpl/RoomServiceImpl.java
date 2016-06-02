package com.trows.hotel.serviceImpl;

import com.trows.hotel.base.AbstractBaseDao;
import com.trows.hotel.entity.Room;
import com.trows.hotel.service.RoomService;
import org.springframework.stereotype.Service;

/**
 * Created by Throws_exception on 2016/5/27.
 */
@Service
public class RoomServiceImpl extends AbstractBaseDao<Room,String> implements RoomService {
}
