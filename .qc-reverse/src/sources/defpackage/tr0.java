package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class tr0 implements ln0 {
    public static final Charset f = Charset.forName("UTF-8");
    public static final o10 g;
    public static final o10 h;
    public static final ld0 i;
    public OutputStream a;
    public final HashMap b;
    public final HashMap c;
    public final kn0 d;
    public final ur0 e = new ur0(this);

    static {
        wb wbVar = new wb(1);
        HashMap map = new HashMap();
        map.put(rr0.class, wbVar);
        g = new o10("key", Collections.unmodifiableMap(new HashMap(map)));
        wb wbVar2 = new wb(2);
        HashMap map2 = new HashMap();
        map2.put(rr0.class, wbVar2);
        h = new o10("value", Collections.unmodifiableMap(new HashMap(map2)));
        i = new ld0(1);
    }

    public tr0(ByteArrayOutputStream byteArrayOutputStream, HashMap map, HashMap map2, kn0 kn0Var) {
        this.a = byteArrayOutputStream;
        this.b = map;
        this.c = map2;
        this.d = kn0Var;
    }

    public static int g(o10 o10Var) {
        rr0 rr0Var = (rr0) ((Annotation) o10Var.b.get(rr0.class));
        if (rr0Var != null) {
            return rr0Var.tag();
        }
        throw new vy("Field has no @Protobuf config");
    }

    @Override // defpackage.ln0
    public final ln0 a(o10 o10Var, Object obj) {
        e(o10Var, obj, true);
        return this;
    }

    public final void b(o10 o10Var, int i2, boolean z) {
        if (z && i2 == 0) {
            return;
        }
        rr0 rr0Var = (rr0) ((Annotation) o10Var.b.get(rr0.class));
        if (rr0Var == null) {
            throw new vy("Field has no @Protobuf config");
        }
        int iOrdinal = rr0Var.intEncoding().ordinal();
        if (iOrdinal == 0) {
            h(rr0Var.tag() << 3);
            h(i2);
        } else if (iOrdinal == 1) {
            h(rr0Var.tag() << 3);
            h((i2 << 1) ^ (i2 >> 31));
        } else {
            if (iOrdinal != 2) {
                return;
            }
            h((rr0Var.tag() << 3) | 5);
            this.a.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(i2).array());
        }
    }

    public final void c(o10 o10Var, long j, boolean z) throws IOException {
        if (z && j == 0) {
            return;
        }
        rr0 rr0Var = (rr0) ((Annotation) o10Var.b.get(rr0.class));
        if (rr0Var == null) {
            throw new vy("Field has no @Protobuf config");
        }
        int iOrdinal = rr0Var.intEncoding().ordinal();
        if (iOrdinal == 0) {
            h(rr0Var.tag() << 3);
            i(j);
        } else if (iOrdinal == 1) {
            h(rr0Var.tag() << 3);
            i((j >> 63) ^ (j << 1));
        } else {
            if (iOrdinal != 2) {
                return;
            }
            h((rr0Var.tag() << 3) | 1);
            this.a.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(j).array());
        }
    }

    @Override // defpackage.ln0
    public final ln0 d(o10 o10Var, long j) throws IOException {
        c(o10Var, j, true);
        return this;
    }

    public final void e(o10 o10Var, Object obj, boolean z) {
        if (obj == null) {
            return;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z && charSequence.length() == 0) {
                return;
            }
            h((g(o10Var) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(f);
            h(bytes.length);
            this.a.write(bytes);
            return;
        }
        if (obj instanceof Collection) {
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                e(o10Var, it.next(), false);
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                f(i, o10Var, (Map.Entry) it2.next(), false);
            }
            return;
        }
        if (obj instanceof Double) {
            double dDoubleValue = ((Double) obj).doubleValue();
            if (z && dDoubleValue == 0.0d) {
                return;
            }
            h((g(o10Var) << 3) | 1);
            this.a.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putDouble(dDoubleValue).array());
            return;
        }
        if (obj instanceof Float) {
            float fFloatValue = ((Float) obj).floatValue();
            if (z && fFloatValue == 0.0f) {
                return;
            }
            h((g(o10Var) << 3) | 5);
            this.a.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putFloat(fFloatValue).array());
            return;
        }
        if (obj instanceof Number) {
            c(o10Var, ((Number) obj).longValue(), z);
            return;
        }
        if (obj instanceof Boolean) {
            b(o10Var, ((Boolean) obj).booleanValue() ? 1 : 0, z);
            return;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if (z && bArr.length == 0) {
                return;
            }
            h((g(o10Var) << 3) | 2);
            h(bArr.length);
            this.a.write(bArr);
            return;
        }
        kn0 kn0Var = (kn0) this.b.get(obj.getClass());
        if (kn0Var != null) {
            f(kn0Var, o10Var, obj, z);
            return;
        }
        fe1 fe1Var = (fe1) this.c.get(obj.getClass());
        if (fe1Var != null) {
            ur0 ur0Var = this.e;
            ur0Var.a = false;
            ur0Var.c = o10Var;
            ur0Var.b = z;
            fe1Var.a(obj, ur0Var);
            return;
        }
        if (obj instanceof pi0) {
            b(o10Var, ((pi0) obj).b, true);
        } else if (obj instanceof Enum) {
            b(o10Var, ((Enum) obj).ordinal(), true);
        } else {
            f(this.d, o10Var, obj, z);
        }
    }

    public final void f(kn0 kn0Var, o10 o10Var, Object obj, boolean z) throws IOException {
        vf0 vf0Var = new vf0();
        vf0Var.b = 0L;
        try {
            OutputStream outputStream = this.a;
            this.a = vf0Var;
            try {
                kn0Var.a(obj, this);
                this.a = outputStream;
                long j = vf0Var.b;
                vf0Var.close();
                if (z && j == 0) {
                    return;
                }
                h((g(o10Var) << 3) | 2);
                i(j);
                kn0Var.a(obj, this);
            } catch (Throwable th) {
                this.a = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                vf0Var.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public final void h(int i2) throws IOException {
        while (true) {
            long j = i2 & (-128);
            OutputStream outputStream = this.a;
            if (j == 0) {
                outputStream.write(i2 & 127);
                return;
            } else {
                outputStream.write((i2 & 127) | 128);
                i2 >>>= 7;
            }
        }
    }

    public final void i(long j) throws IOException {
        while (true) {
            long j2 = (-128) & j;
            OutputStream outputStream = this.a;
            if (j2 == 0) {
                outputStream.write(((int) j) & 127);
                return;
            } else {
                outputStream.write((((int) j) & 127) | 128);
                j >>>= 7;
            }
        }
    }
}
