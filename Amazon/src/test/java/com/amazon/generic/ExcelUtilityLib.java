package com.amazon.generic;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.Reporter;

public class ExcelUtilityLib 
{
	public static String getKeyValue(String sheetName, String methodName, String key)
	{
		Workbook workbook= null  ;
		try {
			workbook = WorkbookFactory.create(ExcelUtilityLib.class.getResourceAsStream("/AmazonTestData/amazon.xlsx"));
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = (XSSFSheet) workbook.getSheet(sheetName);
		System.out.println(sheet);
		XSSFRow row;
		XSSFCell cell=null;
		String mName, key1, value = null;
		int rowNum = sheet.getPhysicalNumberOfRows();
		System.out.println("Row number is" + rowNum);
		for(int rc=0; rc <rowNum; rc++)
		{
			row = sheet.getRow(rc);
			if(row == null)
			{		
				Reporter.log("There is some problem in the row");
			}			
			cell = row.getCell(0);
			if (cell != null) {
				mName = cellToString(cell);
				cell = row.getCell(1);	
				key1 = cellToString(cell);

				if ((!mName.equals(methodName)) || !key.equals(key1))
					continue;
				cell = row.getCell(2);
				value = cellToString(cell);	
				System.out.println(value);

			}else{
				Reporter.log("There is some problem in the sheet");
			}
		}
		return value;
	}

	@SuppressWarnings("deprecation")
	public static String cellToString(XSSFCell cell) 
	{ 
		Object result = null;
		switch (cell.getCellType()) 
		{
		case XSSFCell.CELL_TYPE_NUMERIC:
			//result = cell.getNumericCellValue();
			result = NumberToTextConverter.toText(cell.getNumericCellValue());

			break;
		case XSSFCell.CELL_TYPE_STRING:
			result = cell.getStringCellValue();
			break;

		case XSSFCell.CELL_TYPE_FORMULA:
			result = cell.getCellFormula();
			break;

		case XSSFCell.CELL_TYPE_BLANK:
			result = "";
			break;
		default:
			break;
		}
		return result.toString();
	}
}