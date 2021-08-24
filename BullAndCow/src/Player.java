import java.util.Scanner;
public class Player implements ICurrentPlayer {
	 private Scanner scanner = new Scanner(System.in);
	 private String numbPlayer="";
	 private String textStep="";
	 Player(String s1,String s2) {
		 textStep=s1;
		 numbPlayer=s2;
	 }
	 
	 
	 // ����� ������� �����
	 public String makeANumber() {
		 
		 String lengtText;
		if(SettingGame.numbCount ==1 )
		{
			lengtText= "�����";
		}
		else if(SettingGame.numbCount>1 && SettingGame.numbCount<4  )
		{
			lengtText= "�����";
		}
		else {lengtText= "����";}
		 
		 System.out.printf(numbPlayer+"  ��������� ����� ������ �   " + SettingGame.numbCount + " %s (����� � ������ �� ������ �����������) =  ", lengtText);
		 String s = scanner.nextLine();
		 System.out.print("\n");
		 if(Helper.�heckTheNumber(s) && !Helper.checkForRepetition(s,true) && s.length()==SettingGame.numbCount ) {
		 return s;
		 }
		 else {
			 System.out.println("������������ �����");
			 return makeANumber();
		 }
		 
	 }
	 // ����� ������
	 	public String toAnswer() {
	 		makeAStep();
	 	System.out.print("������� ���� ����� = ");
		 String s = scanner.nextLine();
		 if(Helper.�heckTheNumber(s) && !Helper.checkForRepetition(s,true)) {
			 if(s.length()==SettingGame.numbCount)
			 {
			 return s;
			 }
			 else {System.out.println("����� ����� ������ ��������� = "+ SettingGame.numbCount); return toAnswer();}
		 }
		 else {
			 System.out.println("������������ �����");
			return toAnswer();
		 }
	 }
	 	// �������� ������ 
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
			 if(bul == SettingGame.numbCount)
			 {
				 return true;
			 }
			 else {return false;}
	 	}
	 	
	 	// ����� ������ ��������� � ���� ������
	 	private void makeAStep() {
	 		System.out.println(Render.draw(30,'=')+textStep+Render.draw(30,'='));
	 	}



	
}
