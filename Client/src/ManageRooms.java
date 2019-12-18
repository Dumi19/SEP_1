import java.io.Serializable;
import java.util.ArrayList;

public class ManageRooms implements Serializable
{
    private ArrayList<Room> rooms;

    /**
     * No-argument constructor initializing the StudentList.
     */
    public ManageRooms() {
        rooms = new ArrayList<Room>();
    }

    /**
     * Returns number of rooms in the ArrayList.
     */
    public int getNumberOfRooms() {
        return rooms.size();
    }

    /**
     * Adds a Room to the list.
     * @param room the student to add to the list
     */
    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void removeRoom(int index) {
        rooms.remove(index);
    }

    public Room getRoom(int index) {
        return rooms.get(index - 1);
    }

    public ArrayList<Room> getAllRooms() //i dont know how to do it
    {
        return rooms;
    }

    public int getNumberOfFreeRooms()    //return statement
    {
        int amount = 0;
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).isItFree())
                amount++;
        }
        return amount;
    }

    public int getNumberOfEquipedRooms()    //return statement
    {
        int amount = 0;
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).isItEquiped())
                amount++;
        }
        return amount;
    }

    public ArrayList<Room> getFreeRooms()        //return statement
    {
        ArrayList<Room> tempList = new ArrayList<Room>();
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).isItFree())
                tempList.add(rooms.get(i));
        }
        return tempList;
    }

    public ArrayList<Room> getEquipedRooms()       //return statement
    {
        ArrayList<Room> tempList = new ArrayList<Room>();
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).isItEquiped())
                tempList.add(rooms.get(i));
        }
        return tempList;
    }

    /**
     * Gets a Room object from position index from the list.
     * @param index the position in the list of the Room object
     * @return the Room object at position index if one exists, else null
     */
    public Room getAllRooms(int index)
    {
        if(index<rooms.size())
        {
            return rooms.get(index);
        }
        else
        {
            return null;
        }
    }

    public Room get(int index)
    {
        if(index<rooms.size())
        {
            return rooms.get(index);
        }
        else
        {
            return null;
        }
    }


}
