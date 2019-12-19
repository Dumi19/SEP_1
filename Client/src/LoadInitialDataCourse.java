import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * A simple program used for importing data. It reads a text file with course
 * information, creates a courseList object with all courses read from the file,
 * and saves it as a binary file. The text file must have information of one course
 * on each line, and each line should be in the format: courseName, numberOfStudents, typeOfExams.
 *
 * @author SEP group 7
 * @version 1.0
 */
public class LoadInitialDataCourse
{

  public static void main(String[] args)
  {
    manageCourse_list courses = new manageCourse_list();

    MyTextFileIO mtfio = new MyTextFileIO();
    String[] courseArray = null;
    try
    {
      courseArray = mtfio.readArrayFromFile("Client/CoursesList.txt");

      for (int i = 0; i < courseArray.length; i++)
      {
        String temp = courseArray[i];
        String[] tempArr = temp.split(",");
        String courseName = tempArr[0];
        String numberOfStudents = tempArr[1];
        //int numberOfStudents = Integer.parseInt(tempArr[1]);
        String typeOfExam = tempArr[2];

        courses.addCourse(new Course(courseName, numberOfStudents, typeOfExam));
      }
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File was not found, or could not be opened");
    }

    MyFileIO mfio = new MyFileIO();

    try
    {
      mfio.writeToFile("Client/CoursesList.bin", courses);
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

