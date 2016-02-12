package br.com.radar.model;

public class Usuario {

    private int id;
    private String codigo;
    private String nome;
    private String dscCaminhoFoto;

    public Usuario() {
    }

    public Usuario(int id, String codigo, String nome, String dscCaminhoFoto) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.dscCaminhoFoto = dscCaminhoFoto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDscCaminhoFoto() {
        return dscCaminhoFoto;
    }

    public void setDscCaminhoFoto(String dscCaminhoFoto) {
        this.dscCaminhoFoto = dscCaminhoFoto;
    }
}

