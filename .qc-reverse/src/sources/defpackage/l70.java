package defpackage;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class l70 implements WildcardType, Serializable {
    public final Type b;
    public final Type c;

    public l70(Type[] typeArr, Type[] typeArr2) {
        i1.f(typeArr2.length <= 1);
        i1.f(typeArr.length == 1);
        if (typeArr2.length != 1) {
            Objects.requireNonNull(typeArr[0]);
            i1.g(typeArr[0]);
            this.c = null;
            this.b = i1.d(typeArr[0]);
            return;
        }
        Objects.requireNonNull(typeArr2[0]);
        i1.g(typeArr2[0]);
        i1.f(typeArr[0] == Object.class);
        this.c = i1.d(typeArr2[0]);
        this.b = Object.class;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof WildcardType) && i1.q(this, (WildcardType) obj);
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getLowerBounds() {
        Type type = this.c;
        return type != null ? new Type[]{type} : i1.j;
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getUpperBounds() {
        return new Type[]{this.b};
    }

    public final int hashCode() {
        Type type = this.c;
        return (this.b.hashCode() + 31) ^ (type != null ? type.hashCode() + 31 : 1);
    }

    public final String toString() {
        Type type = this.c;
        if (type != null) {
            return "? super " + i1.d0(type);
        }
        Type type2 = this.b;
        if (type2 == Object.class) {
            return "?";
        }
        return "? extends " + i1.d0(type2);
    }
}
