package defpackage;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class oc0 implements cu0 {
    public final /* synthetic */ sc0 a;

    public oc0(sc0 sc0Var) {
        this.a = sc0Var;
    }

    @Override // defpackage.cu0
    public final void a(MotionEvent motionEvent) {
        sc0 sc0Var = this.a;
        nc ncVar = sc0Var.s;
        ((GestureDetector) sc0Var.x.c).onTouchEvent(motionEvent);
        VelocityTracker velocityTracker = sc0Var.t;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        if (sc0Var.l == -1) {
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        int iFindPointerIndex = motionEvent.findPointerIndex(sc0Var.l);
        if (iFindPointerIndex >= 0) {
            sc0Var.h(actionMasked, iFindPointerIndex, motionEvent);
        }
        pu0 pu0Var = sc0Var.c;
        if (pu0Var == null) {
            return;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                if (iFindPointerIndex >= 0) {
                    sc0Var.p(sc0Var.o, iFindPointerIndex, motionEvent);
                    sc0Var.n(pu0Var);
                    sc0Var.r.removeCallbacks(ncVar);
                    ncVar.run();
                    sc0Var.r.invalidate();
                    return;
                }
                return;
            }
            if (actionMasked != 3) {
                if (actionMasked != 6) {
                    return;
                }
                int actionIndex = motionEvent.getActionIndex();
                if (motionEvent.getPointerId(actionIndex) == sc0Var.l) {
                    sc0Var.l = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
                    sc0Var.p(sc0Var.o, actionIndex, motionEvent);
                    return;
                }
                return;
            }
            VelocityTracker velocityTracker2 = sc0Var.t;
            if (velocityTracker2 != null) {
                velocityTracker2.clear();
            }
        }
        sc0Var.o(null, 0);
        sc0Var.l = -1;
    }

    @Override // defpackage.cu0
    public final boolean b(MotionEvent motionEvent) {
        int iFindPointerIndex;
        sc0 sc0Var = this.a;
        ((GestureDetector) sc0Var.x.c).onTouchEvent(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        pc0 pc0Var = null;
        if (actionMasked == 0) {
            sc0Var.l = motionEvent.getPointerId(0);
            sc0Var.d = motionEvent.getX();
            sc0Var.e = motionEvent.getY();
            VelocityTracker velocityTracker = sc0Var.t;
            if (velocityTracker != null) {
                velocityTracker.recycle();
            }
            sc0Var.t = VelocityTracker.obtain();
            if (sc0Var.c == null) {
                ArrayList arrayList = sc0Var.p;
                if (!arrayList.isEmpty()) {
                    View viewK = sc0Var.k(motionEvent);
                    int size = arrayList.size() - 1;
                    while (true) {
                        if (size < 0) {
                            break;
                        }
                        pc0 pc0Var2 = (pc0) arrayList.get(size);
                        if (pc0Var2.e.a == viewK) {
                            pc0Var = pc0Var2;
                            break;
                        }
                        size--;
                    }
                }
                if (pc0Var != null) {
                    pu0 pu0Var = pc0Var.e;
                    sc0Var.d -= pc0Var.i;
                    sc0Var.e -= pc0Var.j;
                    sc0Var.j(pu0Var, true);
                    if (sc0Var.a.remove(pu0Var.a)) {
                        sc0Var.m.getClass();
                        t3.a(pu0Var);
                    }
                    sc0Var.o(pu0Var, pc0Var.f);
                    sc0Var.p(sc0Var.o, 0, motionEvent);
                }
            }
        } else if (actionMasked == 3 || actionMasked == 1) {
            sc0Var.l = -1;
            sc0Var.o(null, 0);
        } else {
            int i = sc0Var.l;
            if (i != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i)) >= 0) {
                sc0Var.h(actionMasked, iFindPointerIndex, motionEvent);
            }
        }
        VelocityTracker velocityTracker2 = sc0Var.t;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        return sc0Var.c != null;
    }

    @Override // defpackage.cu0
    public final void c(boolean z) {
        if (z) {
            this.a.o(null, 0);
        }
    }
}
