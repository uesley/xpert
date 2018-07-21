package xPertCore;

import java.util.ArrayList;
import java.lang.String;


public class XPert {
	private String Diretorio;
	private ArrayList<ProjetoCore> projetosAbertos = new ArrayList<ProjetoCore>(0);
	
	public void abreProjeto(String nome)
	{
		//Pega um projeto presente no Diret�rio e o coloca na mem�ria
	}
	public void fechaProjeto(String nome)
	{
		int n = projetosAbertos.size();
		
		for(int c=0;c<n;c++)
		{
			if((projetosAbertos.get(c)).getNome() == nome)
			{
				//Atualizar o banco de dados...
				projetosAbertos.remove(c);
				return;
			}
		}
		
		System.out.println("Projeto "+nome+" nao esta aberto" );
		return;
	}
	public ProjetoCore getProjeto(String nome)
	{
		int n = projetosAbertos.size();
		
		for(int c=0;c<n;c++)
		{
			if((projetosAbertos.get(c)).getNome() == nome)
				return projetosAbertos.get(c);
		}
		
		System.out.println("Projeto "+nome+" nao esta aberto" );
		return null;
	}
	public String getDiretorio()
	{
		return Diretorio;
	}
	public void setDiretorio(String dir)
	{
		if(dir != null)
			Diretorio = dir;
		else
			System.out.println("Diretorio Vazio");
	}
	
}
