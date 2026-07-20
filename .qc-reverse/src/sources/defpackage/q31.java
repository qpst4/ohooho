package defpackage;

import android.view.View;
import android.view.ViewParent;
import com.google.android.material.behavior.SwipeDismissBehavior;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class q31 extends lc1 {
    public int n;
    public int o = -1;
    public final /* synthetic */ SwipeDismissBehavior p;

    public q31(SwipeDismissBehavior swipeDismissBehavior) {
        this.p = swipeDismissBehavior;
    }

    @Override // defpackage.lc1
    public final int P(View view) {
        return view.getWidth();
    }

    @Override // defpackage.lc1
    public final void X(View view, int i) {
        this.o = i;
        this.n = view.getLeft();
        ViewParent parent = view.getParent();
        if (parent != null) {
            SwipeDismissBehavior swipeDismissBehavior = this.p;
            swipeDismissBehavior.c = true;
            parent.requestDisallowInterceptTouchEvent(true);
            swipeDismissBehavior.c = false;
        }
    }

    @Override // defpackage.lc1
    public final void Z(View view, int i, int i2) {
        float width = view.getWidth();
        SwipeDismissBehavior swipeDismissBehavior = this.p;
        float f = width * swipeDismissBehavior.e;
        float width2 = view.getWidth() * swipeDismissBehavior.f;
        float fAbs = Math.abs(i - this.n);
        if (fAbs <= f) {
            view.setAlpha(1.0f);
        } else if (fAbs >= width2) {
            view.setAlpha(0.0f);
        } else {
            view.setAlpha(Math.min(Math.max(0.0f, 1.0f - ((fAbs - f) / (width2 - f))), 1.0f));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0067  */
    @Override // defpackage.lc1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a0(android.view.View r9, float r10, float r11) {
        /*
            r8 = this;
            r11 = -1
            r8.o = r11
            int r11 = r9.getWidth()
            r0 = 0
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            r2 = 0
            com.google.android.material.behavior.SwipeDismissBehavior r3 = r8.p
            r4 = 1
            if (r1 == 0) goto L39
            java.util.WeakHashMap r5 = defpackage.uf1.a
            int r5 = r9.getLayoutDirection()
            if (r5 != r4) goto L1a
            r5 = r4
            goto L1b
        L1a:
            r5 = r2
        L1b:
            int r6 = r3.d
            r7 = 2
            if (r6 != r7) goto L21
            goto L52
        L21:
            if (r6 != 0) goto L2d
            if (r5 == 0) goto L2a
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L67
            goto L52
        L2a:
            if (r1 <= 0) goto L67
            goto L52
        L2d:
            if (r6 != r4) goto L67
            if (r5 == 0) goto L34
            if (r1 <= 0) goto L67
            goto L52
        L34:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L67
            goto L52
        L39:
            int r1 = r9.getLeft()
            int r5 = r8.n
            int r1 = r1 - r5
            int r5 = r9.getWidth()
            float r5 = (float) r5
            r6 = 1056964608(0x3f000000, float:0.5)
            float r5 = r5 * r6
            int r5 = java.lang.Math.round(r5)
            int r1 = java.lang.Math.abs(r1)
            if (r1 < r5) goto L67
        L52:
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 < 0) goto L61
            int r10 = r9.getLeft()
            int r0 = r8.n
            if (r10 >= r0) goto L5f
            goto L61
        L5f:
            int r0 = r0 + r11
            goto L65
        L61:
            int r8 = r8.n
            int r0 = r8 - r11
        L65:
            r2 = r4
            goto L69
        L67:
            int r0 = r8.n
        L69:
            wf1 r8 = r3.a
            int r10 = r9.getTop()
            boolean r8 = r8.o(r0, r10)
            if (r8 == 0) goto L7f
            vn1 r8 = new vn1
            r8.<init>(r3, r9, r2)
            java.util.WeakHashMap r10 = defpackage.uf1.a
            r9.postOnAnimation(r8)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.q31.a0(android.view.View, float, float):void");
    }

    @Override // defpackage.lc1
    public final int g(View view, int i) {
        int width;
        int width2;
        WeakHashMap weakHashMap = uf1.a;
        boolean z = view.getLayoutDirection() == 1;
        int i2 = this.p.d;
        if (i2 == 0) {
            width = this.n;
            if (z) {
                width -= view.getWidth();
                width2 = this.n;
            } else {
                width2 = view.getWidth() + width;
            }
        } else {
            int i3 = this.n;
            if (i2 != 1) {
                width = i3 - view.getWidth();
                width2 = this.n + view.getWidth();
            } else if (z) {
                width2 = view.getWidth() + i3;
                width = i3;
            } else {
                width = i3 - view.getWidth();
                width2 = this.n;
            }
        }
        return Math.min(Math.max(width, i), width2);
    }

    @Override // defpackage.lc1
    public final int h(View view, int i) {
        return view.getTop();
    }

    @Override // defpackage.lc1
    public final boolean s0(View view, int i) {
        int i2 = this.o;
        return (i2 == -1 || i2 == i) && this.p.r(view);
    }

    @Override // defpackage.lc1
    public final void Y(int i) {
    }
}
