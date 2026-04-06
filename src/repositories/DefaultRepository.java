package repositories;

import entities.StatusItem;
import entities.Tarefa;

import java.util.List;

public interface DefaultRepository<T> {
    void save(T value); // também será o método para a atualizaçõa
    boolean delete(T value);
    List<T> findAll();
    T findById(int id);
    List<T> findByStatus(StatusItem statusItem);
    boolean deleteAll();
}
