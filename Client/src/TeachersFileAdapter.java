import java.io.FileNotFoundException;
import java.io.IOException;

public class TeachersFileAdapter
{
    private MyFileIO mfio;
    private String fileName;

    /**
     * 1-argument constructor setting the file name.
     * @param fileName the name and path of the file where students will be saved and retrieved
     */
    public TeachersFileAdapter(String fileName)
    {
      mfio = new MyFileIO();
      this.fileName = fileName;
    }


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

