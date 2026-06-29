package jsp.springboot;

public class IdNotFoundException extends RuntimeException{
	
	public IdNotFoundException(String message) {
		super(message);                              //by using getMessage() we can call it
	}

}
