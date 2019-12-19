import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import persistence.MyXmlConverter;
import persistence.XmlConverterException;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * A class containing methods and components that are used in our program GUI and functionality.
 *
 * @author SEP Killers
 * @version 1.0
 */
public class Controller2
{
  @FXML private ComboBox<Course> courseBox;
  @FXML private ComboBox<Student> studentsBox;
  @FXML private ComboBox<Teacher> examinerBox;
  @FXML private ComboBox<Room> classroomBox;
  @FXML private Button submit;
  @FXML private Button updateStudents;
  @FXML private Button export;
  @FXML private DatePicker datePicker;
  @FXML private ListView<Student> StudentList;
  @FXML private ListView<Teacher> TeachersList;
  @FXML private ListView<Course> CourseList;
  @FXML private ListView<Room> RoomsList;
  @FXML private TableView table;
  private ExamList examList;
  @FXML private ObservableList<Exam> data;
  private StudentFileAdapter adapterStudents;
  private TeachersFileAdapter adapterTeachers;
  private CourseFileAdapter adapterCourse;
  private RoomFileAdapter adapterRooms;
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
  @FXML private CheckBox isItEquipedCheckBox;
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

  /**
   * Constructor initializing ExamList
   */
  public Controller2()
  {
    examList = new ExamList();

  }

  /**
   * Method in which buttons are connected with our methods, it also allows us to load data into program from external txt file
   */
  public void initialize()
  {
    setTableColumns();

    submit.setOnAction(e -> scheduleAlert());
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
    export.setOnAction(e -> exportXML());

    adapterStudents = new StudentFileAdapter("Client/StudentsList.bin");
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
    updateCourseBox();
    updateRoomsBox();
    updateStudentsBox();
    updateTeachersBox();
  }

  /**
   * Updates the courseBox ComboBox with information from the courseList file
   */
  public void updateCourseBox()
  {
    int currentIndex = courseBox.getSelectionModel().getSelectedIndex();

    courseBox.getItems().clear();

    manageCourse_list courses = adapterCourse.getAllCourses();
    for (int i = 0; i < courses.getNumberOfCourses(); i++)
    {
      courseBox.getItems().add(courses.get(i));
    }

    if (currentIndex == -1 && courseBox.getItems().size() > 0)
    {
      courseBox.getSelectionModel().select(0);
    }
    else
    {
      courseBox.getSelectionModel().select(currentIndex);
    }
  }

  /**
   * Updates the studentsBox ComboBox with information from the studentsList file
   */
  public void updateStudentsBox()
  {
    int currentIndex = studentsBox.getSelectionModel().getSelectedIndex();

    studentsBox.getItems().clear();

    ManageStudentsList students = adapterStudents.getAllStudents();
    for (int i = 0; i < students.getNumberOfStudents(); i++)
    {
      studentsBox.getItems().add(students.get(i));
    }

    if (currentIndex == -1 && studentsBox.getItems().size() > 0)
    {
      studentsBox.getSelectionModel().select(0);
    }
    else
    {
      studentsBox.getSelectionModel().select(currentIndex);
    }
  }

  /**
   * Updates the examinerBox ComboBox with information from the teacherList file
   */
  public void updateTeachersBox()
  {
    int currentIndex = examinerBox.getSelectionModel().getSelectedIndex();

    examinerBox.getItems().clear();

    ManageTeachers teachers = adapterTeachers.getAllTeachers();
    for (int i = 0; i < teachers.getNumberOfTeachers(); i++)
    {
      examinerBox.getItems().add(teachers.get(i));
    }

    if (currentIndex == -1 && examinerBox.getItems().size() > 0)
    {
      examinerBox.getSelectionModel().select(0);
    }
    else
    {
      examinerBox.getSelectionModel().select(currentIndex);
    }
  }

  /**
   * Updates the classRoomBox ComboBox with information from the roomList file
   */
  public void updateRoomsBox()
  {
    int currentIndex = classroomBox.getSelectionModel().getSelectedIndex();

    classroomBox.getItems().clear();

    ManageRooms rooms = adapterRooms.getAllRooms();
    for (int i = 0; i < rooms.getNumberOfRooms(); i++)
    {
      classroomBox.getItems().add(rooms.get(i));
    }

    if (currentIndex == -1 && classroomBox.getItems().size() > 0)
    {
      classroomBox.getSelectionModel().select(0);
    }
    else
    {
      classroomBox.getSelectionModel().select(currentIndex);
    }
  }

