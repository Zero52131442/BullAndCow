// класс для совместной игры, по сути два SingleMode класса играющих между собой
public class DuoMode implements GameMode {
	private SingleMode[] players = new SingleMode[2];
	private String win="";
	DuoMode(CurrentPlayer[] p)
	{
		players[1]=new SingleMode(p[1],p[0].GuessingANumber(),Render.Draw(30, '*')+" Второй игрок угадал число "+Render.Draw(30, '*'));
		Render.Retreat(30);
		players[0]=new SingleMode(p[0],p[1].GuessingANumber(),Render.Draw(30, '*')+" Первый игрок угадал число  "+Render.Draw(30, '*'));
		Render.Retreat(30);
		
	}
	public void LoopStart() {
		while(true)
		{
			if(players[0].Start())
				{win+="Первый игрок угадал число = "+players[0].hiddenNumb+"\n";}
			if(players[1].Start())
			{win+="Второй игрок угадал число = "+players[1].hiddenNumb+"\n";}
				
			if(win!="")
			{	System.out.println(win);
				return;
			}
		}
	}
	

}
