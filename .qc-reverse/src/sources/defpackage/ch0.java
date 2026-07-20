package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ch0 extends k {
    public final ah0 a;
    public boolean b;
    public int c;

    public ch0(ah0 ah0Var) {
        this.a = ah0Var;
    }

    @Override // defpackage.k
    public final boolean b(kg kgVar) {
        if (!(kgVar instanceof dh0)) {
            return false;
        }
        if (this.b && this.c == 1) {
            this.a.f = false;
            this.b = false;
        }
        return true;
    }

    @Override // defpackage.k
    public final kg d() {
        return this.a;
    }

    @Override // defpackage.k
    public final boolean e() {
        return true;
    }

    @Override // defpackage.k
    public final lg g(ou ouVar) {
        if (ouVar.h) {
            this.b = true;
            this.c = 0;
        } else if (this.b) {
            this.c++;
        }
        return lg.a(ouVar.b);
    }
}
