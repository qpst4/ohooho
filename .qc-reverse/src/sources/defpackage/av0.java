package defpackage;

import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class av0 extends zu0 {
    public final jn0 b;

    public av0(jn0 jn0Var, bv0 bv0Var) {
        super(bv0Var);
        this.b = jn0Var;
    }

    @Override // defpackage.zu0
    public final Object d() {
        return this.b.h();
    }

    @Override // defpackage.zu0
    public final void f(Object obj, vd0 vd0Var, yu0 yu0Var) throws IllegalAccessException {
        Field field = yu0Var.b;
        Object objB = yu0Var.f.b(vd0Var);
        if (objB == null && yu0Var.g) {
            return;
        }
        if (yu0Var.h) {
            throw new rd0("Cannot set value of 'static final' ".concat(xu0.d(field, false)));
        }
        field.set(obj, objB);
    }

    @Override // defpackage.zu0
    public final Object e(Object obj) {
        return obj;
    }
}
