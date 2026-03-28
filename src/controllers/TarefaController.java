package controllers;

import entities.Tarefa;
import views.Menu;

import java.util.Scanner;

public class TarefaController {
    Scanner scan = new Scanner(System.in);
    Tarefa tarefa = new Tarefa();
    int opcaoMenu, opcaoExcluirTarefa, opcaoBuscarTarefa;
    char continuarProgama, continuarExcluir, continuarAtualizar;

    public void processamento(){
        do {
            Menu.menu();

            switch (opcaoMenu){
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                default:
                    System.out.println("= Opção inválida!");
            }


            System.out.println("= Continuar no programa (s - sim / n - não)?");
            continuarProgama = scan.nextLine().charAt(0);
        }while (Character.toLowerCase(continuarProgama) == 's');
    }

}
