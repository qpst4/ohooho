package defpackage;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class t30 {
    public static final t01 b = new t01(0);
    public final /* synthetic */ y30 a;

    public t30(y30 y30Var) {
        this.a = y30Var;
    }

    public static Class b(ClassLoader classLoader, String str) throws ClassNotFoundException {
        t01 t01Var = b;
        t01 t01Var2 = (t01) t01Var.get(classLoader);
        if (t01Var2 == null) {
            t01Var2 = new t01(0);
            t01Var.put(classLoader, t01Var2);
        }
        Class cls = (Class) t01Var2.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        t01Var2.put(str, cls2);
        return cls2;
    }

    public static Class c(ClassLoader classLoader, String str) {
        try {
            return b(classLoader, str);
        } catch (ClassCastException e) {
            throw new cm(l11.j("Unable to instantiate fragment ", str, ": make sure class is a valid subclass of Fragment"), e);
        } catch (ClassNotFoundException e2) {
            throw new cm(l11.j("Unable to instantiate fragment ", str, ": make sure class name exists"), e2);
        }
    }

    public final j30 a(String str) {
        try {
            return (j30) c(this.a.t.n.getClassLoader(), str).getConstructor(null).newInstance(null);
        } catch (IllegalAccessException e) {
            throw new cm(l11.j("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e);
        } catch (InstantiationException e2) {
            throw new cm(l11.j("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e2);
        } catch (NoSuchMethodException e3) {
            throw new cm(l11.j("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), e3);
        } catch (InvocationTargetException e4) {
            throw new cm(l11.j("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), e4);
        }
    }
}
