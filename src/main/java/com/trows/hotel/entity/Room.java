package com.trows.hotel.entity;

/**
 * Created by Throws_exception on 2016/5/27.
 */
public class Room {

    private String room_id;
    private String room_type;
    private float room_price;
    private int room_state;
    private int flag;

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public float getRoom_price() {
        return room_price;
    }

    public void setRoom_price(float room_price) {
        this.room_price = room_price;
    }

    public int getRoom_state() {
        return room_state;
    }

    public void setRoom_state(int room_state) {
        this.room_state = room_state;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
