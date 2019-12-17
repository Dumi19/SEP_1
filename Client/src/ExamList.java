import java.io.Serializable;
import java.util.ArrayList;

public class ExamList implements Serializable
{

  private ArrayList<Exam> exams;

  /**
   * No-argument constructor initializing the ExamList.
   */
  public ExamList()
  {
    exams = new ArrayList<Exam>();
  }

  /**
   * Gets a Student object from position index from the list.
   *
   * @param index the position in the list of the Student object
   * @return the Student object at position index if one exists, else null
   */
  public Exam getAllExams(int index)
  {
    if (index < exams.size())
    {
      return exams.get(index);
    }
    else
    {
      return null;
    }
  }

  /**
   * Adds a Exam to the list.
   *
   * @param exam the student to add to the list
   */
  public void addExam(Exam exam)
  {

    exams.add(exam);
  }

  /**
   * Removes a Student from the list.
   */
  public void removeExam(int index)
  {
    exams.remove(index);
  }

  /**
   * Returns number of students in the ArrayList.
   */
  public int getNumberOfExams()
  {
    return exams.size();
  }

}



