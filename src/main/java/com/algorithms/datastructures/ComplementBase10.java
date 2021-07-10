package com.algorithms.datastructures;

public class ComplementBase10 {
    public int bitwiseComplement(int N) {
        if (N == 0) return 1;
        int result = 0, factor = 1;
        while (N > 0) {
            result += factor * (N % 2 == 0 ? 1 : 0);
            factor *= 2;
            N /= 2;
        }
        return result;
    }

    public int bitwiseComplement2(int N) {
        return N == 0 ? 1 : ((1 << Integer.toBinaryString(N).length()) -1) ^ N;
    }
}
