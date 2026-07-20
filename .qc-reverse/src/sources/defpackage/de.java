package defpackage;

import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.quickcursor.android.drawables.globals.progressbar.ProgressBarDrawable;
import com.quickcursor.android.services.CursorAccessibilityService;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class de extends g1 {
    public float A;
    public float B;
    public b61 C;
    public float k;
    public float l;
    public boolean m;
    public boolean n;
    public float o;
    public ce p;
    public be q;
    public float r;
    public float s;
    public float t;
    public Drawable u;
    public long v;
    public long w;
    public int x;
    public int y;
    public int z;

    public de() {
        super(i3.empty, e1.continuous);
        this.u = null;
    }

    @Override // defpackage.g1
    public final void e() {
        if (this.q == be.triggerSwipe) {
            this.B = Math.max(0.0f, Math.min(1.0f, (this.z - this.c.y) / this.t));
        } else if (this.p == ce.horizontal) {
            this.B = Math.max(0.0f, Math.min(1.0f, (this.b.x - this.z) / this.t));
        } else {
            this.B = Math.max(0.0f, Math.min(1.0f, (this.z - this.b.y) / this.t));
        }
        if (this.q == be.relative) {
            float f = this.B;
            if (f == 0.0f) {
                ce ceVar = this.p;
                ce ceVar2 = ce.horizontal;
                int i = this.x;
                Point point = this.b;
                if (ceVar == ceVar2) {
                    this.z = Math.max(i, (int) (point.x - (f * this.t)));
                } else {
                    this.z = Math.min(i, (int) ((f * this.t) + point.y));
                }
            } else if (f == 1.0f) {
                ce ceVar3 = this.p;
                ce ceVar4 = ce.horizontal;
                int i2 = this.x;
                Point point2 = this.b;
                if (ceVar3 == ceVar4) {
                    this.z = Math.min(i2, (int) (point2.x - (f * this.t)));
                } else {
                    this.z = Math.max(i2, (int) ((f * this.t) + point2.y));
                }
            }
        }
        if (this.v == 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.v = jCurrentTimeMillis - 1;
            this.w = jCurrentTimeMillis;
            b61 b61Var = new b61(new c(9, this), 1L);
            this.C = b61Var;
            b61Var.d();
            b61Var.a.run();
        }
    }

    @Override // defpackage.g1
    public void g() {
        float f;
        int i;
        if (this.i == 2 && this.d != i3.onRelease) {
            CursorAccessibilityService.q.o.e.s = 2;
        }
        switch (xy0.q(dn.Y1.intValue(), this.g.get("maxPerc")).intValue()) {
            case 0:
                f = 0.002f;
                break;
            case 1:
                f = 0.004f;
                break;
            case 2:
                f = 0.006f;
                break;
            case 3:
                f = 0.008f;
                break;
            case 4:
                f = 0.01f;
                break;
            case 5:
                f = 0.014f;
                break;
            case 6:
                f = 0.018f;
                break;
            case 7:
                f = 0.022f;
                break;
            case 8:
                f = 0.03f;
                break;
            default:
                f = 1.0f;
                break;
        }
        this.l = f;
        this.n = ((Boolean) this.g.getOrDefault("showBar", Boolean.valueOf(dn.J2))).booleanValue();
        if (this.i == 128) {
            this.m = true;
            this.p = ce.valueOf((String) this.g.getOrDefault("orientation", dn.e2));
            this.q = be.triggerSwipe;
            this.r = xy0.q(dn.g2.intValue(), this.g.get("verticalPosition")).intValue() / 100.0f;
            this.b = new Point(0, 0);
            float fIntValue = ((xy0.q(dn.N2, this.g.get("swipeLength")).intValue() * 5.0f) + 10.0f) / 100.0f;
            si0.b("Swipe length percentage: " + fIntValue);
            this.o = (this.p == ce.horizontal ? ey0.c() : ey0.b()) * fIntValue;
        } else {
            this.m = ((Boolean) this.g.getOrDefault("hideCursor", dn.c2)).booleanValue();
            this.o = 0.0f;
            this.p = ce.valueOf((String) this.g.getOrDefault("orientation", dn.d2));
            this.q = be.valueOf((String) this.g.getOrDefault("mode", dn.f2));
            this.r = xy0.q(dn.g2.intValue(), this.g.get("verticalPosition")).intValue() / 100.0f;
        }
        this.k = xy0.q(dn.a2.intValue(), this.g.get("smoothTime")).intValue() * 1.0f;
        if (this.p == ce.horizontal) {
            int i2 = o80.u;
            float f2 = ProgressBarDrawable.m;
            this.s = (ey0.c() * 0.125f) + f2;
            this.t = (ey0.c() * 0.75f) - (f2 * 2.0f);
            float fM = m();
            this.A = fM;
            this.x = (int) this.s;
            this.y = (int) (this.b.x - (this.t * fM));
            if (this.n) {
                Drawable drawable = this.u;
                boolean z = this.m;
                bk bkVar = r60.a;
                if (z) {
                    r60.i.h();
                }
                r60.j.g(drawable, fM);
                r60.c.invalidate();
            }
        } else {
            float f3 = this.r;
            int i3 = o80.u;
            float fB = ey0.b();
            int i4 = ProgressBarDrawable.o;
            this.s = (fB - (i4 * 10)) * f3;
            this.t = this.q == be.triggerSwipe ? this.o : i4 * 10;
            float fM2 = m();
            this.A = fM2;
            float f4 = this.s;
            float f5 = this.t;
            this.x = (int) (f4 + f5);
            this.y = (int) ((f5 * fM2) + this.b.y);
            if (this.n) {
                float f6 = this.r;
                Drawable drawable2 = this.u;
                boolean z2 = this.m;
                bk bkVar2 = r60.a;
                if (z2) {
                    r60.i.h();
                }
                o80 o80Var = r60.k;
                o80Var.getClass();
                float fB2 = (ey0.b() - (i4 * 10)) * f6;
                float fC = ey0.c();
                float f7 = ProgressBarDrawable.n;
                float f8 = fC - (1.3f * f7);
                RectF rectF = new RectF(f8, fB2, f7 + f8, (i4 * 10) + fB2);
                o80Var.e = rectF;
                o80Var.t = rectF.height() - ProgressBarDrawable.p;
                o80Var.g(drawable2, fM2);
                r60.c.invalidate();
            }
        }
        be beVar = this.q;
        if (beVar == be.absolute) {
            i = this.x;
        } else if (beVar == be.relative) {
            i = this.y;
        } else {
            Point point = this.c;
            i = (int) ((this.A * this.t) + point.y);
        }
        this.z = i;
    }

    @Override // defpackage.g1
    public final void h() {
        b61 b61Var = this.C;
        if (b61Var != null) {
            b61Var.d();
        }
        if (this.n) {
            boolean z = this.q != be.triggerSwipe;
            r60.j.f();
            r60.k.f();
            if (z) {
                r60.i.l();
            }
            r60.c.invalidate();
        }
    }

    public abstract float m();

    public abstract void n(float f);
}
