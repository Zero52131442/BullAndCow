import java.util.Scanner;
public class Player implements CurrentPlayer {
	 private Scanner scanner = new Scanner(System.in);
	 private String numbPlayer="";
	 private String textStep="";
	 Player(String s1,String s2) {
		 textStep=s1;
		 numbPlayer=s2;
	 }
	 
	 
	 // метод загадки числа
	 public String GuessingANumber() {
		 
		 String lengtText;
		if(SettingGame.numbCount ==1 )
		{
			lengtText= "цифру";
		}
		else if(SettingGame.numbCount>1 && SettingGame.numbCount<4  )
		{
			lengtText= "цифры";
		}
		else {lengtText= "цифр";}
		 
		 System.out.printf(numbPlayer+"  Загадайте число длиной в   " + SettingGame.numbCount + " %s (Цифры в числах не должны повторяться) =  ", lengtText);
		 String s = scanner.nextLine();
		 System.out.print("\n");
		 if(MyFunc.IsIntDigits(s) && !MyFunc.RepeatedСharacter(s,true) && s.length()==SettingGame.numbCount ) {
		 return s;
		 }
		 else {
			 System.out.println("Некорректное число");
			 return GuessingANumber();
		 }
		 
	 }
	 // метод ответа
	 	public String Answer() {
	 		Step();
	 	System.out.print("Введите ваше число = ");
		 String s = scanner.nextLine();
		 if(MyFunc.IsIntDigits(s) && !MyFunc.RepeatedСharacter(s,true)) {
			 if(s.length()==SettingGame.numbCount)
			 {
			 return s;
			 }
			 else {System.out.println("длина числа должна ровняться = "+ SettingGame.numbCount); return Answer();}
		 }
		 else {
			 System.out.println("Некорректное число");
			return Answer();
		 }
	 }
	 	// проверка ответа 
	 	public boolean CheckingTheResponse(String answer, String hiddenNumber) {
	 		 int bul=0;
			 int cow=0;
			 char pc;
			 for(int i = 0;i<SettingGame.numbCount;i++) {
				 pc = hiddenNumber.charAt(i);
				 if(answer.contains(pc+"")) {
					 if(answer.indexOf(pc)==i) {
						 bul++;
					 }
					 else {
						 cow++;
					 }
				 }
			 }
			 System.out.println("Быков = "+	bul +" Коров = "+cow);
			 System.out.print("\n");
			 if(bul == SettingGame.numbCount)
			 {
				 return true;
			 }
			 else {return false;}
	 	}
	 	
	 	// метод вывода сообщения о ходе игрока
	 	private void Step() {
	 		System.out.println(Render.Draw(30,'=')+textStep+Render.Draw(30,'='));
	 	}



	
}
