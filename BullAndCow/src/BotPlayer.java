import java.util.*;
// ������ ����
public class BotPlayer implements CurrentPlayer {
	// ���� ���������� ���� � ���� ���������� ����� � ��� �������� ������ 1 {0,1...����� �����}
Map<Integer,ArrayList<Integer>> numbers = new HashMap<Integer, ArrayList<Integer>>();
// ���� �������
ArrayList<String> listAnswer = new ArrayList<>();



// ��������� ������ ���������� ������� � �� ���������
BotPlayer(){

	for(int i = 0; i<10; i++) {
		numbers.put(i, new ArrayList<>());
		
		for(int j = 0 ; j<SettingGame.numbCount; j++) {
			numbers.get(i).add(j);
		}

	}

}
// ������������� �����
public  String GuessingANumber() {
	System.out.println("��������� ������� �����  ");
	return MyFunc.GeneratingANumberWithNonRepeatingNumbers();
}
// ����� ������ ���������
public String Answer() {
	String answer="";
	// ������ ������ ��������� ���� �� ������������ �������, � ����� �������� ��������� �� ���
	for(int i = 0 ; i<SettingGame.numbCount;i++)
	{	ArrayList<Integer> available�umbers = new ArrayList<>();
	available�umbers = AvailablePosition(i);
	  answer += String.valueOf( available�umbers.get((int) (Math.random() * available�umbers.size())));
	}
	// ������� �� ���������� ������
	if(!listAnswer.contains(answer) && !MyFunc.Repeated�haracter(answer,false)) {
		listAnswer.add(answer);
		System.out.println(Render.Draw(30,'*')+"��� ����"+Render.Draw(30,'*'));
		System.out.println(answer);
		return answer;
	}
	else return Answer();


}
// ����� �������� ������
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
		 System.out.println("����� = "+	bul +" ����� = "+cow);
		 System.out.print("\n");
// ����������� �� ���������� ����������
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



	
	
	
	// ����� ������ ��������� �������
private ArrayList<Integer> AvailablePosition(int position) {
	ArrayList<Integer> available�umbers = new ArrayList<>();
	numbers.forEach((k,v)->{
		for(int i = 0; i <v.size();i++)
		{
			if(v.get(i)== position)
			{
				available�umbers.add(k);
			}
			
		}
		}	);
	return available�umbers;
}
	

// ����� �������� ���� �� ������ ���������
private void DeleteNumb(String answer) {
	for(int i = 0 ; i<answer.length();i++)
	{	
		numbers.remove(Integer.parseInt(""+answer.charAt(i)));
	
	}
}
// ����� �������� ��������� ������� �����
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
// ����� ����������� ������������ ����� � �������� ���� ���������
private void SelectedNumbers(String answer) {
	
	String range = "0123456789";
	range = MyFunc.DeleteChar(range, answer.toCharArray());
	DeleteNumb(range);
}

}
