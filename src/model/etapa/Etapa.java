package model.etapa;

import java.util.ArrayList;

import model.IDAO;
import xPertCore.EtapaCore;

public class Etapa implements IEtapa, IDAO<Etapa> {

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

    public Etapa() {
        dao = new EtapaDAO(this);
    }

    public int getFolga() {
        return folga;
    }

    public void setFolga(int folga) {
        this.folga = folga;
    }
    
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int getDuracao_prevista() {
        return duracao_prevista;
    }

    @Override
    public void setDuracao_prevista(int duracao_prevista) {
        this.duracao_prevista = duracao_prevista;
    }

    @Override
    public int getDuracao_real() {
        return duracao_real;
    }

    @Override
    public void setDuracao_real(int duracao_real) {
        this.duracao_real = duracao_real;
    }

    @Override
    public boolean getDisponibilidade() {
        return disponibilidade != 0;
    }

    @Override
    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = (short) (disponibilidade ? 1 : 0);
    }

    @Override
    public boolean getRealizado() {
        return realizado != 0;
    }

    @Override
    public void setRealizado(boolean realizado) {
        this.realizado = (short) (realizado ? 1 : 0);
    }

    @Override
    public int getProjeto() {
        return projeto;
    }

    @Override
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

    @Override
    public int getMenorTempoInicio() {
        return menor_tempo_inicio;
    }

    @Override
    public void setMenorTempoInicio(int menorTempoInicio) {
        menor_tempo_inicio = menorTempoInicio;
    }

    @Override
    public int getMenorTempoFim() {
        return menor_tempo_fim;
    }

    @Override
    public void setMenorTempoFim(int menorTempoFim) {
        menor_tempo_fim = menorTempoFim;
    }

    @Override
    public void addDependencia(Etapa dependencia) {
        dao.adicionarDependencias(dependencia.getId());
    }

    @Override
    public void addDependencia(int id_dependencia) {
        dao.adicionarDependencias(id_dependencia);
    }

    @Override
    public void removeDependencia(Etapa dependencia) {
        dao.removeDependencia(dependencia.getId());
    }

    @Override
    public void removeDependencia(int id_dependencia) {
        dao.removeDependencia(id_dependencia);
    }

    @Override
    public ArrayList<Etapa> getDependencias() {
        return dao.getDependencias();
    }

    @Override
    public int[] getDependenciasIDs() {
        return dao.getDependenciasID();
    }
    public EtapaCore convert()
    {
        EtapaCore target = new EtapaCoreore(getId(),getNome(),getDuracao_prevista(),getDescricao(), getDuracao_real(), getRealizado(), getMenorTempoInicio(), getMenorTempoFim(), getFolga(),null);
        return target;
    }
}


