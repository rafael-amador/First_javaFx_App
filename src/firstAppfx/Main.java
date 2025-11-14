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
    
    Scene scene1;
    

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) throws Exception{
        Button button1 = new Button("Click me");
        Button button2 = new Button("yes or no");

        button1.setOnAction(e -> AlertBox.display("Alert Box", "Message I want displayed"));
        button2.setOnAction(e -> {
            boolean answer = ConfirmBox.display("Chocie Box", "Are you sure");
            System.out.println(answer);
        });

        VBox layout = new VBox();
        layout.getChildren().addAll(button1, button2);
        Scene scene1 = new Scene(layout, 300, 250);
        window.setTitle("App");
        window.setScene(scene1);
        window.show();
    }
}
