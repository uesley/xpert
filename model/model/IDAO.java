package model;

import java.util.ArrayList;

public interface IDAO<E> {

	public void save();
	
	void update();
	
	public void delete();
	
	public E find(int id);
	
	public ArrayList<E> get();
		
	
}
