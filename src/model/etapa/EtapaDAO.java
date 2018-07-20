package model.etapa;

import java.util.ArrayList;

import database.DBConnection;
import database.DBConnectionMySQL;
import java.util.Iterator;
import model.IDAO;

public class EtapaDAO implements IDAO<Etapa> {

    protected String table = "etapas";
    private DBConnection database = new DBConnectionMySQL();
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
        
        ArrayList<String> values = new ArrayList<>();
        values.add(etapa.getNome());
        values.add(etapa.getDescricao());
        values.add(Integer.toString(etapa.getDuracao_prevista()));
        values.add(Integer.toString(etapa.getDuracao_real()));
        values.add(Integer.toString(etapa.getDisponibilidade()?1:0));
        values.add(Integer.toString(etapa.getRealizado()?1:0));
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
            etapa.setId(Integer.parseInt(result.get(0)));
            etapa.setNome(result.get(1));
            etapa.setDescricao(result.get(2));
            etapa.setDuracao_prevista(Integer.parseInt(result.get(3)));
            etapa.setDisponibilidade(Integer.parseInt(result.get(4)) != 0);
            etapa.setRealizado(Integer.parseInt(result.get(5))!= 0);
            etapa.setDuracao_real(Integer.parseInt(result.get(6)));
            etapa.setProjeto(Integer.parseInt(result.get(7)));
            return etapa;
        }catch(NullPointerException ex){
            return new Etapa();
        }
    }

    @Override
    public ArrayList<Etapa> get() {
        ArrayList<Etapa> etapas = new ArrayList<>();
        ArrayList<ArrayList<String>> result = database.get(table);
        
        Iterator<ArrayList<String>> linha_i = result.iterator();
        while(linha_i.hasNext()){
            ArrayList<String> linha = linha_i.next();
            Etapa etapa = new Etapa();
            etapa.setId(Integer.parseInt(linha.get(0)));
            etapa.setNome(linha.get(1));
            etapa.setDescricao(linha.get(2));
            etapa.setDuracao_prevista(Integer.parseInt(linha.get(3)));
            etapa.setDisponibilidade(Integer.parseInt(linha.get(4)) != 0);
            etapa.setRealizado(Integer.parseInt(linha.get(5)) != 0);
            etapa.setDuracao_real(Integer.parseInt(linha.get(6)));
            etapa.setProjeto(Integer.parseInt(linha.get(7)));
            etapas.add(etapa);
        }
        return etapas;
    }

}
