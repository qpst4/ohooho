package defpackage;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class tm1 extends em1 {
    public static final tm1 f = new tm1(0, new Object[0]);
    public final transient Object[] d;
    public final transient int e;

    public tm1(int i, Object[] objArr) {
        this.d = objArr;
        this.e = i;
    }

    @Override // defpackage.em1, defpackage.yl1
    public final int b(Object[] objArr) {
        Object[] objArr2 = this.d;
        int i = this.e;
        System.arraycopy(objArr2, 0, objArr, 0, i);
        return i;
    }

    @Override // defpackage.yl1
    public final int c() {
        return this.e;
    }

    @Override // defpackage.yl1
    public final int d() {
        return 0;
    }

    @Override // defpackage.yl1
    public final boolean f() {
        return false;
    }

    @Override // defpackage.yl1
    public final Object[] g() {
        return this.d;
    }

    @Override // java.util.List
    public final Object get(int i) {
        f01.V(i, this.e);
        Object obj = this.d[i];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.e;
    }
}
