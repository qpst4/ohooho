package defpackage;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class il implements gb1 {
    public final /* synthetic */ int b;
    public final c70 c;

    public /* synthetic */ il(c70 c70Var, int i) {
        this.b = i;
        this.c = c70Var;
    }

    @Override // defpackage.gb1
    public final fb1 a(i70 i70Var, mc1 mc1Var) {
        Class cls;
        Type[] actualTypeArguments;
        int i = this.b;
        c70 c70Var = this.c;
        cls = Object.class;
        switch (i) {
            case 0:
                Type typeB = mc1Var.b();
                Class clsA = mc1Var.a();
                if (!Collection.class.isAssignableFrom(clsA)) {
                    return null;
                }
                if (typeB instanceof WildcardType) {
                    typeB = ((WildcardType) typeB).getUpperBounds()[0];
                }
                i1.f(Collection.class.isAssignableFrom(clsA));
                Type typeR = i1.R(typeB, clsA, i1.u(typeB, clsA, Collection.class), new HashMap());
                cls = typeR instanceof ParameterizedType ? ((ParameterizedType) typeR).getActualTypeArguments()[0] : Object.class;
                return new hl(new fj0(i70Var, i70Var.g(new mc1(cls)), cls), c70Var.i(mc1Var, false));
            default:
                Type typeB2 = mc1Var.b();
                Class clsA2 = mc1Var.a();
                if (!Map.class.isAssignableFrom(clsA2)) {
                    return null;
                }
                if (Properties.class.isAssignableFrom(clsA2)) {
                    actualTypeArguments = new Type[]{String.class, String.class};
                } else {
                    if (typeB2 instanceof WildcardType) {
                        typeB2 = ((WildcardType) typeB2).getUpperBounds()[0];
                    }
                    i1.f(Map.class.isAssignableFrom(clsA2));
                    Type typeR2 = i1.R(typeB2, clsA2, i1.u(typeB2, clsA2, Map.class), new HashMap());
                    actualTypeArguments = typeR2 instanceof ParameterizedType ? ((ParameterizedType) typeR2).getActualTypeArguments() : new Type[]{cls, cls};
                }
                Type type = actualTypeArguments[0];
                Type type2 = actualTypeArguments[1];
                return new fj0(this, new fj0(i70Var, (type == Boolean.TYPE || type == Boolean.class) ? kc1.c : i70Var.g(new mc1(type)), type), new fj0(i70Var, i70Var.g(new mc1(type2)), type2), c70Var.i(mc1Var, false));
        }
    }
}
