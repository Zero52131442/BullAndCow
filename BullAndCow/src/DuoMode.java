// ����� ��� ���������� ����, �� ���� ��� SingleMode ������ �������� ����� �����
public class DuoMode implements IGameMode {
	private SingleMode[] players = new SingleMode[2];
	private String win="";
	DuoMode(ICurrentPlayer[] p)
	{
		players[1]=new SingleMode(p[1],p[0].makeANumber(),Render.draw(30, '*')+" ������ ����� ������ ����� "+Render.draw(30, '*'));
		Render.retreat(30);
		players[0]=new SingleMode(p[0],p[1].makeANumber(),Render.draw(30, '*')+" ������ ����� ������ �����  "+Render.draw(30, '*'));
		Render.retreat(30);
		
	}
	public void startingTheMode() {
		while(true)
		{
			if(players[0].run())
				{win+="������ ����� ������ ����� = "+players[0].hiddenNumb+"\n";}
			if(players[1].run())
			{win+="������ ����� ������ ����� = "+players[1].hiddenNumb+"\n";}
				
			if(win!="")
			{	System.out.println(win);
				return;
			}
		}
	}
	

}
