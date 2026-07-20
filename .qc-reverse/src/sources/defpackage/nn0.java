package defpackage;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class nn0 extends fb1 {
    public static final mn0 c = new mn0(1);
    public final i70 a;
    public final int b;

    public nn0(i70 i70Var, int i) {
        this.a = i70Var;
        this.b = i;
    }

    @Override // defpackage.fb1
    public final Object b(vd0 vd0Var) throws IOException {
        Object arrayList;
        Serializable arrayList2;
        int I = vd0Var.I();
        int iR = l11.r(I);
        if (iR == 0) {
            vd0Var.a();
            arrayList = new ArrayList();
        } else if (iR != 2) {
            arrayList = null;
        } else {
            vd0Var.g();
            arrayList = new zg0(true);
        }
        if (arrayList == null) {
            return d(I, vd0Var);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (vd0Var.v()) {
                String strC = arrayList instanceof Map ? vd0Var.C() : null;
                int I2 = vd0Var.I();
                int iR2 = l11.r(I2);
                if (iR2 == 0) {
                    vd0Var.a();
                    arrayList2 = new ArrayList();
                } else if (iR2 != 2) {
                    arrayList2 = null;
                } else {
                    vd0Var.g();
                    arrayList2 = new zg0(true);
                }
                boolean z = arrayList2 != null;
                if (arrayList2 == null) {
                    arrayList2 = d(I2, vd0Var);
                }
                if (arrayList instanceof List) {
                    ((List) arrayList).add(arrayList2);
                } else {
                    ((Map) arrayList).put(strC, arrayList2);
                }
                if (z) {
                    arrayDeque.addLast(arrayList);
                    arrayList = arrayList2;
                }
            } else {
                if (arrayList instanceof List) {
                    vd0Var.m();
                } else {
                    vd0Var.q();
                }
                if (arrayDeque.isEmpty()) {
                    return arrayList;
                }
                arrayList = arrayDeque.removeLast();
            }
        }
    }

    @Override // defpackage.fb1
    public final void c(ae0 ae0Var, Object obj) throws IOException {
        if (obj == null) {
            ae0Var.t();
            return;
        }
        Class<?> cls = obj.getClass();
        i70 i70Var = this.a;
        i70Var.getClass();
        fb1 fb1VarG = i70Var.g(new mc1(cls));
        if (!(fb1VarG instanceof nn0)) {
            fb1VarG.c(ae0Var, obj);
        } else {
            ae0Var.h();
            ae0Var.q();
        }
    }

    public final Serializable d(int i, vd0 vd0Var) {
        int iR = l11.r(i);
        if (iR == 5) {
            return vd0Var.G();
        }
        if (iR == 6) {
            return qq0.b(this.b, vd0Var);
        }
        if (iR == 7) {
            return Boolean.valueOf(vd0Var.y());
        }
        if (iR == 8) {
            vd0Var.E();
            return null;
        }
        s1.f("Unexpected token: ".concat(l11.u(i)));
        return null;
    }
}
