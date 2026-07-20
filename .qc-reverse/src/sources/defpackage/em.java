package defpackage;

import android.view.View;
import android.view.Window;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class em implements dg0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ em(int i, Object obj) {
        this.b = i;
        this.c = obj;
    }

    @Override // defpackage.dg0
    public final void c(gg0 gg0Var, yf0 yf0Var) {
        Window window;
        View viewPeekDecorView;
        int i = this.b;
        Object obj = this.c;
        switch (i) {
            case 0:
                pm pmVar = (pm) obj;
                if (yf0Var == yf0.ON_STOP && (window = pmVar.getWindow()) != null && (viewPeekDecorView = window.peekDecorView()) != null) {
                    viewPeekDecorView.cancelPendingInputEvents();
                    break;
                }
                break;
            case 1:
                pm pmVar2 = (pm) obj;
                if (yf0Var == yf0.ON_DESTROY) {
                    pmVar2.c.b = null;
                    if (!pmVar2.isChangingConfigurations()) {
                        pmVar2.m().a();
                    }
                    km kmVar = pmVar2.g;
                    pm pmVar3 = kmVar.e;
                    pmVar3.getWindow().getDecorView().removeCallbacks(kmVar);
                    pmVar3.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(kmVar);
                }
                break;
            default:
                e8 e8Var = (e8) obj;
                e8Var.getClass();
                if (yf0Var == yf0.ON_START) {
                    e8Var.e = true;
                } else if (yf0Var == yf0.ON_STOP) {
                    e8Var.e = false;
                }
                break;
        }
    }
}
