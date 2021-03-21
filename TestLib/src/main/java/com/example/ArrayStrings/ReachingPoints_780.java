package com.example.ArrayStrings;

public class ReachingPoints_780 {
//    Examples:
//    Input: sx = 1, sy = 1, tx = 3, ty = 5
//    Output: True
//    Explanation:
//    One series of moves that transforms the starting point to the target is:
//            (1, 1) -> (1, 2)
//            (1, 2) -> (3, 2)
//            (3, 2) -> (3, 5)
//
//    Input: sx = 1, sy = 1, tx = 2, ty = 2
//    Output: False
//
//    Input: sx = 1, sy = 1, tx = 1, ty = 1
//    Output: True
//    https://leetcode.com/problems/reaching-points/
//    https://leetcode.com/problems/reaching-points/discuss/375429/Detailed-explanation.-or-full-through-process-or-Java-100-beat
//    now we met the base condition, [1,2] can only be translate for [1,1] when ty >= sy {2>1} and (ty-sy)%sx == 0 { (2-1)%1 == 0}
//    why (ty-sy)%sx == 0?
//    since
//    sy will translate to ty only by (sx+sy), if they translate then(sx, sy+k*sx) = ty for some k
//    sy+k*sx = ty => (ty-sy) / sx = k.
//    Since sx,sy,tx,ty are all integer, then k has to be a integer which means,
//    there must be a integer k that help us to reach ty. Which makes reminder to be 0
//    Hence (ty-sy) % sx == 0
    public static void main(String[] args) {
        System.out.println(reachingPoints(1,1,3,5));
    }


//    sy+k*sx = ty => (ty-sy) / sx = k.
//    Since sx,sy,tx,ty are all integer, then k has to be a integer which means,
//    there must be a integer k that help us to reach ty. Which makes reminder to be 0
//    (ty-sy) % sx == 0
    public static boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx > sx && ty > sy) {
            if (ty > tx) {
                ty = ty % tx;
            } else {
                tx = tx % ty;
            }
        }
        if (sx==tx && ty >= sy && (ty-sy)%sx==0) return true;
        else
          return (sy==ty && tx >= sx && (tx-sx)%sy==0);
    }
}