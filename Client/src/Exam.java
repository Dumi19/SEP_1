import javafx.beans.property.SimpleStringProperty;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Exam
{
  //Date
  //Course
  //Examiner
  //Class
  //Room
//set get
  //Create ListView<Exam>()
  //After setting in Schedule method display them
  private SimpleStringProperty date;
  private SimpleStringProperty course;
  private SimpleStringProperty room;
  private SimpleStringProperty teacher;
  private SimpleStringProperty students;

  public Exam(SimpleStringProperty date, SimpleStringProperty course, SimpleStringProperty room, SimpleStringProperty teacher, SimpleStringProperty students)
  {
    this.date = date;
    this.course = course;
    this.room = room;
    this.teacher = teacher;
    this.students = students;
  }

  public String getDate()
  {
    return date.get();
  }

  public SimpleStringProperty dateProperty()
  {
    return date;
  }

  public void setDate(String date)
  {
    this.date.set(date);
  }

  public String getCourse()
  {
    return course.get();
  }

  public SimpleStringProperty courseProperty()
  {
    return course;
  }

  public void setCourse(String course)
  {
    this.course.set(course);
  }

  public String getRoom()
  {
    return room.get();
  }

  public SimpleStringProperty roomProperty()
  {
    return room;
  }

  public void setRoom(String room)
  {
    this.room.set(room);
  }

  public String getTeacher()
  {
    return teacher.get();
  }

  public SimpleStringProperty teacherProperty()
  {
    return teacher;
  }

  public void setTeacher(String teacher)
  {
    this.teacher.set(teacher);
  }

  public String getStudents()
  {
    return students.get();
  }

  public SimpleStringProperty studentsProperty()
  {
    return students;
  }

  public void setStudents(String students)
  {
    this.students.set(students);
  }
}
