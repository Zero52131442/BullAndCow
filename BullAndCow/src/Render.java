// ����� ���������� �� ���������
public class Render {
// ����� �������� �������� ������������ ���������� ���
	public static String Draw(int n, char c) {
		String s ="";
		for(int i =0; i<n;i++) {
			s+=c;
		}
		return s;
	}
	
	// ����� ��� �������� �������
	public static void Retreat(int n) {
		
		for(int i =0; i<n;i++) {
			System.out.println();
		}
		
	}
}
