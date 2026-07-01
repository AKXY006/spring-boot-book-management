package jsp.springboot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import jsp.springboot.dto.ResponseStructure;
import jsp.springboot.entity.Book;
import jsp.springboot.exception.NoRecordAvailableException;
import jsp.springboot.repository.BookRepository;

@Service
public class BookServiceForPaginationAndSorting {
	
	@Autowired
	private BookRepository bookRepository;


	 public ResponseStructure<Page<Book>> getPageByPagination(int pageNumber, int pageSize) {
		 Page<Book> page = bookRepository.findAll(PageRequest.of(pageNumber, pageSize));
	        ResponseStructure<Page<Book>> res = new ResponseStructure<>();

	        if (page.isEmpty()) {
	            throw new NoRecordAvailableException("Data Not Available To Be Display");
	        } else {
	            res.setStatusCode(HttpStatus.OK.value());
	            res.setMessage("Data Retrieved Successfully");
	            res.setData(page);
	            return res;
	        }
	     }
	 
	 
	  public ResponseStructure<Page<Book>> getBookBySortingAndPagination(int pn, int ps , String fieldName){
		  Page<Book> page = bookRepository.findAll(PageRequest.of(pn, ps , Sort.by(fieldName).ascending()));
		  ResponseStructure<Page<Book>> res = new ResponseStructure<>();
		  
		  if (page.isEmpty()) {
	            throw new NoRecordAvailableException("Data Not Available To Be Display"); 
	        } else {
	            res.setStatusCode(HttpStatus.OK.value());
	            res.setMessage("Data Retrieved Successfully");
	            res.setData(page);
	            return res;
	        }
	  }
}
