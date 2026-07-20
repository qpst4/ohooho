package defpackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class em1 extends yl1 implements List, RandomAccess {
    public static final bm1 c = new bm1(tm1.f, 0);

    public static tm1 j(int i, Object[] objArr) {
        return i == 0 ? tm1.f : new tm1(i, objArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static em1 k(List list) {
        if (list instanceof yl1) {
            em1 em1VarE = ((yl1) list).e();
            if (!em1VarE.f()) {
                return em1VarE;
            }
            Object[] array = em1VarE.toArray(yl1.b);
            return j(array.length, array);
        }
        Object[] array2 = list.toArray();
        int length = array2.length;
        for (int i = 0; i < length; i++) {
            if (array2[i] == null) {
                zy.r(qq0.i("at index ", i));
                return null;
            }
        }
        return j(length, array2);
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.yl1
    public int b(Object[] objArr) {
        int size = size();
        for (int i = 0; i < size; i++) {
            objArr[i] = get(i);
        }
        return size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        Object next;
        Object next2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i = 0; i < size; i++) {
                        Object obj2 = get(i);
                        Object obj3 = list.get(i);
                        if (obj2 == obj3 || (obj2 != null && obj2.equals(obj3))) {
                        }
                    }
                    return true;
                }
                bm1 bm1VarListIterator = listIterator(0);
                Iterator it = list.iterator();
                while (true) {
                    if (bm1VarListIterator.hasNext()) {
                        if (!it.hasNext() || ((next = bm1VarListIterator.next()) != (next2 = it.next()) && (next == null || !next.equals(next2)))) {
                            break;
                        }
                    } else if (!it.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public em1 h() {
        return size() <= 1 ? this : new cm1(this);
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int iHashCode = 1;
        for (int i = 0; i < size; i++) {
            iHashCode = (iHashCode * 31) + get(i).hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: i */
    public em1 subList(int i, int i2) {
        f01.b0(i, i2, size());
        int i3 = i2 - i;
        return i3 == size() ? this : i3 == 0 ? tm1.f : new dm1(this, i, i3);
    }

    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public final bm1 listIterator(int i) {
        f01.X(i, size());
        return isEmpty() ? c : new bm1(this, i);
    }

    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.yl1
    public final em1 e() {
        return this;
    }
}
