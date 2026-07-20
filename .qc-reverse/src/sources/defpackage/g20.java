package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class g20 {
    public int a;
    public gn d;
    public gn e;
    public gn f;
    public gn g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int q;
    public final /* synthetic */ h20 r;
    public vn b = null;
    public int c = 0;
    public int l = 0;
    public int m = 0;
    public int n = 0;
    public int o = 0;
    public int p = 0;

    public g20(h20 h20Var, int i, gn gnVar, gn gnVar2, gn gnVar3, gn gnVar4, int i2) {
        this.r = h20Var;
        this.a = i;
        this.d = gnVar;
        this.e = gnVar2;
        this.f = gnVar3;
        this.g = gnVar4;
        this.h = h20Var.w0;
        this.i = h20Var.s0;
        this.j = h20Var.x0;
        this.k = h20Var.t0;
        this.q = i2;
    }

    public final void a(vn vnVar) {
        int i = this.a;
        int i2 = this.q;
        h20 h20Var = this.r;
        if (i == 0) {
            int iU = h20Var.U(vnVar, i2);
            if (vnVar.p0[0] == 3) {
                this.p++;
                iU = 0;
            }
            this.l = iU + (vnVar.g0 != 8 ? h20Var.P0 : 0) + this.l;
            int iT = h20Var.T(vnVar, this.q);
            if (this.b == null || this.c < iT) {
                this.b = vnVar;
                this.c = iT;
                this.m = iT;
            }
        } else {
            int iU2 = h20Var.U(vnVar, i2);
            int iT2 = h20Var.T(vnVar, this.q);
            if (vnVar.p0[1] == 3) {
                this.p++;
                iT2 = 0;
            }
            this.m = iT2 + (vnVar.g0 != 8 ? h20Var.Q0 : 0) + this.m;
            if (this.b == null || this.c < iU2) {
                this.b = vnVar;
                this.c = iU2;
                this.l = iU2;
            }
        }
        this.o++;
    }

    /* JADX WARN: Removed duplicated region for block: B:89:0x0105 A[PHI: r5 r9
  0x0105: PHI (r5v25 int) = (r5v23 int), (r5v26 int) binds: [B:95:0x0115, B:88:0x0103] A[DONT_GENERATE, DONT_INLINE]
  0x0105: PHI (r9v24 float) = (r9v22 float), (r9v27 float) binds: [B:95:0x0115, B:88:0x0103] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(int r23, boolean r24, boolean r25) {
        /*
            Method dump skipped, instruction units count: 724
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.g20.b(int, boolean, boolean):void");
    }

    public final int c() {
        int i = this.a;
        int i2 = this.m;
        return i == 1 ? i2 - this.r.Q0 : i2;
    }

    public final int d() {
        int i = this.a;
        int i2 = this.l;
        return i == 0 ? i2 - this.r.P0 : i2;
    }

    public final void e(int i) {
        h20 h20Var;
        int i2;
        int i3 = this.p;
        if (i3 == 0) {
            return;
        }
        int i4 = this.o;
        int i5 = i / i3;
        int i6 = 0;
        while (true) {
            h20Var = this.r;
            if (i6 >= i4 || (i2 = this.n + i6) >= h20Var.b1) {
                break;
            }
            vn vnVar = h20Var.a1[i2];
            if (this.a == 0) {
                if (vnVar != null) {
                    int[] iArr = vnVar.p0;
                    if (iArr[0] == 3 && vnVar.r == 0) {
                        h20Var.V(1, i5, iArr[1], vnVar.k(), vnVar);
                    }
                }
            } else if (vnVar != null) {
                int[] iArr2 = vnVar.p0;
                if (iArr2[1] == 3 && vnVar.s == 0) {
                    int i7 = i5;
                    h20Var.V(iArr2[0], vnVar.q(), 1, i7, vnVar);
                    i5 = i7;
                }
            }
            i6++;
        }
        this.l = 0;
        this.m = 0;
        this.b = null;
        this.c = 0;
        int i8 = this.o;
        for (int i9 = 0; i9 < i8; i9++) {
            int i10 = this.n + i9;
            if (i10 >= h20Var.b1) {
                return;
            }
            vn vnVar2 = h20Var.a1[i10];
            if (this.a == 0) {
                int iQ = vnVar2.q();
                int i11 = h20Var.P0;
                if (vnVar2.g0 == 8) {
                    i11 = 0;
                }
                this.l = iQ + i11 + this.l;
                int iT = h20Var.T(vnVar2, this.q);
                if (this.b == null || this.c < iT) {
                    this.b = vnVar2;
                    this.c = iT;
                    this.m = iT;
                }
            } else {
                int iU = h20Var.U(vnVar2, this.q);
                int iT2 = h20Var.T(vnVar2, this.q);
                int i12 = h20Var.Q0;
                if (vnVar2.g0 == 8) {
                    i12 = 0;
                }
                this.m = iT2 + i12 + this.m;
                if (this.b == null || this.c < iU) {
                    this.b = vnVar2;
                    this.c = iU;
                    this.l = iU;
                }
            }
        }
    }

    public final void f(int i, gn gnVar, gn gnVar2, gn gnVar3, gn gnVar4, int i2, int i3, int i4, int i5, int i6) {
        this.a = i;
        this.d = gnVar;
        this.e = gnVar2;
        this.f = gnVar3;
        this.g = gnVar4;
        this.h = i2;
        this.i = i3;
        this.j = i4;
        this.k = i5;
        this.q = i6;
    }
}
