package repositories;

import entities.Tarefa;

import java.util.List;

public interface TarefaRepository {
    void saveTarefa(Tarefa tarefa); // também será o método para a atualizaçõa
    void deleteById(int id);
    List<Tarefa> findAll();
    Tarefa findById();
    void deleteAll();
}
