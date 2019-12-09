import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller2
{
  @FXML private ComboBox<String> courseBox;
  @FXML private ComboBox<String> studentsBox;
  @FXML private ComboBox<String> examinerBox;
  @FXML private ComboBox<String> classroomBox;
  @FXML private Button submit;
  @FXML private Button export;
  @FXML private DatePicker datePicker;
  @FXML private Alert alert;
  @FXML private ListView<Student> StudentList;
  @FXML private ListView<Teacher> TeachersList;
  @FXML private ListView<Course> CourseList;
  @FXML private ListView<Room> RoomsList;
  private StudentFileAdapter adapter;


  public void initialize()
  {

    courseBox.getItems().removeAll();
    courseBox.getItems().addAll("SDJ1", "SSE", "RWD1", "MSE", "SEP1", "SDJ2", "DBS1", "SWE1", "SEP2");
    courseBox.setPromptText("Choose course");

    studentsBox.getItems().removeAll();
    studentsBox.getItems().addAll("1X", "1Y", "1Z", "1D", "2X", "2Y", "2Z", "2D", "3X", "3Y", "3Z", "3D");
    studentsBox.setPromptText("Choose students list");

    examinerBox.getItems().removeAll();
    examinerBox.getItems().addAll("Examiner1", "Examiner2", "Examiner3", "Examiner4", "Examiner5", "Examiner6", "Examiner7", "Examiner8", "Examiner9");
    examinerBox.setPromptText("Choose examiner");

    classroomBox.getItems().removeAll();
    classroomBox.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
    classroomBox.setPromptText("Choose classroom");

    submit.setOnAction(e -> scheduleAlert());
    export.setOnAction(e -> exportAlert());
  }



  private void scheduleAlert() {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Test Connection");
    alert.setHeaderText("Results:");
    alert.setContentText("Course: "+courseBox.getValue()+"\nStudents: "+studentsBox.getValue()+"\nExaminer: "+examinerBox.getValue()+"\nClassroom: "+classroomBox.getValue()+"\nDate: "+datePicker.getValue());
    alert.showAndWait();
  }

  private void exportAlert() {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Warning");
    alert.setHeaderText("Are you sure you want to export the schedule?");

    alert.showAndWait();
  }


  /** studentListMethod */
  private void studentListMethod()
  {
    int currentIndex = StudentList.getSelectionModel().getSelectedIndex();

    StudentList.getItems().clear();

    ManageStudentsList students = adapter.getAllStudents();
    for (int i = 0; i < students.getNumberOfStudents(); i++)
    {
      StudentList.getItems().add(students.getAllStudents(i));
    }

    if (currentIndex == -1 && StudentList.getItems().size() > 0)
    {
      StudentList.getSelectionModel().select(0);
    }
    else
    {
      StudentList.getSelectionModel().select(currentIndex);
    }
  }

}
