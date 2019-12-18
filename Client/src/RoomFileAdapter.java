import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * An adapter to the rooms list file, making it easy to retrieve and store information.
 *
 * @author SEP Killers
 * @version 1.0
 */
public class RoomFileAdapter
{

  private MyFileIO mfio;
  private String fileName;

  /**
   * 1-argument constructor setting the file name.
   *
   * @param fileName the name and path of the file where rooms will be saved and retrieved
   */
  public RoomFileAdapter(String fileName)
  {
    mfio = new MyFileIO();
    this.fileName = fileName;
  }

  /**
   * Uses the MyFileIO class to retrieve a RoomsList object with all Rooms.
   *
   * @return a RoomsList object with all stored rooms
   */
  public ManageRooms getAllRooms()
  {
    ManageRooms rooms = new ManageRooms();

    try
    {
      rooms = (ManageRooms) mfio.readObjectFromFile(fileName);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
    }
    return rooms;
  }

  /**
   * Use the MyFileIO class to save some teachers.
   *
   * @param rooms the list of teachers that will be saved
   */
  public void saveRoom(ManageRooms rooms)
  {
    try
    {
      mfio.writeToFile(fileName, rooms);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error writing to file");
    }
  }

  /**
   * Uses the MyFileIO class to change the room number, seats number, equipment(available or not), availability
   *
   * @param any         the room's index in the array list
   * @param roomNumber  number of the room
   * @param seatsNumber number of seats in room
   * @param isItEquiped equipment of the room
   * @param isItFree    availability of the room
   */
  public void changeRoom(int any, int roomNumber, int seatsNumber,
      boolean isItEquiped, boolean isItFree)
  {
    ManageRooms rooms = getAllRooms();
    rooms.getAllRooms(any).setRoomNumber(roomNumber);
    rooms.getAllRooms(any).setSeatsNumber(seatsNumber);
    rooms.getAllRooms(any).setItEquiped(isItEquiped);
    rooms.getAllRooms(any).setItFree(isItFree);
      /*for (int i = 0; i < students.getNumberOfStudents(); i++)
      {
         Student student = students.getAllStudents(i);

            student.setStudentID(studentNumber);
            student.setCourseCode(classNumber);

      }*/
    saveRoom(rooms);
  }

  public void addRoomToArray(int roomNumber, int seatsNumber,
      boolean isItEquiped, boolean isItFree)
  {
    ManageRooms rooms = getAllRooms();

    rooms.addRoom(new Room(roomNumber, seatsNumber, isItEquiped, isItFree));
    saveRoom(rooms);
  }

  public void removeRoomFromArray(int roomNumber, int seatsNumber,
      boolean isItEquiped, boolean isItFree)
  {
    ManageRooms rooms = getAllRooms();

    for (int i = 0; i < rooms.getNumberOfRooms(); i++)
    {
      if (rooms.getAllRooms(i).getRoomNumber() == roomNumber
          && rooms.getAllRooms(i).isItFree() == isItFree
          && rooms.getAllRooms(i).isItEquiped() == isItEquiped)
      {
        rooms.removeRoom(i);
      }
    }

    saveRoom(rooms);
  }

  // Add more methods to the adapter depending on what you wish to do
}
