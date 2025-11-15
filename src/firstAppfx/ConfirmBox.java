package firstAppfx;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;


public class ConfirmBox {

    static boolean answer;
    

    public static boolean display(String title, String message){ //add functionality to make user deal with this window before going back to other window
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL); //used along side with showAndWait
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label(message);

        Button yesButton = new Button("Yes");
        Button noButton= new Button("No");

        yesButton.setOnAction(e -> {
            answer = true;
            window.close();
        });
        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });

        
        HBox layout = new HBox(10);
        layout.getChildren().addAll(yesButton, noButton);
        layout.setAlignment(Pos.CENTER);

        VBox layout1 = new VBox();
        layout1.getChildren().addAll(label, layout);
        layout1.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout1, 300, 100);
        window.setScene(scene);

        window.showAndWait(); //used alongside with initModality

        return answer;
    }
}
