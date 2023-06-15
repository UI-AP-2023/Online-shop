package com.example.phase2.UI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SignedUpSuccessfully {
    public static void display(String title, String message) {

        Stage window = new Stage();
        window.setTitle(title);
        window.setMinWidth(250);
        window.initModality(Modality.APPLICATION_MODAL);

        //scene sazi
        Label label = new Label(message);
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);

        Button yesButton = new Button("Ok");
        yesButton.setOnAction(e -> {

            window.close();
        });


        Scene scene = new Scene(layout);

        layout.getChildren().addAll(label, yesButton);

        window.setScene(scene);
        window.show();
    }
}