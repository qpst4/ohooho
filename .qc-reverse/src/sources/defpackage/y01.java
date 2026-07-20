package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class y01 {
    private int cursorAreaSize;
    private int cursorSpeed;
    private int trackerAlign;
    private int trackerDistance;
    private int triggerLength;
    private int triggerPosition;
    private x01 triggerSides;
    private List<f91> triggers;

    public static y01 a(uv0 uv0Var, float f, float f2) {
        ArrayList arrayList = new ArrayList();
        Iterator<f91> it = uv0Var.l().triggers.iterator();
        while (it.hasNext()) {
            arrayList.add(f91.a(it.next(), f, f2));
        }
        y01 y01VarL = uv0Var.l();
        y01 y01Var = new y01();
        y01Var.triggers = arrayList;
        y01Var.triggerPosition = y01VarL.triggerPosition;
        y01Var.triggerLength = y01VarL.triggerLength;
        y01Var.cursorSpeed = y01VarL.cursorSpeed;
        y01Var.cursorAreaSize = y01VarL.cursorAreaSize;
        y01Var.trackerAlign = y01VarL.trackerAlign;
        y01Var.trackerDistance = y01VarL.trackerDistance;
        y01Var.triggerSides = y01VarL.triggerSides;
        return y01Var;
    }

    public static y01 b(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(lc1.G(i, i2).n("Left"));
        arrayList.add(lc1.G(i, i2).n("Right"));
        y01 y01Var = new y01();
        y01Var.triggers = arrayList;
        y01Var.triggerPosition = ey0.d() ? dn.s1 : dn.y1;
        y01Var.triggerLength = dn.t1;
        y01Var.cursorSpeed = dn.u1;
        y01Var.cursorAreaSize = ey0.d() ? dn.v1 : dn.A1;
        y01Var.trackerAlign = ey0.d() ? dn.w1 : dn.B1;
        y01Var.trackerDistance = ey0.d() ? dn.x1 : dn.C1;
        y01Var.triggerSides = x01.valueOf(dn.C2);
        return y01Var;
    }

    public final int c() {
        return this.cursorAreaSize;
    }

    public final int d() {
        return this.cursorSpeed;
    }

    public final int e() {
        return this.trackerAlign;
    }

    public final int f() {
        return this.trackerDistance;
    }

    public final f91 g(int i) {
        try {
            return this.triggers.get(i);
        } catch (Exception unused) {
            return null;
        }
    }

    public final f91 h(String str) {
        return this.triggers.stream().filter(new f2(2, str)).findFirst().orElse(null);
    }

    public final int i() {
        return this.triggerLength;
    }

    public final int j() {
        return this.triggerPosition;
    }

    public final x01 k() {
        return this.triggerSides;
    }

    public final List l() {
        return this.triggers;
    }

    public final void m(int i) {
        this.cursorAreaSize = i;
    }

    public final void n(int i) {
        this.cursorSpeed = i;
    }

    public final void o(int i) {
        this.trackerAlign = i;
    }

    public final void p(int i) {
        this.trackerDistance = i;
    }

    public final void q(int i) {
        this.triggerLength = i;
    }

    public final void r(int i) {
        this.triggerPosition = i;
    }

    public final void s(x01 x01Var) {
        this.triggerSides = x01Var;
    }

    public final void t(ArrayList arrayList) {
        this.triggers = arrayList;
    }
}
