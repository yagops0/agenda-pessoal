package controllers;

import entities.Tarefa;
import services.TarefaService;
import views.Menu;

import java.util.Scanner;

public class TarefaController {
    Scanner scan = new Scanner(System.in);
    TarefaService tarefaService = new TarefaService();
    int opcaoMenu, opcaoExcluirTarefa;
    char continuarProgama, continuarExcluir, continuarAtualizar, continuarAdd;
    char confirmarExclusao, confirmarAtualizacao;


    private void deleteTarefa(int escolha){
        char confirmar;
        int id;
        switch (escolha){
            case 1:
                scan.nextLine();
                System.out.println("= Digite o número da tarefa que deseja excluir: ");
                id = scan.nextInt();
                scan.nextLine();
                System.out.println("==========================================================================");
                System.out.println("= Tarefa: " + tarefaService.findById(id).toString() + " escolhida!");
                System.out.println("==========================================================================");
                System.out.println("= Deseja excluir esta tarefa (s - sim / n - não)? ");
                System.out.println("==========================================================================");
                confirmar = scan.nextLine().charAt(0);
                if ('s' == Character.toLowerCase(confirmar)){
                    if (tarefaService.delete(tarefaService.findById(id))){
                        System.out.println("= TAREFA EXCLUÍDA COM SUCESSO!");
                        System.out.println("==========================================================================");
                    }else {
                        System.out.println("= OCORREU UM ERRO AO EXCLUIR A TAREFA!");
                    }
                }else if('n' == Character.toLowerCase(confirmar)){
                    System.out.println("= Exclusão não confirmada, saindo do menu...");
                }else {
                    System.out.println("= Opção inválida!");
                }
                break;
            case 2:
                scan.nextLine();
                System.out.println("==========================================================================");
                System.out.println("= Deseja excluir todas as tarefas (s - sim / n - não)? ");
                confirmar = scan.nextLine().charAt(0);

                System.out.println("==========================================================================");
                if ('s' == Character.toLowerCase(confirmar)){
                    if (tarefaService.deleteAll()){
                        System.out.println("= Excluindo...");
                        System.out.println("==========================================================================");
                        System.out.println("= Todas as tarefas foram excluídas com sucesso!");
                        System.out.println("==========================================================================");
                    }else {
                        System.out.println("= Ocorreu um erro ao excluir as tarefas!");
                    }
                } else if ('n' == Character.toLowerCase(confirmar)) {
                    System.out.println("= Exclusão não confirmada, saindo do menu...");
                }else {
                    System.out.println("= Opção inválida!");
                }
                break;
            default:
                System.out.println("= Opção inválida!");
                scan.nextLine();

        }
    }

    public void processamento(){
        do {
            Menu.menu();
            System.out.println("= Digite a opção: ");
            opcaoMenu = scan.nextInt();
            switch (opcaoMenu){
                case 1:
                    scan.nextLine();
                    do {
                        Tarefa tarefa = new Tarefa();
                        System.out.println("===================================== ADICIONAR TAREFA =====================================");
                        System.out.println("= Digite a descrição da tarefa: ");
                        tarefa.setDescricao(scan.nextLine());
                        System.out.println("=============================================================================================");
                        tarefaService.saveTarefa(tarefa);

                        System.out.println("= Deseja adicionar mais alguma tarefa (s - sim / n - não?");
                        continuarAdd = scan.nextLine().charAt(0);
                    }while (Character.toLowerCase(continuarAdd) == 's');
                    break;
                case 2:
                    break;
                case 3:
                    do {

                        scan.nextLine();
                        Menu.excluirMenu();
                        System.out.println("= Digite o que deseja fazer: ");
                        opcaoExcluirTarefa = scan.nextInt();
                        lerTarefas();
                        deleteTarefa(opcaoExcluirTarefa);

                        System.out.println("= Deseja excluir mais alguma tarefa (s - sim / n - não)?");
                        continuarExcluir = scan.nextLine().charAt(0);
                    }while (Character.toLowerCase(continuarExcluir) == 's');
                    break;
                case 4:
                    lerTarefas();
                    break;
                case 5:

                    break;
                default:
                    System.out.println("= Opção inválida!");
            }

            scan.nextLine();
            System.out.println("= Continuar no programa (s - sim / n - não)?");
            continuarProgama = scan.nextLine().charAt(0);
        }while (Character.toLowerCase(continuarProgama) == 's');
    }

    private void lerTarefas(){
        System.out.println("======================================= TAREFAS =======================================");
        for (Tarefa t : tarefaService.findAll()){
            System.out.println(t.toString());
        }
        System.out.println("==========================================================================================");

    }

}
