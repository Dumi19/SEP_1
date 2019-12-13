import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller2
{
  @FXML private ComboBox<String> courseBox;
  @FXML private ComboBox<String> studentsBox;
  @FXML private ComboBox<String> examinerBox;
  @FXML private ComboBox<String> classroomBox;
  @FXML private Button submit;
  @FXML private Button updateStudents;
  @FXML private Button export;
  @FXML private DatePicker datePicker;
  @FXML private Alert alert;
  @FXML private ListView<Student> StudentList;
  @FXML private ListView<Teacher> TeachersList;
  @FXML private ListView<Course> CourseList;
  @FXML private ListView<Room> RoomsList;
  @FXML private StudentFileAdapter adapterStudents;
  private TeachersFileAdapter adapterTeachers;
  private CourseFileAdapter adapterCourse;
  private RoomFileAdapter adapterRooms;
  private ExamFileAdapter adapterExam;
  @FXML private TextField studentNumberField;
  @FXML private TextField classNumberField;
  @FXML private TextField teacherName;
  @FXML private TextField teacherLastName;
  @FXML private TextField subject;
  @FXML private CheckBox availabilityYes;
  @FXML private Button updateTeachers;


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
    updateStudents.setOnAction(e -> updateInfo());
    updateTeachers.setOnAction(e -> updateInfoTeachers());




    adapterStudents= new StudentFileAdapter("Client/StudentsList.bin");
    ManageStudentsList list = adapterStudents.getAllStudents();

    for (int i = 0; i < list.getNumberOfStudents(); i++)
    {
      StudentList.getItems().add(list.getAllStudents(i));
    }



    adapterTeachers= new TeachersFileAdapter("Client/TeachersList.bin");
    ManageTeachers list2 = adapterTeachers.getAllTeachers();
    for (int i = 0; i < list2.getNumberOfTeachers(); i++)
    {
      TeachersList.getItems().add(list2.getAllTeachers(i));
    }



    adapterCourse= new CourseFileAdapter("Client/CoursesList.bin");
    manageCourse_list list3 = adapterCourse.getAllCourses();
    for (int i = 0; i < list3.getNumberOfCourses(); i++)
    {
      CourseList.getItems().add(list3.getAllCourses(i));
    }


    adapterRooms= new RoomFileAdapter("Client/RoomsList.bin");
    ManageRooms list4 = adapterRooms.getAllRooms();
    for (int i = 0; i < list4.getNumberOfRooms(); i++)
    {
      RoomsList.getItems().add(list4.getAllRooms(i));
    }

    //adapterRooms= new StudentFileAdapter("Client/StudentsList.bin");

    //adapterExam
  }



  private void scheduleAlert() {

    //Call the exam constructor with all the parameters in the alert window
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

  private void updateInfo() {
    String studentNumber = studentNumberField.getText();
    String classNumber = classNumberField.getText();

    adapterStudents.changeStudent(StudentList.getSelectionModel().getSelectedIndex(), studentNumber, classNumber);
    //adapterStudents.changeStudent(studentNumber, classNumber);
    studentListMethod();
    studentNumberField.setText("");
    classNumberField.setText("");
  }

  private void updateInfoTeachers() {
    String firstName = teacherName.getText();
    String lastName = teacherLastName.getText();
    String teacherCourse = subject.getText();

    boolean isAvailable = false;

    if(availabilityYes.isSelected())
      isAvailable=true;
     //isAvailable = availability.getText();

    adapterTeachers.changeTeacher(TeachersList.getSelectionModel().getSelectedIndex(), firstName, lastName, teacherCourse, isAvailable);
    teachersListMethod();
    teacherName.setText("");
    teacherLastName.setText("");
    subject.setText("");

  }


  /**
   * Updates the studentListView ListView with information from the students file
   */
    private void studentListMethod()
  {
    int currentIndex = StudentList.getSelectionModel().getSelectedIndex();

    StudentList.getItems().clear();

    ManageStudentsList students = adapterStudents.getAllStudents();
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


  private void teachersListMethod()
  {
    int currentIndex = TeachersList.getSelectionModel().getSelectedIndex();

    TeachersList.getItems().clear();

    ManageTeachers students = adapterTeachers.getAllTeachers();
    for (int i = 0; i < students.getNumberOfTeachers(); i++)
    {
      TeachersList.getItems().add(students.getAllTeachers(i));
    }

    if (currentIndex == -1 && TeachersList.getItems().size() > 0)
    {
      TeachersList.getSelectionModel().select(0);
    }
    else
    {
      TeachersList.getSelectionModel().select(currentIndex);
    }
  }








}
