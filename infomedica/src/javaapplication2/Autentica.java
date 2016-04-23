/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Autentica extends JFrame {

	private JPanel contenitore;
	private JTextField username;
	private JPasswordField password;
	private Database input;
	private Database output;
	private JLabel autenticazione;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Autentica frame = new Autentica();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Autentica() {
		setTitle("Autenticazione");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 331, 203);
		contenitore = new JPanel();
		contenitore.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contenitore);
		contenitore.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(10, 24, 69, 14);
		contenitore.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(10, 67, 63, 14);
		contenitore.add(lblPassword);
		
		username = new JTextField();
		username.setBounds(113, 17, 175, 29);
		contenitore.add(username);
		username.setColumns(10);
		username.setText("");
		
		password = new JPasswordField();
		password.setBounds(113, 60, 175, 29);
		contenitore.add(password);
		password.setText("");

		JButton btnNewButton = new JButton("Accedi");
		
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(156, 99, 89, 29);
		contenitore.add(btnNewButton);
		
		autenticazione = new JLabel("");
		autenticazione.setBounds(10, 133, 295, 20);
		contenitore.add(autenticazione);
		autenticazione.setVisible(false);
		btnNewButton.addMouseListener(new MouseAdapter() {
			
                        @Override
			public void mouseClicked(MouseEvent e) {
				
				int a=checkAutentication();

				if(a==0){//se è ==1 allora sto accedendo come amministratore
					autenticazione.setVisible(false);
                                        setVisible(false);
					username.setText("");
					password.setText("");
                                       

					LogAdmin FINESTRA = new LogAdmin();
					FINESTRA.setVisible(true);
					username.setText("");
					password.setText("");
                                        
					

               
					
				}
				
				else if(a==1){
					autenticazione.setVisible(false);
					setVisible(false);
					LogDoc windoc=new LogDoc(username.getText());
					windoc.setVisible(true);
					username.setText("");
					password.setText("");
				}
				
				else{
				    autenticazione.setForeground(Color.RED);
					autenticazione.setText("username e/o password non valida!");
					autenticazione.setVisible(true);
							
				}
				
			}
			
		});
		}
@SuppressWarnings("deprecation")
private int checkAutentication(){
	int temp=-1 ;
	if(admin(username.getText(),password.getText())){
		temp=0;
	}
	else{
		File file=new File("Data_access.txt");
		      if(file.exists()){
				   try {
					FileInputStream fis=new FileInputStream(file);
				    ObjectInputStream ois = new ObjectInputStream(fis);
					ArrayList<Login>  loginList=(ArrayList<Login>) ois.readObject();

					Login temporaneo;
					Iterator<Login> it=loginList.iterator();
					
					while(it.hasNext()&&temp==-1){
						temporaneo=it.next();

		 if(temporaneo.getUsername().equalsIgnoreCase(username.getText())&&temporaneo.getPassword().equalsIgnoreCase(password.getText())){
							temp=temporaneo.getAccessMode();}
						}
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
				    e.printStackTrace();			}
}  
		      else{	temp=10;	}
}
	return temp;
}
	
private boolean admin(String username,String password){
	
	return username.equalsIgnoreCase("admin")&&password.equalsIgnoreCase("admin");
}
}
