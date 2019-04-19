package cruzamentos;

import algoritmo.Individuo;
import util.Sorteio;

public class CruzaXeYSeparado implements ICruzamento {

	@Override
	public Individuo[] cruza(Individuo i1, Individuo i2) {

		Individuo novo1 = new Individuo();
		Individuo novo2 = new Individuo();
		int[] bits1 = new int[20];
		int[] bits2 = new int[20];
		int somador = 0;

		while(somador < 10){
			int ponto1 = Sorteio.sorteiaInt(9);
			int ponto2 = Sorteio.sorteiaIntComExcecao(9, ponto1);
			ponto1+=somador;
			ponto2+=somador;
			
			if(ponto1 > ponto2){
				int aux = ponto2;
				ponto2 = ponto1;
				ponto1 = aux;
			}
			
			for(int i = somador; i <=somador+9; i++){
				if(i <= ponto1 || i >= ponto2){
					bits1[i] = i1.getBit(i);
					bits2[i] = i2.getBit(i);
				}
				else{
					bits1[i] = i2.getBit(i);
					bits2[i] = i1.getBit(i);
				}
			}
		}
		
		novo1.setBits(bits1);
		novo2.setBits(bits2);
		
		return new Individuo[]{novo1,novo2};
	}
	
	public static void main(String[] args) {

		Individuo i1 = new Individuo(true);
		Individuo i2 = new Individuo(true);
		
		ICruzamento cruza = new CruzaXeYSeparado();
		
		i1.imprimeIndividuo("Individuo 1 :");
		i2.imprimeIndividuo("Individuo 2 :");
/*		
		Individuo[] novos = cruza.cruza(i1, i2);
		novos[0].imprimeIndividuo("Novo 1 :");
		novos[1].imprimeIndividuo("Novo 2 :");
*/		
	}
	

}
