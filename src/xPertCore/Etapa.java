package xPertCore;

import java.util.ArrayList;
import java.lang.String;

public class Etapa {
	private int identificacao;
	private String nome;
	private int tempoDeDuracaoPrevista;
	private int tempoDeDuracaoReal;
	private boolean realizado;
	private int menorTempoDeIncio;
	private int menorTempoDeFim;
	private int maiorTempoDeFolga;
	private ArrayList<Etapa> listaDeDependencias = new ArrayList<Etapa>(0);
	
	public Etapa(int idEtapa,String nomeEtapa,int ETA,ArrayList<Etapa> listaDeDependencias)
	{
		setIdentificacao(idEtapa);
		setNome(nomeEtapa);
		setTempoDeDuracaoPrevista(ETA);
		setRealizado(false);
		this.listaDeDependencias = listaDeDependencias;
	}

	public int getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(int identificacao) {
		this.identificacao = identificacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTempoDeDuracaoPrevista() {
		return tempoDeDuracaoPrevista;
	}

	public void setTempoDeDuracaoPrevista(int tempoDeDuracaoPrevista) {
		this.tempoDeDuracaoPrevista = tempoDeDuracaoPrevista;
	}

	public int getTempoDeDuracaoReal() {
		return tempoDeDuracaoReal;
	}

	public void setTempoDeDuracaoReal(int tempoDeDuracaoReal) {
		this.tempoDeDuracaoReal = tempoDeDuracaoReal;
	}

	public boolean isRealizado() {
		return realizado;
	}

	public void setRealizado(boolean realizado) {
		this.realizado = realizado;
	}

	public int getMenorTempoDeIncio() {
		return menorTempoDeIncio;
	}

	public void setMenorTempoDeIncio(int menorTempoDeIncio) {
		this.menorTempoDeIncio = menorTempoDeIncio;
	}

	public int getMenorTempoDeFim() {
		return menorTempoDeFim;
	}

	public void setMenorTempoDeFim(int menorTempoDeFim) {
		this.menorTempoDeFim = menorTempoDeFim;
	}

	public int getMaiorTempoDeFolga() {
		return maiorTempoDeFolga;
	}

	public void setMaiorTempoDeFolga(int maiorTempoDeFolga) {
		this.maiorTempoDeFolga = maiorTempoDeFolga;
	}

	public ArrayList<Etapa> getListaDeDependencias() {
		return listaDeDependencias;
	}

	public void setListaDeDependencias(ArrayList<Etapa> listaDeDependencias) {
		this.listaDeDependencias = listaDeDependencias;
	}
    public boolean isDisponivel()
    {
        int n=listaDeDependencias.size();
        boolean isAvaliable=true;
        for(int c=0;c<n;c++)
        {
            if(!listaDeDependencias.get(c).isRealizado())
                isAvaliable=false;
        }
        
        return isAvaliable; 
    }
    public boolean isDependencia(int idEtapa)
    {
    	  int n=listaDeDependencias.size();
          boolean isDependencie=false;
          for(int c=0;c<n;c++)
          {
        	  if(listaDeDependencias.get(c).getIdentificacao() == idEtapa)
                  isDependencie=true;
          }
          
          return isDependencie;
    }
	public void concluirEtapa(int tempoGasto)
	{
		setTempoDeDuracaoReal(tempoGasto);
		setRealizado(true);
		
	}
	
	
	
}
