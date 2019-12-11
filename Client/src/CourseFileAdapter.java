import java.io.FileNotFoundException;
import java.io.IOException;

public class CourseFileAdapter
{

    private MyFileIO mfio;
    private String fileName;

    /**
     * 1-argument constructor setting the file name.
     * @param fileName the name and path of the file where students will be saved and retrieved
     */
    public CourseFileAdapter(String fileName)
    {
      mfio = new MyFileIO();
      this.fileName = fileName;
    }

    /**
     * Uses the MyFileIO class to retrieve a StudentList object with all Students.
     * @return a StudentList object with all stored students
     */
    public manageCourse_list getAllCourses()
    {
      manageCourse_list courses = new manageCourse_list();

      try
      {
        courses = (manageCourse_list) mfio.readObjectFromFile(fileName);
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
      return courses;
    }




    public void saveCourses( manageCourse_list courses)
    {
      try
      {
        mfio.writeToFile(fileName, courses);
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


    public void changeCourse(int any, String courseName,int numberOfStudents, String typeOfExam)
    {
      manageCourse_list courses = getAllCourses();
      courses.getAllCourses(any).setCourseName(courseName);
      courses.getAllCourses(any).setNumberOfStudents(numberOfStudents);
      courses.getAllCourses(any).setTypeOfExam(typeOfExam);
      /*for (int i = 0; i < students.getNumberOfStudents(); i++)
      {
         Student student = students.getAllStudents(i);

            student.setStudentID(studentNumber);
            student.setCourseCode(classNumber);

      }*/
      saveCourses(courses);
    }



    // Add more methods to the adapter depending on what you wish to do
  }


