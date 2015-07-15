package com.stock.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class FileUtil {
	public static String[][] getData(File file, int ignoreRows)
			throws Exception {
		return getData(new FileInputStream(file), ignoreRows);
	}
	
	public static String[][] getData(InputStream inputStream, int ignoreRows) throws Exception{
		List<String[]> result = new ArrayList<String[]>();
		int rowSize = 0;
		BufferedInputStream in = new BufferedInputStream(inputStream);
		// ´ò¿ªHSSFWorkbook
		POIFSFileSystem fs = new POIFSFileSystem(in);
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		HSSFCell cell = null;

		for (int sheetIndex = 0; sheetIndex < wb.getNumberOfSheets(); sheetIndex++) {
			HSSFSheet st = wb.getSheetAt(sheetIndex);
			// µÚÒ»ÐÐÎª±êÌâ£¬²»È¡
			for (int rowIndex = ignoreRows; rowIndex <= st.getLastRowNum(); rowIndex++) {
				HSSFRow row = st.getRow(rowIndex);
				if (row == null) {
					continue;
				}

				int tempRowSize = row.getLastCellNum() + 1;

				if (tempRowSize > rowSize) {
					rowSize = tempRowSize;
				}

				String[] values = new String[rowSize];

				Arrays.fill(values, "");

				boolean hasValue = false;

				for (int columnIndex = 0; columnIndex <= row.getLastCellNum(); columnIndex++) {

					String value = "";
					cell = row.getCell(columnIndex);

					if (cell != null) {
						// ×¢Òâ£ºÒ»¶¨ÒªÉè³ÉÕâ¸ö£¬·ñÔò¿ÉÄÜ»á³öÏÖÂÒÂë
						// cell..setEncoding(HSSFCell.ENCODING_UTF_16);
						switch (cell.getCellType()) {

						case HSSFCell.CELL_TYPE_STRING:
							value = cell.getStringCellValue();
							break;

						case HSSFCell.CELL_TYPE_NUMERIC:

							if (HSSFDateUtil.isCellDateFormatted(cell)) {
								Date date = cell.getDateCellValue();

								if (date != null) {
									value = new SimpleDateFormat("yyyy-MM-dd")
											.format(date);
								} else {
									value = "";
								}

							} else {
								value = new DecimalFormat("0").format(cell
										.getNumericCellValue());
							}
							break;

						case HSSFCell.CELL_TYPE_FORMULA:

							// µ¼ÈëÊ±Èç¹ûÎª¹«Ê½Éú³ÉµÄÊý¾ÝÔòÎÞÖµ
							if (!cell.getStringCellValue().equals("")) {
								value = cell.getStringCellValue();
							} else {
								value = cell.getNumericCellValue() + "";
							}
							break;

						case HSSFCell.CELL_TYPE_BLANK:
							break;

						case HSSFCell.CELL_TYPE_ERROR:
							value = "";
							break;

						case HSSFCell.CELL_TYPE_BOOLEAN:
							value = (cell.getBooleanCellValue() == true ? "Y"
									: "N");
							break;

						default:
							value = "";
						}
					}

					if (columnIndex == 0 && value.trim().equals("")) {
						break;
					}

					values[columnIndex] = value.trim();
					hasValue = true;
				}

				if (hasValue) {
					result.add(values);
				}
			}
		}

		in.close();

		String[][] returnArray = new String[result.size()][rowSize];

		for (int i = 0; i < returnArray.length; i++) {
			returnArray[i] = (String[]) result.get(i);
		}

		return returnArray;
	}
}
