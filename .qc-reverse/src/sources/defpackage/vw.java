package defpackage;

import com.quickcursor.android.services.CursorAccessibilityService;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class vw {
    public final CursorAccessibilityService a;
    public final lw b = new lw(n3.nothing, null);
    public final ar c;
    public boolean d;
    public int e;
    public dx f;
    public dx g;
    public dx h;
    public dx i;
    public lw j;
    public g1 k;
    public boolean l;
    public b61 m;
    public int n;
    public boolean o;

    public vw(ar arVar, CursorAccessibilityService cursorAccessibilityService) {
        this.c = arVar;
        this.a = cursorAccessibilityService;
    }

    public final boolean a(i3 i3Var) {
        g1 g1Var = this.k;
        if (g1Var != null && !g1Var.l()) {
            g1 g1Var2 = this.k;
            if (g1Var2.d == i3Var) {
                g1Var2.b(false, i3Var == i3.onRelease);
                return true;
            }
        }
        return false;
    }

    public final boolean b() {
        f1 f1Var;
        g1 g1Var = this.k;
        if (g1Var == null || (f1Var = g1Var.h) == f1.initial || f1Var == f1.ended) {
            return false;
        }
        g1Var.c();
        return true;
    }

    public final void c() {
        b61 b61Var = this.m;
        if (b61Var != null) {
            b61Var.d();
            this.m = null;
        }
        this.k = new zm0(true);
        this.j = this.b;
    }
}
