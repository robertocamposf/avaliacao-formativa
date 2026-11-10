package service;

import model.Livro;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaService {
    private final List<Livro> acervo;

    public BibliotecaService() {
        this.acervo = new ArrayList<>();
    }

    public void cadastrarLivro(Livro livro) {
        acervo.add(livro);
    }

    public List<Livro> listarLivros() {
        return new ArrayList<>(acervo);
    }

    public Livro buscarPorCodigo(String codigo) throws LivroNaoEncontradoException {
        for (Livro livro : acervo) {
            if (livro.getCodigo().equalsIgnoreCase(codigo)) {
                return livro;
            }
        }
        throw new LivroNaoEncontradoException("Livro com o código '" + codigo + "' não foi encontrado.");
    }

    public void emprestarLivro(String codigo) throws LivroNaoEncontradoException {
        Livro livro = buscarPorCodigo(codigo);
        livro.emprestar();
    }

    public void devolverLivro(String codigo) throws LivroNaoEncontradoException {
        Livro livro = buscarPorCodigo(codigo);
        livro.devolver();
    }
}