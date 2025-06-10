package com.devmm.backend.exception;

import com.devmm.backend.dto.PaymentResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    //fazendo a captura dos erros de validação
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<PaymentResponse> handleValidationErrors(MethodArgumentNotValidException ex) {

        //pegando a primeira mensagem de erro que pode acontecer na validação
        String mensagemErro = ex.getBindingResult().getFieldErrors().stream().findFirst().map(fieldError -> fieldError.getDefaultMessage()).orElse("Dados inválidos");

        //montando a resposta no padrão que será usado no resto da API
        PaymentResponse response = new PaymentResponse("FALHA", mensagemErro, null);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

}
