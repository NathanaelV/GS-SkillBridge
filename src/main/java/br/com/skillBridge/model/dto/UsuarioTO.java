package br.com.skillBridge.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.util.ArrayList;

public class UsuarioTO {
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String email;
    @NotBlank
    private String senha;
    private String sexo;
    @Past
    private LocalDate dataNascimento;
    @Positive
    private Long cpf;
    private Long idEmpresa;
    private ArrayList<HabilidadeUsuarioTO> habilidadesUsuario;

    public UsuarioTO() {}

    public UsuarioTO(Long id, String nome, String email, String senha, String sexo, LocalDate dataNascimento, Long cpf, Long idEmpresa, ArrayList<HabilidadeUsuarioTO> habilidadesUsuario) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.idEmpresa = idEmpresa;
        this.habilidadesUsuario = habilidadesUsuario;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public ArrayList<HabilidadeUsuarioTO> getHabilidadesUsuario() {
        return habilidadesUsuario;
    }

    public void setHabilidadesUsuario(ArrayList<HabilidadeUsuarioTO> habilidadesUsuario) {
        this.habilidadesUsuario = habilidadesUsuario;
    }
}
