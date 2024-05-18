import java.util.ArrayList;

import java.util.Scanner;



class Contato {

private String nome;

private String telefone;

private String email;



public Contato(String nome, String telefone, String email) {

this.nome = nome;

this.telefone = telefone;

this.email = email;

}



public String getNome() {

return nome;

}



public String getTelefone() {

return telefone;

}



public String getEmail() {

return email;

}



@Override

public String toString() {

return "Contato{" +

"nome='" + nome + '\'' +

", telefone='" + telefone + '\'' +

", email='" + email + '\'' +

'}';

}

}



public class AgendaContatos {

public static void main(String[] args) {

ArrayList<Contato> contatos = new ArrayList<>();

Scanner scanner = new Scanner(System.in);



while (true) {

System.out.println("Menu:");

System.out.println("1. Adicionar contato");

System.out.println("2. Mostrar todos os contatos");

System.out.println("3. Sair");

System.out.print("Escolha uma opção: ");

int opcao = scanner.nextInt();



if (opcao == 1) {

System.out.print("Digite o nome do contato: ");

String nome = scanner.next();

System.out.print("Digite o telefone do contato: ");

String telefone = scanner.next();

System.out.print("Digite o email do contato: ");

String email = scanner.next();



Contato contato = new Contato(nome, telefone, email);

contatos.add(contato);

System.out.println("Contato adicionado com sucesso!");

} else if (opcao == 2) {

System.out.println("Contatos:");

for (Contato contato : contatos) {

System.out.println(contato);

}

} else if (opcao == 3) {

System.out.println("Saindo...");

break;

} else {

System.out.println("Opção inválida. Tente novamente.");

}

}

}

}