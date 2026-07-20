package defpackage;

import android.animation.ObjectAnimator;
import android.view.View;
import com.quickcursor.R;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class b10 extends t81 {
    public static final String[] D = {"android:visibility:visibility", "android:visibility:parent"};
    public final int C;

    public b10() {
        this.C = 3;
    }

    public static void I(b91 b91Var) {
        View view = b91Var.b;
        int visibility = view.getVisibility();
        HashMap map = b91Var.a;
        map.put("android:visibility:visibility", Integer.valueOf(visibility));
        map.put("android:visibility:parent", view.getParent());
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        map.put("android:visibility:screenLocation", iArr);
    }

    public static float K(b91 b91Var, float f) {
        Float f2;
        return (b91Var == null || (f2 = (Float) b91Var.a.get("android:fade:transitionAlpha")) == null) ? f : f2.floatValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.hh1 L(defpackage.b91 r8, defpackage.b91 r9) {
        /*
            hh1 r0 = new hh1
            r0.<init>()
            r1 = 0
            r0.a = r1
            r0.b = r1
            r2 = 0
            r3 = -1
            java.lang.String r4 = "android:visibility:parent"
            java.lang.String r5 = "android:visibility:visibility"
            if (r8 == 0) goto L2f
            java.util.HashMap r6 = r8.a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L2f
            java.lang.Object r7 = r6.get(r5)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r0.c = r7
            java.lang.Object r6 = r6.get(r4)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.e = r6
            goto L33
        L2f:
            r0.c = r3
            r0.e = r2
        L33:
            if (r9 == 0) goto L52
            java.util.HashMap r6 = r9.a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L52
            java.lang.Object r2 = r6.get(r5)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r0.d = r2
            java.lang.Object r2 = r6.get(r4)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r0.f = r2
            goto L56
        L52:
            r0.d = r3
            r0.f = r2
        L56:
            r2 = 1
            if (r8 == 0) goto L8a
            if (r9 == 0) goto L8a
            int r8 = r0.c
            int r9 = r0.d
            if (r8 != r9) goto L68
            android.view.ViewGroup r3 = r0.e
            android.view.ViewGroup r4 = r0.f
            if (r3 != r4) goto L68
            goto L9f
        L68:
            if (r8 == r9) goto L78
            if (r8 != 0) goto L71
            r0.b = r1
            r0.a = r2
            return r0
        L71:
            if (r9 != 0) goto L9f
            r0.b = r2
            r0.a = r2
            return r0
        L78:
            android.view.ViewGroup r8 = r0.f
            if (r8 != 0) goto L81
            r0.b = r1
            r0.a = r2
            return r0
        L81:
            android.view.ViewGroup r8 = r0.e
            if (r8 != 0) goto L9f
            r0.b = r2
            r0.a = r2
            return r0
        L8a:
            if (r8 != 0) goto L95
            int r8 = r0.d
            if (r8 != 0) goto L95
            r0.b = r2
            r0.a = r2
            return r0
        L95:
            if (r9 != 0) goto L9f
            int r8 = r0.c
            if (r8 != 0) goto L9f
            r0.b = r1
            r0.a = r2
        L9f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.b10.L(b91, b91):hh1");
    }

    public final ObjectAnimator J(View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        ug1.a.x(view, f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, ug1.b, f2);
        a10 a10Var = new a10(view);
        objectAnimatorOfFloat.addListener(a10Var);
        o().a(a10Var);
        return objectAnimatorOfFloat;
    }

    @Override // defpackage.t81
    public final void d(b91 b91Var) {
        I(b91Var);
    }

    @Override // defpackage.t81
    public final void g(b91 b91Var) {
        I(b91Var);
        View view = b91Var.b;
        Float fValueOf = (Float) view.getTag(R.id.transition_pause_alpha);
        if (fValueOf == null) {
            fValueOf = view.getVisibility() == 0 ? Float.valueOf(ug1.a.n(view)) : Float.valueOf(0.0f);
        }
        b91Var.a.put("android:fade:transitionAlpha", fValueOf);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0047, code lost:
    
        if (L(n(r3, false), r(r3, false)).a != false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0213  */
    @Override // defpackage.t81
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.animation.Animator k(android.view.ViewGroup r24, defpackage.b91 r25, defpackage.b91 r26) {
        /*
            Method dump skipped, instruction units count: 727
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.b10.k(android.view.ViewGroup, b91, b91):android.animation.Animator");
    }

    @Override // defpackage.t81
    public final String[] q() {
        return D;
    }

    @Override // defpackage.t81
    public final boolean s(b91 b91Var, b91 b91Var2) {
        if (b91Var == null && b91Var2 == null) {
            return false;
        }
        if (b91Var != null && b91Var2 != null && b91Var2.a.containsKey("android:visibility:visibility") != b91Var.a.containsKey("android:visibility:visibility")) {
            return false;
        }
        hh1 hh1VarL = L(b91Var, b91Var2);
        if (hh1VarL.a) {
            return hh1VarL.c == 0 || hh1VarL.d == 0;
        }
        return false;
    }

    public b10(int i) {
        this();
        this.C = i;
    }
}
