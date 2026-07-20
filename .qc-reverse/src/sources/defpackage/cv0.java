package defpackage;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class cv0 extends zu0 {
    public static final HashMap e;
    public final Constructor b;
    public final Object[] c;
    public final HashMap d;

    static {
        HashMap map = new HashMap();
        map.put(Byte.TYPE, (byte) 0);
        map.put(Short.TYPE, (short) 0);
        map.put(Integer.TYPE, 0);
        map.put(Long.TYPE, 0L);
        map.put(Float.TYPE, Float.valueOf(0.0f));
        map.put(Double.TYPE, Double.valueOf(0.0d));
        map.put(Character.TYPE, (char) 0);
        map.put(Boolean.TYPE, Boolean.FALSE);
        e = map;
    }

    public cv0(Class cls, bv0 bv0Var) {
        super(bv0Var);
        this.d = new HashMap();
        tk0 tk0Var = xu0.a;
        Constructor constructorI = tk0Var.i(cls);
        this.b = constructorI;
        xu0.f(constructorI);
        String[] strArrM = tk0Var.m(cls);
        for (int i = 0; i < strArrM.length; i++) {
            this.d.put(strArrM[i], Integer.valueOf(i));
        }
        Class<?>[] parameterTypes = this.b.getParameterTypes();
        this.c = new Object[parameterTypes.length];
        for (int i2 = 0; i2 < parameterTypes.length; i2++) {
            this.c[i2] = e.get(parameterTypes[i2]);
        }
    }

    @Override // defpackage.zu0
    public final Object d() {
        return (Object[]) this.c.clone();
    }

    @Override // defpackage.zu0
    public final Object e(Object obj) {
        Object[] objArr = (Object[]) obj;
        Constructor constructor = this.b;
        try {
            return constructor.newInstance(objArr);
        } catch (IllegalAccessException e2) {
            tk0 tk0Var = xu0.a;
            zy.l("Unexpected IllegalAccessException occurred (Gson 2.13.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e2);
            return null;
        } catch (IllegalArgumentException e3) {
            e = e3;
            throw new RuntimeException("Failed to invoke constructor '" + xu0.b(constructor) + "' with args " + Arrays.toString(objArr), e);
        } catch (InstantiationException e4) {
            e = e4;
            throw new RuntimeException("Failed to invoke constructor '" + xu0.b(constructor) + "' with args " + Arrays.toString(objArr), e);
        } catch (InvocationTargetException e5) {
            zy.l("Failed to invoke constructor '" + xu0.b(constructor) + "' with args " + Arrays.toString(objArr), e5.getCause());
            return null;
        }
    }

    @Override // defpackage.zu0
    public final void f(Object obj, vd0 vd0Var, yu0 yu0Var) {
        Object[] objArr = (Object[]) obj;
        String str = yu0Var.c;
        Integer num = (Integer) this.d.get(str);
        if (num == null) {
            zy.k("Could not find the index in the constructor '", xu0.b(this.b), "' for field with name '", str, "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
            return;
        }
        int iIntValue = num.intValue();
        Object objB = yu0Var.f.b(vd0Var);
        if (objB != null || !yu0Var.g) {
            objArr[iIntValue] = objB;
        } else {
            StringBuilder sbM = l11.m("null is not allowed as value for record component '", str, "' of primitive type; at path ");
            sbM.append(vd0Var.s());
            throw new cm(sbM.toString());
        }
    }
}
