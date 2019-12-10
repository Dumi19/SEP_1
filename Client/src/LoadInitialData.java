import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * A simple program used for importing data. It reads a text file with student
 * information, creates a StudentList object with all students read from the file, 
 * and saves it as a binary file. The text file must have information of one student
 * on each line, and each line should be in the format: firstName,lastName,country
 * @author Allan Henriksen
 * @version 1.0
 */
public class LoadInitialData
{
   public static void main(String[] args)
   {
      ManageStudentsList students = new ManageStudentsList();

      MyTextFileIO mtfio = new MyTextFileIO();
      String[] studentArray = null;
      try
      {
         studentArray = mtfio.readArrayFromFile("studentsList.txt");
                      
         for(int i = 0; i<studentArray.length; i++)
         {
            String temp = studentArray[i];
            String[] tempArr = temp.split(",");
            String studentID = tempArr[0];
            String courseCode = tempArr[1];


            students.addStudent(new Student(studentID, courseCode));
         }
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File was not found, or could not be opened");
      }
     
      MyFileIO mfio = new MyFileIO();
      
      try
      {
         mfio.writeToFile("studentsList.bin", students);
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
