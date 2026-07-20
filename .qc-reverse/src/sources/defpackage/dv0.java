package defpackage;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class dv0 implements gb1 {
    public final c70 b;
    public final int c;
    public final vz d;
    public final jd0 e;

    public dv0(c70 c70Var, int i, vz vzVar, jd0 jd0Var) {
        List list = Collections.EMPTY_LIST;
        this.b = c70Var;
        this.c = i;
        this.d = vzVar;
        this.e = jd0Var;
    }

    public static void b(Class cls, String str, Field field, Field field2) {
        throw new IllegalArgumentException("Class " + cls.getName() + " declares multiple JSON fields named '" + str + "'; conflict is caused by fields " + xu0.c(field) + " and " + xu0.c(field2) + "\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("duplicate-fields"));
    }

    @Override // defpackage.gb1
    public final fb1 a(i70 i70Var, mc1 mc1Var) {
        Class clsA = mc1Var.a();
        if (!Object.class.isAssignableFrom(clsA)) {
            return null;
        }
        tk0 tk0Var = xu0.a;
        if (!Modifier.isStatic(clsA.getModifiers()) && (clsA.isAnonymousClass() || clsA.isLocalClass())) {
            return new f70(2);
        }
        List list = Collections.EMPTY_LIST;
        fc0.v();
        return xu0.a.s(clsA) ? new cv0(clsA, c(i70Var, mc1Var, clsA, true)) : new av0(this.b.i(mc1Var, true), c(i70Var, mc1Var, clsA, false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01cb  */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r22v0 */
    /* JADX WARN: Type inference failed for: r22v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r22v2 */
    /* JADX WARN: Type inference failed for: r23v0 */
    /* JADX WARN: Type inference failed for: r23v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r23v2 */
    /* JADX WARN: Type inference failed for: r26v0 */
    /* JADX WARN: Type inference failed for: r26v1 */
    /* JADX WARN: Type inference failed for: r26v2 */
    /* JADX WARN: Type inference failed for: r26v3 */
    /* JADX WARN: Type inference failed for: r26v4 */
    /* JADX WARN: Type inference failed for: r26v5 */
    /* JADX WARN: Type inference failed for: r27v0 */
    /* JADX WARN: Type inference failed for: r27v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r27v2 */
    /* JADX WARN: Type inference failed for: r29v0, types: [dv0] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.bv0 c(defpackage.i70 r30, defpackage.mc1 r31, java.lang.Class r32, boolean r33) {
        /*
            Method dump skipped, instruction units count: 576
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dv0.c(i70, mc1, java.lang.Class, boolean):bv0");
    }

    public final boolean d(Field field, boolean z) {
        boolean z2;
        vz vzVar = this.d;
        vzVar.getClass();
        if ((136 & field.getModifiers()) != 0 || field.isSynthetic() || vzVar.b(field.getType(), z)) {
            z2 = true;
        } else {
            List list = z ? vzVar.b : vzVar.c;
            if (!list.isEmpty()) {
                Iterator it = list.iterator();
                if (it.hasNext()) {
                    throw l11.h(it);
                }
            }
            z2 = false;
        }
        return !z2;
    }
}
