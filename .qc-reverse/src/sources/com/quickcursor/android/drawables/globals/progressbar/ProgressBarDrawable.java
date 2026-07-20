package com.quickcursor.android.drawables.globals.progressbar;

import android.animation.ObjectAnimator;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.quickcursor.App;
import com.quickcursor.R;
import defpackage.ey0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ProgressBarDrawable extends Drawable {
    public static final float m;
    public static final float n;
    public static final int o;
    public static final float p;
    public static final AccelerateInterpolator q;
    public static final DecelerateInterpolator r;
    public final Paint b;
    public final Paint c;
    public final Paint d;
    public RectF e;
    public ObjectAnimator f;
    public float g = 0.0f;
    public float h = 0.0f;
    public Drawable i;
    public final int j;
    public final int k;
    public final int l;

    static {
        float fA = ey0.a(24);
        m = fA;
        n = ey0.a(48);
        o = ey0.a(24);
        p = fA * 2.0f;
        q = new AccelerateInterpolator();
        r = new DecelerateInterpolator();
    }

    public ProgressBarDrawable() {
        Paint paint = new Paint(1);
        this.c = paint;
        paint.setStrokeWidth(0.0f);
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        Paint paint2 = new Paint(1);
        this.b = paint2;
        paint2.setStrokeWidth(ey0.a(2));
        paint2.setStyle(Paint.Style.STROKE);
        Paint paint3 = new Paint(1);
        this.d = paint3;
        paint3.setStrokeWidth(0.0f);
        paint3.setStyle(style);
        this.j = App.c.getColor(R.color.progress_bar_drawable_background);
        this.k = App.c.getColor(R.color.progress_bar_drawable_stroke);
        this.l = App.c.getColor(R.color.progress_bar_drawable_progress_background);
        this.i = null;
    }

    public final boolean a() {
        return this.g == 0.0f;
    }

    public final boolean c() {
        ObjectAnimator objectAnimator = this.f;
        return objectAnimator != null && objectAnimator.isStarted();
    }

    public final void f() {
        ObjectAnimator objectAnimator = this.f;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.f = null;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alphaAnimation", this.g, 0.0f);
        this.f = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setInterpolator(q);
        this.f.setDuration(300L);
        this.f.start();
    }

    public void g(Drawable drawable, float f) {
        this.i = drawable;
        ObjectAnimator objectAnimator = this.f;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.f = null;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alphaAnimation", this.g, 1.0f);
        this.f = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setInterpolator(r);
        this.f.setDuration(300L);
        this.f.start();
        this.h = f;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public void setAlphaAnimation(float f) {
        this.g = f;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
