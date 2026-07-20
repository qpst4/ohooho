package defpackage;

import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b30 implements View.OnTouchListener, View.OnAttachStateChangeListener {
    public final float b;
    public final int c;
    public final int d;
    public final View e;
    public a30 f;
    public a30 g;
    public boolean h;
    public int i;
    public final int[] j = new int[2];

    public b30(View view) {
        this.e = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.b = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.c = tapTimeout;
        this.d = (ViewConfiguration.getLongPressTimeout() + tapTimeout) / 2;
    }

    public final void a() {
        a30 a30Var = this.g;
        View view = this.e;
        if (a30Var != null) {
            view.removeCallbacks(a30Var);
        }
        a30 a30Var2 = this.f;
        if (a30Var2 != null) {
            view.removeCallbacks(a30Var2);
        }
    }

    public abstract n01 b();

    public abstract boolean c();

    public boolean d() {
        n01 n01VarB = b();
        if (n01VarB == null || !n01VarB.b()) {
            return true;
        }
        n01VarB.dismiss();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00fe  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r13, android.view.MotionEvent r14) {
        /*
            Method dump skipped, instruction units count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.b30.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.h = false;
        this.i = -1;
        a30 a30Var = this.f;
        if (a30Var != null) {
            this.e.removeCallbacks(a30Var);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
