package model.etapa;

import java.util.ArrayList;

import model.IDAO;
import xPertCore.EtapaCore;

public class Etapa implements IDAO<Etapa> {

    private int id;
    private String nome;
    private String descricao;
    private int duracao_prevista;
    private int duracao_real;
    private short disponibilidade;
    private short realizado;
    private int projeto;
    private int folga;
    private int menor_tempo_inicio;
    private int menor_tempo_fim;
    private EtapaDAO dao;

    public Etapa(int projeto) {
        this.projeto = projeto; 
        dao = new EtapaDAO(this, projeto);
    }

    public int getFolga() {
        return folga;
    }

    public void setFolga(int folga) {
        this.folga = folga;
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
        this.disponibilidade = (short) (disponibilidade ? 1 : 0);
    }

    
    public boolean getRealizado() {
        return realizado != 0;
    }

    
    public void setRealizado(boolean realizado) {
        this.realizado = (short) (realizado ? 1 : 0);
    }

    
    public int getProjeto() {
        return projeto;
    }

    
    public void setProjeto(int projeto) {
        this.projeto = projeto;
    }

    
    public void save() {
        dao.save();
    }

    
    public void update() {
        System.out.println("slacnaicsa: "+ this.getId());
        dao.update();
    }

    
    public void delete() {
        dao.delete();
    }

    
    public Etapa find(int id) {
        return dao.find(id);
    }

    
    public ArrayList<Etapa> get() {
        return dao.get();
    }

    
    public int getMenorTempoInicio() {
        return menor_tempo_inicio;
    }

    
    public void setMenorTempoInicio(int menorTempoInicio) {
        menor_tempo_inicio = menorTempoInicio;
    }

    
    public int getMenorTempoFim() {
        return menor_tempo_fim;
    }

    
    public void setMenorTempoFim(int menorTempoFim) {
        menor_tempo_fim = menorTempoFim;
    }

    
    public void addDependencia(Etapa dependencia) {
        dao.adicionarDependencias(dependencia.getId());
    }

    
    public void addDependencia(int id_dependencia) {
        dao.adicionarDependencias(id_dependencia);
    }

    
    public void removeDependencia(Etapa dependencia) {
        dao.removeDependencia(dependencia.getId());
    }

    
    public void removeDependencia(int id_dependencia) {
        dao.removeDependencia(id_dependencia);
    }

    
    public ArrayList<Etapa> getDependencias() {
        return dao.getDependencias();
    }

    
    public int[] getDependenciasIDs() {
        return dao.getDependenciasID();
    }
    public EtapaCore convert()
    {
        EtapaCore target = new EtapaCore(getId(),getNome(),getDuracao_prevista(),getDescricao(), getDuracao_real(), getRealizado(), getMenorTempoInicio(), getMenorTempoFim(), getFolga(),null);
        return target;
    }
}


