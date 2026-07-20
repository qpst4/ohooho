package com.quickcursor.android.drawables.globals;

import android.animation.ObjectAnimator;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.animation.PathInterpolator;
import defpackage.oq0;
import defpackage.pn0;
import defpackage.s60;
import defpackage.wl;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class RippleDrawable extends Drawable implements s60 {
    public static final PathInterpolator j = new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
    public final ObjectAnimator b;
    public final Paint c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public float i;

    public RippleDrawable(int i, int i2, int i3) {
        this.g = i;
        this.h = i2;
        int iB = (int) oq0.b((SharedPreferences) pn0.t().d, oq0.T);
        this.d = iB;
        this.e = i3;
        this.f = Color.alpha(i3);
        Paint paint = new Paint(1);
        this.c = paint;
        paint.setStyle(Paint.Style.FILL);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "animatedRadius", 0.0f, iB);
        this.b = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(oq0.c((SharedPreferences) pn0.t().d, oq0.S));
        objectAnimatorOfFloat.setRepeatCount(0);
        objectAnimatorOfFloat.setInterpolator(j);
        objectAnimatorOfFloat.start();
    }

    @Override // defpackage.s60
    public final boolean a() {
        return this.i == ((float) this.d);
    }

    @Override // defpackage.s60
    public final boolean c() {
        return !a();
    }

    @Override // android.graphics.drawable.Drawable, defpackage.s60
    public final void draw(Canvas canvas) {
        float f = this.i;
        if (f > 0.0f) {
            float f2 = f / 2.0f;
            int animatedFraction = (int) ((1.0f - this.b.getAnimatedFraction()) * this.f);
            int i = this.g;
            int i2 = this.h;
            int i3 = this.e;
            RadialGradient radialGradient = new RadialGradient(i, i2, f2, wl.f(i3, (int) (((double) animatedFraction) / 1.3d)), wl.f(i3, animatedFraction), Shader.TileMode.MIRROR);
            Paint paint = this.c;
            paint.setShader(radialGradient);
            canvas.drawCircle(i, i2, f2, paint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public void setAnimatedRadius(float f) {
        this.i = f;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
