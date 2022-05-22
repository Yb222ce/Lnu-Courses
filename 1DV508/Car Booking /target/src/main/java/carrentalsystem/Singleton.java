package org.code.carrentalsystem;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import org.code.carrentalsystem.database.Database;
import org.code.carrentalsystem.model.User;

import java.io.IOException;

public class Singleton {


    public Database database = new Database();

    public User active_user;

    private static final Singleton singleton = new Singleton();

    private Singleton(){

    }

    public static Singleton getInstance(){
        return singleton;
    }

    public FXMLLoader fxmlLoader(String _file){
        FXMLLoader loader = new FXMLLoader(getClass().getResource(_file));
        try{
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loader;
    }

    public MenuItem getMenuItem(String str, EventHandler<ActionEvent> event){
        MenuItem item = new MenuItem();
        item.setText(str);
        item.setOnAction(event);
        return item;
    }

    public boolean validate_textField(TextField... fields){
        boolean cond = false;
        for (TextField field : fields) {
            if(field.getText().isEmpty()){
                field.setStyle("-fx-border-color: red;");
                cond = true;
            }else{
                field.setStyle("");
            }
        }
        return cond;
    }
    public boolean validate_passField(PasswordField... fields){
        boolean cond = false;
        for (PasswordField field : fields) {
            if(field.getText().isEmpty()){
                field.setStyle("-fx-border-color: red;");
                cond = true;
            }else{
                field.setStyle("-fx-border-color: grey;");
            }
        }
        return cond;
    }
    public boolean validate_areaField(TextArea... fields){
        boolean cond = false;
        for (TextArea field : fields) {
            if(field.getText().isEmpty()){
                field.setStyle("-fx-border-color: red;");
                cond = true;
            }else{
                field.setStyle("-fx-border-color: grey;");
            }
        }
        return cond;
    }

    public void dialog_box(String title, String header, String msg){
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle(title);
        dialog.setHeaderText(header);
        dialog.setContentText(msg);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        dialog.showAndWait();
    }

    public void numField(TextField field){
        field.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            public void handle( KeyEvent t ) {
                char ar[] = t.getCharacter().toCharArray();
                char ch = ar[t.getCharacter().toCharArray().length - 1];
                if (!(ch >= '0' && ch <= '9')) {
                    t.consume();
                }
            }
        });
    }
}
