package firstAppfx;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import java.util.InputMismatchException;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;


public class Main extends Application{    

    boolean isNewAcount;
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

        
        Label ageLabel = new Label("Age: ");
        GridPane.setConstraints(ageLabel, 0, 0);

        Label userNameLabel = new Label("Username: ");
        GridPane.setConstraints(userNameLabel, 0, 1);

        Label passLabel = new Label("Password: ");
        GridPane.setConstraints(passLabel, 0, 2);

        TextField ageInput = new TextField(); //actual text pre put in 
        ageInput.setPromptText("age"); //grayed out text
        GridPane.setConstraints(ageInput, 1, 0); //position of element in grid compared to other elements

        TextField nameInput = new TextField(); //actual text pre put in 
        nameInput.setPromptText("name"); //grayed out text
        GridPane.setConstraints(nameInput, 1, 1); //position of element in grid compared to other elements

        TextField passInput = new TextField();
        passInput.setPromptText("password"); 
        GridPane.setConstraints(passInput, 1, 2); 


        Button closeButton = new Button("Close Program");
        closeButton.setOnAction(e -> closeProgram());
        GridPane.setConstraints(closeButton, 1, 4);

        //CheckBox
        CheckBox checkBox = new CheckBox("New Acount?");
        GridPane.setConstraints(checkBox, 2, 3);

        //ChocieBox
        //getItems returns the ObservableList object which you can add items to
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("Option 1", "Option 2", "Option 3");
        choiceBox.setValue("Choices");
        GridPane.setConstraints(choiceBox, 3, 0);

        //listen for selection changes
        choiceBox.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> System.out.println(newValue));

        Button choiceButton = new Button("Select Choice");
        choiceButton.setOnAction(e -> {
            System.out.println(choiceBox.getValue());
        });
        GridPane.setConstraints(choiceButton, 3, 1);

        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton, 1, 3);
        loginButton.setOnAction(e -> {
            try{
                int age = Integer.parseInt(ageInput.getText());
                if (age > 100){
                    throw new NumberFormatException("Age is too large");
                }
                if (age < 1){
                    throw new NumberFormatException("Age is too small");
                }
                if (checkBox.isSelected()){
                    System.out.println("Creating Acount");
                    System.out.println("Age: " + age);
                    System.out.println("Username: " + nameInput.getText());
                    System.out.println("Password: " + passInput.getText());
                }
                else{
                    System.out.println("Verifying PassWord");
                    System.out.println("Age: " + age);
                    System.out.println("Username: " + nameInput.getText());
                    System.out.println("Password: " + passInput.getText());
                }
            }
            catch(NumberFormatException error){
                System.out.println("Error: " + error.getMessage());
            }
        });

        //Combo box, doesnt need the use of a listener to make actions on choice selected
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Apple", "Orange", "Banana", "Pear", "Pinnaple");
        comboBox.setPromptText("Choose fruit");
        comboBox.setEditable(true);
        comboBox.setOnAction(e -> System.out.println("User Selected " + comboBox.getValue()));
        GridPane.setConstraints(comboBox, 1, 5);
        //---------------------------------------------------------------------------------------
        //List View
        ListView<String> listView = new ListView<>();
        listView.getItems().addAll("List1", "List2", "List3", "List4");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        Button selectionButton = new Button("Print Selected");
        GridPane.setConstraints(selectionButton, 2, 6);
        selectionButton.setOnAction(e -> {
            String message = "";
            ObservableList<String> movies;
            movies = listView.getSelectionModel().getSelectedItems();

            for(String m : movies) {
                message += m + "\n";
            }
            System.out.println(message);
        });
        GridPane.setConstraints(listView, 1, 6);
        //---------------------------------------------------------------------------------------
        grid.getChildren().addAll(selectionButton, listView, comboBox, ageLabel, passLabel, userNameLabel, ageInput, nameInput, passInput, loginButton, checkBox, closeButton, choiceBox, choiceButton);


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
