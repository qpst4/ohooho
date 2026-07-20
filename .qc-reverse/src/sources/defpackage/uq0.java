package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class uq0 extends lb {
    public m11[] f;
    public m11[] g;
    public int h;
    public pn0 i;

    @Override // defpackage.lb
    public final m11 d(boolean[] zArr) {
        int i = -1;
        for (int i2 = 0; i2 < this.h; i2++) {
            m11[] m11VarArr = this.f;
            m11 m11Var = m11VarArr[i2];
            if (!zArr[m11Var.c]) {
                pn0 pn0Var = this.i;
                pn0Var.c = m11Var;
                int i3 = 8;
                if (i == -1) {
                    while (i3 >= 0) {
                        float f = ((m11) pn0Var.c).i[i3];
                        if (f <= 0.0f) {
                            if (f < 0.0f) {
                                i = i2;
                                break;
                            }
                            i3--;
                        }
                    }
                } else {
                    m11 m11Var2 = m11VarArr[i];
                    while (true) {
                        if (i3 >= 0) {
                            float f2 = m11Var2.i[i3];
                            float f3 = ((m11) pn0Var.c).i[i3];
                            if (f3 == f2) {
                                i3--;
                            } else if (f3 < f2) {
                            }
                        }
                    }
                }
            }
        }
        if (i == -1) {
            return null;
        }
        return this.f[i];
    }

    @Override // defpackage.lb
    public final boolean e() {
        return this.h == 0;
    }

    @Override // defpackage.lb
    public final void i(rg0 rg0Var, lb lbVar, boolean z) {
        m11 m11Var = lbVar.a;
        if (m11Var == null) {
            return;
        }
        float[] fArr = m11Var.i;
        fb fbVar = lbVar.d;
        int iD = fbVar.d();
        for (int i = 0; i < iD; i++) {
            m11 m11VarE = fbVar.e(i);
            float f = fbVar.f(i);
            pn0 pn0Var = this.i;
            pn0Var.c = m11VarE;
            if (m11VarE.b) {
                boolean z2 = true;
                for (int i2 = 0; i2 < 9; i2++) {
                    float[] fArr2 = ((m11) pn0Var.c).i;
                    float f2 = (fArr[i2] * f) + fArr2[i2];
                    fArr2[i2] = f2;
                    if (Math.abs(f2) < 1.0E-4f) {
                        ((m11) pn0Var.c).i[i2] = 0.0f;
                    } else {
                        z2 = false;
                    }
                }
                if (z2) {
                    ((uq0) pn0Var.d).k((m11) pn0Var.c);
                }
            } else {
                for (int i3 = 0; i3 < 9; i3++) {
                    float f3 = fArr[i3];
                    if (f3 != 0.0f) {
                        float f4 = f3 * f;
                        if (Math.abs(f4) < 1.0E-4f) {
                            f4 = 0.0f;
                        }
                        ((m11) pn0Var.c).i[i3] = f4;
                    } else {
                        ((m11) pn0Var.c).i[i3] = 0.0f;
                    }
                }
                j(m11VarE);
            }
            this.b = (lbVar.b * f) + this.b;
        }
        k(m11Var);
    }

    public final void j(m11 m11Var) {
        int i;
        m11[] m11VarArr;
        int i2 = this.h + 1;
        m11[] m11VarArr2 = this.f;
        if (i2 > m11VarArr2.length) {
            m11[] m11VarArr3 = (m11[]) Arrays.copyOf(m11VarArr2, m11VarArr2.length * 2);
            this.f = m11VarArr3;
            this.g = (m11[]) Arrays.copyOf(m11VarArr3, m11VarArr3.length * 2);
        }
        m11[] m11VarArr4 = this.f;
        int i3 = this.h;
        m11VarArr4[i3] = m11Var;
        int i4 = i3 + 1;
        this.h = i4;
        if (i4 > 1 && m11VarArr4[i3].c > m11Var.c) {
            int i5 = 0;
            while (true) {
                i = this.h;
                m11VarArr = this.g;
                if (i5 >= i) {
                    break;
                }
                m11VarArr[i5] = this.f[i5];
                i5++;
            }
            Arrays.sort(m11VarArr, 0, i, new ik(4));
            for (int i6 = 0; i6 < this.h; i6++) {
                this.f[i6] = this.g[i6];
            }
        }
        m11Var.b = true;
        m11Var.a(this);
    }

    public final void k(m11 m11Var) {
        int i = 0;
        while (i < this.h) {
            if (this.f[i] == m11Var) {
                while (true) {
                    int i2 = this.h;
                    if (i >= i2 - 1) {
                        this.h = i2 - 1;
                        m11Var.b = false;
                        return;
                    } else {
                        m11[] m11VarArr = this.f;
                        int i3 = i + 1;
                        m11VarArr[i] = m11VarArr[i3];
                        i = i3;
                    }
                }
            } else {
                i++;
            }
        }
    }

    @Override // defpackage.lb
    public final String toString() {
        pn0 pn0Var = this.i;
        String str = " goal -> (" + this.b + ") : ";
        for (int i = 0; i < this.h; i++) {
            pn0Var.c = this.f[i];
            str = str + pn0Var + " ";
        }
        return str;
    }
}