  /**
   * Method initializing table in exam tab
   */
  private void setTableColumns()
  {
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

    table.getColumns()
        .setAll(dateColumn, courseColumn, classColumn, teacherColumn,
            studentColumn);
  }

  /**
   * Method that allow us to put exam information to the table in Exam tab, it is also displaying alert with all exam information
   */
  private void scheduleAlert()
  {

    LocalDate date = datePicker.getValue();
    Course course = courseBox.getValue();
    Room room = classroomBox.getValue();
    Teacher teacher = examinerBox.getValue();
    Student student = studentsBox.getValue();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");

    LocalDate var0 =  date;
    Course var1 = course;
    Room var2 = room;
    Teacher var3 = teacher;
    Student var4 = student;


    Exam exam = new Exam(var0, var1, var2, var3, var4);
    examList.addExam(exam);
    table.getItems().add(exam);

    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Test Connection");
    alert.setHeaderText("Results:");
    alert.setContentText(
        "Course: " + courseBox.getValue() + "\nStudents: " + studentsBox
            .getValue() + "\nExaminer: " + examinerBox.getValue()
            + "\nClassroom: " + classroomBox.getValue() + "\nDate: "
            + datePicker.getValue());
    alert.showAndWait();

  }

  /**
   * Method that allows us to export all the information from Exam tab table to xml file
   */
  private void exportXML()
  {
    MyXmlConverter xml = new MyXmlConverter();

    try
    {
      xml.toXml(examList, "schedule.xml");
    }
    catch (XmlConverterException e)
    {
      e.printStackTrace();
    }

  }

  /**
   * Method that allows us to select a position from the listView and put the information to textFields so we can change them
   */
  private void updateInfo()
  {
    String studentNumber = StudentList.getSelectionModel().getSelectedItem()
        .getStudentID();
    String classNumber = StudentList.getSelectionModel().getSelectedItem()
        .getStudentsClass();

    studentListMethod();
    studentNumberField.setText(studentNumber);
    classNumberField.setText(classNumber);
  }

  /**
   * Method that allows us to add students to arrayList and listView
   */
  private void studentAdd()
  {
    String studentNumber = studentNumberField.getText();
    String classNumber = classNumberField.getText();

    adapterStudents.addStudentToArray(studentNumber, classNumber);

    studentListMethod();
    studentNumberField.setText("");
    classNumberField.setText("");

  }

  /**
   * Method that allows us to remove students from arrayList and listView
   */
  private void removeStudent()
  {

    String studentNumber = StudentList.getSelectionModel().getSelectedItem()
        .getStudentID();
    String classNumber = StudentList.getSelectionModel().getSelectedItem()
        .getStudentsClass();

    adapterStudents.removeStudentFromArray(studentNumber, classNumber);

    studentListMethod();

  }

  /**
   * Method that allows us to add courses to arrayList and listView
   */
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

  /**
   * Method that allows us to remove courses from arrayList and listView
   */
  private void removeCourse()
  {

    String courseName = CourseList.getSelectionModel().getSelectedItem()
        .getCourseName();
    String numberOfStudents = CourseList.getSelectionModel().getSelectedItem()
        .getNumberOfStudents();
    String typeOfExam = CourseList.getSelectionModel().getSelectedItem()
        .getTypeOfExam();

    adapterCourse
        .removeCourseFromArray(courseName, numberOfStudents, typeOfExam);

    courseListMethod();

  }

  /**
   * Method that allows us to add teachers to arrayList and listView
   */
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

    adapterTeachers
        .addTeacherToArray(name, lastName, teacherCourse, availability);

