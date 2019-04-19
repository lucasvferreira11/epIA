package algoritmo;

import java.util.LinkedList;

import util.Sorteio;

public class SorteadorIndividuo {

	private double limiteSupIndividuo[];
	
	public LinkedList<Individuo> selecionaIndividuos(Populacao populacao){
		LinkedList<Individuo> individuosSelecionados = new LinkedList<>();
		Individuo individuoSelecionado;
		
		limiteSupIndividuo = new double[populacao.getTamanho()];
		
		double total = populacao.getIndividuos().stream().mapToDouble(Individuo::getFitDistanceToMax).sum();
		
		double pInd;
	
		double pTotal = 0d;
		
		for(int i =0; i < populacao.getTamanho(); i++){
			pInd = ((populacao.getIndividuos().get(i).getFitnessValue() / total) * 100);
			limiteSupIndividuo[i] = pTotal + pInd;
			pTotal += limiteSupIndividuo[i];
		}
		
		for(int i =0; i< populacao.getTamanho(); i++){
			double sorteado = Sorteio.sorteiaDouble(100d);
			int posicaoSelecionado = buscaBinaria(sorteado,0,populacao.getTamanho());
			individuoSelecionado = populacao.getIndividuos().get(posicaoSelecionado).geraCopia();
			individuosSelecionados.add(individuoSelecionado);
		}
		
		return individuosSelecionados;
	}
	
	private int buscaBinaria(double valor, int inicio, int fim){
		
		if(inicio == fim)
			return inicio;
		
		int meio = (fim + inicio) / 2;
		if(limiteSupIndividuo[meio] == valor)
			return meio;
		if(valor < limiteSupIndividuo[meio])
			return buscaBinaria(valor,inicio, meio-1);
		else
			return buscaBinaria(valor,meio+1, fim);
		
	}
	
	
	
	
	
}
