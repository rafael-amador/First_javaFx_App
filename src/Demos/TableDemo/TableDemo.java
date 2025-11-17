package Demos.TableDemo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;



public class TableDemo extends Application {

    Stage window;
    TableView<Product> table;
    TextField nameInput, priceInput, quantityInput;
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Table Demo");

        //Name column
        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Price column
        TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        //Quantity column
        TableColumn<Product, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        //Name input
        nameInput = new TextField();
        nameInput.setPromptText("Name");

        //Price input
        priceInput = new TextField();
        priceInput.setPromptText("Price");

        //Quantity input
        quantityInput = new TextField();
        quantityInput.setPromptText("Quantity");

        //Button
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addProduct());
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButton());


        //HBox
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10, 10, 10, 10));
        hbox.setSpacing(10);
        hbox.getChildren().addAll(nameInput, priceInput, quantityInput, addButton, deleteButton);

        table = new TableView<>();
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table.setItems(getProduct());
        table.getColumns().add(nameColumn);
        table.getColumns().add(priceColumn);
        table.getColumns().add(quantityColumn);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(table, hbox);

        Scene scene = new Scene(vbox);
        window.setScene(scene);
        window.show();
    } 
    public ObservableList<Product> getProduct(){
        ObservableList<Product> productList = FXCollections.observableArrayList();
        productList.add(new Product("Laptop", 1149.99, 10));
        productList.add(new Product("Phone", 649.99, 5));
        productList.add(new Product("Head Phones", 110.00, 13));
        productList.add(new Product("Mouse", 45.50, 12)); 
        productList.add(new Product("Microphone", 45.50, 6)); 
        productList.add(new Product("TV", 1830.50, 5)); 
        return productList;
    }
    public void addProduct() {

    boolean error = false;

    // Name validation
    if (nameInput.getText().trim().isEmpty()) {
        nameInput.setStyle("-fx-border-color: red; -fx-border-width: 0 0 2 0;");
        error = true;
    } else {
        nameInput.setStyle("");
    }

    // Price validation
    if (priceInput.getText().trim().isEmpty()) {
        priceInput.setStyle("-fx-border-color: red; -fx-border-width: 0 0 2 0;");
        error = true;
    } else {
        priceInput.setStyle("");
    }

    // Quantity validation
    if (quantityInput.getText().trim().isEmpty()) {
        quantityInput.setStyle("-fx-border-color: red; -fx-border-width: 0 0 2 0;");
        error = true;
    } else {
        quantityInput.setStyle("");
    }

    if (error) {
        return;  // stop here if any input was empty
    }

    // If we reached here, inputs are valid
    Product product = new Product(
            nameInput.getText(),
            Double.parseDouble(priceInput.getText()),
            Integer.parseInt(quantityInput.getText())
    );

    table.getItems().add(product);

    nameInput.clear();
    priceInput.clear();
    quantityInput.clear();
}

    public void deleteButton(){
        table.getItems().removeAll(table.getSelectionModel().getSelectedItems());
        /*
        ObservableList<Product> productsToRemove, allProducts;
        allProducts = table.getItems();
        productsToRemove = table.getSelectionModel().getSelectedItems();

        productsToRemove.forEach(allProducts :: remove);
        */
    }
}
