import java.io.Serializable;

public class Student implements Serializable
{
  private String studentID;
  private String studentsClass;

  /**
   * Three-argument constructor.
   *
   * @param studentID     the VIA ID's number
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

  public void setStudentsClass(String studentsClass)
  {
    this.studentsClass = studentsClass;
  }

  public String getStudentsClass()
  {
    return studentsClass;
  }

  public String getStudentID()
  {
    return studentID;
  }

  public String toString()
  {
    return studentID + " " + studentsClass;
  }

}
