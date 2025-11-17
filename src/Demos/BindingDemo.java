package Demos;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;



public class BindingDemo extends Application{

    Stage window;

    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Binding Demo");

        TextField userInput = new TextField();
        userInput.setPromptText("Type here");
        userInput.setMaxWidth(200);
        Label bindedLabel = new Label();
        bindedLabel.textProperty().bind(userInput.textProperty());

        Label showWhenPressed = new Label();
        Button showWhenPressedButton = new Button("Press to Update label");
        showWhenPressedButton.setOnAction( e -> {
            showWhenPressed.setText(userInput.getText());
        });

        VBox layout = new VBox(10, userInput, bindedLabel, showWhenPressedButton, showWhenPressed);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene (layout, 500, 300);
        window.setScene(scene);
        window.show();
    }
}
