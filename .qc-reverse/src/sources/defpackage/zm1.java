package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class zm1 extends lm1 {
    public static final Object[] i;
    public static final zm1 j;
    public final transient Object[] d;
    public final transient int e;
    public final transient Object[] f;
    public final transient int g;
    public final transient int h;

    static {
        Object[] objArr = new Object[0];
        i = objArr;
        j = new zm1(0, 0, 0, objArr, objArr);
    }

    public zm1(int i2, int i3, int i4, Object[] objArr, Object[] objArr2) {
        this.d = objArr;
        this.e = i2;
        this.f = objArr2;
        this.g = i3;
        this.h = i4;
    }

    @Override // defpackage.yl1
    public final int b(Object[] objArr) {
        Object[] objArr2 = this.d;
        int i2 = this.h;
        System.arraycopy(objArr2, 0, objArr, 0, i2);
        return i2;
    }

    @Override // defpackage.yl1
    public final int c() {
        return this.h;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj != null) {
            Object[] objArr = this.f;
            if (objArr.length != 0) {
                int iR = xr.R(obj.hashCode());
                while (true) {
                    int i2 = iR & this.g;
                    Object obj2 = objArr[i2];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    iR = i2 + 1;
                }
            }
        }
        return false;
    }

    @Override // defpackage.yl1
    public final int d() {
        return 0;
    }

    @Override // defpackage.yl1
    public final Object[] g() {
        return this.d;
    }

    @Override // defpackage.lm1, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.e;
    }

    @Override // defpackage.lm1
    public final em1 i() {
        return em1.j(this.h, this.d);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return e().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.h;
    }
}
