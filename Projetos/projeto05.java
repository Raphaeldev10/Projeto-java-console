import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

class Tarefa {
    private String descricao;
    private Date prazo;
    private boolean concluida;

    public Tarefa(String descricao, Date prazo) {
        this.descricao = descricao;
        this.prazo = prazo;
        this.concluida = false;
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getPrazo() {
        return prazo;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void marcarConcluida() {
        this.concluida = true;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Tarefa{" +
                "descricao='" + descricao + '\'' +
                ", prazo=" + sdf.format(prazo) +
                ", concluida=" + concluida +
                '}';
    }
}

class Usuario {
    private String nome;
    private ArrayList<Tarefa> tarefas;

    public Usuario(String nome) {
        this.nome = nome;
        this.tarefas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }

    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    public void mostrarTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada.");
        } else {
            for (int i = 0; i < tarefas.size(); i++) {
                System.out.println((i + 1) + ". " + tarefas.get(i));
            }
        }
    }

    public void marcarTarefaConcluida(int indice) {
        if (indice >= 0 && indice < tarefas.size()) {
            tarefas.get(indice).marcarConcluida();
            System.out.println("Tarefa marcada como concluída com sucesso!");
        } else {
            System.out.println("Número de tarefa inválido.");
        }
    }
}

public class SistemaGerenciamentoTarefas {
    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {
        Usuario usuario = new Usuario("Usuário");

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Mostrar todas as tarefas");
            System.out.println("3. Marcar tarefa como concluída");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarTarefa(usuario);
                    break;
                case 2:
                    usuario.mostrarTarefas();
                    break;
                case 3:
                    marcarTarefaConcluida(usuario);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void adicionarTarefa(Usuario usuario) {
        scanner.nextLine(); 
        System.out.print("Digite a descrição da tarefa: ");
        String descricao = scanner.nextLine();

        System.out.print("Digite o prazo da tarefa (dd/MM/yyyy): ");
        String prazoStr = scanner.nextLine();
        Date prazo;
        try {
            prazo = sdf.parse(prazoStr);
        } catch (ParseException e) {
            System.out.println("Formato de data inválido. Tarefa não adicionada.");
            return;
        }

        Tarefa tarefa = new Tarefa(descricao, prazo);
        usuario.adicionarTarefa(tarefa);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    private static void marcarTarefaConcluida(Usuario usuario) {
        System.out.print("Digite o número da tarefa que deseja marcar como concluída: ");
        int numTarefa = scanner.nextInt();
        usuario.marcarTarefaConcluida(numTarefa - 1);
    }
}
