package defpackage;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zu0 extends fb1 {
    public final bv0 a;

    public zu0(bv0 bv0Var) {
        this.a = bv0Var;
    }

    @Override // defpackage.fb1
    public final Object b(vd0 vd0Var) throws IOException {
        if (vd0Var.I() == 9) {
            vd0Var.E();
            return null;
        }
        Object objD = d();
        Map map = this.a.a;
        try {
            vd0Var.g();
            while (vd0Var.v()) {
                yu0 yu0Var = (yu0) map.get(vd0Var.C());
                if (yu0Var == null) {
                    vd0Var.P();
                } else {
                    f(objD, vd0Var, yu0Var);
                }
            }
            vd0Var.q();
            return e(objD);
        } catch (IllegalAccessException e) {
            tk0 tk0Var = xu0.a;
            zy.l("Unexpected IllegalAccessException occurred (Gson 2.13.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e);
            return null;
        } catch (IllegalStateException e2) {
            throw new wd0(e2);
        }
    }

    @Override // defpackage.fb1
    public final void c(ae0 ae0Var, Object obj) throws IOException {
        if (obj == null) {
            ae0Var.t();
            return;
        }
        ae0Var.h();
        try {
            Iterator it = this.a.b.iterator();
            while (it.hasNext()) {
                ((yu0) it.next()).a(ae0Var, obj);
            }
            ae0Var.q();
        } catch (IllegalAccessException e) {
            tk0 tk0Var = xu0.a;
            zy.l("Unexpected IllegalAccessException occurred (Gson 2.13.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e);
        }
    }

    public abstract Object d();

    public abstract Object e(Object obj);

    public abstract void f(Object obj, vd0 vd0Var, yu0 yu0Var);
}
