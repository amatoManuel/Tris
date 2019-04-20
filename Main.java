package Tris;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        String  name1, name2;
        Sign sign1, sign2;
        int x,y;
        int choice = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Inserisci nome del 1° giocatore");
        name1 = input.next();
        System.out.println("Inserisci segno del 1° giocatore");
        sign1 = new Sign(input.next().charAt(0));
        System.out.println("Inserisci nome del 2° giocatore");
        name2 = input.next();
        System.out.println("Inserisci segno del 2° giocatore");
        sign2 = new Sign(input.next().charAt(0));
        Tris tris = new Tris(name1, name2, sign1, sign2);
        System.out.println(tris.startGame());
        do {
            System.out.println(tris);
            while (tris.turn < 9) {
                if (tris.checkTurn()) {
                    System.out.println(tris.player1 + " inserisci coordinate x");
                    x = input.nextInt();
                    System.out.println(tris.player1 + " inserisci coordinate y");
                    y = input.nextInt();
                    System.out.println(tris.set(x, y, tris.player1.sign.typeSign));
                    System.out.println(tris);
                } else {
                    System.out.println(tris.player2 + " inserisci coordinate x");
                    x = input.nextInt();
                    System.out.println(tris.player2 + " inserisci coordinate y");
                    y = input.nextInt();
                    System.out.println(tris.set(x, y, tris.player2.sign.typeSign));
                    System.out.println(tris);
                }
            }
            System.out.println("Vuoi iniziare un'alra partita?\n1-Si\t2-No");
            choice =input.nextInt();
            if(choice == 1)
                tris.reset();
        }while(choice == 1);
    }

}
