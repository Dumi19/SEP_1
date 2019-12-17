import java.io.Serializable;
import java.util.ArrayList;

public class manageCourse_list implements Serializable
{
  private ArrayList<Course> courses;

  public manageCourse_list()
  {
    courses = new ArrayList<>();
  }

  public ArrayList<Course> getAllCourses()
  {
    //   // for (int i = 0; i < courses.size(); i++)
    //    {
    //        return courses.get(i);
    //    }
    //    return null; //I don't know if this part is correct

    return courses;
  }

  public void addCourse(Course course)
  {
    courses.add(course);
  }

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
}
