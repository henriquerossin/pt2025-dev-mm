package com.devmm.backend.service;

import com.devmm.backend.dto.PaymentRequest;
import com.devmm.backend.dto.PaymentResponse;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

@Service
public class PaymentService {

    public PaymentResponse process(PaymentRequest request) {
        // tira a máscara dos dados que vierem formatados.
        String cpf = request.getCpf().replaceAll("[^\\d]", "");
        String validade = request.getValidade().trim();

        // validacoes basicas que vao ser simuladas
        if (!isCpfValido(cpf)) {
            return new PaymentResponse("FALHA", "CPF inválido", null);
        }

        if (request.getIdade() < 18) {
            return new PaymentResponse("FALHA", "Idade mínima é 18 anos", null);
        }

        if (!isValidadeValida(validade)) {
            return new PaymentResponse("FALHA", "Cartão expirado ou formato inválido", null);
        }

        // se for tudo bem: validar o pagamento.
        String bandeira = detectaBandeira(request.getNumeroCartao());

        return new PaymentResponse("SUCESSO", "Pagamento processado com sucesso!", new DadosRetorno(request.getNomeTitular(), bandeira));
    }

    private boolean isCpfValido(String cpf) {
        return cpf.matches("\\d{11}");
    }

    private boolean isValidadeValida(String validade) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
            YearMonth dataCartao = YearMonth.parse(validade, formatter);
            YearMonth agora = YearMonth.now();
            return dataCartao.isAfter(agora);
        } catch (Exception e) {
            return false;
        }
    }

    private String detectaBandeira(String numeroCartao) {
        if (numeroCartao.startsWith("4")) {
            return "Visa";
        } else if (numeroCartao.startsWith("5")) {
            return "MarterCard";
        } else {
            return "Bandeira desconhecida";
        }
    }

    static class DadosRetorno {
        private final String nomeTitular;
        private final String bandeira;

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
