import java.util.Scanner;
// класс содержащий поля настроек 
public class SettingGame {
	// длина числа
	public static int numbCount = 0;
		// метод установки длины числа 
	public static void setCountNumb() {
		 	Scanner scanner = new Scanner(System.in);
		 	System.out.print("Введите длину загадываемого числа от 1 до 9 = ");
			 String s = scanner.nextLine();
			 System.out.print("\n");
			 if(s!="" && Helper.сheckTheNumber(s) && (Integer.parseInt(s)<10 && Integer.parseInt(s)>0)) {
			 SettingGame.numbCount = Integer.parseInt(s); 
			
			 }
			 else {
				 System.out.println("Некорректное число");
				 setCountNumb();
			 }

	 }
	// метод установки режима игры
	public static IGameMode setPlayers() {
		System.out.print("Для одиночной игры нажмите '1'\n"
				+"Для игры  в двоём нажмите '2'\n"
				+"Для игры  с ботом нажмите '3'\n"
				+"Ваш выбор = ");
		    Scanner scanner = new Scanner(System.in);
			String n = scanner.nextLine();
			if(Helper.сheckTheNumber(n))
			{
				switch (n) {
			case  ("1"):
				System.out.println(Render.draw(30,'=')+" Режим одиночной игры "+Render.draw(30,'=')+"\n"+ "Число загадано компьютером");
			return	new SingleMode(new Player("Ваш ход",""),Helper.generateANumberWithoutRepetitions(),Render.draw(30, '*')+" Вы угадали число "+ Render.draw(30, '*'));
			case ("2"):
				System.out.println(Render.draw(30,'=')+" Режим совместной игры "+Render.draw(30,'=')+"\n");
			return	new DuoMode(new ICurrentPlayer[]{new Player("Ход первого игрока","Игрок 1"),new Player("Ход второго игрока","Игрок 2")});
			case ("3"):
				System.out.println(Render.draw(30,'=')+" Режим игры против бота"+Render.draw(30,'=')+"\n");
			return	new BotVsPlayer(new ICurrentPlayer[]{new Player("Ваш Ход",""),new Bot()});
      
			default:
			    System.out.println("Веденно неверное значение\n");
			    return  setPlayers();
   }
}

else {
			System.out.println("Веденно неверное значение\n");
			return  setPlayers();
}
		}

}
