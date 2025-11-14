package firstAppfx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class Main extends Application{
    
    Scene scene1, scene2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) throws Exception{
        Label label1 = new Label("Welcome to the 1st scene");
        Label label2 = new Label("Welcome to the 2nd scene");
        Button button1 = new Button("Go to scene 2");
        Button button2 = new Button("Go to scene 1");
        button1.setOnAction(e -> window.setScene(scene2));
        button2.setOnAction(e -> window.setScene(scene1));

        //Layout 1 - Vertical Column
        VBox layout1 = new VBox();
        layout1.getChildren().addAll(label1, button1);
        scene1 = new Scene(layout1, 500, 500);

        //Layout 2 
        VBox layout2 = new VBox();
        layout2.getChildren().addAll(label2, button2);
        scene2 = new Scene(layout2, 800, 300);

        window.setScene(scene1);
        window.setTitle("App");
        window.show();
    }
    //Parent root = FXMLLoader.load(getClass().getResource("firstAppfx.fxml"));
    //stage.setScene(new Scene(root, 600, 400));
    //stage.show();

}
