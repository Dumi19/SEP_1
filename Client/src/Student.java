import java.io.Serializable;

/**
 * A class representing a student with a studentID and studentsClass
 * @author SEP group 7
 * @version 1.0
 */
public class Student implements Serializable
{
  private String studentID;
  private String studentsClass;

  /**
   * Two-argument constructor.
   *
   * @param studentID     the VIA ID's number
   * @param studentsClass the student's class name
   */
  public Student(String studentID, String studentsClass)
  {
    this.studentID = studentID;
    this.studentsClass = studentsClass;
  }

  /**
   * Sets the student's ID.
   * @param studentID what the student's ID will be set to
   */
  public void setStudentID(String studentID)
  {
    this.studentID = studentID;
  }

  /**
   * Sets the student's class.
   * @param studentsClass what the student's class will be set to
   */
  public void setStudentsClass(String studentsClass)
  {
    this.studentsClass = studentsClass;
  }

  /**
   * Gets the student's class .
   * @return the student's class
   */
  public String getStudentsClass()
  {
    return studentsClass;
  }

  /**
   * Gets the student's ID .
   * @return the student's ID
   */
  public String getStudentID()
  {
    return studentID;
  }

  /**
   * Returns a string representation of the student.
   * @return a string representation of the student in the format: "studentID studentsClass"
   */
  public String toString()
  {
    return studentID + " " + studentsClass;
  }

}
