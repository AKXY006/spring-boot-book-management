package jsp.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jsp.springboot.dto.ResponseStructure;
import jsp.springboot.entity.Book;
import jsp.springboot.exception.IdNotFoundException;
import jsp.springboot.repository.BookRepository;

@RestController
public class BookControllerCustomMethodApi {
	
	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping("/book/author/{author}")
	public ResponseEntity<ResponseStructure<List<Book>>>  getBookByAuthor(@PathVariable String author){
		List<Book> books = bookRepository.findByAuthor(author);
		
		ResponseStructure<List<Book>> res = new ResponseStructure<List<Book>>();
		
		if(!books.isEmpty()) {
			res.setStatusCode(HttpStatus.OK.value());
			res.setMessage("Book record with author "+author + " retrieved");
		    res.setData(books);
		    
		    return new ResponseEntity<>(res,HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("Book record with author "+author +" does Not Exist");
		}
	}
	
	
	
	@GetMapping("/book/{title}/{author}")
	public ResponseEntity<ResponseStructure<Book>> getBookByTitleAndAuthor(
	        @PathVariable String title,
	        @PathVariable String author) {

	    Book book = bookRepository.findByTitleAndAuthor(title, author);

	    ResponseStructure<Book> res = new ResponseStructure<>();

	    res.setStatusCode(HttpStatus.OK.value());
	    res.setMessage("Book Retrieved Successfully");
	    res.setData(book);

	    return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
  
	
}
