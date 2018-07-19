package etapa;

import java.util.ArrayList;

import database.DBConnection;
import database.DBConnectionMySQL;
import model.IDAO;

public class EtapaDAO implements IDAO<Etapa>{

	protected String table = "etapas";
	private DBConnection database = new DBConnectionMySQL(); 
	private Etapa etapa;
	
	public EtapaDAO(Etapa e) {
		etapa = e;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void save() {
		
		String f[] = new String[2];
		ArrayList<String> fields = new ArrayList();
		fields.add("um");
		fields.add("dois");
	
		String v[] = new String[2];
		v[0] = "algo";
		v[1] = "outro";
		database.insert(table,(String[])fields.toArray(),v);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Etapa find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Etapa> get() {
		ArrayList<Etapa> etapas = new ArrayList<>();
		String[][] result = database.get(table);
		Etapa etapa;
		for (String linha[] : result) {
			etapa = new Etapa();
			etapa.setId(Integer.parseInt(linha[0]));
			etapa.setNome(linha[1]);
			etapa.setDescricao(linha[2]);
			etapa.setDuracao_prevista(Integer.parseInt(linha[3]));
			etapa.setDisponibilidade(Integer.parseInt(linha[4])!= 0);
			etapa.setRealizado(Integer.parseInt(linha[5]) != 0);
			etapa.setDuracao_real(Integer.parseInt(linha[6]));
			etapa.setProjeto(Integer.parseInt(linha[7]));
			etapas.add(etapa);
		}
		return etapas;
	}
	
	
}
