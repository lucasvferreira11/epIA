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
