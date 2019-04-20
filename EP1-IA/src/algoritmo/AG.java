package algoritmo;

import java.util.LinkedList;

import cruzamentos.ICruzamento;
import util.Sorteio;


public class AG {
	
	private int epocas;
	private int tamanhoPopulacao;
	private ICruzamento tipoCruzamento;
	private double[] dataFitMin;
	private double[] dataFitAvg;

	public AG(int epocas, int tamanhoPopulacao, ICruzamento tipoCruzamento){
		this.epocas = epocas;
		this.tamanhoPopulacao = tamanhoPopulacao;
		this.tipoCruzamento = tipoCruzamento;
		dataFitMin = new double[epocas+1];
		dataFitAvg = new double[epocas+1];
	}
	
	private Individuo[] cruza(Individuo i1, Individuo i2){
		return tipoCruzamento.cruza(i1, i2);
	}

	public void verificaMutacao(Individuo individuo){
		if(Sorteio.sorteiaInt(100)<5){// 5% de chance de mutar
			int j = Sorteio.sorteiaInt(19);
			individuo.mutaAlelo(j);
		}
	}
	
	private void saveFitData(int epoca, Populacao populacao){
		double[] dadosFitness = populacao.getDadosFitness();
		dataFitMin[epoca] = dadosFitness[0];
		dataFitAvg[epoca] = dadosFitness[1];
	}
	
	public void executar(){
		executar(new Populacao(tamanhoPopulacao));
	}
	
	public void executar(Populacao populacao){
		
		Populacao novaPopulacao;
		
		for(int e = 0; e < epocas; e++){
			novaPopulacao = new Populacao();
		
			saveFitData(e, populacao);
			
			SorteadorIndividuo sorteador = new SorteadorIndividuo();
			LinkedList<Individuo> individuosSelecionados = sorteador.selecionaIndividuos(populacao);
			
			for(int i = 0; i < tamanhoPopulacao; i=i+2){
				
				Individuo i1 = individuosSelecionados.get(i);
				Individuo i2 = individuosSelecionados.get(i+1);
				
				Individuo[] novosIndividuos;
				
				if(fazCrossOver()){
					novosIndividuos = cruza(i1,i2);
					verificaMutacao(novosIndividuos[0]);
					verificaMutacao(novosIndividuos[1]);
				}
				else{
					novosIndividuos = new Individuo[]{i1,i2};
				}
				
				novaPopulacao.adicionaIndividuo(novosIndividuos[0]);
				novaPopulacao.adicionaIndividuo(novosIndividuos[1]);				
				
			}
			populacao = novaPopulacao;
			
		}

		saveFitData(epocas, populacao);
		
		exportaDadosExcel(dataFitMin, dataFitAvg, epocas, tamanhoPopulacao);
		
	}
	
	private boolean fazCrossOver() {
		return Sorteio.sorteiaInt(100) < 70;
	}

	private void exportaDadosExcel(double[] dataFitMin, double[] dataFitAvg, int epocas, int tamanhoPopulacao){
		Excel exportar = new Excel();
		exportar.GeraExcel(dataFitMin, dataFitAvg, epocas, tamanhoPopulacao);
	}

}
