package defpackage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ob extends fb1 {
    public static final nb c = new nb();
    public final Class a;
    public final fj0 b;

    public ob(i70 i70Var, fb1 fb1Var, Class cls) {
        this.b = new fj0(i70Var, fb1Var, cls);
        this.a = cls;
    }

    @Override // defpackage.fb1
    public final Object b(vd0 vd0Var) throws IOException {
        if (vd0Var.I() == 9) {
            vd0Var.E();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        vd0Var.a();
        while (vd0Var.v()) {
            arrayList.add(this.b.c.b(vd0Var));
        }
        vd0Var.m();
        int size = arrayList.size();
        Class cls = this.a;
        if (!cls.isPrimitive()) {
            return arrayList.toArray((Object[]) Array.newInstance((Class<?>) cls, size));
        }
        Object objNewInstance = Array.newInstance((Class<?>) cls, size);
        for (int i = 0; i < size; i++) {
            Array.set(objNewInstance, i, arrayList.get(i));
        }
        return objNewInstance;
    }

    @Override // defpackage.fb1
    public final void c(ae0 ae0Var, Object obj) throws IOException {
        if (obj == null) {
            ae0Var.t();
            return;
        }
        ae0Var.g();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.b.c(ae0Var, Array.get(obj, i));
        }
        ae0Var.m();
    }
}
