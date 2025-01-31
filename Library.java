import java.lang.String;
class Book{
	Book(){
		borrowBooks();
		returnBook();
		displayBookInfo();
	}
	int book_id;
	String bookName, authorName;
	boolean availability;

	void borrowBooks(){
		System.out.println("Book is Borroewd.");
	}
	void returnBook(){
		System.out.println("Book is Returned.");
	}
	void displayBookInfo(){
		System.out.println("Info of book is displayed.");
	}
}
class Student{
	Student(){
		borrowBook();
		returnBook();
		displayBorrowedBooks();
	}

	int studentId;
	String name;
	Book[] borrowedBooks;
	
	void borrowBook(){
		System.out.println("Student is borrowing books.");
	}
	void returnBook(){
		System.out.println("Student is returning books.");
	}
	void displayBorrowedBooks(){
		System.out.println("Displaying the Borrowed books of student.");
	}
}

class Library{
	Library(){
		listAvailableBooks();
	}

	Book[] books_list ;
	books_List = new Book[5];

	void addBook(){
		
		System.out.println("Book is added.");
	}
	void removeBook(int i){
		bookslist
		System.out.println("Book is removed.");
	}
	void listAvailableBooks(){
		for (int i = 0; i < 5; i++){
			books_List[i].bookName;
		}
	}
	void findBook(){
		System.out.println("The book is being searched.");
	}
	public static void main(String[] args){
		Library mdh = new Library();
		Book bk = new Book();
		Student std = new Student();
	}
}
