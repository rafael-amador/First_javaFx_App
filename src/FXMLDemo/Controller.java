package FXMLDemo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller{

    @FXML
    Button button;

    @FXML //Must specify if method or variable came from the fxml file
    public void handleButtonClick(){
        System.out.println("Running code...");
        button.setText("Stop Pressing me");
    }
}