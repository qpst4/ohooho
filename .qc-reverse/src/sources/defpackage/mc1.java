package defpackage;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class mc1<T> {
    private final int hashCode;
    private final Class<? super T> rawType;
    private final Type type;

    public mc1() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            if (parameterizedType.getRawType() == mc1.class) {
                Type typeD = i1.d(parameterizedType.getActualTypeArguments()[0]);
                if (!Objects.equals(System.getProperty("gson.allowCapturingTypeVariables"), "true")) {
                    c(typeD);
                }
                this.type = typeD;
                this.rawType = i1.z(typeD);
                this.hashCode = typeD.hashCode();
                return;
            }
        } else if (genericSuperclass == mc1.class) {
            s1.f("TypeToken must be created with a type argument: new TypeToken<...>() {}; When using code shrinkers (ProGuard, R8, ...) make sure that generic signatures are preserved.\nSee ".concat("https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("type-token-raw")));
            throw null;
        }
        s1.f("Must only create direct subclasses of TypeToken");
        throw null;
    }

    public static void c(Type type) {
        if (type instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type;
            StringBuilder sb = new StringBuilder("TypeToken type argument must not contain a type variable; captured type variable ");
            sb.append(typeVariable.getName());
            sb.append(" declared by ");
            sb.append(typeVariable.getGenericDeclaration());
            String strConcat = "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("typetoken-type-variable");
            sb.append("\nSee ");
            sb.append(strConcat);
            throw new IllegalArgumentException(sb.toString());
        }
        if (type instanceof GenericArrayType) {
            c(((GenericArrayType) type).getGenericComponentType());
            return;
        }
        int i = 0;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type ownerType = parameterizedType.getOwnerType();
            if (ownerType != null) {
                c(ownerType);
            }
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            int length = actualTypeArguments.length;
            while (i < length) {
                c(actualTypeArguments[i]);
                i++;
            }
            return;
        }
        if (!(type instanceof WildcardType)) {
            if (type != null) {
                return;
            }
            zy.n("TypeToken captured `null` as type argument; probably a compiler / runtime bug");
            return;
        }
        WildcardType wildcardType = (WildcardType) type;
        for (Type type2 : wildcardType.getLowerBounds()) {
            c(type2);
        }
        Type[] upperBounds = wildcardType.getUpperBounds();
        int length2 = upperBounds.length;
        while (i < length2) {
            c(upperBounds[i]);
            i++;
        }
    }

    public final Class a() {
        return this.rawType;
    }

    public final Type b() {
        return this.type;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof mc1) && i1.q(this.type, ((mc1) obj).type);
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public final String toString() {
        return i1.d0(this.type);
    }

    public mc1(Type type) {
        Objects.requireNonNull(type);
        Type typeD = i1.d(type);
        this.type = typeD;
        this.rawType = i1.z(typeD);
        this.hashCode = typeD.hashCode();
    }
}
