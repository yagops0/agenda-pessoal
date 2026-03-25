package services;

import entities.Tarefa;
import repositories.TarefaRepository;

import java.util.ArrayList;
import java.util.List;

public class TarefaService implements TarefaRepository {

    List<Tarefa> tarefas = new ArrayList<>();
    @Override
    public void saveTarefa(Tarefa tarefa) {

        if (tarefa.getDescricao().isBlank() || tarefa.getDescricao() == null){
            System.out.println("= Não é possível salvar uma tarefa sem descrição!");
        }else{
            tarefas.add(tarefa);
            System.out.println("= Tarefa salva com suceso!");
        }
    }

    @Override
    public void deleteById(int id) {
        return;
    }

    @Override
    public List<Tarefa> findAll() {
        return tarefas;
    }

    @Override
    public Tarefa findById() {
        return null;
    }

    @Override
    public void deleteAll() {
        return;
    }
}
