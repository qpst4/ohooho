package com.quickcursor.android.drawables.globals.triggeractions;

import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import defpackage.f91;
import defpackage.i1;
import defpackage.q91;
import defpackage.s91;
import defpackage.u91;
import defpackage.v91;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class TriggerActionsPieDrawable extends s91 {
    public static final AccelerateInterpolator s = new AccelerateInterpolator();
    public static final DecelerateInterpolator t = new DecelerateInterpolator();
    public final Paint h;
    public final Paint i;
    public final Paint j;
    public final q91 p;
    public ObjectAnimator q;
    public final Path k = new Path();
    public final Path l = new Path();
    public final RectF m = new RectF();
    public final RectF n = new RectF();
    public final RectF o = new RectF();
    public float r = 0.0f;

    public TriggerActionsPieDrawable(q91 q91Var) {
        this.p = q91Var;
        Paint paint = new Paint(1);
        this.j = paint;
        paint.setStrokeWidth(0.0f);
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        Paint paint2 = new Paint(1);
        this.i = paint2;
        paint2.setStrokeWidth(0.0f);
        paint2.setStyle(style);
        Paint paint3 = new Paint(1);
        this.h = paint3;
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeWidth(q91Var.h());
    }

    @Override // defpackage.s60
    public final boolean a() {
        return this.r == 0.0f;
    }

    @Override // defpackage.s60
    public final boolean c() {
        ObjectAnimator objectAnimator = this.q;
        return objectAnimator != null && objectAnimator.isStarted();
    }

    @Override // android.graphics.drawable.Drawable, defpackage.s60
    public final void draw(Canvas canvas) {
        float f;
        Paint paint;
        Iterator it;
        Paint paint2;
        u91 u91Var = this.c;
        float f2 = u91Var.d;
        float f3 = this.r;
        float f4 = (f2 * 0.3f * f3) + (f2 * 0.7f);
        float f5 = u91Var.e;
        float f6 = (f5 * 0.3f * f3) + (f5 * 0.7f);
        float f7 = u91Var.f;
        float f8 = (f7 * 0.3f * f3) + (0.7f * f7);
        float f9 = this.d;
        float f10 = this.e;
        RectF rectF = this.m;
        rectF.set(f9 - f4, f10 - f4, f9 + f4, f10 + f4);
        float f11 = this.d;
        float f12 = this.e;
        RectF rectF2 = this.n;
        rectF2.set(f11 - f6, f12 - f6, f11 + f6, f12 + f6);
        float f13 = this.d;
        float f14 = this.e;
        RectF rectF3 = this.o;
        rectF3.set(f13 - f8, f14 - f8, f13 + f8, f14 + f8);
        q91 q91Var = this.p;
        int iE = i1.e(q91Var.e(), this.r);
        Paint paint3 = this.j;
        paint3.setColor(iE);
        int iE2 = i1.e(q91Var.f(), this.r);
        Paint paint4 = this.i;
        paint4.setColor(iE2);
        int iE3 = i1.e(q91Var.g(), this.r);
        Paint paint5 = this.h;
        paint5.setColor(iE3);
        float fD = q91Var.d();
        float f15 = ((f6 - f4) / 2.0f) + f4;
        float f16 = ((f8 - f6) / 2.0f) + f6;
        Iterator it2 = this.c.a.iterator();
        while (it2.hasNext()) {
            v91 v91Var = (v91) it2.next();
            Path path = this.k;
            path.reset();
            float f17 = v91Var.a;
            Iterator it3 = it2;
            float f18 = v91Var.c;
            q91 q91Var2 = q91Var;
            Drawable drawable = v91Var.j;
            float f19 = fD;
            path.arcTo(rectF2, f17, f18, false);
            path.arcTo(rectF, v91Var.b, -f18, false);
            path.close();
            canvas.drawPath(path, paint5);
            canvas.drawPath(path, v91Var.f ? paint4 : paint3);
            if (drawable != null) {
                paint2 = paint3;
                double d = f15;
                int i = (int) ((v91Var.h * d) + ((double) this.d));
                int i2 = (int) ((v91Var.i * d) + ((double) this.e));
                if (v91Var.k) {
                    drawable.mutate().setColorFilter(q91Var2.c(), PorterDuff.Mode.SRC_IN);
                    drawable.setAlpha((int) (this.r * 255.0f));
                } else {
                    drawable.setAlpha((int) (Color.alpha(q91Var2.c()) * this.r));
                }
                float f20 = i;
                float f21 = i2;
                drawable.setBounds((int) (f20 - f19), (int) (f21 - f19), (int) (f20 + f19), (int) (f21 + f19));
                drawable.draw(canvas);
            } else {
                paint2 = paint3;
            }
            paint3 = paint2;
            it2 = it3;
            q91Var = q91Var2;
            fD = f19;
        }
        q91 q91Var3 = q91Var;
        float f22 = fD;
        Paint paint6 = paint3;
        Iterator it4 = this.c.b.iterator();
        while (it4.hasNext()) {
            v91 v91Var2 = (v91) it4.next();
            Path path2 = this.l;
            path2.reset();
            float f23 = v91Var2.a;
            float f24 = v91Var2.c;
            Drawable drawable2 = v91Var2.j;
            path2.arcTo(rectF3, f23, f24, false);
            path2.arcTo(rectF2, v91Var2.b, -f24, false);
            path2.close();
            canvas.drawPath(path2, paint5);
            canvas.drawPath(path2, v91Var2.f ? paint4 : paint6);
            if (drawable2 != null) {
                paint = paint6;
                it = it4;
                double d2 = f16;
                int i3 = (int) ((v91Var2.h * d2) + ((double) this.d));
                f = f16;
                int i4 = (int) ((v91Var2.i * d2) + ((double) this.e));
                if (v91Var2.k) {
                    drawable2.mutate().setColorFilter(q91Var3.c(), PorterDuff.Mode.SRC_IN);
                    drawable2.setAlpha((int) (this.r * 255.0f));
                } else {
                    drawable2.setAlpha((int) (Color.alpha(q91Var3.c()) * this.r));
                }
                float f25 = i3;
                float f26 = i4;
                drawable2.setBounds((int) (f25 - f22), (int) (f26 - f22), (int) (f25 + f22), (int) (f26 + f22));
                drawable2.draw(canvas);
            } else {
                f = f16;
                paint = paint6;
                it = it4;
            }
            f16 = f;
            paint6 = paint;
            it4 = it;
        }
    }

    @Override // defpackage.s91
    public final void f() {
        this.b = null;
        ObjectAnimator objectAnimator = this.q;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        if (!this.p.i()) {
            this.r = 0.0f;
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "animationValue", this.r, 0.0f);
        this.q = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setInterpolator(s);
        this.q.setDuration(r0.b());
        this.q.start();
    }

    @Override // defpackage.s91
    public final void g(f91 f91Var, u91 u91Var, int i, int i2) {
        this.b = f91Var;
        this.c = u91Var;
        this.d = i;
        this.e = i2;
        this.f = i;
        this.g = i2;
        if (!this.p.i()) {
            this.r = 1.0f;
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "animationValue", this.r, 1.0f);
        this.q = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setInterpolator(t);
        this.q.setDuration(r2.b());
        this.q.start();
    }

    public void setAnimationValue(float f) {
        this.r = f;
    }
}
