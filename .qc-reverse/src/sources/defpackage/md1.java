package defpackage;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class md1 {
    public static final Unsafe a;
    public static final boolean b;
    public static final boolean c;
    public static final long d;

    static {
        boolean z;
        Field declaredField;
        Unsafe unsafeE = e();
        a = unsafeE;
        Class cls = Byte.TYPE;
        Class cls2 = Long.TYPE;
        boolean z2 = false;
        if (unsafeE != null) {
            try {
                Class<?> cls3 = unsafeE.getClass();
                cls3.getMethod("objectFieldOffset", Field.class);
                cls3.getMethod("getByte", cls2);
                cls3.getMethod("getLong", Object.class, cls2);
                cls3.getMethod("putByte", cls2, cls);
                cls3.getMethod("getLong", cls2);
                cls3.getMethod("copyMemory", cls2, cls2, cls2);
                z = true;
            } catch (Throwable unused) {
                z = false;
            }
        } else {
            z = false;
        }
        b = z;
        Unsafe unsafe = a;
        if (unsafe != null) {
            try {
                Class<?> cls4 = unsafe.getClass();
                cls4.getMethod("arrayBaseOffset", Class.class);
                cls4.getMethod("getByte", Object.class, cls2);
                cls4.getMethod("putByte", Object.class, cls2, cls);
                cls4.getMethod("getLong", Object.class, cls2);
                cls4.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
                z2 = true;
            } catch (Throwable unused2) {
            }
        }
        c = z2;
        d = a();
        try {
            declaredField = Buffer.class.getDeclaredField("address");
            declaredField.setAccessible(true);
        } catch (Throwable unused3) {
            declaredField = null;
        }
        b(declaredField);
    }

    public static int a() {
        if (c) {
            return a.arrayBaseOffset(byte[].class);
        }
        return -1;
    }

    public static void b(Field field) {
        Unsafe unsafe;
        if (field == null || (unsafe = a) == null) {
            return;
        }
        unsafe.objectFieldOffset(field);
    }

    public static byte c(byte[] bArr, long j) {
        return a.getByte(bArr, j);
    }

    public static long d(byte[] bArr, long j) {
        return a.getLong(bArr, j);
    }

    public static Unsafe e() {
        try {
            return (Unsafe) AccessController.doPrivileged(new ld1());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void f(byte[] bArr, long j, byte b2) {
        a.putByte(bArr, j, b2);
    }
}
