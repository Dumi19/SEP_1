public class Teacher
{
  private String firstName;
  private String lastName;
  private String teacherCourse;
  private boolean isAvaliable;

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
  public boolean isAvaliable()
  {
    return isAvaliable;
  }

  public String toString()
  {
    return firstName+" "+lastName+" "+teacherCourse+" "+isAvaliable;
  }
}
