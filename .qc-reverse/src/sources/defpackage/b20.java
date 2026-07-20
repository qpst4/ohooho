package defpackage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.quickcursor.R;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b20 {
    public mz0 a;
    public c20 b;
    public RippleDrawable c;
    public tg d;
    public RippleDrawable e;
    public boolean f;
    public float h;
    public float i;
    public float j;
    public int k;
    public Animator l;
    public bm0 m;
    public bm0 n;
    public int p;
    public final FloatingActionButton r;
    public final sp1 s;
    public static final i10 x = s7.c;
    public static final int y = R.attr.motionDurationLong2;
    public static final int z = R.attr.motionEasingEmphasizedInterpolator;
    public static final int A = R.attr.motionDurationMedium1;
    public static final int B = R.attr.motionEasingEmphasizedAccelerateInterpolator;
    public static final int[] C = {android.R.attr.state_pressed, android.R.attr.state_enabled};
    public static final int[] D = {android.R.attr.state_hovered, android.R.attr.state_focused, android.R.attr.state_enabled};
    public static final int[] E = {android.R.attr.state_focused, android.R.attr.state_enabled};
    public static final int[] F = {android.R.attr.state_hovered, android.R.attr.state_enabled};
    public static final int[] G = {android.R.attr.state_enabled};
    public static final int[] H = new int[0];
    public boolean g = true;
    public float o = 1.0f;
    public int q = 0;
    public final Rect t = new Rect();
    public final RectF u = new RectF();
    public final RectF v = new RectF();
    public final Matrix w = new Matrix();

    public b20(FloatingActionButton floatingActionButton, sp1 sp1Var) {
        int i = 0;
        this.r = floatingActionButton;
        this.s = sp1Var;
        pn0 pn0Var = new pn0(9);
        d20 d20Var = (d20) this;
        pn0Var.d(d(new z10(d20Var, 1)));
        pn0Var.d(d(new z10(d20Var, i)));
        pn0Var.d(d(new z10(d20Var, i)));
        pn0Var.d(d(new z10(d20Var, i)));
        pn0Var.d(d(new z10(d20Var, 2)));
        pn0Var.d(d(new y10(d20Var)));
        floatingActionButton.getRotation();
    }

    public static ValueAnimator d(a20 a20Var) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(x);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(a20Var);
        valueAnimator.addUpdateListener(a20Var);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    public final void a(float f, Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.r.getDrawable();
        if (drawable == null || this.p == 0) {
            return;
        }
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        RectF rectF = this.u;
        rectF.set(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
        float f2 = this.p;
        RectF rectF2 = this.v;
        rectF2.set(0.0f, 0.0f, f2, f2);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        float f3 = this.p / 2.0f;
        matrix.postScale(f, f, f3, f3);
    }

    public final AnimatorSet b(bm0 bm0Var, float f, float f2, float f3) {
        ArrayList arrayList = new ArrayList();
        Property property = View.ALPHA;
        float[] fArr = {f};
        FloatingActionButton floatingActionButton = this.r;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) property, fArr);
        bm0Var.f("opacity").a(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.SCALE_X, f2);
        bm0Var.f("scale").a(objectAnimatorOfFloat2);
        int i = Build.VERSION.SDK_INT;
        if (i == 26) {
            x10 x10Var = new x10();
            x10Var.a = new FloatEvaluator();
            objectAnimatorOfFloat2.setEvaluator(x10Var);
        }
        arrayList.add(objectAnimatorOfFloat2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.SCALE_Y, f2);
        bm0Var.f("scale").a(objectAnimatorOfFloat3);
        if (i == 26) {
            x10 x10Var2 = new x10();
            x10Var2.a = new FloatEvaluator();
            objectAnimatorOfFloat3.setEvaluator(x10Var2);
        }
        arrayList.add(objectAnimatorOfFloat3);
        Matrix matrix = this.w;
        a(f3, matrix);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(floatingActionButton, new je(), new v10(this), new Matrix(matrix));
        bm0Var.f("iconScale").a(objectAnimatorOfObject);
        arrayList.add(objectAnimatorOfObject);
        AnimatorSet animatorSet = new AnimatorSet();
        xr.E(animatorSet, arrayList);
        return animatorSet;
    }

    public final AnimatorSet c(float f, float f2, float f3, int i, int i2) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        FloatingActionButton floatingActionButton = this.r;
        valueAnimatorOfFloat.addUpdateListener(new w10(this, floatingActionButton.getAlpha(), f, floatingActionButton.getScaleX(), f2, floatingActionButton.getScaleY(), this.o, f3, new Matrix(this.w)));
        arrayList.add(valueAnimatorOfFloat);
        xr.E(animatorSet, arrayList);
        animatorSet.setDuration(i1.T(floatingActionButton.getContext(), i, floatingActionButton.getContext().getResources().getInteger(R.integer.material_motion_duration_long_1)));
        animatorSet.setInterpolator(i1.U(floatingActionButton.getContext(), i2, s7.b));
        return animatorSet;
    }

    public abstract void e(float f, float f2, float f3);

    public final void g(mz0 mz0Var) {
        this.a = mz0Var;
        c20 c20Var = this.b;
        if (c20Var != null) {
            c20Var.setShapeAppearanceModel(mz0Var);
        }
        Drawable.Callback callback = this.c;
        if (callback instanceof xz0) {
            ((xz0) callback).setShapeAppearanceModel(mz0Var);
        }
        tg tgVar = this.d;
        if (tgVar != null) {
            tgVar.o = mz0Var;
            tgVar.invalidateSelf();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h() {
        /*
            r11 = this;
            r0 = r11
            d20 r0 = (defpackage.d20) r0
            sp1 r1 = r0.s
            java.lang.Object r2 = r1.c
            com.google.android.material.floatingactionbutton.FloatingActionButton r2 = (com.google.android.material.floatingactionbutton.FloatingActionButton) r2
            boolean r2 = r2.l
            boolean r3 = r0.f
            android.graphics.Rect r4 = r11.t
            com.google.android.material.floatingactionbutton.FloatingActionButton r5 = r0.r
            r6 = 0
            if (r2 == 0) goto L4b
            if (r3 == 0) goto L23
            int r2 = r0.k
            int r3 = r5.getSizeDimension()
            int r2 = r2 - r3
            int r2 = r2 / 2
            int r6 = java.lang.Math.max(r2, r6)
        L23:
            boolean r2 = r0.g
            if (r2 == 0) goto L2f
            float r2 = r5.getElevation()
            float r3 = r0.j
            float r2 = r2 + r3
            goto L30
        L2f:
            r2 = 0
        L30:
            double r7 = (double) r2
            double r7 = java.lang.Math.ceil(r7)
            int r3 = (int) r7
            int r3 = java.lang.Math.max(r6, r3)
            r7 = 1069547520(0x3fc00000, float:1.5)
            float r2 = r2 * r7
            double r7 = (double) r2
            double r7 = java.lang.Math.ceil(r7)
            int r2 = (int) r7
            int r2 = java.lang.Math.max(r6, r2)
            r4.set(r3, r2, r3, r2)
            goto L64
        L4b:
            if (r3 == 0) goto L61
            int r2 = r5.getSizeDimension()
            int r3 = r0.k
            if (r2 < r3) goto L56
            goto L61
        L56:
            int r2 = r5.getSizeDimension()
            int r3 = r3 - r2
            int r3 = r3 / 2
            r4.set(r3, r3, r3, r3)
            goto L64
        L61:
            r4.set(r6, r6, r6, r6)
        L64:
            android.graphics.drawable.RippleDrawable r2 = r11.e
            java.lang.String r3 = "Didn't initialize content background"
            defpackage.f01.k(r3, r2)
            java.lang.Object r1 = r1.c
            com.google.android.material.floatingactionbutton.FloatingActionButton r1 = (com.google.android.material.floatingactionbutton.FloatingActionButton) r1
            boolean r1 = r1.l
            sp1 r2 = r11.s
            if (r1 != 0) goto L91
            boolean r1 = r0.f
            if (r1 == 0) goto L81
            int r1 = r5.getSizeDimension()
            int r0 = r0.k
            if (r1 < r0) goto L91
        L81:
            android.graphics.drawable.RippleDrawable r11 = r11.e
            if (r11 == 0) goto L8d
            java.lang.Object r0 = r2.c
            com.google.android.material.floatingactionbutton.FloatingActionButton r0 = (com.google.android.material.floatingactionbutton.FloatingActionButton) r0
            com.google.android.material.floatingactionbutton.FloatingActionButton.b(r0, r11)
            goto La7
        L8d:
            r2.getClass()
            goto La7
        L91:
            android.graphics.drawable.InsetDrawable r5 = new android.graphics.drawable.InsetDrawable
            android.graphics.drawable.RippleDrawable r6 = r11.e
            int r7 = r4.left
            int r8 = r4.top
            int r9 = r4.right
            int r10 = r4.bottom
            r5.<init>(r6, r7, r8, r9, r10)
            java.lang.Object r11 = r2.c
            com.google.android.material.floatingactionbutton.FloatingActionButton r11 = (com.google.android.material.floatingactionbutton.FloatingActionButton) r11
            com.google.android.material.floatingactionbutton.FloatingActionButton.b(r11, r5)
        La7:
            int r11 = r4.left
            int r0 = r4.top
            int r1 = r4.right
            int r3 = r4.bottom
            java.lang.Object r2 = r2.c
            com.google.android.material.floatingactionbutton.FloatingActionButton r2 = (com.google.android.material.floatingactionbutton.FloatingActionButton) r2
            android.graphics.Rect r4 = r2.m
            r4.set(r11, r0, r1, r3)
            int r4 = r2.j
            int r11 = r11 + r4
            int r0 = r0 + r4
            int r1 = r1 + r4
            int r3 = r3 + r4
            r2.setPadding(r11, r0, r1, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.b20.h():void");
    }

    public final void f() {
    }
}
