import java.io.Serializable;
import java.util.ArrayList;

public class ManageStudentsList implements Serializable
{
  private ArrayList<Student> students;

  /**
   * No-argument constructor initializing the StudentList.
   */
  public ManageStudentsList()
  {
    students = new ArrayList<Student>();
  }

  /**
   * Gets a Student object from position index from the list.
   * @param index the position in the list of the Student object
   * @return the Student object at position index if one exists, else null
   */
  public Student getAllStudents(int index)
  {
    if(index<students.size())
    {
      return students.get(index);
    }
    else
    {
      return null;
    }
  }

  /**
   * Gets a Student object from ArrayList where the course matches.
   * @param course the position in the ArrayList
   * @return the Student temporary ArrayList where course equals chosen course
   */
  public ArrayList<Student> getStudentsByCourse(String course)
  {
    ArrayList<Student> tempList = new ArrayList<Student>();
    for (int i = 0; i < students.size(); i++)
    {
      if (students.get(i).getCourseCode().equals(course))
      {
        tempList.add(students.get(i));
      }
    }
    return tempList;
  }

  /**
   * Adds a Student to the list.
   * @param student the student to add to the list
   */
  public void addStudent(Student student)
  {
    students.add(student);
  }

  /**
   * Removes a Student from the list.
   * @param student the student to remove from the list
   */
  public void removeStudents(Student student)
  {
    students.remove(student);
  }


  /**
   * Returns number of students in the ArrayList.
   */
  public int getNumberOfStudents()
  {
    return students.size();
  }

}
