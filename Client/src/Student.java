import java.io.Serializable;

public class Student implements Serializable
{
  private String studentID;
  private String courseCode;

  public Student(String studentID, String courseCode)
  {
    this.studentID = studentID;
    this.courseCode = courseCode;
  }

  public void setStudentID(String studentID)
  {
    this.studentID = studentID;
  }

  public void setCourseCode(String courseCode)
  {
    this.courseCode = courseCode;
  }

  public String getStudentID()
  {
    return studentID;
  }

  public String getCourseCode()
  {
    return courseCode;
  }


}
