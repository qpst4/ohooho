package defpackage;

import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class mz extends fb1 {
    public static final lz d = new lz();
    public final HashMap a = new HashMap();
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();

    public mz(Class cls) {
        try {
            Field[] declaredFields = cls.getDeclaredFields();
            int i = 0;
            for (Field field : declaredFields) {
                if (field.isEnumConstant()) {
                    declaredFields[i] = field;
                    i++;
                }
            }
            Field[] fieldArr = (Field[]) Arrays.copyOf(declaredFields, i);
            AccessibleObject.setAccessible(fieldArr, true);
            for (Field field2 : fieldArr) {
                Enum r4 = (Enum) field2.get(null);
                String strName = r4.name();
                String string = r4.toString();
                gz0 gz0Var = (gz0) field2.getAnnotation(gz0.class);
                if (gz0Var != null) {
                    strName = gz0Var.value();
                    for (String str : gz0Var.alternate()) {
                        this.a.put(str, r4);
                    }
                }
                this.a.put(strName, r4);
                this.b.put(string, r4);
                this.c.put(r4, strName);
            }
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }

    @Override // defpackage.fb1
    public final Object b(vd0 vd0Var) {
        if (vd0Var.I() == 9) {
            vd0Var.E();
            return null;
        }
        String strG = vd0Var.G();
        Enum r0 = (Enum) this.a.get(strG);
        return r0 == null ? (Enum) this.b.get(strG) : r0;
    }

    @Override // defpackage.fb1
    public final void c(ae0 ae0Var, Object obj) throws IOException {
        Enum r2 = (Enum) obj;
        ae0Var.B(r2 == null ? null : (String) this.c.get(r2));
    }
}
