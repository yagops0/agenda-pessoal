package entities;

public class Tarefa {
    private static int contador = 1; // simulando um AUTO_INCREMENT - UTILIZANDO UMA VÁRIAVEL ESTÁTICA POIS ELA PERTENCE A CLASSE NÃO A UMA INSTÂNCIA

    private int id;
    private String descricao;
    private boolean status;

    public Tarefa(){
        this.id = contador++;
    }

    public Tarefa(String descricao, boolean status) {

        this.descricao = descricao;
        this.status = status;
        this.id = contador++;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString(){
        return "= Tarefa: " + id +
                " - " + descricao +
                " - Status: " + status;
    }
}
