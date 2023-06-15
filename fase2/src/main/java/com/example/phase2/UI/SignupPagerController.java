package com.example.phase2.UI;

import com.example.phase2.controller.BuyerController;
import com.example.phase2.controller.LoginPageController;
import com.example.phase2.exceptions.InUsedUserNameException;
import com.example.phase2.exceptions.InvalidEmailException;
import com.example.phase2.exceptions.InvalidPasswordException;
import com.example.phase2.exceptions.InvalidPhoneNumberException;
import com.example.phase2.model.ModelData;
import com.example.phase2.model.userAccount.Buyer;
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

public class SignupPagerController {

    @FXML
    private Button BackButton;

    @FXML
    private Button SubmitButton;

    @FXML
    private TextField emailfield;

    @FXML
    private Label label;

    @FXML
    private TextField numberfield;

    @FXML
    private PasswordField passwordfield;

    @FXML
    private TextField usernamefield;

    @FXML
    void OnBackButton(MouseEvent event) throws IOException {

        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        window.setScene(scene);
        window.show();
    }

    @FXML
    void OnSubmit(MouseEvent event) throws IOException {

        String username = usernamefield.getText();
        String email = emailfield.getText();
        String phone = numberfield.getText();
        String password = passwordfield.getText();

        try {

            BuyerController.checkUserName(username);
            LoginPageController.emailCheck(email);
            LoginPageController.passwordCheck(password);
            LoginPageController.phoneNumberCheck(phone);

            ModelData.addCustomer(new Buyer(username, password,phone,email));

            SignedUpSuccessfully.display("congratulations!","You signed up successfully!");

            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            window.setScene(scene);
            window.show();

        } catch (InvalidEmailException e){

            label.setText("This email is invalid!");
        }
        catch (InvalidPasswordException e){

            label.setText("This password is invalid!");
        }
        catch (InvalidPhoneNumberException e){

            label.setText("This phone number is invalid!");
        }
        catch (InUsedUserNameException e){

            label.setText("This username is invalid!");
        }
    }

}
