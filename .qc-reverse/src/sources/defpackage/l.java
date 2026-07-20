package defpackage;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class l extends gd0 implements jo, mp {
    public final ep f;

    public l(ep epVar, boolean z) {
        super(z);
        y((yc0) epVar.i(ow0.f));
        this.f = epVar.h(this);
    }

    @Override // defpackage.gd0
    public final void E(Object obj) {
        if (obj instanceof am) {
            am.b.get((am) obj);
        }
    }

    @Override // defpackage.mp
    public final ep b() {
        return this.f;
    }

    @Override // defpackage.jo
    public final ep d() {
        return this.f;
    }

    @Override // defpackage.jo
    public final void e(Object obj) {
        Throwable th = obj instanceof jw0 ? ((jw0) obj).b : null;
        if (th != null) {
            obj = new am(th);
        }
        Object objB = B(obj);
        if (objB == yb0.f) {
            return;
        }
        j(objB);
    }

    @Override // defpackage.gd0
    public final String n() {
        return getClass().getSimpleName().concat(" was cancelled");
    }

    @Override // defpackage.gd0
    public final void x(cm cmVar) throws IllegalAccessException, InvocationTargetException {
        fp1.m(this.f, cmVar);
    }
}
