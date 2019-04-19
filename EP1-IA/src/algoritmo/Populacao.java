package algoritmo;

import java.util.LinkedList;
import java.util.List;

public class Populacao {

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
		
		Double min = individuos.stream()
				.mapToDouble(Individuo::getFitnessValue)
				.min().getAsDouble();
		
		dados[0] = min;
		
		Double avg = individuos.stream()
		  		  .mapToDouble(Individuo::getFitnessValue)
		  		  .average().getAsDouble();
		
		dados[1] = avg;
		
		System.out.println("Min fit is " + min);
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
