package entities;

public class Tarefa extends Item{

    private PrioridadeTarefa prioridadeTarefa;


    public Tarefa(PrioridadeTarefa prioridadeTarefa) {
        this.prioridadeTarefa = prioridadeTarefa;
    }

    public Tarefa(String descricao, StatusItem statusItem, PrioridadeTarefa prioridadeTarefa) {
        super(descricao, statusItem);
        this.prioridadeTarefa = prioridadeTarefa;
    }
}
