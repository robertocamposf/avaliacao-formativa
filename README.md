# Sistema de Gerenciamento de Biblioteca

Projeto em Java desenvolvido para colocar em prática conceitos de Orientação a Objetos, Coleções, Tratamento de Exceções e Organização em Pacotes.

## 🚀 Funcionalidades

- **Cadastro de Livros:** Adiciona novos livros com código, título e autor ao acervo.
- **Listagem:** Exibe todos os livros cadastrados e o status de disponibilidade.
- **Busca por Código:** Localiza um livro específico no acervo pelo seu código único.
- **Empréstimo e Devolução:** Altera o status do livro utilizando a interface `Emprestavel`, lançando exceção caso a operação seja inválida (ex: emprestar um livro já emprestado).
- **Tratamento de Exceções:** Trata buscas por códigos inexistentes via `LivroNaoEncontradoException` e entradas inválidas no menu.

## 📁 Estrutura do Projeto

```text
src/
├── app/
│   └── Main.java                      # Ponto de entrada e menu interativo (Scanner)
├── interfaces/
│   └── Emprestavel.java               # Interface com os métodos emprestar() e devolver()
├── model/
│   └── Livro.java                     # Classe modelo que implementa Emprestavel
└── service/
    ├── BibliotecaService.java         # Regras de negócio e gerenciamento do acervo (ArrayList)
    └── LivroNaoEncontradoException.java # Exceção personalizada
```
## 🛠️ Como Compilar e Executar

    Navegue até a pasta src:
    Bash

    cd src

    Compile todos os arquivos do projeto:
    Bash

    javac */*.java

    Execute a aplicação:
    Bash

    java app.Main

## 💻 Tecnologias e Conceitos Utilizados

    Java 17+

    Encapsulamento e Interfaces

    Coleções & Generics (ArrayList<Livro>)

    Tratamento de Exceções Personalizadas (Exception e IllegalStateException)