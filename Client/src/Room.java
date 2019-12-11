import java.io.Serializable;

public class Room implements Serializable
{
  private int roomNumber;
  private int seatsNumber;
  private boolean isItEquiped;
  private boolean isItFree;

  public Room(int roomNumber, int seatsNumber, boolean isItEquiped, boolean isItFree)
  {
    this.roomNumber = roomNumber;
    this.seatsNumber = seatsNumber;
    this.isItEquiped = isItEquiped;
    this.isItFree = isItFree;
  }

  public void setItEquiped(boolean isItEquiped)
  {
    this.isItEquiped = isItEquiped;
  }

  public int getRoomNumber()
  {
    return roomNumber;
  }

  public int getSeatsNumber()
  {
    return seatsNumber;
  }

  public void setItFree(boolean isItFree)
  {
    this.isItFree = isItFree;
  }

  public boolean isItEquiped()
  {
    return isItEquiped;
  }

  public void setRoomNumber(int roomNumber)
  {
    this.roomNumber = roomNumber;
  }

  public void setSeatsNumber(int seatsNumber)
  {
    this.seatsNumber = seatsNumber;
  }

  public boolean isItFree()
  {
    return isItFree;
  }

  public String toString()
  {
    return roomNumber+" "+seatsNumber+" "+isItEquiped+" "+isItFree;
  }
}
