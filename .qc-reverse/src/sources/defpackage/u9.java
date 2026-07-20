package defpackage;

import android.view.ViewTreeObserver;
import android.widget.PopupWindow;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class u9 implements PopupWindow.OnDismissListener {
    public final /* synthetic */ p9 b;
    public final /* synthetic */ v9 c;

    public u9(v9 v9Var, p9 p9Var) {
        this.c = v9Var;
        this.b = p9Var;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        ViewTreeObserver viewTreeObserver = this.c.H.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.b);
        }
    }
}
