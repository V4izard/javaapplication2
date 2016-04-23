/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;
import java.io.*;


public class Login implements Serializable{
	private String username;
	private String password;
	private String codeAccess;//0 amministratore,1 dottore
	
	public Login(String username, String password,String codeAccess){
		setUsername(username);
		setPassword(password);
		setCodeAccess(codeAccess);
	}
	public Login(String username, String password){
		setUsername(username);
		setPassword(password);
	}
	
	public void setCodeAccess(String codeAccess){
		this.codeAccess=codeAccess;
	}
	
	public void setUsername(String username){
		this.username=username;
	}
	
	public void setPassword(String password){
		this.password=password;
	}
public int getAccessMode(){
	return Integer.parseInt(codeAccess);
	
}
	public String getUsername(){
		return username;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	
}
