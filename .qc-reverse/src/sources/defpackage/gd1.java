package defpackage;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class gd1 extends kd1 {
    public final /* synthetic */ Method b;
    public final /* synthetic */ Object c;

    public gd1(Object obj, Method method) {
        this.b = method;
        this.c = obj;
    }

    @Override // defpackage.kd1
    public final Object a(Class cls) {
        String strF = c70.f(cls);
        if (strF != null) {
            throw new AssertionError("UnsafeAllocator is used for non-instantiable type: ".concat(strF));
        }
        return this.b.invoke(this.c, cls);
    }
}
