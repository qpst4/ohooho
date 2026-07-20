package defpackage;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class b00 {
    public final int a;
    public final int b;
    public final long c;
    public final byte[] d;

    public b00(long j, byte[] bArr, int i, int i2) {
        this.a = i;
        this.b = i2;
        this.c = j;
        this.d = bArr;
    }

    public static b00 a(String str) {
        byte[] bytes = str.concat("\u0000").getBytes(f00.Z);
        return new b00(bytes, 2, bytes.length);
    }

    public static b00 b(long j, ByteOrder byteOrder) {
        return c(new long[]{j}, byteOrder);
    }

    public static b00 c(long[] jArr, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[f00.Q[4] * jArr.length]);
        byteBufferWrap.order(byteOrder);
        for (long j : jArr) {
            byteBufferWrap.putInt((int) j);
        }
        return new b00(byteBufferWrap.array(), 4, jArr.length);
    }

    public static b00 d(d00[] d00VarArr, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[f00.Q[5] * d00VarArr.length]);
        byteBufferWrap.order(byteOrder);
        for (d00 d00Var : d00VarArr) {
            byteBufferWrap.putInt((int) d00Var.a);
            byteBufferWrap.putInt((int) d00Var.b);
        }
        return new b00(byteBufferWrap.array(), 5, d00VarArr.length);
    }

    public static b00 e(int i, ByteOrder byteOrder) {
        return f(new int[]{i}, byteOrder);
    }

    public static b00 f(int[] iArr, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[f00.Q[3] * iArr.length]);
        byteBufferWrap.order(byteOrder);
        for (int i : iArr) {
            byteBufferWrap.putShort((short) i);
        }
        return new b00(byteBufferWrap.array(), 3, iArr.length);
    }

    public final double g(ByteOrder byteOrder) throws Throwable {
        Object objJ = j(byteOrder);
        if (objJ == null) {
            throw new NumberFormatException("NULL can't be converted to a double value");
        }
        if (objJ instanceof String) {
            return Double.parseDouble((String) objJ);
        }
        if (objJ instanceof long[]) {
            if (((long[]) objJ).length == 1) {
                return r3[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (objJ instanceof int[]) {
            if (((int[]) objJ).length == 1) {
                return r3[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (objJ instanceof double[]) {
            double[] dArr = (double[]) objJ;
            if (dArr.length == 1) {
                return dArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (!(objJ instanceof d00[])) {
            throw new NumberFormatException("Couldn't find a double value");
        }
        d00[] d00VarArr = (d00[]) objJ;
        if (d00VarArr.length != 1) {
            throw new NumberFormatException("There are more than one component");
        }
        d00 d00Var = d00VarArr[0];
        return d00Var.a / d00Var.b;
    }

    public final int h(ByteOrder byteOrder) throws Throwable {
        Object objJ = j(byteOrder);
        if (objJ == null) {
            throw new NumberFormatException("NULL can't be converted to a integer value");
        }
        if (objJ instanceof String) {
            return Integer.parseInt((String) objJ);
        }
        if (objJ instanceof long[]) {
            long[] jArr = (long[]) objJ;
            if (jArr.length == 1) {
                return (int) jArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (!(objJ instanceof int[])) {
            throw new NumberFormatException("Couldn't find a integer value");
        }
        int[] iArr = (int[]) objJ;
        if (iArr.length == 1) {
            return iArr[0];
        }
        throw new NumberFormatException("There are more than one component");
    }

    public final String i(ByteOrder byteOrder) throws Throwable {
        Object objJ = j(byteOrder);
        if (objJ == null) {
            return null;
        }
        if (objJ instanceof String) {
            return (String) objJ;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if (objJ instanceof long[]) {
            long[] jArr = (long[]) objJ;
            while (i < jArr.length) {
                sb.append(jArr[i]);
                i++;
                if (i != jArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (objJ instanceof int[]) {
            int[] iArr = (int[]) objJ;
            while (i < iArr.length) {
                sb.append(iArr[i]);
                i++;
                if (i != iArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (objJ instanceof double[]) {
            double[] dArr = (double[]) objJ;
            while (i < dArr.length) {
                sb.append(dArr[i]);
                i++;
                if (i != dArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (!(objJ instanceof d00[])) {
            return null;
        }
        d00[] d00VarArr = (d00[]) objJ;
        while (i < d00VarArr.length) {
            sb.append(d00VarArr[i].a);
            sb.append('/');
            sb.append(d00VarArr[i].b);
            i++;
            if (i != d00VarArr.length) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0032: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:51), block:B:17:0x0032 */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0134 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r13v14, types: [int[]] */
    /* JADX WARN: Type inference failed for: r13v15, types: [long[]] */
    /* JADX WARN: Type inference failed for: r13v16, types: [d00[]] */
    /* JADX WARN: Type inference failed for: r13v17, types: [int[]] */
    /* JADX WARN: Type inference failed for: r13v18, types: [int[]] */
    /* JADX WARN: Type inference failed for: r13v19, types: [d00[]] */
    /* JADX WARN: Type inference failed for: r13v20, types: [double[]] */
    /* JADX WARN: Type inference failed for: r13v21, types: [java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r13v22, types: [double[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.io.Serializable j(java.nio.ByteOrder r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.b00.j(java.nio.ByteOrder):java.io.Serializable");
    }

    public final String toString() {
        return "(" + f00.P[this.a] + ", data length:" + this.d.length + ")";
    }

    public b00(byte[] bArr, int i, int i2) {
        this(-1L, bArr, i, i2);
    }
}
