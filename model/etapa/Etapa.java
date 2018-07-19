package etapa;

import java.util.ArrayList;

import model.IDAO;

public class Etapa implements IEtapa,IDAO<Etapa>{
	private int id;
	private String nome;
	private String descricao;
	private int duracao_prevista;
	private int duracao_real;
	private short disponibilidade;
	private short realizado;
	private int projeto;
	private EtapaDAO dao;
	
	public Etapa() {
		 dao = new EtapaDAO(this);
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getDuracao_prevista() {
		return duracao_prevista;
	}
	public void setDuracao_prevista(int duracao_prevista) {
		this.duracao_prevista = duracao_prevista;
	}
	public int getDuracao_real() {
		return duracao_real;
	}
	public void setDuracao_real(int duracao_real) {
		this.duracao_real = duracao_real;
	}
	public boolean getDisponibilidade() {
		return disponibilidade != 0;
	}
	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = (short)(disponibilidade?1:0); 
	}
	public boolean getRealizado() {
		return  realizado != 0;
	}
	public void setRealizado(boolean realizado) {
		this.realizado = (short)(realizado?1:0);
	}
	public int getProjeto() {
		return projeto;
	}
	public void setProjeto(int projeto) {
		this.projeto = projeto;
	}
	
	@Override
	public void save() {
		dao.save();
	}
	@Override
	public void update() {
		dao.update();
		
	}
	@Override
	public void delete() {
		dao.delete();
	}
	@Override
	public Etapa find(int id) {
		return dao.find(id);
	}
	@Override
	public ArrayList<Etapa> get() {
		return dao.get();
	}
}
