// ����� ���������� �� ���������� ���� ������
public class Game {
	 private IGameMode mode=null; ;
	 // ����� ������ ����
	 public void outputRules() {
	System.out.println(Render.draw(30,'=')+" ������� ���� "+Render.draw(30,'='));
	System.out.println("� ������ ���� ����� �������� ��� �����, ���� ����, ������ �����������\n"
			+ "���� ���� � ���, ����� �������� ���������� ����� ������� ����������\n"
			+ "����� � ������ �� �����������\n"
			+ "�� ������ �������� ����� � ����� ����������� � ����� ������� ��� ����� �������� ���\n"
			+"�� ������ �������� ����� � ����� ����������� �� � ����� ������� ��� ����� ��������� ������\n"
			+ "������: �������� ������ ����� 3219. ����� :2310\n"
			+"���������: ��� ������ (��� �����: 2 � 3  ������� �� �������� ��������) � ���� ��� (���� ����� 1 ������� ������ �� �������).\n");
	System.out.println(Render.draw(30,'=')+" �������� ��������� ���� ���� "+Render.draw(30,'='));
	 }
	 
	 // ����� ������������� �������� � ������ ����
	 public void beginGame() {	 
		 SettingGame.setCountNumb();
		 mode= SettingGame.setPlayers();
		 mode.startingTheMode();

	 }
	 
		 



}
