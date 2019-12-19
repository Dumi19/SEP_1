import java.io.FileNotFoundException;
import java.io.IOException;

public class CourseFileAdapter
{

  private MyFileIO mfio;
  private String fileName;

  /**
   * 1-argument constructor setting the file name.
   *
   * @param fileName the name and path of the file where students will be saved and retrieved
   */
  public CourseFileAdapter(String fileName)
  {
    mfio = new MyFileIO();
    this.fileName = fileName;
  }

  /**
   * Uses the MyFileIO class to retrieve a StudentList object with all Students.
   *
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

  /**
   * Use the MyFileIO class to save some students.
   * @param courses the list of students that will be saved
   */
  public void saveCourses(manageCourse_list courses)
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

  /**
   * Uses the MyFileIO class to add course to array with
   * the given courseName and numberOfStudents.
   * @param courseName the name of the course
   * @param numberOfStudents the number of students participating the course
   */

  public void addCourseToArray(String courseName, String numberOfStudents,
      String typeOfExam)
  {
    manageCourse_list courses = getAllCourses();

    courses.addCourse(new Course(courseName, numberOfStudents, typeOfExam));
    saveCourses(courses);
  }

  /**
   * Uses the MyFileIO class to remove course from array with
   * the given courseName and numberOfStudents.
   * @param courseName the name of the course
   * @param numberOfStudents the number of students participating the course
   */
  public void removeCourseFromArray(String courseName, String numberOfStudents,
      String typeOfExam)
  {
    manageCourse_list courses = getAllCourses();

    for (int i = 0; i < courses.getNumberOfCourses(); i++)
    {
      if (courses.getAllCourses(i).getCourseName().equals(courseName) && courses
          .getAllCourses(i).getNumberOfStudents().equals(numberOfStudents)
          && courses.getAllCourses(i).getTypeOfExam().equals(typeOfExam))
      {
        courses.removeCourses(i);
      }
    }

    saveCourses(courses);
  }

  // Add more methods to the adapter depending on what you wish to do
}


