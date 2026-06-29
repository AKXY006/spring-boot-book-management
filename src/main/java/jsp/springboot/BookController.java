package jsp.springboot;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
class BookController {
	
	@Autowired
	private BookRepository bookRepository; 
	
//	@PostMapping("/book") 
//	public String saveBook(@RequestBody Book book) {                        // to save single record 
//		bookRepository.save(book);
//		return "Save the book record";
//	}
	
//	@PostMapping("/book")
//	public ResponseStructure<Book> saveBook(@RequestBody Book book) {
//
//	    Book savedBook = bookRepository.save(book);
//
//	    ResponseStructure<Book> response = new ResponseStructure<>();
//	    response.setStatusCode(201);
//	    response.setMessage("Book Saved Successfully");
//	    response.setData(savedBook);
//
//	    return response;
//	}
	
	
	@PostMapping("/book")
	public ResponseEntity<ResponseStructure<Book>> saveBook(@RequestBody Book book) {

	    Book savedBook = bookRepository.save(book);

	    ResponseStructure<Book> response = new ResponseStructure<>();
	    response.setStatusCode(201);
	    response.setMessage("Book Saved Successfully");
	    response.setData(savedBook);

	    return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	
	
	
	
//	@PostMapping("/book/all")
//    public String saveBookAll(@RequestBody List<Book> books) {              // to save multiple record at a time 
//		bookRepository.saveAll(books);
//		return "save all record";
//	}
	
	
//	@PostMapping("/book/all")
//	public ResponseStructure<List<Book>> saveBookAll(@RequestBody List<Book> books) {
//
//	    List<Book> savedBooks = bookRepository.saveAll(books);
//
//	    ResponseStructure<List<Book>> response = new ResponseStructure<>();
//
//	    response.setStatusCode(201);
//	    response.setMessage("All Books Saved Successfully");
//	    response.setData(savedBooks);
//
//	    return response;
//	}
	
	@PostMapping("/book/all")
	public ResponseEntity<ResponseStructure<List<Book>>> saveBookAll(@RequestBody List<Book> books) {

	    List<Book> savedBooks = bookRepository.saveAll(books);

	    ResponseStructure<List<Book>> response = new ResponseStructure<>();

	    response.setStatusCode(201);
	    response.setMessage("All Books Saved Successfully");
	    response.setData(savedBooks);

	    return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	
	
//	@GetMapping("/book")
//	public List<Book> getAllBook(){                                       // to fetch the record from the db 
//		return bookRepository.findAll();
//	}

	
//	@GetMapping("/book")
//	public ResponseStructure<List<Book>> getAllBook() {
//
//	    List<Book> books = bookRepository.findAll();
//
//	    ResponseStructure<List<Book>> response = new ResponseStructure<>();
//
//	    response.setStatusCode(200);
//	    response.setMessage("All Books Fetched Successfully");
//	    response.setData(books);
//
//	    return response;
//	}
	
	
	@GetMapping("/book")
	public ResponseEntity<ResponseStructure<List<Book>>> getAllBook() {

	    List<Book> books = bookRepository.findAll();

	    ResponseStructure<List<Book>> response = new ResponseStructure<>();

	    response.setStatusCode(200);
	    response.setMessage("All Books Fetched Successfully");
	    response.setData(books);

	    return ResponseEntity.ok(response);
	}
	
	
	
//	@GetMapping("/book/{id}")
//	public Book getBookId(@PathVariable Integer id) {                         // fetch record by id 
//		Optional<Book> option = bookRepository.findById(id);
//		
//		if(option.isPresent()) {
//			return option.get();
//		}
//		else {
//			return null;
//		}
//	}
	
//	@GetMapping("/book/{id}")
//	public ResponseStructure<Book> getBookById(@PathVariable Integer id) {
//
//	    Optional<Book> option = bookRepository.findById(id);
//
//	    ResponseStructure<Book> response = new ResponseStructure<>();
//
//	    if (option.isPresent()) {
//	        response.setStatusCode(200);
//	        response.setMessage("Book Found Successfully");
//	        response.setData(option.get());
//	    } else {
//	        response.setStatusCode(404);
//	        response.setMessage("Book Not Found");
//	        response.setData(null);
//	    }
//
//	    return response;
//	}
	
	@GetMapping("/book/{id}")
	public ResponseEntity<ResponseStructure<Book>> getBookById(@PathVariable Integer id) {

	    Optional<Book> option = bookRepository.findById(id);

	    ResponseStructure<Book> response = new ResponseStructure<>();

	    if (option.isPresent()) {
	        response.setStatusCode(200);
	        response.setMessage("Book Found Successfully");
	        response.setData(option.get());

	        return ResponseEntity.ok(response);
	    } else {
	        response.setStatusCode(404);
	        response.setMessage("Book Not Found");
	        response.setData(null);

	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	    }
	}
	
	
//	@PutMapping("/book")
//	public String updateBook(@RequestBody Book book) {                           
//		                                                                         //used to update the entire update // client should send entire object
//		//case 1 : ID not provided
//		
//		if(book.getId()==null) {
//			return "Id Must Pass To Update The Record";
//		}
//		Optional<Book> option = bookRepository.findById(book.getId());
//		
//		//case 2 : Id Exist
//		
//		if(option.isPresent()) {
//			bookRepository.save(book);
//			return "Book Record With Id : "+ book.getId()+" Updated";	
//		}
//		
//		//case 3 : ID does not exist
//		
//		else {
//			return "Book Record With Id : "+ book.getId()+" Does Not Exist In DataBase";
//		}
//	}
	
	
//	@PutMapping("/book")
//	public ResponseStructure<Book> updateBook(@RequestBody Book book) {
//
//	    ResponseStructure<Book> response = new ResponseStructure<>();
//
//	    if (book.getId() == null) {
//	        response.setStatusCode(400);
//	        response.setMessage("Id Must Be Passed To Update The Record");
//	        response.setData(null);
//	        return response;
//	    }
//
//	    Optional<Book> option = bookRepository.findById(book.getId());
//
//	    if (option.isPresent()) {
//
//	        Book updatedBook = bookRepository.save(book);
//
//	        response.setStatusCode(200);
//	        response.setMessage("Book Updated Successfully");
//	        response.setData(updatedBook);
//	    }
//
//	    else {
//
//	        response.setStatusCode(404);
//	        response.setMessage("Book Record With Id : " + book.getId() + " Does Not Exist");
//	        response.setData(null);
//	    }
//
//	    return response;
//	}
	
	@PutMapping("/book")
	public ResponseEntity<ResponseStructure<Book>> updateBook(@RequestBody Book book) {

	    ResponseStructure<Book> response = new ResponseStructure<>();

	    if (book.getId() == null) {
	        response.setStatusCode(400);
	        response.setMessage("Id Must Be Passed To Update The Record");
	        response.setData(null);

	        return ResponseEntity.badRequest().body(response);
	    }

	    Optional<Book> option = bookRepository.findById(book.getId());

	    if (option.isPresent()) {

	        Book updatedBook = bookRepository.save(book);

	        response.setStatusCode(200);
	        response.setMessage("Book Updated Successfully");
	        response.setData(updatedBook);

	        return ResponseEntity.ok(response);
	    }

	    else {

	        response.setStatusCode(404);
	        response.setMessage("Book Record With Id : " + book.getId() + " Does Not Exist");
	        response.setData(null);

	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	    }
	}
	
	
	
	
//	@PatchMapping("/book/{id}")
//	public String updateBookRecord(@PathVariable Integer id,              // Used to update only specific record 
//	        @RequestBody Map<String, Object> updates) {
//                                                                        // the client send only the field that to be updated 
//	    Optional<Book> option = bookRepository.findById(id);
//
//	    if (option.isPresent()) {
//
//	        Book book = option.get();
//
//	        for (Map.Entry<String, Object> x : updates.entrySet()) {
//
//	            String key = x.getKey();
//	            Object value = x.getValue();
//
//	            switch (key) {
//
//	            case "title":
//	                book.setTitle((String) value);
//	                break;
//
//	            case "author":
//	                book.setAuthor((String) value);
//	                break;
//
//	            case "genre":
//	                book.setGenre((String) value);
//	                break;
//
//	            case "price":
//	                book.setPrice((Double) value);
//	                break;
//
//	            case "publishedYear":
//	                book.setPublishedYear((Integer) value);
//	                break;
//
//	            case "availability":
//	                book.setAvailability((Boolean) value);
//	                break;
//
//	            default:
//	                return "Invalid Field : " + key;
//	            }
//	        }
//
//	        bookRepository.save(book);
//	        return "Book Updated Successfully";
//	    }
//
//	    return "Book Not Found";
//	}
	
	
//	@PatchMapping("/book/{id}")
//	public ResponseStructure<Book> updateBookRecord(@PathVariable Integer id,
//	        @RequestBody Map<String, Object> updates) {
//
//	    ResponseStructure<Book> response = new ResponseStructure<>();
//
//	    Optional<Book> option = bookRepository.findById(id);
//
//	    if (option.isPresent()) {
//
//	        Book book = option.get();
//
//	        for (Map.Entry<String, Object> x : updates.entrySet()) {
//
//	            String key = x.getKey();
//	            Object value = x.getValue();
//
//	            switch (key) {
//
//	            case "title":
//	                book.setTitle((String) value);
//	                break;
//
//	            case "author":
//	                book.setAuthor((String) value);
//	                break;
//
//	            case "genre":
//	                book.setGenre((String) value);
//	                break;
//
//	            case "price":
//	                book.setPrice((Double) value);
//	                break;
//
//	            case "publishedYear":
//	                book.setPublishedYear((Integer) value);
//	                break;
//
//	            case "availability":
//	                book.setAvailability((Boolean) value);
//	                break;
//
//	            default:
//	                response.setStatusCode(400);
//	                response.setMessage("Invalid Field : " + key);
//	                response.setData(null);
//	                return response;
//	            }
//	        }
//
//	        Book updatedBook = bookRepository.save(book);
//
//	        response.setStatusCode(200);
//	        response.setMessage("Book Updated Successfully");
//	        response.setData(updatedBook);
//
//	    } else {
//
//	        response.setStatusCode(404);
//	        response.setMessage("Book Not Found");
//	        response.setData(null);
//	    }
//
//	    return response;
//	}
	
	
	@PatchMapping("/book/{id}")
	public ResponseEntity<ResponseStructure<Book>> updateBookRecord(
	        @PathVariable Integer id,
	        @RequestBody Map<String, Object> updates) {

	    ResponseStructure<Book> response = new ResponseStructure<>();

	    Optional<Book> option = bookRepository.findById(id);

	    if (option.isPresent()) {

	        Book book = option.get();

	        for (Map.Entry<String, Object> x : updates.entrySet()) {

	            String key = x.getKey();
	            Object value = x.getValue();

	            switch (key) {

	            case "title":
	                book.setTitle((String) value);
	                break;

	            case "author":
	                book.setAuthor((String) value);
	                break;

	            case "genre":
	                book.setGenre((String) value);
	                break;

	            case "price":
	                book.setPrice((Double) value);
	                break;

	            case "publishedYear":
	                book.setPublishedYear((Integer) value);
	                break;

	            case "availability":
	                book.setAvailability((Boolean) value);
	                break;

	            default:
	                response.setStatusCode(400);
	                response.setMessage("Invalid Field : " + key);
	                response.setData(null);

	                return ResponseEntity.badRequest().body(response);
	            }
	        }

	        Book updatedBook = bookRepository.save(book);

	        response.setStatusCode(200);
	        response.setMessage("Book Updated Successfully");
	        response.setData(updatedBook);

	        return ResponseEntity.ok(response);

	    } else {

	        response.setStatusCode(404);
	        response.setMessage("Book Not Found");
	        response.setData(null);

	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	    }
	}

	
	
//	@DeleteMapping("/book/{id}")
//	public String deleteRecord(@PathVariable Integer id) {                 // Delete Record 
//		
//		Optional<Book> opt = bookRepository.findById(id);
//		
//		if(opt.isPresent()) {
//			bookRepository.delete(opt.get());
//			return "Deleted";
//		}
//		else {
//			return "Id Not Found";
//		}
//	}

	
//	@DeleteMapping("/book/{id}")
//	public ResponseStructure<String> deleteBook(@PathVariable Integer id){
//		
//	Optional<Book> opt = bookRepository.findById(id);
//	ResponseStructure<String>  res = new ResponseStructure<String>();
//	if(opt.isPresent()) {
//		bookRepository.delete(opt.get());
//		res.setStatusCode(HttpStatus.OK.value());
//		res.setMessage("Book record deleted successfully");
//		res.setData("Success");
//		return res;
//	}
//	else {
//		res.setStatusCode(HttpStatus.NOT_FOUND.value());
//		res.setMessage("Book record with id : "+id+" does not Exist.");
//		res.setData("failure");
//		return res;
//	}
//	}
//	
	
//	@DeleteMapping("/book/{id}")
//	public ResponseEntity<ResponseStructure<String>> deleteBook(@PathVariable Integer id) {
//
//	    Optional<Book> opt = bookRepository.findById(id);
//
//	    ResponseStructure<String> res = new ResponseStructure<>();
//
//	    if (opt.isPresent()) {
//
//	        bookRepository.delete(opt.get());
//
//	        res.setStatusCode(HttpStatus.OK.value());
//	        res.setMessage("Book record deleted successfully");
//	        res.setData("Success");
//
//	        return ResponseEntity.ok(res);
//
//	    } else {
//
//	        res.setStatusCode(HttpStatus.NOT_FOUND.value());
//	        res.setMessage("Book record with id : " + id + " does not exist.");
//	        res.setData("Failure");
//
//	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
//	    }
//	}
	
	
	
	@DeleteMapping("/book/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteBook(@PathVariable Integer id) {

	    Optional<Book> opt = bookRepository.findById(id);

	    ResponseStructure<String> res = new ResponseStructure<>();

	    if (opt.isPresent()) {

	        bookRepository.delete(opt.get());

	        res.setStatusCode(HttpStatus.OK.value());
	        res.setMessage("Book record deleted successfully");
	        res.setData("Success");

	        return ResponseEntity.ok(res);

	    } else {

	        throw new IdNotFoundException("Id Not Found In DB");
	    }  
	}
}
