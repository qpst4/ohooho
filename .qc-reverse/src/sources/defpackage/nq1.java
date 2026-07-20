package defpackage;

import java.util.LinkedHashMap;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class nq1 {
    public final Object a;

    public nq1() {
        this.a = new LinkedHashMap();
    }

    public abstract double a(long j, Object obj);

    public abstract float b(long j, Object obj);

    public abstract void c(Object obj, long j, boolean z);

    public abstract void d(Object obj, long j, byte b);

    public abstract void e(Object obj, long j, double d);

    public abstract void f(Object obj, long j, float f);

    public abstract boolean g(long j, Object obj);

    public nq1(Unsafe unsafe) {
        this.a = unsafe;
    }
}
