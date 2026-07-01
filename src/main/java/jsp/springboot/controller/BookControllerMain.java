package jsp.springboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import jsp.springboot.service.BookService;

@RestController
public class BookControllerMain {
	
	@Autowired
	private BookService bookService;
	
	
	 @PostMapping("/book")
	    public ResponseEntity<ResponseStructure<Book>> saveBook(@RequestBody Book book) {     // to save single record
	        return bookService.saveBook(book);
	    }
	 
	 @PostMapping("/book/all")
	    public ResponseEntity<ResponseStructure<List<Book>>> saveBookAll(@RequestBody List<Book> books) {  //to save multiple record 
	        return bookService.saveBookAll(books);
	    }

	    @GetMapping("/book")
	    public ResponseEntity<ResponseStructure<List<Book>>> getAllBook() {  //to fetch all record
	        return bookService.getAllBook();
	    }

	    @GetMapping("/book/{id}")
	    public ResponseEntity<ResponseStructure<Book>> getBookById(@PathVariable Integer id) {   // to fetch record by id 
	        return bookService.getBookById(id);
	    }

	    @PutMapping("/book")
	    public ResponseEntity<ResponseStructure<Book>> updateBook(@RequestBody Book book) {      // update record
	        return bookService.updateBook(book);
	    }

	    @PatchMapping("/book/{id}")
	    public ResponseEntity<ResponseStructure<Book>> updateBookRecord(@PathVariable Integer id,@RequestBody Map<String, Object> updates) {   // update record 
	        return bookService.updateBookRecord(id, updates);
	    }

	    @DeleteMapping("/book/{id}")
	    public ResponseEntity<ResponseStructure<String>> deleteBook(@PathVariable Integer id) {   // delete record by id
	        return bookService.deleteBook(id);
	    }

}
