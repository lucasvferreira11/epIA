package algoritmo;

import cruzamentos.CruzaTodoCromossomo;
import cruzamentos.CruzaXeYSeparado;

public class Main{
	public static void main (String []args) {
//		CruzaTodoCromossomo cruza = new CruzaTodoCromossomo();
		CruzaXeYSeparado cruza = new CruzaXeYSeparado();
		AG teste = new AG(100, 100, cruza);
		teste.executar();
		/*		/*
		int nInd = 50;
		Individuo in = null;
		
		Individuo ind1 = new Individuo();
		ind1.setBits(new int[]{1,0,0,1,0,1,1,0,1,0,0,0,1,0,1,0,1,1,1,0});
		Individuo ind2 = new Individuo();
		ind2.setBits(new int[]{0,0,0,1,0,1,1,1,0,0,1,0,0,1,1,1,1,0,1,0});

		Individuo ind3 = new Individuo();
		ind3.setBits(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});

		Individuo ind4 = new Individuo();
		ind4.setBits(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
		
		System.out.println(ind1.getBitsAsString() + " - " + ind1.getFitnessValue());
		System.out.println(ind2.getBitsAsString() + " - " + ind2.getFitnessValue());
		System.out.println(ind3.getBitsAsString() + " - " + ind3.getFitnessValue());
		System.out.println(ind4.getBitsAsString() + " - " + ind4.getFitnessValue());
		
		for(int i =0; i < nInd; i++){
			in = new Individuo(true);
			System.out.println(in.getBitsAsString() + " - " + in.getFitnessValue());
		}*/
		
	}
}
