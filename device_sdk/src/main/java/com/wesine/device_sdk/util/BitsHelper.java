package com.wesine.device_sdk.util;

/**
 * Created by wesine on 2018/9/12.
 */

public final class BitsHelper {
    /**
     * 各ビット列の立っているビット数を数える
     * @param v
     * @return
     */
    public static int countBits(byte v) {
        int count = (v & 0x55) + ((v >>> 1) & 0x55);
        count = (count & 0x33) + ((count >>> 2) & 0x33);
        return (count & 0x0f) + ((count >>> 4) & 0x0f);
    }
    /**
     * 各ビット列の立っているビット数を数える
     * @param v
     * @return
     */
    public static int countBits(short v) {
        int count = (v & 0x5555) + ((v >>> 1) & 0x5555);
        count = (count & 0x3333) + ((count >>> 2) & 0x3333);
        count = (count & 0x0f0f) + ((count >>> 4) & 0x0f0f);
        return (count & 0x00ff) + ((count >>> 8) & 0x00ff);
    }

    /**
     * 各ビット列の立っているビット数を数える
     * @param v
     * @return
     */
    public static int countBits(int v) {
        int count = (v & 0x55555555) + ((v >>> 1) & 0x55555555);
        count = (count & 0x33333333) + ((count >>> 2) & 0x33333333);
        count = (count & 0x0f0f0f0f) + ((count >>> 4) & 0x0f0f0f0f);
        count = (count & 0x00ff00ff) + ((count >>> 8) & 0x00ff00ff);
        return (count & 0x0000ffff) + ((count >>> 16) & 0x0000ffff);
    }

    /**
     * 各ビット列の立っているビット数を数える
     * @param v
     * @return
     */
    public static int countBits(long v) {
        long count = (v & 0x5555555555555555L) + ((v >>> 1) & 0x5555555555555555L);
        count = (count & 0x3333333333333333L) + ((count >>> 2) & 0x3333333333333333L);
        count = (count & 0x0f0f0f0f0f0f0f0fL) + ((count >>> 4) & 0x0f0f0f0f0f0f0f0fL);
        count = (count & 0x00ff00ff00ff00ffL) + ((count >>> 8) & 0x00ff00ff00ff00ffL);
        count = (count & 0x0000ffff0000ffffL) + ((count >>> 16) & 0x0000ffff0000ffffL);
        return (int)((count & 0x00000000ffffffffL) + ((count >>> 32) & 0x00000000ffffffffL));
    }

    /**
     * 最大有効ビット数MSB(Most Significant Bit)を取得
     * @param v
     * @return
     */
    public static int MSB(byte v) {
        if (v == 0) return 0;
        v |= (v >>> 1);
        v |= (v >>> 2);
        v |= (v >>> 4);
        return countBits(v) - 1;
    }

    /**
     * 最大有効ビット数MSB(Most Significant Bit)を取得
     * @param v
     * @return
     */
    public static int MSB(short v) {
        if (v == 0) return 0;
        v |= (v >>> 1);
        v |= (v >>> 2);
        v |= (v >>> 4);
        v |= (v >>> 8);
        return countBits(v) - 1;
    }

    /**
     * 最大有効ビット数MSB(Most Significant Bit)を取得
     * @param v
     * @return
     */
    public static int MSB(int v) {
        if (v == 0) return 0;
        v |= (v >>> 1);
        v |= (v >>> 2);
        v |= (v >>> 4);
        v |= (v >>> 8);
        v |= (v >>> 16);
        return countBits(v) - 1;
    }

    /**
     * 最大有効ビット数MSB(Most Significant Bit)を取得</br>
     * 立っているビットの中での最大ビット位置
     * @param v
     * @return
     */
    public static int MSB(long v) {
        if (v == 0) return 0;
        v |= (v >>> 1);
        v |= (v >>> 2);
        v |= (v >>> 4);
        v |= (v >>> 8);
        v |= (v >>> 16);
        v |= (v >>> 32);
        return countBits(v) - 1;
    }

    /**
     * 最小有効ビット数LSB(Least Significant Bit)を取得</br>
     * 立っているビットの最小ビット位置
     * @param v
     * @return
     */
    public static int LSB(byte v) {
        if (v == 0) return 0;
        v |= (v << 1);
        v |= (v << 2);
        v |= (v << 4);
        return 8 - countBits(v);
    }

    /**
     * 最小有効ビット数LSB(Least Significant Bit)を取得</br>
     * 立っているビットの最小ビット位置
     * @param v
     * @return
     */
    public static int LSB(short v) {
        if (v == 0) return 0;
        v |= (v << 1);
        v |= (v << 2);
        v |= (v << 4);
        v |= (v << 8);
        return 16 - countBits(v);
    }

    /**
     * 最小有効ビット数LSB(Least Significant Bit)を取得</br>
     * 立っているビットの最小ビット位置
     * @param v
     * @return
     */
    public static int LSB(int v) {
        if (v == 0) return 0;
        v |= (v << 1);
        v |= (v << 2);
        v |= (v << 4);
        v |= (v << 8);
        v |= (v << 16);
        return 32 - countBits(v);
    }

    /**
     * 最小有効ビット数LSB(Least Significant Bit)を取得</br>
     * 立っているビットの最小ビット位置
     * @param v
     * @return
     */
    public static int LSB(long v) {
        if (v == 0) return 0;
        v |= (v << 1);
        v |= (v << 2);
        v |= (v << 4);
        v |= (v << 8);
        v |= (v << 16);
        v |= (v << 32);
        return 64 - countBits(v);
    }

    /**
     * 指定した値をよりも大きいか等しい最小の2のべき乗数を求める
     * @param v
     * @return
     */
    public static int squareBits(byte v) {
        if (v == 0) return 0;
        return 1 << (MSB(v - 1) + 1);
    }

    /**
     * 指定した値をよりも大きいか等しい最小の2のべき乗数を求める
     * @param v
     * @return
     */
    public static int squareBits(short v) {
        if (v == 0) return 0;
        return 1 << (MSB(v - 1) + 1);
    }

    /**
     * 指定した値をよりも大きいか等しい最小の2のべき乗数を求める
     * @param v
     * @return
     */
    public static int squareBits(int v) {
        if (v == 0) return 0;
        return 1 << (MSB(v - 1) + 1);
    }

    /**
     * 指定した値をよりも大きいか等しい最小の2のべき乗数を求める
     * @param v
     * @return
     */
    public static int squareBits(long v) {
        if (v == 0) return 0;
        return 1 << (MSB(v - 1) + 1);
    }
}
