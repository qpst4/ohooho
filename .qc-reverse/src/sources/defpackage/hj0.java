package defpackage;

import android.content.SharedPreferences;
import android.graphics.Point;
import android.view.WindowManager;
import com.quickcursor.android.services.CursorAccessibilityService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class hj0 extends ar implements qa1, k81 {
    public final Point r;
    public final w91 s;
    public ArrayList t;
    public f91 u;
    public f91 v;
    public dm0 w;

    public hj0(CursorAccessibilityService cursorAccessibilityService) {
        super(cursorAccessibilityService);
        this.r = new Point(0, 0);
        w91 w91Var = new w91(this, cursorAccessibilityService);
        this.s = w91Var;
        super.x();
        w91Var.g = xv0.d.a().k();
        ArrayList arrayList = w91Var.f;
        arrayList.clear();
        Iterator it = w91Var.g.iterator();
        while (it.hasNext()) {
            arrayList.add(new u91((f91) it.next()));
        }
        q();
        C();
        H();
        try {
            m81 m81Var = this.e;
            if (m81Var != null) {
                m81Var.w.d();
                m81Var.w = new b61(new s4(2), 0L);
                m81Var.b.removeView(m81Var);
            }
        } catch (Exception unused) {
        }
        WindowManager windowManager = this.a;
        CursorAccessibilityService cursorAccessibilityService2 = this.b;
        H();
        for (f91 f91Var : xv0.d.a().k()) {
            if (f91Var.h().f() == 0 || f91Var.h().c() == 0) {
                si0.a("Skip trigger.");
            } else {
                ra1 ra1Var = new ra1(cursorAccessibilityService2, this, f91Var, false);
                this.t.add(ra1Var);
                try {
                    windowManager.addView(ra1Var, ra1Var.getLayoutParams());
                } catch (Exception e) {
                    si0.b("MarginCursorManager clearAndAddTriggerViews() exception:" + e.getMessage());
                }
            }
        }
        m81 m81Var2 = new m81(cursorAccessibilityService2, this);
        try {
            windowManager.addView(m81Var2, m81Var2.getLayoutParams());
        } catch (Exception e2) {
            si0.b("MarginCursorManager createTrackerView() exception:" + e2.getMessage());
        }
        this.e = m81Var2;
    }

    @Override // defpackage.ar
    public final void A(f91 f91Var, boolean z) {
        b61 b61Var;
        db dbVarF = f91Var.f();
        int iF = (dbVarF.f() / 2) + dbVarF.d();
        int iC = (dbVarF.c() / 2) + dbVarF.e();
        this.u = f91Var;
        I(iF, iC);
        E(iF, iC, this.v.f(), this.v.c());
        if (!z || (b61Var = this.f) == null) {
            return;
        }
        b61Var.a();
    }

    @Override // defpackage.ar
    public final void B() {
        Point point = this.c;
        r60.e(point.x, point.y);
        r60.g(this.e.getPositionX(), this.e.getPositionY(), this.e.z);
        f91 f91Var = this.v;
        sr srVar = r60.r;
        if (srVar != null) {
            srVar.e = f91Var;
        }
        this.e.setVisibility(0);
        xr.M(this.e);
    }

    @Override // defpackage.ar
    public final void D() {
        if (this.t != null) {
            float fC = oq0.c((SharedPreferences) pn0.t().d, oq0.p) / 100.0f;
            ArrayList arrayList = this.t;
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                ((ra1) obj).setTemporarilyThinner(fC);
                int i3 = i + 1;
                jj jjVar = r60.g;
                jjVar.getClass();
                try {
                    ((ea1) jjVar.b.get(i)).d(fC);
                } catch (Exception unused) {
                }
                r60.c.invalidate();
                i = i3;
            }
        }
    }

    @Override // defpackage.ar
    public final void F() {
        this.e.d();
        ArrayList arrayList = this.t;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ra1 ra1Var = (ra1) obj;
            WindowManager.LayoutParams layoutParams = ra1Var.e;
            if ((layoutParams.flags & 16) == 16) {
                layoutParams.flags = 808;
                ra1Var.b.updateViewLayout(ra1Var, layoutParams);
            }
        }
    }

    @Override // defpackage.ar
    public final void G(Point point) {
        this.e.c(point);
        ArrayList arrayList = this.t;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ra1 ra1Var = (ra1) obj;
            WindowManager.LayoutParams layoutParams = ra1Var.e;
            if ((layoutParams.flags & 16) != 16) {
                layoutParams.flags = 824;
                ra1Var.b.updateViewLayout(ra1Var, layoutParams);
            }
        }
    }

    public final void H() {
        ArrayList arrayList = this.t;
        if (arrayList == null || arrayList.isEmpty()) {
            this.t = new ArrayList();
            return;
        }
        ArrayList arrayList2 = this.t;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            try {
                this.a.removeView((ra1) obj);
            } catch (Exception unused) {
            }
        }
        this.t.clear();
    }

    public final void I(int i, int i2) {
        if (r()) {
            vw vwVar = this.g;
            g1 g1Var = vwVar.k;
            if (g1Var != null && g1Var.h == f1.scheduled) {
                g1Var.b(true, true);
            } else if (!vwVar.a(i3.onRelease)) {
                vwVar.b();
            }
            this.j.b();
            this.h.d(this.e.s == 4);
            this.i.a();
            n();
        }
        f91 f91Var = this.u;
        this.v = f91Var;
        t(f91Var, i, i2);
    }

    @Override // defpackage.qa1
    public final void b(int i, int i2) {
        this.r.set(i, i2);
        w91 w91Var = this.s;
        CursorAccessibilityService cursorAccessibilityService = w91Var.b;
        m91 m91VarB = w91Var.h.b();
        List list = z91.a;
        h91 h91VarN = m91VarB.s() ? z91.c : m91VarB.n();
        i3 i3Var = i3.instant;
        Point point = new Point(i, i2);
        g1 g1VarA = g1.a(cursorAccessibilityService, h91VarN, 128, i3Var, null);
        g1VarA.c = point;
        boolean z = false;
        g1VarA.b(false, true);
        if (!(g1VarA instanceof zm0) && !(g1VarA instanceof pa1) && z91.a(w91Var.h.b())) {
            z = true;
        }
        f01.R(z);
    }

    @Override // defpackage.ar, defpackage.qa1
    public final void c(int i, int i2) {
        g1 g1Var = this.s.k;
        if (g1Var instanceof d70) {
            try {
                ((d70) g1Var).k.u(i, i2);
            } catch (Exception unused) {
                si0.b("onSecondTap crash caught.");
            }
        }
    }

    @Override // defpackage.qa1
    public final void d(dm0 dm0Var, int i, int i2) {
        F();
        this.w = dm0Var;
        this.r.set(i, i2);
        w91 w91Var = this.s;
        g1 g1Var = w91Var.k;
        if (g1Var == null || (g1Var instanceof zm0) || (g1Var.d == i3.delayed && !g1Var.l())) {
            w91Var.k = null;
        }
        if (!w91Var.a(i3.onRelease, true)) {
            g1 g1Var2 = w91Var.k;
            if (g1Var2 == null || !g1Var2.d()) {
                w91Var.k = null;
            } else {
                w91Var.k.c();
                w91Var.k = null;
            }
        }
        s91 s91Var = r60.q;
        if (s91Var != null) {
            s91Var.f();
            r60.q = null;
            r60.c.invalidate();
        }
    }

    @Override // defpackage.k81
    public final void e() {
        E(this.e.getPositionX(), this.e.getPositionY(), this.v.f(), this.v.c());
        r60.l(this.e.getPositionX(), this.e.getPositionY());
    }

    @Override // defpackage.qa1
    public final void f(int i, int i2) {
        this.r.set(i, i2);
        this.s.b(i, i2);
    }

    @Override // defpackage.qa1
    public final void g(f91 f91Var, int i, int i2) {
        this.u = f91Var;
        this.r.set(i, i2);
        w91 w91Var = this.s;
        w91Var.h = f91Var;
        w91Var.d = i;
        w91Var.e = i2;
    }

    @Override // defpackage.qa1
    public final void h(f91 f91Var, int i, int i2) {
        G(ar.q);
        this.u = f91Var;
        this.r.set(i, i2);
        w91 w91Var = this.s;
        ArrayList arrayList = w91Var.f;
        try {
            w91Var.i = (u91) arrayList.get(w91Var.g.indexOf(w91Var.h));
        } catch (Exception unused) {
            w91Var.i = (u91) arrayList.get(0);
            si0.b("This might be an issue. onTriggerActionsStart. please email me");
        }
        w91Var.j = null;
        w91Var.k = null;
        f91 f91Var2 = w91Var.h;
        u91 u91Var = w91Var.i;
        int i3 = w91Var.d;
        int i4 = w91Var.e;
        s91 s91Var = (s91) r60.p.get(f91Var2);
        s91 s91Var2 = r60.q;
        if (s91Var != s91Var2) {
            if (s91Var2 != null) {
                s91Var2.f();
            }
            r60.q = s91Var;
        }
        s91 s91Var3 = r60.q;
        if (s91Var3 != null) {
            r60.o = null;
            s91Var3.g(f91Var2, u91Var, i3, i4);
            r60.c.invalidate();
        }
        w91Var.b(i, i2);
    }

    @Override // defpackage.qa1
    public final void i(int i, int i2) {
        this.r.set(i, i2);
        w91 w91Var = this.s;
        CursorAccessibilityService cursorAccessibilityService = w91Var.b;
        m91 m91VarB = w91Var.h.b();
        List list = z91.a;
        h91 h91VarH = m91VarB.s() ? z91.d : m91VarB.h();
        i3 i3Var = i3.instant;
        Point point = w91Var.a.r;
        g1 g1VarA = g1.a(cursorAccessibilityService, h91VarH, 128, i3Var, null);
        g1VarA.c = point;
        w91Var.k = g1VarA;
        w91Var.a(i3Var, false);
        g1 g1Var = w91Var.k;
        g1Var.getClass();
        if (g1Var instanceof zm0) {
            return;
        }
        f01.R(z91.a(w91Var.h.b()));
    }

    @Override // defpackage.ar
    public final boolean k() {
        return true;
    }

    @Override // defpackage.ar
    public final void m() {
        r60.h.l(null);
        r60.i.h();
        r60.c.invalidate();
        C();
        H();
        try {
            m81 m81Var = this.e;
            if (m81Var != null) {
                m81Var.w.d();
                m81Var.w = new b61(new s4(2), 0L);
                m81Var.b.removeView(m81Var);
            }
        } catch (Exception unused) {
        }
    }

    @Override // defpackage.ar
    public final void o() {
        r60.b();
        p(null);
    }

    @Override // defpackage.ar
    public final void p(dm0 dm0Var) {
        super.p(dm0Var);
        C();
        r60.b();
        r60.h.l(dm0Var);
        r60.c.invalidate();
        sr srVar = r60.r;
        if (srVar != null) {
            srVar.e = null;
        }
        this.e.setVisibility(8);
        ArrayList arrayList = this.t;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            xr.M((ra1) obj);
        }
    }

    @Override // defpackage.ar
    public final void w(int i) {
        ra1 ra1Var;
        int iC = i - oq0.c((SharedPreferences) pn0.t().d, oq0.o);
        int iC2 = ey0.c() / 2;
        ArrayList arrayList = this.t;
        int i2 = 0;
        ra1 ra1Var2 = null;
        if (arrayList != null) {
            int size = arrayList.size();
            int i3 = 0;
            ra1Var = null;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                ra1 ra1Var3 = (ra1) obj;
                if (ra1Var3.getLayoutParamsX() <= iC2) {
                    if (ra1Var2 == null || ra1Var3.getLayoutParamsY() < ra1Var2.getLayoutParamsY()) {
                        ra1Var2 = ra1Var3;
                    }
                } else if (ra1Var == null || ra1Var3.getLayoutParamsY() < ra1Var.getLayoutParamsY()) {
                    ra1Var = ra1Var3;
                }
            }
        } else {
            ra1Var = null;
        }
        ArrayList arrayList2 = this.t;
        if (arrayList2 != null) {
            int size2 = arrayList2.size();
            int i4 = 0;
            while (i4 < size2) {
                Object obj2 = arrayList2.get(i4);
                i4++;
                ra1 ra1Var4 = (ra1) obj2;
                int iB = (ra1Var4 == ra1Var2 || ra1Var4 == ra1Var) ? iC : ey0.b() * 2;
                ra1Var4.setTemporarilyVerticalMargin(iB);
                int i5 = i2 + 1;
                jj jjVar = r60.g;
                jjVar.getClass();
                try {
                    ((ea1) jjVar.b.get(i2)).e(Integer.valueOf(iB));
                } catch (Exception unused) {
                }
                r60.c.invalidate();
                i2 = i5;
            }
        }
    }

    @Override // defpackage.ar
    public final void y() {
        ArrayList arrayList = this.t;
        if (arrayList != null) {
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                ((ra1) obj).a();
            }
            ArrayList arrayList2 = r60.g.b;
            int size2 = arrayList2.size();
            while (i < size2) {
                Object obj2 = arrayList2.get(i);
                i++;
                ((ea1) obj2).b();
            }
            r60.c.invalidate();
        }
    }
}
