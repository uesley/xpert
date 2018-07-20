package model.etapa;

import java.util.ArrayList;

public interface IEtapa {

	public int getId();
	public void setId(int id);
	public String getNome();
	public void setNome(String nome);
	public String getDescricao();
	public void setDescricao(String descricao) ;
	public int getDuracao_prevista();
	public void setDuracao_prevista(int duracao_prevista);
	public int getDuracao_real();
	public void setDuracao_real(int duracao_real) ;
	public boolean getDisponibilidade();
	public void setDisponibilidade(boolean disponibilidade) ;
	public boolean getRealizado() ;
	public void setRealizado(boolean realizado) ;
	public int getProjeto();
	public void setProjeto(int projeto);
//	public void addDependencia(Etapa dependencia);
//        public void removeDependencia(Etapa dependencia);
//        public ArrayList<Etapa> getDependencias();
}
