// Интерфейс для определение главных методов игроков
public interface CurrentPlayer {
	public String GuessingANumber();
	public String Answer();
	public boolean CheckingTheResponse(String answer, String hiddenNumber);
}
