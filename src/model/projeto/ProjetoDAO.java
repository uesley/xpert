package model.projeto;

import database.DBConnection;
import database.MySQLConnection;
import java.util.ArrayList;
import model.IDAO;

public class ProjetoDAO implements IDAO<Projeto> {

    protected String table = "etapas";
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
        
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Projeto find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Projeto> get() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
