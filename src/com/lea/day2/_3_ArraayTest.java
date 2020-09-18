package com.lea.day2;

/**
 * @author a cheng
 * @create 2020/7/28 15:57
 */
public class _3_ArraayTest {

    public static void main(String[] args) {
        int[][] test = test(3);
        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test[i].length; j++) {
                System.out.print(test[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // 回形数格式方阵的实现
    public static int[][] test(int n){
        int[][] arrs = new int[n][n];
        int s = n*n;
        /**
         * k 定义矩阵向某个方向增加
         * k=1 向右
         * k=2 向下
         * k=3 向左
         * k=4 向上
         */
        int k = 1;
        int i=0,j=0;
        for (int m = 1; m <= s; m++) {
            if (k == 1) {
                if (j < n && arrs[i][j] == 0) {
                    arrs[i][j++] = m;
                } else {
                    k = 2;
                    i++;
                    j--;
                    m--;
                }
            }
        }
        return arrs;
    }
}
