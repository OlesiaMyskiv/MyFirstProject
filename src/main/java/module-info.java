module com.example.myfirstproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media; // Для використання Media, MediaPlayer, MediaView


    opens com.example.myfirstproject to javafx.fxml;
    exports com.example.myfirstproject;
}