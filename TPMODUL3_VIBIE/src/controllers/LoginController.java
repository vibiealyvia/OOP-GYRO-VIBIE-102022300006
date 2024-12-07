package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private PasswordField textFieldPassword;

    @FXML
    private TextField textFieldUsername;

    @FXML
    void LoginFunction(ActionEvent event) throws IOException {
        String username = textFieldUsername.getText();
        String password = textFieldPassword.getText();

        Parent inventoryScreenParent = FXMLLoader.load(getClass().getResource("/screens/InventoryScreen.fxml"));
        Scene inventoryScreenScene = new Scene(inventoryScreenParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        if (username.equals("jawirgaming05") && password.equals("1234")) {
            stage.setScene(inventoryScreenScene);
            stage.show();
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Salah Username atau Password");
            alert.setContentText("Silahkan cek kembali Username atau Password anda");
            alert.showAndWait();
        }
    }
}
