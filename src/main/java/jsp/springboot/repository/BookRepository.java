package jsp.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jsp.springboot.entity.Book;

public interface BookRepository extends JpaRepository<Book,Integer>{  
	
	//Custom method 
	
	//Fetch BookByAuthorName
	List<Book> findByAuthor(String author);
	
	//Fetch BookByTitleAndAuthor
	Optional<Book> findByTitleAndAuthor(String title, String author);
	
	List<Book> findByPriceGreaterThan(double price);
	
	List<Book> findByPriceBetween(double startprice, double endprice);
	
	@Query("select b from Book b where b.availability = true")
	List<Book> getBookByavailability();
	
	@Query("select b from Book b where b.publishedYear = ?1")
	List<Book> getBookByYear(Integer publishedYear);
	
	@Query("select b from Book b where b.genre =:genre")
	List<Book> getBookbyGenre(String genre);
	
	
	
	

}
