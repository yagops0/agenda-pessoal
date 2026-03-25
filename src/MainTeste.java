import entities.StatusTarefa;
import entities.Tarefa;
import services.TarefaService;

import java.util.Scanner;

public class MainTeste {
    public static void main(String[] args) {
        TarefaService tarefaService = new TarefaService();
        Scanner scan = new Scanner(System.in);
        Tarefa t1 = new Tarefa("TESTE ESTUDAR", StatusTarefa.INCOMPLETA);
        Tarefa t2 = new Tarefa();
        System.out.println("===============================================");
        System.out.println("= TESTANDO O PROGRAMA");
        System.out.println("===============================================");
        System.out.println("= Digite a descrção da tarefa: ");
        t2.setDescricao(scan.nextLine());
        t2.setStatus(StatusTarefa.COMPLETA);
        tarefaService.saveTarefa(t1);
        System.out.println("===============================================");
        tarefaService.saveTarefa(t2);
        System.out.println("===============================================");

        System.out.println("========================================= TAREFAS =========================================");
        for (Tarefa t : tarefaService.findAll()){
            System.out.println(t.toString());
            System.out.println("===============================================");
        }

    }
}
