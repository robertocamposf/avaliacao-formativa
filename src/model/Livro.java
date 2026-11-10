package model;

import interfaces.Emprestavel;

public class Livro implements Emprestavel {
    private String codigo;
    private String titulo;
    private String autor;
    private boolean emprestado;

    public Livro(String codigo, String titulo, String autor) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.emprestado = false;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    @Override
    public void emprestar() {
        if (this.emprestado) {
            throw new IllegalStateException("O livro '" + titulo + "' já está emprestado.");
        }
        this.emprestado = true;
    }

    @Override
    public void devolver() {
        if (!this.emprestado) {
            throw new IllegalStateException("O livro '" + titulo + "' não está emprestado no momento.");
        }
        this.emprestado = false;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s - %s | Status: %s",
                codigo, titulo, autor, (emprestado ? "Emprestado" : "Disponível"));
    }
}