/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Classe com métodos para executar o dump do MySQL.
 * O "bin" do MySQL deve estar no PATH do SO.
 *
 * @author David Buzatto
 */
public class DumpMySQL {
    
    /**
     * Exporta para um arquivo os dados de uma base de dados específica.
     *
     * @param arquivo Caminho do arquivo que deve ser gerado com a
     * saída da exportação.
     * @param usuario Usuário usado para conectar na base.
     * @param senha Senha do usuário.
     * @param base Nome da base a ser exportada.
     * @param tabelas Tabelas da base especifica a serem exportadas. Caso não
     * seja expecificada nenhuma, todas as tabelas serão exportadas.
     * @throws IOException
     */
    public static void dump(
            String arquivo,
            String usuario,
            String senha,
            String base,
            String... tabelas ) throws IOException { 
        // prepara o comando
        StringBuilder sbComando = new StringBuilder( "mysqldump" );
        sbComando.append( " -u " );
        sbComando.append( usuario );
        // o valor do parâmetro -p não tem espaço!
        sbComando.append( " -p" );
        sbComando.append( senha );
        sbComando.append( " " );
        sbComando.append( " --no-create-info " );
        sbComando.append( base );
        for ( String tabela : tabelas ) {
            sbComando.append( " " );
            sbComando.append( tabela );
        }
        // executa o comando
        Process processo = Runtime.getRuntime().exec( sbComando.toString() );
        // cria os stream gobblers, um para o stream de entrada e um para o
        // stream de erro. os gobblers vão consumir os streams do processo
        StreamGobbler sgInput = new StreamGobbler(
                processo.getInputStream(), "input", new File( arquivo ) );
        StreamGobbler sgError = new StreamGobbler(
                processo.getErrorStream(), "error" );
        // cria uma thread para cada stream gobbler e as inicia
        new Thread( sgInput ).start();
        new Thread( sgError ).start();
    }
    
    /**
     * Exporta para um arquivo os dados de todas as bases de dados.
     *
     * @param arquivo Caminho do arquivo que deve ser gerado com a
     * saída da exportação.
     * @param usuario Usuário usado para conectar na base.
     * @param senha Senha do usuário.
     * @throws IOException
     */
    public static void dumpAll(
            String arquivo,
            String usuario,
            String senha ) throws IOException {
        dump( arquivo, usuario, senha, "--all-databases" );
    }
}

/**
 * Thread para consumir os streams de processos.
 * Baseada na implementação apresentada em:
 * http://www.javaworld.com/javaworld/jw-12-2000/jw-1229-traps.html?page=1
 *
 * @author David Buzatto
 */
class StreamGobbler implements Runnable {
    private InputStream is;
    private String type;
    private FileWriter fw;
    public StreamGobbler( InputStream is, String type ) {
        this.is = is;
        this.type = type;
    }
    public StreamGobbler( InputStream is, String type, File file )
            throws IOException {
        this.is = is;
        this.type = type;
        this.fw = new FileWriter( file );
    }
    @Override
    public void run() {
        try {
            InputStreamReader isr = new InputStreamReader( is );
            BufferedReader br = new BufferedReader( isr );
            String line = null;
            while ( ( line = br.readLine() ) != null ) {
                if ( fw != null ) {
                    fw.write( line + "\n" );
                } else {
                    System.out.println( type + ">" + line );
                }
            }
            if ( fw != null ) {
                fw.close();
            }
        } catch ( IOException ioe ) {
            ioe.printStackTrace();
        }
    }
    
    
    
}
