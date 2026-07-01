package jsp.springboot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.springboot.dto.ResponseStructure;
import jsp.springboot.entity.Book;
import jsp.springboot.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	 public ResponseEntity<ResponseStructure<Book>> saveBook(Book book) {          //save sing record 

	        Book savedBook = bookRepository.save(book);

	        ResponseStructure<Book> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.CREATED.value());
	        response.setMessage("Book Saved Successfully");
	        response.setData(savedBook);

	        return new ResponseEntity<>(response, HttpStatus.CREATED);
	    }

	 
	 
//	 public ResponseEntity<ResponseStructure<List<Book>>>  SaveAllBook(List<Book> books){
//		 List<Book> saveBooks = 
//	 }
}
 
