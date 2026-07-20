package defpackage;

import java.io.EOFException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class u80 {
    public final mh a;
    public boolean c;
    public int b = Integer.MAX_VALUE;
    public v70[] e = new v70[8];
    public int f = 7;
    public int g = 0;
    public int h = 0;
    public int d = 4096;

    public u80(mh mhVar) {
        this.a = mhVar;
    }

    public final void a(int i) {
        int i2;
        if (i > 0) {
            int length = this.e.length - 1;
            int i3 = 0;
            while (true) {
                i2 = this.f;
                if (length < i2 || i <= 0) {
                    break;
                }
                int i4 = this.e[length].c;
                i -= i4;
                this.h -= i4;
                this.g--;
                i3++;
                length--;
            }
            v70[] v70VarArr = this.e;
            int i5 = i2 + 1;
            System.arraycopy(v70VarArr, i5, v70VarArr, i5 + i3, this.g);
            v70[] v70VarArr2 = this.e;
            int i6 = this.f + 1;
            Arrays.fill(v70VarArr2, i6, i6 + i3, (Object) null);
            this.f += i3;
        }
    }

    public final void b(v70 v70Var) {
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

    public final void c(ai aiVar) {
        ha0.d.getClass();
        long j = 0;
        long j2 = 0;
        for (int i = 0; i < aiVar.i(); i++) {
            j2 += (long) ha0.c[aiVar.d(i) & 255];
        }
        int i2 = (int) ((j2 + 7) >> 3);
        int i3 = aiVar.i();
        mh mhVar = this.a;
        if (i2 >= i3) {
            d(aiVar.i(), 127, 0);
            aiVar.m(mhVar);
            return;
        }
        mh mhVar2 = new mh();
        ha0.d.getClass();
        int i4 = 0;
        for (int i5 = 0; i5 < aiVar.i(); i5++) {
            int iD = aiVar.d(i5) & 255;
            int i6 = ha0.b[iD];
            byte b = ha0.c[iD];
            j = (j << b) | ((long) i6);
            i4 += b;
            while (i4 >= 8) {
                i4 -= 8;
                mhVar2.w((int) (j >> i4));
            }
        }
        if (i4 > 0) {
            mhVar2.w((int) ((j << (8 - i4)) | ((long) (255 >>> i4))));
        }
        try {
            byte[] bArrQ = mhVar2.q(mhVar2.c);
            ai aiVar2 = new ai(bArrQ);
            d(bArrQ.length, 127, 128);
            aiVar2.m(mhVar);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final void d(int i, int i2, int i3) {
        mh mhVar = this.a;
        if (i < i2) {
            mhVar.w(i | i3);
            return;
        }
        mhVar.w(i3 | i2);
        int i4 = i - i2;
        while (i4 >= 128) {
            mhVar.w(128 | (i4 & 127));
            i4 >>>= 7;
        }
        mhVar.w(i4);
    }
}
