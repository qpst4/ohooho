package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class yp1 implements dq1 {
    public final ro1 a;
    public final hm1 b;

    public yp1(hm1 hm1Var, ro1 ro1Var) {
        cp1 cp1Var = dp1.a;
        this.b = hm1Var;
        this.a = ro1Var;
    }

    @Override // defpackage.dq1
    public final void a(Object obj) {
        this.b.getClass();
        jq1 jq1Var = ((hp1) obj).zzc;
        if (jq1Var.e) {
            jq1Var.e = false;
        }
        cp1 cp1Var = dp1.a;
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // defpackage.dq1
    public final void b(Object obj, Object obj2) {
        eq1.o(obj, obj2);
    }

    @Override // defpackage.dq1
    public final void c(Object obj, tb0 tb0Var) {
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // defpackage.dq1
    public final hp1 d() {
        ro1 ro1Var = this.a;
        if (ro1Var instanceof hp1) {
            return (hp1) ((hp1) ro1Var).d(4);
        }
        gp1 gp1Var = (gp1) ((hp1) ro1Var).d(5);
        boolean zC = gp1Var.c.c();
        hp1 hp1Var = gp1Var.c;
        if (!zC) {
            return hp1Var;
        }
        hp1Var.j();
        return gp1Var.c;
    }

    @Override // defpackage.dq1
    public final boolean e(hp1 hp1Var, hp1 hp1Var2) {
        return hp1Var.zzc.equals(hp1Var2.zzc);
    }

    @Override // defpackage.dq1
    public final void f(Object obj, byte[] bArr, int i, int i2, uo1 uo1Var) {
        hp1 hp1Var = (hp1) obj;
        if (hp1Var.zzc == jq1.f) {
            hp1Var.zzc = jq1.b();
        }
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // defpackage.dq1
    public final int g(ro1 ro1Var) {
        jq1 jq1Var = ((hp1) ro1Var).zzc;
        int i = jq1Var.d;
        if (i != -1) {
            return i;
        }
        int iF = 0;
        for (int i2 = 0; i2 < jq1Var.a; i2++) {
            int i3 = jq1Var.b[i2] >>> 3;
            yo1 yo1Var = (yo1) jq1Var.c[i2];
            int iQ = zo1.q(8);
            int iQ2 = zo1.q(i3) + zo1.q(16);
            int iQ3 = zo1.q(24);
            int iD = yo1Var.d();
            iF += iQ + iQ + iQ2 + qq0.f(iD, iD, iQ3);
        }
        jq1Var.d = iF;
        return iF;
    }

    @Override // defpackage.dq1
    public final int h(hp1 hp1Var) {
        return hp1Var.zzc.hashCode();
    }

    @Override // defpackage.dq1
    public final boolean i(Object obj) {
        obj.getClass();
        throw new ClassCastException();
    }
}
