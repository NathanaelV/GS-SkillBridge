package br.com.skillBridge.model.dto;

public class TrilhaTO {
    private Long id;
    private String nome;
    private String descricao;
    private String areaProfissional;

    public TrilhaTO() {}

    public TrilhaTO(Long id, String nome, String descricao, String areaProfissional) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.areaProfissional = areaProfissional;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAreaProfissional() {
        return areaProfissional;
    }

    public void setAreaProfissional(String areaProfissional) {
        this.areaProfissional = areaProfissional;
    }

    @Override
    public String toString() {
        return "TrilhaTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", areaProfissional='" + areaProfissional + '\'' +
                '}';
    }
}
