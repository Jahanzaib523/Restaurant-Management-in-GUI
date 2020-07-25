/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
//import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author faizx
 */
public class ViewGController implements Initializable {

    /**
     * Initializes the controller class.
     */

    @FXML
    private TabPane GregisterTPane,GorderTPane,GmorderTPane; 
    @FXML
    private Tab GostatTab, GeorderTab;
    @FXML
    private Button GostatButton,GmorderButton,GeorderButton,GregisterButton;
    @FXML
    private Tab GmorderTab;
    @FXML
    private Tab GregisterTab;
    @FXML
    private Text Gname;
    @FXML
    private Text GdateText;
    @FXML
    private Button GdeorderButton;
    @FXML
    private TextField GeditTextfeild;
    
    @FXML
    private void handleButtonAction(Event event){
        if (event.getSource()== GmorderButton){
           GmorderTPane.toFront();
           
        }
        else
            if (event.getSource()==GeorderButton){
                GorderTPane.toFront();
                GorderTPane.getSelectionModel().select(GeorderTab);
            }
        else
            if (event.getSource()==GregisterButton){
                GregisterTPane.toFront();
            }
        else
            if (event.getSource()==GostatButton){
                GorderTPane.toFront();
                GorderTPane.getSelectionModel().select(GostatTab);
            }
        else 
            if (event.getSource()==GdeorderButton){
                deleteorder(GeditTextfeild.getText());
            }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        //System.out.println(FXMLDocumentController.nameUs);
        Gname.setText(FXMLDocumentController.nameUs);
        GdateText.setText(FXMLDocumentController.loginSession.toString());
    }    

    private void deleteorder(String orderid) {
        try{    Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection(
                    "jdbc:oracle:thin:@Zack-v049tx:1521:faiz","restaurant","re");
            Statement stmtcon=con.createStatement();
            String query;
            query = "Delete from CUSTOMERORDERS where order_id="+orderid;
            ResultSet rs=stmtcon.executeQuery(query);
            query="Delete from orders where order_id="+orderid;
            rs=stmtcon.executeQuery(query);
            rs.close();
        }catch(Exception ex){
        
        }
    }
    
}
