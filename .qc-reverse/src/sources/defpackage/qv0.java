package defpackage;

import android.animation.ValueAnimator;
import android.os.Handler;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class qv0 implements Runnable {
    public final /* synthetic */ int b;
    public Object c;
    public Object d;
    public Object e;

    public qv0(View view, ci1 ci1Var, pn0 pn0Var, ValueAnimator valueAnimator) {
        this.b = 1;
        this.c = view;
        this.d = pn0Var;
        this.e = valueAnimator;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object objCall;
        switch (this.b) {
            case 0:
                try {
                    objCall = ((p20) this.c).call();
                } catch (Exception unused) {
                    objCall = null;
                }
                ((Handler) this.e).post(new vn1((q20) this.d, 10, objCall));
                break;
            case 1:
                yh1.h((View) this.c, (pn0) this.d);
                ((ValueAnimator) this.e).start();
                break;
            case 2:
                ((ul1) this.c).A((gs0) this.d, (ir0) this.e);
                break;
            default:
                ((ul1) this.c).z((c1) this.d, (s1) this.e);
                break;
        }
    }

    public /* synthetic */ qv0(ul1 ul1Var, Object obj, Object obj2, int i) {
        this.b = i;
        this.c = ul1Var;
        this.d = obj;
        this.e = obj2;
    }

    public /* synthetic */ qv0() {
        this.b = 0;
    }
}
