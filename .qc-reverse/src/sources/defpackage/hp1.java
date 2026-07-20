package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class hp1 extends ro1 {
    private static final Map zzb = new ConcurrentHashMap();
    protected jq1 zzc;
    private int zzd;

    public hp1() {
        this.zza = 0;
        this.zzd = -1;
        this.zzc = jq1.f;
    }

    public static hp1 h(Class cls) {
        Map map = zzb;
        hp1 hp1Var = (hp1) map.get(cls);
        if (hp1Var == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                hp1Var = (hp1) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (hp1Var != null) {
            return hp1Var;
        }
        hp1 hp1Var2 = (hp1) ((hp1) oq1.g(cls)).d(6);
        if (hp1Var2 == null) {
            throw new IllegalStateException();
        }
        map.put(cls, hp1Var2);
        return hp1Var2;
    }

    public static Object i(Method method, hp1 hp1Var, Object... objArr) {
        try {
            return method.invoke(hp1Var, objArr);
        } catch (IllegalAccessException e) {
            zy.l("Couldn't use Java reflection to implement protocol message reflection.", e);
            return null;
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            zy.l("Unexpected exception thrown by generated accessor method.", cause);
            return null;
        }
    }

    public static void l(Class cls, hp1 hp1Var) {
        hp1Var.k();
        zzb.put(cls, hp1Var);
    }

    public static final boolean n(hp1 hp1Var, boolean z) {
        byte bByteValue = ((Byte) hp1Var.d(1)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zI = aq1.c.a(hp1Var.getClass()).i(hp1Var);
        if (z) {
            hp1Var.d(2);
        }
        return zI;
    }

    @Override // defpackage.ro1
    public final int a(dq1 dq1Var) {
        if (c()) {
            int iG = dq1Var.g(this);
            if (iG >= 0) {
                return iG;
            }
            s1.f(qq0.i("serialized size must be non-negative, was ", iG));
            return 0;
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iG2 = dq1Var.g(this);
        if (iG2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | iG2;
            return iG2;
        }
        s1.f(qq0.i("serialized size must be non-negative, was ", iG2));
        return 0;
    }

    public final boolean c() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    public abstract Object d(int i);

    public final int e() {
        if (c()) {
            int iG = aq1.c.a(getClass()).g(this);
            if (iG >= 0) {
                return iG;
            }
            s1.f(qq0.i("serialized size must be non-negative, was ", iG));
            return 0;
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iG2 = aq1.c.a(getClass()).g(this);
        if (iG2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | iG2;
            return iG2;
        }
        s1.f(qq0.i("serialized size must be non-negative, was ", iG2));
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return aq1.c.a(getClass()).e(this, (hp1) obj);
    }

    public final gp1 f() {
        return (gp1) d(5);
    }

    public final gp1 g() {
        gp1 gp1Var = (gp1) d(5);
        if (!gp1Var.b.equals(this)) {
            if (!gp1Var.c.c()) {
                hp1 hp1Var = (hp1) gp1Var.b.d(4);
                aq1.c.a(hp1Var.getClass()).b(hp1Var, gp1Var.c);
                gp1Var.c = hp1Var;
            }
            hp1 hp1Var2 = gp1Var.c;
            aq1.c.a(hp1Var2.getClass()).b(hp1Var2, this);
        }
        return gp1Var;
    }

    public final int hashCode() {
        if (c()) {
            return aq1.c.a(getClass()).h(this);
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int iH = aq1.c.a(getClass()).h(this);
        this.zza = iH;
        return iH;
    }

    public final void j() {
        aq1.c.a(getClass()).a(this);
        k();
    }

    public final void k() {
        this.zzd &= Integer.MAX_VALUE;
    }

    public final void m() {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final String toString() {
        String string = super.toString();
        char[] cArr = wp1.a;
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(string);
        wp1.c(this, sb, 0);
        return sb.toString();
    }
}
