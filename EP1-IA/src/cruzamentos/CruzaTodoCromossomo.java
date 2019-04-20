package cruzamentos;

import java.util.Random;

import algoritmo.Individuo;
import util.Sorteio;

public class CruzaTodoCromossomo implements ICruzamento {

	public Individuo[] cruza(Individuo i1, Individuo i2){

		int v1= Sorteio.sorteiaInt(19); //vai sortear um valor de 0 a 19
		int v2= Sorteio.sorteiaInt(19); 
		
		int filho1 [] = new int [20];
		int filho2 [] = new int [20];
		
		Individuo f1 = new Individuo();
		Individuo f2= new Individuo ();
		
		//cruza para gerar filho 1
		for(int i=0; i< filho1.length ; i++) {
			while (i < v1) {
				filho1[i] = i1.getBit(i);
				i++;
			}
			
			while(i<=v2) {
				filho1[i] = i2.getBit(i);
				i++;
			}
			
			filho1[i] = i1.getBit(i);
		}
		
		//cruza para gerar filho 2
		for(int i=0; i< filho2.length ; i++) {
			while (i < v1) {
						filho1[i] = i2.getBit(i);
						i++;
					}
					
					while(i<=v2) {
						filho1[i] = i1.getBit(i);
						i++;
					}
					
					filho1[i] = i2.getBit(i);
			}
		
		f1.setBits(filho1);
		f2.setBits(filho2);
		
		Individuo [] filhos= new Individuo [2];
		filhos[0]= f1;
		filhos[1]= f2;
		
		
		return filhos;
	}
	
}
