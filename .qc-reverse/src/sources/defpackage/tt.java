package defpackage;

import android.app.Dialog;
import android.content.DialogInterface;
import com.nabinbhandari.android.permissions.PermissionsActivity;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class tt implements DialogInterface.OnCancelListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ tt(int i, Object obj) {
        this.b = i;
        this.c = obj;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        int i = this.b;
        Object obj = this.c;
        switch (i) {
            case 0:
                wt wtVar = (wt) obj;
                Dialog dialog = wtVar.j0;
                if (dialog != null) {
                    wtVar.onCancel(dialog);
                }
                break;
            default:
                sp1 sp1Var = PermissionsActivity.f;
                ((PermissionsActivity) obj).a();
                break;
        }
    }
}
