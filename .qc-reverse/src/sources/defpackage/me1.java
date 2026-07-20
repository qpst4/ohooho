package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class me1 extends le1 {
    public lp0[] a;
    public String b;
    public int c;

    public me1(me1 me1Var) {
        this.a = null;
        this.c = 0;
        this.b = me1Var.b;
        lp0[] lp0VarArr = me1Var.a;
        lp0[] lp0VarArr2 = new lp0[lp0VarArr.length];
        for (int i = 0; i < lp0VarArr.length; i++) {
            lp0VarArr2[i] = new lp0(lp0VarArr[i]);
        }
        this.a = lp0VarArr2;
    }

    public lp0[] getPathData() {
        return this.a;
    }

    public String getPathName() {
        return this.b;
    }

    public void setPathData(lp0[] lp0VarArr) {
        lp0[] lp0VarArr2 = this.a;
        if (lp0VarArr2 != null && lp0VarArr != null && lp0VarArr2.length == lp0VarArr.length) {
            for (int i = 0; i < lp0VarArr2.length; i++) {
                lp0 lp0Var = lp0VarArr2[i];
                char c = lp0Var.a;
                lp0 lp0Var2 = lp0VarArr[i];
                if (c == lp0Var2.a && lp0Var.b.length == lp0Var2.b.length) {
                }
            }
            lp0[] lp0VarArr3 = this.a;
            for (int i2 = 0; i2 < lp0VarArr.length; i2++) {
                lp0VarArr3[i2].a = lp0VarArr[i2].a;
                int i3 = 0;
                while (true) {
                    float[] fArr = lp0VarArr[i2].b;
                    if (i3 < fArr.length) {
                        lp0VarArr3[i2].b[i3] = fArr[i3];
                        i3++;
                    }
                }
            }
            return;
        }
        lp0[] lp0VarArr4 = new lp0[lp0VarArr.length];
        for (int i4 = 0; i4 < lp0VarArr.length; i4++) {
            lp0VarArr4[i4] = new lp0(lp0VarArr[i4]);
        }
        this.a = lp0VarArr4;
    }

    public me1() {
        this.a = null;
        this.c = 0;
    }
}
