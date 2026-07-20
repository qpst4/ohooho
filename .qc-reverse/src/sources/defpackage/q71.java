package defpackage;

import android.content.SharedPreferences;
import android.graphics.Point;
import com.quickcursor.android.services.CursorAccessibilityService;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class q71 {
    public final ar a;
    public final CursorAccessibilityService b;
    public List c;
    public j71 d;
    public boolean e;
    public i3 f;
    public i3 g;
    public boolean h;
    public int i;
    public g1 j;
    public b61 k;
    public int l;
    public int m;

    public q71(ar arVar, CursorAccessibilityService cursorAccessibilityService) {
        this.a = arVar;
        this.b = cursorAccessibilityService;
    }

    public final boolean a(i3 i3Var, boolean z) {
        g1 g1Var;
        g1 g1Var2 = this.j;
        if (g1Var2 == null || g1Var2.l() || this.j.d != i3Var) {
            return false;
        }
        b61 b61Var = this.k;
        if (b61Var != null) {
            b61Var.d();
            this.k = null;
        }
        if (!oq0.a((SharedPreferences) pn0.t().d, oq0.L0)) {
            r60.h.g();
            r60.c.invalidate();
        }
        this.j.b(true, z);
        if (this.h && (g1Var = this.j) != null && g1Var.h == f1.ended) {
            this.a.o();
        }
        return true;
    }

    public final boolean b() {
        g1 g1Var = this.j;
        if (g1Var == null || !g1Var.d()) {
            this.j = null;
            return false;
        }
        this.j.c();
        this.j = null;
        if (!this.h) {
            return true;
        }
        this.a.o();
        return true;
    }

    public final void c() {
        g1 g1Var = this.j;
        if (g1Var == null || !g1Var.l()) {
            b61 b61Var = this.k;
            if (b61Var != null) {
                b61Var.d();
                this.k = null;
            }
            boolean z = this.i == this.c.size();
            j71 j71Var = z ? this.d : (j71) this.c.get(this.i);
            this.h = j71Var.j() && !xr.y(j71Var.b().requirements, 16384);
            i3 i3Var = z ? this.g : this.f;
            ar arVar = this.a;
            Point point = arVar.c;
            Point point2 = arVar.d;
            g1 g1VarA = g1.a(this.b, j71Var, 2, i3Var, null);
            g1VarA.a = point;
            g1VarA.b = point2;
            this.j = g1VarA;
            if (g1VarA instanceof zm0) {
                return;
            }
            f01.R(!z && this.e);
            a(i3.instant, false);
            g1 g1Var2 = this.j;
            if (g1Var2 == null || this.k != null || g1Var2.d != i3.delayed || g1Var2.l()) {
                return;
            }
            b61 b61Var2 = new b61(new lk0(14, this), z ? this.m : this.l);
            this.k = b61Var2;
            b61Var2.c();
        }
    }

    public final boolean d(boolean z) {
        g1 g1Var = this.j;
        if (g1Var == null || (g1Var instanceof zm0) || (g1Var.d == i3.delayed && !g1Var.l())) {
            if (z) {
                b61 b61Var = this.k;
                if (b61Var != null) {
                    b61Var.d();
                    this.k = null;
                }
                if (!oq0.a((SharedPreferences) pn0.t().d, oq0.L0)) {
                    r60.h.g();
                    r60.c.invalidate();
                }
            }
            this.j = null;
            return false;
        }
        if (!a(i3.onRelease, true)) {
            return b();
        }
        b61 b61Var2 = this.k;
        if (b61Var2 != null) {
            b61Var2.d();
            this.k = null;
        }
        if (!oq0.a((SharedPreferences) pn0.t().d, oq0.L0)) {
            r60.h.g();
            r60.c.invalidate();
        }
        return true;
    }
}
