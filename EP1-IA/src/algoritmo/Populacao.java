package algoritmo;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Populacao implements Serializable {

	private static final long serialVersionUID = -43220086251230746L;
	private List<Individuo> individuos = new LinkedList<Individuo>();
	
	public Populacao(){}
	
	public Populacao(int tamanho){
		Individuo individuo;
		for(int i = 0; i < tamanho; i++){
			individuo = new Individuo(true);
			individuos.add(individuo);
		}
	}
	
	public double[] getDadosFitness(){
		
		double[] dados = new double[2];
		
		Double max = individuos.stream()
				.mapToDouble(Individuo::getFitnessValue)
				.max().getAsDouble();
		Double avg = individuos.stream()
		  		  .mapToDouble(Individuo::getFitnessValue)
		  		  .average().getAsDouble();
		
		dados[0] = max;
		dados[1] = avg;
		
		System.out.println("Max fit is " + max);
		System.out.println("Avg fit is " + avg);
		
		return dados;
		
	}
	
	public int getTamanho(){
		return this.individuos.size();
	}
	
	public List<Individuo> getIndividuos(){
		return this.individuos;
	}
	
	public void adicionaIndividuo(Individuo individuo){
		individuos.add(individuo);
	}
	
}
