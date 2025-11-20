package br.com.skillBridge.model.dto;

import java.time.LocalDate;

public class CursoTO {
    private Long id;
    private String nome;
    private String nivel;
    private String conteudoPrincipal;
    private LocalDate dataCriacao;

    public CursoTO() {}

    public CursoTO(Long id, String nome, String nivel, String conteudoPrincipal, LocalDate dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.nivel = nivel;
        this.conteudoPrincipal = conteudoPrincipal;
        this.dataCriacao = dataCriacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getConteudoPrincipal() {
        return conteudoPrincipal;
    }

    public void setConteudoPrincipal(String conteudoPrincipal) {
        this.conteudoPrincipal = conteudoPrincipal;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
