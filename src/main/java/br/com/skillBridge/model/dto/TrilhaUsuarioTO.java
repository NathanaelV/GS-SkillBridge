package br.com.skillBridge.model.dto;

import java.time.LocalDate;

public class TrilhaUsuarioTO {
    private Long id;
    private int progresso;
    private String status;
    private Long idUsuario;
    private Long idTrilha;
    private LocalDate dataCriacao;

    public TrilhaUsuarioTO() {}

    public TrilhaUsuarioTO(Long id, int progresso, String status, Long idUsuario, Long idTrilha, LocalDate dataCriacao) {
        this.id = id;
        this.progresso = progresso;
        this.status = status;
        this.idUsuario = idUsuario;
        this.idTrilha = idTrilha;
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

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdTrilha() {
        return idTrilha;
    }

    public void setIdTrilha(Long idTrilha) {
        this.idTrilha = idTrilha;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
