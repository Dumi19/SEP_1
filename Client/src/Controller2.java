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
  @FXML private TextField courseNameField;
  @FXML private TextField courseTypeField;
  @FXML private TextField courseNumberField;
  @FXML private Button updateCourses;
  @FXML private TextField roomNumberField;
  @FXML private TextField seatsNumberField;
  @FXML private TextField isItEquipedField;
  @FXML private CheckBox isItFreeYes;
  @FXML private Button updateRooms;
  @FXML private Button addStudent;

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
    updateCourses.setOnAction(e -> updateInfoCourses());
    updateRooms.setOnAction(e -> updateInfoRooms());
    addStudent.setOnAction(e -> studentAdd());




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

  private void studentAdd()
  {
    String studentNumber = studentNumberField.getText();
    String classNumber = classNumberField.getText();

    adapterStudents.addStudentToArray(9,studentNumber, classNumber);


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

  private void updateInfoCourses() {
    String courseName = courseNameField.getText();
    String numberOfStudents = courseNumberField.getText();
    String typeOfExam = courseTypeField.getText();


    adapterCourse.changeCourse(CourseList.getSelectionModel().getSelectedIndex(), courseName, numberOfStudents, typeOfExam);
    courseListMethod();
    courseNameField.setText("");
    courseNumberField.setText("");
    courseTypeField.setText("");

  }


  private void updateInfoRooms() {
    int roomNumber = Integer.parseInt(roomNumberField.getText());
    int seatsNumber = Integer.parseInt(seatsNumberField.getText());
    boolean isItEquiped = Boolean.parseBoolean(isItEquipedField.getText());
    boolean isItFree = Boolean.parseBoolean(isItFreeYes.getText());



    adapterRooms.changeRoom(RoomsList.getSelectionModel().getSelectedIndex(), roomNumber, seatsNumber, isItEquiped, isItFree);
    roomsListMethod();
    roomNumberField.setText("");
    seatsNumberField.setText("");
    isItEquipedField.setText("");
    isItFreeYes.setText("");

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



  private void courseListMethod()
  {
    int currentIndex = CourseList.getSelectionModel().getSelectedIndex();

    CourseList.getItems().clear();

    manageCourse_list courses = adapterCourse.getAllCourses();
    for (int i = 0; i < courses.getNumberOfCourses(); i++)
    {
      CourseList.getItems().add(courses.getAllCourses(i));
    }

    if (currentIndex == -1 && CourseList.getItems().size() > 0)
    {
      CourseList.getSelectionModel().select(0);
    }
    else
    {
      CourseList.getSelectionModel().select(currentIndex);
    }
  }



  private void roomsListMethod()
  {
    int currentIndex = RoomsList.getSelectionModel().getSelectedIndex();

    RoomsList.getItems().clear();

    ManageRooms rooms = adapterRooms.getAllRooms();
    for (int i = 0; i < rooms.getNumberOfRooms(); i++)
    {
      RoomsList.getItems().add(rooms.getAllRooms(i));
    }

    if (currentIndex == -1 && RoomsList.getItems().size() > 0)
    {
      RoomsList.getSelectionModel().select(0);
    }
    else
    {
      RoomsList.getSelectionModel().select(currentIndex);
    }
  }









}
