package ru.apzakharov.comfort_soft.demo.domain.usecase.impl;

import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.apzakharov.comfort_soft.demo.application.annotation.UseCase;
import ru.apzakharov.comfort_soft.demo.application.exepction.UseCaseException;
import ru.apzakharov.comfort_soft.demo.domain.usecase.GetMaxFromFileUC;
import ru.apzakharov.comfort_soft.demo.ports.LocalFilePort;

import java.io.FileInputStream;
import java.util.Arrays;

@UseCase
@RequiredArgsConstructor
public class GetMaxFromFileUCImpl implements GetMaxFromFileUC {

    private final LocalFilePort filePort;

    @Override
    public Integer getMaxFromFileUC(String path, int boundary) {
        try {
            FileInputStream fileInputStream = filePort.fileStream(path);
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);
            int lastRowNum = sheet.getLastRowNum();

            int[] array = lastRowNum > boundary ? getIntArray(sheet, boundary) : getIntArray(sheet, lastRowNum);

            return Arrays.stream(array).reduce((a1, a2) -> a1 > a2 ? a1 : a2).orElse(0);
        } catch (Exception e) {
            throw new UseCaseException(e);
        }
    }

    private int[] getIntArray(Sheet sheet, int boundary) {
        int[] array = new int[boundary];
        for (int i = 0; i < boundary; i++) {
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(0);
            int value = (int) cell.getNumericCellValue();
            array[i] = value;
        }
        return array;
    }


}
