package algoritmo;

import java.util.LinkedList;

import util.Sorteio;

public class AG {
	
	private Individuo[] cruza(Individuo i1, Individuo i2){
		return null;
	}

	public void verificaMutacao(Individuo individuo){
		for(int j = 0; j < 20; j ++){
			if(Sorteio.sorteiaInt(100)==1){// 1% de chance de mutar
				individuo.mutaAlelo(j);
			}
		}
	}
	
	public void executar(int epocas, int tamanhoPopulacao){
		
		Populacao populacao = new Populacao(tamanhoPopulacao);
		Populacao novaPopulacao = new Populacao();
		
		for(int e = 0; e < epocas; e++){
			
			SorteadorIndividuo sorteador = new SorteadorIndividuo();
			LinkedList<Individuo> individuosSelecionados = sorteador.selecionaIndividuos(populacao);
			
			for(int i = 0; i < tamanhoPopulacao; i ++){
				
				Individuo i1 = individuosSelecionados.get(i);
				Individuo i2 = individuosSelecionados.get(i+1);
				
				Individuo[] novosIndividuos = cruza(i1,i2);
				
				verificaMutacao(novosIndividuos[0]);
				verificaMutacao(novosIndividuos[1]);
				
				novaPopulacao.adicionaIndividuo(novosIndividuos[0]);
				novaPopulacao.adicionaIndividuo(novosIndividuos[1]);				
				
			}
			populacao = novaPopulacao;
			
		}
		
		
		
	}
	

}
