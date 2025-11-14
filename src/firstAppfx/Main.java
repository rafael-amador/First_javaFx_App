package firstAppfx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class Main extends Application implements EventHandler<ActionEvent> {
    Button button;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("First_App");
        button = new Button("Click me");
        button.setOnAction(this);

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 500, 250);
        stage.setScene(scene);
        stage.show();
    }

    @Override //needed from the implement EventHandler
    public void handle(ActionEvent event){
        if(event.getSource() == button){
            System.out.println("Button was clicked");
        }
    }
    //Parent root = FXMLLoader.load(getClass().getResource("firstAppfx.fxml"));
    //stage.setScene(new Scene(root, 600, 400));
    //stage.show();

}
