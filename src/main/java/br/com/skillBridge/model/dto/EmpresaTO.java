package br.com.skillBridge.model.dto;

public class EmpresaTO {
    private Long codigo;
    private String nome;
    private String email;
    private String setor;

    public EmpresaTO() {}

    public EmpresaTO(Long codigo, String nome, String email, String setor) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.setor = setor;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
}
