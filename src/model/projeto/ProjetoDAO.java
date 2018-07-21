package model.projeto;

import database.DBConnection;
import database.MySQLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import model.IDAO;
import model.etapa.Etapa;
import model.etapa.EtapaDAO;

class ProjetoDAO implements IDAO<Projeto> {

    protected String table = "projetos";
    private DBConnection database = new MySQLConnection();
    private Projeto projeto;

    public ProjetoDAO(Projeto p) {
        projeto = p;
    }

    @Override
    public void save() {
        String fields[] = {"nome"};
        String values[] = {projeto.getNome()};
        database.insert(table, fields, values);
    }

    @Override
    public void update() {
        String fields[] = {"nome","situacao"};
        String values[] = {projeto.getNome(),Float.toString(projeto.getSituacao())};
        database.update(table, projeto.getId(), fields, values);
    }

    @Override
    public void delete() {
        database.delete(table, projeto.getId());
    }

    @Override
    public Projeto find(int id) {
        ArrayList<String> result = database.find(table, id);
        try{
            projeto.setId(Integer.parseInt(result.get(0)));
            projeto.setNome(result.get(1));
            projeto.setSituacao(Float.parseFloat(result.get(2)));
            
        }catch(NullPointerException ex){
            projeto = new Projeto();
        }
        return projeto;
    }

    @Override
    public ArrayList<Projeto> get() {
        ArrayList<Projeto> projetos = new ArrayList<>();
        ArrayList<ArrayList<String>> result = database.get(table);
        
        Iterator<ArrayList<String>> linha_i = result.iterator();
        while(linha_i.hasNext()){
            ArrayList<String> linha = linha_i.next();
            Projeto projeto = new Projeto();
            projeto.setId(Integer.parseInt(linha.get(0)));
            projeto.setNome(linha.get(1));
            projeto.setSituacao(Float.parseFloat(linha.get(2)));
            projetos.add(projeto);
        }
        return projetos;
    }
    
    public ArrayList<Etapa> getEtapas(){
        EtapaDAO dao = new EtapaDAO(new Etapa());
        return dao.getByProject(projeto.getId());
    }
}
