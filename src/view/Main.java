package view;

import java.io.IOException;

import controller.FrutaController;

public class Main {

	public static void main(String[] args) {
		
		try {
			new FrutaController().readFruit("C:\\TEMP");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
