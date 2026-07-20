package defpackage;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class yu0 {
    public final String a;
    public final Field b;
    public final String c;
    public final /* synthetic */ Method d;
    public final /* synthetic */ fb1 e;
    public final /* synthetic */ fb1 f;
    public final /* synthetic */ boolean g;
    public final /* synthetic */ boolean h;

    public yu0(String str, Field field, Method method, fb1 fb1Var, fb1 fb1Var2, boolean z, boolean z2) {
        this.d = method;
        this.e = fb1Var;
        this.f = fb1Var2;
        this.g = z;
        this.h = z2;
        this.a = str;
        this.b = field;
        this.c = field.getName();
    }

    public final void a(ae0 ae0Var, Object obj) throws IllegalAccessException {
        Object objInvoke;
        Method method = this.d;
        if (method != null) {
            try {
                objInvoke = method.invoke(obj, null);
            } catch (InvocationTargetException e) {
                throw new rd0(l11.j("Accessor ", xu0.d(method, false), " threw exception"), e.getCause());
            }
        } else {
            objInvoke = this.b.get(obj);
        }
        if (objInvoke == obj) {
            return;
        }
        ae0Var.r(this.a);
        this.e.c(ae0Var, objInvoke);
    }
}
