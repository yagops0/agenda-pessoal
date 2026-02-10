import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public void listarTarefas(List<String> tarefas) throws InterruptedException {
        int contador = 0;
        for (String s : tarefas){
            contador++;
            Thread.sleep(1000);
            System.out.println("= " + contador + " - " + s);
        }
    }
    public void menu(){
        System.out.println("========================= AGENDA PESSOAL =========================");
        System.out.println("= Escolha o que deseja fazer: ");
        System.out.println("= 1 - Listar tarefas/objetivos.");
        System.out.println("= 2 - Adicionar uma(um) nova(o) tarefa/obejtivo.");
        System.out.println("= 3 - Atualizar alguma tarefa.");
        System.out.println("= 4 - Deletar alguma tarefa/Deletar todas as tarefas.");
        System.out.println("= 5 - Sair do programa.");
        System.out.println("=================================================================");
    }

    public static void main(String[] args) throws InterruptedException {
        Main menu = new Main();
        Scanner scan = new Scanner(System.in);
        List<String> tarefas = new ArrayList<>();
        String tarefa;
        int opcao, posicaoTarefa, opcaoDelete;
        char continuar, confirmar;
        boolean inputValido = false; // 1. Começa como falso (ainda não temos um dado bom)

        while (!inputValido){  // 2. O "!" significa "NÃO". Ou seja: "Enquanto NÃO for válido..."
            try {
                do {
                    menu.menu();
                    System.out.println("= Digite sua escolha: ");
                    opcao = scan.nextInt();
                    scan.nextLine();
                    switch (opcao){
                        case 1:
                            System.out.println("============================== TAREFAS ==============================");
                            Thread.sleep(1000);
                            System.out.println("= Espere, listando tarefas...");
                            System.out.println("=================================================================");
                            Thread.sleep(1000);
                            if (tarefas.isEmpty()){
                                System.out.println("= Agenda vazia, adicione algo!");
                                System.out.println("=================================================================");
                            }else {
                                menu.listarTarefas(tarefas);
                                System.out.println("=================================================================");
                            }
                            break;
                        case 2:
                            System.out.println("=========================== ADICIONAR TAREFA ===========================");
                            do{

                                System.out.println("= Por favor digite a nova tarefa: ");
                                tarefa = scan.nextLine();
                                tarefas.add(tarefa);
                                System.out.println("=================================================================");
                                Thread.sleep(1000);
                                System.out.println("= Adicionando tarefa...");
                                Thread.sleep(1000);
                                System.out.println("=================================================================");
                                System.out.println("= Tarefa adicionada com sucesso!");
                                System.out.println("=================================================================");
                                Thread.sleep(1000);
                                System.out.println("= Deseja adicionar mais alguma tarefa (s - sim / n - não)?");
                                continuar = scan.nextLine().charAt(0);
                            }while(Character.toLowerCase(continuar) == 's');
                            break;

                        case 3:
                            System.out.println("=========================== ATUALIZAR TAREFA ===========================");
                            System.out.println("============================== TAREFAS ===============================");
                            if (tarefas.isEmpty()){
                                System.out.println("= Agenda vazia, adicione algo!");
                                System.out.println("=================================================================");
                            }else {
                                menu.listarTarefas(tarefas);
                                ///  COLOCAR ESTE BLOCO LOGO APÓS A LISTAGEM DA TAREFA DENTRO DE UM DO-WHILE
                                do {
                                    System.out.println("= Por favor digite o número a tarefa que deseja atualizar: ");
                                    posicaoTarefa = scan.nextInt();
                                    scan.nextLine();
                                    for (String s : tarefas){
                                        if (tarefas.indexOf(s) + 1 == posicaoTarefa){
                                            System.out.println("= Tarefa: " + s + " - selecionada!");
                                            System.out.println("= Por favor digite a atualização: ");
                                            tarefa = scan.nextLine();
                                            Thread.sleep(1000);
                                            System.out.println("= Atualizando tarefa...");
                                            Thread.sleep(1000);
                                            tarefas.set(tarefas.indexOf(s), tarefa);
                                            System.out.println("=================================================================");
                                            System.out.println("= Tarefa atualizada com sucesso!");
                                            System.out.println("=================================================================");

                                        }
                                    }

                                    System.out.println("= Deseja atualizar mais alguma tarefa (s - sim / n - não?");
                                    continuar = scan.nextLine().charAt(0);
                                }while (Character.toLowerCase(continuar) == 's');

                            }
                            break;

                        case 4:
                            System.out.println("=========================== DELETAR TAREFA(S) ===========================");
                            System.out.println("============================== TAREFAS ===============================");
                            do {
                                if (tarefas.isEmpty()){
                                    System.out.println("= Ainda não há tarefas na agenda!");
                                    System.out.println("=================================================================");
                                }else {

                                    menu.listarTarefas(tarefas);
                                    System.out.println("=================================================================");
                                    System.out.println("======================== MENU DELETAR ========================");
                                    System.out.println("= 1 - Deletar uma única tarefa.");
                                    System.out.println("= 2 - Deletar todas as tarefas.");
                                    System.out.println("=================================================================");
                                    System.out.println("= Digite sua opção: ");
                                    opcaoDelete = scan.nextInt();
                                    System.out.println("=================================================================");
                                    switch (opcaoDelete){
                                        case 1:
                                            System.out.println("======================== DELETAR TAREFA ÚNICA ========================");
                                            System.out.println("= Digite o número da tarefa que deseja deletar: ");
                                            posicaoTarefa = scan.nextInt();
                                            Thread.sleep(1000);
                                            scan.nextLine();
                                            System.out.println("= Tarefa: " + posicaoTarefa + " - " + tarefas.get(posicaoTarefa - 1) + " selecionada!.");
                                            System.out.println("= Deseja realmente excluir esta tarefa (s - sim / n - não)?");
                                            confirmar = scan.nextLine().charAt(0);
                                            if (Character.toLowerCase(confirmar) == 's'){
                                                Thread.sleep(1000);
                                                System.out.println("=================================================================");
                                                System.out.println("= Deletando tarefa...");
                                                Thread.sleep(1000);
                                                System.out.println("=================================================================");
                                                tarefas.remove(posicaoTarefa - 1);
                                                System.out.println("= Tarefa deletada com sucesso!");
                                            }else if (Character.toLowerCase(confirmar) == 'n'){
                                                Thread.sleep(1000);
                                                System.out.println("= Não foi possível deletar a tarefa.");
                                            }else {
                                                Thread.sleep(1000);
                                                System.out.println("= Ocorreu um erro, opção inválida.");
                                            }
                                            System.out.println("=================================================================");
                                            Thread.sleep(1000);
                                            break;

                                        case 2:
                                            scan.nextLine();
                                            System.out.println("======================== DELETAR TODAS ========================");
                                            System.out.println(" = Confirmar exclusão das tarefas da agenda (s - sim / n - não? ");
                                            confirmar = scan.nextLine().charAt(0);
                                            if (Character.toLowerCase(confirmar) == 's'){
                                                Thread.sleep(1000);
                                                System.out.println("=================================================================");
                                                System.out.println("= Excluindo tarefas...");
                                                tarefas.clear();
                                                System.out.println("=================================================================");
                                                Thread.sleep(1000);
                                                System.out.println("= Todas as tarefas foram excluídas com sucesso!");
                                                System.out.println("=================================================================");
                                            } else if (Character.toLowerCase(confirmar) == 'n') {
                                                Thread.sleep(1000);
                                                System.out.println("=================================================================");
                                                System.out.println("= Tarefas não foram excluídas!");
                                                System.out.println("=================================================================");
                                                System.out.println("= Saindo...");
                                                System.out.println("=================================================================");
                                                Thread.sleep(1000);
                                            }else {
                                                System.out.println("=================================================================");
                                                System.out.println("= Essa opção é inválida!");
                                                System.out.println("=================================================================");
                                                System.out.println("= Saindo...");
                                                System.out.println("=================================================================");
                                                Thread.sleep(1000);
                                            }
                                            break;
                                    }
                                }

                                System.out.println("= Deseja deletar mais alguma tarefa (s - sim / n - não)?");
                                continuar = scan.nextLine().charAt(0);

                            }while(Character.toLowerCase(continuar) == 's');

                        case 5:
                            Thread.sleep(1000);
                            System.out.println("=================================================================");
                            System.out.println("= Saindo...");
                            System.out.println("=================================================================");
                            break;
                        default:
                            System.out.println("= Desculpe, essa opção não existe.");

                    }


                    System.out.println("= Deseja continuar na agenda (s - sim / n - não)? ");
                    continuar = scan.nextLine().charAt(0);
                }while (Character.toLowerCase(continuar) == 's');
                inputValido = true;  // 3. Se o programa chegar nesta linha, significa que todos os inputs funcionarão!
            } catch (Exception e) {
                // 4. Se der erro, o 'inputValido' continua sendo 'false'.
                // O catch trata o erro e o 'while' joga o usuário para o topo de novo.
                System.out.println("=================================================================");
                System.out.println("= Ocorreu um erro ao rodar o programa, por favor rode o programa novamente!");;
                System.out.println("=================================================================");
                scan.nextLine(); // Limpa o lixo do teclado
            }
        }


        scan.close();
    }
}
