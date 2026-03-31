package controllers;

import entities.StatusTarefa;
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

    private void atualizarTarefa(){
        int escolhaAtt, escolhaStatus;

        System.out.println("= Digite o número da tarefa que deseja atualizar: ");
        escolhaAtt = scan.nextInt();
        Tarefa tarefa = tarefaService.findById(escolhaAtt);
        scan.nextLine();
        System.out.println("=============================================================");
        System.out.println("= Tarefa:  " + tarefa.toString() + " escolhida.");
        System.out.println("=============================================================");
        System.out.println("= Digite a descrição atualizada da tarefa: ");
        tarefa.setDescricao(scan.nextLine());
        System.out.println("=============================================================");
        System.out.println("= Escolha o status atualizado da tarefa (1 - completa / 2 - incompleta): ");
        escolhaStatus = scan.nextInt();
        if (escolhaStatus == 1){
            tarefa.setStatus(StatusTarefa.COMPLETA);
        } else if (escolhaStatus == 2) {
            tarefa.setStatus(StatusTarefa.INCOMPLETA);
        }else {
            System.out.println("= Opção inválida!");
        }
        System.out.println("=============================================================");
        scan.nextLine();
        try {
            tarefaService.saveTarefa(tarefa);
            System.out.println("=============================================================");
            System.out.println("===================== TAREFA ATUALIZADA =====================");
            System.out.println("= Tarefa atualizada: " + tarefa);
            System.out.println("=============================================================");
        }catch (Exception e){
            System.out.println("=============================================================");
            System.out.println("= Não foi possível atualizar a tarefa!");
            System.out.println("=============================================================");
        }

    }

    private void deleteTarefa(int escolha){
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
                confirmarExclusao = scan.nextLine().charAt(0);
                if ('s' == Character.toLowerCase(confirmarExclusao)){
                    if (tarefaService.delete(tarefaService.findById(id))){
                        System.out.println("= TAREFA EXCLUÍDA COM SUCESSO!");
                        System.out.println("==========================================================================");
                    }else {
                        System.out.println("= OCORREU UM ERRO AO EXCLUIR A TAREFA!");
                    }
                }else if('n' == Character.toLowerCase(confirmarExclusao)){
                    System.out.println("= Exclusão não confirmada, saindo do menu...");
                }else {
                    System.out.println("= Opção inválida!");
                }
                break;
            case 2:
                scan.nextLine();
                System.out.println("==========================================================================");
                System.out.println("= Deseja excluir todas as tarefas (s - sim / n - não)? ");
                confirmarExclusao = scan.nextLine().charAt(0);

                System.out.println("==========================================================================");
                if ('s' == Character.toLowerCase(confirmarExclusao)){
                    if (tarefaService.deleteAll()){
                        System.out.println("= Excluindo...");
                        System.out.println("==========================================================================");
                        System.out.println("= Todas as tarefas foram excluídas com sucesso!");
                        System.out.println("==========================================================================");
                    }else {
                        System.out.println("= Ocorreu um erro ao excluir as tarefas!");
                    }
                } else if ('n' == Character.toLowerCase(confirmarExclusao)) {
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
                    do {
                        scan.nextLine();
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
                    do {
                        scan.nextLine();
                        System.out.println("================================= ATUALIZAR TAREFAS =================================");
                        lerTarefas();
                        atualizarTarefa();
                        System.out.println("= Deseja atualizar mais alguma tarefa (s - sim / n - não)? ");
                        continuarAtualizar = scan.nextLine().charAt(0);
                    }while (Character.toLowerCase(continuarAtualizar) == 's');

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
