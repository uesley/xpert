package xPertCore;

import java.util.ArrayList;
import java.lang.String;
import model.etapa.Etapa;

public class EtapaCore {
	private int id;
        private int id_projeto;
	private String nome;
	private int tempoDeDuracaoPrevista;
	private int tempoDeDuracaoReal;
	private boolean realizado;
	private int menorTempoDeIncio;
	private int menorTempoDeFim;
	private int maiorTempoDeFolga;
        private String descricao;
        
        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }
	private ArrayList<EtapaCore> listaDeDependencias = new ArrayList<EtapaCore>(0);
	
	public EtapaCore(int idEtapa,String nomeEtapa,int ETA,ArrayList<EtapaCore> listaDeDependencias, int id_projeto)
	{
		setIdentificacao(idEtapa);
		setNome(nomeEtapa);
		setTempoDeDuracaoPrevista(ETA);
		setRealizado(false);
		this.listaDeDependencias = listaDeDependencias;
	}
        public EtapaCore(int idEtapa,String nomeEtapa,int ETA,String descricao,int tempoDeDuracaoReal,boolean realizado,int menorTempoDeInicio,int menorTempoDeFim,int maiorTempoDeFolga,ArrayList<EtapaCore> listaDeDependencias)
	{
		setIdentificacao(idEtapa);
		setNome(nomeEtapa);
		setTempoDeDuracaoPrevista(ETA);
		setRealizado(false);
                setDescricao(descricao);
                setTempoDeDuracaoReal(tempoDeDuracaoReal);
                setRealizado(realizado);
                setMenorTempoDeIncio(menorTempoDeIncio);
                setMenorTempoDeFim(menorTempoDeFim);
                setMaiorTempoDeFolga(maiorTempoDeFolga);
		this.listaDeDependencias = listaDeDependencias;
	}

	public int getIdentificacao() {
		return id;
	}

	public void setIdentificacao(int identificacao) {
		this.id = identificacao;
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

	public ArrayList<EtapaCore> getListaDeDependencias() {
		return listaDeDependencias;
	}

	public void setListaDeDependencias(ArrayList<EtapaCore> listaDeDependencias) {
		this.listaDeDependencias = listaDeDependencias;
	}
    public boolean isDisponivel()
    {
        int n=listaDeDependencias.size();
        boolean isAvaliable=true;
        for(int c=0;c<n;c++)
        {
            if(!listaDeDependencias.get(c).isRealizado())
                isAvaliable = false;
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
        public Etapa convert(int id_projeto)
        {
            Etapa targetEtapa = new Etapa(id_projeto);
            targetEtapa.setDescricao(getDescricao());
            targetEtapa.setDisponibilidade(isDisponivel());
            targetEtapa.setDuracao_prevista(getTempoDeDuracaoPrevista());
            targetEtapa.setDuracao_real(getTempoDeDuracaoReal());
            targetEtapa.setFolga(getMaiorTempoDeFolga());
            targetEtapa.setId(getIdentificacao());
            targetEtapa.setMenorTempoFim(getMenorTempoDeFim());
            targetEtapa.setMenorTempoInicio(getMenorTempoDeIncio());
            targetEtapa.setNome(getNome());
            
            return targetEtapa;
        }
        public String toString()
        {
            return "Id: "+getIdentificacao()+"\nNome:"+getNome()+"\nRealizado? "+isRealizado()+"\n Disponivel? "+isDisponivel();
        }
        public boolean isAtrasada()
        {
            return getTempoDeDuracaoReal()-getTempoDeDuracaoPrevista()>0;
        }
        public boolean isCritica()
        {
            return getMaiorTempoDeFolga()==0;
        }
	
	
}
