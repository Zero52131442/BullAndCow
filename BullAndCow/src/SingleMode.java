// класс для одиночной игры
public class SingleMode implements GameMode {
	CurrentPlayer player ;
	public String hiddenNumb ="";
	private String winText;
	
	SingleMode(CurrentPlayer p, String s, String txt)
	{	winText = txt;
		player=p;
		hiddenNumb = s;
	}
	public void LoopStart() {
		while(true)
		{
			if(Start()) {return;}
		}
	}
	// метод проверки на ответ игрока
	public boolean Start() {

		if(player.CheckingTheResponse(player.Answer(), hiddenNumb)) {
			System.out.println(winText);
			return true;
		}
		else return false;
		
	}
		
	}



