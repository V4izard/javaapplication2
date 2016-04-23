/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author super_000
 */
public class Database {
    private File inputFile;
	private File outputFile;
	private File file;
    private DOTTORE dottore;
    private Login login;
    private static FileOutputStream fos;
    private static FileInputStream fis;
    private static ObjectOutputStream oos;
    private static ObjectInputStream ois;
    private ArrayList<DOTTORE> listDottore;
    private static ArrayList<Login>  listLogin;
    
    
    public Database(String fileName){
		file=new File(fileName);
		
	}
}
