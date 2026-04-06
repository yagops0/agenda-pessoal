package entities;

public abstract class Item {
    private static int contador = 1; // simulando um AUTO_INCREMENT - UTILIZANDO UMA VÁRIAVEL ESTÁTICA POIS ELA PERTENCE A CLASSE NÃO A UMA INSTÂNCIA

    private int id;
    private String descricao;
    private StatusItem statusItem = StatusItem.PENDENTE;

    public Item(){
        this.id = contador++;
    }

    public Item(String descricao, StatusItem statusItem) {
        this.descricao = descricao;
        this.statusItem = statusItem;
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

    public StatusItem getStatusItem() {
        return statusItem;
    }

    public void setStatusItem(StatusItem statusItem) {
        this.statusItem = statusItem;
    }

}
