// ����� ��� ���� � �����
public class BotVsPlayer implements IGameMode {
	SingleMode player;
	Bot bot;
	private String hiddenNumbBot;
	private String win="";
	BotVsPlayer(ICurrentPlayer[] p)
	{
		bot = (Bot) p[1];
		player = new SingleMode(p[0],bot.makeANumber(),Render.draw(30, '*')+" �� ������� ����� "+ Render.draw(30, '*'));
		hiddenNumbBot = p[0].makeANumber();
		
	}
	
	public void startingTheMode() {
		while(true)
		{
			if(player.run())
				{win+="�� ������� ����� = "+player.hiddenNumb+"\n";}
			
			if(bot.checkTheResult(bot.toAnswer(),hiddenNumbBot))
			{win+="��� ������ ����� = "+hiddenNumbBot+"\n";}
				
			if(win!="")
			{	System.out.println(win);
				return;
			}
		}
		}
	}

