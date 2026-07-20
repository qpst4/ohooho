package defpackage;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.quickcursor.android.views.settings.ActionsRecyclerView;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class rc0 extends GestureDetector.SimpleOnGestureListener {
    public boolean a = true;
    public final /* synthetic */ sc0 b;

    public rc0(sc0 sc0Var) {
        this.b = sc0Var;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
        View viewK;
        sc0 sc0Var = this.b;
        t3 t3Var = sc0Var.m;
        if (!this.a || (viewK = sc0Var.k(motionEvent)) == null || sc0Var.r.I(viewK) == null) {
            return;
        }
        ActionsRecyclerView actionsRecyclerView = sc0Var.r;
        t3Var.getClass();
        WeakHashMap weakHashMap = uf1.a;
        if ((t3.b(208947, actionsRecyclerView.getLayoutDirection()) & 16711680) != 0) {
            int pointerId = motionEvent.getPointerId(0);
            int i = sc0Var.l;
            if (pointerId == i) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i);
                float x = motionEvent.getX(iFindPointerIndex);
                float y = motionEvent.getY(iFindPointerIndex);
                sc0Var.d = x;
                sc0Var.e = y;
                sc0Var.i = 0.0f;
                sc0Var.h = 0.0f;
                t3Var.getClass();
            }
        }
    }
}
