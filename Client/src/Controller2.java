import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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
  @FXML private ListView<Student> StudentList;
  @FXML private ListView<Teacher> TeachersList;
  @FXML private ListView<Course> CourseList;
  @FXML private ListView<Room> RoomsList;
  @FXML private TableView table;
  @FXML private ArrayList<Exam> examList;
  @FXML private ObservableList<Exam> data;
  @FXML private StudentFileAdapter adapterStudents;
  @FXML private TeachersFileAdapter adapterTeachers;
  @FXML private CourseFileAdapter adapterCourse;
  @FXML private RoomFileAdapter adapterRooms;
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
  @FXML private Button addCourse;
  @FXML private Button addTeacher;
  @FXML private Button addRoom;
  @FXML private Button removeStudents;
  @FXML private Button removeRoom;
  @FXML private Button removeCourse;
  @FXML private Button removeTeachers;



 public Controller2(){
   examList = new ArrayList<>();
   RoomsList = new ListView<>();
   adapterStudents= new StudentFileAdapter("Client/StudentsList.bin");
 }
  public void initialize()
  {
    setTableColumns();
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
    addCourse.setOnAction(e -> courseAdd());
    addRoom.setOnAction(e -> roomAdd());
    addTeacher.setOnAction(e -> teacherAdd());
    removeStudents.setOnAction(e -> removeStudent());
    removeRoom.setOnAction(e -> removeRoom());
    removeCourse.setOnAction(e -> removeCourse());
    removeTeachers.setOnAction(e -> removeTeacher());

    ManageStudentsList list = adapterStudents.getAllStudents();

    for (int i = 0; i < list.getNumberOfStudents(); i++)
    {
      StudentList.getItems().add(list.getAllStudents(i));
    }



    adapterTeachers = new TeachersFileAdapter("Client/TeachersList.bin");
    ManageTeachers list2 = adapterTeachers.getAllTeachers();
    for (int i = 0; i < list2.getNumberOfTeachers(); i++)
    {
      TeachersList.getItems().add(list2.getAllTeachers(i));
    }



    adapterCourse = new CourseFileAdapter("Client/CoursesList.bin");
    manageCourse_list list3 = adapterCourse.getAllCourses();
    for (int i = 0; i < list3.getNumberOfCourses(); i++)
    {
      CourseList.getItems().add(list3.getAllCourses(i));
    }


    adapterRooms = new RoomFileAdapter("Client/RoomsList.bin");
    ManageRooms list4 = adapterRooms.getAllRooms();
    for (int i = 0; i < list4.getNumberOfRooms(); i++)
    {
      RoomsList.getItems().add(list4.getAllRooms(i));
    }


  }

