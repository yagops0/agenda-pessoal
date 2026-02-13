package service;

import entities.Tarefa;
import repositories.TarefaRepository;

import java.util.ArrayList;
import java.util.List;

public class TarefaService implements TarefaRepository {

    List<Tarefa> tarefas = new ArrayList<>();

    @Override
    public boolean save(Tarefa tarefa){

        if (tarefa.getDescricao() == null || tarefa.getDescricao().equalsIgnoreCase("")){
            System.out.println("= Por favor adicione uma descrição à tarefa! Caso contrário ela não será salva!");
            return false;
        }else {
            this.tarefas.add(tarefa);
            return true;
        }
    }

    @Override
    public boolean deleteById(int id) {
        if (tarefas.isEmpty()){
            return false;
        }else if (id == tarefas.get(id - 1).getId()){
            tarefas.remove(id - 1);
        }
        return false;
    }
}
