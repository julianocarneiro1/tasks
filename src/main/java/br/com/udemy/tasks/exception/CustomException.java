package br.com.udemy.tasks.exception;

import br.com.udemy.tasks.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import reactor.core.publisher.Mono;

@ControllerAdvice
public class CustomException {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException ex) {
        return Mono.just(ex)
                .map(ErrorResponse::internalError)
                .map(error -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error))
                .block();
    }
}
