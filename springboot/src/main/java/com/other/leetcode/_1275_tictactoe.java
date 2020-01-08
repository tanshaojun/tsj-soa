package com.other.leetcode;

/**
 * 1275. 找出井字棋的获胜者
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/1/8 15:33
 */
public class _1275_tictactoe {
    public String tictactoe(int[][] moves) {
        if (moves.length < 5) return "Pending";
        int[][] ints = new int[3][3];
        for (int i = 0; i < moves.length; i++) {
            int a = moves[i][0];
            int b = moves[i][1];
            if (i % 2 == 0) ints[a][b] = 1;
            else ints[a][b] = 2;
            if (i >= 4) {
                boolean b1 = ints[0][0] != 0 ? ints[0][0] == ints[0][1] ? ints[0][1] == ints[0][2] : false : false;
                boolean b2 = ints[1][0] != 0 ? ints[1][0] == ints[1][1] ? ints[1][1] == ints[1][2] : false : false;
                boolean b3 = ints[2][0] != 0 ? ints[2][0] == ints[2][1] ? ints[2][1] == ints[2][2] : false : false;

                boolean b4 = ints[0][0] != 0 ? ints[0][0] == ints[1][0] ? ints[1][0] == ints[2][0] : false : false;
                boolean b5 = ints[0][1] != 0 ? ints[0][1] == ints[1][1] ? ints[1][1] == ints[2][1] : false : false;
                boolean b6 = ints[0][2] != 0 ? ints[0][2] == ints[1][2] ? ints[1][2] == ints[2][2] : false : false;

                boolean b7 = ints[0][0] != 0 ? ints[0][0] == ints[1][1] ? ints[1][1] == ints[2][2] : false : false;
                boolean b8 = ints[0][2] != 0 ? ints[0][2] == ints[1][1] ? ints[1][1] == ints[2][0] : false : false;
                if (b1 || b2 || b3 || b4 || b5 || b6 || b7 || b8)
                    return ints[a][b] == 1 ? "A" : "B";
            }
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }

}
