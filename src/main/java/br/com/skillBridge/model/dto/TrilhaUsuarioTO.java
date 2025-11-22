package br.com.skillBridge.model.dto;

import java.time.LocalDate;

public class TrilhaUsuarioTO {
    private Long id;
    private int progresso;
    private String status;
    private TrilhaTO trilha;
    private LocalDate dataCriacao;

    public TrilhaUsuarioTO() {}

    public TrilhaUsuarioTO(Long id, int progresso, String status, TrilhaTO trilha, LocalDate dataCriacao) {
        this.id = id;
        this.progresso = progresso;
        this.status = status;
        this.trilha = trilha;
        this.dataCriacao = dataCriacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getProgresso() {
        return progresso;
    }

    public void setProgresso(int progresso) {
        this.progresso = progresso;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public TrilhaTO getTrilha() {
        return trilha;
    }

    public void setTrilha(TrilhaTO trilha) {
        this.trilha = trilha;
    }
}
