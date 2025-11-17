package Demos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.MenuBar;

public class TopMenuDemo extends Application{

    Stage window;
    BorderPane layout;

    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Menu Demo");

        //File menu
        Menu fileMenu = new Menu("_File"); //underscore is used for shortcuts

        MenuItem newTextFile = new MenuItem("_New Text File");
        newTextFile.setOnAction(e -> System.out.println("New text file as been created..."));
        MenuItem newFile = new MenuItem("_New File...");
        newFile.setOnAction(e -> System.out.println("New file as been created..."));
        MenuItem newWindow = new MenuItem("_New Window");
        newWindow.setOnAction(e -> System.out.println("New window has been opened."));
        MenuItem newWindowProfile = new MenuItem("_New Window with Profile ");
        newWindowProfile.setOnAction(e -> System.out.println("New window with a set profile has been opened."));
        MenuItem openFile = new MenuItem("_Open File");
        openFile.setOnAction(e -> System.out.println("File has been opened."));

        Menu windowProfile = new Menu("_New Window with Profile ");
        windowProfile.getItems().add(newWindowProfile);


        fileMenu.getItems().add(newTextFile);
        fileMenu.getItems().add(newFile);
        fileMenu.getItems().add(newWindow);
        fileMenu.getItems().add(windowProfile);
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(openFile);
        
        //Edit menu
        Menu editMenu = new Menu("_Edit");
        editMenu.getItems().add(new MenuItem("Undo"));
        editMenu.getItems().add(new MenuItem("Redo"));
        editMenu.getItems().add(new SeparatorMenuItem());
        editMenu.getItems().add(new MenuItem("Cut"));
        editMenu.getItems().add(new MenuItem("Copy"));
        editMenu.getItems().add(new MenuItem("Paste"));

        //Help Menu check box style menu, can check as many as you want
        Menu helpMenu = new Menu("Help");
        CheckMenuItem autoSave = new CheckMenuItem("Toggle Auto-Save");
        autoSave.setOnAction(e -> {
            if (autoSave.isSelected()){
                System.out.println("AutoSave has been turned on");
            }
            else{
                System.out.println("AutoSave has been turned off");
            }
        });
        autoSave.setSelected(true); //sets value to true on program start
        helpMenu.getItems().add(autoSave);

        //Radio menuItem Only one can be check at one time
        Menu difficultyMenu = new Menu("Difficulty");
        ToggleGroup difficultyToggle = new ToggleGroup();
        RadioMenuItem easy = new RadioMenuItem("Easy");
        RadioMenuItem medium = new RadioMenuItem("Medium");
        RadioMenuItem hard = new RadioMenuItem("Hard");
        easy.setToggleGroup(difficultyToggle);
        medium.setToggleGroup(difficultyToggle);
        hard.setToggleGroup(difficultyToggle);


        difficultyMenu.getItems().addAll(easy, medium, hard);


        //Menu Bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu, difficultyMenu);

        //Layout
        layout = new BorderPane();
        layout.setTop(menuBar);

        Scene scene = new Scene(layout, 500, 500);
        window.setScene(scene);
        window.show();
    }
}
