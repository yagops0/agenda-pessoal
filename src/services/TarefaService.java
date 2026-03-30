package services;

import entities.Tarefa;
import repositories.TarefaRepository;

import java.util.ArrayList;
import java.util.List;

public class TarefaService implements TarefaRepository {

    List<Tarefa> tarefas = new ArrayList<>();


    @Override
    public void saveTarefa(Tarefa tarefa) {

        if (this.findById(tarefa.getId()) == null){
            if (tarefa.getDescricao().isBlank() || tarefa.getDescricao() == null){
                System.out.println("= Não é possível salvar uma tarefa sem descrição!");
            }else{
                tarefas.add(tarefa);
                System.out.println("= Tarefa salva com suceso!");
            }
        }else {
            if (tarefa.getDescricao().isBlank() || tarefa.getDescricao() == null){
                System.out.println("= Não é possível atualizar uma tarefa sem descrição!");
            }else{
                tarefas.set(tarefas.indexOf(tarefa), tarefa);
                System.out.println("= Tarefa atualizada com suceso!");
            }
        }
    }

    @Override
    public boolean delete(Tarefa tarefa) {
        try {
            tarefas.remove(tarefa);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Tarefa> findAll() {

        return this.tarefas;
    }

    @Override
    public Tarefa findById(int id) {
        for (Tarefa t : tarefas){
            if (t.getId() == id){
                return t;
            }
        }

        return null;
    }

    @Override
    public boolean deleteAll() {
        try {
            tarefas.clear();
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
