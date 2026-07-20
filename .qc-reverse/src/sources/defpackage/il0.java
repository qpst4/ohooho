package defpackage;

import android.widget.PopupWindow;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class il0 implements PopupWindow.OnDismissListener {
    public final /* synthetic */ jl0 b;

    public il0(jl0 jl0Var) {
        this.b = jl0Var;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.b.c();
    }
}
