package defpackage;

import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import com.quickcursor.R;
import com.quickcursor.android.drawables.globals.EdgeActionsDrawable;
import com.quickcursor.android.drawables.globals.RippleDrawable;
import com.quickcursor.android.drawables.globals.trackers.TrackerDrawable;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class r60 {
    public static WindowManager b;
    public static ff1 c;
    public static x00 f;
    public static jj g;
    public static TrackerDrawable h;
    public static yq i;
    public static o80 j;
    public static o80 k;
    public static b60 l;
    public static o81 m;
    public static EdgeActionsDrawable n;
    public static y91 o;
    public static HashMap p;
    public static s91 q;
    public static sr r;
    public static boolean s;
    public static final bk a = new bk(3000);
    public static final CopyOnWriteArrayList d = new CopyOnWriteArrayList();
    public static final CopyOnWriteArrayList e = new CopyOnWriteArrayList();

    public static boolean a(Canvas canvas, s60 s60Var) {
        if (s60Var == null) {
            return false;
        }
        if (!s60Var.a()) {
            s60Var.draw(canvas);
        }
        return s60Var.c();
    }

    public static void b() {
        i.h();
        EdgeActionsDrawable edgeActionsDrawable = n;
        if (edgeActionsDrawable != null) {
            edgeActionsDrawable.g(false);
        }
        c.invalidate();
    }

    public static void c(int i2, int i3) {
        TrackerDrawable trackerDrawable = h;
        if (trackerDrawable.D.isEmpty()) {
            yb0.A(R.string.tracker_actions_no_actions_configured_warning);
        } else {
            trackerDrawable.r(i2, i3);
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(trackerDrawable, "actionsAnimation", trackerDrawable.f, 1.0f);
            trackerDrawable.e = objectAnimatorOfFloat;
            DecelerateInterpolator decelerateInterpolator = TrackerDrawable.J;
            objectAnimatorOfFloat.setInterpolator(decelerateInterpolator);
            trackerDrawable.e.setDuration(300L);
            trackerDrawable.e.start();
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(trackerDrawable, "sizeAnimation", trackerDrawable.h, trackerDrawable.o);
            trackerDrawable.d = objectAnimatorOfInt;
            objectAnimatorOfInt.setInterpolator(decelerateInterpolator);
            trackerDrawable.d.setDuration(300L);
            trackerDrawable.d.start();
        }
        c.invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x018a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void d(com.quickcursor.android.services.CursorAccessibilityService r7) {
        /*
            Method dump skipped, instruction units count: 523
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.r60.d(com.quickcursor.android.services.CursorAccessibilityService):void");
    }

    public static void e(int i2, int i3) {
        i.l();
        yq yqVar = i;
        yqVar.b = i2;
        yqVar.c = i3;
        c.invalidate();
    }

    public static void f(int i2, int i3, int i4, int i5, int i6) {
        e.add(new kg0(i2, i3, i4, i5, i6, i.g()));
        c.invalidate();
    }

    public static void g(int i2, int i3, boolean z) {
        TrackerDrawable trackerDrawable = h;
        TrackerDrawable.f(trackerDrawable.b);
        trackerDrawable.i = i2;
        trackerDrawable.j = i3;
        trackerDrawable.r(i2, i3);
        TrackerDrawable.f(trackerDrawable.c);
        TrackerDrawable.f(trackerDrawable.d);
        TrackerDrawable.f(trackerDrawable.b);
        TrackerDrawable.f(trackerDrawable.e);
        trackerDrawable.f = z ? 1.0f : 0.0f;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(trackerDrawable, "alphaAnimation", 0.0f, 1.0f);
        trackerDrawable.c = objectAnimatorOfFloat;
        DecelerateInterpolator decelerateInterpolator = TrackerDrawable.J;
        objectAnimatorOfFloat.setInterpolator(decelerateInterpolator);
        trackerDrawable.c.setDuration(300L);
        trackerDrawable.c.start();
        int i4 = trackerDrawable.h;
        int i5 = trackerDrawable.k;
        if (i4 != i5) {
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(trackerDrawable, "sizeAnimation", i4, i5);
            trackerDrawable.d = objectAnimatorOfInt;
            objectAnimatorOfInt.setInterpolator(decelerateInterpolator);
            trackerDrawable.d.setDuration(300L);
            trackerDrawable.d.start();
        }
        c.invalidate();
    }

    public static void h(int i2, int i3, int i4) {
        d.add(new RippleDrawable(i3, i4, i2));
        c.invalidate();
    }

    public static void i(f91 f91Var) {
        if (o == null) {
            o = new y91();
        }
        y91 y91Var = o;
        y91Var.d = f91Var;
        y91Var.f = new u91(f91Var);
        q91 q91VarJ = f91Var.b().j();
        y91Var.e = q91VarJ;
        y91Var.c.setColor(q91VarJ.e());
        Paint paint = y91Var.b;
        paint.setColor(y91Var.e.g());
        paint.setStrokeWidth(y91Var.e.h());
        db dbVarH = f91Var.h();
        int i2 = x91.a[f91Var.e().ordinal()];
        if (i2 == 1) {
            y91Var.g = (dbVarH.f() / 2) + dbVarH.d();
            y91Var.h = dbVarH.e();
        } else if (i2 == 2) {
            y91Var.g = (dbVarH.f() / 2) + dbVarH.d();
            y91Var.h = dbVarH.c() + dbVarH.e();
        } else if (i2 == 3) {
            y91Var.g = dbVarH.d();
            y91Var.h = (dbVarH.c() / 2) + dbVarH.e();
        } else if (i2 == 4) {
            y91Var.g = dbVarH.f() + dbVarH.d();
            y91Var.h = (dbVarH.c() / 2) + dbVarH.e();
        }
        c.invalidate();
        a.a(new s4(8));
    }

    public static void j(boolean z) {
        ff1 ff1Var = c;
        if (ff1Var != null) {
            ff1Var.getView().setAlpha(z ? 0.0f : 1.0f);
        }
    }

    public static void k() {
        ff1 ff1Var = c;
        if (ff1Var == null || b == null) {
            return;
        }
        ff1Var.getView().setVisibility(8);
        try {
            b.removeView(c.getView());
        } catch (Exception unused) {
        }
    }

    public static void l(int i2, int i3) {
        TrackerDrawable trackerDrawable = h;
        TrackerDrawable.f(trackerDrawable.b);
        trackerDrawable.i = i2;
        trackerDrawable.j = i3;
        c.invalidate();
    }
}
