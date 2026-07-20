package defpackage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class w50 {
    public int a = 0;
    public cd1 b = cd1.d;
    public int c = -1;

    public static void a(w50 w50Var) throws ic0 {
        if (w50Var.b(Boolean.TRUE, 1, null) == null) {
            throw new ic0(new cm().getMessage());
        }
    }

    public static Object f(Method method, w50 w50Var, Object... objArr) {
        try {
            return method.invoke(w50Var, objArr);
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

    public static sr0 h(sr0 sr0Var) {
        int size = sr0Var.c.size();
        int i = size == 0 ? 10 : size * 2;
        ArrayList arrayList = sr0Var.c;
        if (i < arrayList.size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList2 = new ArrayList(i);
        arrayList2.addAll(arrayList);
        return new sr0(arrayList2);
    }

    public static w50 i(w50 w50Var, zh zhVar) throws ic0 {
        w00 w00VarA = w00.a();
        byte[] bArr = zhVar.c;
        int iD = zhVar.d();
        int size = zhVar.size();
        cl clVar = new cl(bArr, iD, size, true);
        try {
            if (size < 0) {
                throw new ic0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            int i = clVar.f + iD + size;
            if (i > Integer.MAX_VALUE) {
                throw new ic0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            clVar.g = i;
            clVar.j();
            w50 w50VarJ = j(w50Var, clVar, w00VarA);
            clVar.a(0);
            a(w50VarJ);
            a(w50VarJ);
            return w50VarJ;
        } catch (ic0 e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static w50 j(w50 w50Var, cl clVar, w00 w00Var) throws ic0 {
        w50 w50Var2 = (w50) w50Var.b(null, 5, null);
        try {
            w50Var2.b(clVar, 3, w00Var);
            w50Var2.g();
            return w50Var2;
        } catch (RuntimeException e) {
            if (e.getCause() instanceof ic0) {
                throw ((ic0) e.getCause());
            }
            throw e;
        }
    }

    public abstract Object b(Object obj, int i, Object obj2);

    public final q50 c() {
        return (q50) b(null, 8, null);
    }

    public abstract int d();

    public final String e(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((w50) b(null, 7, null)).getClass().isInstance(obj)) {
            return false;
        }
        try {
            n(s50.a, (w50) obj);
            return true;
        } catch (r50 unused) {
            return false;
        }
    }

    public final void g() {
        b(null, 4, null);
        this.b.getClass();
    }

    public final int hashCode() {
        if (this.a == 0) {
            t50 t50Var = new t50();
            t50Var.a = 0;
            n(t50Var, this);
            this.a = t50Var.a;
        }
        return this.a;
    }

    public final p50 k() {
        p50 p50Var = (p50) b(null, 6, null);
        p50Var.d(this);
        return p50Var;
    }

    public final byte[] l() {
        try {
            int iD = d();
            byte[] bArr = new byte[iD];
            dl dlVar = new dl(iD, bArr);
            o(dlVar);
            if (iD - dlVar.c == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            zy.l(e("byte array"), e);
            return null;
        }
    }

    public final zh m() {
        try {
            int iD = d();
            zh zhVar = zh.d;
            byte[] bArr = new byte[iD];
            dl dlVar = new dl(iD, bArr);
            o(dlVar);
            if (iD - dlVar.c == 0) {
                return new zh(bArr);
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            zy.l(e("ByteString"), e);
            return null;
        }
    }

    public final void n(v50 v50Var, w50 w50Var) {
        b(v50Var, 2, w50Var);
        this.b = v50Var.g(this.b, w50Var.b);
    }

    public abstract void o(dl dlVar);

    public final String toString() {
        String string = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(string);
        lc1.f0(this, sb, 0);
        return sb.toString();
    }
}
