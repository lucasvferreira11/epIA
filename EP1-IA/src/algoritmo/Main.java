package algoritmo;

import cruzamentos.CruzaXeYSeparado;

public class Main{
	public static void main (String []args) {
		CruzaXeYSeparado cruza = new CruzaXeYSeparado();
		AG teste = new AG(100, 50, cruza);
		teste.executar();
	}
}
