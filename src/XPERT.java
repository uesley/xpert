
import model.etapa.Etapa;

public class XPERT {

    public static void main(String[] args) {

        // testeInsertEtapa("Novo Nome", "uma descricao qualquer", 12);
//            testeListEtapas();
//            testeFindEtapa();
//            testeEditEtapa();
        testeListDependencias();
    }

    public static void testeInsertEtapa(String nome, String descricao, int duracao_prevista) {
        Etapa etapa = new Etapa();
        etapa.setNome(nome);
        etapa.setDescricao(descricao);
        etapa.setDuracao_prevista(duracao_prevista);
        etapa.setProjeto(1);
        etapa.save();
    }

    public static void testeListEtapas() {
        Etapa etapa = new Etapa();
        for (Etapa e : etapa.get()) {
            System.out.println("id: " + e.getId());
            System.out.println("nome: " + e.getNome());
        }
    }

    public static void testeFindEtapa() {
        Etapa etapa = new Etapa().find(3);
        System.out.println("id : " + etapa.getId());
        System.out.println("nome : " + etapa.getNome());
    }

    public static void testeEditEtapa() {
        Etapa etapa = new Etapa().find(3);
        etapa.setNome("Mudando");
        etapa.setDescricao("nova Descricao");
        etapa.setDuracao_prevista(16);
        etapa.update();
        System.out.println("id : " + etapa.getId());
        System.out.println("nome : " + etapa.getNome());
    }

    public static void testeInsertProjeto() {

    }

    public static void testeListaDependenciasID() {
        Etapa etapa = new Etapa().find(2);
        System.out.println("Dependencias de : [" + etapa.getId() + "]:" + etapa.getNome());
        for (int a : etapa.getDependenciasIDs()) {
            System.out.println(a);
        }
    }
    
    public static void testeListDependencias(){
        Etapa etapa = new Etapa().find(2);
        System.out.println("Dependencias de : [" + etapa.getId() + "]:" + etapa.getNome());
        for (Etapa e : etapa.getDependencias()) {
            System.out.println("["+e.getId()+"] : "+e.getNome()+"");
        }
    }

}
