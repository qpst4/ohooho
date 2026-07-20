package defpackage;

import android.content.SharedPreferences;
import android.graphics.Point;
import android.view.WindowManager;
import com.quickcursor.android.activities.settings.InputDispatcherBug;
import com.quickcursor.android.drawables.globals.EdgeActionsDrawable;
import com.quickcursor.android.services.CursorAccessibilityService;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ar {
    public static final Point q = new Point(-1, -1);
    public final WindowManager a;
    public final CursorAccessibilityService b;
    public m81 e;
    public b61 f;
    public final vw g;
    public final q71 h;
    public final m71 i;
    public final e81 j;
    public pq0 k;
    public b61 l;
    public boolean m;
    public o21 n;
    public boolean o;
    public final Point c = new Point(0, 0);
    public final Point d = new Point(0, 0);
    public final sp1 p = new sp1(17, this);

    public ar(CursorAccessibilityService cursorAccessibilityService) {
        this.b = cursorAccessibilityService;
        this.a = (WindowManager) cursorAccessibilityService.getSystemService("window");
        this.g = new vw(this, cursorAccessibilityService);
        this.h = new q71(this, cursorAccessibilityService);
        this.i = new m71(this, cursorAccessibilityService);
        this.j = new e81(this, cursorAccessibilityService);
    }

    public abstract void A(f91 f91Var, boolean z);

    public abstract void B();

    public final void C() {
        b61 b61Var = this.f;
        if (b61Var != null) {
            b61Var.d();
        }
    }

    public abstract void D();

    public final void E(int i, int i2, db dbVar, db dbVar2) {
        float f;
        e81 e81Var;
        g1 g1Var;
        g1 g1Var2;
        g1 g1Var3;
        g1 g1Var4;
        g1 g1Var5;
        lw lwVarB;
        i3 i3VarValueOf;
        f1 f1Var;
        f1 f1Var2;
        f1 f1Var3;
        f1 f1Var4;
        f1 f1Var5;
        f1 f1Var6;
        if (this.m) {
            return;
        }
        int iD = (int) (((((double) (i - dbVar.d())) / ((double) dbVar.f())) * ((double) dbVar2.f())) + ((double) dbVar2.d()));
        int iE = (int) (((((double) (i2 - dbVar.e())) / ((double) dbVar.c())) * ((double) dbVar2.c())) + ((double) dbVar2.e()));
        int iMax = Math.max(0, Math.min(ey0.c(), iD));
        int iMax2 = Math.max(0, Math.min(ey0.b(), iE));
        Point point = this.c;
        point.set(iMax, iMax2);
        this.d.set(iD, iE);
        if (this.k != pq0.b) {
            this.e.c(point);
        }
        vw vwVar = this.g;
        ar arVar = vwVar.c;
        vwVar.o = false;
        if (vwVar.l || arVar.s()) {
            f = 1.0f;
        } else {
            Point point2 = arVar.c;
            Point point3 = arVar.d;
            int i3 = point2.x - point3.x;
            int i4 = point2.y - point3.y;
            if (arVar.r() && vwVar.d && (Math.abs(i3) > vwVar.e || Math.abs(i4) > vwVar.e)) {
                arVar.n();
                vwVar.c();
            } else {
                g1 g1Var6 = arVar.g.k;
                if ((g1Var6 == null || (f1Var6 = g1Var6.h) == f1.initial || f1Var6 == f1.ended) && (((g1Var = (e81Var = arVar.j).f) == null || (f1Var5 = g1Var.h) == f1.initial || f1Var5 == f1.ended) && (((g1Var2 = e81Var.g) == null || (f1Var4 = g1Var2.h) == f1.initial || f1Var4 == f1.ended) && (((g1Var3 = e81Var.h) == null || (f1Var3 = g1Var3.h) == f1.initial || f1Var3 == f1.ended) && (((g1Var4 = arVar.i.g) == null || (f1Var2 = g1Var4.h) == f1.initial || f1Var2 == f1.ended) && ((g1Var5 = arVar.h.j) == null || (f1Var = g1Var5.h) == f1.initial || f1Var == f1.ended)))))) {
                    vwVar.o = true;
                    if (!vwVar.f.g().booleanValue() || i3 <= vwVar.e) {
                        f = 1.0f;
                        lwVarB = null;
                    } else {
                        f = 1.0f;
                        lwVarB = vwVar.f.b((int) Math.ceil(point2.y / ((ey0.b() * 1.0f) / r4.e())));
                    }
                    if (vwVar.h.g().booleanValue() && i3 < vwVar.e * (-1)) {
                        lwVarB = vwVar.h.b((int) Math.ceil(point2.y / ((ey0.b() * f) / r4.e())));
                    }
                    if (vwVar.g.g().booleanValue() && i4 > vwVar.e && (lwVarB == null || i4 > Math.abs(i3))) {
                        lwVarB = vwVar.g.b((int) Math.ceil(point2.x / ((ey0.c() * f) / r4.e())));
                    }
                    if (vwVar.i.g().booleanValue() && i4 < vwVar.e * (-1) && (lwVarB == null || Math.abs(i4) > Math.abs(i3))) {
                        lwVarB = vwVar.i.b((int) Math.ceil(point2.x / ((ey0.c() * f) / r4.e())));
                    }
                    if (vwVar.j != lwVarB) {
                        vwVar.j = lwVarB;
                        b61 b61Var = vwVar.m;
                        if (b61Var != null) {
                            b61Var.d();
                            vwVar.m = null;
                        }
                        if (lwVarB == null) {
                            vwVar.k = null;
                        } else {
                            g1 g1Var7 = vwVar.k;
                            if (g1Var7 == null || !g1Var7.l()) {
                                CursorAccessibilityService cursorAccessibilityService = vwVar.a;
                                lw lwVar = vwVar.j;
                                pn0 pn0VarT = pn0.t();
                                pn0VarT.getClass();
                                try {
                                    i3VarValueOf = i3.valueOf(oq0.d((SharedPreferences) pn0VarT.d, oq0.u0));
                                } catch (Exception unused) {
                                    i3VarValueOf = i3.valueOf((String) oq0.u0.b);
                                }
                                g1 g1VarA = g1.a(cursorAccessibilityService, lwVar, 1, i3VarValueOf, null);
                                g1VarA.a = point2;
                                g1VarA.b = point3;
                                vwVar.k = g1VarA;
                                if (!(g1VarA instanceof zm0)) {
                                    f01.R(oq0.a((SharedPreferences) pn0.t().d, oq0.n0));
                                    if (oq0.a((SharedPreferences) pn0.t().d, oq0.m0)) {
                                        r60.h(oq0.c((SharedPreferences) pn0.t().d, oq0.r0), point2.x, point2.y);
                                    }
                                }
                                vwVar.a(i3.instant);
                                g1 g1Var8 = vwVar.k;
                                if (g1Var8 != null && vwVar.m == null && g1Var8.d == i3.delayed && !g1Var8.l()) {
                                    b61 b61Var2 = new b61(new c(23, vwVar), vwVar.n);
                                    vwVar.m = b61Var2;
                                    b61Var2.c();
                                }
                            }
                        }
                    }
                } else {
                    g1 g1Var9 = vwVar.k;
                    if ((g1Var9 == null || g1Var9.h != f1.scheduled) && g1Var9 != null && g1Var9.h == f1.triggered) {
                        g1Var9.f();
                    }
                }
            }
            f = 1.0f;
        }
        e81 e81Var2 = this.j;
        g1 g1Var10 = e81Var2.f;
        if (g1Var10 != null && g1Var10.h == f1.triggered) {
            g1Var10.f();
        }
        g1 g1Var11 = e81Var2.g;
        if (g1Var11 != null && g1Var11.h == f1.triggered) {
            g1Var11.f();
        }
        g1 g1Var12 = e81Var2.h;
        if (g1Var12 != null && g1Var12.h == f1.triggered) {
            g1Var12.f();
        }
        g1 g1Var13 = this.h.j;
        if (g1Var13 != null && g1Var13.h == f1.triggered) {
            g1Var13.f();
        }
        g1 g1Var14 = this.i.g;
        if (g1Var14 != null && g1Var14.h == f1.triggered) {
            g1Var14.f();
        }
        boolean z = r() || (vwVar.o && vwVar.k == null);
        yq yqVar = r60.i;
        yqVar.b = iMax;
        yqVar.c = iMax2;
        if (r60.m != null && r60.l == null && !yqVar.a()) {
            o81 o81Var = r60.m;
            CopyOnWriteArrayList copyOnWriteArrayList = o81Var.e;
            long jCurrentTimeMillis = System.currentTimeMillis();
            t51 t51Var = o81Var.j;
            if (t51Var == null) {
                t51 t51Var2 = new t51(iMax, iMax2, jCurrentTimeMillis);
                o81Var.i = t51Var2;
                copyOnWriteArrayList.add(t51Var2);
                t51 t51Var3 = new t51(iMax, iMax2, jCurrentTimeMillis);
                o81Var.j = t51Var3;
                copyOnWriteArrayList.add(t51Var3);
            } else {
                long j = jCurrentTimeMillis - t51Var.c;
                t51 t51Var4 = o81Var.i;
                double dHypot = Math.hypot(t51Var4.a - t51Var.a, t51Var4.b - t51Var.b);
                n81 n81Var = o81Var.b;
                if (j <= n81Var.a || dHypot <= n81Var.c || (j <= n81Var.b && dHypot <= n81Var.d)) {
                    t51 t51Var5 = o81Var.j;
                    t51Var5.a = iMax;
                    t51Var5.b = iMax2;
                } else {
                    o81Var.i = o81Var.j;
                    t51 t51Var6 = new t51(iMax, iMax2, jCurrentTimeMillis);
                    o81Var.j = t51Var6;
                    copyOnWriteArrayList.add(t51Var6);
                }
            }
        }
        EdgeActionsDrawable edgeActionsDrawable = r60.n;
        if (edgeActionsDrawable != null) {
            edgeActionsDrawable.g(z);
            if (edgeActionsDrawable.l) {
                Point point4 = new Point(iD, iE);
                for (sw swVar : edgeActionsDrawable.k) {
                    i9 i9Var = swVar.d;
                    int i5 = point4.x;
                    Point point5 = (Point) i9Var.c;
                    int i6 = point5.x;
                    int i7 = point4.y;
                    int i8 = point5.y;
                    Point point6 = (Point) i9Var.d;
                    int i9 = point6.x;
                    int i10 = i9 - i6;
                    int i11 = point6.y;
                    int i12 = i11 - i8;
                    int i13 = (i12 * i12) + (i10 * i10);
                    float f2 = i13 != 0 ? ((((i7 - i8) * i12) + ((i5 - i6) * i10)) * f) / i13 : -1.0f;
                    if (f2 >= 0.0f) {
                        if (f2 > f) {
                            i8 = i11;
                            i6 = i9;
                        } else {
                            i6 = (int) ((i10 * f2) + i6);
                            i8 = (int) ((f2 * i12) + i8);
                        }
                    }
                    Point point7 = new Point(i6, i8);
                    float fHypot = (float) Math.hypot(point4.x - point7.x, point4.y - point7.y);
                    float f3 = edgeActionsDrawable.e;
                    if (fHypot > f3) {
                        swVar.k = 0.0f;
                    } else {
                        swVar.k = (100.0f - ((fHypot / f3) * 100.0f)) / 100.0f;
                    }
                }
            }
        }
        r60.c.invalidate();
    }

    public abstract void F();

    public abstract void G(Point point);

    public void a(dm0 dm0Var) {
        F();
        v(dm0Var, this.k == pq0.d);
    }

    public void c(int i, int i2) {
        u(i, i2);
    }

    public final boolean j() {
        g1 g1Var = this.g.k;
        if (g1Var != null && g1Var.h == f1.triggered) {
            return true;
        }
        e81 e81Var = this.j;
        g1 g1Var2 = e81Var.f;
        if (g1Var2 != null && g1Var2.h == f1.triggered) {
            return true;
        }
        g1 g1Var3 = e81Var.g;
        if (g1Var3 != null && g1Var3.h == f1.triggered) {
            return true;
        }
        g1 g1Var4 = e81Var.h;
        if (g1Var4 != null && g1Var4.h == f1.triggered) {
            return true;
        }
        g1 g1Var5 = this.i.g;
        if (g1Var5 != null && g1Var5.h == f1.triggered) {
            return true;
        }
        g1 g1Var6 = this.h.j;
        return g1Var6 != null && g1Var6.h == f1.triggered;
    }

    public abstract boolean k();

    public final void l() {
        Point point = this.c;
        int i = point.x;
        int i2 = point.y;
        if (this.o) {
            this.e.b(this.p, new j81(i, i2, 2));
        }
        z();
        l60.a(this.b, i, i2, true);
        f01.R(oq0.a((SharedPreferences) pn0.t().d, oq0.U));
        if (oq0.a((SharedPreferences) pn0.t().d, oq0.V)) {
            r60.i.f();
            r60.c.invalidate();
            r60.h(oq0.c((SharedPreferences) pn0.t().d, oq0.W), i, i2);
        }
    }

    public abstract void m();

    public final void n() {
        F();
        o21 o21Var = this.n;
        if (o21Var != null) {
            this.n = null;
            o21Var.m();
        }
    }

    public abstract void o();

    public void p(dm0 dm0Var) {
        this.m = true;
        this.l.d();
        vw vwVar = this.g;
        vwVar.b();
        vwVar.c();
        this.h.b();
        m71 m71Var = this.i;
        g1 g1Var = m71Var.g;
        if (g1Var != null && g1Var.d()) {
            m71Var.g.c();
            m71Var.g = null;
        }
        e81 e81Var = this.j;
        g1 g1Var2 = e81Var.f;
        if (g1Var2 != null && g1Var2.d()) {
            e81Var.f.c();
            e81Var.f = null;
        }
        g1 g1Var3 = e81Var.g;
        if (g1Var3 != null && g1Var3.d()) {
            e81Var.g.c();
            e81Var.g = null;
        }
        g1 g1Var4 = e81Var.h;
        if (g1Var4 != null && g1Var4.d()) {
            e81Var.h.c();
            e81Var.h = null;
        }
        if (r()) {
            n();
        }
    }

    public final void q() {
        C();
        if (oq0.a((SharedPreferences) pn0.t().d, oq0.P)) {
            this.f = new b61(new zq(this, 0), oq0.c((SharedPreferences) pn0.t().d, oq0.Q));
        } else {
            this.f = null;
        }
    }

    public final boolean r() {
        return this.n != null;
    }

    public boolean s() {
        return false;
    }

    public final void t(f91 f91Var, int i, int i2) {
        this.m = false;
        this.g.c();
        C();
        this.l.d();
        E(i, i2, f91Var.f(), f91Var.c());
        m81 m81Var = this.e;
        boolean z = m81Var.y;
        m81Var.z = z;
        int i3 = z ? m81Var.l + m81Var.m : m81Var.k;
        int i4 = i3 / 2;
        m81Var.p = i4;
        WindowManager.LayoutParams layoutParams = m81Var.d;
        layoutParams.width = i3;
        layoutParams.height = i3;
        layoutParams.x = i - i4;
        layoutParams.y = i2 - i4;
        layoutParams.flags = 262952;
        try {
            m81Var.b.updateViewLayout(m81Var, layoutParams);
        } catch (Exception unused) {
        }
        B();
        f01.R(oq0.a((SharedPreferences) pn0.t().d, oq0.a0));
    }

    public final void u(int i, int i2) {
        si0.a("onTrackerSecondTap: " + i + ", " + i2);
        if (j()) {
            return;
        }
        if (this.b.f.isKeyguardLocked()) {
            si0.a("isKeyguardLocked true");
            return;
        }
        if (i <= 0 || i2 <= 0 || i >= ey0.c() || i2 >= ey0.b()) {
            si0.a("onTrackerSecondTap coordinates outside of screen size. Probably OnePlus device full of Android bugs. No margin protection for second tap in this case.");
        } else {
            int i3 = dn.O1;
            if (i < i3 || i > ey0.c() - i3 || i2 < i3 || i2 > ey0.b() - i3) {
                si0.a("SECOND_TAP_TRACKER_ACTION_THRESHOLD: " + i3);
                return;
            }
        }
        vw vwVar = this.g;
        g1 g1Var = vwVar.k;
        if (g1Var != null && g1Var.h == f1.scheduled) {
            g1Var.b(true, true);
        } else if (!vwVar.a(i3.onRelease)) {
            vwVar.b();
        }
        e81 e81Var = this.j;
        e81Var.b();
        this.h.d(this.e.s == 4);
        this.i.a();
        e81Var.h = e81Var.c(e81Var.e, 16, i3.instant, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v(defpackage.dm0 r5, boolean r6) {
        /*
            r4 = this;
            if (r5 == 0) goto L23
            float r0 = r5.a
            float r0 = java.lang.Math.abs(r0)
            float r1 = r5.b
            float r1 = java.lang.Math.abs(r1)
            float r1 = r1 + r0
            float r0 = defpackage.ey0.f
            float r1 = r1 / r0
            r0 = 1050253722(0x3e99999a, float:0.3)
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 <= 0) goto L23
            boolean r0 = r4.j()
            if (r0 != 0) goto L23
            r4.p(r5)
            return
        L23:
            vw r5 = r4.g
            g1 r0 = r5.k
            r1 = 1
            if (r0 == 0) goto L35
            f1 r2 = r0.h
            f1 r3 = defpackage.f1.scheduled
            if (r2 != r3) goto L35
            r0.b(r1, r1)
        L33:
            r5 = r1
            goto L42
        L35:
            i3 r0 = defpackage.i3.onRelease
            boolean r0 = r5.a(r0)
            if (r0 == 0) goto L3e
            goto L33
        L3e:
            boolean r5 = r5.b()
        L42:
            if (r5 != 0) goto La2
            e81 r5 = r4.j
            boolean r5 = r5.b()
            if (r5 != 0) goto La2
            m71 r5 = r4.i
            boolean r5 = r5.a()
            if (r5 != 0) goto La2
            m81 r5 = r4.e
            int r5 = r5.s
            r0 = 4
            if (r5 != r0) goto L5c
            goto L5d
        L5c:
            r1 = 0
        L5d:
            q71 r5 = r4.h
            boolean r5 = r5.d(r1)
            if (r5 != 0) goto La2
            pn0 r5 = defpackage.pn0.t()
            java.lang.Object r5 = r5.d
            android.content.SharedPreferences r5 = (android.content.SharedPreferences) r5
            oq0 r0 = defpackage.oq0.d1
            boolean r5 = defpackage.oq0.a(r5, r0)
            if (r5 == 0) goto L85
            java.lang.String r5 = "inputDispatcherBugOnTrackerRelease triggered."
            defpackage.si0.a(r5)
            s4 r5 = new s4
            r0 = 3
            r5.<init>(r0)
            r0 = 10
            defpackage.b61.b(r5, r0)
        L85:
            if (r6 == 0) goto La2
            boolean r5 = r4.k()
            if (r5 == 0) goto La2
            boolean r5 = r4.m
            if (r5 != 0) goto La2
            b61 r5 = r4.l
            long r0 = r5.b
            r2 = 0
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 != 0) goto L9f
            r4.l()
            goto La2
        L9f:
            r5.a()
        La2:
            boolean r5 = r4.r()
            if (r5 != 0) goto Lc2
            pn0 r5 = defpackage.pn0.t()
            java.lang.Object r5 = r5.d
            android.content.SharedPreferences r5 = (android.content.SharedPreferences) r5
            oq0 r6 = defpackage.oq0.U0
            boolean r5 = defpackage.oq0.a(r5, r6)
            if (r5 == 0) goto Lbb
            defpackage.r60.b()
        Lbb:
            b61 r4 = r4.f
            if (r4 == 0) goto Lc2
            r4.a()
        Lc2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ar.v(dm0, boolean):void");
    }

    public abstract void w(int i);

    public void x() {
        i3 i3VarValueOf;
        i3 i3VarValueOf2;
        this.o = InputDispatcherBug.G();
        this.k = pn0.t().j();
        this.l = new b61(new zq(this, 1), oq0.c((SharedPreferences) pn0.t().d, oq0.L));
        vw vwVar = this.g;
        vwVar.j = null;
        vwVar.k = null;
        vwVar.m = null;
        vwVar.d = oq0.a((SharedPreferences) pn0.t().d, oq0.f0);
        vwVar.e = (int) oq0.b((SharedPreferences) pn0.t().d, oq0.k0);
        vwVar.n = oq0.c((SharedPreferences) pn0.t().d, oq0.l0);
        xw xwVar = xw.e;
        vwVar.f = xwVar.d("leftEdgeBar");
        vwVar.g = xwVar.d("topEdgeBar");
        vwVar.h = xwVar.d("rightEdgeBar");
        vwVar.i = xwVar.d("bottomEdgeBar");
        vwVar.l = (vwVar.f.g().booleanValue() || vwVar.g.g().booleanValue() || vwVar.h.g().booleanValue() || vwVar.i.g().booleanValue()) ? false : true;
        q71 q71Var = this.h;
        q71Var.getClass();
        s71 s71Var = s71.e;
        q71Var.c = s71Var.c;
        q71Var.d = s71Var.d;
        q71Var.e = oq0.a((SharedPreferences) pn0.t().d, oq0.G0);
        pn0 pn0VarT = pn0.t();
        pn0VarT.getClass();
        try {
            i3VarValueOf = i3.valueOf(oq0.d((SharedPreferences) pn0VarT.d, oq0.F0));
        } catch (Exception unused) {
            i3VarValueOf = i3.valueOf((String) oq0.F0.b);
        }
        q71Var.f = i3VarValueOf;
        q71Var.l = oq0.c((SharedPreferences) pn0.t().d, oq0.H0);
        pn0 pn0VarT2 = pn0.t();
        pn0VarT2.getClass();
        try {
            i3VarValueOf2 = i3.valueOf(oq0.d((SharedPreferences) pn0VarT2.d, oq0.J0));
        } catch (Exception unused2) {
            i3VarValueOf2 = i3.valueOf((String) oq0.J0.b);
        }
        q71Var.g = i3VarValueOf2;
        q71Var.m = oq0.c((SharedPreferences) pn0.t().d, oq0.K0);
        m71 m71Var = this.i;
        m71Var.getClass();
        m71Var.d = s71Var.c;
        m71Var.e = s71Var.d;
        m71Var.c = oq0.a((SharedPreferences) pn0.t().d, oq0.G0);
        e81 e81Var = this.j;
        e81Var.getClass();
        e81Var.c = pn0.t().w();
        e81Var.d = pn0.t().s();
        e81Var.e = pn0.t().y();
    }

    public abstract void y();

    public final void z() {
        this.e.r = true;
    }
}
