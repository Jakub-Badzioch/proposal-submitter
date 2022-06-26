package com.towerbuilder.proposalsubmitter.controller;

import com.towerbuilder.proposalsubmitter.exception.InvalidPasswordException;
import com.towerbuilder.proposalsubmitter.exception.TooLowGradeException;
import com.towerbuilder.proposalsubmitter.model.dto.ErrorDTO;
import com.towerbuilder.proposalsubmitter.model.dto.FieldErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class AdviceController {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleEntityNotFoundException(EntityNotFoundException e) {
        return new ErrorDTO("Data couldn't be found");
    }

    @ExceptionHandler(TooLowGradeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO handleTooLowGradeException(TooLowGradeException e) {
        return new ErrorDTO(e.getMessage());
    }

    @ExceptionHandler(InvalidPasswordException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO handleInvalidPasswordException(InvalidPasswordException e) {
        return new ErrorDTO(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public List<FieldErrorDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return e.getFieldErrors().stream()
                .map(fieldError -> new FieldErrorDTO(fieldError.getField(), fieldError.getDefaultMessage()))
                .collect(Collectors.toList());
    }
}
