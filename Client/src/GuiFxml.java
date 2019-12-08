import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GuiFxml extends Application
{
  public void start(Stage window) throws IOException
  {
    window.setTitle("A Simple Window 3");
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("GuiSEP.fxml"));
    Scene scene = new Scene(loader.load());
    window.setScene(scene);
    window.show();
  }
}