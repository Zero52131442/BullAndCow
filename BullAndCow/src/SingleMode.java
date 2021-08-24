// класс для одиночной игры
public class SingleMode implements IGameMode {
	ICurrentPlayer player ;
	public String hiddenNumb ="";
	private String winText;
	
	SingleMode(ICurrentPlayer p, String s, String txt)
	{	winText = txt;
		player=p;
		hiddenNumb = s;
	}
	public void startingTheMode() {
		while(true)
		{
			if(run()) {return;}
		}
	}
	// метод проверки на ответ игрока
	public boolean run() {

		if(player.checkTheResult(player.toAnswer(), hiddenNumb)) {
			System.out.println(winText);
			return true;
		}
		else return false;
		
	}
		
	}



