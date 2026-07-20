package defpackage;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class uh0 implements View.OnTouchListener {
    public static final int s = ViewConfiguration.getTapTimeout();
    public final mc b;
    public final AccelerateInterpolator c;
    public final bv d;
    public nc e;
    public final float[] f;
    public final float[] g;
    public final int h;
    public final int i;
    public final float[] j;
    public final float[] k;
    public final float[] l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public final bv r;

    public uh0(bv bvVar) {
        mc mcVar = new mc();
        mcVar.e = Long.MIN_VALUE;
        mcVar.g = -1L;
        mcVar.f = 0L;
        this.b = mcVar;
        this.c = new AccelerateInterpolator();
        float[] fArr = {0.0f, 0.0f};
        this.f = fArr;
        float[] fArr2 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.g = fArr2;
        float[] fArr3 = {0.0f, 0.0f};
        this.j = fArr3;
        float[] fArr4 = {0.0f, 0.0f};
        this.k = fArr4;
        float[] fArr5 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.l = fArr5;
        this.d = bvVar;
        float f = Resources.getSystem().getDisplayMetrics().density;
        float f2 = ((int) ((1575.0f * f) + 0.5f)) / 1000.0f;
        fArr5[0] = f2;
        fArr5[1] = f2;
        float f3 = ((int) ((f * 315.0f) + 0.5f)) / 1000.0f;
        fArr4[0] = f3;
        fArr4[1] = f3;
        this.h = 1;
        fArr2[0] = Float.MAX_VALUE;
        fArr2[1] = Float.MAX_VALUE;
        fArr[0] = 0.2f;
        fArr[1] = 0.2f;
        fArr3[0] = 0.001f;
        fArr3[1] = 0.001f;
        this.i = s;
        mcVar.a = 500;
        mcVar.b = 500;
        this.r = bvVar;
    }

    public static float b(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float a(float r4, float r5, float r6, int r7) {
        /*
            r3 = this;
            float[] r0 = r3.f
            r0 = r0[r7]
            float[] r1 = r3.g
            r1 = r1[r7]
            float r0 = r0 * r5
            r2 = 0
            float r0 = b(r0, r2, r1)
            float r1 = r3.c(r4, r0)
            float r5 = r5 - r4
            float r4 = r3.c(r5, r0)
            float r4 = r4 - r1
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            android.view.animation.AccelerateInterpolator r0 = r3.c
            if (r5 >= 0) goto L25
            float r4 = -r4
            float r4 = r0.getInterpolation(r4)
            float r4 = -r4
            goto L2d
        L25:
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r5 <= 0) goto L36
            float r4 = r0.getInterpolation(r4)
        L2d:
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0 = 1065353216(0x3f800000, float:1.0)
            float r4 = b(r4, r5, r0)
            goto L37
        L36:
            r4 = r2
        L37:
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r5 != 0) goto L3c
            return r2
        L3c:
            float[] r0 = r3.j
            r0 = r0[r7]
            float[] r1 = r3.k
            r1 = r1[r7]
            float[] r3 = r3.l
            r3 = r3[r7]
            float r0 = r0 * r6
            if (r5 <= 0) goto L51
            float r4 = r4 * r0
            float r3 = b(r4, r1, r3)
            return r3
        L51:
            float r4 = -r4
            float r4 = r4 * r0
            float r3 = b(r4, r1, r3)
            float r3 = -r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.uh0.a(float, float, float, int):float");
    }

    public final float c(float f, float f2) {
        if (f2 != 0.0f) {
            int i = this.h;
            if (i == 0 || i == 1) {
                if (f < f2) {
                    if (f >= 0.0f) {
                        return 1.0f - (f / f2);
                    }
                    if (this.p && i == 1) {
                        return 1.0f;
                    }
                }
            } else if (i == 2 && f < 0.0f) {
                return f / (-f2);
            }
        }
        return 0.0f;
    }

    public final void d() {
        int i = 0;
        if (this.n) {
            this.p = false;
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        mc mcVar = this.b;
        int i2 = (int) (jCurrentAnimationTimeMillis - mcVar.e);
        int i3 = mcVar.b;
        if (i2 > i3) {
            i = i3;
        } else if (i2 >= 0) {
            i = i2;
        }
        mcVar.i = i;
        mcVar.h = mcVar.a(jCurrentAnimationTimeMillis);
        mcVar.g = jCurrentAnimationTimeMillis;
    }

    public final boolean e() {
        bv bvVar;
        int count;
        mc mcVar = this.b;
        float f = mcVar.d;
        int iAbs = (int) (f / Math.abs(f));
        Math.abs(mcVar.c);
        if (iAbs != 0 && (count = (bvVar = this.r).getCount()) != 0) {
            int childCount = bvVar.getChildCount();
            int firstVisiblePosition = bvVar.getFirstVisiblePosition();
            int i = firstVisiblePosition + childCount;
            if (iAbs <= 0 ? !(iAbs >= 0 || (firstVisiblePosition <= 0 && bvVar.getChildAt(0).getTop() >= 0)) : !(i >= count && bvVar.getChildAt(childCount - 1).getBottom() <= bvVar.getHeight())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0014, code lost:
    
        if (r0 != 3) goto L30;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
        /*
            r7 = this;
            boolean r0 = r7.q
            r1 = 0
            if (r0 != 0) goto L7
            goto L7c
        L7:
            int r0 = r9.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1b
            if (r0 == r2) goto L17
            r3 = 2
            if (r0 == r3) goto L1f
            r8 = 3
            if (r0 == r8) goto L17
            goto L7c
        L17:
            r7.d()
            return r1
        L1b:
            r7.o = r2
            r7.m = r1
        L1f:
            float r0 = r9.getX()
            int r3 = r8.getWidth()
            float r3 = (float) r3
            bv r4 = r7.d
            int r5 = r4.getWidth()
            float r5 = (float) r5
            float r0 = r7.a(r0, r3, r5, r1)
            float r9 = r9.getY()
            int r8 = r8.getHeight()
            float r8 = (float) r8
            int r3 = r4.getHeight()
            float r3 = (float) r3
            float r8 = r7.a(r9, r8, r3, r2)
            mc r9 = r7.b
            r9.c = r0
            r9.d = r8
            boolean r8 = r7.p
            if (r8 != 0) goto L7c
            boolean r8 = r7.e()
            if (r8 == 0) goto L7c
            nc r8 = r7.e
            if (r8 != 0) goto L60
            nc r8 = new nc
            r8.<init>(r1, r7)
            r7.e = r8
        L60:
            r7.p = r2
            r7.n = r2
            boolean r8 = r7.m
            if (r8 != 0) goto L75
            int r8 = r7.i
            if (r8 <= 0) goto L75
            nc r9 = r7.e
            long r5 = (long) r8
            java.util.WeakHashMap r8 = defpackage.uf1.a
            r4.postOnAnimationDelayed(r9, r5)
            goto L7a
        L75:
            nc r8 = r7.e
            r8.run()
        L7a:
            r7.m = r2
        L7c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.uh0.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
