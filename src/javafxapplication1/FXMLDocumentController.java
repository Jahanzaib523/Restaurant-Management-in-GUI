/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author faizx
 */
public class FXMLDocumentController implements Initializable {

    public static int id = 17;
    public static Timestamp loginSession;
    public static String nameUs ="dummy";
    @FXML
    private Button LloginButton, LgloginButton;

    @FXML
    private TextField LidTextfeild, LnameTextfeild;

    @FXML
    private PasswordField LpassPasswordfeild;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == LloginButton) {
            try {
                BringupLogin(decider(LidTextfeild.getText()));
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (event.getSource() == LgloginButton) {
            BringupLogin("viewG.fxml");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        loginSession = new Timestamp(now.getTime());
        nameUs=LnameTextfeild.getText();
        
    }

    private void BringupLogin(String myfxml) {
        Stage stage = (Stage) LloginButton.getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(myfxml));
            stage.hide();
            stage.setScene(new Scene((Pane) loader.load()));
            if (myfxml.equals("viewC.fxml")){
            ViewCController controller = (ViewCController) loader.getController();
            }
            else 
                if(myfxml.equals("FXMLDocument.fxml")){
                    FXMLDocumentController controller = (FXMLDocumentController) loader.getController();
                }
            else
                if(myfxml.equals("viewG.fxml")){
                try {
                    addGuest(nameUs);
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
                    ViewGController controller = (ViewGController) loader.getController();
                }
            else
                if(myfxml.equals("viewE.fxml")){
                    ViewEController controller = (ViewEController) loader.getController();
                }
            else
                if(myfxml.equals("viewM.fxml")){
                    ViewMController controller = (ViewMController) loader.getController();
                }
            stage.show();
        } catch (IOException ex) {
            System.err.println(" 1: " + ex);
        }
    }
    
    private String decider(String uid) throws SQLException{
        String retval;
        ObservableList<registeredU> users = FXCollections.observableArrayList();
        ObservableList<registeredU> emps=FXCollections.observableArrayList();
        
            
        
        try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection con=DriverManager.getConnection(
                        "jdbc:oracle:thin:@Zack-v049tx:1521:faiz","restaurant","re");
            Statement stmtcon=con.createStatement();
            String query;
            query = "Select * from registered";
            ResultSet rs=stmtcon.executeQuery(query);
            while(rs.next()){
                users.add(new registeredU(rs.getInt(1) , rs.getString(2),rs.getString(3),rs.getString(4)));
                //rs.deleteRow();
//System.out.println(rs.getString(1));
            }
            
            query = "Select * from employees";
            ResultSet rs1=stmtcon.executeQuery(query);
            while(rs.next()){
                emps.add(new registeredU(rs1.getInt(1) ,"",rs1.getString(3),""));
                //System.out.println(rs.getString(1));
            }
            
            StringProperty st=new SimpleStringProperty("FXMLDocument.fxml");
            StringProperty st1=new SimpleStringProperty("");
            StringProperty st2=new SimpleStringProperty("");
            int x=Integer.parseInt(uid);
            id=x;
            users.forEach((use)->{
                if (x==use.getU_id()){
                    st.set("viewC.fxml");
                }
            });
            if (st.getValue().equals("viewC.fxml")){
                    emps.forEach((emp)->{
                        System.out.println(emp.getU_id());
                        if(x==emp.getU_id()){
                            
                            if ("waiter".equals(emp.getContact())){
                                st1.set("ViewE.fxml");
                            }else{
                                st2.set("viewM.fxml");
                            }
                        }
                });
                }
            if (""!=st1.getValue()){
                retval=st1.getValue();
            }else
                if(""!=st2.getValue()){
                    retval=st2.getValue();
                }
                else{
                    retval=st.getValue();
                }
            rs.close();
            rs1.close();
        return retval;
    }
    private void addGuest(String g) throws SQLException, ClassNotFoundException{
        
        try{
                    Class.forName("oracle.jdbc.driver.OracleDriver");
          
                Connection con=DriverManager.getConnection(
                        "jdbc:oracle:thin:@Zack-v049tx:1521:faiz","restaurant","re");
                Statement stmtcon=con.createStatement();
                String query;
                query = "Insert into person values(SQ_PERSON.nextval,'"+g+"')";
                ResultSet rs=stmtcon.executeQuery(query);
                rs.close();
        }
        catch(Exception ex){
        
        }
        try{    Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection(
                    "jdbc:oracle:thin:@Zack-v049tx:1521:faiz","restaurant","re");
            Statement stmtcon=con.createStatement();
            String query;
            query = "Insert into guests values(SQ_PERSON.currval)";
            ResultSet rs=stmtcon.executeQuery(query);
            rs.close();
        }catch(Exception ex1){
        
        }
    }

}
