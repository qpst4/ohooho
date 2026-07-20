package defpackage;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ok {
    public static final ok c = new ok();
    public final HashMap a = new HashMap();
    public final HashMap b = new HashMap();

    public static void b(HashMap map, nk nkVar, yf0 yf0Var, Class cls) {
        yf0 yf0Var2 = (yf0) map.get(nkVar);
        if (yf0Var2 == null || yf0Var == yf0Var2) {
            if (yf0Var2 == null) {
                map.put(nkVar, yf0Var);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + nkVar.b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + yf0Var2 + ", new value " + yf0Var);
    }

    public final mk a(Class cls, Method[] methodArr) {
        int i;
        Class superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        HashMap map2 = this.a;
        if (superclass != null) {
            mk mkVarA = (mk) map2.get(superclass);
            if (mkVarA == null) {
                mkVarA = a(superclass, null);
            }
            map.putAll(mkVarA.b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            mk mkVarA2 = (mk) map2.get(cls2);
            if (mkVarA2 == null) {
                mkVarA2 = a(cls2, null);
            }
            for (Map.Entry entry : mkVarA2.b.entrySet()) {
                b(map, (nk) entry.getKey(), (yf0) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
            }
        }
        boolean z = false;
        for (Method method : methodArr) {
            do0 do0Var = (do0) method.getAnnotation(do0.class);
            if (do0Var != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else {
                    if (!gg0.class.isAssignableFrom(parameterTypes[0])) {
                        zy.n("invalid parameter type. Must be one and instanceof LifecycleOwner");
                        return null;
                    }
                    i = 1;
                }
                yf0 yf0VarValue = do0Var.value();
                if (parameterTypes.length > 1) {
                    if (!yf0.class.isAssignableFrom(parameterTypes[1])) {
                        zy.n("invalid parameter type. second arg must be an event");
                        return null;
                    }
                    if (yf0VarValue != yf0.ON_ANY) {
                        zy.n("Second arg is supported only for ON_ANY value");
                        return null;
                    }
                    i = 2;
                }
                if (parameterTypes.length > 2) {
                    zy.n("cannot have more than 2 params");
                    return null;
                }
                b(map, new nk(i, method), yf0VarValue, cls);
                z = true;
            }
        }
        mk mkVar = new mk(map);
        map2.put(cls, mkVar);
        this.b.put(cls, Boolean.valueOf(z));
        return mkVar;
    }
}
