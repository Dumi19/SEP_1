import java.io.Serializable;

/**
 * A class representing a room with a room number, number of seats, equipment and availability.
 * @author SEP Killers
 * @version 1.0
 */
public class Room implements Serializable
{
  private int roomNumber;
  private int seatsNumber;
  private boolean isItEquiped;
  private boolean isItFree;

  /**
   * Four-argument constructor.
   * @param roomNumber the room's number
   * @param seatsNumber the number of seats in room
   * @param isItEquiped the room's equipment
   * @param isItFree the room's availability
   */
  public Room(int roomNumber, int seatsNumber, boolean isItEquiped, boolean isItFree)
  {
    this.roomNumber = roomNumber;
    this.seatsNumber = seatsNumber;
    this.isItEquiped = isItEquiped;
    this.isItFree = isItFree;
  }

  /**
   * Sets the room's equipment.
   * @param isItEquiped what the rooms's equipment will be set to
   */
  public void setItEquiped(boolean isItEquiped)
  {
    this.isItEquiped = isItEquiped;
  }

  /**
   * Gets the room's number.
   * @return the room's number
   */
  public int getRoomNumber()
  {
    return roomNumber;
  }

  /**
   * Gets the room's number of seats.
   * @return the room's number of seats
   */
  public int getSeatsNumber()
  {
    return seatsNumber;
  }

  /**
   * Sets the room's availability.
   * @param isItFree what the room's availability
   */
  public void setItFree(boolean isItFree)
  {
    this.isItFree = isItFree;
  }

  /**
   * Gets the room's equipment.
   * @return the room's equipment
   */
  public boolean isItEquiped()
  {
    return isItEquiped;
  }

  /**
   * Sets the room's number.
   * @param roomNumber what the room's number will be set to
   */
  public void setRoomNumber(int roomNumber)
  {
    this.roomNumber = roomNumber;
  }

  /**
   * Sets the room's seats number.
   * @param seatsNumber what the room's number of seats will be set to
   */
  public void setSeatsNumber(int seatsNumber)
  {
    this.seatsNumber = seatsNumber;
  }

  /**
   * Gets the room's availability.
   * @return the room availability
   */
  public boolean isItFree()
  {
    return isItFree;
  }

  /**
   * Returns a string representation of the room.
   * @return a string representation of the room in the format: "roomNumber seatsNumber isItEquiped isItFree"
   */
  public String toString()
  {
    return roomNumber+" /"+" "+seatsNumber+" /"+" "+isItEquiped+" /"+" "+isItFree;
  }
}
