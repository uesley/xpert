
package model.projeto;

import java.util.ArrayList;
import model.IDAO;
import model.etapa.Etapa;


public class Projeto implements IProjeto , IDAO<Projeto>{
    
  private int id;  
  private String nome;
  private float situacao;
  private ProjetoDAO dao;

  public Projeto(){
      this.dao = new ProjetoDAO(this);
  }
  
  @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
  
    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public float getSituacao() {
        return situacao;
    }

    @Override
    public void setSituacao(float situacao) {
        this.situacao = situacao;
    }

    @Override
    public void save() {
        dao.save();
    }

    @Override
    public void update() {
        dao.update();
    }

    @Override
    public void delete() {
        dao.delete();
    }

    @Override
    public Projeto find(int id) {
        return dao.find(id);
    }

    @Override
    public ArrayList<Projeto> get() {
        return dao.get();
    }

    @Override
    public ArrayList<Etapa> getEtapas() {
        return dao.getEtapas();
    }

    @Override
    public void addEtapa(Etapa etapa) {
        etapa.setProjeto(id);
        etapa.save();
    }

    @Override
    public void removeEtapa(Etapa etapa) {
        etapa.delete();
    }
    
    @Override
    public void removeEtapa(int etapa_id){
        Etapa e = new Etapa();
        e.setId(etapa_id);
        e.delete();
    }
}
