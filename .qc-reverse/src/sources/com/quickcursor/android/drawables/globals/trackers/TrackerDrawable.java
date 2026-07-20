package com.quickcursor.android.drawables.globals.trackers;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.quickcursor.R;
import defpackage.a81;
import defpackage.b81;
import defpackage.c81;
import defpackage.cp0;
import defpackage.d81;
import defpackage.dm0;
import defpackage.ey0;
import defpackage.f20;
import defpackage.i1;
import defpackage.j71;
import defpackage.l11;
import defpackage.lc1;
import defpackage.oq0;
import defpackage.pn0;
import defpackage.s60;
import defpackage.s71;
import defpackage.si0;
import defpackage.v71;
import defpackage.x71;
import defpackage.xr;
import defpackage.xv0;
import defpackage.xy0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TrackerDrawable extends Drawable implements s60 {
    public static final AccelerateInterpolator I = new AccelerateInterpolator();
    public static final DecelerateInterpolator J = new DecelerateInterpolator();
    public static final DecelerateInterpolator K = new DecelerateInterpolator(1.25f);
    public final Paint A;
    public int B;
    public int C;
    public LinkedList D;
    public int H;
    public ObjectAnimator b;
    public ObjectAnimator c;
    public ObjectAnimator d;
    public ObjectAnimator e;
    public int h;
    public int i;
    public int j;
    public int k;
    public float l;
    public int m;
    public int n;
    public int o;
    public int p;
    public float q;
    public int r;
    public int s;
    public int t;
    public int u;
    public d81 v;
    public boolean w;
    public final Paint x;
    public final Paint y;
    public final Paint z;
    public float f = 0.0f;
    public float g = 0.0f;
    public final RectF E = new RectF();
    public final RectF F = new RectF();
    public final Path G = new Path();

    public TrackerDrawable() {
        Paint paint = new Paint(1);
        this.x = paint;
        paint.setStrokeWidth(0.0f);
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        Paint paint2 = new Paint(1);
        this.y = paint2;
        paint2.setStrokeWidth(0.0f);
        paint2.setStyle(style);
        Paint paint3 = new Paint(1);
        this.z = paint3;
        paint3.setStyle(Paint.Style.STROKE);
        Paint paint4 = new Paint(1);
        this.A = paint4;
        paint4.setStrokeWidth(0.0f);
        paint4.setStyle(style);
    }

    public static void f(Animator animator) {
        if (animator != null) {
            animator.cancel();
        }
    }

    public static TrackerDrawable n(int i) {
        Bitmap bitmapV;
        switch (l11.r(i)) {
            case 0:
                return new a81();
            case 1:
                return new b81();
            case 2:
                return new c81();
            case 3:
                return new x71(lc1.v(R.drawable.tracker_design_fingerprint1), false, true);
            case 4:
                return new x71(lc1.v(R.drawable.tracker_design_flower1), true, false);
            case 5:
                return new x71(lc1.v(R.drawable.tracker_design_flower2), true, false);
            case 6:
                return new x71(lc1.v(R.drawable.tracker_design_flower3), true, false);
            case 7:
                return new x71(lc1.v(R.drawable.tracker_design_airplane1), false, true);
            case 8:
                return new x71(lc1.v(R.drawable.tracker_design_airplane2), false, true);
            case 9:
                return new x71(lc1.v(R.drawable.tracker_design_airplane3), true, false);
            case 10:
                return new x71(lc1.v(R.drawable.tracker_design_android), false, true);
            case 11:
                return new x71(lc1.v(R.drawable.tracker_design_donut), true, false);
            case 12:
                return new x71(lc1.v(R.drawable.tracker_design_sports1), true, false);
            case 13:
                return new x71(lc1.v(R.drawable.tracker_design_sports2), true, false);
            case 14:
                return new x71(lc1.v(R.drawable.tracker_design_sports3), true, false);
            case 15:
                return new x71(lc1.v(R.drawable.tracker_design_yin_yang), true, false);
            case 16:
                return new x71(lc1.v(R.drawable.tracker_design_cd), true, false);
            case 17:
                return new x71(lc1.v(R.drawable.tracker_design_floppy_disk), true, false);
            case 18:
                return new x71(lc1.v(R.drawable.tracker_design_ghost), true, false);
            case 19:
                return new x71(lc1.v(R.drawable.tracker_design_watermelon), true, false);
            case 20:
                pn0 pn0VarT = pn0.t();
                pn0VarT.getClass();
                try {
                    bitmapV = xr.h(oq0.d((SharedPreferences) pn0VarT.d, oq0.C));
                    break;
                } catch (Exception e) {
                    si0.b("getTrackerDesignCustomBitmap error: " + e);
                }
                if (bitmapV == null) {
                    bitmapV = lc1.v(R.drawable.tracker_design_quick_cursor);
                }
                return new x71(bitmapV, true, false);
            default:
                throw new IncompatibleClassChangeError();
        }
    }

    @Override // defpackage.s60
    public final boolean a() {
        return this.h <= 0 || this.g == 0.0f;
    }

    @Override // defpackage.s60
    public final boolean c() {
        ObjectAnimator objectAnimator = this.c;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            return true;
        }
        ObjectAnimator objectAnimator2 = this.d;
        if (objectAnimator2 != null && objectAnimator2.isStarted()) {
            return true;
        }
        ObjectAnimator objectAnimator3 = this.b;
        if (objectAnimator3 != null && objectAnimator3.isStarted()) {
            return true;
        }
        ObjectAnimator objectAnimator4 = this.e;
        return objectAnimator4 != null && objectAnimator4.isStarted();
    }

    @Override // android.graphics.drawable.Drawable, defpackage.s60
    public final void draw(Canvas canvas) {
        d81 d81Var;
        Drawable drawable;
        Iterator it;
        if (this.g == 0.0f) {
            return;
        }
        i(canvas);
        float f = this.f;
        if (f == 0.0f) {
            return;
        }
        float f2 = f * this.g;
        float f3 = this.o;
        float f4 = (f3 * f2) + (this.n - f3);
        int iE = i1.e(this.r, f2);
        Paint paint = this.x;
        paint.setColor(iE);
        int iE2 = i1.e(this.s, f2);
        Paint paint2 = this.y;
        paint2.setColor(iE2);
        int iE3 = i1.e(this.t, f2);
        Paint paint3 = this.z;
        paint3.setColor(iE3);
        this.A.setColor(i1.e(this.u, f2));
        float f5 = this.i;
        float f6 = this.j;
        RectF rectF = this.E;
        rectF.set(f5 - f3, f6 - f3, f5 + f3, f6 + f3);
        float f7 = this.i;
        float f8 = this.j;
        RectF rectF2 = this.F;
        rectF2.set(f7 - f4, f8 - f4, f7 + f4, f8 + f4);
        canvas.drawCircle(this.i, this.j, this.o, paint);
        float f9 = f4 - f3;
        float f10 = (f9 / 2.0f) + f3;
        float f11 = (f9 * this.p) / 200.0f;
        Iterator it2 = this.D.iterator();
        while (it2.hasNext()) {
            d81 d81Var2 = (d81) it2.next();
            Path path = this.G;
            path.reset();
            float f12 = d81Var2.a;
            float f13 = d81Var2.c;
            Drawable drawable2 = d81Var2.i;
            float f14 = f2;
            path.arcTo(rectF2, f12, f13, false);
            path.arcTo(rectF, d81Var2.b, -f13, false);
            path.close();
            canvas.drawPath(path, paint3);
            canvas.drawPath(path, d81Var2.h ? paint : paint2);
            if (drawable2 != null) {
                it = it2;
                double d = f10;
                int i = (int) ((d81Var2.f * d) + ((double) this.i));
                int i2 = (int) ((d81Var2.g * d) + ((double) this.j));
                if (d81Var2.j) {
                    drawable2.mutate().setColorFilter(this.u, PorterDuff.Mode.SRC_IN);
                    drawable2.setAlpha((int) (f14 * 255.0f));
                } else {
                    drawable2.setAlpha((int) (Color.alpha(this.u) * f14));
                }
                float f15 = i;
                float f16 = i2;
                drawable2.setBounds((int) (f15 - f11), (int) (f16 - f11), (int) (f15 + f11), (int) (f16 + f11));
                drawable2.draw(canvas);
            } else {
                it = it2;
            }
            it2 = it;
            f2 = f14;
        }
        float f17 = f2;
        if (!this.w || (drawable = (d81Var = this.v).i) == null) {
            return;
        }
        if (d81Var.j) {
            drawable.mutate().setColorFilter(this.u, PorterDuff.Mode.SRC_IN);
        }
        this.v.i.setAlpha((int) (f17 * 255.0f));
        Drawable drawable3 = this.v.i;
        float f18 = this.i;
        float f19 = this.j;
        drawable3.setBounds((int) (f18 - f11), (int) (f19 - f11), (int) (f18 + f11), (int) (f19 + f11));
        this.v.i.draw(canvas);
    }

    public final void g() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "actionsAnimation", this.f, 0.0f);
        this.e = objectAnimatorOfFloat;
        DecelerateInterpolator decelerateInterpolator = J;
        objectAnimatorOfFloat.setInterpolator(decelerateInterpolator);
        this.e.setDuration(300L);
        this.e.start();
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, "sizeAnimation", this.h, this.k);
        this.d = objectAnimatorOfInt;
        objectAnimatorOfInt.setInterpolator(decelerateInterpolator);
        this.d.setDuration(300L);
        this.d.start();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public final LinkedList h(List list) {
        LinkedList linkedList = new LinkedList();
        int i = 0;
        if (list.size() == 1) {
            ArrayList arrayList = new ArrayList(list);
            arrayList.add((j71) arrayList.get(0));
            list = arrayList;
        }
        float fSum = 360.0f / list.stream().mapToInt(new v71(0)).sum();
        for (j71 j71Var : list) {
            float f = (i * fSum) + this.q;
            linkedList.add(new d81(this, f, (j71Var.i() * fSum) + f, j71Var));
            i += j71Var.i();
        }
        return linkedList;
    }

    public abstract void i(Canvas canvas);

    public final cp0 j(dm0 dm0Var) {
        dm0Var.getClass();
        float f = 0.75f * ey0.f;
        float f2 = dm0Var.a;
        if (f2 > f) {
            dm0Var.a = f;
        } else {
            float f3 = -f;
            if (f2 < f3) {
                dm0Var.a = f3;
            }
        }
        float f4 = dm0Var.b;
        if (f4 > f) {
            dm0Var.b = f;
        } else {
            float f5 = -f;
            if (f4 < f5) {
                dm0Var.b = f5;
            }
        }
        return new cp0(Integer.valueOf((int) ((dm0Var.a * 60.0f) + this.i)), Integer.valueOf((int) ((dm0Var.b * 60.0f) + this.j)));
    }

    public final int k(float f, float f2) {
        double degrees = (((Math.toDegrees(Math.atan2(f2 - this.j, f - this.i)) + 360.0d) % 360.0d) + ((double) (360.0f - this.q))) % 360.0d;
        double dN = xy0.n(this.i, f, this.j, f2);
        int i = 0;
        for (d81 d81Var : this.D) {
            if (dN > this.o && degrees >= d81Var.e && degrees < d81Var.d) {
                return i;
            }
            i++;
        }
        return this.D.size();
    }

    public final void l(dm0 dm0Var) {
        f(this.c);
        f(this.e);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alphaAnimation", this.g, 0.0f);
        this.c = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(300L);
        this.c.setInterpolator(dm0Var == null ? I : J);
        this.c.start();
        if (dm0Var != null) {
            cp0 cp0VarJ = j(dm0Var);
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofInt("x", this.i, ((Integer) cp0VarJ.a).intValue()), PropertyValuesHolder.ofInt("y", this.j, ((Integer) cp0VarJ.b).intValue()));
            this.b = objectAnimatorOfPropertyValuesHolder;
            objectAnimatorOfPropertyValuesHolder.setInterpolator(K);
            this.b.setDuration(300L);
            this.b.start();
        }
    }

    public final void m(int i) {
        if (i == -1 || i == this.D.size()) {
            r(this.i, this.j);
            return;
        }
        d81 d81Var = (d81) this.D.get(i);
        float f = ((this.n - r0) / 2.0f) + this.o;
        double radians = Math.toRadians(((d81Var.c / 2.0f) + d81Var.a) % 360.0f);
        double d = f;
        r((int) ((Math.cos(radians) * d) + ((double) this.i)), (int) ((Math.sin(radians) * d) + ((double) this.j)));
    }

    public void o() {
        f20 f20VarE = xv0.d.a().e();
        this.k = ((int) oq0.b((SharedPreferences) pn0.t().d, oq0.D)) / 2;
        this.m = f20VarE.d().h().f() / 2;
        this.l = f20VarE.c() / 100.0f;
        int iB = ((int) oq0.b((SharedPreferences) pn0.t().d, oq0.x0)) / 2;
        this.n = iB;
        this.o = Math.min(iB, ((int) oq0.b((SharedPreferences) pn0.t().d, oq0.v0)) / 2);
        this.z.setStrokeWidth((int) oq0.b((SharedPreferences) pn0.t().d, oq0.z0));
        this.p = oq0.c((SharedPreferences) pn0.t().d, oq0.B0);
        this.q = oq0.b((SharedPreferences) pn0.t().d, oq0.E0);
        this.r = oq0.c((SharedPreferences) pn0.t().d, oq0.w0);
        this.s = oq0.c((SharedPreferences) pn0.t().d, oq0.y0);
        this.t = oq0.c((SharedPreferences) pn0.t().d, oq0.A0);
        this.u = oq0.c((SharedPreferences) pn0.t().d, oq0.C0);
        this.w = oq0.a((SharedPreferences) pn0.t().d, oq0.I0);
        s71 s71Var = s71.e;
        this.D = h(s71Var.c);
        this.v = new d81(this, 0.0f, 360.0f, s71Var.d);
        this.h = this.k;
        this.f = 0.0f;
        this.H = this.D.size();
    }

    public final void p(float f) {
        this.q = f;
        this.D = h(s71.e.c);
        r(this.B, this.C);
    }

    public final void q() {
        g();
        f(this.c);
        f(this.d);
        float f = this.g;
        float f2 = this.l;
        DecelerateInterpolator decelerateInterpolator = J;
        if (f != f2) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alphaAnimation", f, f2);
            this.c = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setInterpolator(decelerateInterpolator);
            this.c.setDuration(300L);
            this.c.start();
        }
        int i = this.h;
        int i2 = this.m;
        if (i != i2) {
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, "sizeAnimation", i, i2);
            this.d = objectAnimatorOfInt;
            objectAnimatorOfInt.setInterpolator(decelerateInterpolator);
            this.d.setDuration(300L);
            this.d.start();
        }
    }

    public final void r(int i, int i2) {
        this.B = i;
        this.C = i2;
        double degrees = (((Math.toDegrees(Math.atan2(i2 - this.j, i - this.i)) + 360.0d) % 360.0d) + ((double) (360.0f - this.q))) % 360.0d;
        double dN = xy0.n(this.i, this.B, this.j, this.C);
        int size = this.D.size();
        int i3 = 0;
        for (d81 d81Var : this.D) {
            boolean z = dN > ((double) this.o) && degrees >= ((double) d81Var.e) && degrees < ((double) d81Var.d);
            d81Var.h = z;
            if (z) {
                size = i3;
            }
            i3++;
        }
        this.H = size;
    }

    public void setActionsAnimation(float f) {
        this.f = f;
    }

    public void setAlphaAnimation(float f) {
        this.g = f;
    }

    public void setSizeAnimation(int i) {
        this.h = i;
    }

    public void setX(float f) {
        this.i = (int) f;
    }

    public void setY(float f) {
        this.j = (int) f;
    }

    public void setX(int i) {
        this.i = i;
    }

    public void setY(int i) {
        this.j = i;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
