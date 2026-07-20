package defpackage;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class nb implements gb1 {
    @Override // defpackage.gb1
    public final fb1 a(i70 i70Var, mc1 mc1Var) {
        Type typeB = mc1Var.b();
        boolean z = typeB instanceof GenericArrayType;
        if (!z && (!(typeB instanceof Class) || !((Class) typeB).isArray())) {
            return null;
        }
        Type genericComponentType = z ? ((GenericArrayType) typeB).getGenericComponentType() : ((Class) typeB).getComponentType();
        return new ob(i70Var, i70Var.g(new mc1(genericComponentType)), i1.z(genericComponentType));
    }
}
