package com.example.handicappedcare.advise;
import com.example.handicappedcare.exception.apiException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserAdvise {

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<apiException> dataIntegrityViolation(DataIntegrityViolationException dataIntegrityViolationException){
        String message="There are restrictions on the information you registered, it may have been previously registered, please change it in order for your request to be executed successfully";
        return ResponseEntity.status(400).body(new apiException(message));
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<apiException> methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        String message=methodArgumentNotValidException.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(new apiException(message));
    }
//    @ExceptionHandler(value = apiException.class)
//    public ResponseEntity apiException(apiException apiException){
//        return ResponseEntity.status(400).body(new apiException(apiException.getMessage(),400));
//    }
    @ExceptionHandler(value = apiException.class)
    public ResponseEntity<apiException> apiException(apiException apiException){
        String message=apiException.getMessage();
        return ResponseEntity.status(400).body(new apiException(message));
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<apiException> exception(Exception exception){
        String message=exception.getMessage();
        return ResponseEntity.status(500).body(new apiException(message));
    }

}
