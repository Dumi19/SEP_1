import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;

public class GuiFxml extends Application
{
  public void start(Stage window) throws IOException
  {
    window.setTitle("Planner");
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("GuiSEP.fxml"));
    Scene scene = new Scene(loader.load());
    window.setScene(scene);
    window.show();

  }

}