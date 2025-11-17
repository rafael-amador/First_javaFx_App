package Demos.PropertiesDemo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;

public class PropertiesDemo extends Application{

    Stage window;

    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Properties Demo");

        Person person = new Person();

        person.firstNameProperty().addListener( (v, oldValue, newValue)  -> {
            System.out.println("Name changed to " + newValue);
            System.out.println("firstNameProperty(): " + person.firstNameProperty());
            System.out.println("getFirstName(): " + person.getFirstName());
        });

        Button button = new Button("Submit");
        button.setOnAction(e -> person.setFirstName("Bob"));

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 400, 300);
        window.setScene(scene);
        window.show();
    }
}
