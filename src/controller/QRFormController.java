package controller;

import com.google.zxing.WriterException;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import qr.QRGenerator;

import java.io.File;
import java.io.IOException;
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
    void btnGenerateOnAction(ActionEvent event) {
        if (!txtText.getText().isEmpty()) {
            QRGenerator qrGenerator = new QRGenerator();
            qrGenerator.setData(txtText.getText());
            try {
                qrGenerator.getGenerator();
            } catch (IOException | WriterException e) {
                new Alert(Alert.AlertType.ERROR, String.valueOf(e)).show();
            }
            File file = new File(qrGenerator.getPath());
            Image image = new Image(file.toURI().toString());
            pic.setImage(image);
        } else {
            new Alert(Alert.AlertType.ERROR, "Input Data First! ").show();
        }
    }

    @FXML
    void txtTextOnAction(ActionEvent event) {
        btnGenerateOnAction(event);
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtText.clear();
        btnController(true);
        pic.setImage(new Image(new File("src/assets/QR-Code-Background.jpg").toURI().toString()));
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
