package repositories;

import entities.Tarefa;

import java.util.List;

public interface TarefaRepository {
    void saveTarefa(Tarefa tarefa); // também será o método para a atualizaçõa
    boolean delete(Tarefa tarefa);
    List<Tarefa> findAll();
    Tarefa findById(int id);
    void deleteAll();
}
