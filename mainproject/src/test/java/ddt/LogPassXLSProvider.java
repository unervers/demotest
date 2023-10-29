package ddt;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LogPassXLSProvider {
   
    private XSSFWorkbook wBook;
    private XSSFSheet sheet;
    
    public LogPassXLSProvider(String fName) throws IOException {
        wBook = new XSSFWorkbook(new FileInputStream(new File(fName)));
    }
    
    public int getRowCount(String name) {
        return wBook.getSheet(name).getPhysicalNumberOfRows(); 
    }
    
    public String getCellData(String name, int row, int colunm) {
        sheet = wBook.getSheet(name);
        return sheet.getRow(row).getCell(colunm).getStringCellValue();
    }
    
}
