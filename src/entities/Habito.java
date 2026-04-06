package entities;

import java.util.List;

public class Habito extends Item{

    private int frequenciaSemana;

    public Habito(int frequenciaSemana) {
        this.frequenciaSemana = frequenciaSemana;
    }

    public Habito(String descricao, StatusItem statusItem, int frequenciaSemana) {
        super(descricao, statusItem);
        this.frequenciaSemana = frequenciaSemana;
    }
}
