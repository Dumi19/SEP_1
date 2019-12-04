import java.util.ArrayList;

public class manageCourse_list
{
  private ArrayList<Course> courses;

  public manageCourse_list()
  {
    ArrayList<Course> courses = new ArrayList<>();
  }

  public Course getAllCourses()
  {
    for (int i = 0; i < courses.size(); i++)
    {
       courses.get(i);
    }
    return null; //I don't know if this part is correct
  }

  public void addCourse(Course course)
  {
    courses.add(course);
  }
}
