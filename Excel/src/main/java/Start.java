
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * A dirty simple program that reads an Excel file.
 * @author www.codejava.net
 *
 */
public class Start {

    public static void main(String[] args) throws IOException {
        String excelFilePath = "Book.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();

        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                if(cell.getCellTypeEnum() == CellType.STRING){
                    System.out.print(cell.getStringCellValue());
                }
                if(cell.getCellTypeEnum() == CellType.NUMERIC){
                    System.out.print(cell.getNumericCellValue());
                }
                if(cell.getCellTypeEnum() == CellType.FORMULA){
                    System.out.print(cell.getCellFormula());
                }
                System.out.print(" - ");
            }
            System.out.println();
        }

        workbook.close();
        inputStream.close();
    }

}