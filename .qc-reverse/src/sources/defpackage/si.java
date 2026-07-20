package defpackage;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class si implements View.OnAttachStateChangeListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ si(int i, Object obj) {
        this.b = i;
        this.c = obj;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        int i = this.b;
        Object obj = this.c;
        switch (i) {
            case 1:
                hz hzVar = (hz) obj;
                AccessibilityManager accessibilityManager = hzVar.u;
                if (hzVar.v != null && accessibilityManager != null) {
                    WeakHashMap weakHashMap = uf1.a;
                    if (hzVar.isAttachedToWindow()) {
                        accessibilityManager.addTouchExplorationStateChangeListener(new a0(hzVar.v));
                    }
                    break;
                }
                break;
            case 2:
                View view2 = (View) obj;
                view2.removeOnAttachStateChangeListener(this);
                WeakHashMap weakHashMap2 = uf1.a;
                jf1.c(view2);
                break;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        AccessibilityManager accessibilityManager;
        int i = this.b;
        Object obj = this.c;
        switch (i) {
            case 0:
                vi viVar = (vi) obj;
                ViewTreeObserver viewTreeObserver = viVar.y;
                if (viewTreeObserver != null) {
                    if (!viewTreeObserver.isAlive()) {
                        viVar.y = view.getViewTreeObserver();
                    }
                    viVar.y.removeGlobalOnLayoutListener(viVar.j);
                }
                view.removeOnAttachStateChangeListener(this);
                break;
            case 1:
                hz hzVar = (hz) obj;
                r1 r1Var = hzVar.v;
                if (r1Var != null && (accessibilityManager = hzVar.u) != null) {
                    accessibilityManager.removeTouchExplorationStateChangeListener(new a0(r1Var));
                    break;
                }
                break;
            case 2:
                break;
            default:
                m21 m21Var = (m21) obj;
                ViewTreeObserver viewTreeObserver2 = m21Var.p;
                if (viewTreeObserver2 != null) {
                    if (!viewTreeObserver2.isAlive()) {
                        m21Var.p = view.getViewTreeObserver();
                    }
                    m21Var.p.removeGlobalOnLayoutListener(m21Var.j);
                }
                view.removeOnAttachStateChangeListener(this);
                break;
        }
    }

    private final void a(View view) {
    }

    private final void b(View view) {
    }

    private final void c(View view) {
    }
}
