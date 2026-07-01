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
	
	// 1. Fetch Book By Author
	@GetMapping("/book/author/{author}")
	public ResponseEntity<ResponseStructure<List<Book>>> getBookByAuthor(
	        @PathVariable String author) {

	    return bookService.getBookByAuthor(author);
	}


	// 2. Fetch Book By Title And Author
	@GetMapping("/book/{title}/{author}")
	public ResponseEntity<ResponseStructure<Book>> getBookByTitleAndAuthor(
	        @PathVariable String title,
	        @PathVariable String author) {

	    return bookService.getBookByTitleAndAuthor(title, author);
	}


	// 3. Fetch Books By Price Greater Than
	@GetMapping("/book/pricegreater/{price}")
	public ResponseEntity<ResponseStructure<List<Book>>> getBookByPriceGreaterThan(
	        @PathVariable double price) {

	    return bookService.getBookByPriceGreaterThan(price);
	}


	// 4. Fetch Books Between Price Range
	@GetMapping("/book/pricebetween/{startPrice}/{endPrice}")
	public ResponseEntity<ResponseStructure<List<Book>>> getBookByPriceBetween(
	        @PathVariable double startPrice,
	        @PathVariable double endPrice) {

	    return bookService.getBookByPriceBetween(startPrice, endPrice);
	}


	// 5. Fetch Available Books
	@GetMapping("/book/availability")
	public ResponseEntity<ResponseStructure<List<Book>>> getBookByAvailability() {

	    return bookService.getBookByAvailability();
	}


	// 6. Fetch Books By Published Year
	@GetMapping("/book/year/{publishedYear}")
	public ResponseEntity<ResponseStructure<List<Book>>> getBookByYear(
	        @PathVariable Integer publishedYear) {

	    return bookService.getBookByYear(publishedYear);
	}


	// 7. Fetch Books By Genre
	@GetMapping("/book/genre/{genre}")
	public ResponseEntity<ResponseStructure<List<Book>>> getBookByGenre(
	        @PathVariable String genre) {

	    return bookService.getBookByGenre(genre);
	}
	
}
