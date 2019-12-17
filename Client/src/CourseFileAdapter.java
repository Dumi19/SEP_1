import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * An adapter to the courses list file, making it easy to retrieve and store information.
 * @author SEP Killers
 * @version 1.0
 */
public class CourseFileAdapter
{

    private MyFileIO mfio;
    private String fileName;

    /**
     * 1-argument constructor setting the file name.
     * @param fileName the name and path of the file where courses will be saved and retrieved
     */
    public CourseFileAdapter(String fileName)
    {
      mfio = new MyFileIO();
      this.fileName = fileName;
    }

    /**
     * Uses the MyFileIO class to retrieve a CourseList object with all Courses.
     * @return a courseList object with all stored courses
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
   * Use the MyFileIO class to save some courses.
   * @param courses the list of courses that will be saved
   */
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

  /**
   * Uses the MyFileIO class to change the name of the course, number of students that belong to course and type of exam.
   * @param any the course's index in the array list
   * @param courseName the name of the course
   * @param numberOfStudents the number of students which belong to course
   * @param typeOfExam the type of exam(oral/written)
   */
    public void changeCourse(int any, String courseName,String numberOfStudents, String typeOfExam)
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

  public void addCourseToArray(String courseName, String numberOfStudents, String typeOfExam)
  {
    manageCourse_list courses = getAllCourses();


    courses.addCourse(new Course(courseName, numberOfStudents, typeOfExam));
    saveCourses(courses);
  }




  // Add more methods to the adapter depending on what you wish to do
  }


