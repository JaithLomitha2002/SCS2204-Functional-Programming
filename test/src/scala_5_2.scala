import scala.collection.mutable
import scala.io.StdIn.readLine

case class Book(title: String, author: String, isbn: String)

object scala_5_2 {
  val library: mutable.Set[Book] = mutable.Set(
    Book("ABCD", "George Well", "0000"),
    Book("Mockingbird", "Harper Lee", "1111"),
    Book("The Great Day", "Rumain Cooray", "2222")
  )

  def addBook(book: Book): Unit = {
    if (library.exists(_.isbn == book.isbn)) {
      println("A book with this ISBN already exists in the library.")
    } else {
      library.add(book)
      println(s"Book '${book.title}' by ${book.author} added to the library.")
    }
  }

  def removeBook(isbn: String): Unit = {
    val bookOpt = library.find(_.isbn == isbn)
    bookOpt match {
      case Some(book) =>
        library.remove(book)
        println(s"Book '${book.title}' by ${book.author} removed from the library.")
      case None =>
        println("No book found with the given ISBN.")
    }
  }

  def isBookInLibrary(isbn: String): Boolean = {
    library.exists(_.isbn == isbn)
  }

  def displayLibrary(): Unit = {
    println("Current Library Collection:")
    library.foreach(book => println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"))
  }

  def searchBookByTitle(title: String): Unit = {
    val books = library.filter(_.title.equalsIgnoreCase(title))
    if (books.nonEmpty) {
      books.foreach(book => println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"))
    } else {
      println("No book found with the given title.")
    }
  }

  def displayBooksByAuthor(author: String): Unit = {
    val books = library.filter(_.author.equalsIgnoreCase(author))
    if (books.nonEmpty) {
      books.foreach(book => println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"))
    } else {
      println("No books found by the given author.")
    }
  }

  def main(args: Array[String]): Unit = {
    var continue = true

    while (continue) {
      println("\n-------Library Management System-------")
      println("1. Display Library Collection")
      println("2. Add a Book")
      println("3. Remove a Book")
      println("4. Search Book by Title")
      println("5. Display Books by Author")
      println("6. Exit")
      println("Enter your choice:")

      val choice = readLine().toInt

      choice match {
        case 1 =>
          displayLibrary()
        case 2 =>
          println("Enter book title:")
          val title = readLine()
          println("Enter book author:")
          val author = readLine()
          println("Enter book ISBN:")
          val isbn = readLine()
          addBook(Book(title, author, isbn))
        case 3 =>
          println("Enter book ISBN to remove:")
          val isbn = readLine()
          removeBook(isbn)
        case 4 =>
          println("Enter book title to search:")
          val title = readLine()
          searchBookByTitle(title)
        case 5 =>
          println("Enter author to display books:")
          val author = readLine()
          displayBooksByAuthor(author)
        case 6 =>
          continue = false
        case _ =>
          println("Invalid choice!!! Please try again.")
      }
    }
  }
}