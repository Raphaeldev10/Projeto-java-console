mport java.util.ArrayList;

import java.util.Scanner;



class Livro {

private String titulo;

private String autor;

private int numPaginas;

private boolean disponivel;



public Livro(String titulo, String autor, int numPaginas) {

this.titulo = titulo;

this.autor = autor;

this.numPaginas = numPaginas;

this.disponivel = true;

}



public String getTitulo() {

return titulo;

}



public String getAutor() {

return autor;

}



public int getNumPaginas() {

return numPaginas;

}



public boolean isDisponivel() {

return disponivel;

}



public void emprestarLivro() {

disponivel = false;

}



public void devolverLivro() {

disponivel = true;

}



@Override

public String toString() {

return "Livro{" +

"titulo='" + titulo + '\'' +

", autor='" + autor + '\'' +

", numPaginas=" + numPaginas +

", disponivel=" + disponivel +

'}';

}

}



public class GestaoBiblioteca {

public static void main(String[] args) {

ArrayList<Livro> acervo = new ArrayList<>();

Scanner scanner = new Scanner(System.in);



while (true) {

System.out.println("Menu:");

System.out.println("1. Adicionar livro");

System.out.println("2. Mostrar todos os livros do acervo");

System.out.println("3. Emprestar livro");

System.out.println("4. Devolver livro");

System.out.println("5. Sair");

System.out.print("Escolha uma opção: ");

int opcao = scanner.nextInt();



if (opcao == 1) {

System.out.print("Digite o título do livro: ");

String titulo = scanner.next();

System.out.print("Digite o autor do livro: ");

String autor = scanner.next();

System.out.print("Digite o número de páginas do livro: ");

int numPaginas = scanner.nextInt();



Livro livro = new Livro(titulo, autor, numPaginas);

acervo.add(livro);

System.out.println("Livro adicionado com sucesso!");

} else if (opcao == 2) {

System.out.println("Livros no acervo:");

for (Livro livro : acervo) {

System.out.println(livro);

}

} else if (opcao == 3) {

System.out.print("Digite o título do livro que deseja emprestar: ");

String titulo = scanner.next();

boolean encontrado = false;

for (Livro livro : acervo) {

if (livro.getTitulo().equalsIgnoreCase(titulo)) {

if (livro.isDisponivel()) {

livro.emprestarLivro();

System.out.println("Livro emprestado com sucesso!");

} else {

System.out.println("Livro indisponível para empréstimo.");

}

encontrado = true;

break;

}

}

if (!encontrado) {

System.out.println("Livro não encontrado no acervo.");

}

} else if (opcao == 4) {

System.out.print("Digite o título do livro que deseja devolver: ");

String titulo = scanner.next();

boolean encontrado = false;

for (Livro livro : acervo) {

if (livro.getTitulo().equalsIgnoreCase(titulo)) {

if (!livro.isDisponivel()) {

livro.devolverLivro();

System.out.println("Livro devolvido com sucesso!");

} else {

System.out.println("Este livro já está disponível na biblioteca.");

}

encontrado = true;

break;

}

}

if (!encontrado) {

System.out.println("Livro não encontrado no acervo.");

}

} else if (opcao == 5) {

System.out.println("Saindo...");

break;

} else {

System.out.println("Opção inválida. Tente novamente.");

}

}

}

}

