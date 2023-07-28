package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class QRFormController implements Initializable {
    @FXML
    private ImageView pic;

    @FXML
    private TextField txtText;

    @FXML
    private JFXButton btnGenerate;

    @FXML
    private JFXButton btnClear;


    @FXML
    void txtTextOnAction(ActionEvent event) {

    }

    @FXML
    void btnGenerateOnAction(ActionEvent event) {

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {

    }

    @FXML
    void txtTextonKeyReleased(KeyEvent event) {
        if (!txtText.getText().isEmpty()) {
            btnController(false);
        } else {
            btnController(true);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnController(true);
    }

    void btnController(boolean value) {
        btnGenerate.setDisable(value);
        btnClear.setDisable(value);
    }
}
