package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class bn1 extends lm1 {
    public final transient Object d;

    public bn1(Object obj) {
        this.d = obj;
    }

    @Override // defpackage.yl1
    public final int b(Object[] objArr) {
        objArr[0] = this.d;
        return 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.d.equals(obj);
    }

    @Override // defpackage.lm1, defpackage.yl1
    public final em1 e() {
        Object[] objArr = {this.d};
        for (int i = 0; i < 1; i++) {
            bm1 bm1Var = em1.c;
            if (objArr[i] == null) {
                zy.r(qq0.i("at index ", i));
                return null;
            }
        }
        return em1.j(1, objArr);
    }

    @Override // defpackage.lm1, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.d.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return new nm1(this.d);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return l11.j("[", this.d.toString(), "]");
    }
}
