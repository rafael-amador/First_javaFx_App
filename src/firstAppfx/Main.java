package firstAppfx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class Main extends Application implements EventHandler<ActionEvent> {
    Button button1;
    Button button2;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("First_App");
        button1 = new Button("Click me");
        button2 = new Button("Click me");
        button1.setOnAction(this);
        button2.setOnAction(this);

        VBox layout = new VBox();
        layout.getChildren().addAll(button1, button2);

        Scene scene = new Scene(layout, 500, 250);
        stage.setScene(scene);
        stage.show();
    }

    @Override //needed from the implement EventHandler
    public void handle(ActionEvent event){
        if(event.getSource() == button1){
            System.out.println("Button1 was clicked");
        }
        else if (event.getSource() == button2){
            System.out.println("Button2 was clicked");
        }
    }
    //Parent root = FXMLLoader.load(getClass().getResource("firstAppfx.fxml"));
    //stage.setScene(new Scene(root, 600, 400));
    //stage.show();

}
