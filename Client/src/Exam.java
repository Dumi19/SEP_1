import javafx.beans.property.SimpleStringProperty;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 * A class representing a exam with a date, course, room, teacher and students.
 * @author SEP group 7
 * @version 1.0
 */
public class Exam
{

  private LocalDate date;
  private Course course;
  private Room room;
  private Teacher teacher;
  private Student students;

  /**
   * Three-argument constructor.
   * @param date the date of the exam
   * @param course the information about the course
   * @param room the classroom
   * @param teacher the information about the examiner
   * @param students the student's information
   */
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

  /**
   * Gets the exam's date .
   * @return the exam's date
   */
  public LocalDate getDate()
  {
    return date;
  }

  public void setDate(LocalDate date)
  {
    this.date = date;
  }

  /**
   * Gets the exam's course .
   * @return the exam's course
   */
  public Course getCourse()
  {
    return course;
  }

  /**
   * Sets the exam's course.
   * @param course what the exam's course will be set to
   */
  public void setCourse(Course course)
  {
    this.course = course;
  }

  /**
   * Gets the exam's room .
   * @return the exam's room
   */
  public Room getRoom()
  {
    return room;
  }

  /**
   * Sets the exam's room.
   * @param room what the exam's course will be set to
   */
  public void setRoom(Room room)
  {
    this.room = room;
  }

  /**
   * Gets the exam's teacher .
   * @return the exam's teacher
   */
  public Teacher getTeacher()
  {
    return teacher;
  }

  /**
   * Sets the exam's teacher.
   * @param teacher what the exam's teacher will be set to
   */
  public void setTeacher(Teacher teacher)
  {
    this.teacher = teacher;
  }

  /**
   * Gets the exam's students .
   * @return the exam's students
   */
  public Student getStudents()
  {
    return students;
  }

  /**
   * Sets the exam's students.
   * @param students what the exam's studnts will be set to
   */
  public void setStudents(Student students)
  {
    this.students = students;
  }

  /**
   * Returns a string representation of the exam.
   * @return a string representation of the exam in the format: "date course room teacher students"
   */
  public String toString()
  {
    return "Exam{" + "date=" + date + ", course=" + course + ", room=" + room
        + ", teacher=" + teacher + ", students=" + students + '}';
  }
}
