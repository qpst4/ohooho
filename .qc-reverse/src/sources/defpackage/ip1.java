package defpackage;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ip1 extends so1 implements RandomAccess, jp1 {
    public static final int[] e;
    public static final ip1 f;
    public int[] c;
    public int d;

    static {
        int[] iArr = new int[0];
        e = iArr;
        f = new ip1(iArr, 0, false);
    }

    public ip1(int[] iArr, int i, boolean z) {
        super(z);
        this.c = iArr;
        this.d = i;
    }

    @Override // defpackage.kp1
    public final /* bridge */ /* synthetic */ kp1 a(int i) {
        if (i >= this.d) {
            return new ip1(i == 0 ? e : Arrays.copyOf(this.c, i), this.d, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2;
        int iIntValue = ((Integer) obj).intValue();
        b();
        if (i < 0 || i > (i2 = this.d)) {
            throw new IndexOutOfBoundsException(qq0.h(i, this.d, "Index:", ", Size:"));
        }
        int i3 = i + 1;
        int[] iArr = this.c;
        int length = iArr.length;
        if (i2 < length) {
            System.arraycopy(iArr, i, iArr, i3, i2 - i);
        } else {
            int[] iArr2 = new int[Math.max(((length * 3) / 2) + 1, 10)];
            System.arraycopy(this.c, 0, iArr2, 0, i);
            System.arraycopy(this.c, i, iArr2, i3, this.d - i);
            this.c = iArr2;
        }
        this.c[i] = iIntValue;
        this.d++;
        ((AbstractList) this).modCount++;
    }

    @Override // defpackage.so1, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        Charset charset = lp1.a;
        collection.getClass();
        if (!(collection instanceof ip1)) {
            return super.addAll(collection);
        }
        ip1 ip1Var = (ip1) collection;
        int i = ip1Var.d;
        if (i == 0) {
            return false;
        }
        int i2 = this.d;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        int[] iArr = this.c;
        if (i3 > iArr.length) {
            this.c = Arrays.copyOf(iArr, i3);
        }
        System.arraycopy(ip1Var.c, 0, this.c, this.d, ip1Var.d);
        this.d = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final int c(int i) {
        e(i);
        return this.c[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(int i) {
        b();
        int i2 = this.d;
        int length = this.c.length;
        if (i2 == length) {
            int[] iArr = new int[Math.max(((length * 3) / 2) + 1, 10)];
            System.arraycopy(this.c, 0, iArr, 0, this.d);
            this.c = iArr;
        }
        int[] iArr2 = this.c;
        int i3 = this.d;
        this.d = i3 + 1;
        iArr2[i3] = i;
    }

    public final void e(int i) {
        if (i < 0 || i >= this.d) {
            throw new IndexOutOfBoundsException(qq0.h(i, this.d, "Index:", ", Size:"));
        }
    }

    @Override // defpackage.so1, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ip1)) {
            return super.equals(obj);
        }
        ip1 ip1Var = (ip1) obj;
        if (this.d != ip1Var.d) {
            return false;
        }
        int[] iArr = ip1Var.c;
        for (int i = 0; i < this.d; i++) {
            if (this.c[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        e(i);
        return Integer.valueOf(this.c[i]);
    }

    @Override // defpackage.so1, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.d; i2++) {
            i = (i * 31) + this.c[i2];
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int i = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.c[i2] == iIntValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // defpackage.so1, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        b();
        e(i);
        int[] iArr = this.c;
        int i2 = iArr[i];
        if (i < this.d - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (r2 - i) - 1);
        }
        this.d--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i2);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        b();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.c;
        System.arraycopy(iArr, i2, iArr, i, this.d - i2);
        this.d -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        b();
        e(i);
        int[] iArr = this.c;
        int i2 = iArr[i];
        iArr[i] = iIntValue;
        return Integer.valueOf(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.d;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        d(((Integer) obj).intValue());
        return true;
    }
}
