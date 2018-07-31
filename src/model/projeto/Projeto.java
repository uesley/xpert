
package model.projeto;

import java.util.ArrayList;
import model.IDAO;
import model.etapa.Etapa;
import xPertCore.EtapaCore;
import xPertCore.ProjetoCore;


public class Projeto implements IDAO<Projeto>{
    
  private int id;  
  private String nome;
  private float situacao;
  private ProjetoDAO dao;
  private boolean simulado;
  
  public Projeto(){
      this.dao = new ProjetoDAO(this);
      
  }

    public ProjetoDAO getDao() {
        return dao;
    }

    public void setDao(ProjetoDAO dao) {
        this.dao = dao;
    }

    public boolean getSimulado() {
        return simulado;
    }

    public void setSimulado(boolean simulado) {
        this.simulado = simulado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSituacao() {
        return situacao;
    }

    public void setSituacao(float situacao) {
        this.situacao = situacao;
    }

    public void save() {
        dao.save();
    }

    public void update() {
        dao.update();
    }

    public void delete() {
        dao.delete();
    }
    
    public Projeto find(int id) {
        return dao.find(id);
    }

    public ArrayList<Projeto> get() {
        return dao.get();
    }

    public ArrayList<Etapa> getEtapas() {
        return dao.getEtapas();
    }
    
    public void addEtapa(Etapa etapa) {
        etapa.setProjeto(id);
        etapa.save();
    }
    
    public void updateEtapa(Etapa etapa) {
        etapa.setProjeto(id);
        etapa.update();
    }

    public void removeEtapa(Etapa etapa) {
        etapa.delete();
    }
    
    public void removeEtapa(int etapa_id){
        Etapa e = new Etapa(id);
        e.setId(etapa_id);
        e.delete();
    }
    public ProjetoCore convert()
    {   
//        System.out.println("id: "+getId());
        ArrayList<Etapa> aux = getEtapas();
        ArrayList<EtapaCore> etapasTarget = new ArrayList<>(0);
        int n = aux.size();
        
        for(int c=0;c<n;c++)
            etapasTarget.add(c,aux.get(c).convert());
        
        for(int c=0;c<n;c++)
        {
            ArrayList<EtapaCore> etapasTargetRef = new ArrayList<>(0);
            int idDep[] = aux.get(c).getDependenciasIDs();
            for(int j=0;j<idDep.length;j++)
                for(int k=0;k<n;k++)
                {
                    if(idDep[j] == etapasTarget.get(k).getIdentificacao())
                       etapasTargetRef.add(etapasTarget.get(k));
                }
            etapasTarget.get(c).setListaDeDependencias(etapasTargetRef);
        }
        ProjetoCore target = new ProjetoCore(etapasTarget,getId(),getNome());
        return target;
    }

    public void export(String fileName) {
        dao.export(fileName);
    }

    public void acquire(String fileName, String projectName) {
        dao.acquire(fileName, projectName);
    }

}
