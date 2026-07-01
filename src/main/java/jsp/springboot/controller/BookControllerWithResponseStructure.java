package jsp.springboot.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jsp.springboot.dto.ResponseStructure;
import jsp.springboot.entity.Book;
import jsp.springboot.repository.BookRepository;

@RestController
public class BookControllerWithResponseStructure {
	
	@Autowired
	private BookRepository bookRepository;
	
	@PostMapping("/book")
	public ResponseStructure<Book> saveBook(@RequestBody Book book) {               //to save a single record
	    Book savedBook = bookRepository.save(book);
	    ResponseStructure<Book> response = new ResponseStructure<>();
	    
	    response.setStatusCode(201);
	    response.setMessage("Book Saved Successfully");
	    response.setData(savedBook);
	    return response;
	}
	
	
	@PostMapping("/book/all")
	public ResponseStructure<List<Book>> saveBookAll(@RequestBody List<Book> books) {             //to save multiple record
	    List<Book> savedBooks = bookRepository.saveAll(books);
	    ResponseStructure<List<Book>> response = new ResponseStructure<>();
	    
	    response.setStatusCode(201);
	    response.setMessage("All Books Saved Successfully");
	    response.setData(savedBooks);
	    return response;
	}
	
	
	@GetMapping("/book")
	public ResponseStructure<List<Book>> getAllBook() {                                         //to fetch all the record
	    List<Book> books = bookRepository.findAll();
	    ResponseStructure<List<Book>> response = new ResponseStructure<>();
	    
	    response.setStatusCode(200);
	    response.setMessage("All Books Fetched Successfully");
	    response.setData(books);
	    return response;
	}
	
	
	@GetMapping("/book/{id}")
	public ResponseStructure<Book> getBookById(@PathVariable Integer id) {                   //fetch by id 
	    Optional<Book> option = bookRepository.findById(id);
	    ResponseStructure<Book> response = new ResponseStructure<>();

	    if (option.isPresent()) {
	        response.setStatusCode(200);
	        response.setMessage("Book Found Successfully");
	        response.setData(option.get());
	    } else {
	        response.setStatusCode(404);
	        response.setMessage("Book Not Found");
	        response.setData(null);
	    }
	    return response;
	}
	
	
	@PutMapping("/book")
	public ResponseStructure<Book> updateBook(@RequestBody Book book) {            //used to update the entire update // client should send entire object
	    ResponseStructure<Book> response = new ResponseStructure<>();

	    if (book.getId() == null) {
	        response.setStatusCode(400);
	        response.setMessage("Id Must Be Passed To Update The Record");
	        response.setData(null);
	        return response;
	    }
	    Optional<Book> option = bookRepository.findById(book.getId());

	    if (option.isPresent()) {
	        Book updatedBook = bookRepository.save(book);

	        response.setStatusCode(200);
	        response.setMessage("Book Updated Successfully");
	        response.setData(updatedBook);
	    }
	    else {
	        response.setStatusCode(404);
	        response.setMessage("Book Record With Id : " + book.getId() + " Does Not Exist");
	        response.setData(null);
	    }
	    return response;
	}
	
	
	
	@PatchMapping("/book/{id}")
	public ResponseStructure<Book> updateBookRecord(@PathVariable Integer id, @RequestBody Map<String, Object> updates) {
	    ResponseStructure<Book> response = new ResponseStructure<>();      
	    Optional<Book> option = bookRepository.findById(id);

	    if (option.isPresent()) {
	        Book book = option.get();  
	        for (Map.Entry<String, Object> x : updates.entrySet()) {                  // Used to update only specific record
	            String key = x.getKey();
	            Object value = x.getValue();

	            switch (key) {

	            case "title": book.setTitle((String) value);
	                break;

	            case "author": book.setAuthor((String) value);
	                break;

	            case "genre": book.setGenre((String) value);
	                break;

	            case "price": book.setPrice((Double) value);
	                break;

	            case "publishedYear": book.setPublishedYear((Integer) value);
	                break;

	            case "availability": book.setAvailability((Boolean) value);
	                break;

	            default:
	                response.setStatusCode(400);
	                response.setMessage("Invalid Field : " + key);
	                response.setData(null);
	                return response;
	            }
	        }

	        Book updatedBook = bookRepository.save(book);

	        response.setStatusCode(200);
	        response.setMessage("Book Updated Successfully");
	        response.setData(updatedBook);

	    } else {
	        response.setStatusCode(404);
	        response.setMessage("Book Not Found");
	        response.setData(null);
	    }
	    return response;
	}
	
	
	
	
	@DeleteMapping("/book/{id}")
	public ResponseStructure<String> deleteBook(@PathVariable Integer id){	
	Optional<Book> opt = bookRepository.findById(id);                          //delete record by id
	ResponseStructure<String>  res = new ResponseStructure<String>();
	
	if(opt.isPresent()) {
		bookRepository.delete(opt.get());
		res.setStatusCode(HttpStatus.OK.value());
		res.setMessage("Book record deleted successfully");
		res.setData("Success");
		return res;
	}
	else {
		res.setStatusCode(HttpStatus.NOT_FOUND.value());
		res.setMessage("Book record with id : "+id+" does not Exist.");
		res.setData("failure");
		return res;
	}
	}
}
