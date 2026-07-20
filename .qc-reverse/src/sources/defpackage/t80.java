package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class t80 {
    public final gt0 b;
    public final ArrayList a = new ArrayList();
    public v70[] e = new v70[8];
    public int f = 7;
    public int g = 0;
    public int h = 0;
    public final int c = 4096;
    public int d = 4096;

    public t80(v90 v90Var) {
        Logger logger = tn0.a;
        this.b = new gt0(v90Var);
    }

    public final int a(int i) {
        int i2;
        int i3 = 0;
        if (i > 0) {
            int length = this.e.length;
            while (true) {
                length--;
                i2 = this.f;
                if (length < i2 || i <= 0) {
                    break;
                }
                int i4 = this.e[length].c;
                i -= i4;
                this.h -= i4;
                this.g--;
                i3++;
            }
            v70[] v70VarArr = this.e;
            System.arraycopy(v70VarArr, i2 + 1, v70VarArr, i2 + 1 + i3, this.g);
            this.f += i3;
        }
        return i3;
    }

    public final ai b(int i) throws IOException {
        if (i >= 0) {
            v70[] v70VarArr = v80.a;
            if (i <= v70VarArr.length - 1) {
                return v70VarArr[i].a;
            }
        }
        int length = this.f + 1 + (i - v80.a.length);
        if (length >= 0) {
            v70[] v70VarArr2 = this.e;
            if (length < v70VarArr2.length) {
                return v70VarArr2[length].a;
            }
        }
        throw new IOException("Header index too large " + (i + 1));
    }

    public final void c(v70 v70Var) {
        this.a.add(v70Var);
        int i = v70Var.c;
        int i2 = this.d;
        if (i > i2) {
            Arrays.fill(this.e, (Object) null);
            this.f = this.e.length - 1;
            this.g = 0;
            this.h = 0;
            return;
        }
        a((this.h + i) - i2);
        int i3 = this.g + 1;
        v70[] v70VarArr = this.e;
        if (i3 > v70VarArr.length) {
            v70[] v70VarArr2 = new v70[v70VarArr.length * 2];
            System.arraycopy(v70VarArr, 0, v70VarArr2, v70VarArr.length, v70VarArr.length);
            this.f = this.e.length - 1;
            this.e = v70VarArr2;
        }
        int i4 = this.f;
        this.f = i4 - 1;
        this.e[i4] = v70Var;
        this.g++;
        this.h += i;
    }

    public final ai d() {
        gt0 gt0Var = this.b;
        byte b = gt0Var.readByte();
        int i = b & 255;
        boolean z = (b & 128) == 128;
        int iE = e(i, 127);
        if (!z) {
            return gt0Var.e(iE);
        }
        ha0 ha0Var = ha0.d;
        long j = iE;
        gt0Var.n(j);
        byte[] bArrQ = gt0Var.b.q(j);
        ha0Var.getClass();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        mn mnVar = ha0Var.a;
        mn mnVar2 = mnVar;
        int i2 = 0;
        int i3 = 0;
        for (byte b2 : bArrQ) {
            i2 = (i2 << 8) | (b2 & 255);
            i3 += 8;
            while (i3 >= 8) {
                mnVar2 = ((mn[]) mnVar2.c)[(i2 >>> (i3 - 8)) & 255];
                if (((mn[]) mnVar2.c) == null) {
                    byteArrayOutputStream.write(mnVar2.a);
                    i3 -= mnVar2.b;
                    mnVar2 = mnVar;
                } else {
                    i3 -= 8;
                }
            }
        }
        while (i3 > 0) {
            mn mnVar3 = ((mn[]) mnVar2.c)[(i2 << (8 - i3)) & 255];
            mn[] mnVarArr = (mn[]) mnVar3.c;
            int i4 = mnVar3.b;
            if (mnVarArr != null || i4 > i3) {
                break;
            }
            byteArrayOutputStream.write(mnVar3.a);
            i3 -= i4;
            mnVar2 = mnVar;
        }
        return ai.f(byteArrayOutputStream.toByteArray());
    }

    public final int e(int i, int i2) {
        int i3 = i & i2;
        if (i3 < i2) {
            return i3;
        }
        int i4 = 0;
        while (true) {
            byte b = this.b.readByte();
            int i5 = b & 255;
            if ((b & 128) == 0) {
                return i2 + (i5 << i4);
            }
            i2 += (b & 127) << i4;
            i4 += 7;
        }
    }
}
