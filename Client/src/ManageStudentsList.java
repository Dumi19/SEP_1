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

  public ArrayList<Student> getStudentsByCourse(String course) {
    ArrayList<Student> tempList = new ArrayList<Student>();
    for (int i = 0 ; i<students.size(); i++){
      if(students.get(i).getCourseCode().equals(course)){
        tempList.add(students.get(i));
      }
    }
    return tempList;
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
