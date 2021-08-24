// Класс для игры с ботом
public class BotVsPlayer implements IGameMode {
	SingleMode player;
	Bot bot;
	private String hiddenNumbBot;
	private String win="";
	BotVsPlayer(ICurrentPlayer[] p)
	{
		bot = (Bot) p[1];
		player = new SingleMode(p[0],bot.makeANumber(),Render.draw(30, '*')+" Вы угадали число "+ Render.draw(30, '*'));
		hiddenNumbBot = p[0].makeANumber();
		
	}
	
	public void startingTheMode() {
		while(true)
		{
			if(player.run())
				{win+="Вы угадали число = "+player.hiddenNumb+"\n";}
			
			if(bot.checkTheResult(bot.toAnswer(),hiddenNumbBot))
			{win+="Бот угадал число = "+hiddenNumbBot+"\n";}
				
			if(win!="")
			{	System.out.println(win);
				return;
			}
		}
		}
	}

