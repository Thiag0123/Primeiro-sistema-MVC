package com.biblioteca.biblioteca.model;

public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private String categoria;
    private Integer anoPublicacao;

    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public String getIsbn() {
        return isbn;
    }
    public String getCategoria() {
        return categoria;
    }
    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
}
