package views;

import entities.Tarefa;

import java.util.Scanner;

public class Menu {

    public static void menu(){
        System.out.println("=============================================");
        System.out.println("= 1 - Adicionar tarefa");
        System.out.println("= 2 - Atualizar tarefa");
        System.out.println("= 3 - Excluir tarefa(s)");
        System.out.println("= 4 - Listar tarefas");
        System.out.println("= 5 - Sair do programa");
        System.out.println("=============================================");
    }



    public static void excluirMenu(){
        System.out.println("============================ EXCLUSÃO DE TAREFA(S) ============================");
        System.out.println("= 1 - Excluir única tarefa");
        System.out.println("= 2 - Excluir todas as tarefas");
        System.out.println("===============================================================================");
    }




}
