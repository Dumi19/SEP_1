import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * A simple program used for importing data. It reads a text file with room
 * information, creates a RoomList object with all rooms read from the file,
 * and saves it as a binary file. The text file must have information of one room
 * on each line, and each line should be in the format: roomNumber, seatsNumber, isItEquiped, isItFree
 *
 * @author SEP group 7
 * @version 1.0
 */
public class LoadInitialDataRooms
{

  public static void main(String[] args)
  {
    ManageRooms rooms = new ManageRooms();

    MyTextFileIO mtfio = new MyTextFileIO();
    String[] roomsArray = null;
    try
    {
      roomsArray = mtfio.readArrayFromFile("Client/RoomsList.txt");

      for (int i = 0; i < roomsArray.length; i++)
      {
        String temp = roomsArray[i];
        String[] tempArr = temp.split(",");
        int roomNumber = Integer.parseInt(tempArr[0]);
        int seatsNumber = Integer.parseInt(tempArr[1]);
        boolean isItEquiped = Boolean.parseBoolean(tempArr[2]);
        boolean isItFree = Boolean.parseBoolean(tempArr[3]);

        rooms.addRoom(new Room(roomNumber, seatsNumber, isItEquiped, isItFree));
      }
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File was not found, or could not be opened");
    }

    MyFileIO mfio = new MyFileIO();

    try
    {
      mfio.writeToFile("Client/RoomsList.bin", rooms);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("Error opening file ");
    }
    catch (IOException e)
    {
      System.out.println("IO Error writing to file ");
    }

    System.out.println("Done");
  }
}