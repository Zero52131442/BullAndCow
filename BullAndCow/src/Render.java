// класс отвечающий за отрисовку
public class Render {
// метод отрисоки элемента определенное количество раз
	public static String Draw(int n, char c) {
		String s ="";
		for(int i =0; i<n;i++) {
			s+=c;
		}
		return s;
	}
	
	// метод для большого отступа
	public static void Retreat(int n) {
		
		for(int i =0; i<n;i++) {
			System.out.println();
		}
		
	}
}
