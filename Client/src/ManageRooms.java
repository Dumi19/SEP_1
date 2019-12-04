import java.util.ArrayList;

public class ManageRooms
{
  private ArrayList<Room> rooms;

  public ManageRooms()
  {
    rooms = new ArrayList<Room>();
  }

  public int getNumberOfRooms()
  {
    return rooms.size();
  }

  public void addRoom(Room room)
  {
    rooms.add(room);
  }

  public void removeRoom(Room room)
  {
    rooms.remove(room);
  }

  public Room getRoom(int index)
  {
    return rooms.get(index-1);
  }

  public Room getAllRooms() //i dont know how to do it
  {
    return rooms;
  }

  public int getNumberOfFreeRooms()    //return statement
  {
    int amount =0;
    for (int i = 0; i <rooms.size() ; i++)
    {
      if (rooms.get(i).isItFree())
        amount++;
    }
    return amount;
  }

  public int getNumberOfEquipedRooms()    //return statement
  {
    int amount =0;
    for (int i = 0; i <rooms.size() ; i++)
    {
      if (rooms.get(i).isItEquiped())
        amount++;
    }
    return amount;
  }

  public Room getFreeRooms()        //return statement
  {
    for (int i = 0; i < rooms.size(); i++)
    {
      if (rooms.get(i).isItFree())
        return rooms.get(i);
    }
    return null;
  }

  public Room getEquipedRooms()       //return statement
  {
    for (int i = 0; i <rooms.size() ; i++)
    {
      if (rooms.get(i).isItEquiped())
        return rooms.get(i);
    }
  }


}
