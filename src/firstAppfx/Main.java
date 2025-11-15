package firstAppfx;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
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

        

        // NEW grid layout -----------------------------------------------
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        //----------------------------------------------------------------


        Button closeButton = new Button("Close Program");
        closeButton.setOnAction(e -> closeProgram());
        GridPane.setConstraints(closeButton, 2, 0);

        Label label1 = new Label("Username: ");
        GridPane.setConstraints(label1, 0, 0);

        Label label2 = new Label("Password: ");
        GridPane.setConstraints(label2, 0, 1);

        TextField nameInput = new TextField("Bob"); //actual text pre put in 
        nameInput.setPromptText("im watching you"); //grayed out text
        GridPane.setConstraints(nameInput, 1, 0); //position of element in grid compared to other elements

        TextField passInput = new TextField();
        passInput.setPromptText("type in here"); 
        GridPane.setConstraints(passInput, 1, 1); 

        grid.getChildren().addAll(closeButton, label1, label2, nameInput, passInput);


        Scene scene = new Scene(grid, 500, 400);
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
