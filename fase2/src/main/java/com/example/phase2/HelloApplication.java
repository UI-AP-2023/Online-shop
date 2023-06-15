package com.example.phase2;

import com.example.phase2.UI.SignedUpSuccessfully;
import com.example.phase2.model.Discount.Discount;
import com.example.phase2.model.ModelData;
import com.example.phase2.model.product.digital_Product.PC;
import com.example.phase2.model.product.stationerySupplies.Pencil;
import com.example.phase2.model.product.stationerySupplies.PencilType;
import com.example.phase2.model.product.vehicle.Car;
import com.example.phase2.model.userAccount.Buyer;
import com.example.phase2.view.BuyerView.LoginPageView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class HelloApplication extends Application implements Initializable {

    public static Stage mainStage;

    @Override
    public void start(Stage stage) throws IOException {

        mainStage = stage;

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500,350);
        mainStage.setTitle("Hello!");
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void main(String[] args) {

        new PC(2, 16, "TUFGaming", 13, "Core_i5", 16, 1000);
        Car c  = new Car("BMW", 3000, true, "Z4", 1, 15000);
        Pencil p = new Pencil("Germany", PencilType.HB, "Faber Castle", 32, 2);

        ModelData.getDiscountCodes().add(new Discount(50,2,2,"AAAA"));

        Buyer b =new Buyer("m", "m", "1", "m");

        Arrays.sort(ModelData.getProducts().toArray());

        ModelData.addCustomer(b);

//        LoginPageView.showLoginPage();

        SignedUpSuccessfully.display("Hello","You are signed up");
//        launch();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}