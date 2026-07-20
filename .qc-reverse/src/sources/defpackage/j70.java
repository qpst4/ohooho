package defpackage;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class j70 implements GenericArrayType, Serializable {
    public final Type b;

    public j70(Type type) {
        Objects.requireNonNull(type);
        this.b = i1.d(type);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && i1.q(this, (GenericArrayType) obj);
    }

    @Override // java.lang.reflect.GenericArrayType
    public final Type getGenericComponentType() {
        return this.b;
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return i1.d0(this.b) + "[]";
    }
}
