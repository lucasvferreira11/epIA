package cruzamentos;

import algoritmo.Individuo;
import util.Sorteio;

public class CruzaTodoCromossomo implements ICruzamento {

	public Individuo[] cruza(Individuo i1, Individuo i2){

		int v1= Sorteio.sorteiaInt(19); //vai sortear um valor de 0 a 19
		int v2 = Sorteio.sorteiaIntComExcecao(19, v1);
		
		if(v1 > v2){
			int aux = v2;
			v2 = v1;
			v1 = aux;
		}

		int filho1 [] = new int [20];
		int filho2 [] = new int [20];
		
		Individuo f1 = new Individuo();
		Individuo f2= new Individuo ();
		
		//cruza para gerar filho 1
		int i = 0;
		while (i < v1) {
			filho1[i] = i1.getBit(i);
			filho2[i] = i2.getBit(i);
			i++;
		}
		
		while(i<=v2) {
			filho1[i] = i2.getBit(i);
			filho2[i] = i2.getBit(i);
			i++;
		}
		
		while(i < 20){
			filho1[i] = i1.getBit(i);
			filho2[i] = i2.getBit(i);
			i++;
		}
		
		f1.setBits(filho1);
		f2.setBits(filho2);
		
		Individuo [] filhos= new Individuo [2];
		filhos[0]= f1;
		filhos[1]= f2;
		
		return filhos;
	}
	
}
