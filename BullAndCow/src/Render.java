// ����� ���������� �� ���������
public class Render {
// ����� �������� �������� ������������ ���������� ���
	public static String draw(int n, char c) {
		String s ="";
		for(int i =0; i<n;i++) {
			s+=c;
		}
		return s;
	}
	
	// ����� ��� �������� �������
	public static void retreat(int n) {
		
		for(int i =0; i<n;i++) {
			System.out.println();
		}
		
	}
}
