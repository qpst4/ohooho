package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class dm1 extends em1 {
    public final transient int d;
    public final transient int e;
    public final /* synthetic */ em1 f;

    public dm1(em1 em1Var, int i, int i2) {
        this.f = em1Var;
        this.d = i;
        this.e = i2;
    }

    @Override // defpackage.yl1
    public final int c() {
        return this.f.d() + this.d + this.e;
    }

    @Override // defpackage.yl1
    public final int d() {
        return this.f.d() + this.d;
    }

    @Override // defpackage.yl1
    public final boolean f() {
        return true;
    }

    @Override // defpackage.yl1
    public final Object[] g() {
        return this.f.g();
    }

    @Override // java.util.List
    public final Object get(int i) {
        f01.V(i, this.e);
        return this.f.get(i + this.d);
    }

    @Override // defpackage.em1, java.util.List
    /* JADX INFO: renamed from: i */
    public final em1 subList(int i, int i2) {
        f01.b0(i, i2, this.e);
        int i3 = this.d;
        return this.f.subList(i + i3, i2 + i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.e;
    }
}
