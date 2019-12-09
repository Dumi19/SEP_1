import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class controller
{
  @FXML private Button edit;
  @FXML private Button schedule;
  private Button next_Scene;
  private ComboBox comboBox;
  private Scene sceneViewScene;

  public void handleClickMe(ActionEvent e)
  {
    if (e.getSource() == edit)
    {
      schedule.setText("Hello");
    }
  }

  public void initialize()
  {
    comboBox.getItems().removeAll(comboBox.getItems());
    comboBox.getItems()
        .addAll("SDJ1", "SSE", "RWD1", "MSE", "SEP1", "SDJ2", "DBS1", "SWE1",
            "SEP2");
    comboBox.getSelectionModel().select("COURSES");
  }

  public void setNext_Scene(ActionEvent event) throws IOException
  {
    Parent sceneViewParent = FXMLLoader
        .load(getClass().getResource("GuiSEP_2.fxml"));

    sceneViewScene = new Scene(sceneViewParent);

    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

    window.setScene(sceneViewScene);
    window.show();
  }
}
