package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class sv extends w50 {
    public static final sv h;
    public static volatile q50 i;
    public int d;
    public ov e;
    public zh f;
    public zh g;

    static {
        sv svVar = new sv();
        h = svVar;
        svVar.g();
    }

    public sv() {
        zh zhVar = zh.d;
        this.f = zhVar;
        this.g = zhVar;
    }

    @Override // defpackage.w50
    public final Object b(Object obj, int i2, Object obj2) {
        switch (l11.r(i2)) {
            case 0:
                return h;
            case 1:
                v50 v50Var = (v50) obj;
                sv svVar = (sv) obj2;
                int i3 = this.d;
                boolean z = i3 != 0;
                int i4 = svVar.d;
                this.d = v50Var.f(i3, i4, z, i4 != 0);
                this.e = (ov) v50Var.e(this.e, svVar.e);
                zh zhVar = this.f;
                zh zhVar2 = zh.d;
                boolean z2 = zhVar != zhVar2;
                zh zhVar3 = svVar.f;
                this.f = v50Var.a(z2, zhVar, zhVar3 != zhVar2, zhVar3);
                zh zhVar4 = this.g;
                boolean z3 = zhVar4 != zhVar2;
                zh zhVar5 = svVar.g;
                this.g = v50Var.a(z3, zhVar4, zhVar5 != zhVar2, zhVar5);
                return this;
            case 2:
                cl clVar = (cl) obj;
                w00 w00Var = (w00) obj2;
                while (!z) {
                    try {
                        int i5 = clVar.i();
                        if (i5 != 0) {
                            if (i5 == 8) {
                                this.d = clVar.f();
                            } else if (i5 == 18) {
                                ov ovVar = this.e;
                                nv nvVar = ovVar != null ? (nv) ovVar.k() : null;
                                ov ovVar2 = (ov) clVar.d(ov.g.c(), w00Var);
                                this.e = ovVar2;
                                if (nvVar != null) {
                                    nvVar.d(ovVar2);
                                    this.e = (ov) nvVar.b();
                                }
                            } else if (i5 == 26) {
                                this.f = clVar.c();
                            } else if (i5 == 34) {
                                this.g = clVar.c();
                            } else if (!clVar.k(i5)) {
                            }
                        }
                        z = true;
                    } catch (ic0 e) {
                        zy.m(e);
                        return null;
                    } catch (IOException e2) {
                        zy.m(new ic0(e2.getMessage()));
                        return null;
                    }
                }
                break;
            case 3:
                return null;
            case 4:
                return new sv();
            case 5:
                return new rv(h);
            case 6:
                break;
            case 7:
                if (i == null) {
                    synchronized (sv.class) {
                        try {
                            if (i == null) {
                                i = new q50(h);
                            }
                        } finally {
                        }
                        break;
                    }
                }
                return i;
            default:
                zy.a();
                return null;
        }
        return h;
    }

    @Override // defpackage.w50
    public final int d() {
        int i2 = this.c;
        if (i2 != -1) {
            return i2;
        }
        int i3 = this.d;
        int iF = i3 != 0 ? dl.f(1, i3) : 0;
        if (this.e != null) {
            iF += dl.c(2, p());
        }
        if (!this.f.isEmpty()) {
            iF += dl.a(3, this.f);
        }
        if (!this.g.isEmpty()) {
            iF += dl.a(4, this.g);
        }
        this.c = iF;
        return iF;
    }

    @Override // defpackage.w50
    public final void o(dl dlVar) throws el {
        int i2 = this.d;
        if (i2 != 0) {
            dlVar.n(1, i2);
        }
        if (this.e != null) {
            dlVar.k(2, p());
        }
        if (!this.f.isEmpty()) {
            dlVar.h(3, this.f);
        }
        if (this.g.isEmpty()) {
            return;
        }
        dlVar.h(4, this.g);
    }

    public final ov p() {
        ov ovVar = this.e;
        return ovVar == null ? ov.g : ovVar;
    }
}
