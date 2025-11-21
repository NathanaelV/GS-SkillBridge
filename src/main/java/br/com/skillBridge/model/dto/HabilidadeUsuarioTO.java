package br.com.skillBridge.model.dto;

import java.time.LocalDate;

public class HabilidadeUsuarioTO {
    private Long id;
    private String nivel;
    private LocalDate dataCriacao;
    private HabilidadeTO habilidade;

    public HabilidadeUsuarioTO() {}

    public HabilidadeUsuarioTO(Long id, String nivel, LocalDate dataCriacao, HabilidadeTO habilidade) {
        this.id = id;
        this.nivel = nivel;
        this.dataCriacao = dataCriacao;
        this.habilidade = habilidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public HabilidadeTO getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(HabilidadeTO habilidade) {
        this.habilidade = habilidade;
    }
}
