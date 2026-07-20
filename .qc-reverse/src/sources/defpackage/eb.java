package defpackage;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class eb extends AbstractList implements List, ce0 {
    public static final Object[] e = new Object[0];
    public int b;
    public Object[] c = e;
    public int d;

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int length;
        int i2 = this.d;
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(qq0.h(i, i2, "index: ", ", size: "));
        }
        if (i == i2) {
            addLast(obj);
            return;
        }
        if (i == 0) {
            addFirst(obj);
            return;
        }
        h();
        c(this.d + 1);
        int iG = g(this.b + i);
        int i3 = this.d;
        if (i < ((i3 + 1) >> 1)) {
            if (iG == 0) {
                Object[] objArr = this.c;
                objArr.getClass();
                length = objArr.length - 1;
            } else {
                length = iG - 1;
            }
            int length2 = this.b;
            if (length2 == 0) {
                Object[] objArr2 = this.c;
                objArr2.getClass();
                length2 = objArr2.length;
            }
            int i4 = length2 - 1;
            int i5 = this.b;
            Object[] objArr3 = this.c;
            if (length >= i5) {
                objArr3[i4] = objArr3[i5];
                pb.f0(i5, i5 + 1, length + 1, objArr3, objArr3);
            } else {
                pb.f0(i5 - 1, i5, objArr3.length, objArr3, objArr3);
                Object[] objArr4 = this.c;
                objArr4[objArr4.length - 1] = objArr4[0];
                pb.f0(0, 1, length + 1, objArr4, objArr4);
            }
            this.c[length] = obj;
            this.b = i4;
        } else {
            int iG2 = g(this.b + i3);
            Object[] objArr5 = this.c;
            if (iG < iG2) {
                pb.f0(iG + 1, iG, iG2, objArr5, objArr5);
            } else {
                pb.f0(1, 0, iG2, objArr5, objArr5);
                Object[] objArr6 = this.c;
                objArr6[0] = objArr6[objArr6.length - 1];
                pb.f0(iG + 1, iG, objArr6.length - 1, objArr6, objArr6);
            }
            this.c[iG] = obj;
        }
        this.d++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        collection.getClass();
        int i2 = this.d;
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(qq0.h(i, i2, "index: ", ", size: "));
        }
        if (collection.isEmpty()) {
            return false;
        }
        if (i == this.d) {
            return addAll(collection);
        }
        h();
        c(collection.size() + this.d);
        int iG = g(this.b + this.d);
        int iG2 = g(this.b + i);
        int size = collection.size();
        if (i >= ((this.d + 1) >> 1)) {
            int i3 = iG2 + size;
            Object[] objArr = this.c;
            if (iG2 < iG) {
                int i4 = size + iG;
                if (i4 <= objArr.length) {
                    pb.f0(i3, iG2, iG, objArr, objArr);
                } else if (i3 >= objArr.length) {
                    pb.f0(i3 - objArr.length, iG2, iG, objArr, objArr);
                } else {
                    int length = iG - (i4 - objArr.length);
                    pb.f0(0, length, iG, objArr, objArr);
                    Object[] objArr2 = this.c;
                    pb.f0(i3, iG2, length, objArr2, objArr2);
                }
            } else {
                pb.f0(size, 0, iG, objArr, objArr);
                Object[] objArr3 = this.c;
                if (i3 >= objArr3.length) {
                    pb.f0(i3 - objArr3.length, iG2, objArr3.length, objArr3, objArr3);
                } else {
                    pb.f0(0, objArr3.length - size, objArr3.length, objArr3, objArr3);
                    Object[] objArr4 = this.c;
                    pb.f0(i3, iG2, objArr4.length - size, objArr4, objArr4);
                }
            }
            b(iG2, collection);
            return true;
        }
        int i5 = this.b;
        int length2 = i5 - size;
        Object[] objArr5 = this.c;
        if (iG2 < i5) {
            pb.f0(length2, i5, objArr5.length, objArr5, objArr5);
            Object[] objArr6 = this.c;
            if (size >= iG2) {
                pb.f0(objArr6.length - size, 0, iG2, objArr6, objArr6);
            } else {
                pb.f0(objArr6.length - size, 0, size, objArr6, objArr6);
                Object[] objArr7 = this.c;
                pb.f0(0, size, iG2, objArr7, objArr7);
            }
        } else if (length2 >= 0) {
            pb.f0(length2, i5, iG2, objArr5, objArr5);
        } else {
            length2 += objArr5.length;
            int i6 = iG2 - i5;
            int length3 = objArr5.length - length2;
            if (length3 >= i6) {
                pb.f0(length2, i5, iG2, objArr5, objArr5);
            } else {
                pb.f0(length2, i5, i5 + length3, objArr5, objArr5);
                Object[] objArr8 = this.c;
                pb.f0(0, this.b + length3, iG2, objArr8, objArr8);
            }
        }
        this.b = length2;
        b(e(iG2 - size), collection);
        return true;
    }

    public final void addFirst(Object obj) {
        h();
        c(this.d + 1);
        int length = this.b;
        if (length == 0) {
            Object[] objArr = this.c;
            objArr.getClass();
            length = objArr.length;
        }
        int i = length - 1;
        this.b = i;
        this.c[i] = obj;
        this.d++;
    }

    public final void addLast(Object obj) {
        h();
        c(this.d + 1);
        this.c[g(this.b + this.d)] = obj;
        this.d++;
    }

    public final void b(int i, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.c.length;
        while (i < length && it.hasNext()) {
            this.c[i] = it.next();
            i++;
        }
        int i2 = this.b;
        for (int i3 = 0; i3 < i2 && it.hasNext(); i3++) {
            this.c[i3] = it.next();
        }
        this.d = collection.size() + this.d;
    }

    public final void c(int i) {
        if (i < 0) {
            s1.f("Deque is too big.");
            return;
        }
        Object[] objArr = this.c;
        if (i <= objArr.length) {
            return;
        }
        if (objArr == e) {
            if (i < 10) {
                i = 10;
            }
            this.c = new Object[i];
            return;
        }
        int length = objArr.length;
        int i2 = length + (length >> 1);
        if (i2 - i < 0) {
            i2 = i;
        }
        if (i2 - 2147483639 > 0) {
            i2 = i > 2147483639 ? Integer.MAX_VALUE : 2147483639;
        }
        Object[] objArr2 = new Object[i2];
        pb.f0(0, this.b, objArr.length, objArr, objArr2);
        Object[] objArr3 = this.c;
        int length2 = objArr3.length;
        int i3 = this.b;
        pb.f0(length2 - i3, 0, i3, objArr3, objArr2);
        this.b = 0;
        this.c = objArr2;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        if (!isEmpty()) {
            h();
            f(this.b, g(this.b + this.d));
        }
        this.b = 0;
        this.d = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final int d(int i) {
        this.c.getClass();
        if (i == r0.length - 1) {
            return 0;
        }
        return i + 1;
    }

    public final int e(int i) {
        return i < 0 ? i + this.c.length : i;
    }

    public final void f(int i, int i2) {
        Object[] objArr = this.c;
        if (i < i2) {
            objArr.getClass();
            Arrays.fill(objArr, i, i2, (Object) null);
        } else {
            Arrays.fill(objArr, i, objArr.length, (Object) null);
            Object[] objArr2 = this.c;
            objArr2.getClass();
            Arrays.fill(objArr2, 0, i2, (Object) null);
        }
    }

    public final int g(int i) {
        Object[] objArr = this.c;
        return i >= objArr.length ? i - objArr.length : i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        int i2 = this.d;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(qq0.h(i, i2, "index: ", ", size: "));
        }
        return this.c[g(this.b + i)];
    }

    public final void h() {
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int i;
        int iG = g(this.b + this.d);
        int length = this.b;
        if (length < iG) {
            while (length < iG) {
                if (fc0.b(obj, this.c[length])) {
                    i = this.b;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iG) {
            return -1;
        }
        int length2 = this.c.length;
        while (true) {
            if (length >= length2) {
                for (int i2 = 0; i2 < iG; i2++) {
                    if (fc0.b(obj, this.c[i2])) {
                        length = i2 + this.c.length;
                        i = this.b;
                    }
                }
                return -1;
            }
            if (fc0.b(obj, this.c[length])) {
                i = this.b;
                break;
            }
            length++;
        }
        return length - i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.d == 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int length;
        int i;
        int iG = g(this.b + this.d);
        int i2 = this.b;
        if (i2 < iG) {
            length = iG - 1;
            if (i2 <= length) {
                while (!fc0.b(obj, this.c[length])) {
                    if (length != i2) {
                        length--;
                    }
                }
                i = this.b;
                return length - i;
            }
            return -1;
        }
        if (i2 > iG) {
            while (true) {
                iG--;
                Object[] objArr = this.c;
                if (-1 >= iG) {
                    objArr.getClass();
                    length = objArr.length - 1;
                    int i3 = this.b;
                    if (i3 <= length) {
                        while (!fc0.b(obj, this.c[length])) {
                            if (length != i3) {
                                length--;
                            }
                        }
                        i = this.b;
                    }
                } else if (fc0.b(obj, objArr[iG])) {
                    length = iG + this.c.length;
                    i = this.b;
                    break;
                }
            }
            return length - i;
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        int i2 = this.d;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(qq0.h(i, i2, "index: ", ", size: "));
        }
        if (i == i2 - 1) {
            return removeLast();
        }
        if (i == 0) {
            return removeFirst();
        }
        h();
        int iG = g(this.b + i);
        Object[] objArr = this.c;
        Object obj = objArr[iG];
        int i3 = this.d;
        int i4 = i3 >> 1;
        int i5 = this.b;
        if (i < i4) {
            if (iG >= i5) {
                pb.f0(i5 + 1, i5, iG, objArr, objArr);
            } else {
                pb.f0(1, 0, iG, objArr, objArr);
                Object[] objArr2 = this.c;
                objArr2[0] = objArr2[objArr2.length - 1];
                int i6 = this.b;
                pb.f0(i6 + 1, i6, objArr2.length - 1, objArr2, objArr2);
            }
            Object[] objArr3 = this.c;
            int i7 = this.b;
            objArr3[i7] = null;
            this.b = d(i7);
        } else {
            int iG2 = g((i3 - 1) + i5);
            Object[] objArr4 = this.c;
            if (iG <= iG2) {
                pb.f0(iG, iG + 1, iG2 + 1, objArr4, objArr4);
            } else {
                pb.f0(iG, iG + 1, objArr4.length, objArr4, objArr4);
                Object[] objArr5 = this.c;
                objArr5[objArr5.length - 1] = objArr5[0];
                pb.f0(0, 1, iG2 + 1, objArr5, objArr5);
            }
            this.c[iG2] = null;
        }
        this.d--;
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        int iG;
        Object[] objArr;
        collection.getClass();
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.c.length != 0) {
            int iG2 = g(this.b + this.d);
            int i = this.b;
            if (i < iG2) {
                iG = i;
                while (true) {
                    objArr = this.c;
                    if (i >= iG2) {
                        break;
                    }
                    Object obj = objArr[i];
                    if (collection.contains(obj)) {
                        z = true;
                    } else {
                        this.c[iG] = obj;
                        iG++;
                    }
                    i++;
                }
                objArr.getClass();
                Arrays.fill(objArr, iG, iG2, (Object) null);
            } else {
                int length = this.c.length;
                boolean z2 = false;
                int i2 = i;
                while (i < length) {
                    Object[] objArr2 = this.c;
                    Object obj2 = objArr2[i];
                    objArr2[i] = null;
                    if (collection.contains(obj2)) {
                        z2 = true;
                    } else {
                        this.c[i2] = obj2;
                        i2++;
                    }
                    i++;
                }
                iG = g(i2);
                for (int i3 = 0; i3 < iG2; i3++) {
                    Object[] objArr3 = this.c;
                    Object obj3 = objArr3[i3];
                    objArr3[i3] = null;
                    if (collection.contains(obj3)) {
                        z2 = true;
                    } else {
                        this.c[iG] = obj3;
                        iG = d(iG);
                    }
                }
                z = z2;
            }
            if (z) {
                h();
                this.d = e(iG - this.b);
            }
        }
        return z;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        h();
        Object[] objArr = this.c;
        int i = this.b;
        Object obj = objArr[i];
        objArr[i] = null;
        this.b = d(i);
        this.d--;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        h();
        int iG = g((size() - 1) + this.b);
        Object[] objArr = this.c;
        Object obj = objArr[iG];
        objArr[iG] = null;
        this.d--;
        return obj;
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        yb0.c(i, i2, this.d);
        int i3 = i2 - i;
        if (i3 == 0) {
            return;
        }
        if (i3 == this.d) {
            clear();
            return;
        }
        if (i3 == 1) {
            remove(i);
            return;
        }
        h();
        int i4 = this.d - i2;
        int i5 = this.b;
        if (i < i4) {
            int iG = g((i - 1) + i5);
            int iG2 = g((i2 - 1) + this.b);
            while (i > 0) {
                int i6 = iG + 1;
                int iMin = Math.min(i, Math.min(i6, iG2 + 1));
                Object[] objArr = this.c;
                int i7 = iG2 - iMin;
                int i8 = iG - iMin;
                pb.f0(i7 + 1, i8 + 1, i6, objArr, objArr);
                iG = e(i8);
                iG2 = e(i7);
                i -= iMin;
            }
            int iG3 = g(this.b + i3);
            f(this.b, iG3);
            this.b = iG3;
        } else {
            int iG4 = g(i5 + i2);
            int iG5 = g(this.b + i);
            int i9 = this.d;
            while (true) {
                i9 -= i2;
                if (i9 <= 0) {
                    break;
                }
                Object[] objArr2 = this.c;
                i2 = Math.min(i9, Math.min(objArr2.length - iG4, objArr2.length - iG5));
                Object[] objArr3 = this.c;
                int i10 = iG4 + i2;
                pb.f0(iG5, iG4, i10, objArr3, objArr3);
                iG4 = g(i10);
                iG5 = g(iG5 + i2);
            }
            int iG6 = g(this.b + this.d);
            f(e(iG6 - i3), iG6);
        }
        this.d -= i3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        int iG;
        Object[] objArr;
        collection.getClass();
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.c.length != 0) {
            int iG2 = g(this.b + this.d);
            int i = this.b;
            if (i < iG2) {
                iG = i;
                while (true) {
                    objArr = this.c;
                    if (i >= iG2) {
                        break;
                    }
                    Object obj = objArr[i];
                    if (collection.contains(obj)) {
                        this.c[iG] = obj;
                        iG++;
                    } else {
                        z = true;
                    }
                    i++;
                }
                objArr.getClass();
                Arrays.fill(objArr, iG, iG2, (Object) null);
            } else {
                int length = this.c.length;
                boolean z2 = false;
                int i2 = i;
                while (i < length) {
                    Object[] objArr2 = this.c;
                    Object obj2 = objArr2[i];
                    objArr2[i] = null;
                    if (collection.contains(obj2)) {
                        this.c[i2] = obj2;
                        i2++;
                    } else {
                        z2 = true;
                    }
                    i++;
                }
                iG = g(i2);
                for (int i3 = 0; i3 < iG2; i3++) {
                    Object[] objArr3 = this.c;
                    Object obj3 = objArr3[i3];
                    objArr3[i3] = null;
                    if (collection.contains(obj3)) {
                        this.c[iG] = obj3;
                        iG = d(iG);
                    } else {
                        z2 = true;
                    }
                }
                z = z2;
            }
            if (z) {
                h();
                this.d = e(iG - this.b);
            }
        }
        return z;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        int i2 = this.d;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(qq0.h(i, i2, "index: ", ", size: "));
        }
        int iG = g(this.b + i);
        Object[] objArr = this.c;
        Object obj2 = objArr[iG];
        objArr[iG] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.d;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        objArr.getClass();
        int length = objArr.length;
        int i = this.d;
        if (length < i) {
            Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), i);
            objNewInstance.getClass();
            objArr = (Object[]) objNewInstance;
        }
        int iG = g(this.b + this.d);
        int i2 = this.b;
        if (i2 < iG) {
            pb.g0(i2, iG, 2, this.c, objArr);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.c;
            pb.f0(0, this.b, objArr2.length, objArr2, objArr);
            Object[] objArr3 = this.c;
            pb.f0(objArr3.length - this.b, 0, iG, objArr3, objArr);
        }
        int i3 = this.d;
        if (i3 < objArr.length) {
            objArr[i3] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[this.d]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        collection.getClass();
        if (collection.isEmpty()) {
            return false;
        }
        h();
        c(collection.size() + this.d);
        b(g(this.b + this.d), collection);
        return true;
    }
}
