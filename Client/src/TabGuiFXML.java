import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;

public class TabGuiFXML extends Application
{

  public void start(Stage window) throws IOException
  {

    window.setTitle("TabGui");
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("TabGui.fxml"));
    Scene scene = new Scene(loader.load());
    window.setScene(scene);
    window.show();

  }


}
