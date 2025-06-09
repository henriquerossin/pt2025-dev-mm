package com.devmm.backend.dto;

import jakarta.validation.constraints.*;

public class PaymentRequest {

    @NotBlank(message = "Nome do Titular é obrigatório.")
    private String nomeTitular;

    @NotBlank(message = "Número do cartão é obrigatório.")
    @Pattern(regexp = "\\d{16}", message = "Número do cartão deve ter 16 dígitos.")
    private String numeroCartao;

    @NotBlank(message = "Data de validade é obrigatória.")
    @Pattern(regexp = "(0[1-9]|1[0-2])/\\d{2}", message = "Formato da validade deve ser MM/AA.")
    private String validade;

    @NotBlank(message = "CVV é obrigatório.")
    @Pattern(regexp = "\\d{3}", message = "CVV deve conter 3 dígitos.")
    private String cvv;

    @NotBlank(message = "CPF é obrigatório.")
    @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 dígitos (após desmascarar).")
    private String cpf;

    @Min(value = 18, message = "É necessário ter pelo menos 18 anos.")
    private int idade;

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
