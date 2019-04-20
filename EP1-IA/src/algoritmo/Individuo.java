package algoritmo;

import java.io.Serializable;

import util.Sorteio;

public class Individuo implements Serializable {

	private static final long serialVersionUID = 1563951163757853051L;
	private int bits[] = new int[20];

	public Individuo(){}
	
	public Individuo(boolean geraRandomicamente){
		if(geraRandomicamente){
			for(int i = 0; i < 20; i++){
				bits[i] = Sorteio.sorteiaInt(1);
			}
		}
	}

	public Individuo geraCopia(){
		Individuo individuo = new Individuo();
		individuo.setBits(getBits().clone());
		return individuo;
	}
	
	public int[] getBits() {
		return bits;
	}
	
	public int getBit(int posicao){
		return bits[posicao];
	}
	
	public void mutaAlelo(int alelo){
		
		if(bits[alelo] == 1)
			bits[alelo] = 0;
		else
			bits[alelo] = 1;

	}

	public void setBits(int[] bits) {
		this.bits = bits;
	}
	
	public String getBitsAsString(){
		StringBuilder str = new StringBuilder("[").append(bits[0]);
		for(int i = 1; i < 20; i++)
			str.append("," + bits[i]);
		return str.append("]").toString();
	}
	
	public double getFitnessValue(){
		double x = 0;
		double y = 0;
		for (int i = 0; i<10; i++) {
			x += (bits[i] * Math.pow(2, i));
		}
		for (int i = 9; i<20; i++) {
			y += (bits[i] * Math.pow(2, i-10));
		}
		
		x = x * 0.00978;
		y = y * 0.00978;
		
		x -= 5;
		y -= 5;

		double cosX = Math.cos(2 * x * 180);
		double cosY = Math.cos(2 * y * 180);
		double fitness = 20 + (x * x) + (y * y) - (10* (cosX + cosY));
		
		return 100-fitness;
		
	}
  
	public double getFitDistanceToMax(){
		return getFitnessValue();
	}
	
	public void imprimeIndividuo(){
		imprimeIndividuo("");
	}
	
	public void imprimeIndividuo(String texto){
		System.out.println(texto + "" + getBitsAsString());
	}
	
}

