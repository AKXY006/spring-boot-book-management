package jsp.springboot.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jsp.springboot.entity.Book;
import jsp.springboot.repository.BookRepository;



@RestController
class BookController {
	
	@Autowired
	private BookRepository bookRepository; 
	
	
//	@PostMapping("/book") 
//	public String saveBook(@RequestBody Book book) {                        // to save single record 
//		bookRepository.save(book);
//		return "Save the book record";
//	}
//	
//
//	@PostMapping("/book/all")
//    public String saveBookAll(@RequestBody List<Book> books) {              // to save multiple record at a time 
//		bookRepository.saveAll(books);
//		return "save all record";
//	}
//	
//	
//	@GetMapping("/book")
//	public List<Book> getAllBook(){                                       // to fetch the record from the db 
//		return bookRepository.findAll();
//	}
//
//	
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
//	
//
//	@PutMapping("/book")
//	public String updateBook(@RequestBody Book book) {                           
//		                                                                         //used to update the entire update // client should send entire object
//		//case 1 : ID not provided
//		if(book.getId()==null) {
//			return "Id Must Pass To Update The Record";
//		}
//		Optional<Book> option = bookRepository.findById(book.getId());
//		
//		//case 2 : Id Exist
//		if(option.isPresent()) {
//			bookRepository.save(book);
//			return "Book Record With Id : "+ book.getId()+" Updated";	
//		}
//		
//		//case 3 : ID does not exist
//		else {
//			return "Book Record With Id : "+ book.getId()+" Does Not Exist In DataBase";
//		}
//	}
//	
//	
//
//	@PatchMapping("/book/{id}")
//	public String updateBookRecord(@PathVariable Integer id, @RequestBody Map<String, Object> updates) {             // Used to update only specific record 
//	    Optional<Book> option = bookRepository.findById(id);                                               // the client send only the field that to be updated 
//
//	    if (option.isPresent()) {
//	        Book book = option.get();
//	        for (Map.Entry<String, Object> x : updates.entrySet()) {
//
//	            String key = x.getKey();
//	            Object value = x.getValue();
//
//	            switch (key) {
//
//	            case "title": book.setTitle((String) value);
//	                break;
//
//	            case "author": book.setAuthor((String) value);
//	                break;
//
//	            case "genre": book.setGenre((String) value);
//	                break;
//
//	            case "price": book.setPrice((Double) value);
//	                break;
//
//	            case "publishedYear":book.setPublishedYear((Integer) value);
//	                break;
//
//	            case "availability": book.setAvailability((Boolean) value);
//	                break;
//
//	            default: return "Invalid Field : " + key;
//	            }
//	        }
//	        bookRepository.save(book);
//	        return "Book Updated Successfully";
//	    }
//	    return "Book Not Found";
//	}
//	
//
//	@DeleteMapping("/book/{id}")
//	public String deleteRecord(@PathVariable Integer id) {                 // Delete Record 
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
}