    teachersListMethod();
    teacherLastName.setText("");
    teacherName.setText("");
    subject.setText("");
    availabilityYes.setText("");

  }

  /**
   * Method that allows us to remove  teachers from arrayList and listView
   */
  private void removeTeacher()
  {

    String name = TeachersList.getSelectionModel().getSelectedItem()
        .getFirstName();
    String lastName = TeachersList.getSelectionModel().getSelectedItem()
        .getLastName();
    String course = TeachersList.getSelectionModel().getSelectedItem()
        .getTeacherCourse();
    boolean isAvailable = TeachersList.getSelectionModel().getSelectedItem()
        .isAvaliable();

    adapterTeachers.removeTeacherFromArray(name, lastName, course, isAvailable);

    teachersListMethod();

  }

  /**
   * Method that allows us to add classRooms to arrayList and listView
   */
  private void roomAdd()
  {
    int number = Integer.parseInt(roomNumberField.getText());
    int seats = Integer.parseInt(seatsNumberField.getText());
    boolean equipped = false;
    boolean free = false;

    if (isItFreeYes.isSelected())
    {
      free = true;
    }
    if (isItEquipedCheckBox.isSelected())
    {
      equipped = true;
    }

    adapterRooms.addRoomToArray(number, seats, equipped, free);

    roomsListMethod();
    roomNumberField.setText("");
    seatsNumberField.setText("");
    isItEquipedCheckBox.setText("");
    isItFreeYes.setText("");

  }

  /**
   * Method that allows us to remove rooms from arrayList and listView
   */
  private void removeRoom()
  {

    int roomNumber = RoomsList.getSelectionModel().getSelectedItem()
        .getRoomNumber();
    int numberOfSeats = RoomsList.getSelectionModel().getSelectedItem()
        .getSeatsNumber();
    boolean equipped = RoomsList.getSelectionModel().getSelectedItem()
        .isItEquiped();
    boolean free = RoomsList.getSelectionModel().getSelectedItem().isItFree();

    adapterRooms.removeRoomFromArray(roomNumber, numberOfSeats, equipped, free);

    roomsListMethod();

  }

  /**
   * Method that allows us to update teachers information in the listView
   */
  private void updateInfoTeachers()
  {
    String name = TeachersList.getSelectionModel().getSelectedItem()
        .getFirstName();
    teacherName.setText(name);

    String lastName = TeachersList.getSelectionModel().getSelectedItem()
        .getLastName();
    teacherLastName.setText(lastName);

    String subjectT = TeachersList.getSelectionModel().getSelectedItem()
        .getTeacherCourse();
    subject.setText(subjectT);
    if (TeachersList.getSelectionModel().getSelectedItem().isAvaliable())
    {
      availabilityYes.setSelected(true);
    }

    teachersListMethod();

  }

  /**
   * Method that allows us to update courses information in the listView
   */
  private void updateInfoCourses()
  {
    String courseName = CourseList.getSelectionModel().getSelectedItem()
        .getCourseName();
    String numberOfStudents = CourseList.getSelectionModel().getSelectedItem()
        .getNumberOfStudents();
    String typeOfExam = CourseList.getSelectionModel().getSelectedItem()
        .getTypeOfExam();

    courseNameField.setText(courseName);
    courseNumberField.setText(numberOfStudents);
    courseTypeField.setText(typeOfExam);
    courseListMethod();
  }

  /**
   * Method that allows us to update rooms information in the listView
   */
  private void updateInfoRooms()
  {
    int roomNumber = RoomsList.getSelectionModel().getSelectedItem()
        .getRoomNumber();
    int seatsNumber = RoomsList.getSelectionModel().getSelectedItem()
        .getSeatsNumber();

    String roomNumber1 = Integer.toString(roomNumber);
    String seatsNumber1 = Integer.toString(seatsNumber);

    if (RoomsList.getSelectionModel().getSelectedItem().isItEquiped())
    {
      isItEquipedCheckBox.setSelected(true);
    }
    if (RoomsList.getSelectionModel().getSelectedItem().isItFree())
    {
      isItFreeYes.setSelected(true);
    }

    roomsListMethod();
    roomNumberField.setText(roomNumber1);
    seatsNumberField.setText(seatsNumber1);

  }

  /**
   * Updates the studentListView with information from the studentsList file
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

  /**
   * Updates the teachersListView  with information from the teacherList file
   */
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

  /**
   * Updates the coursesListView  with information from the coursesList file
   */
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

  /**
   * Updates the roomsListView  with information from the RoomsList file
   */
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
