package defpackage;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class uj implements View.OnLongClickListener {
    public final /* synthetic */ int b;

    public uj(int i) {
        this.b = i;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        return xy0.a(view, view.getContext().getString(this.b));
    }
}
