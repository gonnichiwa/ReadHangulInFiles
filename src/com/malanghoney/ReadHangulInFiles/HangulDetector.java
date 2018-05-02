package com.malanghoney.ReadHangulInFiles;

class HangulDetector {

	private EncodingChanger ec = new EncodingChanger();

	private HangulDetector(){
	}

	private static class LazyHolder {

		private static final HangulDetector INSTANCE = new HangulDetector();
	}
	static HangulDetector getInstance(){
		return LazyHolder.INSTANCE;
	}
	boolean isContainHangul(String lineString) {
		boolean isContain = false;
		int[] unicodes = ec.getUnicodesFromString(lineString);
		for(int i : unicodes){
			/* (UTF-8 INT : UTF-8 HEX )
			       44032  :   0xAC00
			       55203  :   0xD7A3 */
			if(i >= 44032 && i <= 55203) isContain = true;
		}
		return isContain;
	}

}
