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

//			System.out.println("* 경로\t : " + filePath);
//			System.out.println("* 파일명\t : " + fileName);
//			System.out.println("=======한글 포함 라인=======");
			// read source String each Line
			while ((lineString = br.readLine()) != null) {
				int[] codes = ec.getUnicodesFromString(lineString);
				// TODO : 한글 감지
				if(hd.isContainHangul(lineString)) System.out.println("Line"+ lineNum + "\t" + lineString);
				lineNum++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void test() {
		/* 이렇게 하는게 아니라 char[] 배열에서 처리해야되나? */
		String strHan = "    ### 본 디자인의 저작권은 디자인웹굿에 있으며 디자인을 무단 [ 이전/양도/대여/재판매/템플릿제작 ] 은 법적책임을 지게됩니다. ####";
//		 4자씩 읽어서 유니코드 출력
		int[] unicodes = ec.getUnicodesFromString(strHan);
		for(int i : unicodes) {
			if(i >= 44032 && i <= 55203)
			System.out.println(i + "\t" + (char)i);
		}
	}

}