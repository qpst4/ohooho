package defpackage;

import java.lang.reflect.Array;
import java.math.BigInteger;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class gw {
    public static final long[] a;
    public static final ew[][] b;
    public static final ew[] c;
    public static final BigInteger d;
    public static final BigInteger e;
    public static final BigInteger f;

    static {
        BigInteger bigIntegerSubtract = BigInteger.valueOf(2L).pow(255).subtract(BigInteger.valueOf(19L));
        d = bigIntegerSubtract;
        BigInteger bigIntegerMod = BigInteger.valueOf(-121665L).multiply(BigInteger.valueOf(121666L).modInverse(bigIntegerSubtract)).mod(bigIntegerSubtract);
        e = bigIntegerMod;
        BigInteger bigIntegerMod2 = BigInteger.valueOf(2L).multiply(bigIntegerMod).mod(bigIntegerSubtract);
        f = bigIntegerMod2;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(2L);
        BigInteger bigInteger = BigInteger.ONE;
        BigInteger bigIntegerModPow = bigIntegerValueOf.modPow(bigIntegerSubtract.subtract(bigInteger).divide(BigInteger.valueOf(4L)), bigIntegerSubtract);
        i9 i9Var = new i9(13);
        BigInteger bigIntegerMod3 = BigInteger.valueOf(4L).multiply(BigInteger.valueOf(5L).modInverse(bigIntegerSubtract)).mod(bigIntegerSubtract);
        i9Var.d = bigIntegerMod3;
        BigInteger bigIntegerMultiply = bigIntegerMod3.pow(2).subtract(bigInteger).multiply(bigIntegerMod.multiply(bigIntegerMod3.pow(2)).add(bigInteger).modInverse(bigIntegerSubtract));
        BigInteger bigIntegerModPow2 = bigIntegerMultiply.modPow(bigIntegerSubtract.add(BigInteger.valueOf(3L)).divide(BigInteger.valueOf(8L)), bigIntegerSubtract);
        if (!bigIntegerModPow2.pow(2).subtract(bigIntegerMultiply).mod(bigIntegerSubtract).equals(BigInteger.ZERO)) {
            bigIntegerModPow2 = bigIntegerModPow2.multiply(bigIntegerModPow).mod(bigIntegerSubtract);
        }
        if (bigIntegerModPow2.testBit(0)) {
            bigIntegerModPow2 = bigIntegerSubtract.subtract(bigIntegerModPow2);
        }
        i9Var.c = bigIntegerModPow2;
        a = lc1.t(c(bigIntegerMod));
        lc1.t(c(bigIntegerMod2));
        lc1.t(c(bigIntegerModPow));
        b = (ew[][]) Array.newInstance((Class<?>) ew.class, 32, 8);
        i9 i9VarA = i9Var;
        for (int i = 0; i < 32; i++) {
            i9 i9VarA2 = i9VarA;
            for (int i2 = 0; i2 < 8; i2++) {
                b[i][i2] = b(i9VarA2);
                i9VarA2 = a(i9VarA2, i9VarA);
            }
            for (int i3 = 0; i3 < 8; i3++) {
                i9VarA = a(i9VarA, i9VarA);
            }
        }
        i9 i9VarA3 = a(i9Var, i9Var);
        c = new ew[8];
        for (int i4 = 0; i4 < 8; i4++) {
            c[i4] = b(i9Var);
            i9Var = a(i9Var, i9VarA3);
        }
    }

    public static i9 a(i9 i9Var, i9 i9Var2) {
        i9 i9Var3 = new i9(13);
        BigInteger bigIntegerMultiply = e.multiply(((BigInteger) i9Var.c).multiply((BigInteger) i9Var2.c).multiply((BigInteger) i9Var.d).multiply((BigInteger) i9Var2.d));
        BigInteger bigInteger = d;
        BigInteger bigIntegerMod = bigIntegerMultiply.mod(bigInteger);
        BigInteger bigIntegerAdd = ((BigInteger) i9Var.c).multiply((BigInteger) i9Var2.d).add(((BigInteger) i9Var2.c).multiply((BigInteger) i9Var.d));
        BigInteger bigInteger2 = BigInteger.ONE;
        i9Var3.c = bigIntegerAdd.multiply(bigInteger2.add(bigIntegerMod).modInverse(bigInteger)).mod(bigInteger);
        i9Var3.d = ((BigInteger) i9Var.d).multiply((BigInteger) i9Var2.d).add(((BigInteger) i9Var.c).multiply((BigInteger) i9Var2.c)).multiply(bigInteger2.subtract(bigIntegerMod).modInverse(bigInteger)).mod(bigInteger);
        return i9Var3;
    }

    public static ew b(i9 i9Var) {
        BigInteger bigIntegerAdd = ((BigInteger) i9Var.d).add((BigInteger) i9Var.c);
        BigInteger bigInteger = d;
        return new ew(lc1.t(c(bigIntegerAdd.mod(bigInteger))), lc1.t(c(((BigInteger) i9Var.d).subtract((BigInteger) i9Var.c).mod(bigInteger))), lc1.t(c(f.multiply((BigInteger) i9Var.c).multiply((BigInteger) i9Var.d).mod(bigInteger))));
    }

    public static byte[] c(BigInteger bigInteger) {
        byte[] bArr = new byte[32];
        byte[] byteArray = bigInteger.toByteArray();
        System.arraycopy(byteArray, 0, bArr, 32 - byteArray.length, byteArray.length);
        for (int i = 0; i < 16; i++) {
            byte b2 = bArr[i];
            int i2 = 31 - i;
            bArr[i] = bArr[i2];
            bArr[i2] = b2;
        }
        return bArr;
    }
}
