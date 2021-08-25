// класс отвечающий за отрисовку
public class Render {
// метод отрисоки элемента определенное количество раз
	public static String draw(int n, char c) {
		String s ="";
		for(int i =0; i<n;i++) {
			s+=c;
		}
		return s;
	}
	
	// метод для большого отступа
	public static void retreat(int n) {
		
		for(int i =0; i<n;i++) {
			System.out.println();
		}
		
	}
}
