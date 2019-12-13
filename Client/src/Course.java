import java.io.Serializable;

public class Course implements Serializable
{
  private String courseName;
  private String numberOfStudents;
  private String typeOfExam;

  public Course(String courseName, String numberOfStudents, String typeOfExam)
  {
    this.courseName = courseName;
    this.numberOfStudents = numberOfStudents;
    this.typeOfExam = typeOfExam;
  }

  public void setCourseName(String courseName)
  {
    this.courseName = courseName;
  }

  public String getCourseName()
  {
    return courseName;
  }

  public void setNumberOfStudents(String numberOfStudents)
  {
    this.numberOfStudents = numberOfStudents;
  }

  public String getNumberOfStudents()
  {
    return numberOfStudents;
  }

  public void setTypeOfExam(String typeOfExam)
  {
    this.typeOfExam = typeOfExam;
  }

  public String getTypeOfExam()
  {
    return typeOfExam;
  }

  public String toString()
  {
    return courseName+" "+numberOfStudents+" "+typeOfExam;
  }
}
