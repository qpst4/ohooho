package defpackage;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class qd0 extends fb1 {
    public static final qd0 a = new qd0();

    private qd0() {
    }

    public static pd0 d(int i, vd0 vd0Var) {
        int iR = l11.r(i);
        if (iR == 5) {
            return new ud0(vd0Var.G());
        }
        if (iR == 6) {
            return new ud0(new sf0(vd0Var.G()));
        }
        if (iR == 7) {
            return new ud0(Boolean.valueOf(vd0Var.y()));
        }
        if (iR == 8) {
            vd0Var.E();
            return sd0.b;
        }
        s1.f("Unexpected token: ".concat(l11.u(i)));
        return null;
    }

    public static void e(ae0 ae0Var, pd0 pd0Var) throws IOException {
        if (pd0Var == null || (pd0Var instanceof sd0)) {
            ae0Var.t();
            return;
        }
        if (pd0Var instanceof ud0) {
            ud0 ud0Var = (ud0) pd0Var;
            Serializable serializable = ud0Var.b;
            if (serializable instanceof Number) {
                ae0Var.A(ud0Var.g());
                return;
            } else if (serializable instanceof Boolean) {
                ae0Var.C(ud0Var.e());
                return;
            } else {
                ae0Var.B(ud0Var.c());
                return;
            }
        }
        if (pd0Var instanceof kd0) {
            ae0Var.g();
            ArrayList arrayList = ((kd0) pd0Var).b;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                e(ae0Var, (pd0) obj);
            }
            ae0Var.m();
            return;
        }
        if (!(pd0Var instanceof td0)) {
            s1.j("Couldn't write ", pd0Var.getClass());
            return;
        }
        ae0Var.h();
        Iterator it = ((xg0) pd0Var.b().b.entrySet()).iterator();
        while (((wg0) it).hasNext()) {
            yg0 yg0VarB = ((wg0) it).b();
            ae0Var.r((String) yg0VarB.getKey());
            e(ae0Var, (pd0) yg0VarB.getValue());
        }
        ae0Var.q();
    }

    @Override // defpackage.fb1
    public final Object b(vd0 vd0Var) throws IOException {
        pd0 kd0Var;
        pd0 kd0Var2;
        if (vd0Var instanceof yd0) {
            yd0 yd0Var = (yd0) vd0Var;
            int I = yd0Var.I();
            if (I == 5 || I == 2 || I == 4 || I == 10) {
                s1.e(l11.u(I), " when reading a JsonElement.", "Unexpected ");
                return null;
            }
            pd0 pd0Var = (pd0) yd0Var.W();
            yd0Var.P();
            return pd0Var;
        }
        int I2 = vd0Var.I();
        int iR = l11.r(I2);
        if (iR == 0) {
            vd0Var.a();
            kd0Var = new kd0();
        } else if (iR != 2) {
            kd0Var = null;
        } else {
            vd0Var.g();
            kd0Var = new td0();
        }
        if (kd0Var == null) {
            return d(I2, vd0Var);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (vd0Var.v()) {
                String strC = kd0Var instanceof td0 ? vd0Var.C() : null;
                int I3 = vd0Var.I();
                int iR2 = l11.r(I3);
                if (iR2 == 0) {
                    vd0Var.a();
                    kd0Var2 = new kd0();
                } else if (iR2 != 2) {
                    kd0Var2 = null;
                } else {
                    vd0Var.g();
                    kd0Var2 = new td0();
                }
                boolean z = kd0Var2 != null;
                if (kd0Var2 == null) {
                    kd0Var2 = d(I3, vd0Var);
                }
                if (kd0Var instanceof kd0) {
                    ((kd0) kd0Var).b.add(kd0Var2);
                } else {
                    ((td0) kd0Var).b.put(strC, kd0Var2);
                }
                if (z) {
                    arrayDeque.addLast(kd0Var);
                    kd0Var = kd0Var2;
                }
            } else {
                if (kd0Var instanceof kd0) {
                    vd0Var.m();
                } else {
                    vd0Var.q();
                }
                if (arrayDeque.isEmpty()) {
                    return kd0Var;
                }
                kd0Var = (pd0) arrayDeque.removeLast();
            }
        }
    }

    @Override // defpackage.fb1
    public final /* bridge */ /* synthetic */ void c(ae0 ae0Var, Object obj) throws IOException {
        e(ae0Var, (pd0) obj);
    }
}
