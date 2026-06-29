package jsp.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
	
  
	
}
