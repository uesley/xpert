package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLConnection implements DBConnection {

    private String lastQuery;
    private Connection conexao;
    private String HOST = "localhost";
    private String PORT = "3306";
    private String USER = "root";
    private String PASS = "";
    private String BASE = "xpert";
    private String DRIVER = "com.mysql.cj.jdbc.Driver";
    private String URL = "jdbc:mysql://" + HOST + "/" + BASE + "?useTimezone=true&serverTimezone=UTC";

    public MySQLConnection() {

        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USER, PASS);
            if (conexao == null) {
                System.out.println("Erro inesperado no banco de dados");
                System.exit(0);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("O driver de Banco de dados nao foi encontrado");
            System.exit(0);
        } catch (SQLException e) {
            System.out.println("As informações de conexão com o Banco estão desatualizadas");
            System.out.println(e.getMessage());
            System.exit(0);
        }

    }

    @Override
    public void insert(String table, String[] fields, String[] values) {
        if ((fields.length <= 0 && values.length <= 0) || fields.length != values.length) {
            return;
        }
        String f = "`" + String.join("`,`", fields) + "`";
        String v = "'" + String.join("','", values) + "'";
        String query = "INSERT INTO `" + table + "` (" + f + ") values(" + v + ")";
//        System.out.println("usando banco: mysql, inserindo em : " + table);
//        System.out.println("Query: " + query);
		command(query);
    }

    @Override
    public void delete(String table, int id) {
        String query = "DELETE FROM `"+table+"` where `id`="+id;
        command(query);
    }

    @Override
    public void update(String table, int id, String[] fields, String[] values) {
        String query = "UPDATE `"+table+"` SET "; 
        String sets[] = new String[fields.length];
        for (int i = 0; i<fields.length;i++)
            sets[i] = "`"+fields[i]+"` = '"+values[i]+"'";
        query += String.join(" , ", sets);
        query += "where  `id`="+id;
        command(query);
    }

    @Override
    public void command(String query) {
        lastQuery = query;
        try {
            PreparedStatement ps = conexao.prepareCall(query);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("não foi possivel executar o omando SQL: " + query);
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ArrayList<ArrayList<String>> query(String query) {
        ArrayList<ArrayList<String>> result = new ArrayList();
        try {
            PreparedStatement ps = conexao.prepareStatement(query);
            lastQuery = query;
            ResultSet rs = ps.executeQuery();
            int qtd_colunas = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                ArrayList<String> row = new ArrayList<>();
                for (int i =0;i < qtd_colunas; i++)
                    row.add(rs.getString(i+1));
                result.add(row);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar o comando SQL: "+query);
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public ArrayList<ArrayList<String>> get(String table) {
        String query = "SELECT * FROM `" + table + "`";
        return query(query);
    }

    @Override
    public ArrayList<String> find(String table, int id) {
        String query = "SELECT * FROM `"+table+"` WHERE `id`="+id;
        ArrayList<ArrayList<String>> rs = query(query);
        return rs.size()>0?rs.get(0):null;
    }

    @Override
    public String getLastQuery() {
        return lastQuery;
    }

}
