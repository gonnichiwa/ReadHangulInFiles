package com.malanghoney.ReadHangulInFiles;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Hello {

	private static EncodingChanger ec = new EncodingChanger();
	private static HangulDetector hd = HangulDetector.getInstance();

	public static void main(String[] args) {
		Charset inputCharset;

		String filePath = "C:\\dev-Source\\cafe24FTP\\_\\sde_design\\skin3\\";
		String fileName = "index.html";

		// 파일 내용 읽기
		inputCharset = Charset.forName("UTF-8");
		try (FileInputStream fis = new FileInputStream(filePath + fileName);
			 InputStreamReader isr = new InputStreamReader(fis, inputCharset);
			 BufferedReader br = new BufferedReader(isr)) {

			int lineNum = 1;
			String lineString;

			System.out.println("****** 경로\t : " + filePath);
			System.out.println("****** 파일명\t : " + fileName);
			System.out.println("=========================한글 포함 라인===========================================");
			// read source String each Line
			while ((lineString = br.readLine()) != null) {
				// 한글 감지된 라인만 출력
				if(hd.isContainHangul(lineString)) System.out.println("Line"+ lineNum + "\t" + lineString);
				lineNum++;
			}
			System.out.println("===================== END : " + filePath + fileName + " =================================================");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}