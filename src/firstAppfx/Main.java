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

public class Main extends Application{
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
        //------------------------------
        // Anonymous Inner Classes     |
        //------------------------------
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                System.out.println("Button 2 pressed");
            }
        });
        //------------------------------
        // Lambda Expression (Shortcut)|
        //------------------------------
        button2.setOnAction(e -> System.out.println("Button 1 pressed"));

        VBox layout = new VBox();
        layout.getChildren().addAll(button1, button2);

        Scene scene = new Scene(layout, 500, 250);
        stage.setScene(scene);
        stage.show();
    }
    //Parent root = FXMLLoader.load(getClass().getResource("firstAppfx.fxml"));
    //stage.setScene(new Scene(root, 600, 400));
    //stage.show();

}
