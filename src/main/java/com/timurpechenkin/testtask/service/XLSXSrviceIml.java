package com.timurpechenkin.testtask.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;

import com.timurpechenkin.testtask.sort.QuickSort;

@Service
public class XLSXSrviceIml implements XLSXService {

	@Override
	public String getMinNumber(String adres, int n) {
		List<Integer> numsList = new ArrayList<>();
		File file = new File(adres);

		if (!file.exists()) {
			return "File does not exist";
		}

		try (FileInputStream fileInputStream = new FileInputStream(file)) {
			Workbook workbook = WorkbookFactory.create(fileInputStream);
			Sheet sheet = workbook.getSheetAt(0);
			for (Row row : sheet) {
				Cell cell = row.getCell(0);
				if (cell != null && cell.getCellType() == CellType.NUMERIC && cell.getNumericCellValue() % 1 == 0) {
					int num = (int) cell.getNumericCellValue();
					numsList.add(num);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return "FileNotFoundException: " + e.getMessage();
		} catch (IOException e) {
			e.printStackTrace();
			return "IOException: " + e.getMessage();
		} catch (Exception e) {
			e.printStackTrace();
			return "An error occurred: " + e.getMessage();
		}

		if (numsList.isEmpty() || n <= 0 || n > numsList.size()) {
			return "Invalid index or no numbers found";
		}

		QuickSort.sort(numsList);
		return numsList.get(n - 1).toString();
	}

}
