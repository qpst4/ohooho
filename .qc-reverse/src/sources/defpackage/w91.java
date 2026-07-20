package defpackage;

import android.graphics.Point;
import com.quickcursor.android.services.CursorAccessibilityService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class w91 {
    public final hj0 a;
    public final CursorAccessibilityService b;
    public int d;
    public int e;
    public List g;
    public f91 h;
    public u91 i;
    public h91 j;
    public g1 k;
    public final ArrayList f = new ArrayList();
    public b61 c = null;

    public w91(hj0 hj0Var, CursorAccessibilityService cursorAccessibilityService) {
        this.a = hj0Var;
        this.b = cursorAccessibilityService;
    }

    public final boolean a(i3 i3Var, boolean z) {
        g1 g1Var = this.k;
        if (g1Var != null && !g1Var.l()) {
            g1 g1Var2 = this.k;
            if (g1Var2.d == i3Var) {
                g1Var2.b(false, z);
                s91 s91Var = r60.q;
                if (s91Var == null) {
                    return true;
                }
                s91Var.f();
                r60.q = null;
                r60.c.invalidate();
                return true;
            }
        }
        return false;
    }

    public final void b(int i, int i2) {
        g1 g1Var = this.k;
        if (g1Var != null && g1Var.h == f1.triggered) {
            g1Var.f();
            return;
        }
        if ((g1Var == null || g1Var.h != f1.ended) && this.i != null) {
            s91 s91Var = r60.q;
            if (s91Var != null) {
                s91Var.f = i;
                s91Var.g = i2;
                r60.c.invalidate();
            }
            double degrees = (((Math.toDegrees(Math.atan2(i2 - this.e, i - this.d)) + 360.0d) - ((double) this.i.c)) + 90.0d) % 360.0d;
            double dN = xy0.n(this.d, i, this.e, i2);
            Iterator it = this.i.a.iterator();
            h91 h91Var = null;
            while (true) {
                boolean z = false;
                if (!it.hasNext()) {
                    break;
                }
                v91 v91Var = (v91) it.next();
                u91 u91Var = this.i;
                if (dN > u91Var.d && dN < u91Var.e && degrees >= v91Var.e && degrees < v91Var.d) {
                    z = true;
                }
                v91Var.f = z;
                if (z) {
                    h91Var = v91Var.g;
                }
            }
            for (v91 v91Var2 : this.i.b) {
                u91 u91Var2 = this.i;
                boolean z2 = dN > ((double) u91Var2.e) && dN < ((double) u91Var2.f) && degrees >= ((double) v91Var2.e) && degrees < ((double) v91Var2.d);
                v91Var2.f = z2;
                if (z2) {
                    h91Var = v91Var2.g;
                }
            }
            if (this.j != h91Var) {
                this.j = h91Var;
                if (h91Var == null) {
                    this.k = null;
                    b61 b61Var = this.c;
                    if (b61Var != null) {
                        b61Var.d();
                        this.c = null;
                        return;
                    }
                    return;
                }
                g1 g1Var2 = this.k;
                if (g1Var2 == null || !g1Var2.l()) {
                    b61 b61Var2 = this.c;
                    if (b61Var2 != null) {
                        b61Var2.d();
                        this.c = null;
                    }
                    h91 h91Var2 = this.j;
                    i3 i3VarC = this.h.b().c();
                    Point point = this.a.r;
                    g1 g1VarA = g1.a(this.b, h91Var2, 128, i3VarC, null);
                    g1VarA.c = point;
                    this.k = g1VarA;
                    if (g1VarA instanceof zm0) {
                        return;
                    }
                    f01.R(z91.a(this.h.b()));
                    a(i3.instant, false);
                    g1 g1Var3 = this.k;
                    if (g1Var3 == null || this.c != null || g1Var3.d != i3.delayed || g1Var3.l()) {
                        return;
                    }
                    b61 b61Var3 = new b61(new lk0(19, this), this.h.b().d());
                    this.c = b61Var3;
                    b61Var3.c();
                }
            }
        }
    }
}
