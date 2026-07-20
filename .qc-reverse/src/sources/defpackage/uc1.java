package defpackage;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class uc1 {
    public static final ThreadLocal d = new ThreadLocal();
    public final int a;
    public final g7 b;
    public volatile int c = 0;

    public uc1(g7 g7Var, int i) {
        this.b = g7Var;
        this.a = i;
    }

    public final int a(int i) {
        ul0 ul0VarB = b();
        int iA = ul0VarB.a(16);
        if (iA == 0) {
            return 0;
        }
        ByteBuffer byteBuffer = (ByteBuffer) ul0VarB.d;
        int i2 = iA + ul0VarB.a;
        return byteBuffer.getInt((i * 4) + byteBuffer.getInt(i2) + i2 + 4);
    }

    public final ul0 b() {
        ThreadLocal threadLocal = d;
        ul0 ul0Var = (ul0) threadLocal.get();
        if (ul0Var == null) {
            ul0Var = new ul0();
            threadLocal.set(ul0Var);
        }
        vl0 vl0Var = (vl0) this.b.c;
        int iA = vl0Var.a(6);
        if (iA != 0) {
            int i = iA + vl0Var.a;
            int i2 = (this.a * 4) + ((ByteBuffer) vl0Var.d).getInt(i) + i + 4;
            int i3 = ((ByteBuffer) vl0Var.d).getInt(i2) + i2;
            ByteBuffer byteBuffer = (ByteBuffer) vl0Var.d;
            ul0Var.d = byteBuffer;
            if (byteBuffer != null) {
                ul0Var.a = i3;
                int i4 = i3 - byteBuffer.getInt(i3);
                ul0Var.b = i4;
                ul0Var.c = ((ByteBuffer) ul0Var.d).getShort(i4);
                return ul0Var;
            }
            ul0Var.a = 0;
            ul0Var.b = 0;
            ul0Var.c = 0;
        }
        return ul0Var;
    }

    public final String toString() {
        int i;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        ul0 ul0VarB = b();
        int iA = ul0VarB.a(4);
        sb.append(Integer.toHexString(iA != 0 ? ((ByteBuffer) ul0VarB.d).getInt(iA + ul0VarB.a) : 0));
        sb.append(", codepoints:");
        ul0 ul0VarB2 = b();
        int iA2 = ul0VarB2.a(16);
        if (iA2 != 0) {
            int i2 = iA2 + ul0VarB2.a;
            i = ((ByteBuffer) ul0VarB2.d).getInt(((ByteBuffer) ul0VarB2.d).getInt(i2) + i2);
        } else {
            i = 0;
        }
        for (int i3 = 0; i3 < i; i3++) {
            sb.append(Integer.toHexString(a(i3)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
