import Locations.*;

import pmain.Player;

import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);


    public void start(){
        System.out.println("Macera Oyunu'na Hosgeldiniz...");
        System.out.print("Lutfen bir isim giriniz : ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);

        System.out.println("------------------------------");
        System.out.println("------ Hosgeldin " + player.getName() + " ------");
        System.out.println("------------------------------");

        player.selectChar();
        player.characterSheet();

        Location location = null;

        while (true){
            System.out.println();
            System.out.println("####### Bolgeler #######");
            System.out.println();
            System.out.println("1- Guvenli Ev --> Burasi sizin icin guvenli bir ev , dusman yoktur.");
            System.out.println("2- Market --> Silah ve zirh satin alabilirsiniz.");
            System.out.println("3- Magara --> Magaraya git. Kolay seviye dusmanlar. Odul <Yemek>");
            System.out.println("4- Orman --> Ormana git. Orta seviye dusmanlar. Odul <Odun>");
            System.out.println("5- Nehir --> Nehire git. Yuksek seviye dusmanlar. Odul <Su>");
            System.out.print("Lutfen gitmek istediginiz bolgeyi seciniz : ");
            int selectLoc = input.nextInt();

            switch (selectLoc) {
                case 1 -> location = new SafeHouse(player);
                case 2 -> location = new ToolStore(player);
                case 3 -> location = new Cave(player);
                case 4 -> location = new Forest(player);
                case 5 -> location = new River(player);
                default -> {
                    System.out.println("Yanlis bir secim yaptiniz...");
                    continue;
                }
            }


            if(!location.onLocation()){
                System.out.println("Game Over!");
                break;
            }
        }

    }
}
