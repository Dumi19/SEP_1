import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class controller
{
  @FXML private Button edit;
  @FXML private Button schedule;


  public void handleClickMe(ActionEvent e)
  {
    if (e.getSource() == button1)
    {
      text.setText("Hello");
    }
  }
}
