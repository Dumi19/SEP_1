import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class used to manage teachers list
 * @author SEP group 7
 * @version 1.0
 */
public class ManageTeachers implements Serializable
{
  private ArrayList<Teacher> teachers;

  /**
   * No-argument constructor initializing the StudentList.
   */
  public ManageTeachers()
  {
    teachers = new ArrayList<Teacher>();
  }

  /**
   * Returns number of teachers in the ArrayList.
   */
  public int getNumberOfTeachers()
  {
    return teachers.size();
  }

  public ArrayList<Teacher> getTeachers()     //im not sure how to do that
  {
    return teachers;
  }

  /**
   * Adds a Teacher to the list.
   *
   * @param teacher the teacher to add to the list
   */
  public void addTeachers(Teacher teacher)
  {
    teachers.add(teacher);
  }

  /**
   * Removes a Student from the list.
   */
  public void removeTeacher(int index)
  {
    teachers.remove(index);
  }

  public int getNumberOfAvaliableTeachers()
  {
    int amount = 0;

    for (int i = 0; i < teachers.size(); i++)
    {
      if (teachers.get(i).isAvaliable() == true)
      {
        amount++;
      }
    }
    return amount;
  }

  public ArrayList<Teacher> getAvaliableTeachers()
  {
    ArrayList<Teacher> tempList = new ArrayList<Teacher>();
    for (int i = 0; i < teachers.size(); i++)
    {
      if (teachers.get(i).isAvaliable())
        tempList.add(teachers.get(i));
    }
    return tempList;
  }

  public Teacher getAllTeachers(int index)
  {
    if (index < teachers.size())
    {
      return teachers.get(index);
    }
    else
    {
      return null;
    }
  }

  public Teacher get(int index)
  {
    if (index < teachers.size())
    {
      return teachers.get(index);
    }
    else
    {
      return null;
    }
  }

}
