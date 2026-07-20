package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Build;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.WindowManager;
import com.quickcursor.android.drawables.globals.trackers.TrackerDrawable;
import com.quickcursor.android.services.CursorAccessibilityService;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class m81 extends View implements View.OnTouchListener {
    public final j71 A;
    public boolean B;
    public boolean C;
    public final WindowManager b;
    public final k81 c;
    public final WindowManager.LayoutParams d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public final int k;
    public final int l;
    public final int m;
    public final ArrayList n;
    public j71 o;
    public int p;
    public final int q;
    public boolean r;
    public int s;
    public l81 t;
    public j81 u;
    public final b61 v;
    public b61 w;
    public final b61 x;
    public boolean y;
    public boolean z;

    public m81(Context context, k81 k81Var) {
        super(context);
        if (Build.VERSION.SDK_INT >= 29) {
            setForceDarkAllowed(false);
        }
        this.b = (WindowManager) context.getSystemService("window");
        int iC = oq0.c((SharedPreferences) pn0.t().d, oq0.O0);
        int iC2 = oq0.c((SharedPreferences) pn0.t().d, oq0.Q0);
        this.q = (int) oq0.b((SharedPreferences) pn0.t().d, oq0.M);
        this.A = pn0.t().w();
        final int i = 1;
        this.B = pn0.t().j() == pq0.d || pn0.t().s().b() == n3.nothing;
        this.k = (int) oq0.b((SharedPreferences) pn0.t().d, oq0.D);
        oq0.b((SharedPreferences) pn0.t().d, oq0.v0);
        this.l = (int) oq0.b((SharedPreferences) pn0.t().d, oq0.x0);
        this.m = (int) oq0.b((SharedPreferences) pn0.t().d, oq0.z0);
        this.y = oq0.a((SharedPreferences) pn0.t().d, oq0.L0);
        s71 s71Var = s71.e;
        ArrayList arrayList = new ArrayList(s71Var.c);
        this.n = arrayList;
        arrayList.add(s71Var.d);
        b61 b61Var = this.w;
        if (b61Var != null) {
            b61Var.d();
        }
        this.w = new b61(new Runnable(this) { // from class: i81
            public final /* synthetic */ m81 c;

            {
                this.c = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i2 = i;
                m81 m81Var = this.c;
                switch (i2) {
                    case 0:
                        m81Var.setVisibility(8);
                        break;
                    case 1:
                        if (m81Var.s == 1) {
                            m81Var.s = 3;
                            ar arVar = (ar) m81Var.c;
                            if (!arVar.j()) {
                                e81 e81Var = arVar.j;
                                e81Var.getClass();
                                e81Var.f = e81Var.c(oq0.a((SharedPreferences) pn0.t().d, oq0.e1) ? new j71(n3.inputDispatcherBug, null) : e81Var.c, 4, i3.instant, false);
                                break;
                            }
                        }
                        break;
                    case 2:
                        m81Var.C = false;
                        ar arVar2 = (ar) m81Var.c;
                        if (arVar2.k != pq0.d) {
                            arVar2.l();
                        }
                        break;
                    default:
                        l81 l81Var = m81Var.t;
                        if (l81Var != null) {
                            l81Var.j(m81Var.u);
                        }
                        break;
                }
            }
        }, iC);
        final int i2 = 2;
        this.x = new b61(new Runnable(this) { // from class: i81
            public final /* synthetic */ m81 c;

            {
                this.c = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i22 = i2;
                m81 m81Var = this.c;
                switch (i22) {
                    case 0:
                        m81Var.setVisibility(8);
                        break;
                    case 1:
                        if (m81Var.s == 1) {
                            m81Var.s = 3;
                            ar arVar = (ar) m81Var.c;
                            if (!arVar.j()) {
                                e81 e81Var = arVar.j;
                                e81Var.getClass();
                                e81Var.f = e81Var.c(oq0.a((SharedPreferences) pn0.t().d, oq0.e1) ? new j71(n3.inputDispatcherBug, null) : e81Var.c, 4, i3.instant, false);
                                break;
                            }
                        }
                        break;
                    case 2:
                        m81Var.C = false;
                        ar arVar2 = (ar) m81Var.c;
                        if (arVar2.k != pq0.d) {
                            arVar2.l();
                        }
                        break;
                    default:
                        l81 l81Var = m81Var.t;
                        if (l81Var != null) {
                            l81Var.j(m81Var.u);
                        }
                        break;
                }
            }
        }, iC2);
        final int i3 = 3;
        this.v = new b61(new Runnable(this) { // from class: i81
            public final /* synthetic */ m81 c;

            {
                this.c = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i22 = i3;
                m81 m81Var = this.c;
                switch (i22) {
                    case 0:
                        m81Var.setVisibility(8);
                        break;
                    case 1:
                        if (m81Var.s == 1) {
                            m81Var.s = 3;
                            ar arVar = (ar) m81Var.c;
                            if (!arVar.j()) {
                                e81 e81Var = arVar.j;
                                e81Var.getClass();
                                e81Var.f = e81Var.c(oq0.a((SharedPreferences) pn0.t().d, oq0.e1) ? new j71(n3.inputDispatcherBug, null) : e81Var.c, 4, i3.instant, false);
                                break;
                            }
                        }
                        break;
                    case 2:
                        m81Var.C = false;
                        ar arVar2 = (ar) m81Var.c;
                        if (arVar2.k != pq0.d) {
                            arVar2.l();
                        }
                        break;
                    default:
                        l81 l81Var = m81Var.t;
                        if (l81Var != null) {
                            l81Var.j(m81Var.u);
                        }
                        break;
                }
            }
        }, 25L);
        this.z = false;
        this.C = false;
        yb0.w();
        this.p = this.k / 2;
        int i4 = this.k;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(i4, i4, 2032, 262952, -3);
        this.d = layoutParams;
        layoutParams.gravity = 51;
        layoutParams.x = 0;
        layoutParams.y = 0;
        try {
            Class<?> cls = Class.forName("android.view.WindowManager$LayoutParams");
            Field field = cls.getField("privateFlags");
            field.setInt(layoutParams, cls.getField("PRIVATE_FLAG_NO_MOVE_ANIMATION").getInt(layoutParams) | field.getInt(layoutParams));
        } catch (Exception e) {
            si0.a("noAnimationFix issue: " + e);
        }
        if (Build.MANUFACTURER.equalsIgnoreCase("google") && Build.MODEL.toLowerCase().contains("fold")) {
            si0.a("Pixel Fold hack.");
            b61.b(new Runnable(this) { // from class: i81
                public final /* synthetic */ m81 c;

                {
                    this.c = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    int i22 = i;
                    m81 m81Var = this.c;
                    switch (i22) {
                        case 0:
                            m81Var.setVisibility(8);
                            break;
                        case 1:
                            if (m81Var.s == 1) {
                                m81Var.s = 3;
                                ar arVar = (ar) m81Var.c;
                                if (!arVar.j()) {
                                    e81 e81Var = arVar.j;
                                    e81Var.getClass();
                                    e81Var.f = e81Var.c(oq0.a((SharedPreferences) pn0.t().d, oq0.e1) ? new j71(n3.inputDispatcherBug, null) : e81Var.c, 4, i3.instant, false);
                                    break;
                                }
                            }
                            break;
                        case 2:
                            m81Var.C = false;
                            ar arVar2 = (ar) m81Var.c;
                            if (arVar2.k != pq0.d) {
                                arVar2.l();
                            }
                            break;
                        default:
                            l81 l81Var = m81Var.t;
                            if (l81Var != null) {
                                l81Var.j(m81Var.u);
                            }
                            break;
                    }
                }
            }, 0L);
        } else {
            setVisibility(8);
        }
        setLayoutParams(this.d);
        setBackgroundColor(oq0.a((SharedPreferences) pn0.t().d, oq0.e) ? dn.l0 : 0);
        this.c = k81Var;
        setOnTouchListener(this);
    }

    public final void a(boolean z) {
        this.z = z;
        if (z) {
            r60.c(getPositionX(), getPositionY());
            TrackerDrawable trackerDrawable = r60.h;
            trackerDrawable.r(trackerDrawable.i, trackerDrawable.j);
            r60.c.invalidate();
        } else {
            r60.h.g();
            r60.c.invalidate();
        }
        int positionX = getPositionX();
        int positionY = getPositionY();
        int i = this.z ? this.l + this.m : this.k;
        int i2 = i / 2;
        int i3 = this.p - i2;
        this.p = i2;
        WindowManager.LayoutParams layoutParams = this.d;
        layoutParams.width = i;
        layoutParams.height = i;
        layoutParams.x = positionX - i2;
        layoutParams.y = positionY - i2;
        try {
            this.b.updateViewLayout(this, layoutParams);
            float f = i3;
            this.e -= f;
            this.f -= f;
        } catch (Exception unused) {
        }
    }

    public final void b(l81 l81Var, j81 j81Var) {
        si0.a("startInputDispatcherBugDetector(" + j81Var + ")");
        this.t = l81Var;
        this.u = j81Var;
        this.v.a();
    }

    public final void c(Point point) {
        int i;
        int i2;
        int i3;
        WindowManager.LayoutParams layoutParams = this.d;
        int i4 = layoutParams.flags;
        if ((i4 & 16) == 16) {
            return;
        }
        int i5 = point.x;
        if ((i5 == -1 || (i5 >= (i = layoutParams.x) && i5 <= i + layoutParams.width && (i2 = point.y) >= (i3 = layoutParams.y) && i2 <= i3 + layoutParams.height)) && (i4 & 16) != 16) {
            layoutParams.flags = 262968;
            this.b.updateViewLayout(this, layoutParams);
        }
    }

    public final void d() {
        WindowManager.LayoutParams layoutParams = this.d;
        if ((layoutParams.flags & 16) == 16) {
            layoutParams.flags = 262952;
            this.b.updateViewLayout(this, layoutParams);
        }
    }

    public int getPositionX() {
        return this.d.x + this.p;
    }

    public int getPositionY() {
        return this.d.y + this.p;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        e1 e1Var;
        int actionMasked = motionEvent.getActionMasked();
        k81 k81Var = this.c;
        if (actionMasked == 5) {
            int action = (motionEvent.getAction() & 65280) >> 8;
            int i = Build.VERSION.SDK_INT;
            ((ar) k81Var).u(i >= 29 ? (int) motionEvent.getRawX(action) : ey0.c() / 2, i >= 29 ? (int) motionEvent.getRawY(action) : ey0.b() / 2);
            return true;
        }
        this.i = motionEvent.getRawX();
        this.j = motionEvent.getRawY();
        b61 b61Var = this.x;
        dm0 dm0Var = null;
        if (actionMasked == 0) {
            this.o = null;
            if (this.z) {
                j71 j71Var = (j71) this.n.get(r60.h.k((int) this.i, (int) r8));
                this.o = j71Var;
                if (j71Var.b() == n3.nothing) {
                    this.o = null;
                }
            }
            this.r = false;
            this.s = 1;
            this.e = motionEvent.getX();
            this.f = motionEvent.getY();
            float f = this.i;
            this.g = f;
            float f2 = this.j;
            this.h = f2;
            if (this.o != null) {
                this.s = 5;
                int i2 = (int) f;
                int i3 = (int) f2;
                ar arVar = (ar) k81Var;
                arVar.C();
                m71 m71Var = arVar.i;
                g1 g1Var = m71Var.g;
                if (g1Var != null && g1Var.d()) {
                    m71Var.g.c();
                    m71Var.g = null;
                }
                r60.h.r(i2, i3);
                r60.c.invalidate();
                int i4 = r60.h.H;
                m71Var.h = i4;
                j71 j71Var2 = i4 == m71Var.d.size() ? m71Var.e : (j71) m71Var.d.get(m71Var.h);
                m71Var.f = j71Var2.j() && !xr.y(j71Var2.b().requirements, 16384);
                CursorAccessibilityService cursorAccessibilityService = m71Var.b;
                i3 i3Var = i3.instant;
                ar arVar2 = m71Var.a;
                Point point = arVar2.c;
                Point point2 = arVar2.d;
                g1 g1VarA = g1.a(cursorAccessibilityService, j71Var2, 2, i3Var, i3Var);
                g1VarA.a = point;
                g1VarA.b = point2;
                m71Var.g = g1VarA;
                if (g1VarA.e == e1.continuousAfterPositioned) {
                    f01.R(m71Var.c);
                    m71Var.g.b(true, false);
                }
            } else {
                ar arVar3 = (ar) k81Var;
                Point point3 = arVar3.c;
                vw vwVar = arVar3.g;
                g1 g1Var2 = vwVar.k;
                if (g1Var2 != null && g1Var2.h == f1.positioned) {
                    g1Var2.b(true, false);
                } else if (g1Var2 == null || !g1Var2.l() || vwVar.k.h == f1.ended) {
                    vwVar.c();
                }
                g1 g1Var3 = arVar3.i.g;
                if (g1Var3 != null && g1Var3.h == f1.positioned) {
                    g1Var3.b(true, false);
                }
                g1 g1Var4 = arVar3.j.g;
                if (g1Var4 != null && g1Var4.h == f1.positioned) {
                    g1Var4.b(true, false);
                }
                g1 g1Var5 = arVar3.h.j;
                if (g1Var5 != null && g1Var5.h == f1.positioned) {
                    g1Var5.b(true, false);
                }
                arVar3.G(point3);
                arVar3.C();
                arVar3.l.d();
                if (oq0.a((SharedPreferences) pn0.t().d, oq0.U0)) {
                    r60.e(point3.x, point3.y);
                }
                if (this.A.b() != n3.nothing) {
                    this.w.a();
                }
                if (!this.B) {
                    b61Var.d();
                }
            }
            VelocityTracker velocityTracker = yb0.m;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
        if (yb0.m != null) {
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            motionEventObtain.offsetLocation(motionEventObtain.getRawX() - motionEventObtain.getX(), motionEventObtain.getRawY() - motionEventObtain.getY());
            yb0.m.addMovement(motionEventObtain);
        }
        int i5 = this.q;
        if (actionMasked == 2) {
            float f3 = this.i;
            int i6 = (int) (f3 - this.e);
            float f4 = this.j;
            int i7 = (int) (f4 - this.f);
            double dN = xy0.n(this.g, f3, this.h, f4);
            int i8 = this.s;
            if ((i8 == 1 || i8 == 3) && dN > i5) {
                this.s = 2;
                this.w.d();
            }
            int i9 = this.s;
            if (i9 == 4) {
                int i10 = (int) this.i;
                int i11 = (int) this.j;
                q71 q71Var = ((ar) k81Var).h;
                q71Var.getClass();
                r60.h.r(i10, i11);
                r60.c.invalidate();
                int i12 = r60.h.H;
                if (i12 != q71Var.i) {
                    q71Var.i = i12;
                    q71Var.c();
                }
                this.e = motionEvent.getX();
                this.f = motionEvent.getY();
            } else if (i9 == 5) {
                int i13 = (int) this.i;
                int i14 = (int) this.j;
                g1 g1Var6 = ((ar) k81Var).i.g;
                if (g1Var6 != null && g1Var6.h == f1.triggered && ((e1Var = g1Var6.e) == e1.continuous || e1Var == e1.continuousAfterPositioned)) {
                    g1Var6.f();
                } else {
                    r60.h.r(i13, i14);
                    r60.c.invalidate();
                }
            } else {
                WindowManager.LayoutParams layoutParams = this.d;
                layoutParams.x = i6;
                layoutParams.y = i7;
                try {
                    this.b.updateViewLayout(this, layoutParams);
                } catch (Exception unused) {
                }
                k81Var.e();
            }
        } else {
            if (actionMasked == 1 || actionMasked == 3) {
                this.w.d();
                if (actionMasked == 1) {
                    double dN2 = xy0.n(this.g, this.i, this.h, this.j);
                    if (this.s != 1 || dN2 > i5) {
                        this.C = false;
                    } else if (this.B) {
                        ar arVar4 = (ar) k81Var;
                        if (arVar4.k != pq0.d) {
                            arVar4.l();
                        }
                    } else if (this.C) {
                        this.C = false;
                        b61Var.d();
                        ar arVar5 = (ar) k81Var;
                        if (!arVar5.j()) {
                            e81 e81Var = arVar5.j;
                            e81Var.g = e81Var.c(e81Var.d, 8, i3.onRelease, true);
                        }
                    } else {
                        this.C = true;
                        b61Var.c();
                    }
                }
                VelocityTracker velocityTracker2 = yb0.m;
                if (velocityTracker2 != null) {
                    velocityTracker2.computeCurrentVelocity(1);
                    VelocityTracker velocityTracker3 = yb0.m;
                    dm0Var = new dm0();
                    dm0Var.a = velocityTracker3.getXVelocity();
                    dm0Var.b = velocityTracker3.getYVelocity();
                }
                k81Var.a(dm0Var);
                return true;
            }
            if (actionMasked == 4) {
                this.w.d();
                b61 b61Var2 = this.v;
                if (b61Var2 != null) {
                    b61Var2.d();
                }
                if (motionEvent.getDeviceId() == 0) {
                    this.r = false;
                    return true;
                }
                if (this.r) {
                    this.r = false;
                    return true;
                }
                ar arVar6 = (ar) k81Var;
                arVar6.getClass();
                if (oq0.a((SharedPreferences) pn0.t().d, oq0.N) && !arVar6.j()) {
                    arVar6.C();
                    arVar6.p(null);
                }
            }
        }
        return true;
    }

    public void setActionsAlwaysVisible(boolean z) {
        this.y = z;
    }
}
