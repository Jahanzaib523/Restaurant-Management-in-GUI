/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.sql.Timestamp;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author faizx
 */
public class OrderHandle {
    private SimpleStringProperty orderid;
    private Timestamp  ordertime;

    public OrderHandle(String orderid, Timestamp ordertime) 
    {
        this.orderid = new SimpleStringProperty(orderid) {};
        this.ordertime = ordertime;
    }

    public String getOrderid() 
    {
        return new String(orderid.get());
    }

    public void setOrderid(SimpleStringProperty orderid) 
    {
        this.orderid = orderid;
    }

    public Timestamp getOrdertime() 
    {
        return ordertime;
    }

    public void setOrdertime(Timestamp ordertime) 
    {
        this.ordertime = ordertime;
    }
    
}
