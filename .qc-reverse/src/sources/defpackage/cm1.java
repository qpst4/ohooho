package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class cm1 extends em1 {
    public final transient em1 d;

    public cm1(em1 em1Var) {
        this.d = em1Var;
    }

    @Override // defpackage.em1, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return this.d.contains(obj);
    }

    @Override // defpackage.yl1
    public final boolean f() {
        return this.d.f();
    }

    @Override // java.util.List
    public final Object get(int i) {
        em1 em1Var = this.d;
        f01.V(i, em1Var.size());
        return em1Var.get((em1Var.size() - 1) - i);
    }

    @Override // defpackage.em1
    public final em1 h() {
        return this.d;
    }

    @Override // defpackage.em1, java.util.List
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public final em1 subList(int i, int i2) {
        em1 em1Var = this.d;
        f01.b0(i, i2, em1Var.size());
        return em1Var.subList(em1Var.size() - i2, em1Var.size() - i).h();
    }

    @Override // defpackage.em1, java.util.List
    public final int indexOf(Object obj) {
        int iLastIndexOf = this.d.lastIndexOf(obj);
        if (iLastIndexOf >= 0) {
            return (r1.size() - 1) - iLastIndexOf;
        }
        return -1;
    }

    @Override // defpackage.em1, java.util.List
    public final int lastIndexOf(Object obj) {
        int iIndexOf = this.d.indexOf(obj);
        if (iIndexOf >= 0) {
            return (r1.size() - 1) - iIndexOf;
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.d.size();
    }
}
