package algoritmo;

import cruzamentos.CruzaXeYSeparado;

public class Main{
	public static void main (String []args) {
/*		CruzaXeYSeparado cruza = new CruzaXeYSeparado();
		AG teste = new AG(100, 50, cruza);
		teste.executar();*/
		
		int nInd = 50;
		Individuo in = null;
		
		Individuo ind1 = new Individuo();
		ind1.setBits(new int[]{1,0,0,1,0,1,1,0,1,0,0,0,1,0,1,0,1,1,1,0});
		Individuo ind2 = new Individuo();
		ind2.setBits(new int[]{0,0,0,1,0,1,1,1,0,0,1,0,0,1,1,1,1,0,1,0});
		
		System.out.println(ind1.getBitsAsString() + " - " + ind1.getFitnessValue());
		System.out.println(ind2.getBitsAsString() + " - " + ind2.getFitnessValue());
		
		/*
		for(int i =0; i < nInd; i++){
			in = new Individuo(true);
			System.out.println(in.getBitsAsString() + " - " + in.getFitnessValue());
		}*/
		
	}
}
