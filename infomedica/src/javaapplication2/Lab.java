/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;
import java.io.Serializable;

/**
 *
 * @author super_000
 */
public class Lab implements Serializable {
    private String Nome;
    private String Tipodiacqu;
    private int[] anno=new int[2];
    private int[] mese=new int[12];
    private int[] giorno=new int[31];
    private int[] oraocc=new int[12];
    private String Descrizione;
    private String Operativo;
    public int getAnno(int A){
        return anno[A];
    }
    public int getMese(int A){
        return mese[A];
    }
    public int getGiorno(int A){
        return giorno[A];
    }
    public int getOra(int A)
    {
        return oraocc[A];
    }
    public String getTipo()
    {
        return this.Tipodiacqu;
    }
    public String getDescrizione()
    {
        return this.Descrizione;
    }
    public String getOperativo()
    {
        return this.Operativo;
    }
    public String getnome(){
      return this.Nome;
           }
    public Lab(String nome,String tipodiacqu,String Descrizione,String operativo)
    {
        set(nome,tipodiacqu,Descrizione,operativo);
    }
    
    	

	public void set(String nome,String tipo, String desc,String op){
		this.Nome=nome;
        this.Tipodiacqu=tipo;
        this.Descrizione=desc;
        this.Operativo=op;
		
	}
    public Lab(int a)
    {
        anno[0]=-1;
    }
    
}




