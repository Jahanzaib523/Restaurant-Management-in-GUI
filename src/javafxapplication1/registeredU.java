/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author faizx
 */
public class registeredU {

    int u_id;
    SimpleStringProperty pass;
    SimpleStringProperty contact;
    SimpleStringProperty email;

    public registeredU(int u_id, String pass, String contact, String email) {
        this.u_id = u_id;
        this.pass = new SimpleStringProperty(pass);
        this.contact = new SimpleStringProperty(contact);
        this.email = new SimpleStringProperty(email);
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getPass() {
        return pass.getValue();
    }

    public void setPass(String pass) {
        this.pass = new SimpleStringProperty(pass);
    }

    public String getContact() {
        return contact.getValue();
    }

    public void setContact(String contact) {
        this.contact = new SimpleStringProperty(contact);
    }

    public String getEmail() {
        return email.getValue();
    }

    public void setEmail(String email) {
        this.email = new SimpleStringProperty(email);
    }

}
