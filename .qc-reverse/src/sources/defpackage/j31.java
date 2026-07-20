package defpackage;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class j31 extends wt {
    public Dialog o0;
    public DialogInterface.OnCancelListener p0;
    public AlertDialog q0;

    @Override // defpackage.wt
    public final Dialog i0() {
        Dialog dialog = this.o0;
        if (dialog != null) {
            return dialog;
        }
        this.f0 = false;
        if (this.q0 == null) {
            Context contextU = u();
            xy0.d(contextU);
            this.q0 = new AlertDialog.Builder(contextU).create();
        }
        return this.q0;
    }

    @Override // defpackage.wt, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.p0;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }
}
