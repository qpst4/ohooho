package defpackage;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class yd0 extends vd0 {
    public static final xd0 u = new xd0();
    public static final Object v = new Object();
    public Object[] q;
    public int r;
    public String[] s;
    public int[] t;

    @Override // defpackage.vd0
    public final int A() {
        int I = I();
        if (I != 7 && I != 6) {
            zy.k("Expected ", l11.u(7), " but was ", l11.u(I), U());
            return 0;
        }
        ud0 ud0Var = (ud0) W();
        int iIntValue = ud0Var.b instanceof Number ? ud0Var.g().intValue() : Integer.parseInt(ud0Var.c());
        X();
        int i = this.r;
        if (i > 0) {
            int[] iArr = this.t;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return iIntValue;
    }

    @Override // defpackage.vd0
    public final long B() {
        int I = I();
        if (I != 7 && I != 6) {
            zy.k("Expected ", l11.u(7), " but was ", l11.u(I), U());
            return 0L;
        }
        ud0 ud0Var = (ud0) W();
        long jLongValue = ud0Var.b instanceof Number ? ud0Var.g().longValue() : Long.parseLong(ud0Var.c());
        X();
        int i = this.r;
        if (i > 0) {
            int[] iArr = this.t;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return jLongValue;
    }

    @Override // defpackage.vd0
    public final String C() {
        return V(false);
    }

    @Override // defpackage.vd0
    public final void E() {
        S(9);
        X();
        int i = this.r;
        if (i > 0) {
            int[] iArr = this.t;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // defpackage.vd0
    public final String G() {
        int I = I();
        if (I != 6 && I != 7) {
            zy.k("Expected ", l11.u(6), " but was ", l11.u(I), U());
            return null;
        }
        String strC = ((ud0) X()).c();
        int i = this.r;
        if (i > 0) {
            int[] iArr = this.t;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return strC;
    }

    @Override // defpackage.vd0
    public final int I() {
        if (this.r == 0) {
            return 10;
        }
        Object objW = W();
        if (objW instanceof Iterator) {
            boolean z = this.q[this.r - 2] instanceof td0;
            Iterator it = (Iterator) objW;
            if (!it.hasNext()) {
                return z ? 4 : 2;
            }
            if (z) {
                return 5;
            }
            Y(it.next());
            return I();
        }
        if (objW instanceof td0) {
            return 3;
        }
        if (objW instanceof kd0) {
            return 1;
        }
        if (objW instanceof ud0) {
            Serializable serializable = ((ud0) objW).b;
            if (serializable instanceof String) {
                return 6;
            }
            if (serializable instanceof Boolean) {
                return 8;
            }
            if (serializable instanceof Number) {
                return 7;
            }
            throw new AssertionError();
        }
        if (objW instanceof sd0) {
            return 9;
        }
        if (objW == v) {
            s1.f("JsonReader is closed");
            return 0;
        }
        throw new ej0("Custom JsonElement subclass " + objW.getClass().getName() + " is not supported");
    }

    @Override // defpackage.vd0
    public final void P() {
        int iR = l11.r(I());
        if (iR == 1) {
            m();
            return;
        }
        if (iR != 9) {
            if (iR == 3) {
                q();
                return;
            }
            if (iR == 4) {
                V(true);
                return;
            }
            X();
            int i = this.r;
            if (i > 0) {
                int[] iArr = this.t;
                int i2 = i - 1;
                iArr[i2] = iArr[i2] + 1;
            }
        }
    }

    public final void S(int i) {
        if (I() == i) {
            return;
        }
        zy.k("Expected ", l11.u(i), " but was ", l11.u(I()), U());
    }

    public final String T(boolean z) {
        StringBuilder sb = new StringBuilder("$");
        int i = 0;
        while (true) {
            int i2 = this.r;
            if (i >= i2) {
                return sb.toString();
            }
            Object[] objArr = this.q;
            Object obj = objArr[i];
            if (obj instanceof kd0) {
                i++;
                if (i < i2 && (objArr[i] instanceof Iterator)) {
                    int i3 = this.t[i];
                    if (z && i3 > 0 && (i == i2 - 1 || i == i2 - 2)) {
                        i3--;
                    }
                    sb.append('[');
                    sb.append(i3);
                    sb.append(']');
                }
            } else if ((obj instanceof td0) && (i = i + 1) < i2 && (objArr[i] instanceof Iterator)) {
                sb.append('.');
                String str = this.s[i];
                if (str != null) {
                    sb.append(str);
                }
            }
            i++;
        }
    }

    public final String U() {
        return " at path ".concat(T(false));
    }

    public final String V(boolean z) {
        S(5);
        Map.Entry entry = (Map.Entry) ((Iterator) W()).next();
        String str = (String) entry.getKey();
        this.s[this.r - 1] = z ? "<skipped>" : str;
        Y(entry.getValue());
        return str;
    }

    public final Object W() {
        return this.q[this.r - 1];
    }

    public final Object X() {
        Object[] objArr = this.q;
        int i = this.r - 1;
        this.r = i;
        Object obj = objArr[i];
        objArr[i] = null;
        return obj;
    }

    public final void Y(Object obj) {
        int i = this.r;
        Object[] objArr = this.q;
        if (i == objArr.length) {
            int i2 = i * 2;
            this.q = Arrays.copyOf(objArr, i2);
            this.t = Arrays.copyOf(this.t, i2);
            this.s = (String[]) Arrays.copyOf(this.s, i2);
        }
        Object[] objArr2 = this.q;
        int i3 = this.r;
        this.r = i3 + 1;
        objArr2[i3] = obj;
    }

    @Override // defpackage.vd0
    public final void a() {
        S(1);
        Y(((kd0) W()).b.iterator());
        this.t[this.r - 1] = 0;
    }

    @Override // defpackage.vd0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.q = new Object[]{v};
        this.r = 1;
    }

    @Override // defpackage.vd0
    public final void g() {
        S(3);
        Y(((xg0) ((td0) W()).b.entrySet()).iterator());
    }

    @Override // defpackage.vd0
    public final void m() {
        S(2);
        X();
        X();
        int i = this.r;
        if (i > 0) {
            int[] iArr = this.t;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // defpackage.vd0
    public final void q() {
        S(4);
        this.s[this.r - 1] = null;
        X();
        X();
        int i = this.r;
        if (i > 0) {
            int[] iArr = this.t;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // defpackage.vd0
    public final String s() {
        return T(false);
    }

    @Override // defpackage.vd0
    public final String toString() {
        return yd0.class.getSimpleName().concat(U());
    }

    @Override // defpackage.vd0
    public final String u() {
        return T(true);
    }

    @Override // defpackage.vd0
    public final boolean v() {
        int I = I();
        return (I == 4 || I == 2 || I == 10) ? false : true;
    }

    @Override // defpackage.vd0
    public final boolean y() {
        S(8);
        boolean zE = ((ud0) X()).e();
        int i = this.r;
        if (i > 0) {
            int[] iArr = this.t;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return zE;
    }

    @Override // defpackage.vd0
    public final double z() throws ej0 {
        int I = I();
        if (I != 7 && I != 6) {
            zy.k("Expected ", l11.u(7), " but was ", l11.u(I), U());
            return 0.0d;
        }
        double dF = ((ud0) W()).f();
        if (this.p != 1 && (Double.isNaN(dF) || Double.isInfinite(dF))) {
            throw new ej0("JSON forbids NaN and infinities: " + dF);
        }
        X();
        int i = this.r;
        if (i > 0) {
            int[] iArr = this.t;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return dF;
    }
}
