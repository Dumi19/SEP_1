import java.io.Serializable;

public class Student implements Serializable
{
  private String studentID;
  private String studentsClass;


  /**
   * Three-argument constructor.
   * @param studentID the VIA ID's number
   * @param studentsClass the student's class name
   */
  public Student(String studentID, String studentsClass)
  {
    this.studentID = studentID;
    this.studentsClass = studentsClass;
  }

  public void setStudentID(String studentID)
  {
    this.studentID = studentID;
  }

  public void setCourseCode(String courseCode)
  {
    this.studentsClass = courseCode;
  }

  public String getStudentID()
  {
    return studentID;
  }

  public String getCourseCode()
  {
    return studentsClass;
  }


}
