import java.util.*;
// ������ ����

public class Bot implements ICurrentPlayer {
	// ���� ���������� ���� � ���� ���������� ����� � ��� �������� ������ 1 {0,1...����� �����}
Map<Integer,ArrayList<Integer>> numbers = new HashMap<Integer, ArrayList<Integer>>();
// ���� �������
ArrayList<String> listAnswer = new ArrayList<>();



// ��������� ������ ���������� ������� � �� ���������
Bot(){

	for(int i = 0; i<10; i++) {
		numbers.put(i, new ArrayList<>());
		
		for(int j = 0 ; j<SettingGame.numbCount; j++) {
			numbers.get(i).add(j);
		}

	}

}
// ������������� �����
public  String makeANumber() {
	System.out.println("��������� ������� �����  ");
	return Helper.generateANumberWithoutRepetitions();
}
// ����� ������ ���������
public String toAnswer() {
	String answer="";
	// ������ ������ ��������� ���� �� ������������ �������, � ����� �������� ��������� �� ���
	for(int i = 0 ; i<SettingGame.numbCount;i++)
	{	ArrayList<Integer> available�umbers = new ArrayList<>();
	available�umbers = findAnAvailablePosition(i);
	  answer += String.valueOf( available�umbers.get((int) (Math.random() * available�umbers.size())));
	}
	// ������� �� ���������� ������
	if(!listAnswer.contains(answer) && !Helper.checkForRepetition(answer,false)) {
		listAnswer.add(answer);
		System.out.println(Render.draw(30,'*')+"��� ����"+Render.draw(30,'*'));
		System.out.println(answer);
		return answer;
	}
	else return toAnswer();


}
// ����� �������� ������
public boolean checkTheResult(String answer, String hiddenNumber) {
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
			 deleteANumber(answer);
			 
			
		 }
		 
		 if((bul+cow) == SettingGame.numbCount) {
			 leaveTheNumbers(answer);
		 }
		 
		 if(bul==0 && cow>0)
		 {
			 deleteNumberPosition(answer);
			
		 }
		 
		 if(bul == SettingGame.numbCount)
		 {
			 return true;
		 }
		 else {return false;}
	}



	
	
	
	// ����� ������ ��������� �������
private ArrayList<Integer> findAnAvailablePosition(int position) {
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
private void deleteANumber(String answer) {
	for(int i = 0 ; i<answer.length();i++)
	{		
		numbers.remove(Integer.parseInt(""+answer.charAt(i)));
	}
}
// ����� �������� ��������� ������� �����
private void deleteNumberPosition(String answer) {
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
private void leaveTheNumbers(String answer) {
	
	String range = "0123456789";
	range = Helper.deleteChar(range, answer.toCharArray());
	deleteANumber(range);
}

}
