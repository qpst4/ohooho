package defpackage;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g2 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int b;

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.b) {
            case 0:
                dialogInterface.dismiss();
                break;
            case 1:
                dialogInterface.dismiss();
                break;
            case 2:
                yb0.y(R.string.missing_resolution_dialog_restore_canceled, 0);
                break;
            case 3:
                si0.a("onCursorTipPositionClicked() onDismiss()");
                break;
            case 4:
                pn0 pn0VarT = pn0.t();
                ((SharedPreferences) pn0VarT.d).edit().putString(oq0.g.name(), "").apply();
                pn0VarT.b("Logs cleared!");
                yb0.y(R.string.debug_toast_logs_cleared, 0);
                break;
            case 6:
                dialogInterface.dismiss();
                break;
        }
    }

    public /* synthetic */ g2(int i) {
        this.b = i;
    }

    private final void a(DialogInterface dialogInterface, int i) {
    }
}
