package defpackage;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class lq1 extends nq1 {
    @Override // defpackage.nq1
    public final double a(long j, Object obj) {
        return Double.longBitsToDouble(((Unsafe) this.a).getLong(obj, j));
    }

    @Override // defpackage.nq1
    public final float b(long j, Object obj) {
        return Float.intBitsToFloat(((Unsafe) this.a).getInt(obj, j));
    }

    @Override // defpackage.nq1
    public final void c(Object obj, long j, boolean z) {
        if (oq1.g) {
            oq1.c(obj, j, z ? (byte) 1 : (byte) 0);
        } else {
            oq1.d(obj, j, z ? (byte) 1 : (byte) 0);
        }
    }

    @Override // defpackage.nq1
    public final void d(Object obj, long j, byte b) {
        if (oq1.g) {
            oq1.c(obj, j, b);
        } else {
            oq1.d(obj, j, b);
        }
    }

    @Override // defpackage.nq1
    public final void e(Object obj, long j, double d) {
        ((Unsafe) this.a).putLong(obj, j, Double.doubleToLongBits(d));
    }

    @Override // defpackage.nq1
    public final void f(Object obj, long j, float f) {
        ((Unsafe) this.a).putInt(obj, j, Float.floatToIntBits(f));
    }

    @Override // defpackage.nq1
    public final boolean g(long j, Object obj) {
        return oq1.g ? oq1.m(j, obj) : oq1.n(j, obj);
    }
}
