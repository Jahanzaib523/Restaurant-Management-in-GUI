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

/**
 *
 * @author faizx
 */
public class ViewCController implements Initializable{
    
    @FXML
    private Button CostatButton;
    
        @FXML
    private Button CmorderButton,CeorderButton,CfeedbackButton;
    @FXML
    private TabPane CfeedbackTPane;
    @FXML
    private TabPane CmorderTPane,CorderTPane;
    @FXML
    private Tab CfeedbackTab;
    @FXML
    private Tab CreviewTab,CostatTab,CeorderTab;
    @FXML
    private Tab CmorderTab;
    
    @FXML
    private void handleButtonAction(ActionEvent event){
        if (event.getSource()== CostatButton){
            CorderTPane.toFront();
            CorderTPane.getSelectionModel().select(CostatTab);
        }
        else
            if (event.getSource()==CmorderButton){
                CmorderTPane.toFront();
            }
        else
            if (event.getSource()==CeorderButton){
                CorderTPane.toFront();
                CorderTPane.getSelectionModel().select(CeorderTab);
            }
        else
            if (event.getSource()==CfeedbackButton){
                CfeedbackTPane.toFront();
                CfeedbackTPane.getSelectionModel().select(CfeedbackTab);
            }
        else
            if (event.getSource()==CreviewTab){
                CfeedbackTPane.getSelectionModel().select(CreviewTab);
            }
        
//end function
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }
}
