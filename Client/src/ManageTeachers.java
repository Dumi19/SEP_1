import java.io.Serializable;
import java.util.ArrayList;

public class ManageTeachers  implements Serializable
{
  private ArrayList<Teacher>teachers;

  public ManageTeachers()
  {
    teachers = new ArrayList<Teacher>();
  }
  public int getNumberOfTeachers()
  {
    return teachers.size();
  }

  public ArrayList<Teacher> getTeachers()     //im not sure how to do that
  {
    return teachers;
  }

  public void addTeachers(Teacher teacher)
  {
    teachers.add(teacher);
  }

  public void removeTeacher(int index)
  {
    teachers.remove(index);
  }

  public int getNumberOfAvaliableTeachers() //check
  {
    int amount = 0;

    for (int i = 0; i <teachers.size() ; i++)
    {
      if (teachers.get(i).isAvaliable()==true)
      {
        amount++;
      }
    }
    return amount;
  }

  public ArrayList<Teacher> getAvaliableTeachers()               //check
  {
    ArrayList<Teacher> tempList = new ArrayList<Teacher>();
    for (int i = 0; i <teachers.size() ; i++)
    {
      if (teachers.get(i).isAvaliable())
        tempList.add(teachers.get(i));
    }
    return tempList;
  }

  public Teacher getAllTeachers(int index)
  {
    if(index<teachers.size())
    {
      return teachers.get(index);
    }
    else
    {
      return null;
    }
  }







}
