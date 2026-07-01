package jsp.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jsp.springboot.dto.ResponseStructure;
import jsp.springboot.entity.Book;
import jsp.springboot.exception.NoRecordAvailableException;
import jsp.springboot.repository.BookRepository;

@RestController
public class BookControllerPageAndSort {

    @Autowired
    private BookRepository bookRepository;
    

    @GetMapping("/book/page/{pageNumber}/{pageSize}")
    public ResponseStructure<Page<Book>> getPageByPagination(@PathVariable int pageNumber,@PathVariable int pageSize) {
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
    
    
}