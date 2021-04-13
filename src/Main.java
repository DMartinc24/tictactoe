package tictactoe;

import java.util.Scanner;


public class Main {
    static char[][] inputCharacters = new char[3][5];
    static Scanner scanner = new Scanner(System.in);
    static int x;
    static int y;
    static int player = 2;

    public static void main(String[] args) {
        // write your code here

        inputCharacters[0][0] = '|';
        inputCharacters[0][4] = '|';
        inputCharacters[1][0] = '|';
        inputCharacters[1][4] = '|';
        inputCharacters[2][0] = '|';
        inputCharacters[2][4] = '|';

        getInput();
        printGrid();
        while (true) {
            enterCoordinates();
            if ((verifyX() && verifyO()) || verifyImpossible()) {
                System.out.println("Impossible");
                break;
            } else if (verifyX()) {
                System.out.println("X wins");
                break;
            } else if (verifyO()) {
                System.out.println("O wins");
                break;
            } else {
                if (!verifyEmptyCells()) {
                    System.out.println("Draw");
                    break;
                }
            }
        }

    }

    public static void getInput() {

        for (int i = 0; i < 3; i++) {
            for (int j = 1; j <= 3; j++) {
                inputCharacters[i][j] = '_';
            }
        }
    }

    public static void printGrid() {
        System.out.println("---------");
        for (char[] inputCharacter : inputCharacters) {
            for (char c : inputCharacter) {
                System.out.print(c);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("---------");
    }

    public static boolean verifyImpossible() {
        boolean isImpossible = false;

        int x = 0;
        int o = 0;

        for (char[] inputCharacter : inputCharacters) {
            for (char c : inputCharacter) {
                if (c == 'X') x++;
                else if (c == 'O') o++;
            }
        }

        if (x - o > 1 || o - x > 1) isImpossible = true;
        return isImpossible;

    }

    public static void enterCoordinates() {
        int z = 0;
        System.out.print("Enter the coordinates: ");
        do {
            if (scanner.hasNextInt()) {
                x = scanner.nextInt();
                y = scanner.nextInt();
                z = 1;
            } else {
                String input = scanner.nextLine();
                if (!input.isEmpty()) {
                    System.out.println("You need to enter numbers!");
                    System.out.print("Enter the coordinates: ");
                }
            }
        } while (z != 1);


        if (x > 3 || x < 1 || y > 3 || y < 1) {
            System.out.println("Coordinates should be from 1 to 3!");
            enterCoordinates();
        } else {
            if (inputCharacters[x - 1][y] == 'X' || inputCharacters[x - 1][y] == 'O') {
                System.out.println("This cell is occupied! Choose another one!");
                enterCoordinates();
            } else {
                if (player % 2 == 0) {
                    inputCharacters[x - 1][y] = 'X';
                    player++;
                } else {
                    inputCharacters[x - 1][y] = 'O';
                    player++;
                }
                printGrid();
            }
        }

    }

    public static boolean verifyX() {
        boolean xScores = false;

        if (inputCharacters[0][1] == 'X') {
            if (inputCharacters[0][2] == 'X') {
                if (inputCharacters[0][3] == 'X') {
                    xScores = true;
                }
            }
        }

        if (inputCharacters[1][1] == 'X') {
            if (inputCharacters[1][2] == 'X') {
                if (inputCharacters[1][3] == 'X') {
                    xScores = true;
                }
            }
        }

        if (inputCharacters[2][1] == 'X') {
            if (inputCharacters[2][2] == 'X') {
                if (inputCharacters[2][3] == 'X') {
                    xScores = true;
                }
            }
        }

        if (inputCharacters[0][1] == 'X') {
            if (inputCharacters[1][1] == 'X') {
                if (inputCharacters[2][1] == 'X') {
                    xScores = true;
                }
            }
        }

        if (inputCharacters[0][2] == 'X') {
            if (inputCharacters[1][2] == 'X') {
                if (inputCharacters[2][2] == 'X') {
                    xScores = true;
                }
            }
        }


        if (inputCharacters[0][3] == 'X') {
            if (inputCharacters[1][3] == 'X') {
                if (inputCharacters[2][3] == 'X') {
                    xScores = true;
                }
            }
        }

        if (inputCharacters[0][1] == 'X') {
            if (inputCharacters[1][2] == 'X') {
                if (inputCharacters[2][3] == 'X') {
                    xScores = true;
                }
            }
        }

        if (inputCharacters[0][3] == 'X') {
            if (inputCharacters[1][2] == 'X') {
                if (inputCharacters[2][1] == 'X') {
                    xScores = true;
                }
            }
        }
        return xScores;
    }


    public static boolean verifyO() {
        boolean oScores = false;

        if (inputCharacters[0][1] == 'O') {
            if (inputCharacters[0][2] == 'O') {
                if (inputCharacters[0][3] == 'O') {
                    oScores = true;
                }
            }
        }

        if (inputCharacters[1][1] == 'O') {
            if (inputCharacters[1][2] == 'O') {
                if (inputCharacters[1][3] == 'O') {
                    oScores = true;
                }
            }
        }

        if (inputCharacters[2][1] == 'O') {
            if (inputCharacters[2][2] == 'O') {
                if (inputCharacters[2][3] == 'O') {
                    oScores = true;
                }
            }
        }

        if (inputCharacters[0][1] == 'O') {
            if (inputCharacters[1][1] == 'O') {
                if (inputCharacters[2][1] == 'O') {
                    oScores = true;
                }
            }
        }

        if (inputCharacters[0][2] == 'O') {
            if (inputCharacters[1][2] == 'O') {
                if (inputCharacters[2][2] == 'O') {
                    oScores = true;
                }
            }
        }


        if (inputCharacters[0][3] == 'O') {
            if (inputCharacters[1][3] == 'O') {
                if (inputCharacters[2][3] == 'O') {
                    oScores = true;
                }
            }
        }

        if (inputCharacters[0][1] == 'O') {
            if (inputCharacters[1][2] == 'O') {
                if (inputCharacters[2][3] == 'O') {
                    oScores = true;
                }
            }
        }

        if (inputCharacters[0][3] == 'O') {
            if (inputCharacters[1][2] == 'O') {
                if (inputCharacters[2][1] == 'O') {
                    oScores = true;
                }
            }
        }
        return oScores;
    }


    public static boolean verifyEmptyCells() {
        boolean emptyCellsExist = false;

        for (char[] inputCharacter : inputCharacters) {
            for (char c : inputCharacter) {
                if (c == '_') {
                    emptyCellsExist = true;
                    break;
                }
            }
        }

        return emptyCellsExist;
    }
}