package defpackage;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class nz extends DialogFragment {
    public Dialog b;
    public DialogInterface.OnCancelListener c;
    public AlertDialog d;

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.c;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.b;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.d == null) {
            Activity activity = getActivity();
            xy0.d(activity);
            this.d = new AlertDialog.Builder(activity).create();
        }
        return this.d;
    }
}
