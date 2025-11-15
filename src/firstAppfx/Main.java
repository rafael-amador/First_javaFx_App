package firstAppfx;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
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

    public static void main(String[] args) {
        launch(args);
    }
    Stage window;
    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Close Program App");

        window.setOnCloseRequest(e -> {
            e.consume(); //dont do the event (close the program withought our logic)
            closeProgram();
        });

        Button button1 = new Button("Close Program");

        button1.setOnAction(e -> closeProgram());



        StackPane layout = new StackPane();
        layout.getChildren().add(button1);
        layout.setAlignment(Pos.TOP_RIGHT);

        Scene scene = new Scene(layout, 500, 400);
        window.setScene(scene);
        window.show();
    }
    private void closeProgram(){
        boolean answer = ConfirmBox.display("Confirm Box", "Are you sure you want to close this program");
        if (answer){
            System.out.println("Program closed");
            window.close();
        }
        else{
            System.out.println("Close Cancelled");
        }
    }
}
