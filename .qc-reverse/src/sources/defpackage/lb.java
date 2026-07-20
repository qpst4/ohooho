package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class lb {
    public final fb d;
    public m11 a = null;
    public float b = 0.0f;
    public final ArrayList c = new ArrayList();
    public boolean e = false;

    public lb(ra raVar) {
        this.d = new fb(this, raVar);
    }

    public final void a(rg0 rg0Var, int i) {
        m11 m11VarJ = rg0Var.j(i);
        fb fbVar = this.d;
        fbVar.g(m11VarJ, 1.0f);
        fbVar.g(rg0Var.j(i), -1.0f);
    }

    public final void b(m11 m11Var, m11 m11Var2, m11 m11Var3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.b = i;
        }
        fb fbVar = this.d;
        if (z) {
            fbVar.g(m11Var, 1.0f);
            fbVar.g(m11Var2, -1.0f);
            fbVar.g(m11Var3, -1.0f);
        } else {
            fbVar.g(m11Var, -1.0f);
            fbVar.g(m11Var2, 1.0f);
            fbVar.g(m11Var3, 1.0f);
        }
    }

    public final void c(m11 m11Var, m11 m11Var2, m11 m11Var3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.b = i;
        }
        fb fbVar = this.d;
        if (z) {
            fbVar.g(m11Var, 1.0f);
            fbVar.g(m11Var2, -1.0f);
            fbVar.g(m11Var3, 1.0f);
        } else {
            fbVar.g(m11Var, -1.0f);
            fbVar.g(m11Var2, 1.0f);
            fbVar.g(m11Var3, -1.0f);
        }
    }

    public m11 d(boolean[] zArr) {
        return f(zArr, null);
    }

    public boolean e() {
        return this.a == null && this.b == 0.0f && this.d.d() == 0;
    }

    public final m11 f(boolean[] zArr, m11 m11Var) {
        int i;
        fb fbVar = this.d;
        int iD = fbVar.d();
        m11 m11Var2 = null;
        float f = 0.0f;
        for (int i2 = 0; i2 < iD; i2++) {
            float f2 = fbVar.f(i2);
            if (f2 < 0.0f) {
                m11 m11VarE = fbVar.e(i2);
                if ((zArr == null || !zArr[m11VarE.c]) && m11VarE != m11Var && (((i = m11VarE.m) == 3 || i == 4) && f2 < f)) {
                    f = f2;
                    m11Var2 = m11VarE;
                }
            }
        }
        return m11Var2;
    }

    public final void g(m11 m11Var) {
        m11 m11Var2 = this.a;
        fb fbVar = this.d;
        if (m11Var2 != null) {
            fbVar.g(m11Var2, -1.0f);
            this.a.d = -1;
            this.a = null;
        }
        float fH = fbVar.h(m11Var, true) * (-1.0f);
        this.a = m11Var;
        if (fH == 1.0f) {
            return;
        }
        this.b /= fH;
        int i = fbVar.h;
        for (int i2 = 0; i != -1 && i2 < fbVar.a; i2++) {
            float[] fArr = fbVar.g;
            fArr[i] = fArr[i] / fH;
            i = fbVar.f[i];
        }
    }

    public final void h(rg0 rg0Var, m11 m11Var, boolean z) {
        if (m11Var.g) {
            fb fbVar = this.d;
            float fC = fbVar.c(m11Var);
            this.b = (m11Var.f * fC) + this.b;
            fbVar.h(m11Var, z);
            if (z) {
                m11Var.b(this);
            }
            if (fbVar.d() == 0) {
                this.e = true;
                rg0Var.b = true;
            }
        }
    }

    public void i(rg0 rg0Var, lb lbVar, boolean z) {
        fb fbVar = this.d;
        fbVar.getClass();
        float fC = fbVar.c(lbVar.a);
        fbVar.h(lbVar.a, z);
        fb fbVar2 = lbVar.d;
        int iD = fbVar2.d();
        for (int i = 0; i < iD; i++) {
            m11 m11VarE = fbVar2.e(i);
            fbVar.a(m11VarE, fbVar2.c(m11VarE) * fC, z);
        }
        this.b = (lbVar.b * fC) + this.b;
        if (z) {
            lbVar.a.b(this);
        }
        if (this.a == null || fbVar.d() != 0) {
            return;
        }
        this.e = true;
        rg0Var.b = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            r10 = this;
            m11 r0 = r10.a
            if (r0 != 0) goto L7
            java.lang.String r0 = "0"
            goto L17
        L7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = ""
            r0.<init>(r1)
            m11 r1 = r10.a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L17:
            java.lang.String r1 = " = "
            java.lang.String r0 = r0.concat(r1)
            float r1 = r10.b
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L35
            java.lang.StringBuilder r0 = defpackage.l11.l(r0)
            float r1 = r10.b
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = r4
            goto L36
        L35:
            r1 = r3
        L36:
            fb r10 = r10.d
            int r5 = r10.d()
        L3c:
            if (r3 >= r5) goto L98
            m11 r6 = r10.e(r3)
            if (r6 != 0) goto L45
            goto L95
        L45:
            float r7 = r10.f(r3)
            int r8 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r8 != 0) goto L4e
            goto L95
        L4e:
            java.lang.String r6 = r6.toString()
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L62
            int r1 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r1 >= 0) goto L72
            java.lang.String r1 = "- "
            java.lang.String r0 = r0.concat(r1)
        L60:
            float r7 = r7 * r9
            goto L72
        L62:
            if (r8 <= 0) goto L6b
            java.lang.String r1 = " + "
            java.lang.String r0 = r0.concat(r1)
            goto L72
        L6b:
            java.lang.String r1 = " - "
            java.lang.String r0 = r0.concat(r1)
            goto L60
        L72:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto L7d
            java.lang.String r0 = r0.concat(r6)
            goto L94
        L7d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
        L94:
            r1 = r4
        L95:
            int r3 = r3 + 1
            goto L3c
        L98:
            if (r1 != 0) goto La1
            java.lang.String r10 = "0.0"
            java.lang.String r10 = r0.concat(r10)
            return r10
        La1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lb.toString():java.lang.String");
    }
}
