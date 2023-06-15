package com.example.phase2.UI;

import com.example.fase2.exceptions.InvalidLoginException;
import com.example.fase2.exceptions.ThisIsCustomer;
import com.example.phase2.controller.LoginPageController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class GraphicLoginPageController {

    @FXML
    private Button LoginButton;

    @FXML
    private Button SignupButton;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private TextField UserNameField;


    @FXML
    private Label invalidParameter;
    @FXML
    void OnLoginButtonClick(MouseEvent event) throws IOException {

        String username = UserNameField.getText();
        String password = PasswordField.getText();

        try {

            LoginPageController.loginCheck(username,password);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.close();

        } catch (InvalidLoginException e){

            invalidParameter.setText("Invalid username or password!");
        }
//        catch (ThisIsCustomer e) {
//
//            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main-menu.fxml")));
//            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            Scene scene = new Scene(parent);
//            window.setScene(scene);
//            window.show();
//        }
    }

    @FXML
    void OnSignupClick(MouseEvent event) throws IOException {

        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("signup-view.fxml")));
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        window.setScene(scene);
        window.show();
    }
}
