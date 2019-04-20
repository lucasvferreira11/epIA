package algoritmo;

import util.Sorteio;

public class Individuo {

  private static final double MAX_FIT_VALUE = 5.12;
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
		
		imprimeIndividuo("Antes de mutar: ");
		System.out.println("Mutou alelo " + alelo);
		
		if(bits[alelo] == 1)
			bits[alelo] = 0;
		else
			bits[alelo] = 1;

		imprimeIndividuo("Apos mutar    : ");

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
			x += (bits[i] * (i^2));
		}
		for (int i = 10; i<20; i++) {
			y += (bits[i] * (2^i));
		}
		x = x * 0.00978;
		y = y * 0.00978;
		double cosX = Math.cos(2 * x * 90);
		double cosY = Math.cos(2 * y * 90);
		double fitness = 20 + (x * x) + (y * y) - 10* (cosX + cosY);
		
		return (fitness -5.12);
		
	}
  
	public double getFitDistanceToMax(){
		return MAX_FIT_VALUE - getFitnessValue();
	}
	
	public void imprimeIndividuo(){
		imprimeIndividuo("");
	}
	
	public void imprimeIndividuo(String texto){
		System.out.println(texto + "" + getBitsAsString());
	}
	
}

