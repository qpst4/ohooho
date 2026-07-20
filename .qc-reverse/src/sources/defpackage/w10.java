package defpackage;

import android.animation.ValueAnimator;
import android.graphics.Matrix;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class w10 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ float a;
    public final /* synthetic */ float b;
    public final /* synthetic */ float c;
    public final /* synthetic */ float d;
    public final /* synthetic */ float e;
    public final /* synthetic */ float f;
    public final /* synthetic */ float g;
    public final /* synthetic */ Matrix h;
    public final /* synthetic */ b20 i;

    public w10(b20 b20Var, float f, float f2, float f3, float f4, float f5, float f6, float f7, Matrix matrix) {
        this.i = b20Var;
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.e = f5;
        this.f = f6;
        this.g = f7;
        this.h = matrix;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        b20 b20Var = this.i;
        FloatingActionButton floatingActionButton = b20Var.r;
        floatingActionButton.setAlpha(s7.b(this.a, this.b, 0.0f, 0.2f, fFloatValue));
        float f = this.c;
        float f2 = this.d;
        floatingActionButton.setScaleX(s7.a(f, f2, fFloatValue));
        floatingActionButton.setScaleY(s7.a(this.e, f2, fFloatValue));
        float f3 = this.f;
        float f4 = this.g;
        b20Var.o = s7.a(f3, f4, fFloatValue);
        float fA = s7.a(f3, f4, fFloatValue);
        Matrix matrix = this.h;
        b20Var.a(fA, matrix);
        floatingActionButton.setImageMatrix(matrix);
    }
}
