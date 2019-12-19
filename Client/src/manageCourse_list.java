import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class used to manage course list
 * @author SEP group 7
 * @version 1.0
 */
public class manageCourse_list implements Serializable
{
  private ArrayList<Course> courses;

  /**
   * No-argument constructor initializing the StudentList.
   */
  public manageCourse_list()
  {
    courses = new ArrayList<>();
  }

  public ArrayList<Course> getAllCourses()
  {
    return courses;
  }

  /**
   * Adds a Course to the list.
   *
   * @param course the student to add to the list
   */
  public void addCourse(Course course)
  {
    courses.add(course);
  }

  /**
   * Gets a Course object from position index from the list.
   *
   * @param index the position in the list of the Course object
   * @return the Course object at position index if one exists, else null
   */
  public Course getAllCourses(int index)
  {
    if (index < courses.size())
    {
      return courses.get(index);
    }
    else
    {
      return null;
    }
  }

  /**
   * Returns number of courses in the ArrayList.
   */
  public int getNumberOfCourses()
  {
    return courses.size();
  }

  public void removeCourses(int index)
  {
    courses.remove(index);
  }

  public Course getOneCourseElement(int index)
  {
    return courses.get(index);
  }

  public Course get(int index)
  {
    if (index < courses.size())
    {
      return courses.get(index);
    }
    else
    {
      return null;
    }
  }
}
