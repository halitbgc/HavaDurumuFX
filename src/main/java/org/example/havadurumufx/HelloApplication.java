package org.example.havadurumufx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        stage.getIcons().add(new Image(getClass().getResourceAsStream("az_bulutlu.png")));

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hava Durumu");
        stage.setScene(scene);
        stage.setResizable(false); // pencere boyutu ayarlanamaz
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}