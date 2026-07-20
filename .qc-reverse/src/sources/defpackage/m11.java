package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class m11 implements Comparable {
    public boolean b;
    public float f;
    public int m;
    public int c = -1;
    public int d = -1;
    public int e = 0;
    public boolean g = false;
    public final float[] h = new float[9];
    public final float[] i = new float[9];
    public lb[] j = new lb[16];
    public int k = 0;
    public int l = 0;

    public m11(int i) {
        this.m = i;
    }

    public final void a(lb lbVar) {
        int i = 0;
        while (true) {
            int i2 = this.k;
            lb[] lbVarArr = this.j;
            if (i >= i2) {
                if (i2 >= lbVarArr.length) {
                    this.j = (lb[]) Arrays.copyOf(lbVarArr, lbVarArr.length * 2);
                }
                lb[] lbVarArr2 = this.j;
                int i3 = this.k;
                lbVarArr2[i3] = lbVar;
                this.k = i3 + 1;
                return;
            }
            if (lbVarArr[i] == lbVar) {
                return;
            } else {
                i++;
            }
        }
    }

    public final void b(lb lbVar) {
        int i = this.k;
        int i2 = 0;
        while (i2 < i) {
            if (this.j[i2] == lbVar) {
                while (i2 < i - 1) {
                    lb[] lbVarArr = this.j;
                    int i3 = i2 + 1;
                    lbVarArr[i2] = lbVarArr[i3];
                    i2 = i3;
                }
                this.k--;
                return;
            }
            i2++;
        }
    }

    public final void c() {
        this.m = 5;
        this.e = 0;
        this.c = -1;
        this.d = -1;
        this.f = 0.0f;
        this.g = false;
        int i = this.k;
        for (int i2 = 0; i2 < i; i2++) {
            this.j[i2] = null;
        }
        this.k = 0;
        this.l = 0;
        this.b = false;
        Arrays.fill(this.i, 0.0f);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.c - ((m11) obj).c;
    }

    public final void d(rg0 rg0Var, float f) {
        this.f = f;
        this.g = true;
        int i = this.k;
        this.d = -1;
        for (int i2 = 0; i2 < i; i2++) {
            this.j[i2].h(rg0Var, this, false);
        }
        this.k = 0;
    }

    public final void e(rg0 rg0Var, lb lbVar) {
        int i = this.k;
        for (int i2 = 0; i2 < i; i2++) {
            this.j[i2].i(rg0Var, lbVar, false);
        }
        this.k = 0;
    }

    public final String toString() {
        return "" + this.c;
    }
}
