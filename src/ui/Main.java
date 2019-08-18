package ui;
import model.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public Main() {
	}
	
	public void showMenu() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("1.Crear club");
		System.out.println("2.Salir");
		String entrada = br.readLine();
		int inputUser = Integer.parseInt(entrada);
		
		while(inputUser != 2) {
			
			if(inputUser == 1) {
				System.out.println("s");

				br.close();
			}
			
			
		}//finalDelWhile
		
	}//FinalDeShowMenu
	

	public static void main(String[] args) throws IOException {
		Main m = new Main();
		m.showMenu();
	}

}
