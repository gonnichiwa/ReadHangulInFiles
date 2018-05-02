package com.malanghoney.ReadHangulInFiles;

import java.io.UnsupportedEncodingException;

class EncodingChanger {

	private static final String UTF8_FORMAT = "%04X";

	// UNICODE 변환(int) FROM 문자열
	public int[] toUnicodesFromString(String targetStr) {
		int length = targetStr.length();
		// TODO : char배열 변환
		char[] strArr = new char[length];
		targetStr.getChars(0,length,strArr,0);

		// TODO : 한글자씩 돌면서 int 캐스팅 -> int 배열 집어넣음
		int[] charIntArr = new int[length];
		for(int i=0; i< length; i++) {
			charIntArr[i] = (int) strArr[i];
		}

		return charIntArr;
	}

	// 콘솔 출력 (UTF8)
	void printUTF8Code(String targetStr){
		char[] strArr = new char[targetStr.length()];
		targetStr.getChars(0,targetStr.length(),strArr,0);

		for (char chr : strArr) {
			System.out.print(String.format(UTF8_FORMAT, (int) chr) + " ");
		}
	}

	// UTF8문자열 변환 FROM 문자열
	String toStringFromUTF8Code(String targetStr){
		StringBuilder sb = new StringBuilder();
		char[] strArr = new char[targetStr.length()];
		targetStr.getChars(0,targetStr.length(),strArr,0);

		for (char chr : strArr) {
			sb.append(String.format(UTF8_FORMAT, (int) chr));
		}
		return sb.toString();
	}

	// UTF-8 byte 변환 FROM 문자열
	byte[] toByteFromString(String targetStr) throws UnsupportedEncodingException {
//		return targetStr.getBytes(); equal with UTF8
		return targetStr.getBytes("UTF-8");
	}

}
