package com.stock.service.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


import com.stock.dao.BaseDao;

public abstract class AbstractImportService {

	private InputStream inputStream;
	private BaseDao baseDao;
	
	public void process(){
		FileInputStream fin = null;
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			String strLine = null;
			while((strLine = reader.readLine()) != null){
				saveInfo(strLine);
			}
		}catch(IOException e){
			throw new RuntimeException("Import file failed", e);
		}finally{
			try {
				fin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	/**
	 * 由子类去实现，根据每行数据生成对象
	 * @param strLine
	 * @return
	 */
	public abstract Object handler(String strLine);
	
	public  void saveInfo(String strLine){
		Object obj = handler(strLine);
		baseDao.save(obj);
	}

	public void  setInputStream(InputStream in) {
		this.inputStream = in;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	
	
}
