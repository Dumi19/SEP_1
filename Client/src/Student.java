import java.io.Serializable;

/**
 * A class representing a student with a VIA ID and class that student belong.
 * @author SEP Killers
 * @version 1.0
 */
public class Student implements Serializable
{
  private String studentID;
  private String studentsClass;


  /**
   * Two-argument constructor.
   * @param studentID the student's VIA ID number
   * @param studentsClass the student's class name
   */
  public Student(String studentID, String studentsClass)
  {
    this.studentID = studentID;
    this.studentsClass = studentsClass;
  }

  /**
   * Sets the student's VIA ID.
   * @param studentID what the student's VIA ID will be set to
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
   * Gets the student's programme/course.
   * @return the student's programme/course
   */
  public String getStudentsClass()
  {
    return studentsClass;
  }

  /**
   * Gets the student's VIA ID.
   * @return the student's VIA ID
   */
  public String getStudentID()
  {
    return studentID;
  }

  /**
   * Gets the student's class.
   * @return the student's class
   */
  public String getCourseCode()
  {
    return studentsClass;
  }

  /**
   * Returns a string representation of the student.
   * @return a string representation of the student in the format: "studentID studentClass"
   */
  public String toString()
  {
    return studentID +" " + studentsClass ;
  }


}
