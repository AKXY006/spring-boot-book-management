package jsp.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jsp.springboot.dto.ResponseStructure;

@RestControllerAdvice
public class GlobalExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handleINFE(IdNotFoundException exception) {
        return buildResponse(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    
    

    @ExceptionHandler(NoRecordAvailableException.class)
    public ResponseEntity<ResponseStructure<String>> handleNRAE(NoRecordAvailableException exception) {
        return buildResponse(exception.getMessage(), HttpStatus.NOT_FOUND);
    }


    private ResponseEntity<ResponseStructure<String>> buildResponse(String message, HttpStatus status) {

        ResponseStructure<String> res = new ResponseStructure<>();

        res.setStatusCode(status.value());
        res.setMessage(message);
        res.setData("Failure");

        return ResponseEntity.status(status).body(res);
    }
}