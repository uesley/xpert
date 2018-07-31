package model.projeto;

import database.DBConnection;
import database.MySQLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import model.IDAO;
import model.etapa.Etapa;
import model.etapa.EtapaDAO;

class ProjetoDAO implements IDAO<Projeto> {

    protected String base = "xpert";
    protected String table = "projetos";
    protected String projectDB = "xpert_project_";
    private DBConnection database = new MySQLConnection(base);
    private Projeto projeto;

    public ProjetoDAO(Projeto p) {
        projeto = p;
    }

    @Override
    public void save() {
        String fields[] = {"nome","simulado","situacao"};
        String values[] = {projeto.getNome(), Integer.toString(projeto.getSimulado()?1:0), Float.toString(projeto.getSituacao())};
        database.insert(table, fields, values);
        int id = Integer.parseInt(database.query("select max(id) from projetos").get(0).get(0));
        String newBD = projectDB + id;
        database.command("create database `" + newBD + "`;");
        database.createTable(newBD+".etapas", createEtapasCommand());
        database.createTable(newBD+".dependencias", createDependenciasCommand());
        projeto.setId(id);
    }
    
    private String createEtapasCommand() {
        return " CREATE TABLE {0} (\n"
                + "  `id`INT NOT NULL AUTO_INCREMENT,\n"
                + "  `nome` VARCHAR(10) NOT NULL,\n"
                + "  `descricao` VARCHAR(45) NOT NULL,\n"
                + "  `duracao_prevista` INT NOT NULL DEFAULT 0,\n"
                + "  `disponibilidade` TINYINT NULL DEFAULT '0',\n"
                + "  `realizado` TINYINT NULL DEFAULT '0',\n"
                + "  `duracao_real` INT NULL DEFAULT 0,\n"
                + "  `folga` INT NULL DEFAULT 0,\n"
                + "  `menor_tempo_inicio` INT NULL DEFAULT 0,\n"
                + "  `maior_tempo_fim` INT NULL DEFAULT 0,\n"
                + "  `projeto` INT NOT NULL,\n"
                + "  PRIMARY KEY (`id`))"
                + "ENGINE = InnoDB;";
    }

    private String createDependenciasCommand() {
        return "CREATE TABLE {0} ("
                + "  `dependencia` INT(11) NOT NULL,"
                + "  `dependente` INT(11) NOT NULL,"
                + "  INDEX `index1` USING BTREE (`dependencia` ASC),"
                + "  INDEX `index2` (`dependente` ASC),"
                + "  CONSTRAINT `fk_dependencias_1`"
                + "    FOREIGN KEY (`dependente`)"
                + "    REFERENCES `etapas` (`id`)"
                + "    ON DELETE CASCADE"
                + "    ON UPDATE CASCADE,"
                + "  CONSTRAINT `fk_dependencias_2`"
                + "    FOREIGN KEY (`dependencia`)"
                + "    REFERENCES `etapas` (`id`)"
                + "    ON DELETE CASCADE"
                + "    ON UPDATE CASCADE,"
                + "  check(dependencia <> dependente))"
                + "ENGINE = InnoDB;";
    }

    @Override
    public void update() {
        String fields[] = {"nome", "situacao"};
        String values[] = {projeto.getNome(), Float.toString(projeto.getSituacao())};
        database.update(table, projeto.getId(), fields, values);
    }

    @Override
    public void delete() {
        database.delete(table, projeto.getId());
        database.command("DROP DATABASE "+projectDB+projeto.getId());
    }

    @Override
    public Projeto find(int id) {
        ArrayList<String> result = database.find(table, id);
        try {
            projeto.setId(Integer.parseInt(result.get(0)));
            projeto.setNome(result.get(1));
            projeto.setSituacao(Float.parseFloat(result.get(2)));
            projeto.setSimulado(Integer.parseInt(result.get(3))== 1);
        } catch (NullPointerException ex) {
            projeto = new Projeto();
        }
        return projeto;
    }

    @Override
    public ArrayList<Projeto> get() {
        ArrayList<Projeto> projetos = new ArrayList<>();
        ArrayList<ArrayList<String>> result = database.get(table);

        Iterator<ArrayList<String>> linha_i = result.iterator();
        while (linha_i.hasNext()) {
            ArrayList<String> linha = linha_i.next();
            Projeto projeto = new Projeto();
            projeto.setId(Integer.parseInt(linha.get(0)));
            projeto.setNome(linha.get(1));
            projeto.setSituacao(Float.parseFloat(linha.get(2)));
             projeto.setSimulado(Integer.parseInt(linha.get(3))== 1);
            projetos.add(projeto);
        }
        return projetos;
    }

    public ArrayList<Etapa> getEtapas() {
//        Etapa  = new EtapaDAO(new Etapa(projeto.getId()),projeto.getId());
//System.out.println("projeto: "+projeto.getId());
        return new Etapa(projeto.getId()).get();
    }

    public void export(String fileName) {
        database.export(fileName, "xpert_project_" + projeto.getId());
    }
    
    public void acquire(String filename, String ProjectName){
        projeto.setNome(ProjectName);
        projeto.setSituacao(0);
        projeto.save();
        int id = Integer.parseInt(database.query("select max(id) from projetos").get(0).get(0));
        database.acquire(filename, id);
    }
}
