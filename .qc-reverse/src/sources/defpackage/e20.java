package defpackage;

import android.animation.ObjectAnimator;
import android.content.SharedPreferences;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Point;
import android.view.WindowManager;
import com.quickcursor.android.drawables.globals.trackers.TrackerDrawable;
import com.quickcursor.android.services.CursorAccessibilityService;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class e20 extends ar implements qa1, k81 {
    public final ra1 r;
    public final int s;
    public boolean t;
    public final f91 u;

    public e20(CursorAccessibilityService cursorAccessibilityService) {
        super(cursorAccessibilityService);
        super.x();
        q();
        f91 f91VarD = xv0.d.a().e().d();
        this.u = f91VarD;
        this.s = H(f91VarD.f());
        C();
        try {
            m81 m81Var = this.e;
            if (m81Var != null) {
                m81Var.w.d();
                m81Var.w = new b61(new s4(2), 0L);
                m81Var.b.removeView(m81Var);
            }
        } catch (Exception unused) {
        }
        try {
            ra1 ra1Var = this.r;
            if (ra1Var != null) {
                this.a.removeView(ra1Var);
            }
        } catch (Exception unused2) {
        }
        WindowManager windowManager = this.a;
        CursorAccessibilityService cursorAccessibilityService2 = this.b;
        m81 m81Var2 = new m81(cursorAccessibilityService2, this);
        try {
            windowManager.addView(m81Var2, m81Var2.getLayoutParams());
        } catch (Exception e) {
            si0.b("FloatingCursorManager createTrackerView() exception:" + e.getMessage());
        }
        this.e = m81Var2;
        n3 n3VarB = this.u.b().n().b();
        n3 n3Var = n3.nothing;
        ra1 ra1Var2 = new ra1(cursorAccessibilityService2, this, this.u, n3VarB == n3Var && this.u.b().h().b() == n3Var);
        ra1Var2.setBackgroundColor(oq0.a((SharedPreferences) pn0.t().d, oq0.e) ? wl.f(-256, 75) : 0);
        r60.l(ra1Var2.getPositionX(), ra1Var2.getPositionY());
        r60.h.q();
        r60.c.invalidate();
        try {
            windowManager.addView(ra1Var2, ra1Var2.getLayoutParams());
        } catch (Exception e2) {
            si0.b("FloatingCursorManager createTriggerView() exception:" + e2.getMessage());
        }
        this.r = ra1Var2;
    }

    public static int H(db dbVar) {
        return Math.max(dn.q0, Math.min(dn.r0, (int) (((double) Math.min(dbVar.d(), (ey0.c() - dbVar.f()) - dbVar.d())) / 1.5d)));
    }

    @Override // defpackage.ar
    public final void A(f91 f91Var, boolean z) {
        b61 b61Var;
        db dbVarF = f91Var.f();
        int iF = (dbVarF.f() / 2) + dbVarF.d();
        int iC = (dbVarF.c() / 2) + dbVarF.e();
        this.r.setVisibility(8);
        h(f91Var, iF, iC);
        f(iF, iC);
        f91 f91Var2 = this.u;
        E(iF, iC, f91Var2.f(), f91Var2.c());
        if (!z || (b61Var = this.f) == null) {
            return;
        }
        b61Var.a();
    }

    @Override // defpackage.ar
    public final void B() {
        this.e.d();
        this.e.setVisibility(0);
        xr.M(this.e);
        sr srVar = r60.r;
        if (srVar != null) {
            srVar.e = this.u;
        }
    }

    @Override // defpackage.ar
    public final void F() {
        this.e.d();
        ra1 ra1Var = this.r;
        WindowManager.LayoutParams layoutParams = ra1Var.e;
        if ((layoutParams.flags & 16) == 16) {
            layoutParams.flags = 808;
            ra1Var.b.updateViewLayout(ra1Var, layoutParams);
        }
    }

    @Override // defpackage.ar
    public final void G(Point point) {
        this.e.c(point);
        ra1 ra1Var = this.r;
        WindowManager.LayoutParams layoutParams = ra1Var.e;
        if ((layoutParams.flags & 16) != 16) {
            layoutParams.flags = 824;
            ra1Var.b.updateViewLayout(ra1Var, layoutParams);
        }
    }

    public final void I() {
        if (r() || !this.t) {
            return;
        }
        boolean z = this.e.getPositionX() < this.s;
        ra1 ra1Var = this.r;
        int size = ra1Var.getSize() / 2;
        f91 f91Var = this.u;
        f91Var.h().m(z ? (f91Var.h().f() * (-1)) / 2 : ey0.c() - (f91Var.h().f() / 2));
        f91Var.h().n(this.e.getPositionY() - size);
        f91Var.f().m(z ? f91Var.f().i() : (ey0.c() - f91Var.f().i()) - f91Var.f().f());
        new Thread(new s4(7)).start();
        WindowManager.LayoutParams layoutParams = ra1Var.e;
        f91 f91Var2 = ra1Var.d;
        layoutParams.x = f91Var2.h().d();
        ra1Var.e.y = f91Var2.h().e();
        ra1Var.b.updateViewLayout(ra1Var, ra1Var.e);
        C();
        p(null);
    }

    @Override // defpackage.ar, defpackage.k81
    public final void a(dm0 dm0Var) {
        super.a(dm0Var);
        I();
    }

    @Override // defpackage.qa1
    public final void b(int i, int i2) {
        f91 f91Var = this.u;
        h91 h91VarN = f91Var.b().n();
        i3 i3Var = i3.instant;
        Point point = new Point(i, i2);
        g1 g1VarA = g1.a(this.b, h91VarN, 128, i3Var, null);
        g1VarA.c = point;
        boolean z = false;
        g1VarA.b(false, true);
        if (!(g1VarA instanceof zm0) && !(g1VarA instanceof pa1) && z91.a(f91Var.b())) {
            z = true;
        }
        f01.R(z);
    }

    @Override // defpackage.qa1
    public final void d(dm0 dm0Var, int i, int i2) {
        F();
        pq0 pq0Var = this.k;
        v(dm0Var, pq0Var == pq0.c || pq0Var == pq0.d);
        if (this.m) {
            p(null);
        } else {
            this.r.setVisibility(8);
            b61.b(new c(24, this), 0L);
        }
    }

    @Override // defpackage.k81
    public final void e() {
        int positionX = this.e.getPositionX();
        r60.l(positionX, this.e.getPositionY());
        int positionY = this.e.getPositionY();
        f91 f91Var = this.u;
        E(positionX, positionY, f91Var.f(), f91Var.c());
        int i = this.s;
        boolean z = (positionX < i || positionX > ey0.c() - i) && !r();
        boolean z2 = this.t;
        if (z2 || !z) {
            if (!z2 || z) {
                return;
            }
            this.t = false;
            Point point = this.c;
            r60.e(point.x, point.y);
            r60.g(positionX, this.e.getPositionY(), this.e.z);
            return;
        }
        this.t = true;
        vw vwVar = this.g;
        vwVar.b();
        vwVar.c();
        r60.b();
        r60.h.q();
        r60.c.invalidate();
    }

    @Override // defpackage.qa1
    public final void f(int i, int i2) {
        if (this.m) {
            return;
        }
        m81 m81Var = this.e;
        int i3 = m81Var.p;
        int i4 = i - i3;
        int i5 = i2 - i3;
        WindowManager.LayoutParams layoutParams = m81Var.d;
        layoutParams.x = i4;
        layoutParams.y = i5;
        try {
            m81Var.b.updateViewLayout(m81Var, layoutParams);
        } catch (Exception unused) {
        }
        e();
    }

    @Override // defpackage.qa1
    public final void h(f91 f91Var, int i, int i2) {
        G(ar.q);
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
        this.t = true;
        t(f91Var, i, i2);
    }

    @Override // defpackage.qa1
    public final void i(int i, int i2) {
        ra1 ra1Var = this.r;
        WindowManager windowManager = ra1Var.b;
        windowManager.removeView(ra1Var);
        windowManager.addView(ra1Var, ra1Var.e);
        try {
            WindowManager.LayoutParams layoutParams = ra1Var.e;
            layoutParams.width = ra1Var.m;
            layoutParams.height = ra1Var.n;
            ra1Var.b.updateViewLayout(ra1Var, layoutParams);
            xr.M(ra1Var);
        } catch (Exception unused) {
        }
        f91 f91Var = this.u;
        h91 h91VarH = f91Var.b().h();
        i3 i3Var = i3.instant;
        Point point = new Point(i, i2);
        g1 g1VarA = g1.a(this.b, h91VarH, 128, i3Var, null);
        g1VarA.c = point;
        boolean z = false;
        g1VarA.b(false, false);
        if (!(g1VarA instanceof zm0) && !(g1VarA instanceof pa1) && z91.a(f91Var.b())) {
            z = true;
        }
        f01.R(z);
    }

    @Override // defpackage.ar
    public final boolean k() {
        return !this.t;
    }

    @Override // defpackage.ar
    public final void m() {
        r60.h.l(null);
        r60.i.h();
        r60.c.invalidate();
        C();
        try {
            m81 m81Var = this.e;
            if (m81Var != null) {
                m81Var.w.d();
                m81Var.w = new b61(new s4(2), 0L);
                m81Var.b.removeView(m81Var);
            }
        } catch (Exception unused) {
        }
        try {
            ra1 ra1Var = this.r;
            if (ra1Var != null) {
                this.a.removeView(ra1Var);
            }
        } catch (Exception unused2) {
        }
    }

    @Override // defpackage.ar
    public final void o() {
        p(null);
    }

    @Override // defpackage.ar
    public final void p(dm0 dm0Var) {
        int length;
        Path path;
        super.p(dm0Var);
        C();
        r60.b();
        ra1 ra1Var = this.r;
        int positionX = ra1Var.getPositionX();
        int positionY = ra1Var.getPositionY();
        r60.h.q();
        TrackerDrawable trackerDrawable = r60.h;
        TrackerDrawable.f(trackerDrawable.b);
        if (dm0Var == null) {
            path = new Path();
            path.moveTo(trackerDrawable.i, trackerDrawable.j);
            path.lineTo(positionX, positionY);
            length = 300;
        } else {
            cp0 cp0VarJ = trackerDrawable.j(dm0Var);
            Path path2 = new Path();
            path2.moveTo(trackerDrawable.i, trackerDrawable.j);
            path2.cubicTo(trackerDrawable.i, trackerDrawable.j, ((Integer) cp0VarJ.a).intValue(), ((Integer) cp0VarJ.b).intValue(), positionX, positionY);
            length = (int) ((new PathMeasure(path2, false).getLength() / (Math.abs(dm0Var.b) + Math.abs(dm0Var.a))) * 5.0f);
            path = path2;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(trackerDrawable, "x", "y", path);
        trackerDrawable.b = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(length);
        trackerDrawable.b.setInterpolator(TrackerDrawable.J);
        trackerDrawable.b.start();
        r60.c.invalidate();
        sr srVar = r60.r;
        if (srVar != null) {
            srVar.e = null;
        }
        m81 m81Var = this.e;
        WindowManager.LayoutParams layoutParams = m81Var.d;
        if ((layoutParams.flags & 16) != 16) {
            layoutParams.flags = 262968;
            m81Var.b.updateViewLayout(m81Var, layoutParams);
        }
        this.e.setVisibility(8);
        ra1Var.setVisibility(0);
        xr.M(ra1Var);
    }

    @Override // defpackage.ar
    public final boolean s() {
        return this.t;
    }

    @Override // defpackage.ar
    public final void w(int i) {
        if (this.r != null) {
            int iC = i - oq0.c((SharedPreferences) pn0.t().d, oq0.o);
            if ((this.r.getSize() / 2) + this.r.getPositionY() > iC) {
                this.r.setTemporarilyVerticalMargin(iC);
                if (this.r.getVisibility() == 0) {
                    r60.l(this.r.getPositionX(), this.r.getPositionY());
                }
            }
        }
    }

    @Override // defpackage.ar
    public final void y() {
        ra1 ra1Var = this.r;
        if (ra1Var != null) {
            ra1Var.a();
            if (this.r.getVisibility() == 0) {
                r60.l(this.r.getPositionX(), this.r.getPositionY());
            }
        }
    }

    @Override // defpackage.ar
    public final void D() {
    }

    @Override // defpackage.qa1
    public final void g(f91 f91Var, int i, int i2) {
    }
}
