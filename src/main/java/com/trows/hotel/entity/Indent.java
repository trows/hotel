package com.trows.hotel.entity;

/**
 * Created by Throws_exception on 2016/5/27.
 */
public class Indent {

    private int indent_id;
    private String room_id;
    private String user_name;
    private String id_card;
    private String cellphone;
    private int num;
    private String start_time;
    private String end_time;
    private float room_price;
    private float service_price;
    private String service_list;
    private float other_price;
    private String indent_state;
    private int id_key;
    private int flag;


    public int getIndent_id() {
        return indent_id;
    }

    public void setIndent_id(int indent_id) {
        this.indent_id = indent_id;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public float getRoom_price() {
        return room_price;
    }

    public void setRoom_price(float room_price) {
        this.room_price = room_price;
    }

    public float getService_price() {
        return service_price;
    }

    public void setService_price(float service_price) {
        this.service_price = service_price;
    }

    public String getService_list() {
        return service_list;
    }

    public void setService_list(String service_list) {
        this.service_list = service_list;
    }

    public float getOther_price() {
        return other_price;
    }

    public void setOther_price(float other_price) {
        this.other_price = other_price;
    }

    public String getIndent_state() {
        return indent_state;
    }

    public void setIndent_state(String indent_state) {
        this.indent_state = indent_state;
    }

    public int getId_key() {
        return id_key;
    }

    public void setId_key(int id_key) {
        this.id_key = id_key;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Indent{" +
                "indent_id=" + indent_id +
                ", room_id='" + room_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", id_card='" + id_card + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", num=" + num +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", room_price=" + room_price +
                ", service_price=" + service_price +
                ", service_list='" + service_list + '\'' +
                ", other_price=" + other_price +
                ", indent_state=" + indent_state +
                ", key=" + id_key +
                '}';
    }
}
