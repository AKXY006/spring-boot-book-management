package jsp.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jsp.springboot.dto.ResponseStructure;
import jsp.springboot.entity.Book;
import jsp.springboot.service.BookServiceForPaginationAndSorting;

@RestController
public class BookControllerPageAndSort {

    @Autowired
    private BookServiceForPaginationAndSorting bookService;
    
    @GetMapping("/book/page/{pageNumber}/{pageSize}")
    public ResponseStructure<Page<Book>> getPagination(@PathVariable int pageNumber,  @PathVariable int pageSize) {
        return bookService.getPageByPagination(pageNumber, pageSize);
    }
    
   @GetMapping("book/page/{pageNumber}/{pageSize}/{fieldName}")
   public ResponseStructure<Page<Book>> Soting(@PathVariable int pageNumber,  @PathVariable int pageSize , @PathVariable String fieldName) {
       return bookService.getBookBySortingAndPagination(pageNumber, pageSize , fieldName);
   } 
}