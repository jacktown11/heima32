package se.day25;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesModification {
	public static void main(String[] args) throws IOException {
		new PropertiesModification().start();
	}

	public void start() throws IOException {
		Properties p = new Properties();
		final File config = new File("d:\\temp\\test\\config.properties");
		p.load(new FileInputStream(config));
		p.setProperty("score", String.valueOf(100));
		p.store(new FileOutputStream(config), "");
		System.out.println("score modified.");
	}
}
