import java.util.Scanner;
// ����� ���������� ���� �������� 
public class SettingGame {
	// ����� �����
	public static int numbCount = 0;
		// ����� ��������� ����� ����� 
	public static void setCountNumb() {
		 	Scanner scanner = new Scanner(System.in);
		 	System.out.print("������� ����� ������������� ����� �� 1 �� 9 = ");
			 String s = scanner.nextLine();
			 System.out.print("\n");
			 if(s!="" && Helper.�heckTheNumber(s) && (Integer.parseInt(s)<10 && Integer.parseInt(s)>0)) {
			 SettingGame.numbCount = Integer.parseInt(s); 
			
			 }
			 else {
				 System.out.println("������������ �����");
				 setCountNumb();
			 }

	 }
	// ����� ��������� ������ ����
	public static IGameMode setPlayers() {
		System.out.print("��� ��������� ���� ������� '1'\n"
				+"��� ����  � ���� ������� '2'\n"
				+"��� ����  � ����� ������� '3'\n"
				+"��� ����� = ");
		    Scanner scanner = new Scanner(System.in);
			String n = scanner.nextLine();
			if(Helper.�heckTheNumber(n))
			{
				switch (n) {
			case  ("1"):
				System.out.println(Render.draw(30,'=')+" ����� ��������� ���� "+Render.draw(30,'=')+"\n"+ "����� �������� �����������");
			return	new SingleMode(new Player("��� ���",""),Helper.generateANumberWithoutRepetitions(),Render.draw(30, '*')+" �� ������� ����� "+ Render.draw(30, '*'));
			case ("2"):
				System.out.println(Render.draw(30,'=')+" ����� ���������� ���� "+Render.draw(30,'=')+"\n");
			return	new DuoMode(new ICurrentPlayer[]{new Player("��� ������� ������","����� 1"),new Player("��� ������� ������","����� 2")});
			case ("3"):
				System.out.println(Render.draw(30,'=')+" ����� ���� ������ ����"+Render.draw(30,'=')+"\n");
			return	new BotVsPlayer(new ICurrentPlayer[]{new Player("��� ���",""),new Bot()});
      
			default:
			    System.out.println("������� �������� ��������\n");
			    return  setPlayers();
   }
}

else {
			System.out.println("������� �������� ��������\n");
			return  setPlayers();
}
		}

}
