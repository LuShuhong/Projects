package Hourglass;

public class Hourglass {
    public static void main(String[] args) {
        int length = Integer.parseInt(args[0]);
        String line = "";
        for (int i = 0; i < 2 * length - 1; i++) {
            for (int j = 0; j < 2 * length - 1; j++) {
                if (i < length) {
                    if (j < i || j >= 2 * length - 1 - i) {
                        line += " ";
                    } else {
                        line += "*";
                    }
                } else {
                    if (j + i < 2 * length - 2 || j > i) {
                        line += " ";
                    } else {
                        line += "*";
                    }
                }


            }
            System.out.println(line);
            line = "";
        }
    }
    }

