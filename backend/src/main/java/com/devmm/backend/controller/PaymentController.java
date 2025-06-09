package com.devmm.backend.controller;

import com.devmm.backend.dto.PaymentRequest;
import com.devmm.backend.dto.PaymentResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @PostMapping
    public ResponseEntity<PaymentResponse> processPayment(@Valid @RequestBody PaymentRequest request) {
        String nome = request.getNomeTitular();
        String bandeira = detectaBandeira(request.getNumeroCartao());

        PaymentResponse response = new PaymentResponse("SUCESSO", "Pagamento processado com sucesso!", new DadosRetorno(nome, bandeira));

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // Um método privado que vai simular a detecção da bandeira do cartão.
    private String detectaBandeira(String numeroCartao) {
        if (numeroCartao.startsWith("4")) {
            return "Visa";
        } else if (numeroCartao.startsWith("5")) {
            return "MasterCard";
        } else {
            return "Bandeira desconhecida";
        }
    }

    // Uma classe auxiliar interna que vai montar os dados da resposta
    static class DadosRetorno {
        private String nomeTitular;
        private String bandeira;

        public DadosRetorno(String nomeTitular, String bandeira) {
            this.nomeTitular = nomeTitular;
            this.bandeira = bandeira;
        }

        public String getNomeTitular() {
            return nomeTitular;
        }

        public String getBandeira() {
            return bandeira;
        }
    }

}
