package defpackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class hb1 extends fb1 {
    @Override // defpackage.fb1
    public final Object b(vd0 vd0Var) throws IOException {
        ArrayList arrayList = new ArrayList();
        vd0Var.a();
        while (vd0Var.v()) {
            try {
                arrayList.add(Integer.valueOf(vd0Var.A()));
            } catch (NumberFormatException e) {
                throw new wd0(e);
            }
        }
        vd0Var.m();
        int size = arrayList.size();
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
        for (int i = 0; i < size; i++) {
            atomicIntegerArray.set(i, ((Integer) arrayList.get(i)).intValue());
        }
        return atomicIntegerArray;
    }

    @Override // defpackage.fb1
    public final void c(ae0 ae0Var, Object obj) throws IOException {
        ae0Var.g();
        int length = ((AtomicIntegerArray) obj).length();
        for (int i = 0; i < length; i++) {
            ae0Var.z(r5.get(i));
        }
        ae0Var.m();
    }
}
