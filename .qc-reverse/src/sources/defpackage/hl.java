package defpackage;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class hl extends fb1 {
    public final /* synthetic */ int a = 1;
    public final Object b;
    public final Object c;

    public hl(fj0 fj0Var, jn0 jn0Var) {
        this.b = fj0Var;
        this.c = jn0Var;
    }

    @Override // defpackage.fb1
    public final Object b(vd0 vd0Var) throws IOException {
        int i = this.a;
        Object obj = this.c;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                if (vd0Var.I() == 9) {
                    vd0Var.E();
                    return null;
                }
                Collection collection = (Collection) ((jn0) obj).h();
                vd0Var.a();
                while (vd0Var.v()) {
                    collection.add(((fj0) obj2).c.b(vd0Var));
                }
                vd0Var.m();
                return collection;
            default:
                Class cls = (Class) obj2;
                Object objB = ((ac1) obj).d.b(vd0Var);
                if (objB == null || cls.isInstance(objB)) {
                    return objB;
                }
                throw new wd0("Expected a " + cls.getName() + " but was " + objB.getClass().getName() + "; at path " + vd0Var.u());
        }
    }

    @Override // defpackage.fb1
    public final void c(ae0 ae0Var, Object obj) throws IOException {
        switch (this.a) {
            case 0:
                Collection collection = (Collection) obj;
                if (collection != null) {
                    ae0Var.g();
                    Iterator it = collection.iterator();
                    while (it.hasNext()) {
                        ((fj0) this.b).c(ae0Var, it.next());
                    }
                    ae0Var.m();
                } else {
                    ae0Var.t();
                }
                break;
            default:
                ((ac1) this.c).d.c(ae0Var, obj);
                break;
        }
    }

    public hl(ac1 ac1Var, Class cls) {
        this.c = ac1Var;
        this.b = cls;
    }
}
