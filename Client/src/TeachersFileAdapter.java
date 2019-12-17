import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * An adapter to the teachers list file, making it easy to retrieve and store information.
 * @author SEP Killers
 * @version 1.0
 */
public class TeachersFileAdapter
{
    private MyFileIO mfio;
    private String fileName;

    /**
     * 1-argument constructor setting the file name.
     * @param fileName the name and path of the file where teachers will be saved and retrieved
     */
    public TeachersFileAdapter(String fileName)
    {
      mfio = new MyFileIO();
      this.fileName = fileName;
    }

  /**
   * Uses the MyFileIO class to retrieve a TeachersList object with all Teachers.
   * @return a TeachersList object with all stored Teachers
   */
    public ManageTeachers getAllTeachers()
    {
      ManageTeachers teachers = new ManageTeachers();

      try
      {
        teachers = (ManageTeachers) mfio.readObjectFromFile(fileName);
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
      return teachers;
    }


  /**
   * Use the MyFileIO class to save some teachers.
   * @param teachers the list of teachers that will be saved
   */
    public void saveTeachers( ManageTeachers teachers)
    {
      try
      {
        mfio.writeToFile(fileName, teachers);
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
   * @param any the teacher's index in the array list
   * @param firstName the first name of the teacher
   * @param lastName the last name of the teacher
   * @param teacherCourse the course which teacher teaches
   * @param isAvaliable the availability of the teacher
   */
    public void changeTeacher(int any, String firstName, String lastName, String teacherCourse, boolean isAvaliable)
    {
      ManageTeachers teachers = getAllTeachers();
      teachers.getAllTeachers(any).setFirstName(firstName);
      teachers.getAllTeachers(any).setLastName(lastName);
      teachers.getAllTeachers(any).setTeacherCourse(teacherCourse);
      teachers.getAllTeachers(any).setAvaliable(isAvaliable);
      /*for (int i = 0; i < students.getNumberOfStudents(); i++)
      {
         Student student = students.getAllStudents(i);

            student.setStudentID(studentNumber);
            student.setCourseCode(classNumber);

      }*/
      saveTeachers(teachers);
    }

  public void addTeacherToArray(String firstName, String lastName, String teacherCourse, boolean isAvaliable)
  {
    ManageTeachers teachers = getAllTeachers();


    teachers.addTeachers(new Teacher(firstName, lastName, teacherCourse, isAvaliable));
    saveTeachers(teachers);
  }



  // Add more methods to the adapter depending on what you wish to do
  }

