package defpackage;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class xm1 extends em1 {
    public final transient Object[] d;
    public final transient int e;
    public final transient int f;

    public xm1(Object[] objArr, int i, int i2) {
        this.d = objArr;
        this.e = i;
        this.f = i2;
    }

    @Override // defpackage.yl1
    public final boolean f() {
        return true;
    }

    @Override // java.util.List
    public final Object get(int i) {
        f01.V(i, this.f);
        Object obj = this.d[i + i + this.e];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f;
    }
}
