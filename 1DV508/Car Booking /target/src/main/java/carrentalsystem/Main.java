package org.code.carrentalsystem;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(Singleton.getInstance().fxmlLoader("views/LoginPage.fxml").getRoot());
        stage.setTitle("Car Rental");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
