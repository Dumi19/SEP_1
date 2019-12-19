import javafx.beans.property.SimpleStringProperty;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Exam
{

  private LocalDate date;
  private Course course;
  private Room room;
  private Teacher teacher;
  private Student students;

  public Exam(LocalDate date, Course course,
      Room room, Teacher teacher,
      Student students)
  {
    this.date = date;
    this.course = course;
    this.room = room;
    this.teacher = teacher;
    this.students = students;
  }

  public LocalDate getDate()
  {
    return date;
  }

  public void setDate(LocalDate date)
  {
    this.date = date;
  }

  public Course getCourse()
  {
    return course;
  }

  public void setCourse(Course course)
  {
    this.course = course;
  }

  public Room getRoom()
  {
    return room;
  }

  public void setRoom(Room room)
  {
    this.room = room;
  }

  public Teacher getTeacher()
  {
    return teacher;
  }

  public void setTeacher(Teacher teacher)
  {
    this.teacher = teacher;
  }

  public Student getStudents()
  {
    return students;
  }

  public void setStudents(Student students)
  {
    this.students = students;
  }

  public String toString()
  {
    return "Exam{" + "date=" + date + ", course=" + course + ", room=" + room
        + ", teacher=" + teacher + ", students=" + students + '}';
  }
}
