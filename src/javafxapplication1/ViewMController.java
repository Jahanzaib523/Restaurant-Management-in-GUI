/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author faizx
 */
public class ViewMController implements Initializable {

    @FXML
    private Button MattendanceButton,MhOrderButton,MvInventoryButton,McSalaryButton,MvSalesButton;
    @FXML
    private TabPane MreportTabpane;
    @FXML
    private Tab MsalesTab,MsalariesTab;
    @FXML
    private TabPane MinventoryTPane;
    @FXML
    private Tab MinventoryTab;
    @FXML
    private TabPane MorderTPane;
    @FXML
    private Tab MorderTab;
    @FXML
    private TabPane MAttendanceTPane;
    @FXML
    private Tab MvAttendanceTab;
    @FXML
    private Tab MmAttendanceTab;
    @FXML
    private TextArea MiconsoleTextarea;

    @FXML
    private void handleButtonAction(ActionEvent event){
        if (event.getSource() == MattendanceButton){
            MAttendanceTPane.toFront();
            MAttendanceTPane.getSelectionModel().select(MmAttendanceTab);
        }
        else
            if (event.getSource() == MhOrderButton){
                MorderTPane.toFront();
            }
       else
            if (event.getSource() == MvInventoryButton){
                MinventoryTPane.toFront();
            }
        else
            if (event.getSource() == McSalaryButton){
                MreportTabpane.toFront();
                MreportTabpane.getSelectionModel().select(MsalariesTab);
            }
        else
            if (event.getSource() == MvSalesButton){
                MreportTabpane.toFront();
                MreportTabpane.getSelectionModel().select(MsalesTab);
            }
        else
            if (event.getSource() == MvAttendanceTab){
                MAttendanceTPane.getSelectionModel().select(MvAttendanceTab);
            }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
