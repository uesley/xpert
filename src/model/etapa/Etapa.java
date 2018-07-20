package model.etapa;

import java.util.ArrayList;

import model.IDAO;

public class Etapa implements IEtapa, IDAO<Etapa> {

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
}
