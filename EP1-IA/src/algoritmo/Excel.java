package algoritmo;

import  java.io.*;
import  org.apache.poi.hssf.usermodel.HSSFSheet;
import  org.apache.poi.hssf.usermodel.HSSFWorkbook;
import  org.apache.poi.hssf.usermodel.HSSFRow;


public class Excel{ 
	
	public Excel() {}
	
		public void GeraExcel(double[] melhor, double[] medio) {
		//public static void main(String[]args){
			
			try {
				 // local do arquivo
				String caminho = System.getProperty("user.home");
		    	String filename= caminho+"\\GA.xls" ;
		        HSSFWorkbook workbook = new HSSFWorkbook();
		        HSSFSheet sheet =  workbook.createSheet("GA");  
		        
		        // criando as colunas
		        HSSFRow rowhead=   sheet.createRow((short)0);
		        rowhead.createCell(0).setCellValue("Epoca");
		        rowhead.createCell(1).setCellValue("Fitness medio");
		        rowhead.createCell(2).setCellValue("Melhor Fitness");
		        
		        // define os valores das linhas
		        int tamanho = melhor.length;
		        for(int i = 1; i < tamanho; i++) {
		        	HSSFRow row=   sheet.createRow((short)i);
			        row.createCell(0).setCellValue(i);
			        row.createCell(1).setCellValue(medio[i]);
			        row.createCell(2).setCellValue(melhor[i]);
		        }
		        

		        FileOutputStream fileOut =  new FileOutputStream(filename);
		        workbook.write(fileOut);
		        fileOut.close();
		        System.out.println("O arquivo excel foi gerado!");
			}
			
			catch (Exception ex) {
				System.out.print(ex);
			}
       
 	}
}
