package jsp.springboot.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.springboot.dto.ResponseStructure;
import jsp.springboot.entity.Book;
import jsp.springboot.repository.BookRepository;

@Service
public class BookService {
	
	private BookRepository bookRepository;
	
	public ResponseEntity<Book> SaveBook(Book book){
		
		Book savedBook = bookRepository.save(book);

	    ResponseStructure<Book> response = new ResponseStructure<>();
	    response.setStatusCode(201);
	    response.setMessage("Book Saved Successfully");
	    response.setData(savedBook);

		
	}

}
