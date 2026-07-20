package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class xb {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(xb.class, Object.class, "_consensus$volatile");
    public static final /* synthetic */ long b = sz.a.objectFieldOffset(xb.class.getDeclaredField("_consensus$volatile"));
    private volatile /* synthetic */ Object _consensus$volatile = yb0.c;

    public abstract void a(Object obj, Object obj2);

    public final Object b(Object obj) {
        a.getClass();
        Unsafe unsafe = sz.a;
        long j = b;
        Object objectVolatile = unsafe.getObjectVolatile(this, j);
        c1 c1Var = yb0.c;
        if (objectVolatile != c1Var) {
            return objectVolatile;
        }
        while (true) {
            Unsafe unsafe2 = sz.a;
            xb xbVar = this;
            Object obj2 = obj;
            if (unsafe2.compareAndSwapObject(xbVar, b, c1Var, obj2)) {
                return obj2;
            }
            if (unsafe2.getObjectVolatile(xbVar, j) != c1Var) {
                return unsafe2.getObjectVolatile(xbVar, j);
            }
            this = xbVar;
            obj = obj2;
        }
    }

    public final Object c(Object obj) {
        a.getClass();
        Object objectVolatile = sz.a.getObjectVolatile(this, b);
        if (objectVolatile == yb0.c) {
            objectVolatile = b(d(obj));
        }
        a(obj, objectVolatile);
        return objectVolatile;
    }

    public abstract c1 d(Object obj);

    public final String toString() {
        return getClass().getSimpleName() + '@' + xr.p(this);
    }
}
