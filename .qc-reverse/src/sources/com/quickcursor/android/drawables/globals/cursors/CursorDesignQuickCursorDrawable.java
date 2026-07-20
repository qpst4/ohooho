package com.quickcursor.android.drawables.globals.cursors;

import android.animation.ObjectAnimator;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Pair;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import defpackage.i1;
import defpackage.m1;
import defpackage.oq0;
import defpackage.pn0;
import defpackage.wl;
import defpackage.yq;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class CursorDesignQuickCursorDrawable extends yq {
    public static final AccelerateInterpolator x = new AccelerateInterpolator();
    public static final DecelerateInterpolator y = new DecelerateInterpolator();
    public static final OvershootInterpolator z = new OvershootInterpolator(4.0f);
    public final Paint e;
    public final Paint f;
    public final Paint g;
    public ObjectAnimator h;
    public ObjectAnimator i;
    public ObjectAnimator j;
    public ObjectAnimator k;
    public float l = 0.0f;
    public float m = 0.0f;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;

    public CursorDesignQuickCursorDrawable() {
        Paint paint = new Paint(1);
        this.e = paint;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        paint.setStrokeWidth(0.0f);
        Paint paint2 = new Paint(1);
        this.f = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        Paint paint3 = new Paint(1);
        this.g = paint3;
        paint3.setStyle(style);
        k();
    }

    @Override // defpackage.s60
    public final boolean a() {
        return this.l == 0.0f;
    }

    @Override // defpackage.s60
    public final boolean c() {
        return yq.i(this.i) || yq.i(this.h) || yq.i(this.j) || yq.i(this.k);
    }

    @Override // android.graphics.drawable.Drawable, defpackage.s60
    public final void draw(Canvas canvas) {
        float animatedFraction;
        ObjectAnimator objectAnimator = this.j;
        if (objectAnimator != null) {
            animatedFraction = objectAnimator.getAnimatedFraction();
            if (this.j.getInterpolator() == x) {
                animatedFraction = 1.0f - animatedFraction;
            }
        } else {
            animatedFraction = 1.0f;
        }
        int iE = i1.e(this.r, this.l);
        Paint paint = this.e;
        paint.setColor(iE);
        canvas.drawCircle(this.b, this.c, this.m * animatedFraction * ((this.p - this.v) - 1), paint);
        int iE2 = i1.e(this.q, this.l);
        Paint paint2 = this.f;
        paint2.setColor(iE2);
        paint2.setStrokeWidth(this.m * this.u);
        canvas.drawCircle(this.b, this.c, this.m * animatedFraction * (this.p - this.v), paint2);
        ObjectAnimator objectAnimator2 = this.k;
        if (objectAnimator2 == null || !objectAnimator2.isStarted()) {
            int iE3 = i1.e(this.n, this.l);
            Paint paint3 = this.g;
            paint3.setColor(iE3);
            canvas.drawCircle(this.b, this.c, (((1.0f - animatedFraction) * 0.6f) + 1.0f) * this.u, paint3);
            return;
        }
        paint2.setColor(wl.b(this.k.getAnimatedFraction(), this.q, this.s));
        canvas.drawCircle(this.b, this.c, this.o - this.v, paint2);
    }

    @Override // defpackage.yq
    public final void f() {
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, "clickCircleSize", this.p, this.u);
        this.k = objectAnimatorOfInt;
        objectAnimatorOfInt.setInterpolator(y);
        this.k.setDuration(this.w);
        this.k.start();
    }

    @Override // defpackage.yq
    public final int g() {
        return this.u * 2;
    }

    @Override // defpackage.yq
    public final void h() {
        ObjectAnimator objectAnimator = this.i;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.h;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        float f = this.l;
        AccelerateInterpolator accelerateInterpolator = x;
        if (f != 0.0f) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alphaAnimation", f, 0.0f);
            this.i = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setInterpolator(accelerateInterpolator);
            this.i.setDuration(300L);
            this.i.start();
        }
        float f2 = this.m;
        if (f2 != 0.0f) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, "sizeAnimation", f2, 0.0f);
            this.h = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setInterpolator(accelerateInterpolator);
            this.h.setDuration(500L);
            this.h.start();
        }
    }

    @Override // defpackage.yq
    public final void k() {
        int iB = (int) oq0.b((SharedPreferences) pn0.t().d, oq0.r);
        int iB2 = (int) oq0.b((SharedPreferences) pn0.t().d, oq0.T);
        int iC = oq0.c((SharedPreferences) pn0.t().d, oq0.S);
        this.p = iB / 2;
        this.q = oq0.c((SharedPreferences) pn0.t().d, oq0.v);
        this.u = (int) oq0.b((SharedPreferences) pn0.t().d, oq0.u);
        this.r = oq0.c((SharedPreferences) pn0.t().d, oq0.w);
        this.s = oq0.c((SharedPreferences) pn0.t().d, oq0.x);
        this.t = oq0.c((SharedPreferences) pn0.t().d, oq0.e0);
        this.n = this.s;
        this.w = Math.min((int) (((iB * 1.3f) / iB2) * iC), iC);
        this.v = this.u / 2;
        this.d = new Pair(Integer.valueOf(this.p), Integer.valueOf(this.p));
    }

    @Override // defpackage.yq
    public final void l() {
        ObjectAnimator objectAnimator = this.i;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.h;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        if (this.l != 1.0f) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alphaAnimation", 0.0f, 1.0f);
            this.i = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setInterpolator(y);
            this.i.setDuration(400L);
            this.i.start();
        }
        if (this.m != 1.0f) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, "sizeAnimation", 0.0f, 1.0f);
            this.h = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setInterpolator(z);
            this.h.setDuration(500L);
            this.h.start();
        }
    }

    @Override // defpackage.yq
    public final void m() {
        setAlphaAnimation(1.0f);
        setSizeAnimation(1.0f);
    }

    @Override // defpackage.yq
    public final void n() {
        ObjectAnimator objectAnimator = this.j;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.j.end();
        }
        l();
        ObjectAnimator objectAnimatorOfArgb = ObjectAnimator.ofArgb(this, "colorAnimation", this.n, this.t);
        this.j = objectAnimatorOfArgb;
        objectAnimatorOfArgb.setInterpolator(x);
        this.j.setDuration(400L);
        this.j.start();
    }

    @Override // defpackage.yq
    public final void o() {
        ObjectAnimator objectAnimator = this.j;
        DecelerateInterpolator decelerateInterpolator = y;
        if (objectAnimator != null && objectAnimator.isStarted() && this.j.getInterpolator() == decelerateInterpolator) {
            return;
        }
        ObjectAnimator objectAnimatorOfArgb = ObjectAnimator.ofArgb(this, "colorAnimation", this.n, this.s);
        this.j = objectAnimatorOfArgb;
        objectAnimatorOfArgb.setInterpolator(decelerateInterpolator);
        this.j.setDuration(400L);
        this.j.addListener(new m1(2, this));
        this.j.start();
    }

    public void setAlphaAnimation(float f) {
        this.l = f;
    }

    public void setClickCircleSize(int i) {
        this.o = i;
    }

    public void setColorAnimation(int i) {
        this.n = i;
    }

    public void setSizeAnimation(float f) {
        this.m = f;
    }
}
