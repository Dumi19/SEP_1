import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * A simple program used for importing data. It reads a text file with teacher
 * information, creates a TeachersList object with all teachers read from the file,
 * and saves it as a binary file. The text file must have information of one teacher
 * on each line, and each line should be in the format: firstName,lastName,teacherCourse, isAvaliable
 *
 * @author SEP group 7
 * @version 1.0
 */
public class LoadInitialDataTeachers
{

  public static void main(String[] args)
  {
    ManageTeachers teachers = new ManageTeachers();

    MyTextFileIO mtfio = new MyTextFileIO();
    String[] teacherArray = null;
    try
    {
      teacherArray = mtfio.readArrayFromFile("Client/TeachersList.txt");

      for (int i = 0; i < teacherArray.length; i++)
      {
        String temp = teacherArray[i];
        String[] tempArr = temp.split(",");
        String firstName = tempArr[0];
        String lastName = tempArr[1];
        String teacherCourse = tempArr[2];
        boolean isAvaliable = Boolean.parseBoolean(tempArr[3]);

        teachers.addTeachers(
            new Teacher(firstName, lastName, teacherCourse, isAvaliable));
      }
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File was not found, or could not be opened");
    }

    MyFileIO mfio = new MyFileIO();

    try
    {
      mfio.writeToFile("Client/TeachersList.bin", teachers);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("Error opening file ");
    }
    catch (IOException e)
    {
      System.out.println("IO Error writing to file ");
    }

    System.out.println("Done");
  }
}
