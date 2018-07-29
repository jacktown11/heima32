package se.day22;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountFile {
	private final   String OTHER_CLASSIFICATION = "其他";
	public static void main(String[] args) {
		new CountFile().go();
	}
	
	public void go() {		
		File folder = acceptFolder();
		Map<String, Integer> result = getStatistics(folder);
		printStatistics(result);
	}
	
	public File acceptFolder() {
		Scanner sc = new Scanner(System.in);
		File folder;
		System.out.println("Input the folder's name:");
		folder = new File(sc.nextLine());
		while (!folder.exists() || !folder.isDirectory()) {
			if (!folder.exists()) {
				System.out.println("The folder you input doesn't exist, input again:");
			} else {
				System.out.println("What you input is a file, not a folder, input again please:");
			}
			folder = new File(sc.nextLine());
		}	
		return folder;
	}
	
	/**
	 * 统计文件夹下各类型文件的数目
	 * @param folder 文件夹对象
	 * @return 统计结果存储对象
	 */
	public Map<String, Integer> getStatistics(File folder){
		return _getStatistics(folder, new HashMap<String, Integer>());
	}
	
	/**
	 * 统计文件夹下各类型文件数目，并存储在给定的存储对象中
	 * @param folder 文件夹对象
	 * @param data 统计结果存储对象
	 * @return 更新数据后的统计结果存储对象
	 */
	private Map<String, Integer> _getStatistics(File folder, Map<String, Integer> data){
		if(folder.isDirectory()) {
			// 文件夹，遍历内部文件
			for(File innerfolder : folder.listFiles()) {
				_getStatistics(innerfolder, data);
			}
		}else{
			// 获取文件类型，并递增相应类型文件的数目
			String classification = getSuffix(folder);
			if(data.containsKey(classification)) {
				data.put(classification, data.get(classification)+1);
			}else {
				data.put(classification, 1);
			}
		}
		return data;
	}
	
	/**
	 * 获取文件后缀名（最后一个`.`后的字符串），
	 * 无后缀名则返回CountFile.OTHER_CLASSIFICATION，即其他分类
	 * @param file 文件
	 * @return 文件后缀名
	 */
	public String getSuffix(File file) {
		String name = file.getName();
		String[] parts = name.split("\\.");
		if(parts.length > 0) {
			return parts[parts.length-1];
		}else {
			return OTHER_CLASSIFICATION;
		}
	}
	
	/**
	 * 打印各类型文件数目统计结果
	 * @param data 文件数目统计结果
	 */
	public void printStatistics(Map<String, Integer> data) {
		for(String key : data.keySet()) {
			System.out.println(key + "类型文件个数：" + data.get(key));
		}
	}
	
}
