package database;

public interface DBConnection {
		
	void insert(String table, String fields[], String values[]);
	void update(String table, int id, String fields[], String values[]);
	void delete(String table, int id);
	void command(String query);
	String[][] get(String table);
	String[][] query(String query);
	String getLastQuery();
}
