package defpackage;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class mb implements Collection, Set, ce0 {
    public int[] b;
    public Object[] c;
    public int d;

    public mb(int i) {
        this.b = f01.d;
        this.c = f01.e;
        if (i > 0) {
            this.b = new int[i];
            this.c = new Object[i];
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        int i;
        int iR;
        int i2 = this.d;
        if (obj == null) {
            iR = xy0.r(this, null, 0);
            i = 0;
        } else {
            int iHashCode = obj.hashCode();
            i = iHashCode;
            iR = xy0.r(this, obj, iHashCode);
        }
        if (iR >= 0) {
            return false;
        }
        int i3 = ~iR;
        int[] iArr = this.b;
        if (i2 >= iArr.length) {
            int i4 = 8;
            if (i2 >= 8) {
                i4 = (i2 >> 1) + i2;
            } else if (i2 < 4) {
                i4 = 4;
            }
            Object[] objArr = this.c;
            int[] iArr2 = new int[i4];
            this.b = iArr2;
            this.c = new Object[i4];
            if (i2 != this.d) {
                throw new ConcurrentModificationException();
            }
            if (iArr2.length != 0) {
                pb.e0(0, 0, iArr.length, iArr, iArr2);
                pb.g0(0, objArr.length, 6, objArr, this.c);
            }
        }
        if (i3 < i2) {
            int[] iArr3 = this.b;
            int i5 = i3 + 1;
            pb.e0(i5, i3, i2, iArr3, iArr3);
            Object[] objArr2 = this.c;
            pb.f0(i5, i3, i2, objArr2, objArr2);
        }
        int i6 = this.d;
        if (i2 == i6) {
            int[] iArr4 = this.b;
            if (i3 < iArr4.length) {
                iArr4[i3] = i;
                this.c[i3] = obj;
                this.d = i6 + 1;
                return true;
            }
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        collection.getClass();
        int size = collection.size() + this.d;
        int i = this.d;
        int[] iArr = this.b;
        boolean zAdd = false;
        if (iArr.length < size) {
            Object[] objArr = this.c;
            int[] iArr2 = new int[size];
            this.b = iArr2;
            this.c = new Object[size];
            if (i > 0) {
                pb.e0(0, 0, i, iArr, iArr2);
                pb.g0(0, this.d, 6, objArr, this.c);
            }
        }
        if (this.d != i) {
            throw new ConcurrentModificationException();
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    public final Object b(int i) {
        int i2 = this.d;
        Object[] objArr = this.c;
        Object obj = objArr[i];
        if (i2 <= 1) {
            clear();
            return obj;
        }
        int i3 = i2 - 1;
        int[] iArr = this.b;
        if (iArr.length <= 8 || i2 >= iArr.length / 3) {
            if (i < i3) {
                int i4 = i + 1;
                pb.e0(i, i4, i2, iArr, iArr);
                Object[] objArr2 = this.c;
                pb.f0(i, i4, i2, objArr2, objArr2);
            }
            this.c[i3] = null;
        } else {
            int i5 = i2 > 8 ? i2 + (i2 >> 1) : 8;
            int[] iArr2 = new int[i5];
            this.b = iArr2;
            this.c = new Object[i5];
            if (i > 0) {
                pb.e0(0, 0, i, iArr, iArr2);
                pb.g0(0, i, 6, objArr, this.c);
            }
            if (i < i3) {
                int i6 = i + 1;
                pb.e0(i, i6, i2, iArr, this.b);
                pb.f0(i, i6, i2, objArr, this.c);
            }
        }
        if (i2 != this.d) {
            throw new ConcurrentModificationException();
        }
        this.d = i3;
        return obj;
    }

    @Override // java.util.Collection, java.util.Set
    public final void clear() {
        if (this.d != 0) {
            this.b = f01.d;
            this.c = f01.e;
            this.d = 0;
        }
        if (this.d != 0) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return (obj == null ? xy0.r(this, null, 0) : xy0.r(this, obj, obj.hashCode())) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        collection.getClass();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set) || this.d != ((Set) obj).size()) {
            return false;
        }
        try {
            int i = this.d;
            for (int i2 = 0; i2 < i; i2++) {
                if (!((Set) obj).contains(this.c[i2])) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        int[] iArr = this.b;
        int i = this.d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.d <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new gb(this);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int iR = obj == null ? xy0.r(this, null, 0) : xy0.r(this, obj, obj.hashCode());
        if (iR < 0) {
            return false;
        }
        b(iR);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        collection.getClass();
        Iterator it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        collection.getClass();
        boolean z = false;
        for (int i = this.d - 1; -1 < i; i--) {
            if (!collection.contains(this.c[i])) {
                b(i);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public final int size() {
        return this.d;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        Object[] objArr = this.c;
        int i = this.d;
        objArr.getClass();
        int length = objArr.length;
        if (i <= length) {
            Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr, 0, i);
            objArrCopyOfRange.getClass();
            return objArrCopyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i + ") is greater than size (" + length + ").");
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.d * 14);
        sb.append('{');
        int i = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object obj = this.c[i2];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        objArr.getClass();
        int i = this.d;
        if (objArr.length < i) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
        } else if (objArr.length > i) {
            objArr[i] = null;
        }
        pb.f0(0, 0, this.d, this.c, objArr);
        return objArr;
    }
}
