package Controllers;

/**
 * This class controls Order Type view.
 *
 * @author Sultan Al Bogami Last Updated: 2/22/2020
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;
import views.SetView;
import views.Frame;
import java.net.URL;
import java.util.ResourceBundle;

public class OrderTypeController implements Initializable {

    public OrderTypeController() {
    }

    /**
     * Called once implementing the controller.
     *
     * @param _url
     * @param _rb
     */
    public void initialize(URL _url, ResourceBundle _rb) {
    }

    /**
     * Called when dine in button is clicked.
     *
     * @param _event
     */
    @FXML
    private void dineInAction(ActionEvent _event) {
        Stage stage = (Stage) ((Node) _event.getSource()).getScene().getWindow();
        stage.close();
        new Frame(new Stage(), SetView.LOG_IN_VIEW);
    }

    /**
     * Called when take out button is clicked.
     *
     * @param _event
     */
    @FXML
    private void takeOutAction(ActionEvent _event) {
        Stage stage = (Stage) ((Node) _event.getSource()).getScene().getWindow();
        stage.close();
        new Frame(new Stage(), SetView.LOG_IN_VIEW);
    }
}

