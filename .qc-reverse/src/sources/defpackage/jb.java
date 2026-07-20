package defpackage;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class jb implements Collection {
    public final /* synthetic */ kb b;

    public jb(kb kbVar) {
        this.b = kbVar;
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final void clear() {
        this.b.clear();
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        return this.b.a(obj) >= 0;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.b.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new gb(this.b, 1);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        kb kbVar = this.b;
        int iA = kbVar.a(obj);
        if (iA < 0) {
            return false;
        }
        kbVar.g(iA);
        return true;
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        kb kbVar = this.b;
        int i = kbVar.d;
        int i2 = 0;
        boolean z = false;
        while (i2 < i) {
            if (collection.contains(kbVar.i(i2))) {
                kbVar.g(i2);
                i2--;
                i--;
                z = true;
            }
            i2++;
        }
        return z;
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        kb kbVar = this.b;
        int i = kbVar.d;
        int i2 = 0;
        boolean z = false;
        while (i2 < i) {
            if (!collection.contains(kbVar.i(i2))) {
                kbVar.g(i2);
                i2--;
                i--;
                z = true;
            }
            i2++;
        }
        return z;
    }

    @Override // java.util.Collection
    public final int size() {
        return this.b.d;
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        kb kbVar = this.b;
        int i = kbVar.d;
        if (objArr.length < i) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
        }
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = kbVar.i(i2);
        }
        if (objArr.length > i) {
            objArr[i] = null;
        }
        return objArr;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        kb kbVar = this.b;
        int i = kbVar.d;
        Object[] objArr = new Object[i];
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = kbVar.i(i2);
        }
        return objArr;
    }
}
