package com.exercise.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class WordCount {
	private static String fileName = "src/main/resources/sample.txt"; //読み込みファイル名

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new FileReader(fileName));
		TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			//１：ファイルから文字列を読み込む

			String[] words = line.split("\\s");
			//２：文字列から単語を抽出する

			for (String s : words) {
				if (!treeMap.containsKey(s)) {
					treeMap.put(s, 1);
				} else {
					treeMap.put(s, treeMap.get(s).intValue() + 1);
				}
			}
			//３：マップに登録する

		}
		for (String s : treeMap.keySet()) {
			System.out.println(s + treeMap.get(s));
		}
		//４：マップから出力する
	}
}