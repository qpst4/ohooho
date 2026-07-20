package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class o70 extends oh1 {
    @Override // defpackage.et
    public final void a(et etVar) {
        gt gtVar = this.h;
        if (gtVar.c && !gtVar.j) {
            gtVar.d((int) ((((gt) gtVar.l.get(0)).g * ((n70) this.b).q0) + 0.5f));
        }
    }

    @Override // defpackage.oh1
    public final void d() {
        vn vnVar = this.b;
        n70 n70Var = (n70) vnVar;
        int i = n70Var.r0;
        int i2 = n70Var.s0;
        int i3 = n70Var.u0;
        gt gtVar = this.h;
        if (i3 == 1) {
            if (i != -1) {
                gtVar.l.add(vnVar.T.d.h);
                this.b.T.d.h.k.add(gtVar);
                gtVar.f = i;
            } else if (i2 != -1) {
                gtVar.l.add(vnVar.T.d.i);
                this.b.T.d.i.k.add(gtVar);
                gtVar.f = -i2;
            } else {
                gtVar.b = true;
                gtVar.l.add(vnVar.T.d.i);
                this.b.T.d.i.k.add(gtVar);
            }
            m(this.b.d.h);
            m(this.b.d.i);
            return;
        }
        if (i != -1) {
            gtVar.l.add(vnVar.T.e.h);
            this.b.T.e.h.k.add(gtVar);
            gtVar.f = i;
        } else if (i2 != -1) {
            gtVar.l.add(vnVar.T.e.i);
            this.b.T.e.i.k.add(gtVar);
            gtVar.f = -i2;
        } else {
            gtVar.b = true;
            gtVar.l.add(vnVar.T.e.i);
            this.b.T.e.i.k.add(gtVar);
        }
        m(this.b.e.h);
        m(this.b.e.i);
    }

    @Override // defpackage.oh1
    public final void e() {
        vn vnVar = this.b;
        int i = ((n70) vnVar).u0;
        gt gtVar = this.h;
        if (i == 1) {
            vnVar.Y = gtVar.g;
        } else {
            vnVar.Z = gtVar.g;
        }
    }

    @Override // defpackage.oh1
    public final void f() {
        this.h.c();
    }

    @Override // defpackage.oh1
    public final boolean k() {
        return false;
    }

    public final void m(gt gtVar) {
        gt gtVar2 = this.h;
        gtVar2.k.add(gtVar);
        gtVar.l.add(gtVar2);
    }
}
