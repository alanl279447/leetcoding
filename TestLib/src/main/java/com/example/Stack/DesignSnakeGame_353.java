package com.example.Stack;

import java.util.LinkedList;
import java.util.Stack;

public class DesignSnakeGame_353 {
//    Given width = 3, height = 2, and food = [[1,2],[0,1]].
//    Snake snake = new Snake(width, height, food);
//    Initially the snake appears at position (0,0) and the food at (1,2).
//            |S| | |
//            | | |F|
//            snake.move("R"); -> Returns 0
//            | |S| |
//            | | |F|
//            snake.move("D"); -> Returns 0
//            | | | |
//            | |S|F|
//            snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )
//            | |F| |
//            | |S|S|
//            snake.move("U"); -> Returns 1
//            | |F|S|
//            | | |S|
//            snake.move("L"); -> Returns 2 (Snake eats the second food)
//            | |S|S|
//            | | |S|
//
//            snake.move("U"); -> Returns -1 (Game over because snake collides with border)
//    https://leetcode.com/problems/design-snake-game/

    public static void main(String[] args) {
        int[][] food = {{1,2}, {0,1}};
        SnakeGame obj = new SnakeGame(3, 2, food);
        int param_1 = obj.move("R");
        System.out.print(param_1);
    }

    static class SnakeGame {
        LinkedList<Position> snake;
        int[][] food;
        int foodCount;
        int width;
        int height;
        /** Initialize your data structure here.
         @param width - screen width
         @param height - screen height
         @param food - A list of food positions
         E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
        public SnakeGame(int width, int height, int[][] food) {
            this.width = width;
            this.height = height;
            this.food = food;
            this.foodCount = 0;
            this.snake = new LinkedList<>();
            snake.add(new Position(0, 0));
        }

        /** Moves the snake.
         @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
         @return The game's score after the move. Return -1 if game over.
         Game over when snake crosses the screen boundary or bites its body. */
        public int move(String direction) {
            // when snake move, the head move to current position (U, L, R,D)
            Position head = snake.getFirst();
            Position newHead = new Position(head.x, head.y);
            Position tail = snake.removeLast();

            if(direction.equals("U")) {
                newHead.x--;
            } else if(direction.equals("L")) {
                newHead.y--;
            } else if(direction.equals("R")) {
                newHead.y++;
            } else {
                newHead.x++;
            }

            // edge cases
            // 1. hit the border.
            // 2. hit its body.
            // note: snake.contains(newHead) -> requires to override the equals method in Position object.
            if(newHead.x < 0 || newHead.x == height || newHead.y < 0 || newHead.y == width || snake.contains(newHead)) return -1;

            // if snake meets the food, add the tail back, because snake body extends one from the head.
            snake.addFirst(newHead);
            if(foodCount< food.length && food[foodCount][0] == newHead.x && food[foodCount][1] == newHead.y) {
                snake.addLast(tail);
                foodCount++;
            }
            return foodCount;

        }
    }
    // the position in the board
    static class Position {
        int x;
        int y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if(o == this) return true;
            if(! (o instanceof Position)) return false;

            Position p = (Position) o;
            if(p.x == this.x && p.y == this.y)  return true;

            return false;
        }
    }
}