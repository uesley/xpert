package model.etapa;

import java.util.ArrayList;

import database.DBConnection;
import database.MySQLConnection;
import java.util.Iterator;
import model.IDAO;

public class EtapaDAO implements IDAO<Etapa> {

    protected String table = "etapas";
    private DBConnection database = new MySQLConnection();
    private Etapa etapa;

    public EtapaDAO(Etapa e) {
        etapa = e;
    }

    @Override
    public void save() {

        String f[] = new String[2];
        ArrayList<String> fields = new ArrayList();
        fields.add("nome");
        fields.add("descricao");
        fields.add("duracao_prevista");
        fields.add("projeto");

        ArrayList<String> values = new ArrayList<>();
        values.add(etapa.getNome());
        values.add(etapa.getDescricao());
        values.add(Integer.toString(etapa.getDuracao_prevista()));
        values.add(Integer.toString(etapa.getProjeto()));
        database.insert(
                table,
                fields.toArray(new String[0]),
                values.toArray(new String[0]));
    }

    @Override
    public void update() {
        String f[] = new String[2];
        ArrayList<String> fields = new ArrayList();
        fields.add("nome");
        fields.add("descricao");
        fields.add("duracao_prevista");
        fields.add("duracao_real");
        fields.add("disponibilidade");
        fields.add("realizado");
        fields.add("projeto");
        
        ArrayList<String> values = new ArrayList<>();
        values.add(etapa.getNome());
        values.add(etapa.getDescricao());
        values.add(Integer.toString(etapa.getDuracao_prevista()));
        values.add(Integer.toString(etapa.getDuracao_real()));
        values.add(Integer.toString(etapa.getDisponibilidade()?1:0));
        values.add(Integer.toString(etapa.getRealizado()?1:0));
        values.add(Integer.toString(etapa.getProjeto()));
        database.update( 
                table,
                etapa.getId(),
                fields.toArray(new String[0]),
                values.toArray(new String[0]));
    }

    @Override
    public void delete() {
        database.delete(table, etapa.getId());
    }

    @Override
    public Etapa find(int id) {
        
        ArrayList<String> result = database.find(table, id);
        try{
            mapToEtapa(etapa,result);
        }catch(NullPointerException ex){
            etapa = new Etapa();
        }
        return etapa;
    }

    @Override
    public ArrayList<Etapa> get() {
        ArrayList<Etapa> etapas = new ArrayList<>();
        ArrayList<ArrayList<String>> result = database.get(table);
        Iterator<ArrayList<String>> linha_i = result.iterator();
        while(linha_i.hasNext()){
            ArrayList<String> linha = linha_i.next();
            etapas.add(mapToEtapa(linha));
        }
        return etapas;
    }
    
    public ArrayList<Etapa> getByProject(int idProjeto){
        ArrayList<Etapa> etapas = new ArrayList<>();
        String select = "SELECT * FROM `"+table+"` "
                + " where projeto="+idProjeto;
        ArrayList<ArrayList<String>> result = database.query(select);
        Iterator<ArrayList<String>> linha_i = result.iterator();
        while(linha_i.hasNext()){
            ArrayList<String> linha = linha_i.next();
            etapas.add(mapToEtapa(linha));
        }
        return etapas;
    }

    public void adicionarDependencias(int dependencia){
        String[] fields = {"dependente","dependencia"};
        String[] values = {Integer.toString(etapa.getId()), Integer.toString(dependencia)};
        database.insert("dependencias", fields, values);
    }
    
    public void removeDependencia(int dependencia){
        String delete = "DELETE FROM dependencias "
                + "WHERE dependencia=" + dependencia+" and "
                + "dependente="+etapa.getId();
        database.command(delete);
    }
    
    private void mapToEtapa(Etapa e, ArrayList<String> linha){
            etapa.setId(Integer.parseInt(linha.get(0)));
            etapa.setNome(linha.get(1));
            etapa.setDescricao(linha.get(2));
            etapa.setDuracao_prevista(Integer.parseInt(linha.get(3)));
            etapa.setDisponibilidade(Integer.parseInt(linha.get(4)) != 0);
            etapa.setRealizado(Integer.parseInt(linha.get(5)) != 0);
            etapa.setDuracao_real(Integer.parseInt(linha.get(6)));
            etapa.setProjeto(Integer.parseInt(linha.get(7)));
    }
    
    private Etapa mapToEtapa(ArrayList<String> linha){
            Etapa etapa = new Etapa();
            etapa.setId(Integer.parseInt(linha.get(0)));
            etapa.setNome(linha.get(1));
            etapa.setDescricao(linha.get(2));
            etapa.setDuracao_prevista(Integer.parseInt(linha.get(3)));
            etapa.setDisponibilidade(Integer.parseInt(linha.get(4)) != 0);
            etapa.setRealizado(Integer.parseInt(linha.get(5)) != 0);
            etapa.setDuracao_real(Integer.parseInt(linha.get(6)));
            etapa.setProjeto(Integer.parseInt(linha.get(7)));
            return etapa;
    }
    
    public ArrayList<Etapa> getDependencias(){
        ArrayList<Etapa> etapas = new ArrayList<>();
        String select = "SELECT "
                + "id,nome,descricao, duracao_prevista,disponibilidade,realizado,duracao_real,projeto"
                + " FROM dependencias inner join etapas on (dependencia = id)"
                + " where dependente="+etapa.getId();
        ArrayList<ArrayList<String>> result = database.query(select);
        Iterator<ArrayList<String>> linha_i = result.iterator();
        while(linha_i.hasNext()){
            ArrayList<String> linha = linha_i.next();
            etapas.add(mapToEtapa(linha));
        }
        return etapas;
    }
    
    public int[] getDependenciasID(){
        String select = "SELECT dependencia as id FROM dependencias where dependente="+etapa.getId();
        ArrayList<ArrayList<String>> resultBD = database.query(select);
        int result[] = new int[resultBD.size()];
        int i=0;
        for(ArrayList<String> row : resultBD)
            result[i++] = (Integer.parseInt(row.get(0)));
        return result;
    }
    
    
}
