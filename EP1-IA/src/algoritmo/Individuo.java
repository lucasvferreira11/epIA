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
	
	public void mutaAlelo(int alelo){
		
		System.out.println("Mutou alelo " + alelo);
		
		if(bits[alelo] == 1)
			bits[alelo] = 0;
		else
			bits[alelo] = 1;
	}

	public void setBits(int[] bits) {
		this.bits = bits;
	}
	
	public String getBitsAsString(){
		StringBuilder str = new StringBuilder();
		for(int i = 0; i < 20; i++)
			str.append(bits[i]);
		return str.toString();
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
		double cosX = Math.cos(2 * x * Math.PI);
		double cosY = Math.cos(2 * y * Math.PI);
		double fitness = 20 + (x * x) + (y * y) - 10* (cosX + cosY);
		
		return (fitness -5.12);
		
	}
	
	public double getFitDistanceToMax(){
		return MAX_FIT_VALUE - getFitnessValue();
	}

}
