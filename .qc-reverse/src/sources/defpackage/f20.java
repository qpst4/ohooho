package defpackage;

import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class f20 {
    private int edgeTrackerOpacity;
    private f91 trigger;

    public f20(f91 f91Var) {
        this.trigger = f91Var;
        m91 m91VarB = f91Var.b();
        n3 n3Var = n3.nothing;
        i3 i3Var = i3.empty;
        m91VarB.O(new h91(1, n3Var, null, i3Var));
        this.trigger.b().K(new h91(1, n3Var, null, i3Var));
        this.edgeTrackerOpacity = dn.g1;
    }

    public static f20 a(uv0 uv0Var, float f, float f2) {
        return new f20(f91.a(uv0Var.e().trigger, f, f2));
    }

    public static f20 b(int i, int i2) {
        z01 z01VarA;
        Type type = uv0.MAP_HASH_TYPE;
        if (i < i2) {
            z01VarA = z01.b();
            z01VarA.a = dn.e1;
            z01VarA.b = 8;
        } else {
            z01VarA = z01.a();
            z01VarA.a = dn.e1;
            z01VarA.b = 3;
            z01VarA.f = 2;
            z01VarA.g = 1;
        }
        return new f20(lc1.G(i, i2).o("Floating", z01VarA));
    }

    public final int c() {
        return this.edgeTrackerOpacity;
    }

    public final f91 d() {
        return this.trigger;
    }

    public final void e(int i) {
        this.edgeTrackerOpacity = i;
    }
}
