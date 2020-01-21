package com.empirix.cloud.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.empirix.cloud.helper.Constants;
import com.empirix.cloud.helper.TestBase;

public class ExcelUtil extends TestBase
{
	/**
	 * To read key value
	 * @author Tarun Goswami
	 * @since 2020-10-21
	 * @version 1.0
	 */
	public Map<String, String> readKeyValue(String platform, String role, String methodName) throws IOException
	{
		Map<String, String> dataMap = new HashMap<String, String>();
	    
		InputStream XlsxFileToRead = new FileInputStream(Constants.EXCEL_FILE);

		XSSFWorkbook workbook = new XSSFWorkbook(XlsxFileToRead);
		
		XSSFSheet sheet = workbook.getSheet(environment);
	 
		 for (Row row : sheet) 
		 {
			 for (Cell cell : row) 
			 {
				 if (cell.getCellTypeEnum() == CellType.STRING) 
				 {
					 if(cellToString(row.getCell(1)).equals(platform) & cellToString(row.getCell(2)).equals(methodName) & cellToString(row.getCell(3)).equals(role)) 
					 {
						 dataMap.put(cellToString(row.getCell(4)), cellToString(row.getCell(5))); 
		             }
				 }
		     }
		 }
		        
        return dataMap;
	}
	

	/**
	 * To Convert cell data to string
	 * @author Tarun Goswami
	 * @since 2018-09-29
	 * @version 1.0
	 */
	public static String cellToString(Cell cell) 
	{  
	   
	    Object result = null;
	    
	 
        switch (cell.getCellTypeEnum()) 
        {
            
        case NUMERIC:
            result = cell.getNumericCellValue();
            break;
        	case STRING:
                result = cell.getStringCellValue();
                break;

            case BLANK:
            	result = "";
                break;

            case FORMULA:
            	result = cell.getCellFormula();
                break;

            default:
                break;
        }
	    return result.toString();
	}

}
