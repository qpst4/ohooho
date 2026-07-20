package defpackage;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class uv0 {
    public static final Type MAP_HASH_TYPE = new sv0().b();
    private w4 advancedTriggers;
    private f20 floating;
    private int height;
    private tv0 mode;
    private y01 simpleTriggers;
    private int width;

    public uv0(int i, int i2, tv0 tv0Var, y01 y01Var, w4 w4Var, f20 f20Var) {
        this.width = i;
        this.height = i2;
        this.mode = tv0Var;
        this.simpleTriggers = y01Var;
        this.advancedTriggers = w4Var;
        this.floating = f20Var;
    }

    public static uv0 b(int i, int i2, uv0 uv0Var) {
        float f = (i * 1.0f) / uv0Var.width;
        float f2 = (i2 * 1.0f) / uv0Var.height;
        tv0 tv0Var = uv0Var.mode;
        y01 y01VarA = y01.a(uv0Var, f, f2);
        ArrayList arrayList = new ArrayList();
        Iterator it = uv0Var.simpleTriggers.l().iterator();
        while (it.hasNext()) {
            arrayList.add(f91.a((f91) it.next(), f, f2));
        }
        return new uv0(i, i2, tv0Var, y01VarA, new w4(arrayList), f20.a(uv0Var, f, f2));
    }

    public static uv0 c(int i, int i2) {
        return new uv0(i, i2, tv0.simpleTriggers, y01.b(i, i2), w4.a(i, i2), f20.b(i, i2));
    }

    public final void a() {
        y01 y01Var = this.simpleTriggers;
        ArrayList arrayList = new ArrayList();
        Iterator it = y01Var.l().iterator();
        while (it.hasNext()) {
            arrayList.add(f91.a((f91) it.next(), 1.0f, 1.0f));
        }
        this.advancedTriggers = new w4(arrayList);
    }

    public final w4 d() {
        return this.advancedTriggers;
    }

    public final f20 e() {
        return this.floating;
    }

    public final int f() {
        return this.height;
    }

    public final tv0 g() {
        return this.mode;
    }

    public final float h() {
        int i = this.width;
        int i2 = this.height;
        return Math.max(i, i2) / Math.min(i, i2);
    }

    public final int i() {
        return this.width < this.height ? 1 : 2;
    }

    public final f91 j(Integer num) {
        return q() ? this.simpleTriggers.g(num.intValue()) : this.advancedTriggers.b(num.intValue());
    }

    public final List k() {
        return q() ? this.simpleTriggers.l() : this.advancedTriggers.c();
    }

    public final y01 l() {
        return this.simpleTriggers;
    }

    public final int m() {
        return this.width;
    }

    public final boolean n() {
        return this.mode == tv0.advancedTriggers;
    }

    public final boolean o() {
        return this.mode == tv0.disabled;
    }

    public final boolean p() {
        return this.mode == tv0.floating;
    }

    public final boolean q() {
        return this.mode == tv0.simpleTriggers;
    }

    public final void r() {
        this.advancedTriggers = w4.a(ey0.c(), ey0.b());
    }

    public final void s() {
        this.floating = f20.b(ey0.c(), ey0.b());
    }

    public final void t() {
        this.simpleTriggers = y01.b(ey0.c(), ey0.b());
    }

    public final void u(tv0 tv0Var) {
        this.mode = tv0Var;
    }

    public final String v() {
        return this.width + "x" + this.height;
    }
}
