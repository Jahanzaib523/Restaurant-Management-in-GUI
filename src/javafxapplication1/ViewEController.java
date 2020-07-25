/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

//import order
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class ViewEController implements Initializable {

    @FXML
    private Button EattendanceButton;
    @FXML
    private Button EvInventoryButton;
    @FXML
    private Button EhOrderButton;
    @FXML
    private TabPane EinventoryTPane;
    @FXML
    private Tab EinventoryTab;
    @FXML
    private TabPane EorderTPane;
    @FXML
    private Tab EorderTab;
    //private AnchorPane EorderAnchorPane;
    @FXML
    private TextField EorderTextfeild;
    @FXML
    private TableView<OrderHandle> EordersTabelview;
    @FXML
    private TableColumn<OrderHandle, String> EoidTablecol;
    @FXML
    private TableColumn<OrderHandle, Timestamp> EotTablecol;
    @FXML
    private TabPane EAttendanceTPane;
//    @FXML
//    private Tab EvAttendanceTab;
    @FXML
    private Tab EmAttendanceTab;
    @FXML
    private TextArea EiconsoleTextarea;
    @FXML
    private AnchorPane EinventoryAnchor;
//    @FXML
//    private AnchorPane EvAttendanceAnchor;
    @FXML
    private AnchorPane EorderAnchor;
    @FXML
    private AnchorPane EmAttendanceAnchor;
    @FXML
    private TextField EentertTextfeild;
    @FXML
    private TextField EexittTextfeild;
    @FXML
    private Button EentertButton;
    @FXML
    private Button EexittButton;
    @FXML
    private Tab EvAttendanceTab;
    @FXML
    private AnchorPane EvAttendanceAnchor;
    @FXML
    private TableView<?> EvAttendanceTable;
    @FXML
    private TableColumn<?, ?> EmonthaCol;
    @FXML
    private TableColumn<?, ?> EentertaColumn;
    @FXML
    private TableColumn<?, ?> EexittaColumn;

    /**
     * Initializes the controller class.
     */
   
    @FXML
    private void handleButtonAction(Event event){
        if (event.getSource() == EattendanceButton){
            hidetabAnchorAll();
            EAttendanceTPane.toFront();
            EAttendanceTPane.getSelectionModel().select(EmAttendanceTab);
            EmAttendanceAnchor.setVisible(true);
            
        }
        else
            if (event.getSource() == EhOrderButton){
                hidetabAnchorAll();
                EorderTPane.toFront();
                EorderAnchor.setVisible(true);
            }
       else
            if (event.getSource() == EvInventoryButton){
                hidetabAnchorAll();
                EinventoryTPane.toFront();
            }
        else
            if (event.getSource() == EvAttendanceTab){
                EvAttendanceAnchor.setVisible(true);
            }
    }
    
//    @FXML
//    private void handleButtonAction(Event event) {
//    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            hidetabAnchorAll();
        //Order table
            EoidTablecol.setCellValueFactory(new PropertyValueFactory<>("orderid"));
           // EotTablecol.setCellValueFactory(new PropertyValueFactory<>("ordertime"));
            
            EordersTabelview.setItems(getOrders());
        } catch (SQLException ex) {
            Logger.getLogger(ViewEController.class.getName()).log(Level.SEVERE, null, ex);
        }
//        try {
//            // order end here
////            getAttendance("sdg");
//            //Attendance table
//        } catch (SQLException ex) {
//            Logger.getLogger(ViewEController.class.getName()).log(Level.SEVERE, null, ex);
//        }
            
    }    
// Table getters
    public ObservableList<OrderHandle> getOrders() throws SQLException{
        ObservableList<OrderHandle> orders = FXCollections.observableArrayList();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection(
                        "jdbc:oracle:thin:@Zack-v049tx:1521:faiz","restaurant","re");
            Statement stmtcon=con.createStatement();
            ResultSet rs=stmtcon.executeQuery("Select order_id,order_time from orders where status = 'processing'");
            while(rs.next()){
                orders.add(new OrderHandle(rs.getString(1) , rs.getTimestamp(2)));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewEController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return orders;
    }
    
    public ObservableList<AttendanceHandle> getAttendance(String e_id) throws SQLException{
        ObservableList<AttendanceHandle> attendance = FXCollections.observableArrayList();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection(
                        "jdbc:oracle:thin:@Zack-v049tx:1521:faiz","restaurant","re");
            Statement stmtcon=con.createStatement();
            String query;
            query = "Select to_char(entry_time,'Month'),to_char(entry_time,'HH24:MI:SS'),to_char(exit_time,'HH24:MI:SS') from attendance where employee_id="+e_id;
            ResultSet rs=stmtcon.executeQuery("Select month,entry,exit from attendanceemp where employee_id=15");
            while(rs.next()){
                attendance.add(new AttendanceHandle(rs.getString(1) , rs.getTimestamp(2),rs.getTimestamp(3)));
                System.out.println(rs.getString(1));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewEController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return attendance;
    }
    // Table getters enders
    
    //
    private void hidetabAnchorAll(){
        EinventoryAnchor.setVisible(false);
        EmAttendanceAnchor.setVisible(false);
        EorderAnchor.setVisible(false);
        EvAttendanceAnchor.setVisible(false);
    } 
    
}
