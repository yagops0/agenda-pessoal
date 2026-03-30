import controllers.TarefaController;
import entities.StatusTarefa;
import entities.Tarefa;
import services.TarefaService;
import views.Menu;

import java.util.Scanner;

public class MainTeste {
    public static void main(String[] args) {
        TarefaService tarefaService = new TarefaService();
        Scanner scan = new Scanner(System.in);
//        Tarefa t1 = new Tarefa("TESTE ESTUDAR");
//        Tarefa t2 = new Tarefa();
//        System.out.println("===============================================");
//        System.out.println("= TESTANDO O PROGRAMA");
//        System.out.println("===============================================");
//        System.out.println("= Digite a descrição da tarefa: ");
//        t2.setDescricao(scan.nextLine());
//        tarefaService.saveTarefa(t1);
//        System.out.println("===============================================");
//        tarefaService.saveTarefa(t2);
//        System.out.println("===============================================");
//
//        System.out.println("========================================= TAREFAS =========================================");
//        for (Tarefa t : tarefaService.findAll()){
//            System.out.println(t.toString());
//            System.out.println("===============================================");
//        }
//
//        int idExc;
//        int escolhaS;
//        System.out.println("= ATULIZAR TAREFAS =");
//        System.out.println("= digite o número da tarefa que deseja atualizar: ");
//        idExc = scan.nextInt();
//        scan.nextLine();
//        Tarefa tarefaAtualizar = tarefaService.findById(idExc);
//        System.out.println("= Digite a descrição atualizada: ");
//        tarefaAtualizar.setDescricao(scan.nextLine());
//        System.out.println("= Escolha o status novo (1 - completa / 2 - incompleta: ");
//        escolhaS = scan.nextInt();
//        if (escolhaS == 1){
//            tarefaAtualizar.setStatus(StatusTarefa.COMPLETA);
//        } else if (escolhaS == 2) {
//           tarefaAtualizar.setStatus(StatusTarefa.INCOMPLETA);
//        }
//
////
////        System.out.println("= EXCLUIR TAREFAS =");
////        System.out.println("= Digite o número da tarefa que deseja excluir: ");
////        idExc = scan.nextInt();
////        if (tarefaService.delete(tarefaService.findById(idExc))){
////            System.out.println("= TAREFA EXCLUIDA COM SUCESSO!");
////        }else {
////            System.out.println("= OCORREU UM ERRRO.");
////        }
//
//        System.out.println("========================================= TAREFAS =========================================");
//        for (Tarefa t : tarefaService.findAll()){
//            System.out.println(t.toString());
//            System.out.println("===============================================");
//        }

        TarefaController tarefaController = new TarefaController();
        tarefaController.processamento();



        scan.close();
    }
}
