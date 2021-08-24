import java.util.Scanner;
public class Player implements CurrentPlayer {
	 private Scanner scanner = new Scanner(System.in);
	 private String numbPlayer="";
	 private String textStep="";
	 Player(String s1,String s2) {
		 textStep=s1;
		 numbPlayer=s2;
	 }
	 
	 
	 // ����� ������� �����
	 public String GuessingANumber() {
		 
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
		 if(MyFunc.IsIntDigits(s) && !MyFunc.Repeated�haracter(s,true) && s.length()==SettingGame.numbCount ) {
		 return s;
		 }
		 else {
			 System.out.println("������������ �����");
			 return GuessingANumber();
		 }
		 
	 }
	 // ����� ������
	 	public String Answer() {
	 		Step();
	 	System.out.print("������� ���� ����� = ");
		 String s = scanner.nextLine();
		 if(MyFunc.IsIntDigits(s) && !MyFunc.Repeated�haracter(s,true)) {
			 if(s.length()==SettingGame.numbCount)
			 {
			 return s;
			 }
			 else {System.out.println("����� ����� ������ ��������� = "+ SettingGame.numbCount); return Answer();}
		 }
		 else {
			 System.out.println("������������ �����");
			return Answer();
		 }
	 }
	 	// �������� ������ 
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
			 if(bul == SettingGame.numbCount)
			 {
				 return true;
			 }
			 else {return false;}
	 	}
	 	
	 	// ����� ������ ��������� � ���� ������
	 	private void Step() {
	 		System.out.println(Render.Draw(30,'=')+textStep+Render.Draw(30,'='));
	 	}



	
}
