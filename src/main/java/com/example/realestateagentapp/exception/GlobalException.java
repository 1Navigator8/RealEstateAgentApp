package com.example.realestateagentapp.exception;
import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(LoginException.class)
    public ResponseEntity<MyErrorDetails> myExceptionHandler(LoginException ee, WebRequest req){
        MyErrorDetails err=new MyErrorDetails();
        err.setTimestamp(LocalDateTime.now());
        err.setMessage(ee.getMessage());
        err.setDetails(req.getDescription(false));
        return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(AgentException.class)
    public ResponseEntity<MyErrorDetails> AgentHandler(AgentException ee,WebRequest req){
        MyErrorDetails err=new MyErrorDetails();
        err.setTimestamp(LocalDateTime.now());
        err.setMessage(ee.getMessage());
        err.setDetails(req.getDescription(false));
        return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(TransactionException.class)
    public ResponseEntity<MyErrorDetails> DealExceptionHandler(TransactionException ee,WebRequest req){
        MyErrorDetails err=new MyErrorDetails();
        err.setTimestamp(LocalDateTime.now());
        err.setMessage(ee.getMessage());
        err.setDetails(req.getDescription(false));
        return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(PropertyException.class)
    public ResponseEntity<MyErrorDetails> propertyHandler(PropertyException ee,WebRequest req){
        MyErrorDetails err=new MyErrorDetails();
        err.setTimestamp(LocalDateTime.now());
        err.setMessage(ee.getMessage());
        err.setDetails(req.getDescription(false));
        return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(UserException.class)
    public ResponseEntity<MyErrorDetails> UserExceptionHandler(UserException ee,WebRequest req){
        MyErrorDetails err=new MyErrorDetails();
        err.setTimestamp(LocalDateTime.now());
        err.setMessage(ee.getMessage());
        err.setDetails(req.getDescription(false));
        return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(CustomerException.class)
    public ResponseEntity<MyErrorDetails> CustomerExceptionHandler(CustomerException ee,WebRequest req){
        MyErrorDetails err=new MyErrorDetails();
        err.setTimestamp(LocalDateTime.now());
        err.setMessage(ee.getMessage());
        err.setDetails(req.getDescription(false));
        return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(AdminException.class)
    public ResponseEntity<MyErrorDetails> AdminExceptionHandler(AdminException ee,WebRequest req){
        MyErrorDetails err=new MyErrorDetails();
        err.setTimestamp(LocalDateTime.now());
        err.setMessage(ee.getMessage());
        err.setDetails(req.getDescription(false));
        return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> myAnyExceptionHandler(Exception ee,WebRequest req){
        MyErrorDetails err=new MyErrorDetails();
        err.setTimestamp(LocalDateTime.now());
        err.setMessage(ee.getMessage());
        err.setDetails(req.getDescription(false));
        return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<MyErrorDetails> myAnyExceptionHandler(NoHandlerFoundException ee,WebRequest req){
        MyErrorDetails err=new MyErrorDetails();
        err.setTimestamp(LocalDateTime.now());
        err.setMessage(ee.getMessage());
        err.setDetails(req.getDescription(false));
        return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MyErrorDetails> myMethodHandlerExceptionHandler(MethodArgumentNotValidException ee){
        MyErrorDetails err=new MyErrorDetails();
        err.setTimestamp(LocalDateTime.now());
        err.setMessage("Validation Error");
        err.setDetails(ee.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
    }



}