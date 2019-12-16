import java.io.FileNotFoundException;
import java.io.IOException;

public class RoomFileAdapter
{

    private MyFileIO mfio;
    private String fileName;


    public RoomFileAdapter(String fileName)
    {
      mfio = new MyFileIO();
      this.fileName = fileName;
    }

    /**
     * Uses the MyFileIO class to retrieve a StudentList object with all Students.
     * @return a StudentList object with all stored students
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


    public void changeRoom(int any, int roomNumber, int seatsNumber, boolean isItEquiped, boolean isItFree)
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


  public void addTeacherToArray(int roomNumber, int seatsNumber, boolean isItEquiped, boolean isItFree)
  {
    ManageRooms rooms = getAllRooms();


    rooms.addRoom(new Room(roomNumber, seatsNumber, isItEquiped, isItFree));
    saveRoom(rooms);
  }


    // Add more methods to the adapter depending on what you wish to do
  }
