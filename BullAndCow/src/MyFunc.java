// ����� � ���������, ������� ����� ������������� � ����� ������
public class MyFunc {
// �������
	public static String PaddingLeft(String s,int n) {
		for(int i = 0 ; i<n;i++) {
			s=" "+s;
		}
		return s;
	}
	
	public static String PaddingRight(String s,int n) {
		for(int i = 0 ; i<n;i++) {
			s+=" ";
		}
		return s;
	}
	
	
// �������� ��������
	public static String DeleteChar (String s, char c) {
		
		for(int i = 0 ; i<s.length();i++) {
			if(s.charAt(i)==c) {
				s=s.substring(0,i)+s.substring(i+1);
			}
		}
		return s;
	}
	
	
	public static String DeleteChar(String s, char [] c) {
		for(int i=0; i<c.length;i++) {
				s=DeleteChar(s,c[i]);
			}
		return s;
		}
	
	
	// �������� �� �����
	public static boolean  IsIntDigit(char s) {
		char [] mas = new char [] {'0','1','2','3','4','5','6','7','8','9'};	
		for(int i =0;i<mas.length;i++) {
			if(s==mas[i]) {
				return true;
							}
				}
		return false;
	}
	
	public static boolean IsIntDigits(String s) {

		for(int i =0;i<s.length();i++) {
			if(!IsIntDigit(s.charAt(i))) {
				System.out.println("������ ���� ����� �����");
				return false;
				}	
			}
		return true;
		}
	
	
	// �����������
	public static int[] StingInInteger(String s) {
		if(IsIntDigits(s)) {
			int mas []= new  int [s.length()];
			for(int i=0;i<s.length();i++) {
				mas[i]=Integer.parseInt(""+s.charAt(i));
			}
			return mas;
		}
		else {
			System.out.println("�� ������� ������������� ������ � ������ ����");
			return null;
		}
	}
	
	// �������� ������ �� ������������
	public static boolean Repeated�haracter(String s,boolean bool) {
		for(int i = 0 ; i <s.length()-1;i++) {
			char c = s.charAt(i);
			for(int j =i+1;j<s.length();j++) {
				if(c ==s.charAt(j)) {
					if(bool==true) {
					System.out.println("����� �� ������ �����������");
					}
					return true;
				}
			}
		}
		return false;
	}
	
	
	// ��������� ����� � �� �������������� �������
	public static String GeneratingANumberWithNonRepeatingNumbers() {
		String s = "";
		while(true) {
		String c =String.valueOf((int)(Math.random() *10));
		  if(s.indexOf(c)==-1) {
			  s+=c;
		  }
		if(s.length()==SettingGame.numbCount ){
			break;}
		
		}
		return s;
	}
	
	}
	
	
	

