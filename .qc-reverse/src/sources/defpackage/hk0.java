package defpackage;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class hk0 extends Drawable.ConstantState {
    public mz0 a;
    public nx b;
    public ColorStateList c;
    public ColorStateList d;
    public ColorStateList e;
    public PorterDuff.Mode f;
    public Rect g;
    public final float h;
    public float i;
    public float j;
    public int k;
    public float l;
    public float m;
    public int n;
    public int o;
    public final Paint.Style p;

    public hk0(hk0 hk0Var) {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = PorterDuff.Mode.SRC_IN;
        this.g = null;
        this.h = 1.0f;
        this.i = 1.0f;
        this.k = 255;
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = 0;
        this.o = 0;
        this.p = Paint.Style.FILL_AND_STROKE;
        this.a = hk0Var.a;
        this.b = hk0Var.b;
        this.j = hk0Var.j;
        this.c = hk0Var.c;
        this.d = hk0Var.d;
        this.f = hk0Var.f;
        this.e = hk0Var.e;
        this.k = hk0Var.k;
        this.h = hk0Var.h;
        this.o = hk0Var.o;
        this.i = hk0Var.i;
        this.l = hk0Var.l;
        this.m = hk0Var.m;
        this.n = hk0Var.n;
        this.p = hk0Var.p;
        if (hk0Var.g != null) {
            this.g = new Rect(hk0Var.g);
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        ik0 ik0Var = new ik0(this);
        ik0Var.f = true;
        return ik0Var;
    }

    public hk0(mz0 mz0Var) {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = PorterDuff.Mode.SRC_IN;
        this.g = null;
        this.h = 1.0f;
        this.i = 1.0f;
        this.k = 255;
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = 0;
        this.o = 0;
        this.p = Paint.Style.FILL_AND_STROKE;
        this.a = mz0Var;
        this.b = null;
    }
}
