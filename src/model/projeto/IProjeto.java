
package model.projeto;

import java.util.ArrayList;
import model.etapa.Etapa;

public interface IProjeto {
 
    int getId();
    
    void setId(int id);
    
    public String getNome();

    public void setNome(String nome);

    public float getSituacao();

    public void setSituacao(float situacao);
    
    public ArrayList<Etapa> getEtapas();
    
    public void addEtapa(Etapa etapa);
    
    public void removeEtapa(Etapa etapa);
    
    public void removeEtapa(int etapa_id);
    
    public void export(String fileName);
    
    public void acquire(String fileName, String projectName);
    
}
