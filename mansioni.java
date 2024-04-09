package com.example.demo;

import java.util.ArrayList;

public class mansioni {
	
	ArrayList <mansione> lista;
	
public mansioni() {
	lista = new ArrayList();
}



	public void addMansione(String nome) {
		int cont = 0;
		boolean trovato = false;
		mansione m2 = new mansione(nome);
		if (lista.isEmpty()){
			lista.add(m2);
		}
		else
		 {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).nome.equalsIgnoreCase(nome)) {
				trovato = true;
				lista.get(i).conteggio += 1;
				
			}}
		if (trovato == false) {
		 lista.add(m2);}
		
		}
		 
		 
			
	}
	}
