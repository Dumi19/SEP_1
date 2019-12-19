import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * An adapter to the students file, making it easy to retrieve and store information.
 * @author SEP group 7
 * @version 1.0
 */
public class StudentFileAdapter
{
  private MyFileIO mfio;
  private String fileName;

  /**
   * 1-argument constructor setting the file name.
   *
   * @param fileName the name and path of the file where students will be saved and retrieved
   */
  public StudentFileAdapter(String fileName)
  {
    mfio = new MyFileIO();
    this.fileName = fileName;
  }

  /**
   * Uses the MyFileIO class to retrieve a StudentList object with all Students.
   *
   * @return a StudentList object with all stored students
   */
  public ManageStudentsList getAllStudents()
  {
    ManageStudentsList students = new ManageStudentsList();

    try
    {
      students = (ManageStudentsList) mfio.readObjectFromFile(fileName);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
    }
    return students;
  }

  /**
   * Use the MyFileIO class to save some students.
   *
   * @param students the list of students that will be saved
   */
  public void saveStudents(ManageStudentsList students)
  {
    try
    {
      mfio.writeToFile(fileName, students);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error writing to file");
    }
  }

  /**
   * Uses the MyFileIO class to change the first name, last name, course which teacher teaches and availability of the teacher.
   *
   * @param any           the student's index in the array list
   * @param studentNumber     the number of the student
   * @param classNumber      the number of the class student belongs to
   */
  public void changeStudent(int any, String studentNumber, String classNumber)
  {
    ManageStudentsList students = getAllStudents();
    students.getAllStudents(any).setStudentID(studentNumber);
    students.getAllStudents(any).setStudentsClass(classNumber);

    saveStudents(students);
  }

  /**
   * Uses the MyFileIO class to add course to array with
   * the given courseName and numberOfStudents.
   * @param studentNumber the name of the course
   * @param classNumber the number of students participating the course
   */
  public void addStudentToArray(String studentNumber, String classNumber)
  {
    ManageStudentsList students = getAllStudents();

    students.addStudent(new Student(studentNumber, classNumber));
    saveStudents(students);
  }

  /**
   * Uses the MyFileIO class to remove course from array with
   * the given courseName and numberOfStudents.
   * @param studentNumber the number of the student
   * @param classNumber the number of class the students belong to
   */
  public void removeStudentFromArray(String studentNumber, String classNumber)
  {
    ManageStudentsList students = getAllStudents();

    for (int i = 0; i < students.getNumberOfStudents(); i++)
    {
      if (students.getAllStudents(i).getStudentID().equals(studentNumber)
          && students.getAllStudents(i).getStudentsClass().equals(classNumber))
      {
        students.removeStudents(i);
      }
    }

    saveStudents(students);
  }
}
