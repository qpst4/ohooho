package defpackage;

import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class vz implements gb1, Cloneable {
    public static final vz d = new vz();
    public final List b;
    public final List c;

    public vz() {
        List list = Collections.EMPTY_LIST;
        this.b = list;
        this.c = list;
    }

    @Override // defpackage.gb1
    public final fb1 a(i70 i70Var, mc1 mc1Var) {
        Class clsA = mc1Var.a();
        boolean zB = b(clsA, true);
        boolean zB2 = b(clsA, false);
        if (zB || zB2) {
            return new uz(this, zB2, zB, i70Var, mc1Var);
        }
        return null;
    }

    public final boolean b(Class cls, boolean z) {
        if (!z && !Enum.class.isAssignableFrom(cls)) {
            tk0 tk0Var = xu0.a;
            if (!Modifier.isStatic(cls.getModifiers()) && (cls.isAnonymousClass() || cls.isLocalClass())) {
                return true;
            }
        }
        Iterator it = (z ? this.b : this.c).iterator();
        if (it.hasNext()) {
            throw l11.h(it);
        }
        return false;
    }

    public final Object clone() {
        try {
            return (vz) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
