package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class wm1 extends lm1 {
    public final transient ym1 d;
    public final transient xm1 e;

    public wm1(ym1 ym1Var, xm1 xm1Var) {
        this.d = ym1Var;
        this.e = xm1Var;
    }

    @Override // defpackage.yl1
    public final int b(Object[] objArr) {
        return this.e.b(objArr);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.d.get(obj) != null;
    }

    @Override // defpackage.lm1, defpackage.yl1
    public final em1 e() {
        return this.e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return this.e.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.d.g;
    }
}
