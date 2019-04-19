package algoritmo;

import  java.io.*;
import  org.apache.poi.hssf.usermodel.HSSFSheet;
import  org.apache.poi.hssf.usermodel.HSSFWorkbook;
import  org.apache.poi.hssf.usermodel.HSSFRow;


public class Excel{ 
	
	public Excel() {}
	
		public void GeraExcel() {
		//public static void main(String[]args){
			
			try {
				 // local do arquivo
				String caminho = System.getProperty("user.home");
		    	String filename= caminho+"\\GA.xls" ;
		        HSSFWorkbook workbook = new HSSFWorkbook();
		        HSSFSheet sheet =  workbook.createSheet("GA");  
		        
		        // criando as colunas
		        HSSFRow rowhead=   sheet.createRow((short)0);
		        rowhead.createCell(0).setCellValue("Indiviuo");
		        rowhead.createCell(1).setCellValue("Fitness");
		        rowhead.createCell(2).setCellValue("Probabilidade");
		        
		        // define os valores das linhas
		        HSSFRow row=   sheet.createRow((short)1);
		        row.createCell(0).setCellValue("x");
		        row.createCell(1).setCellValue("y");

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


