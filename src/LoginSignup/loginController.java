package LoginSignup;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import java.io.IOException;

public class loginController {

    public static final int MAX_USERNAME_LENGTH = 20;

    @FXML private TextField usernameTextField;
    @FXML private PasswordField passwordTextField;

    @FXML
    private void initialize() {
        System.out.println("FXML loaded, controller is ready!");

        usernameTextField.setOnAction(e -> login(e));
        passwordTextField.setOnAction(e -> login(e));
    }
    
    public void login(ActionEvent e){
        try{
        if (inputIsValid()){
            Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            SceneSwitcher.switchTo(stage, "mainPage.fxml");
        }
        }
        catch(IOException error){
            System.out.println("error: " + error.getMessage());
        }
    }

   
    public void switchToSignUp(ActionEvent e) throws IOException{
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        SceneSwitcher.switchTo(stage, "signup.fxml");
    }

    //helper methods 

    public boolean inputIsValid(){
        boolean valid = true;

        
        if (isEmpty(usernameTextField) || !isSmaller(usernameTextField)) {
            showError(usernameTextField);
            valid = false;
        } else {
            clearError(usernameTextField);
        }

        if (isEmpty(passwordTextField)) {
            showError(passwordTextField);
            valid = false;
        } else {
            clearError(passwordTextField);
        }

        return valid;
    }

    public boolean isEmpty(TextField text){
        return text.getText().trim().isEmpty();
    }

    private void showError(TextField field) {
        if (!field.getStyleClass().contains("error-underline")) {
            field.getStyleClass().add("error-underline");
        }
    }

    private void clearError(TextField field) {
        field.getStyleClass().remove("error-underline");
    }

    private boolean isSmaller(TextField field){
        return (field.getText().length() <= MAX_USERNAME_LENGTH);
    }
}