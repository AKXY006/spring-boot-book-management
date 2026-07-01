package jsp.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.springboot.dto.ResponseStructure;
import jsp.springboot.entity.Book;
import jsp.springboot.exception.IdNotFoundException;
import jsp.springboot.exception.NoRecordAvailableException;
import jsp.springboot.repository.BookRepository;

@Service
public class BookServiceForCustomMenthod {
	
	@Autowired
	private BookRepository bookRepository;
	
	public ResponseEntity<ResponseStructure<List<Book>>> getBookByAuthor(String author) {
	    List<Book> bookList = bookRepository.findByAuthor(author);
	    if (bookList.isEmpty()) {
	        throw new IdNotFoundException("Book record with author " + author + " does not exist");                    //Fetch Book By Author
	    }
	    ResponseStructure<List<Book>> response = new ResponseStructure<>();
	    response.setStatusCode(HttpStatus.OK.value());
	    response.setMessage("Book record with author " + author + " retrieved successfully");
	    response.setData(bookList);

	    return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	
	
	public ResponseEntity<ResponseStructure<Book>> getBookByTitleAndAuthor(String title, String author) {          //Fetch Book By Title And Author
	    Optional<Book> bookOptional = bookRepository.findByTitleAndAuthor(title, author);
	    if (bookOptional.isEmpty()) {
	        throw new IdNotFoundException("Book record with title " + title + " and author " + author + " does not exist");
	    }  
	    ResponseStructure<Book> response = new ResponseStructure<>(); 
	    response.setStatusCode(HttpStatus.OK.value());
	    response.setMessage("Book retrieved successfully");
	    response.setData(bookOptional.get());

	    return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	
	
	public ResponseEntity<ResponseStructure<List<Book>>> getBookByPriceGreaterThan(double price) {  //Fetch Book By Price GreaterThan ....
	    List<Book> bookList = bookRepository.findByPriceGreaterThan(price);
	    if (bookList.isEmpty()) {
	        throw new NoRecordAvailableException("No books found with price greater than " + price);
	    }
	    ResponseStructure<List<Book>> response = new ResponseStructure<>();
	    response.setStatusCode(HttpStatus.OK.value());
	    response.setMessage("Books retrieved successfully");
	    response.setData(bookList);

	    return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	
	public ResponseEntity<ResponseStructure<List<Book>>> getBookByPriceBetween(double startPrice, double endPrice) {     //Fetch Book By Price Between
	    List<Book> bookList = bookRepository.findByPriceBetween(startPrice, endPrice);
	    if (bookList.isEmpty()) {
	        throw new NoRecordAvailableException("No books found between " + startPrice + " and " + endPrice);
	    }
	    ResponseStructure<List<Book>> response = new ResponseStructure<>();
	    response.setStatusCode(HttpStatus.OK.value());
	    response.setMessage("Books retrieved successfully");
	    response.setData(bookList);

	    return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	
	public ResponseEntity<ResponseStructure<List<Book>>> getBookByAvailability() {        //Fetch Available Book
	    List<Book> bookList = bookRepository.getBookByAvailability();
	    if (bookList.isEmpty()) {
	        throw new NoRecordAvailableException("No available books found");
	    }
	    ResponseStructure<List<Book>> response = new ResponseStructure<>();
	    response.setStatusCode(HttpStatus.OK.value());
	    response.setMessage("Available books retrieved successfully");
	    response.setData(bookList);

	    return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	
	public ResponseEntity<ResponseStructure<List<Book>>> getBookByYear(Integer publishedYear) {     // Fetch Book By PublishedYear
	    List<Book> bookList = bookRepository.getBookByYear(publishedYear);
	    if (bookList.isEmpty()) {
	        throw new NoRecordAvailableException("No books found for published year " + publishedYear);
	    }
	    ResponseStructure<List<Book>> response = new ResponseStructure<>();
	    response.setStatusCode(HttpStatus.OK.value());
	    response.setMessage("Books retrieved successfully");
	    response.setData(bookList);

	    return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	
	
	public ResponseEntity<ResponseStructure<List<Book>>> getBookByGenre(String genre) {    // Fetch Book By Genre
	    List<Book> bookList = bookRepository.getBookbyGenre(genre);
	    if (bookList.isEmpty()) {
	        throw new NoRecordAvailableException("No books found for genre " + genre);
	    }
	    ResponseStructure<List<Book>> response = new ResponseStructure<>();
	    response.setStatusCode(HttpStatus.OK.value());
	    response.setMessage("Books retrieved successfully");
	    response.setData(bookList);

	    return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
