public class Date
{
  private int day;
  private int month;
  private int year;
  private boolean availability;

  public Date(int day, int month, int year, boolean availability)
  {
    this.day = day;
    this.month = month;
    this.year=year;
    this.availability = availability;
  }

  public void setDay(int day)
  {
    this.day = day;
  }

  public int getDay()
  {
    return day;
  }

  public void setMonth(int month)
  {
    this.month = month;
  }

  public int getMonth()
  {
    return month;
  }

  public void setYear(int year)
  {
    this.year = year;
  }

  public int getYear()
  {
    return year;
  }

  public void setAvailability(boolean availability)
  {
    this.availability = availability;
  }
  public boolean getAvailability()
  {
    return availability;
  }
}
