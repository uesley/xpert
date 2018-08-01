package xPertCore;

import java.util.ArrayList;
import java.lang.String;
import model.projeto.Projeto;

public class ProjetoCore {

    private int id;
    private String nome;
    private double situacao;
    private int ETA;
    private int atraso;
    private boolean simulado;
    private ArrayList<EtapaCore> etapasVinculadas = new ArrayList<EtapaCore>(0);

    public ProjetoCore(ArrayList<EtapaCore> etapasNecessarias, int idProjeto, String nomeProjeto) {
        etapasVinculadas = etapasNecessarias;
        setIdentificacao(idProjeto);
        setNome(nomeProjeto);
        setETA(0);
    }

    public boolean getSimulado() {
        return simulado;
    }

    public void setSimulado(boolean simulado) {
        this.simulado = simulado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nomeProjeto) {
        nome = nomeProjeto;
    }

    public int getIdentificacao() {
        return id;
    }

    public void setIdentificacao(int idProjeto) {
        if (idProjeto >= 0) {
            id = idProjeto;
        } else {
            System.out.println("Id invalido");
        }
    }

    public int getSituacao() {
        int n = etapasVinculadas.size();
        int tempoRealizado = 0, tempoTotal = 0;
        for (int c = 0; c < n; c++) {
            if (etapasVinculadas.get(c).isRealizado()) {
                tempoRealizado += etapasVinculadas.get(c).getTempoDeDuracaoPrevista();
            }

            tempoTotal += etapasVinculadas.get(c).getTempoDeDuracaoPrevista();
        }

        return (int)((double) (tempoRealizado*100) / tempoTotal);
    }

    public int getAtraso() {
        int n = etapasVinculadas.size();
        int tempoAtrasado = 0;
        for (int c = 0; c < n; c++) {
            if (etapasVinculadas.get(c).isRealizado()) {
                int aux = (etapasVinculadas.get(c).getTempoDeDuracaoReal() - etapasVinculadas.get(c).getTempoDeDuracaoPrevista() - etapasVinculadas.get(c).getMaiorTempoDeFolga());

                if (aux > 0) {
                    tempoAtrasado += aux;
                }
            }
        }
        setAtraso(tempoAtrasado);
        return tempoAtrasado;
    }

    public void setAtraso(int atraso) {
        this.atraso = atraso;
    }

    public int getETA() {
        return ETA;
    }

    public void setETA(int eTA) {
        ETA = eTA;
    }

    public EtapaCore getEtapa(int idEtapa) {
        int n = etapasVinculadas.size();
        for (int c = 0; c < n; c++) {
            if (etapasVinculadas.get(c).getIdentificacao() == idEtapa) {
                return etapasVinculadas.get(c);
            }
        }

        System.out.println("Etapa não vinculada ao projeto");
        return null;
    }

    public ArrayList<EtapaCore> getEtapasDisponiveis() {
        int n = etapasVinculadas.size();
        ArrayList<EtapaCore> etapasDisponiveis = new ArrayList<EtapaCore>(0);

        for (int c = 0; c < n; c++) {
            if (etapasVinculadas.get(c).isDisponivel() && !etapasVinculadas.get(c).isRealizado()) {
                etapasDisponiveis.add(etapasVinculadas.get(c));
            }
        }

        return etapasDisponiveis;

    }
    public int getEtapasAtrasadas()
    {
        int n = etapasVinculadas.size();
        int ct=0;
        for(int c=0;c<n;c++)
        {
            if(etapasVinculadas.get(c).isAtrasada())
                ct++;
        }
        return ct;
    }
    public int getEtapasCriticas()
    {
        int n = etapasVinculadas.size();
        int ct=0;
        for(int c=0;c<n;c++)
        {
            if(etapasVinculadas.get(c).isCritica())
                ct++;
        }
        return ct;
    }

