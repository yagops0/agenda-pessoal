package services;

import entities.Habito;
import entities.StatusItem;
import repositories.DefaultRepository;

import java.util.ArrayList;
import java.util.List;

public class HabitoService implements DefaultRepository<Habito> {

    List<Habito> habitos = new ArrayList<>();

    @Override
    public void save(Habito habito) {

        if (this.findById(habito.getId()) == null){
            if (habito.getDescricao().isBlank() || habito.getDescricao() == null){
                System.out.println("= Não é possível salvar um habito sem descrição!");
            }else{
                habitos.add(habito);
                System.out.println("= Habito salvo com suceso!");
            }
        }else {
            if (habito.getDescricao().isBlank() || habito.getDescricao() == null){
                System.out.println("= Não é possível atualizar um habito sem descrição!");
            }else{
                habitos.set(habitos.indexOf(habito), habito);
                System.out.println("= Habito atualizado com suceso!");
            }
        }
    }

    @Override
    public boolean delete(Habito habito) {
        try {
            habitos.remove(habito);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Habito> findAll() {

        return this.habitos;
    }

    @Override
    public Habito findById(int id) {
        for (Habito h : habitos){
            if (h.getId() == id){
                return h;
            }
        }

        return null;
    }

    @Override
    public List<Habito> findByStatus(StatusItem statusItem) {

        List<Habito> habitosStatus= new ArrayList<>();

        for (Habito h : habitos){
            if (h.getStatusItem().toString().equalsIgnoreCase(StatusItem.PENDENTE.toString())){
                habitosStatus.add(h);
            }else if (h.getStatusItem().toString().equalsIgnoreCase(StatusItem.COMPLETO.toString())){
                habitosStatus.add(h);
            }
        }
        return habitosStatus;
    }

    @Override
    public boolean deleteAll() {
        try {
            habitos.clear();
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
