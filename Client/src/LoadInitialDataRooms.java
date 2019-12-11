import java.io.FileNotFoundException;
import java.io.IOException;

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

        for(int i = 0; i<roomsArray.length; i++)
        {
          String temp = roomsArray[i];
          String[] tempArr = temp.split(",");
          int roomNumber = tempArr[0];
          int seatsNumber = tempArr[1];
          boolean isItEquiped = tempArr[2];
          boolean isItFree = tempArr[3];


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
        mfio.writeToFile("Client/studentsList.bin", rooms);
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