    public ArrayList<EtapaCore> getEtapasConcluidas() {
        int n = etapasVinculadas.size();
        ArrayList<EtapaCore> etapasConculuidas = new ArrayList<EtapaCore>(0);

        for (int c = 0; c < n; c++) {
            if (etapasVinculadas.get(c).isRealizado()) {
                etapasConculuidas.add(etapasVinculadas.get(c));
            }
        }

        return etapasConculuidas;
    }

    public int getEtapasAFazer() {
        return etapasVinculadas.size() - getEtapasConcluidas().size();
    }

    public void simular() {
       
        if (!getSimulado()) {
            int time = 0;
            int depth = 0;
            ArrayList<EtapaCore> abertos = new ArrayList<EtapaCore>(0);

            while (getEtapasAFazer() > 0) {
                int maiorTempofinal = 0;
                abertos = getEtapasDisponiveis();

                int n = abertos.size();

                for (int c = 0; c < n; c++) {
                    abertos.get(c).setMenorTempoDeIncio(time);
                    abertos.get(c).setMenorTempoDeFim(abertos.get(c).getMenorTempoDeIncio() + abertos.get(c).getTempoDeDuracaoPrevista());
                    abertos.get(c).setRealizado(true);
                    abertos.get(c).setProfundidade(depth);

                    if (abertos.get(c).getMenorTempoDeFim() > maiorTempofinal) {
                        maiorTempofinal = abertos.get(c).getMenorTempoDeFim();
                    }
                }

                for (int c = 0; c < n; c++) {
                    abertos.get(c).setMaiorTempoDeFolga(maiorTempofinal - abertos.get(c).getMenorTempoDeFim());
                }

                time = maiorTempofinal;
                depth++;

            }

            int n = etapasVinculadas.size();

            for (int c = 0; c < n; c++) {
                etapasVinculadas.get(c).setRealizado(false);
            }
            setETA(time);
            situacao = 0;
            setSimulado(true);
        } else {
            System.out.println("Projeto foi previamente simulado");
        }
    }

    public void concluirEtapaVinculada(int idEtapa, int tempoGasto) {
        getEtapa(idEtapa).concluirEtapa(tempoGasto);
    }
    public int[] getProfundidades()
    {
        int profundidades[] = new int[3];
        ArrayList<EtapaCore> aux = new ArrayList<EtapaCore>(0);
        int maior = 0,menor = 0;
        boolean primeiro = true;
        aux = getEtapasDisponiveis();
        
        while(!aux.isEmpty())
        {
            int depth = aux.get(0).getProfundidade();
            if(primeiro)
            {
                maior = menor = depth;
                primeiro = false;
            }
            else
            {   
                if(depth > maior)
                {
                    maior = depth;
                }
                
                if(depth < menor)
                {
                    menor = depth;
                }
            }
            aux.remove(0);
        }
        
        profundidades[0] = menor;
        profundidades[1] = maior;
        primeiro = true;
        
        int n = etapasVinculadas.size();
        
        for(int c=0;c<n;c++)
        {
            if(primeiro)
            {
                maior = etapasVinculadas.get(c).getProfundidade();
                primeiro = false;
            }
            else
            {
                if(etapasVinculadas.get(c).getProfundidade() > maior)
                    maior = etapasVinculadas.get(c).getProfundidade();
            }
        }
        
        profundidades[2] = maior;
        
        return profundidades;
    }

    public Projeto convert() {
        Projeto targetProjeto = new Projeto();
        int n = etapasVinculadas.size();
        targetProjeto.setNome(getNome());
        targetProjeto.setId(getIdentificacao());
        targetProjeto.setSimulado(getSimulado());
        targetProjeto.setSituacao((float) getSituacao());
        for (int c = 0; c < n; c++) {
            targetProjeto.updateEtapa(etapasVinculadas.get(c).convert(targetProjeto.getId()));
        }
        return targetProjeto;
    }
    public int getDiasRestantes()
    {
        ArrayList<EtapaCore> concluidas = getEtapasConcluidas();
        int sum=0,n=concluidas.size();
        for(int c=0;c<n;c++)
            sum+=concluidas.get(c).getTempoDeDuracaoPrevista();
        
        return getETA()-sum;
    }
}
