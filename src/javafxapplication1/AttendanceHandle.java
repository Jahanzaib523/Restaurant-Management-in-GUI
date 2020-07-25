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
public class AttendanceHandle {
    //private Timestamp month;
    private SimpleStringProperty month;
    private Timestamp entry_time;
    private Timestamp exit_time;

    public AttendanceHandle(String month, Timestamp entry_time, Timestamp exit_time) {
        this.month = new SimpleStringProperty(month);
        this.entry_time = entry_time;
        this.exit_time = exit_time;
    }

    public String getMonth() {
        return month.get();
    }

    public void setMonth(String month) {
        this.month = new SimpleStringProperty(month);
    }

    public Timestamp getEntry_time() {
        return entry_time;
    }

    public void setEntry_time(Timestamp entry_time) {
        this.entry_time = entry_time;
    }

    public Timestamp getExit_time() {
        return exit_time;
    }

    public void setExit_time(Timestamp exit_time) {
        this.exit_time = exit_time;
    }
    
    
    
}
