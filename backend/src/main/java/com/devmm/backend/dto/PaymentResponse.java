package com.devmm.backend.dto;

public class PaymentResponse {

    // Variáveis que vão ser a resposta do pagamento.
    private String status;
    private String mensagem;
    private Object dados;

    // Construtores que vão ser usados.
    public PaymentResponse() {
    }

    public PaymentResponse(String status, String mensagem, Object dados) {
        this.status = status;
        this.mensagem = mensagem;
        this.dados = dados;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Object getDados() {
        return dados;
    }

    public void setDados(Object dados) {
        this.dados = dados;
    }
}
