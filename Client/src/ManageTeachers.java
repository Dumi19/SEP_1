import java.util.ArrayList;

public class ManageTeachers
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

  public Teacher getTeachers()     //im not sure how to do that
  {
    return teachers;
  }

  public void addTeachers(Teacher teacher)
  {
    teachers.add(teacher);
  }

  public void removeTeacher(Teacher teacher)
  {
    teachers.remove(teacher);
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

  public Teacher getAvaliableTeachers()               //check
  {
    for (int i = 0; i <teachers.size() ; i++)
    {
      if (teachers.get(i).isAvaliable())
        return teachers.get(i);
    }
    return null;
  }







}
