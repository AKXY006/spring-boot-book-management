package jsp.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import jsp.springboot.dto.ResponseStructure;
import jsp.springboot.entity.Book;
import jsp.springboot.exception.NoRecordAvailableException;
import jsp.springboot.repository.BookRepository;
import jsp.springboot.service.BookService;
import sun.jvm.hotspot.oops.ReturnTypeEntry;

@RestController
public class BookControllerPageAndSort {
	
	@Autowired
	private BookService bookService;
	
	public ResponseStructure<Page<Book>> getPageByPagination(int pageNumber,int PageSize){
		
		Page<Book> page = bookRepository.findAll(PageRequest.of(pageNumber, PageSize));
		
		ResponseStructure<Page<Book>> res = new ResponseStructure<Page<Book>>();
		
		if(page.isEmpty()) {
			throw new NoRecordAvailableException("Data Not Available To Be Display");
		}
		else {
			res.setStatusCode(HttpStatus.OK.value());
			res.setMessage("Data retrieved for the respective page");
			res.setData("page");
			return res;
		}
	}

}
