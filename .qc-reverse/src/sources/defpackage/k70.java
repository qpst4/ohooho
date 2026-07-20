package defpackage;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class k70 implements ParameterizedType, Serializable {
    public final Type b;
    public final Type c;
    public final Type[] d;

    public k70(Type type, Class cls, Type... typeArr) {
        Objects.requireNonNull(cls);
        if (type == null && !Modifier.isStatic(cls.getModifiers()) && cls.getDeclaringClass() != null) {
            zy.h("Must specify owner type for ", cls);
            throw null;
        }
        this.b = type != null ? i1.d(type) : null;
        this.c = i1.d(cls);
        Type[] typeArr2 = (Type[]) typeArr.clone();
        this.d = typeArr2;
        int length = typeArr2.length;
        for (int i = 0; i < length; i++) {
            Objects.requireNonNull(this.d[i]);
            i1.g(this.d[i]);
            Type[] typeArr3 = this.d;
            typeArr3[i] = i1.d(typeArr3[i]);
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ParameterizedType) && i1.q(this, (ParameterizedType) obj);
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type[] getActualTypeArguments() {
        return (Type[]) this.d.clone();
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getOwnerType() {
        return this.b;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getRawType() {
        return this.c;
    }

    public final int hashCode() {
        int iHashCode = Arrays.hashCode(this.d) ^ this.c.hashCode();
        Type type = this.b;
        return (type != null ? type.hashCode() : 0) ^ iHashCode;
    }

    public final String toString() {
        Type[] typeArr = this.d;
        int length = typeArr.length;
        Type type = this.c;
        if (length == 0) {
            return i1.d0(type);
        }
        StringBuilder sb = new StringBuilder((length + 1) * 30);
        sb.append(i1.d0(type));
        sb.append("<");
        sb.append(i1.d0(typeArr[0]));
        for (int i = 1; i < length; i++) {
            sb.append(", ");
            sb.append(i1.d0(typeArr[i]));
        }
        sb.append(">");
        return sb.toString();
    }
}
