package com.malanghoney.ReadHangulInFiles;

class EncodingChanger {

	void printUTF8Code(String targetStr){
		char[] strArr = new char[targetStr.length()];
		targetStr.getChars(0,targetStr.length(),strArr,0);

		for (char chr : strArr) {
			System.out.print(String.format("%04X", (int) chr) + " ");
		}
	}

	String toStringFromUTF8Code(String targetStr){
		StringBuffer sb = new StringBuffer();
		char[] strArr = new char[targetStr.length()];
		targetStr.getChars(0,targetStr.length(),strArr,0);

		for (char chr : strArr) {
			sb.append(String.format("%04X", (int) chr) + " ");
		}
		return sb.toString();
	}
}
