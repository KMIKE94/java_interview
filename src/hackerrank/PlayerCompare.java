package hackerrank;

import java.util.*;

// Write your Checker class here
class Checker implements Comparator<Player> {

    public int compare(Player o1, Player o2) {
        if(o1.name.equalsIgnoreCase(o2.name)) {
            if (o1.score > o2.score) {
                return 1;
            } else if(o1.score == o2.score) {
                return 0;
            } else {
                return -1;
            }
        } else if (o1.name.charAt(0) < o2.name.charAt(0)) {
            return 1;
        }

        return -1;
    }

}

class Player{
    String name;
    int score;

    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

class PlayerCompare {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}