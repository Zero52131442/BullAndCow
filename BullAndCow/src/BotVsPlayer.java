// Класс для игры с ботом
public class BotVsPlayer implements GameMode {
	SingleMode player;
	BotPlayer bot;
	private String hiddenNumbBot;
	private String win="";
	BotVsPlayer(CurrentPlayer[] p)
	{
		bot = (BotPlayer) p[1];
		player = new SingleMode(p[0],bot.GuessingANumber(),Render.Draw(30, '*')+" Вы угадали число "+ Render.Draw(30, '*'));
		hiddenNumbBot = p[0].GuessingANumber();
		
	}
	
	public void LoopStart() {
		while(true)
		{
			if(player.Start())
				{win+="Вы угадали число = "+player.hiddenNumb+"\n";}
			if(bot.CheckingTheResponse(bot.Answer(), hiddenNumbBot))
			{win+="Бот угадал число = "+hiddenNumbBot+"\n";}
				
			if(win!="")
			{	System.out.println(win);
				return;
			}
		}
		}
	}

