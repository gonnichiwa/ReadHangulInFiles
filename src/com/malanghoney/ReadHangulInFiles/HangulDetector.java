package com.malanghoney.ReadHangulInFiles;

class HangulDetector {

	private HangulDetector(){}
	private static class LazyHolder {
		private static final HangulDetector INSTANCE = new HangulDetector();
	}
	static HangulDetector getInstance(){
		return LazyHolder.INSTANCE;
	}

	String detectHangul(String lineString) {
		return lineString;
	}

}
