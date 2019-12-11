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
  private Date date;
  private Course course;
  private Room room;
  private Teacher teacher;



  public Exam(Date date, Course course, Room room, Teacher teacher)
  {
    this.date = date;
    this.course = course;
    this.room = room;
    this.teacher = teacher;
  }

  public Date getDate()
  {
    return date;
  }

  public void setDate(Date date)
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
}
