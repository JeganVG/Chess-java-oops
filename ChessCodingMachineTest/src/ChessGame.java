import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ChessGame implements Game {

    ArrayList<String> moves = new ArrayList<>();

    String[] blackElements = { "BR1", "BN1", "BB1", "BQ1", "BK1", "BB2", "BN2", "BR2", "BP1", "BP2", "BP3", "BP4",
            "BP5", "BP6", "BP7", "BP8" };
    String[] whiteElements = { "WR1", "WN1", "WB1", "WQ1", "WK1", "WB2", "WN2", "WR2", "WP1", "WP2", "WP3", "WP4",
            "WP5", "WP6", "WP7", "WP8" };

    String[] type = { "W", "B" };
    int count = 0;

    Map<String, Chessman> assign = new HashMap<>();
    String[][] board = new String[8][8];
    String y = "abcdefgh";
    String x = "87654321";
    ArrayList<Chessman> elements = new ArrayList<>();

    public void init() {
        int i, j;
        for (i = 0; i < y.length(); i++) {
            for (j = 0; j < x.length(); j++) {

                board[i][j] = "" + y.charAt(j) + x.charAt(i);
                if (i == 0) {
                    String type = "" + blackElements[i].charAt(1);
                    if (type.equals("K")) {
                        King n = new King("B", blackElements[j], board[i][j], type);
                        elements.add(n);
                        assign.put(board[i][j], n);
                    } else if (type.equals("Q")) {
                        Queen n = new Queen("B", blackElements[j], board[i][j], type);
                        elements.add(n);
                        assign.put(board[i][j], n);
                    } else if (type.equals("R")) {
                        Rook n = new Rook("B", blackElements[j], board[i][j], type);
                        elements.add(n);
                        assign.put(board[i][j], n);
                    } else if (type.equals("B")) {
                        Bishop n = new Bishop("B", blackElements[j], board[i][j], type);
                        elements.add(n);
                        assign.put(board[i][j], n);
                    } else if (type.equals("N")) {
                        Knight n = new Knight("B", blackElements[j], board[i][j], type);
                        elements.add(n);
                        assign.put(board[i][j], n);
                    }

                }

                else if (i == 1) {
                    String type = "" + blackElements[i].charAt(1);
                    Pawn n = new Pawn("B", blackElements[j + 8], board[i][j], type);
                    elements.add(n);
                    assign.put(board[i][j], n);
                }

                else if (i == 7) {
                    String type = "" + whiteElements[i].charAt(1);
                    if (type.equals("K")) {
                        King n = new King("W", whiteElements[j], board[i][j], type);
                        elements.add(n);
                        assign.put(board[i][j], n);
                    } else if (type.equals("Q")) {
                        Queen n = new Queen("W", whiteElements[j], board[i][j], type);
                        elements.add(n);
                        assign.put(board[i][j], n);
                    } else if (type.equals("R")) {
                        Rook n = new Rook("W", whiteElements[j], board[i][j], type);
                        elements.add(n);
                        assign.put(board[i][j], n);
                    } else if (type.equals("B")) {
                        Bishop n = new Bishop("W", whiteElements[j], board[i][j], type);
                        elements.add(n);
                        assign.put(board[i][j], n);
                    } else if (type.equals("N")) {
                        Knight n = new Knight("W", whiteElements[j], board[i][j], type);
                        elements.add(n);
                        assign.put(board[i][j], n);
                    }
                }

                else if (i == 6) {
                    String type = "" + whiteElements[i].charAt(1);
                    Pawn n = new Pawn("W", whiteElements[j + 8], board[i][j], type);
                    elements.add(n);
                    assign.put(board[i][j], n);
                }
            }
        }
        while (true) {
            display();

            if (count % 2 == 0) {
                play(type[0]);
            } else {
                play(type[1]);
            }
            count += 1;
        }
    }

    public void display() {
        int i, j;
        String line = "--------";
        String lines = "     ";
        String header = "";
        header += "     ";

        for (i = 0; i < 8; i++) {
            header += "|";
            header += "   ";
            header += y.charAt(i);
            header += "   ";
            if (i == 7) {
                header += "|";
                lines += "-";
            }
            lines += line;
        }

        System.out.println(header);
        System.out.println(lines);

        for (i = 0; i < 8; i++) {
            String str = "";
            str += "  ";
            str += x.charAt(i);
            str += "  ";
            for (j = 0; j < 8; j++) {
                str += "|";
                str += "  ";
                if (assign.get(board[i][j]) == null) {
                    str += "   ";
                } else {
                    str += assign.get(board[i][j]).getID();
                }
                str += "  ";
                if (j == 7)
                    str += "|";
            }

            System.out.println(str);
            System.out.println(lines);
        }
    }

    public void play(String type) {
        String move = "";
        Scanner scan = new Scanner(System.in);
        System.out.println("ENTER THE ELEMENT YOU NEED TO MOVE: ");
        String man = scan.next();
        System.out.println("ENTER THE POSITION YOU NEED TO MOVE: ");
        String position = scan.next();
        move += position + ":" + man;
        moves.add(move);
        System.out.println(moves);

        if (type == "B") {
            if (Arrays.asList(blackElements).contains(man)) {
                for (java.util.Map.Entry<String, Chessman> entry : assign.entrySet()) {
                    if (entry.getValue().getID().toString().equals(man)) {
                        assign.remove(entry.getKey().toString());
                        break;
                    }
                }
                for (Chessman k : elements) {
                    if (k.getID().equals(man) ) {
                        String[] poss_locations = k.check

                        k.setPosition(position);
                        assign.remove(position);
                        assign.put(position, k);
                        assign.get(position);
                    }

                }

            } else {
                System.out.println("PLEASE ENTER VALID CHESSMAN !!");
                play(type);
            }
        } else {
            if (Arrays.asList(whiteElements).contains(man)) {
                for (java.util.Map.Entry<String, Chessman> entry : assign.entrySet()) {
                    if (entry.getValue().getID().toString().equals(man)) {
                        assign.remove(entry.getKey().toString());
                        break;
                    }
                }
                for (Chessman k : elements) {
                    if (k.getID().equals(man)) {
                        k.setPosition(position);
                        assign.remove(position);
                        assign.put(position, k);
                        assign.get(position);
                    }

                }

            } else {
                System.out.println("PLEASE ENTER VALID CHESSMAN !!");
                play(type);
            }

        }
    }
}
