package com.quickcursor.android.drawables.globals.cursors;

import android.animation.ObjectAnimator;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.util.Pair;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import defpackage.oq0;
import defpackage.pn0;
import defpackage.yq;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class CursorBitmapDrawable extends yq {
    public static final AccelerateInterpolator q = new AccelerateInterpolator();
    public static final DecelerateInterpolator r = new DecelerateInterpolator();
    public ObjectAnimator e;
    public int g;
    public int h;
    public int i;
    public int j;
    public final Bitmap k;
    public final float l;
    public final float m;
    public final float n;
    public BitmapDrawable p;
    public float f = 0.0f;
    public final int o = (int) oq0.b((SharedPreferences) pn0.t().d, oq0.s);

    public CursorBitmapDrawable(Bitmap bitmap, float f, float f2) {
        this.k = bitmap;
        this.m = f;
        this.n = f2;
        this.l = (bitmap.getWidth() * 1.0f) / bitmap.getHeight();
        k();
    }

    @Override // defpackage.s60
    public final boolean a() {
        return this.f == 0.0f;
    }

    @Override // defpackage.s60
    public final boolean c() {
        return yq.i(this.e);
    }

    @Override // android.graphics.drawable.Drawable, defpackage.s60
    public final void draw(Canvas canvas) {
        this.p.setAlpha((int) (this.f * 255.0f));
        BitmapDrawable bitmapDrawable = this.p;
        int i = this.i + this.b;
        int i2 = this.j + this.c;
        bitmapDrawable.setBounds(i, i2, this.g + i, this.h + i2);
        this.p.draw(canvas);
    }

    @Override // defpackage.yq
    public final int g() {
        return this.o;
    }

    @Override // defpackage.yq
    public final void h() {
        ObjectAnimator objectAnimator = this.e;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        float f = this.f;
        if (f != 0.0f) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alphaAnimation", f, 0.0f);
            this.e = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setInterpolator(q);
            this.e.setDuration(300L);
            this.e.start();
        }
    }

    @Override // defpackage.yq
    public final void k() {
        boolean zA = oq0.a((SharedPreferences) pn0.t().d, oq0.t);
        int iB = (int) oq0.b((SharedPreferences) pn0.t().d, oq0.r);
        float f = this.l;
        if (f > 1.0f) {
            this.g = iB;
            this.h = (int) (iB / f);
        } else {
            this.h = iB;
            this.g = (int) (iB * f);
        }
        int i = this.g;
        Bitmap bitmap = this.k;
        float f2 = this.m;
        if (zA) {
            this.i = (int) ((1.0f - f2) * i * (-1.0f));
            Matrix matrix = new Matrix();
            matrix.preScale(-1.0f, 1.0f);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
            bitmapCreateBitmap.setDensity(160);
            this.p = new BitmapDrawable(bitmapCreateBitmap);
        } else {
            this.i = (int) (i * (-1.0f) * f2);
            this.p = new BitmapDrawable(bitmap);
        }
        this.j = (int) (this.h * (-1.0f) * this.n);
        this.d = new Pair(Integer.valueOf(this.i * (-1)), Integer.valueOf(this.j * (-1)));
    }

    @Override // defpackage.yq
    public final void l() {
        ObjectAnimator objectAnimator = this.e;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        if (this.f != 1.0f) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alphaAnimation", 0.0f, 1.0f);
            this.e = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setInterpolator(r);
            this.e.setDuration(400L);
            this.e.start();
        }
    }

    @Override // defpackage.yq
    public final void m() {
        this.f = 1.0f;
    }

    public void setAlphaAnimation(float f) {
        this.f = f;
    }

    @Override // defpackage.yq
    public final void f() {
    }

    @Override // defpackage.yq
    public final void n() {
    }

    @Override // defpackage.yq
    public final void o() {
    }
}
