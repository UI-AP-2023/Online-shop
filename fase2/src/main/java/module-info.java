module com.example.fase2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.phase2 to javafx.fxml;
    exports com.example.phase2;
    exports com.example.phase2.exceptions;
    opens com.example.phase2.exceptions to javafx.fxml;
    exports com.example.phase2.UI;
    opens com.example.phase2.UI to javafx.fxml;
    exports com.example.phase2.view.BuyerView;
    opens com.example.phase2.view.BuyerView to javafx.fxml;
}