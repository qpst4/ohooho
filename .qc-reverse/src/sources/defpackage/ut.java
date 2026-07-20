package defpackage;

import android.app.Dialog;
import android.content.DialogInterface;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ut implements DialogInterface.OnDismissListener {
    public final /* synthetic */ wt b;

    public ut(wt wtVar) {
        this.b = wtVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        wt wtVar = this.b;
        Dialog dialog = wtVar.j0;
        if (dialog != null) {
            wtVar.onDismiss(dialog);
        }
    }
}
