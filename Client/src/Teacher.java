import java.io.Serializable;

public class Teacher implements Serializable
{
  private String firstName;
  private String lastName;
  private String teacherCourse;
  private boolean isAvaliable;

  public Teacher(String firstName, String lastName, String teacherCourse, boolean isAvaliable)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.teacherCourse = teacherCourse;
    this.isAvaliable = isAvaliable;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public void setLastName (String lastName)
  {
    this.lastName = lastName;
  }

  public void setTeacherCourse(String teacherCourse)
  {
    this.teacherCourse = teacherCourse;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public String getTeacherCourse()
  {
    return teacherCourse;
  }

  public void setAvaliable(boolean avaliable)
  {
    isAvaliable = avaliable;
  }

  public boolean isAvaliable()
  {
    return isAvaliable;
  }

  public String toString()
  {
    return firstName+" "+lastName+" "+teacherCourse+" "+isAvaliable;
  }
}
