package LoginSignup;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class SceneSwitcher {
    public static void switchTo(Stage stage, String fxml) throws IOException {
        Parent root = FXMLLoader.load(SceneSwitcher.class.getResource(fxml));
        stage.getScene().setRoot(root);
    }
}
