public class Course
{
  private String courseName;
  private int numberOfStudents;
  private String typeOfExam;

  public Course(String courseName, int numberOfStudents, String typeOfExam)
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

  public void setNumberOfStudents(int numberOfStudents)
  {
    this.numberOfStudents = numberOfStudents;
  }

  public int getNumberOfStudents()
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
