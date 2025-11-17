package Demos;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class GridDemo extends Application{

    Stage window;

    public static void main(String[] args){
        launch(args);
    }
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Into to CSS");

        GridPane gridLayout = new GridPane();
        gridLayout.setPadding(new Insets(10, 10, 10, 10));
        gridLayout.setVgap(10);
        gridLayout.setHgap(10);

        //name label
        Label nameLabel = new Label("Username: ");
        GridPane.setConstraints(nameLabel, 0, 0);

        //pass label
        Label passLabel = new Label("Password: ");
        GridPane.setConstraints(passLabel, 0, 1);

        //name input
        TextField nameInput = new TextField();
        nameInput.setPromptText("username");
        GridPane.setConstraints(nameInput, 1, 0);

        //pass input
        TextField passwordInput = new TextField();
        passwordInput.setPromptText("password");
        GridPane.setConstraints(passwordInput, 1, 1);

        //login button
        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton, 1, 2);

        //set layout
        gridLayout.getChildren().addAll(nameLabel, passLabel, nameInput, passwordInput, loginButton);
        Scene scene = new Scene(gridLayout, 300, 200);
        scene.getStylesheets().add(getClass().getResource("GridDemo.css").toExternalForm());
        window.setScene(scene);
        window.show();
    }
}
