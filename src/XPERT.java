
import java.util.ArrayList;
import model.etapa.Etapa;
import model.projeto.Projeto;

public class XPERT {

    public static void main(String[] args) {

        // testeInsertEtapa("Novo Nome", "uma descricao qualquer", 12);
//            testeListEtapas();
//            testeFindEtapa();
//            testeEditEtapa();
//        testeAddDependencia();
//        testeListDependencias();
//        testeRemoveDependencia();
//testeNovoProjeto();
//testeListProjetos();
//        testeTodo();
        Projeto p = new Projeto();
        p.setNome("NovoProjeto");
        p.setSituacao(0);
        p.save();
        System.out.println(p.getId());
        Etapa e = new Etapa(p.getId()).find(3);
        System.out.println("E: " + e.getNome());
        e.addDependencia(3);
        e.setNome("uma ai");
        e.setDescricao("descricao da etapa");
        e.setProjeto(p.getId());
        e.setDuracao_prevista(30);
        e.save();
        Etapa e2 = new Etapa(p.getId()).find(5);
        e2.addDependencia(e);
        e2.setNome("outro nome");
        e2.setDescricao("Uma outra etapa");
        e2.setProjeto(p.getId());
        e2.setDuracao_prevista(20);
        e2.save();
        e2.addDependencia(e);
        p.export("/home/uesleymelo/xpert/xpert/base.sql");
        new Projeto().acquire("/home/uesleymelo/xpert/xpert/base.sql", "Projeto Importado");

    }

    public static void testeInsertEtapa(String nome, String descricao, int duracao_prevista) {
        Etapa etapa = new Etapa(42);
        etapa.setNome(nome);
        etapa.setDescricao(descricao);
        etapa.setDuracao_prevista(duracao_prevista);
        etapa.setProjeto(1);
        etapa.save();
    }

    public static void testeListEtapas() {
        Etapa etapa = new Etapa(42);
        for (Etapa e : etapa.get()) {
            System.out.println("id: " + e.getId());
            System.out.println("nome: " + e.getNome());
        }
    }

    public static void testeFindEtapa() {
        Etapa etapa = new Etapa(42).find(3);
        System.out.println("id : " + etapa.getId());
        System.out.println("nome : " + etapa.getNome());
    }

    public static void testeEditEtapa() {
        Etapa etapa = new Etapa(42).find(3);
        etapa.setNome("Mudando");
        etapa.setDescricao("nova Descricao");
        etapa.setDuracao_prevista(16);
        etapa.update();
        System.out.println("id : " + etapa.getId());
        System.out.println("nome : " + etapa.getNome());
    }

    public static void testeListaDependenciasID() {
        Etapa etapa = new Etapa(42).find(2);
        System.out.println("Dependencias de : [" + etapa.getId() + "]:" + etapa.getNome());
        for (int a : etapa.getDependenciasIDs()) {
            System.out.println(a);
        }
    }

    public static void testeListDependencias() {
        Etapa etapa = new Etapa(42).find(2);
        System.out.println("Dependencias de : [" + etapa.getId() + "]:" + etapa.getNome());
        for (Etapa e : etapa.getDependencias()) {
            System.out.println("[" + e.getId() + "] : " + e.getNome() + "");
        }
    }

    public static void testeAddDependencia() {
        Etapa etapa = new Etapa(42).find(3);
        etapa.addDependencia(1);
    }

    public static void testeRemoveDependencia() {
        Etapa etapa = new Etapa(42).find(3);
        etapa.removeDependencia(1);
    }

    public static void testeNovoProjeto() {
        Projeto p = new Projeto();
        p.setNome("outro projeto novo");
        p.save();
    }

    public static void testeListProjetos() {
        for (Projeto p : new Projeto().get()) {
            System.out.println("[" + p.getId() + "]: " + p.getNome());
        }
    }

    public static void testeTodo() {
        Projeto p = new Projeto().find(1);
        ArrayList<Etapa> etapas = p.getEtapas();
        for (Etapa e : etapas) {
            System.out.print("[" + e.getId() + "]: depende de: {");
            for (int i : e.getDependenciasIDs()) {
                System.out.print(i + ",");
            }
            System.out.println("}");
        }
    }

}
