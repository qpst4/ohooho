package defpackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class g70 extends fb1 {
    public final /* synthetic */ int a;
    public final /* synthetic */ fb1 b;

    public /* synthetic */ g70(fb1 fb1Var, int i) {
        this.a = i;
        this.b = fb1Var;
    }

    @Override // defpackage.fb1
    public final Object b(vd0 vd0Var) throws IOException {
        int i = this.a;
        fb1 fb1Var = this.b;
        switch (i) {
            case 0:
                return new AtomicLong(((Number) fb1Var.b(vd0Var)).longValue());
            default:
                ArrayList arrayList = new ArrayList();
                vd0Var.a();
                while (vd0Var.v()) {
                    arrayList.add(Long.valueOf(((Number) fb1Var.b(vd0Var)).longValue()));
                }
                vd0Var.m();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i2 = 0; i2 < size; i2++) {
                    atomicLongArray.set(i2, ((Long) arrayList.get(i2)).longValue());
                }
                return atomicLongArray;
        }
    }

    @Override // defpackage.fb1
    public final void c(ae0 ae0Var, Object obj) throws IOException {
        int i = this.a;
        fb1 fb1Var = this.b;
        switch (i) {
            case 0:
                fb1Var.c(ae0Var, Long.valueOf(((AtomicLong) obj).get()));
                break;
            default:
                AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
                ae0Var.g();
                int length = atomicLongArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    fb1Var.c(ae0Var, Long.valueOf(atomicLongArray.get(i2)));
                }
                ae0Var.m();
                break;
        }
    }
}