private void setTableColumns() {
  TableColumn dateColumn = new TableColumn("Date");
  dateColumn.setCellValueFactory(new PropertyValueFactory("date"));

  TableColumn courseColumn = new TableColumn("Course");
  courseColumn.setCellValueFactory(new PropertyValueFactory("course"));

  TableColumn classColumn = new TableColumn("Class");
  classColumn.setCellValueFactory(new PropertyValueFactory("room"));

  TableColumn teacherColumn = new TableColumn("Teacher");
  teacherColumn.setCellValueFactory(new PropertyValueFactory("teacher"));

  TableColumn studentColumn = new TableColumn("Students");
  studentColumn.setCellValueFactory(new PropertyValueFactory("students"));

  table.getColumns().setAll(dateColumn, courseColumn, classColumn, teacherColumn, studentColumn);
}

  private void scheduleAlert() {

    LocalDate date = datePicker.getValue();
    String course = courseBox.getValue();
    String room = classroomBox.getValue();
    String teacher = examinerBox.getValue();
    String student = studentsBox.getValue();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
    String formattedDate = date.format(formatter);
    SimpleStringProperty var0 = new SimpleStringProperty((String) formattedDate);
    SimpleStringProperty var1 = new SimpleStringProperty((String) course);
    SimpleStringProperty var2 = new SimpleStringProperty((String) room);
    SimpleStringProperty var3 = new SimpleStringProperty((String) teacher);
    SimpleStringProperty var4 = new SimpleStringProperty((String) student);
    Exam exam = new Exam(var0, var1, var2, var3, var4);
    examList.add(exam);
    data = FXCollections.observableArrayList(examList);
    table.setItems(data);

    //table.getItems().add(data);




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

    adapterStudents.addStudentToArray(studentNumber, classNumber);

    studentListMethod();
    studentNumberField.setText("");
    classNumberField.setText("");

  }

  private void removeStudent() {

    String studentNumber = StudentList.getSelectionModel().getSelectedItem().getStudentID();
    String classNumber = StudentList.getSelectionModel().getSelectedItem().getStudentsClass();

    adapterStudents.removeStudentFromArray(studentNumber, classNumber);

    studentListMethod();

  }


  private void courseAdd()
  {
    String courseName = courseNameField.getText();
    String numberOfStudents = courseNumberField.getText();
    String typeOfExam = courseTypeField.getText();

    adapterCourse.addCourseToArray(courseName, numberOfStudents, typeOfExam);

    courseListMethod();
    courseNumberField.setText("");
    courseNameField.setText("");
    courseTypeField.setText("");

  }
  private void removeCourse() {

    String courseName = CourseList.getSelectionModel().getSelectedItem().getCourseName();
    String numberOfStudents = CourseList.getSelectionModel().getSelectedItem().getNumberOfStudents();
    String typeOfExam = CourseList.getSelectionModel().getSelectedItem().getTypeOfExam();

    adapterCourse.removeCourseFromArray(courseName, numberOfStudents, typeOfExam);

    courseListMethod();

  }

  private void teacherAdd()
  {
    String name = teacherName.getText();
    String lastName = teacherLastName.getText();
    String teacherCourse = subject.getText();
    boolean availability = false;

    if (availabilityYes.isSelected())
    {
      availability = true;
    }

    

    adapterTeachers.addTeacherToArray(name, lastName, teacherCourse, availability);

    teachersListMethod();
    teacherLastName.setText("");
    teacherName.setText("");
    subject.setText("");
    availabilityYes.setText("");

  }

  private void removeTeacher() {

    String name = TeachersList.getSelectionModel().getSelectedItem().getFirstName();
    String lastName = TeachersList.getSelectionModel().getSelectedItem().getLastName();
    String course = TeachersList.getSelectionModel().getSelectedItem().getTeacherCourse();
    boolean isAvailable = TeachersList.getSelectionModel().getSelectedItem().isAvaliable();


    adapterTeachers.removeTeacherFromArray(name, lastName, course, isAvailable);

    teachersListMethod();

  }

  private void roomAdd()
  {
    int number = Integer.parseInt(roomNumberField.getText());
    int seats = Integer.parseInt(seatsNumberField.getText());
    boolean equipped = Boolean.parseBoolean(isItEquipedField.getText());
    boolean free = false;

    if (isItFreeYes.isSelected())
    {
      free = true;
    }

    adapterRooms.addRoomToArray(number, seats, equipped, free);

    roomsListMethod();
    roomNumberField.setText("");
    seatsNumberField.setText("");
    isItEquipedField.setText("");
    isItFreeYes.setText("");

  }
  private void removeRoom() {

    int roomNumber = RoomsList.getSelectionModel().getSelectedItem().getRoomNumber();
    int numberOfSeats = RoomsList.getSelectionModel().getSelectedItem().getSeatsNumber();
    boolean equipped = RoomsList.getSelectionModel().getSelectedItem().isItEquiped();
    boolean free = RoomsList.getSelectionModel().getSelectedItem().isItFree();

    adapterRooms.removeRoomFromArray(roomNumber, numberOfSeats, equipped, free);

    roomsListMethod();

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
