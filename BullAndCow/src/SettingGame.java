import java.util.Scanner;
// ����� ���������� ���� �������� 
public class SettingGame {
	// ����� �����
	public static int numbCount = 0;
		// ����� ��������� ����� ����� 
	public static void SetCountNumb() {
		 	Scanner scanner = new Scanner(System.in);
		 	System.out.print("������� ����� ������������� ����� �� 1 �� 9 = ");
			 String s = scanner.nextLine();
			 System.out.print("\n");
			 if(s!="" && MyFunc.IsIntDigits(s) && (Integer.parseInt(s)<10 && Integer.parseInt(s)>0)) {
			 SettingGame.numbCount = Integer.parseInt(s); 
			
			 }
			 else {
				 System.out.println("������������ �����");
				 SetCountNumb();
			 }

	 }
	// ����� ��������� ������ ����
	public static GameMode SetPlayers() {
		System.out.print("��� ��������� ���� ������� '1'\n"
				+"��� ����  � ���� ������� '2'\n"
				+"��� ����  � ����� ������� '3'\n"
				+"��� ����� = ");
		    Scanner scanner = new Scanner(System.in);
			String n = scanner.nextLine();
			if(MyFunc.IsIntDigits(n))
			{
				switch (n) {
			case  ("1"):
				System.out.println(Render.Draw(30,'=')+" ����� ��������� ���� "+Render.Draw(30,'=')+"\n"+ "����� �������� �����������");
			return	new SingleMode(new Player("��� ���",""),MyFunc.GeneratingANumberWithNonRepeatingNumbers(),Render.Draw(30, '*')+" �� ������� ����� "+ Render.Draw(30, '*'));
			case ("2"):
				System.out.println(Render.Draw(30,'=')+" ����� ���������� ���� "+Render.Draw(30,'=')+"\n");
			return	new DuoMode(new CurrentPlayer[]{new Player("��� ������� ������","����� 1"),new Player("��� ������� ������","����� 2")});
			case ("3"):
				System.out.println(Render.Draw(30,'=')+" ����� ���� ������ ����"+Render.Draw(30,'=')+"\n");
			return	new BotVsPlayer(new CurrentPlayer[]{new Player("��� ���",""),new BotPlayer()});
      
			default:
			    System.out.println("������� �������� ��������\n");
			    return  SetPlayers();
   }
}

else {
			System.out.println("������� �������� ��������\n");
			return  SetPlayers();
}
		}

}
