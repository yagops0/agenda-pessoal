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
        System.out.println("= 1 - Listar tarefas/obejetivos");
        System.out.println("= 2 - Adicionar uma(um) nova(o) tarefa/obejtivo");
        System.out.println("= 3 - Atualizar alguma tarefa");
        System.out.println("= 4 - Deletar alguma tarefa");
        System.out.println("= 5 - Deletar todas as tarefas");
        System.out.println("=================================================================");
    }

    public static void main(String[] args) throws InterruptedException {
        Main menu = new Main();
        Scanner scan = new Scanner(System.in);
        List<String> tarefas = new ArrayList<>();
        String tarefa;
        int opcao, posicaoTarefa;
        char continuar;

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
                    System.out.println("=========================== TAREFAS ===========================");
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
                    ///  COLOCAR ESTE BLOCO LOGO APÓS A LISTAGEM DA TAREFA DENTRO DE UM DO-WHILE
            }


            System.out.println("= Deseja continuar na agenda (s - sim / n - não)? ");
            continuar = scan.nextLine().charAt(0);
        }while (Character.toLowerCase(continuar) == 's');

        scan.close();
    }
}
