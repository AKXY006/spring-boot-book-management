package jsp.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jsp.springboot.dto.ResponseStructure;
import jsp.springboot.entity.Book;
import jsp.springboot.service.BookServiceForCustomMenthod;

@RestController
public class BookControllerCustomMethodApi {
	

	
	@Autowired
	private BookServiceForCustomMenthod bookService;
	
	
	@GetMapping("/book/author/{author}")
	public ResponseEntity<ResponseStructure<List<Book>>> getBookByAuthor(@PathVariable String author) {    //  Fetch Book By Author
	    return bookService.getBookByAuthor(author);
	}


	@GetMapping("/book/{title}/{author}")
	public ResponseEntity<ResponseStructure<Book>> getBookByTitleAndAuthor(@PathVariable String title, @PathVariable String author) {    //  Fetch Book By Title And Author
	    return bookService.getBookByTitleAndAuthor(title, author);
	}


	
	@GetMapping("/book/pricegreater/{price}")
	public ResponseEntity<ResponseStructure<List<Book>>> getBookByPriceGreaterThan(@PathVariable double price) {     //  Fetch Books By Price Greater Than
	    return bookService.getBookByPriceGreaterThan(price);
	}


	
	@GetMapping("/book/pricebetween/{startPrice}/{endPrice}")                                       
	public ResponseEntity<ResponseStructure<List<Book>>> getBookByPriceBetween(@PathVariable double startPrice, @PathVariable double endPrice) {   // Fetch Books Between Price Range
	    return bookService.getBookByPriceBetween(startPrice, endPrice);
	}



	@GetMapping("/book/availability")
	public ResponseEntity<ResponseStructure<List<Book>>> getBookByAvailability() {   	//Fetch Available Books
	    return bookService.getBookByAvailability();
	}


	
	@GetMapping("/book/year/{publishedYear}")
	public ResponseEntity<ResponseStructure<List<Book>>> getBookByYear(@PathVariable Integer publishedYear) {    // Fetch Books By Published Year
	    return bookService.getBookByYear(publishedYear);  
	}


	
	@GetMapping("/book/genre/{genre}")
	public ResponseEntity<ResponseStructure<List<Book>>> getBookByGenre(@PathVariable String genre) {   // Fetch Books By Genre
	    return bookService.getBookByGenre(genre);
	}
	
}
