import java.io.FileNotFoundException;
import java.io.IOException;

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

        for(int i = 0; i<teacherArray.length; i++)
        {
          String temp = teacherArray[i];
          String[] tempArr = temp.split(",");
          String firstName = tempArr[0];
          String lastName = tempArr[1];
          String teacherCourse = tempArr[2];
          Boolean isAvaliable = tempArr[3];


          teachers.addTeachers(new Teacher(firstName, lastName, teacherCourse, isAvaliable));
        }
      }
      catch (FileNotFoundException e)
      {
        System.out.println("File was not found, or could not be opened");
      }

      MyFileIO mfio = new MyFileIO();

      try
      {
        mfio.writeToFile("Client/studentsList.bin", teachers);
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
