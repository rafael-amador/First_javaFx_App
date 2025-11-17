package SceneBuilderDemo;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;


public class Controller implements Initializable{

    public void loginButton(){
        System.out.println("User clicked button");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) { //program calls this method on startup
        System.out.println("Loading up user data... "); 
    }
}