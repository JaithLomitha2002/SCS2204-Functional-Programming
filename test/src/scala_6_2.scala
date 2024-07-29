
import scala.io.StdIn.readLine
object scala_6_2 {
  
  def getStudentInfo(): (String, Int, Int, Double, Char) = {
    val name = readLine("Enter student's name\t: ").trim
    val marks = readLine("Enter student's marks\t: ").trim.toInt
    val totalMarks = readLine("Enter total possible marks: ").trim.toInt

    val (isValid, errorMessage) = validateInput(name, marks, totalMarks)
    if (!isValid) {
      throw new IllegalArgumentException(errorMessage.getOrElse("Invalid input"))
    }

    val percentage = (marks.toDouble / totalMarks) * 100
    val grade = calculateGrade(percentage)

    (name, marks, totalMarks, percentage, grade)
  }

  def printStudentRecord(studentRecord: (String, Int, Int, Double, Char)): Unit = {
    val (name, marks, totalMarks, percentage, grade) = studentRecord
    println(s"\nStudent Name: $name")
    println(s"Marks Obtained: $marks")
    println(s"Total Possible Marks: $totalMarks")
    println(f"Percentage: $percentage%.2f%%")
    println(s"Grade: $grade")
  }

  def validateInput(name: String, marks: Int, totalMarks: Int): (Boolean, Option[String]) = {
    if (name.isEmpty) {
      (false, Some("Name cannot be empty"))
    } else if (marks < 0 || marks > totalMarks) {
      (false, Some("Marks must be a positive integer and cannot exceed total possible marks"))
    } else if (totalMarks <= 0) {
      (false, Some("Total possible marks must be a positive integer"))
    } else {
      (true, None)
    }
  }

  def calculateGrade(percentage: Double): Char = {
    percentage match {
      case p if p >= 90 => 'A'
      case p if p >= 75 => 'B'
      case p if p >= 50 => 'C'
      case _ => 'D'
    }
  }

  def getStudentInfoWithRetry(): (String, Int, Int, Double, Char) = {
    var studentInfo: (String, Int, Int, Double, Char) = null
    var isValid = false

    while (!isValid) {
      try {
        studentInfo = getStudentInfo()
        isValid = true
      } catch {
        case e: IllegalArgumentException =>
          println(e.getMessage)
          println("Please try again.")
      }
    }

    studentInfo
  }

  def main(args: Array[String]): Unit = {
    val studentInfo = getStudentInfoWithRetry()
    printStudentRecord(studentInfo)
  }

}