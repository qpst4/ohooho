package defpackage;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class an1 extends lm1 implements NavigableSet, Iterable {
    public static final an1 g;
    public final transient Comparator d;
    public transient an1 e;
    public final transient em1 f;

    static {
        bm1 bm1Var = em1.c;
        g = new an1(tm1.f, qm1.c);
    }

    public an1(em1 em1Var, Comparator comparator) {
        this.d = comparator;
        this.f = em1Var;
    }

    public final void addFirst(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final void addLast(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.yl1
    public final int b(Object[] objArr) {
        return this.f.b(objArr);
    }

    @Override // defpackage.yl1
    public final int c() {
        return this.f.c();
    }

    @Override // java.util.NavigableSet
    public final Object ceiling(Object obj) {
        int iL = l(obj, true);
        em1 em1Var = this.f;
        if (iL == em1Var.size()) {
            return null;
        }
        return em1Var.get(iL);
    }

    @Override // java.util.SortedSet
    public final Comparator comparator() {
        return this.d;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj != null) {
            try {
                if (Collections.binarySearch(this.f, obj, this.d) >= 0) {
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        Comparator comparator = this.d;
        if (!fc0.V(comparator, collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        bm1 bm1VarListIterator = this.f.listIterator(0);
        Iterator it = collection.iterator();
        if (bm1VarListIterator.hasNext()) {
            Object next = it.next();
            Object next2 = bm1VarListIterator.next();
            while (true) {
                try {
                    int iCompare = comparator.compare(next2, next);
                    if (iCompare >= 0) {
                        if (iCompare != 0) {
                            break;
                        }
                        if (!it.hasNext()) {
                            return true;
                        }
                        next = it.next();
                    } else {
                        if (!bm1VarListIterator.hasNext()) {
                            break;
                        }
                        next2 = bm1VarListIterator.next();
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
        }
        return false;
    }

    @Override // defpackage.yl1
    public final int d() {
        return this.f.d();
    }

    @Override // java.util.NavigableSet
    public final Iterator descendingIterator() {
        return this.f.h().listIterator(0);
    }

    @Override // java.util.NavigableSet
    public final NavigableSet descendingSet() {
        an1 an1Var;
        an1 an1Var2 = this.e;
        if (an1Var2 != null) {
            return an1Var2;
        }
        Comparator comparatorReverseOrder = Collections.reverseOrder(this.d);
        if (!isEmpty()) {
            an1Var = new an1(this.f.h(), comparatorReverseOrder);
        } else if (qm1.c != comparatorReverseOrder) {
            bm1 bm1Var = em1.c;
            an1Var = new an1(tm1.f, comparatorReverseOrder);
        } else {
            an1Var = g;
        }
        this.e = an1Var;
        an1Var.e = this;
        return an1Var;
    }

    @Override // defpackage.lm1, defpackage.yl1
    public final em1 e() {
        return this.f;
    }

    @Override // defpackage.lm1, java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            em1 em1Var = this.f;
            if (em1Var.size() == set.size()) {
                if (isEmpty()) {
                    return true;
                }
                Comparator comparator = this.d;
                if (!fc0.V(comparator, set)) {
                    return containsAll(set);
                }
                Iterator it = set.iterator();
                try {
                    bm1 bm1VarListIterator = em1Var.listIterator(0);
                    while (bm1VarListIterator.hasNext()) {
                        Object next = bm1VarListIterator.next();
                        Object next2 = it.next();
                        if (next2 == null || comparator.compare(next, next2) != 0) {
                        }
                    }
                    return true;
                } catch (ClassCastException | NoSuchElementException unused) {
                }
            }
        }
        return false;
    }

    @Override // java.util.SortedSet
    public final Object first() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.f.get(0);
    }

    @Override // java.util.NavigableSet
    public final Object floor(Object obj) {
        int iK = k(obj, true) - 1;
        if (iK == -1) {
            return null;
        }
        return this.f.get(iK);
    }

    @Override // defpackage.yl1
    public final Object[] g() {
        return this.f.g();
    }

    public final Object getFirst() {
        return first();
    }

    public final Object getLast() {
        return last();
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public final SortedSet headSet(Object obj) {
        obj.getClass();
        return m(0, k(obj, false));
    }

    @Override // java.util.NavigableSet
    public final Object higher(Object obj) {
        int iL = l(obj, false);
        em1 em1Var = this.f;
        if (iL == em1Var.size()) {
            return null;
        }
        return em1Var.get(iL);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public final /* synthetic */ Iterator iterator() {
        return this.f.listIterator(0);
    }

    public final int k(Object obj, boolean z) {
        obj.getClass();
        int iBinarySearch = Collections.binarySearch(this.f, obj, this.d);
        return iBinarySearch >= 0 ? z ? iBinarySearch + 1 : iBinarySearch : ~iBinarySearch;
    }

    public final int l(Object obj, boolean z) {
        obj.getClass();
        int iBinarySearch = Collections.binarySearch(this.f, obj, this.d);
        return iBinarySearch >= 0 ? z ? iBinarySearch : iBinarySearch + 1 : ~iBinarySearch;
    }

    @Override // java.util.SortedSet
    public final Object last() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.f.get(r1.size() - 1);
    }

    @Override // java.util.NavigableSet
    public final Object lower(Object obj) {
        int iK = k(obj, false) - 1;
        if (iK == -1) {
            return null;
        }
        return this.f.get(iK);
    }

    public final an1 m(int i, int i2) {
        em1 em1Var = this.f;
        if (i == 0) {
            if (i2 == em1Var.size()) {
                return this;
            }
            i = 0;
        }
        Comparator comparator = this.d;
        if (i < i2) {
            return new an1(em1Var.subList(i, i2), comparator);
        }
        if (qm1.c == comparator) {
            return g;
        }
        bm1 bm1Var = em1.c;
        return new an1(tm1.f, comparator);
    }

    @Override // java.util.NavigableSet
    public final Object pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    public final Object pollLast() {
        throw new UnsupportedOperationException();
    }

    public final Object removeFirst() {
        throw new UnsupportedOperationException();
    }

    public final Object removeLast() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f.size();
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public final SortedSet subSet(Object obj, Object obj2) {
        obj.getClass();
        obj2.getClass();
        if (this.d.compare(obj, obj2) > 0) {
            throw new IllegalArgumentException();
        }
        an1 an1VarM = m(l(obj, true), this.f.size());
        return an1VarM.m(0, an1VarM.k(obj2, false));
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public final SortedSet tailSet(Object obj) {
        obj.getClass();
        return m(l(obj, true), this.f.size());
    }

    @Override // java.util.NavigableSet
    public final NavigableSet headSet(Object obj, boolean z) {
        obj.getClass();
        return m(0, k(obj, z));
    }

    @Override // java.util.NavigableSet
    public final NavigableSet tailSet(Object obj, boolean z) {
        obj.getClass();
        return m(l(obj, z), this.f.size());
    }

    @Override // java.util.NavigableSet
    public final NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
        obj.getClass();
        obj2.getClass();
        if (this.d.compare(obj, obj2) <= 0) {
            an1 an1VarM = m(l(obj, z), this.f.size());
            return an1VarM.m(0, an1VarM.k(obj2, z2));
        }
        throw new IllegalArgumentException();
    }
}
