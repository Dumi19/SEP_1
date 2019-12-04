import java.util.ArrayList;

public class ManageStudentsList
{
  private ArrayList<Student> students;

  public ManageStudentsList()
  {
    students = new ArrayList<Student>();
  }

  public Student getAllStudents()   //idk
  {
    return students;
  }

  public void addStudent(Student student)
  {
    students.add(student);
  }

  public void removeStudents(Student student)
  {
    students.remove(student);
  }

  public int getNumberOfStudents()
  {
    return students.size();
  }


}
