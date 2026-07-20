package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class rg0 {
    public static boolean q = false;
    public final uq0 d;
    public final ra m;
    public lb p;
    public int a = 1000;
    public boolean b = false;
    public int c = 0;
    public int e = 32;
    public int f = 32;
    public boolean h = false;
    public boolean[] i = new boolean[32];
    public int j = 1;
    public int k = 0;
    public int l = 32;
    public m11[] n = new m11[1000];
    public int o = 0;
    public lb[] g = new lb[32];

    public rg0() {
        s();
        ra raVar = new ra(3);
        raVar.c = new tp0();
        raVar.d = new tp0();
        raVar.e = new m11[32];
        this.m = raVar;
        uq0 uq0Var = new uq0(raVar);
        uq0Var.f = new m11[128];
        uq0Var.g = new m11[128];
        uq0Var.h = 0;
        uq0Var.i = new pn0(uq0Var);
        this.d = uq0Var;
        this.p = new lb(raVar);
    }

    public static int n(Object obj) {
        m11 m11Var = ((gn) obj).i;
        if (m11Var != null) {
            return (int) (m11Var.f + 0.5f);
        }
        return 0;
    }

    public final m11 a(int i) {
        tp0 tp0Var = (tp0) this.m.d;
        int i2 = tp0Var.b;
        Object obj = null;
        if (i2 > 0) {
            int i3 = i2 - 1;
            Object[] objArr = tp0Var.a;
            Object obj2 = objArr[i3];
            objArr[i3] = null;
            tp0Var.b = i3;
            obj = obj2;
        }
        m11 m11Var = (m11) obj;
        if (m11Var == null) {
            m11Var = new m11(i);
            m11Var.m = i;
        } else {
            m11Var.c();
            m11Var.m = i;
        }
        int i4 = this.o;
        int i5 = this.a;
        if (i4 >= i5) {
            int i6 = i5 * 2;
            this.a = i6;
            this.n = (m11[]) Arrays.copyOf(this.n, i6);
        }
        m11[] m11VarArr = this.n;
        int i7 = this.o;
        this.o = i7 + 1;
        m11VarArr[i7] = m11Var;
        return m11Var;
    }

    public final void b(m11 m11Var, m11 m11Var2, int i, float f, m11 m11Var3, m11 m11Var4, int i2, int i3) {
        lb lbVarL = l();
        if (m11Var2 == m11Var3) {
            lbVarL.d.g(m11Var, 1.0f);
            lbVarL.d.g(m11Var4, 1.0f);
            lbVarL.d.g(m11Var2, -2.0f);
        } else {
            fb fbVar = lbVarL.d;
            if (f == 0.5f) {
                fbVar.g(m11Var, 1.0f);
                lbVarL.d.g(m11Var2, -1.0f);
                lbVarL.d.g(m11Var3, -1.0f);
                lbVarL.d.g(m11Var4, 1.0f);
                if (i > 0 || i2 > 0) {
                    lbVarL.b = (-i) + i2;
                }
            } else if (f <= 0.0f) {
                fbVar.g(m11Var, -1.0f);
                lbVarL.d.g(m11Var2, 1.0f);
                lbVarL.b = i;
            } else if (f >= 1.0f) {
                fbVar.g(m11Var4, -1.0f);
                lbVarL.d.g(m11Var3, 1.0f);
                lbVarL.b = -i2;
            } else {
                float f2 = 1.0f - f;
                fbVar.g(m11Var, f2 * 1.0f);
                lbVarL.d.g(m11Var2, f2 * (-1.0f));
                lbVarL.d.g(m11Var3, (-1.0f) * f);
                lbVarL.d.g(m11Var4, 1.0f * f);
                if (i > 0 || i2 > 0) {
                    lbVarL.b = (i2 * f) + ((-i) * f2);
                }
            }
        }
        if (i3 != 8) {
            lbVarL.a(this, i3);
        }
        c(lbVarL);
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:155:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(defpackage.lb r18) {
        /*
            Method dump skipped, instruction units count: 450
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.rg0.c(lb):void");
    }

    public final void d(m11 m11Var, int i) {
        int i2 = m11Var.d;
        if (i2 == -1) {
            m11Var.d(this, i);
            for (int i3 = 0; i3 < this.c + 1; i3++) {
                m11 m11Var2 = ((m11[]) this.m.e)[i3];
            }
            return;
        }
        if (i2 == -1) {
            lb lbVarL = l();
            lbVarL.a = m11Var;
            float f = i;
            m11Var.f = f;
            lbVarL.b = f;
            lbVarL.e = true;
            c(lbVarL);
            return;
        }
        lb lbVar = this.g[i2];
        if (lbVar.e) {
            lbVar.b = i;
            return;
        }
        if (lbVar.d.d() == 0) {
            lbVar.e = true;
            lbVar.b = i;
            return;
        }
        lb lbVarL2 = l();
        if (i < 0) {
            lbVarL2.b = i * (-1);
            lbVarL2.d.g(m11Var, 1.0f);
        } else {
            lbVarL2.b = i;
            lbVarL2.d.g(m11Var, -1.0f);
        }
        c(lbVarL2);
    }

    public final void e(m11 m11Var, m11 m11Var2, int i, int i2) {
        if (i2 == 8 && m11Var2.g && m11Var.d == -1) {
            m11Var.d(this, m11Var2.f + i);
            return;
        }
        lb lbVarL = l();
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            lbVarL.b = i;
        }
        fb fbVar = lbVarL.d;
        if (z) {
            fbVar.g(m11Var, 1.0f);
            lbVarL.d.g(m11Var2, -1.0f);
        } else {
            fbVar.g(m11Var, -1.0f);
            lbVarL.d.g(m11Var2, 1.0f);
        }
        if (i2 != 8) {
            lbVarL.a(this, i2);
        }
        c(lbVarL);
    }

    public final void f(m11 m11Var, m11 m11Var2, int i, int i2) {
        lb lbVarL = l();
        m11 m11VarM = m();
        m11VarM.e = 0;
        lbVarL.b(m11Var, m11Var2, m11VarM, i);
        if (i2 != 8) {
            lbVarL.d.g(j(i2), (int) (lbVarL.d.c(m11VarM) * (-1.0f)));
        }
        c(lbVarL);
    }

    public final void g(m11 m11Var, m11 m11Var2, int i, int i2) {
        lb lbVarL = l();
        m11 m11VarM = m();
        m11VarM.e = 0;
        lbVarL.c(m11Var, m11Var2, m11VarM, i);
        if (i2 != 8) {
            lbVarL.d.g(j(i2), (int) (lbVarL.d.c(m11VarM) * (-1.0f)));
        }
        c(lbVarL);
    }

    public final void h(lb lbVar) {
        int i;
        if (lbVar.e) {
            lbVar.a.d(this, lbVar.b);
        } else {
            lb[] lbVarArr = this.g;
            int i2 = this.k;
            lbVarArr[i2] = lbVar;
            m11 m11Var = lbVar.a;
            m11Var.d = i2;
            this.k = i2 + 1;
            m11Var.e(this, lbVar);
        }
        if (this.b) {
            int i3 = 0;
            while (i3 < this.k) {
                if (this.g[i3] == null) {
                    System.out.println("WTF");
                }
                lb lbVar2 = this.g[i3];
                if (lbVar2 != null && lbVar2.e) {
                    lbVar2.a.d(this, lbVar2.b);
                    ((tp0) this.m.c).b(lbVar2);
                    this.g[i3] = null;
                    int i4 = i3 + 1;
                    int i5 = i4;
                    while (true) {
                        i = this.k;
                        if (i4 >= i) {
                            break;
                        }
                        lb[] lbVarArr2 = this.g;
                        int i6 = i4 - 1;
                        lb lbVar3 = lbVarArr2[i4];
                        lbVarArr2[i6] = lbVar3;
                        m11 m11Var2 = lbVar3.a;
                        if (m11Var2.d == i4) {
                            m11Var2.d = i6;
                        }
                        i5 = i4;
                        i4++;
                    }
                    if (i5 < i) {
                        this.g[i5] = null;
                    }
                    this.k = i - 1;
                    i3--;
                }
                i3++;
            }
            this.b = false;
        }
    }

    public final void i() {
        for (int i = 0; i < this.k; i++) {
            lb lbVar = this.g[i];
            lbVar.a.f = lbVar.b;
        }
    }

    public final m11 j(int i) {
        if (this.j + 1 >= this.f) {
            o();
        }
        m11 m11VarA = a(4);
        float[] fArr = m11VarA.i;
        int i2 = this.c + 1;
        this.c = i2;
        this.j++;
        m11VarA.c = i2;
        m11VarA.e = i;
        ((m11[]) this.m.e)[i2] = m11VarA;
        uq0 uq0Var = this.d;
        uq0Var.i.c = m11VarA;
        Arrays.fill(fArr, 0.0f);
        fArr[m11VarA.e] = 1.0f;
        uq0Var.j(m11VarA);
        return m11VarA;
    }

    public final m11 k(Object obj) {
        if (obj == null) {
            return null;
        }
        if (this.j + 1 >= this.f) {
            o();
        }
        if (!(obj instanceof gn)) {
            return null;
        }
        gn gnVar = (gn) obj;
        m11 m11Var = gnVar.i;
        if (m11Var == null) {
            gnVar.k();
            m11Var = gnVar.i;
        }
        int i = m11Var.c;
        ra raVar = this.m;
        if (i != -1 && i <= this.c && ((m11[]) raVar.e)[i] != null) {
            return m11Var;
        }
        if (i != -1) {
            m11Var.c();
        }
        int i2 = this.c + 1;
        this.c = i2;
        this.j++;
        m11Var.c = i2;
        m11Var.m = 1;
        ((m11[]) raVar.e)[i2] = m11Var;
        return m11Var;
    }

    public final lb l() {
        Object obj;
        ra raVar = this.m;
        tp0 tp0Var = (tp0) raVar.c;
        int i = tp0Var.b;
        if (i > 0) {
            int i2 = i - 1;
            Object[] objArr = tp0Var.a;
            obj = objArr[i2];
            objArr[i2] = null;
            tp0Var.b = i2;
        } else {
            obj = null;
        }
        lb lbVar = (lb) obj;
        if (lbVar == null) {
            return new lb(raVar);
        }
        lbVar.a = null;
        lbVar.d.b();
        lbVar.b = 0.0f;
        lbVar.e = false;
        return lbVar;
    }

    public final m11 m() {
        if (this.j + 1 >= this.f) {
            o();
        }
        m11 m11VarA = a(3);
        int i = this.c + 1;
        this.c = i;
        this.j++;
        m11VarA.c = i;
        ((m11[]) this.m.e)[i] = m11VarA;
        return m11VarA;
    }

    public final void o() {
        int i = this.e * 2;
        this.e = i;
        this.g = (lb[]) Arrays.copyOf(this.g, i);
        ra raVar = this.m;
        raVar.e = (m11[]) Arrays.copyOf((m11[]) raVar.e, this.e);
        int i2 = this.e;
        this.i = new boolean[i2];
        this.f = i2;
        this.l = i2;
    }

    public final void p() {
        uq0 uq0Var = this.d;
        if (uq0Var.e()) {
            i();
            return;
        }
        if (!this.h) {
            q(uq0Var);
            return;
        }
        for (int i = 0; i < this.k; i++) {
            if (!this.g[i].e) {
                q(uq0Var);
                return;
            }
        }
        i();
    }

    public final void q(uq0 uq0Var) {
        int i = 0;
        while (true) {
            if (i >= this.k) {
                break;
            }
            lb lbVar = this.g[i];
            int i2 = 1;
            if (lbVar.a.m != 1) {
                float f = 0.0f;
                if (lbVar.b < 0.0f) {
                    boolean z = false;
                    int i3 = 0;
                    while (!z) {
                        i3 += i2;
                        float f2 = Float.MAX_VALUE;
                        int i4 = -1;
                        int i5 = -1;
                        int i6 = 0;
                        int i7 = 0;
                        while (i6 < this.k) {
                            lb lbVar2 = this.g[i6];
                            if (lbVar2.a.m != i2 && !lbVar2.e && lbVar2.b < f) {
                                int iD = lbVar2.d.d();
                                int i8 = 0;
                                while (i8 < iD) {
                                    m11 m11VarE = lbVar2.d.e(i8);
                                    float fC = lbVar2.d.c(m11VarE);
                                    if (fC > f) {
                                        for (int i9 = 0; i9 < 9; i9++) {
                                            float f3 = m11VarE.h[i9] / fC;
                                            if ((f3 < f2 && i9 == i7) || i9 > i7) {
                                                i7 = i9;
                                                i5 = m11VarE.c;
                                                i4 = i6;
                                                f2 = f3;
                                            }
                                        }
                                    }
                                    i8++;
                                    f = 0.0f;
                                }
                            }
                            i6++;
                            f = 0.0f;
                            i2 = 1;
                        }
                        if (i4 != -1) {
                            lb lbVar3 = this.g[i4];
                            lbVar3.a.d = -1;
                            lbVar3.g(((m11[]) this.m.e)[i5]);
                            m11 m11Var = lbVar3.a;
                            m11Var.d = i4;
                            m11Var.e(this, lbVar3);
                        } else {
                            z = true;
                        }
                        if (i3 > this.j / 2) {
                            z = true;
                        }
                        f = 0.0f;
                        i2 = 1;
                    }
                }
            }
            i++;
        }
        r(uq0Var);
        i();
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0091 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(defpackage.lb r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = 0
            r3 = r2
        L6:
            int r4 = r0.j
            if (r3 >= r4) goto L11
            boolean[] r4 = r0.i
            r4[r3] = r2
            int r3 = r3 + 1
            goto L6
        L11:
            r3 = r2
            r4 = r3
        L13:
            if (r3 != 0) goto Lae
            r5 = 1
            int r4 = r4 + r5
            int r6 = r0.j
            int r6 = r6 * 2
            if (r4 < r6) goto L1f
            goto Lae
        L1f:
            m11 r6 = r1.a
            if (r6 == 0) goto L29
            boolean[] r7 = r0.i
            int r6 = r6.c
            r7[r6] = r5
        L29:
            boolean[] r6 = r0.i
            m11 r6 = r1.d(r6)
            if (r6 == 0) goto L3d
            boolean[] r7 = r0.i
            int r8 = r6.c
            boolean r9 = r7[r8]
            if (r9 == 0) goto L3b
            goto Lae
        L3b:
            r7[r8] = r5
        L3d:
            if (r6 == 0) goto Laa
            r7 = -1
            r8 = 2139095039(0x7f7fffff, float:3.4028235E38)
            r9 = r2
            r10 = r7
        L45:
            int r11 = r0.k
            if (r9 >= r11) goto L95
            lb[] r11 = r0.g
            r11 = r11[r9]
            m11 r12 = r11.a
            int r12 = r12.m
            if (r12 != r5) goto L54
            goto L91
        L54:
            boolean r12 = r11.e
            if (r12 == 0) goto L59
            goto L91
        L59:
            fb r12 = r11.d
            int r13 = r12.h
            if (r13 != r7) goto L60
            goto L79
        L60:
            r14 = r2
        L61:
            if (r13 == r7) goto L79
            int r15 = r12.a
            if (r14 >= r15) goto L79
            int[] r15 = r12.e
            r15 = r15[r13]
            int r2 = r6.c
            if (r15 != r2) goto L71
            r2 = r5
            goto L7a
        L71:
            int[] r2 = r12.f
            r13 = r2[r13]
            int r14 = r14 + 1
            r2 = 0
            goto L61
        L79:
            r2 = 0
        L7a:
            if (r2 == 0) goto L91
            fb r2 = r11.d
            float r2 = r2.c(r6)
            r12 = 0
            int r12 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r12 >= 0) goto L91
            float r11 = r11.b
            float r11 = -r11
            float r11 = r11 / r2
            int r2 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            if (r2 >= 0) goto L91
            r10 = r9
            r8 = r11
        L91:
            int r9 = r9 + 1
            r2 = 0
            goto L45
        L95:
            if (r10 <= r7) goto Lab
            lb[] r2 = r0.g
            r2 = r2[r10]
            m11 r5 = r2.a
            r5.d = r7
            r2.g(r6)
            m11 r5 = r2.a
            r5.d = r10
            r5.e(r0, r2)
            goto Lab
        Laa:
            r3 = r5
        Lab:
            r2 = 0
            goto L13
        Lae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.rg0.r(lb):void");
    }

    public final void s() {
        for (int i = 0; i < this.k; i++) {
            lb lbVar = this.g[i];
            if (lbVar != null) {
                ((tp0) this.m.c).b(lbVar);
            }
            this.g[i] = null;
        }
    }

    public final void t() {
        ra raVar;
        int i = 0;
        while (true) {
            raVar = this.m;
            m11[] m11VarArr = (m11[]) raVar.e;
            if (i >= m11VarArr.length) {
                break;
            }
            m11 m11Var = m11VarArr[i];
            if (m11Var != null) {
                m11Var.c();
            }
            i++;
        }
        tp0 tp0Var = (tp0) raVar.d;
        m11[] m11VarArr2 = this.n;
        int length = this.o;
        tp0Var.getClass();
        if (length > m11VarArr2.length) {
            length = m11VarArr2.length;
        }
        for (int i2 = 0; i2 < length; i2++) {
            m11 m11Var2 = m11VarArr2[i2];
            int i3 = tp0Var.b;
            Object[] objArr = tp0Var.a;
            if (i3 < objArr.length) {
                objArr[i3] = m11Var2;
                tp0Var.b = i3 + 1;
            }
        }
        this.o = 0;
        Arrays.fill((m11[]) raVar.e, (Object) null);
        this.c = 0;
        uq0 uq0Var = this.d;
        uq0Var.h = 0;
        uq0Var.b = 0.0f;
        this.j = 1;
        for (int i4 = 0; i4 < this.k; i4++) {
            lb lbVar = this.g[i4];
        }
        s();
        this.k = 0;
        this.p = new lb(raVar);
    }
}
