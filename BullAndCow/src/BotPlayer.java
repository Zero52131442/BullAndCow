import java.util.*;
// Логика бота
public class BotPlayer implements CurrentPlayer {
	// Лист содержащий ключ в виде доступного числа и его позициии Пример 1 {0,1...длина числа}
Map<Integer,ArrayList<Integer>> numbers = new HashMap<Integer, ArrayList<Integer>>();
// Лист ответов
ArrayList<String> listAnswer = new ArrayList<>();



// Заполняем список возможными числами и их позициями
BotPlayer(){

	for(int i = 0; i<10; i++) {
		numbers.put(i, new ArrayList<>());
		
		for(int j = 0 ; j<SettingGame.numbCount; j++) {
			numbers.get(i).add(j);
		}

	}

}
// Генерирование числа
public  String GuessingANumber() {
	System.out.println("Компьютер загадал число  ");
	return MyFunc.GeneratingANumberWithNonRepeatingNumbers();
}
// метод ответа комьютера
public String Answer() {
	String answer="";
	// делаем запрос доступных цифр на определенные позиции, а потом выбираем случайную из них
	for(int i = 0 ; i<SettingGame.numbCount;i++)
	{	ArrayList<Integer> availableТumbers = new ArrayList<>();
	availableТumbers = AvailablePosition(i);
	  answer += String.valueOf( availableТumbers.get((int) (Math.random() * availableТumbers.size())));
	}
	// Сверяем на повторение ответа
	if(!listAnswer.contains(answer) && !MyFunc.RepeatedСharacter(answer,false)) {
		listAnswer.add(answer);
		System.out.println(Render.Draw(30,'*')+"Ход бота"+Render.Draw(30,'*'));
		System.out.println(answer);
		return answer;
	}
	else return Answer();


}
// Метод проверки ответа
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
// манипуляции от зависимого результата
		 if(bul==0 && cow ==0)
		 {
			 DeleteNumb(answer);
			 
			
		 }
		 
		 if((bul+cow) == SettingGame.numbCount) {
			 SelectedNumbers(answer);
		 }
		 
		 if(bul==0 && cow>0)
		 {
			 DeleteNumbPosition(answer);
			
		 }
		 
		 if(bul == SettingGame.numbCount)
		 {
			 return true;
		 }
		 else {return false;}
	}



	
	
	
	// метод поиска доступных позиций
private ArrayList<Integer> AvailablePosition(int position) {
	ArrayList<Integer> availableТumbers = new ArrayList<>();
	numbers.forEach((k,v)->{
		for(int i = 0; i <v.size();i++)
		{
			if(v.get(i)== position)
			{
				availableТumbers.add(k);
			}
			
		}
		}	);
	return availableТumbers;
}
	

// метод удаления цифр из списка доступных
private void DeleteNumb(String answer) {
	for(int i = 0 ; i<answer.length();i++)
	{	
		numbers.remove(Integer.parseInt(""+answer.charAt(i)));
	
	}
}
// метод удаления доступной позиции цифры
private void DeleteNumbPosition(String answer) {
	char key=' ';
	for(int i = 0 ; i<answer.length();i++)
	{		
		key = answer.charAt(i);
		for(int j = 0 ; j<numbers.get(Integer.parseInt(""+key)).size();j++)
		{
			if(numbers.get(Integer.parseInt(""+key)).get(j)==i) {
				numbers.get(Integer.parseInt(""+key)).remove(j);
			}
		}
		
	
	}
}
// метод исключающий определенные числа и удаления всех остальных
private void SelectedNumbers(String answer) {
	
	String range = "0123456789";
	range = MyFunc.DeleteChar(range, answer.toCharArray());
	DeleteNumb(range);
}

}
