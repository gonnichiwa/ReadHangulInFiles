package com.malanghoney.ReadHangulInFiles;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Hello {

	public static void main(String[] args) {
		EncodingChanger ec = new EncodingChanger();
		Charset inputCharset;

		String filePath = "C:\\dev-Source\\cafe24FTP\\_\\sde_design\\skin3\\";
		String fileName = "index.html";

		// 파일 내용 읽기
		inputCharset = Charset.forName("UTF-8");
		try (FileInputStream fis = new FileInputStream(filePath + fileName);
			 InputStreamReader isr = new InputStreamReader(fis, inputCharset);
			 BufferedReader br = new BufferedReader(isr)) {

			String lineString; // source String each Line
			int lineNum = 1;
			while ((lineString = br.readLine()) != null) {
				// TODO : 한글 감지
				lineString = ec.toStringFromUTF8Code(lineString);
				System.out.println("Line"+ lineNum + "\t" + lineString);
				lineNum++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}