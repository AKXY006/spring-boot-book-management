package jsp.springboot.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.springboot.dto.ResponseStructure;
import jsp.springboot.entity.Book;
import jsp.springboot.exception.IdNotFoundException;
import jsp.springboot.exception.NoRecordAvailableException;
import jsp.springboot.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

                                                                                    // Save single record 
    public ResponseEntity<ResponseStructure<Book>> saveBook(Book book) {
        Book savedBook = bookRepository.save(book);
        ResponseStructure<Book> res = new ResponseStructure<>();

        res.setStatusCode(HttpStatus.CREATED.value());
        res.setMessage("Book Saved Successfully");
        res.setData(savedBook);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

                                                                                                // Save Multiple Books
    public ResponseEntity<ResponseStructure<List<Book>>> saveBookAll(List<Book> books) {
        List<Book> savedBooks = bookRepository.saveAll(books);
        ResponseStructure<List<Book>> response = new ResponseStructure<>();

        response.setStatusCode(HttpStatus.CREATED.value());
        response.setMessage("All Books Saved Successfully");
        response.setData(savedBooks);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

                                                                                                 // Get All Books
    public ResponseEntity<ResponseStructure<List<Book>>> getAllBook() {
        List<Book> books = bookRepository.findAll();
        if (books.isEmpty()) {
            throw new NoRecordAvailableException("No Book Records Available");
        }
        ResponseStructure<List<Book>> response = new ResponseStructure<>();

        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("All Books Fetched Successfully");
        response.setData(books);
        return ResponseEntity.ok(response);
    }

    
    
                                                                                                 // Get Book By Id
    public ResponseEntity<ResponseStructure<Book>> getBookById(Integer id) {
        Optional<Book> option = bookRepository.findById(id);
        if (option.isEmpty()) {
            throw new IdNotFoundException("Book Record With Id : " + id + " Does Not Exist");
        }
        ResponseStructure<Book> response = new ResponseStructure<>();

        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Book Found Successfully");
        response.setData(option.get());

        return ResponseEntity.ok(response);
    }
    
    
                                                                                                   // Update Complete Book Record (PUT)
    public ResponseEntity<ResponseStructure<Book>> updateBook(Book book) {
        if (book.getId() == null) {
            throw new IdNotFoundException("Id Must Be Passed To Update The Record");
        }
        Optional<Book> option = bookRepository.findById(book.getId());

        if (option.isEmpty()) {
            throw new IdNotFoundException("Book Record With Id : " + book.getId() + " Does Not Exist");
        }
        Book updatedBook = bookRepository.save(book);
        ResponseStructure<Book> response = new ResponseStructure<>();

        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Book Updated Successfully");
        response.setData(updatedBook);

        return ResponseEntity.ok(response);
    }

                                                                                                      // Update Particular Fields (PATCH)
    public ResponseEntity<ResponseStructure<Book>> updateBookRecord(Integer id,
            Map<String, Object> updates) {

        Optional<Book> option = bookRepository.findById(id);

        if (option.isEmpty()) {
            throw new IdNotFoundException("Book Record With Id : " + id + " Does Not Exist");
        }

        Book book = option.get();

        for (Map.Entry<String, Object> entry : updates.entrySet()) {

            String key = entry.getKey();
            Object value = entry.getValue();

            switch (key) {

            case "title": book.setTitle((String) value);
                break;

            case "author": book.setAuthor((String) value);
                break;

            case "genre":book.setGenre((String) value);
                break;

            case "price":book.setPrice((Double) value);
                break;

            case "publishedYear":book.setPublishedYear((Integer) value);
                break;

            case "availability": book.setAvailability((Boolean) value);
                break;

            default: throw new IllegalArgumentException("Invalid Field : " + key);
            }
        }

        Book updatedBook = bookRepository.save(book);

        ResponseStructure<Book> res = new ResponseStructure<>();
        res.setStatusCode(HttpStatus.OK.value());
        res.setMessage("Book Updated Successfully");
        res.setData(updatedBook);

        return ResponseEntity.ok(res);
    }


                                                                                                       // Delete Book
    public ResponseEntity<ResponseStructure<String>> deleteBook(Integer id) {
        Optional<Book> option = bookRepository.findById(id);
        if (option.isEmpty()) {
            throw new IdNotFoundException("Book Record With Id : " + id + " Does Not Exist");
        }
        bookRepository.delete(option.get());
        ResponseStructure<String> response = new ResponseStructure<>();

        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Book Record Deleted Successfully");
        response.setData("Success");

        return ResponseEntity.ok(response);
    }

}