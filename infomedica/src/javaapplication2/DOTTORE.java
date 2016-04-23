/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;
import java.io.Serializable;

public class DOTTORE implements Serializable {
	
	private String nome;
	private String cognome;
	private String specialistica;
	private String username;
        private String labass;
        private Paziente[] listapazienti;
	
	
	public DOTTORE(String nome, String cognome,String labass,String username,String specialistica){
		setNCP(nome,cognome,labass,username,specialistica);
		
	}

	public void setNCP(String nome,String cognome, String labass,String username,String specialistica){
		this.nome=nome;
                
       
		this.cognome=cognome;
		this.specialistica=specialistica;
		this.username=username;
                this.labass=labass;
		
	}
        public String getLab()
        {
            return this.labass;
        
        }
        public String getSpec()
        {
            return this.specialistica;
        }
	public String getCognome(){
		return this.cognome;
	}
	public String getNome(){
		return this.nome;
	}
	public String getUsername()
	{
		return username;
	}
	
	
}
