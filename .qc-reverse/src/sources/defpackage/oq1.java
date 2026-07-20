package defpackage;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class oq1 {
    public static final Unsafe a;
    public static final Class b;
    public static final nq1 c;
    public static final boolean d;
    public static final boolean e;
    public static final long f;
    public static final boolean g;

    /* JADX WARN: Removed duplicated region for block: B:11:0x0043  */
    static {
        /*
            Method dump skipped, instruction units count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.oq1.<clinit>():void");
    }

    public static void a(Class cls) {
        if (e) {
            ((Unsafe) c.a).arrayIndexScale(cls);
        }
    }

    public static Field b() {
        Field declaredField;
        Field declaredField2;
        int i = to1.a;
        try {
            declaredField = Buffer.class.getDeclaredField("effectiveDirectAddress");
        } catch (Throwable unused) {
            declaredField = null;
        }
        if (declaredField != null) {
            return declaredField;
        }
        try {
            declaredField2 = Buffer.class.getDeclaredField("address");
        } catch (Throwable unused2) {
            declaredField2 = null;
        }
        if (declaredField2 == null || declaredField2.getType() != Long.TYPE) {
            return null;
        }
        return declaredField2;
    }

    public static void c(Object obj, long j, byte b2) {
        nq1 nq1Var = c;
        long j2 = (-4) & j;
        int i = ((Unsafe) nq1Var.a).getInt(obj, j2);
        int i2 = ((~((int) j)) & 3) << 3;
        ((Unsafe) nq1Var.a).putInt(obj, j2, ((255 & b2) << i2) | (i & (~(255 << i2))));
    }

    public static void d(Object obj, long j, byte b2) {
        nq1 nq1Var = c;
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        ((Unsafe) nq1Var.a).putInt(obj, j2, ((255 & b2) << i) | (((Unsafe) nq1Var.a).getInt(obj, j2) & (~(255 << i))));
    }

    public static int e(long j, Object obj) {
        return ((Unsafe) c.a).getInt(obj, j);
    }

    public static long f(long j, Object obj) {
        return ((Unsafe) c.a).getLong(obj, j);
    }

    public static Object g(Class cls) {
        try {
            return a.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static Object h(long j, Object obj) {
        return ((Unsafe) c.a).getObject(obj, j);
    }

    public static Unsafe i() {
        try {
            return (Unsafe) AccessController.doPrivileged(new kq1());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void j(Object obj, long j, int i) {
        ((Unsafe) c.a).putInt(obj, j, i);
    }

    public static void k(Object obj, long j, long j2) {
        ((Unsafe) c.a).putLong(obj, j, j2);
    }

    public static void l(long j, Object obj, Object obj2) {
        ((Unsafe) c.a).putObject(obj, j, obj2);
    }

    public static /* bridge */ /* synthetic */ boolean m(long j, Object obj) {
        return ((byte) ((((Unsafe) c.a).getInt(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3))) & 255)) != 0;
    }

    public static /* bridge */ /* synthetic */ boolean n(long j, Object obj) {
        return ((byte) ((((Unsafe) c.a).getInt(obj, (-4) & j) >>> ((int) ((j & 3) << 3))) & 255)) != 0;
    }

    public static boolean o(Class cls) {
        int i = to1.a;
        try {
            Class cls2 = b;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int p(Class cls) {
        if (e) {
            return ((Unsafe) c.a).arrayBaseOffset(cls);
        }
        return -1;
    }
}
