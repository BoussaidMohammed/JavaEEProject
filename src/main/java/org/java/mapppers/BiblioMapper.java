package org.java.mapppers;

import org.java.models.Publisher;
import org.java.models.Title;

public class BiblioMapper {

	public static Title getTitle(String...row) {
		return new Title(row[0], row[1], toInt(row[2]), toInt(row[3]));
	}
	
	
	private static int toInt(String value) {
		try {
			return Integer.parseInt(value);
		} catch (Exception e) {
			System.out.println("Erreur mapper: "+e.getMessage());
			return -1;
		}
	}
	
	public static Publisher getPublisher(String... row) {
		return new Publisher(toInt(row[0]), row[1]);
	}

}
