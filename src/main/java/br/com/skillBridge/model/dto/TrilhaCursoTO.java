package br.com.skillBridge.model.dto;

import java.time.LocalDate;

public class TrilhaCursoTO {
    private Long id;
    private Long idTrilha;
    private Long idCurso;
    private LocalDate dataCriacao;

    public TrilhaCursoTO() {}

    public TrilhaCursoTO(Long id, Long idTrilha, Long idCurso, LocalDate dataCriacao) {
        this.id = id;
        this.idTrilha = idTrilha;
        this.idCurso = idCurso;
        this.dataCriacao = dataCriacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdTrilha() {
        return idTrilha;
    }

    public void setIdTrilha(Long idTrilha) {
        this.idTrilha = idTrilha;
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
