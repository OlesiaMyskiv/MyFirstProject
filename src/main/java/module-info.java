module com.example.myfirstproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.myfirstproject to javafx.fxml;
    exports com.example.myfirstproject;
}