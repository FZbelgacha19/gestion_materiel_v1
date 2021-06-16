package testpack;


import java.lang.reflect.Field;

import comptable.models.Commande;
import magasinier.models.*;
import professeur.models.*;
import technicien.models.*;


public class sql {

	public static void main(String[] args) {
		Class cl = Intervention.class;
		
	    Field[] fields = cl.getDeclaredFields();
	    String[] name = cl.getName().split("\\.");

	    String query = "CREATE TABLE "+name[2]+"( \n";
	    for(int i=0;i<fields.length;i++){
	        if(fields[i].getType().getSimpleName().toLowerCase().equals("long") || fields[i].getType().getSimpleName().toLowerCase().contains("int")){
	            query += fields[i].getName()+" int(11) NOT NULL";
	        }
	        else if (fields[i].getType().getSimpleName().toLowerCase().contains("double") || fields[i].getType().getSimpleName().toLowerCase().equals("float")){
	            query += fields[i].getName()+" double NOT NULL";
	        }
	        else if (fields[i].getType().getSimpleName().toLowerCase().contains("string")){
	            query += fields[i].getName()+"  varchar(100) DEFAULT NULL";
	        }
	        else if (fields[i].getType().getSimpleName().toLowerCase().contains("date")){
	        	query += fields[i].getName()+" date DEFAULT NULL";
	        } else if (fields[i].getType().getSimpleName().toLowerCase().contains("boolean")){
	        	query += fields[i].getName()+" varchar(8) DEFAULT NULL";
	        }
	        if(i != fields.length-1)
	            query+=",\n";
	    }
	    query+="\n) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";
	    System.out.println(query);

	}

}
