package defpackage;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class bq1 extends so1 implements RandomAccess {
    public static final Object[] e;
    public static final bq1 f;
    public Object[] c;
    public int d;

    static {
        Object[] objArr = new Object[0];
        e = objArr;
        f = new bq1(objArr, 0, false);
    }

    public bq1(Object[] objArr, int i, boolean z) {
        super(z);
        this.c = objArr;
        this.d = i;
    }

    @Override // defpackage.kp1
    public final /* bridge */ /* synthetic */ kp1 a(int i) {
        if (i >= this.d) {
            return new bq1(i == 0 ? e : Arrays.copyOf(this.c, i), this.d, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2;
        b();
        if (i < 0 || i > (i2 = this.d)) {
            throw new IndexOutOfBoundsException(qq0.h(i, this.d, "Index:", ", Size:"));
        }
        int i3 = i + 1;
        Object[] objArr = this.c;
        int length = objArr.length;
        if (i2 < length) {
            System.arraycopy(objArr, i, objArr, i3, i2 - i);
        } else {
            Object[] objArr2 = new Object[Math.max(((length * 3) / 2) + 1, 10)];
            System.arraycopy(this.c, 0, objArr2, 0, i);
            System.arraycopy(this.c, i, objArr2, i3, this.d - i);
            this.c = objArr2;
        }
        this.c[i] = obj;
        this.d++;
        ((AbstractList) this).modCount++;
    }

    public final void c(int i) {
        if (i < 0 || i >= this.d) {
            throw new IndexOutOfBoundsException(qq0.h(i, this.d, "Index:", ", Size:"));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        c(i);
        return this.c[i];
    }

    @Override // defpackage.so1, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        b();
        c(i);
        Object[] objArr = this.c;
        Object obj = objArr[i];
        if (i < this.d - 1) {
            System.arraycopy(objArr, i + 1, objArr, i, (r2 - i) - 1);
        }
        this.d--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        b();
        c(i);
        Object[] objArr = this.c;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.d;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        b();
        int i = this.d;
        int length = this.c.length;
        if (i == length) {
            this.c = Arrays.copyOf(this.c, Math.max(((length * 3) / 2) + 1, 10));
        }
        Object[] objArr = this.c;
        int i2 = this.d;
        this.d = i2 + 1;
        objArr[i2] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
