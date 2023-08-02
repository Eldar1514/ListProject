package com.example.Test;

import com.example.Test.Model.Entry;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelExportService {

    public void exportToExcel(List<Entry> entries) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Entries");
            int rowNum = 0;

            Row headerRow = sheet.createRow(rowNum++);
            headerRow.createCell(0).setCellValue("Name");
            headerRow.createCell(1).setCellValue("Surname");
            headerRow.createCell(2).setCellValue("Age");
            headerRow.createCell(3).setCellValue("Profession");

            for (Entry entry : entries) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(entry.getName());
                row.createCell(1).setCellValue(entry.getSurname());
                row.createCell(2).setCellValue(entry.getAge());
                row.createCell(3).setCellValue(entry.getProfession());
            }

            try (FileOutputStream outputStream = new FileOutputStream("entries.xlsx")) {
                workbook.write(outputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
