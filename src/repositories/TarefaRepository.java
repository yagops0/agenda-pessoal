package repositories;

import entities.Tarefa;

public interface TarefaRepository {

    boolean save(Tarefa tarefa);
    boolean deleteById(int id);
    boolean findById(int id);
    boolean findAll();
    boolean updateById(int id);
}
