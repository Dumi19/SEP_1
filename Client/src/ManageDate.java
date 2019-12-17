import java.util.ArrayList;

public class ManageDate
{
  private ArrayList<Date> dates;

  /**
   * No-argument constructor initializing the StudentList.
   */
  public ManageDate()
  {
    dates = new ArrayList<Date>();
  }

  /**
   * Gets a Date object from position index from the list.
   * @param index the position in the list of the Date object
   * @return the Date object at position index if one exists, else null
   */
  public Date getAllDates()                 //We have to check it
  {
    for (int i = 0; i <dates.size() ; i++)
    {
      dates.get(i);
    }
    return null;
  }


  public void addDate(Date date)
  {
    dates.add(date);
  }

  public void removeDate(int index)
  {
    dates.remove(index-1);   //should -1 be there?
  }

  public void setAvailability(int index)
  {
    dates.get(index-1).setAvailability(true);
  }

  public boolean getAvailability(int index)
  {
    return dates.get(index-1).getAvailability();
  }

}

