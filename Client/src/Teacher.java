import java.io.Serializable;

/**
 * A class representing a teacher with a first name, last name, the course he/she teaches and his/her availability.
 * @author SEP Killers
 * @version 1.0
 */
public class Teacher implements Serializable
{
  private String firstName;
  private String lastName;
  private String teacherCourse;
  private boolean isAvaliable;

  /**
   * Four-argument constructor.
   * @param firstName the teacher's first name
   * @param lastName the teacher's last name
   * @param teacherCourse the course's name
   * @param isAvaliable the teacher's availability
   */
  public Teacher(String firstName, String lastName, String teacherCourse, boolean isAvaliable)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.teacherCourse = teacherCourse;
    this.isAvaliable = isAvaliable;
  }

  /**
   * Sets the teacher's first name.
   * @param firstName what the teachers's first name will be set to
   */
  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  /**
   * Sets the teacher's last name.
   * @param lastName what the teacher's first name will be set to
   */
  public void setLastName (String lastName)
  {
    this.lastName = lastName;
  }

  /**
   * Sets the teacher's course he/she teach.
   * @param teacherCourse what the teacher's first name will be set to
   */
  public void setTeacherCourse(String teacherCourse)
  {
    this.teacherCourse = teacherCourse;
  }

  /**
   * Gets the teacher's first name.
   * @return the teacher's first name
   */
  public String getFirstName()
  {
    return firstName;
  }

  /**
   * Gets the teacher's last name.
   * @return the teacher's last name
   */
  public String getLastName()
  {
    return lastName;
  }

  /**
   * Gets the teacher's course.
   * @return the student's course
   */
  public String getTeacherCourse()
  {
    return teacherCourse;
  }

  /**
   * Sets the teacher's availability.
   * @param avaliable what the teacher's availability will be set to
   */
  public void setAvaliable(boolean avaliable)
  {
    isAvaliable = avaliable;
  }

  /**
   * Gets the teacher's availability.
   * @return the teacher's availability
   */
  public boolean isAvaliable()
  {
    return isAvaliable;
  }

  /**
   * Returns a string representation of the teacher.
   * @return a string representation of the teacher in the format: "firstName lastName teacherCourse isAvaliable"
   */
  public String toString()
  {
    return firstName+" "+lastName+" "+teacherCourse+" "+isAvaliable;
  }
}
