package defpackage;

import java.util.AbstractMap;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class um1 extends em1 {
    public final /* synthetic */ vm1 d;

    public um1(vm1 vm1Var) {
        this.d = vm1Var;
    }

    @Override // defpackage.yl1
    public final boolean f() {
        return true;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        vm1 vm1Var = this.d;
        f01.V(i, vm1Var.f);
        Object[] objArr = vm1Var.e;
        int i2 = i + i;
        Object obj = objArr[i2];
        Objects.requireNonNull(obj);
        Object obj2 = objArr[i2 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.d.f;
    }
}
