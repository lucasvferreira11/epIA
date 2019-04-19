package cruzamentos;

import java.util.Random;
import algoritmo.Individuo;

public class CruzaTodoCromossomo implements ICruzamento {

	public Individuo[] cruza(Individuo i1, Individuo i2){
		int individuo1 []  = i1.getBits();
		int individuo2 [] = i2.getBits();
		
		Random gerador = new Random();
		int v1= gerador.nextInt(20); //vai sortear um valor de 0 a 19
		int v2= gerador.nextInt(20); 
		
		int filho1 [] = new int [20];
		int filho2 [] = new int [20];
		
		Individuo f1 = new Individuo();
		Individuo f2= new Individuo ();
		
		//cruza para gerar filho 1
		for(int i=0; i< filho1.length ; i++) {
			while (i < v1) {
				filho1[i] = individuo1[i];
				i++;
			}
			
			while(i<=v2) {
				filho1[i] = individuo2[i];
				i++;
			}
			
			filho1[i] = individuo1[i];
		}
		
		//cruza para gerar filho 2
		for(int i=0; i< filho2.length ; i++) {
			while (i < v1) {
						filho1[i] = individuo2[i];
						i++;
					}
					
					while(i<=v2) {
						filho1[i] = individuo1[i];
						i++;
					}
					
					filho1[i] = individuo2[i];
				}
		f1.setBits(filho1);
		f2.setBits(filho2);
		
		Individuo [] filhos= new Individuo [2];
		filhos[0]= f1;
		filhos[1]= f2;
		
		return filhos;
	}
	
}
