// ��������� ��� ����������� ������� ������� �������
public interface ICurrentPlayer {
	public String makeANumber();
	public String toAnswer();
	public boolean checkTheResult(String answer, String hiddenNumber);
}
