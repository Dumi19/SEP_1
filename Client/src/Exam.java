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
  private LocalDate date;
  private String course;
  private String room;
  private String teacher;
  private String students;

  public Exam(LocalDate date, String course, String room, String teacher, String students)
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

  public String getCourse()
  {
    return course;
  }

  public void setCourse(String course)
  {
    this.course = course;
  }

  public String getRoom()
  {
    return room;
  }

  public void setRoom(String room)
  {
    this.room = room;
  }

  public String getTeacher()
  {
    return teacher;
  }

  public void setTeacher(String teacher)
  {
    this.teacher = teacher;
  }
}
