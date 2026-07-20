package defpackage;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class a30 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ b30 c;

    public /* synthetic */ a30(b30 b30Var, int i) {
        this.b = i;
        this.c = b30Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        b30 b30Var = this.c;
        switch (i) {
            case 0:
                ViewParent parent = b30Var.e.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                break;
            default:
                b30Var.a();
                View view = b30Var.e;
                if (view.isEnabled() && !view.isLongClickable() && b30Var.c()) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                    view.onTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                    b30Var.h = true;
                    break;
                }
                break;
        }
    }
}
