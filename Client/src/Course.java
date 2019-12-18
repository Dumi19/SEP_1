import java.io.Serializable;

/**
 * A class representing a course with a name of course, number of students belong to the course and type of exam.
 *
 * @author SEP Killers
 * @version 1.0
 */
public class Course implements Serializable
{
  private String courseName;
  private String numberOfStudents;
  private String typeOfExam;

  /**
   * Three-argument constructor.
   *
   * @param courseName       the course's name
   * @param numberOfStudents the number of students which belong to course
   * @param typeOfExam       the course's type of exam
   */
  public Course(String courseName, String numberOfStudents, String typeOfExam)
  {
    this.courseName = courseName;
    this.numberOfStudents = numberOfStudents;
    this.typeOfExam = typeOfExam;
  }

  /**
   * Sets the course's name.
   *
   * @param courseName what the course's name will be set to
   */
  public void setCourseName(String courseName)
  {
    this.courseName = courseName;
  }

  /**
   * Gets the course's name.
   *
   * @return the room's name
   */
  public String getCourseName()
  {
    return courseName;
  }

  /**
   * Sets the course's number of students.
   *
   * @param numberOfStudents what the course's number of students which belong to course will be set to
   */
  public void setNumberOfStudents(String numberOfStudents)
  {
    this.numberOfStudents = numberOfStudents;
  }

  /**
   * Gets the course's number of students.
   *
   * @return the course's number of students
   */
  public String getNumberOfStudents()
  {
    return numberOfStudents;
  }

  /**
   * Sets the course's type of exam.
   *
   * @param typeOfExam what the course's type of exam will be set to
   */
  public void setTypeOfExam(String typeOfExam)
  {
    this.typeOfExam = typeOfExam;
  }

  /**
   * Gets the course's type of exam.
   *
   * @return the course's type of exam
   */
  public String getTypeOfExam()
  {
    return typeOfExam;
  }

  /**
   * Returns a string representation of the course.
   *
   * @return a string representation of the course in the format: "courseName numberOfStudents typeOfExam"
   */
  public String toString()
  {
    return courseName + " " + numberOfStudents + " " + typeOfExam;
  }
}
