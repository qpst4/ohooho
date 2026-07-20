package defpackage;

import android.content.SharedPreferences;
import android.graphics.Point;
import com.quickcursor.android.services.CursorAccessibilityService;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class e81 {
    public final ar a;
    public final CursorAccessibilityService b;
    public j71 c;
    public j71 d;
    public j71 e;
    public g1 f;
    public g1 g;
    public g1 h;

    public e81(ar arVar, CursorAccessibilityService cursorAccessibilityService) {
        this.a = arVar;
        this.b = cursorAccessibilityService;
    }

    public static boolean a(g1 g1Var) {
        if (g1Var != null && !g1Var.l() && g1Var.d == i3.onRelease) {
            f01.R(oq0.a((SharedPreferences) pn0.t().d, oq0.X));
            g1Var.b(true, true);
            return true;
        }
        if (g1Var == null || !g1Var.d()) {
            return false;
        }
        g1Var.c();
        return true;
    }

    public final boolean b() {
        if (a(this.f)) {
            f1 f1Var = this.f.h;
            if (f1Var != f1.initial && f1Var != f1.ended) {
                return true;
            }
            this.f = null;
            return true;
        }
        if (a(this.g)) {
            f1 f1Var2 = this.g.h;
            if (f1Var2 != f1.initial && f1Var2 != f1.ended) {
                return true;
            }
            this.g = null;
            return true;
        }
        if (!a(this.h)) {
            return false;
        }
        f1 f1Var3 = this.h.h;
        if (f1Var3 != f1.initial && f1Var3 != f1.ended) {
            return true;
        }
        this.h = null;
        return true;
    }

    public final g1 c(j71 j71Var, int i, i3 i3Var, boolean z) {
        if (j71Var.b() == n3.nothing) {
            return null;
        }
        ar arVar = this.a;
        Point point = arVar.c;
        Point point2 = arVar.d;
        g1 g1VarA = g1.a(this.b, j71Var, i, i3Var, i3Var);
        g1VarA.a = point;
        g1VarA.b = point2;
        if (g1VarA.d != i3.onRelease) {
            f01.R(oq0.a((SharedPreferences) pn0.t().d, oq0.X));
            g1VarA.b(true, z);
        }
        return g1VarA;
    }
}
