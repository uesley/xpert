package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBConnectionMySQL implements DBConnection{

	private String lastQuery;
	private Connection conexao;
	private String HOST = "localhost";
	private String PORT = "3306";
	private String USER = "root";
	private String PASS = "?R00t_bd!";
	private String BASE = "xpert";
	private String DRIVER = "com.mysql.cj.jdbc.Driver";
	private String URL = "jdbc:mysql://" + HOST + "/" + BASE;
	
	
	
	public DBConnectionMySQL() {
		
		try {
			Class.forName(DRIVER);
			conexao = DriverManager.getConnection(URL, USER, PASS);
			if (conexao == null) {
				System.out.println("Erro inesperado no banco de dados");
				System.exit(0);
			}
		}catch (ClassNotFoundException e) {
			System.out.println("O driver de Banco de dados nao foi encontrado");
			System.exit(0);
		} catch (SQLException e) {
			System.out.println("As informações de conexão com o Banco estão desatualizadas");
			System.exit(0);
		}
		
	}

	
	@Override
	public void insert(String table, String[] fields, String[] values) {
		if ((fields.length <= 0 && values.length <=0 )|| fields.length != values.length) 
			return;
		String f = "`"+String.join("`,`", fields)+"`";
		String v = "`"+String.join("`,", values)+"`";
		String query = "INSERT INTO `"+table+"` ("+f+") values("+v+")";
		System.out.println("usando banco: mysql, inserindo em : "+table);	
		System.out.println("Query: "+ query);
//		command(query);
	}

	@Override
	public void delete(String table, int id) {
		// TODO Auto-generated method stub
		
	}

	public void update(String table, int id, String[] fields, String[] values) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void command(String query) {
		lastQuery = query;
		try {
			PreparedStatement ps = conexao.prepareCall(query);
			ps.execute();
		} catch (SQLException e) {
			System.out.println("não foi possivel executar o omando SQL: "+query);
		}
	}

	@Override
	public String[][] query(String query) {
		// TODO Auto-generated method stub
		ArrayList<String[]> result = new ArrayList<>();
		try {
			PreparedStatement ps = conexao.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
//			int rows = rs.getRow
			int qtd = rs.getMetaData().getColumnCount();
			while(rs.next()) {
				String reg[] = new String[qtd];
				reg = rs.getRow()
				
				rs.getType();
//				rs.getMetaData().getColumnType(column)
//				registro.add(rs.getInt(0));
			}
		}catch(SQLException e) {
			System.out.println("");
		}
	}

	@Override
	public String[][] get(String table) {
		String query = "SELECT * FROM `"+ table + "`";
		
		
		return null;
	}
	
	@Override
	public String getLastQuery() {
		return lastQuery;
	}
	
}
