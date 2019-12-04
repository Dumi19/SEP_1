import java.util.ArrayList;

public class ManageDate
{
  private ArrayList<Date> dates = new ArrayList<>();

  public ManageDate()
  {
    ArrayList<Date> dates = new ArrayList<>();
  }

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

