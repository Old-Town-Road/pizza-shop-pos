package controllers;

/**
 * This class controls the service options view.
 *
 * @author Sultan Al Bogami Last Updated: 2/22/2020
 */

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderTypeController{
    @FXML
    private Button DineIn;
    @FXML
    private Button TakeOut;

    public OrderTypeController(){
    }

    /**
     * Called once implementing the controller.
     *
     * @param _url
     * @param _rb
     */
    public void initialize(URL _url, ResourceBundle _rb) {
    }
}
