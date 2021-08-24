// Класс с функциями, которые могут потребоваться в любой момент
public class Helper {
// Отступы
	public static String paddingLeft(String s,int n) {
		for(int i = 0 ; i<n;i++) {
			s=" "+s;
		}
		return s;
	}
	
	public static String paddingRight(String s,int n) {
		for(int i = 0 ; i<n;i++) {
			s+=" ";
		}
		return s;
	}
	
	
// Удаление символов
	public static String deleteChar (String s, char c) {
		
		for(int i = 0 ; i<s.length();i++) {
			if(s.charAt(i)==c) {
				s=s.substring(0,i)+s.substring(i+1);
			}
		}
		return s;
	}
	
	
	public static String deleteChar(String s, char [] c) {
		for(int i=0; i<c.length;i++) {
				s=deleteChar(s,c[i]);
			}
		return s;
		}
	
	
	// Проверка на число
	public static boolean  сheckTheNumber(char s) {
		char [] mas = new char [] {'0','1','2','3','4','5','6','7','8','9'};	
		for(int i =0;i<mas.length;i++) {
			if(s==mas[i]) {
				return true;
							}
				}
		return false;
	}
	
	public static boolean сheckTheNumber(String s) {

		for(int i =0;i<s.length();i++) {
			if(!сheckTheNumber(s.charAt(i))) {
				System.out.println("Должно быть целое число");
				return false;
				}	
			}
		return true;
		}
	
	
	// Конвертация
	public static int[] convertToAnArrayOfNumbers(String s) {
		if(сheckTheNumber(s)) {
			int mas []= new  int [s.length()];
			for(int i=0;i<s.length();i++) {
				mas[i]=Integer.parseInt(""+s.charAt(i));
			}
			return mas;
		}
		else {
			System.out.println("Не удалось преобразовать строку в массив цифр");
			return null;
		}
	}
	
	// Проверка строки на дублирование
	public static boolean checkForRepetition(String s,boolean bool) {
		for(int i = 0 ; i <s.length()-1;i++) {
			char c = s.charAt(i);
			for(int j =i+1;j<s.length();j++) {
				if(c ==s.charAt(j)) {
					if(bool==true) {
					System.out.println("Цифры не должны повторяться");
					}
					return true;
				}
			}
		}
		return false;
	}
	
	
	// генерация числа с не повторяющимися числами
	public static String generateANumberWithoutRepetitions() {
		String s = "";
		while(true) {
		String c =String.valueOf((int)(Math.random() *10));
		  if(s.indexOf(c)==-1) {
			  s+=c;
		  }
		if(s.length()==SettingGame.numbCount ){
			break;}
		
		}
		return s;
	}
	
	}
	
	
	

