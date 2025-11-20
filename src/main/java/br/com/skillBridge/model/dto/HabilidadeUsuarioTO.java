package br.com.skillBridge.model.dto;

import java.time.LocalDate;

public class HabilidadeUsuarioTO {
    private Long id;
    private String nivel;
    private LocalDate dataCriacao;
    private Long idUsuario;
    private Long idHabilidade;

    public HabilidadeUsuarioTO() {}

    public HabilidadeUsuarioTO(Long id, String nivel, LocalDate dataCriacao, Long idUsuario, Long idHabilidade) {
        this.id = id;
        this.nivel = nivel;
        this.dataCriacao = dataCriacao;
        this.idUsuario = idUsuario;
        this.idHabilidade = idHabilidade;
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

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdHabilidade() {
        return idHabilidade;
    }

    public void setIdHabilidade(Long idHabilidade) {
        this.idHabilidade = idHabilidade;
    }
}
