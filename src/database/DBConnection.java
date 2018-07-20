package database;

import java.util.ArrayList;

public interface DBConnection {
	ArrayList<String> find(String table, int id);
	void insert(String table, String fields[], String values[]);
	void update(String table, int id, String fields[], String values[]);
	void delete(String table, int id);
	void command(String query);
	ArrayList<ArrayList<String>> get(String table);
	ArrayList<ArrayList<String>> query(String query);
	String getLastQuery();
}
