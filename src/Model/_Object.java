/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author tuankqhe130156
 */
public class _Object {

    int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    String name;
    int type;
    String IP_Address;
    int designation;
    Date to_date;
    Date from_date;
    Date from_time;
    Date to_time;

    public _Object() {
    }

    public void setName(String username) {
        this.name = username;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setIP_Address(String IP_Address) {
        this.IP_Address = IP_Address;
    }

    public void setDesignation(int designation) {
        this.designation = designation;
    }

    public void setTo_date(Date to_date) {
        this.to_date = to_date;
    }

    public void setFrom_date(Date from_date) {
        this.from_date = from_date;
    }

    public void setFrom_time(Date from_time) {
        this.from_time = from_time;
    }

    public void setTo_time(Date to_time) {
        this.to_time = to_time;
    }

    public _Object(String username, int type, String IP_Address, int designation, Date to_date, Date from_date, Date from_time, Date to_time) {
        this.name = username;
        this.type = type;
        this.IP_Address = IP_Address;
        this.designation = designation;
        this.to_date = to_date;
        this.from_date = from_date;
        this.from_time = from_time;
        this.to_time = to_time;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }

    public String getIP_Address() {
        return IP_Address;
    }

    public int getDesignation() {
        return designation;
    }

    public Date getTo_date() {
        return to_date;
    }

    public Date getFrom_date() {
        return from_date;
    }

    public Date getFrom_time() {
        return from_time;
    }

    public Date getTo_time() {
        return to_time;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
