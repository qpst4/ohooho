package defpackage;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class o31 implements i50, jo, op, Serializable {
    public final jo b;
    public final ep c;
    public transient jo d;
    public final int e;

    public o31(jo joVar) {
        ep epVarD = joVar != null ? joVar.d() : null;
        this.b = joVar;
        this.c = epVarD;
        this.e = 2;
    }

    @Override // defpackage.i50
    public final int b() {
        return this.e;
    }

    @Override // defpackage.op
    public final op c() {
        jo joVar = this.b;
        if (joVar instanceof op) {
            return (op) joVar;
        }
        return null;
    }

    @Override // defpackage.jo
    public final ep d() {
        ep epVar = this.c;
        epVar.getClass();
        return epVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    @Override // defpackage.jo
    public final void e(Object obj) {
        ?? r4 = this;
        while (true) {
            o31 o31Var = (o31) r4;
            jo joVar = o31Var.b;
            joVar.getClass();
            try {
                obj = o31Var.i(obj);
                if (obj == np.b) {
                    return;
                }
            } catch (Throwable th) {
                obj = new jw0(th);
            }
            jo joVar2 = o31Var.d;
            if (joVar2 != null && joVar2 != o31Var) {
                ep epVar = o31Var.c;
                epVar.getClass();
                cp cpVarI = epVar.i(ow0.d);
                cpVarI.getClass();
                fu fuVar = (fu) joVar2;
                fuVar.b();
                fuVar.f();
            }
            o31Var.d = zl.b;
            if (!(joVar instanceof o31)) {
                joVar.e(obj);
                return;
            }
            r4 = joVar;
        }
    }

    public abstract jo h(jo joVar, Object obj);

    public abstract Object i(Object obj);

    public final String j() {
        int iIntValue;
        String strC;
        StringBuilder sb = new StringBuilder("Continuation at ");
        tr trVar = (tr) getClass().getAnnotation(tr.class);
        Object name = null;
        str = null;
        str = null;
        str = null;
        String str = null;
        if (trVar != null) {
            int iV = trVar.v();
            if (iV > 1) {
                throw new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + iV + ". Please update the Kotlin standard library.").toString());
            }
            try {
                Field declaredField = getClass().getDeclaredField("label");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(this);
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                iIntValue = (num != null ? num.intValue() : 0) - 1;
            } catch (Exception unused) {
                iIntValue = -1;
            }
            int i = iIntValue >= 0 ? trVar.l()[iIntValue] : -1;
            l7 l7Var = f01.g;
            l7 l7Var2 = f01.h;
            if (l7Var2 == null) {
                try {
                    l7 l7Var3 = new l7(Class.class.getDeclaredMethod("getModule", null), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
                    f01.h = l7Var3;
                    l7Var2 = l7Var3;
                } catch (Exception unused2) {
                    f01.h = l7Var;
                    l7Var2 = l7Var;
                }
            }
            if (l7Var2 != l7Var) {
                Method method = l7Var2.a;
                Object objInvoke = method != null ? method.invoke(getClass(), null) : null;
                if (objInvoke != null) {
                    Method method2 = l7Var2.b;
                    Object objInvoke2 = method2 != null ? method2.invoke(objInvoke, null) : null;
                    if (objInvoke2 != null) {
                        Method method3 = l7Var2.c;
                        Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, null) : null;
                        if (objInvoke3 instanceof String) {
                            str = (String) objInvoke3;
                        }
                    }
                }
            }
            if (str == null) {
                strC = trVar.c();
            } else {
                strC = str + '/' + trVar.c();
            }
            name = new StackTraceElement(strC, trVar.m(), trVar.f(), i);
        }
        if (name == null) {
            name = getClass().getName();
        }
        sb.append(name);
        return sb.toString();
    }

    public final String toString() {
        if (this.b != null) {
            return j();
        }
        tu0.a.getClass();
        String string = getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }
}
