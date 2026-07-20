package defpackage;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class kd0 extends pd0 implements Iterable {
    public final ArrayList b = new ArrayList();

    @Override // defpackage.pd0
    public final String c() {
        ArrayList arrayList = this.b;
        int size = arrayList.size();
        if (size == 1) {
            return ((pd0) arrayList.get(0)).c();
        }
        s1.f(qq0.i("Array must have size 1, but has size ", size));
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof kd0) && ((kd0) obj).b.equals(this.b);
        }
        return true;
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.b.iterator();
    }
}
