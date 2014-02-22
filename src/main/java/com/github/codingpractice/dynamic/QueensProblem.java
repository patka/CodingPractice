package com.github.codingpractice.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Patrick Kranz
 */
public class QueensProblem {
    private List<Coordinate> coordinates = new ArrayList<>();

    public boolean solve(int numberOfQueens, int boardSize) {
        if (numberOfQueens == 0)
            return true;

        for (int j = 0; j<boardSize; j++) {
            if (isQueenSave(boardSize - numberOfQueens, j)) {
                Coordinate coordinate = new Coordinate(boardSize - numberOfQueens, j);
                coordinates.add(coordinate);
                if (!solve(numberOfQueens - 1, boardSize)) {
                    coordinates.remove(coordinate);
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isQueenSave(int line, int row) {
        for (Coordinate coordinate : coordinates) {
            if (coordinate.getX() == line || coordinate.getY() == row)
                return false;
            int diff = line - row;
            if ((coordinate.getX() - coordinate.getY()) == diff)
                return false;
            if ((coordinate.getX() + coordinate.getY()) == line + row)
                return false;
        }
        return true;
    }

    public void printBoard() {
        int[][] board = new int[coordinates.size()][coordinates.size()];
        for (Coordinate coordinate : coordinates) {
            board[coordinate.getX()][coordinate.getY()] = 1;
        }
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y< board.length; y++) {
                System.out.print(board[x][y] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        QueensProblem problem = new QueensProblem();
        System.out.println(problem.solve(8, 8));
        problem.printBoard();
    }
}

class Coordinate {
    private int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}