package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class eh0 extends k {
    public final dh0 a = new dh0();
    public final int b;
    public boolean c;

    public eh0(int i) {
        this.b = i;
    }

    @Override // defpackage.k
    public final boolean b(kg kgVar) {
        if (!this.c) {
            return true;
        }
        kg kgVar2 = (kg) this.a.a;
        if (!(kgVar2 instanceof ah0)) {
            return true;
        }
        ((ah0) kgVar2).f = false;
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
            if (this.a.b == null) {
                return null;
            }
            kg kgVarD = ouVar.h().d();
            this.c = (kgVarD instanceof dp0) || (kgVarD instanceof dh0);
            return lg.a(ouVar.e);
        }
        int i = ouVar.g;
        int i2 = this.b;
        if (i >= i2) {
            return new lg(-1, ouVar.c + i2, false);
        }
        return null;
    }
}
