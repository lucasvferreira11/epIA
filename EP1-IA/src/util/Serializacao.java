package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import algoritmo.AG;
import algoritmo.Populacao;
import cruzamentos.CruzaXeYSeparado;

public class Serializacao {

	private String getCaminho(String arquivo){
		String caminho = System.getProperty("user.home");
		caminho += "\\" + arquivo + ".ser";
		return caminho;
	}
	
	private boolean existeArquivo(String arquivo){
		File file = new File(getCaminho(arquivo));
		return file.exists();
	}
	
	public Populacao deserializar(String arquivo){

		Populacao populacao = null;
		ObjectInputStream objectinputstream = null;
		try {
		    FileInputStream streamIn = new FileInputStream(getCaminho(arquivo));
		    objectinputstream = new ObjectInputStream(streamIn);
		    populacao = (Populacao) objectinputstream.readObject();
		    return populacao;
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    if(objectinputstream != null){
		        try {
					objectinputstream .close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		    } 
		}
		
		return populacao;
		
	}
	
	public void serializar(Populacao populacao, String arquivo){
		
		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		try{
		    fout = new FileOutputStream(getCaminho(arquivo), true);
		    oos = new ObjectOutputStream(fout);
		    oos.writeObject(populacao);
		} catch (Exception ex) {
		    ex.printStackTrace();
		} finally {
		    if(oos != null){
		        try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		    } 
		}
		
	}
	
	public static void main(String[] args) {

		Serializacao s = new Serializacao();
		String nomeArquivo = "populacaoTravada";
		int tamanhoPopulacao = 2;
		Populacao populacao = null;
		
		if(!s.existeArquivo(nomeArquivo)){
			populacao = new Populacao(tamanhoPopulacao);
			s.serializar(populacao, nomeArquivo);
		}
		else{
			populacao = s.deserializar(nomeArquivo);
		}

		AG algoritmo = new AG(100,tamanhoPopulacao,new CruzaXeYSeparado());
		algoritmo.executar(populacao);
		
	}
	
	
}
