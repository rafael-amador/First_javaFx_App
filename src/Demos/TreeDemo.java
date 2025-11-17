package Demos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TreeView;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.StackPane;


public class TreeDemo extends Application{    

    Stage window;
    TreeView<String> tree;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Tree Demo");
        
        //tree
        TreeItem<String> root, bucky, megan;
        //root
        root = new TreeItem<>();
        //Bucky
        bucky = makeBranch("Bucky", root);
        makeBranch("Knife", bucky);
        makeBranch("Mask", bucky);

        //Megan
        megan = makeBranch("Megan", root);
        makeBranch("Dolls", megan);
        makeBranch("Dance", megan);

        tree = new TreeView<>(root);
        tree.setShowRoot(false); //hides root
        tree.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            if(newValue != null){
                System.out.println(newValue.getValue());
            }
        });

        //Layout
        StackPane layout = new StackPane();
        layout.getChildren().add(tree);
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }
    //create branches
    public TreeItem<String> makeBranch(String name, TreeItem<String> parent){
        TreeItem<String> item = new TreeItem<>(name);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }
}
