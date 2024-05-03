package DataDriven;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingData {
public static void main(String[] args) throws IOException {
	XSSFWorkbook book=new XSSFWorkbook();
	XSSFSheet sheet=book.createSheet("Sheet1");
	
	Object data[][]= {{"name","id","job","123"},
						{"abhi",1,"it","23"},
						{"rahul",2,"cricket","233"}
	};
	
	int row = data.length;
	System.out.println(row);
	int col = data.length;
	System.out.println(col);
	
	
	for(int r=0;r<row;r++) {
		XSSFRow rr = sheet.createRow(r);
		
	for(int c=0;c<col;c++)	{
		XSSFCell cc = rr.createCell(c);
		Object value = data[r][c];
		if(value instanceof String) 
		cc.setCellValue((String) value);
		if(value instanceof Integer) 
			cc.setCellValue((Integer) value);
		
	}
	}

	String path=".\\Datafiles\\employees1.xlsx";
	FileOutputStream file=new FileOutputStream(path);
	book.write(file);
	System.out.println("Data File Is Created...");
}
}
