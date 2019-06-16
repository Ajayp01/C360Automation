package com.collateral360.qa.utilities;

	import java.awt.Color;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.GroupLayout.Alignment;

	import org.apache.poi.openxml4j.util.ZipSecureFile;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.CellStyle;
	import org.apache.poi.ss.usermodel.DataFormatter;
	import org.apache.poi.ss.usermodel.FillPatternType;
	import org.apache.poi.ss.usermodel.Font;
	import org.apache.poi.ss.usermodel.HorizontalAlignment;
	import org.apache.poi.ss.usermodel.IndexedColors;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.VerticalAlignment;
	import org.apache.poi.xssf.usermodel.XSSFCellStyle;
	import org.apache.poi.xssf.usermodel.XSSFColor;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;

	public class Excel {
		
		//Global Declarations
		XSSFWorkbook wb;
		File src;
		
		//Constructor	
		public Excel(String path) throws Exception
		{
			
					//Specify the path of file
					src=new File(path);
					
					//Load the file
					FileInputStream p=new FileInputStream(src);
					
					ZipSecureFile.setMinInflateRatio(0);
					//Load the workbook
					wb=new XSSFWorkbook(p);	
					
		}
		
		
		public String ReadExcel(String sheet, int rownum, int cellnum)
		{
			
			XSSFSheet sh=wb.getSheet(sheet);
			Cell cell=sh.getRow(rownum).getCell(cellnum);
		
			DataFormatter formatter=new DataFormatter();//convert to string 
			
			String formattedData=formatter.formatCellValue(cell);
			
			return formattedData;		
		
		}
		
		public void WriteToExcel(String sheet, int rownum, int cellnum,String data,int call) throws Exception
		{
			XSSFSheet sht=wb.getSheet(sheet);
			
			if(rownum==call)
			{
				 sht.createRow(rownum);
			}	
			 
			if(data.length()>50)
			{
				sht.setColumnWidth(cellnum, 15000);
			
			}
			
			XSSFCellStyle cellStyle=wb.createCellStyle();
					  	  
			  	Row r=sht.getRow(rownum);
			    
			    Cell cell=r.createCell(cellnum);
			    
			    cellStyle.setWrapText(true);
			   
			    cell.setCellStyle(cellStyle);
			    
			    cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
			    
			    cellStyle.setAlignment(HorizontalAlignment.CENTER);
			    
			    cell.setCellStyle(cellStyle);
			    
				 if(data.equalsIgnoreCase("Pass"))
				 {/*
					 	CellStyle style = wb.createCellStyle();
					    style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
					    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
					cellStyle.setFont(()Font.COLOR_RED);
					 /*cellStyle.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
					 cellStyle.setFillPattern(cellStyle.SOLID_FOREGROUND);
					cell.setCellStyle(cellStyle); 
					cellStyle.setFillBackgroundColor();*/
				 }
			    cell.setCellValue(data);
				
				FileOutputStream writedata=new FileOutputStream(src);
				
				wb.write(writedata);
		}
		
		public ArrayList ReadServices(String sheet, int rownum, int cellnum) throws IOException
		{
			//Specify the path of file
			String formattedData = null;	
			ArrayList a =a=new ArrayList();
			XSSFSheet sh=wb.getSheet(sheet);
	
     			 for (int i =rownum; i < sh.getLastRowNum(); i++) 
     			 {
     				 Row r = sh.getRow(i);
     				 Cell c = r.getCell(0);
     				 try {
     					 // System.out.println(r.getRowStyle());
     					 System.out.println(r.getZeroHeight());
     					 	if(r.getZeroHeight() == false)//if row is not hidden then go inside and if body executed
     					 	{
     					 		DataFormatter formatter=new DataFormatter();//convert to string 
							
     					 		 formattedData=formatter.formatCellValue(c);
     					 		//System.out.println(formattedData);
     					 		 
     					 		 a.add(formattedData);
     					 	}
     			
     				  	} 
     					 catch (Exception e) 
     				 	{
					
     				 	}
			 
     			 }	
				return a;
			
}
		
}
