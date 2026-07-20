package defpackage;

import android.content.DialogInterface;
import com.nabinbhandari.android.permissions.PermissionsActivity;
import com.rarepebble.colorpicker.ColorPreference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class tl implements DialogInterface.OnClickListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ tl(int i, Object obj) {
        this.b = i;
        this.c = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = this.b;
        Object obj = this.c;
        switch (i2) {
            case 0:
                ColorPreference colorPreference = (ColorPreference) obj;
                if (colorPreference.a(null)) {
                    colorPreference.L(null);
                }
                break;
            case 1:
                th0 th0Var = (th0) obj;
                th0Var.w0 = i;
                th0Var.onClick(dialogInterface, -1);
                dialogInterface.dismiss();
                break;
            default:
                PermissionsActivity permissionsActivity = (PermissionsActivity) obj;
                if (i != -1) {
                    sp1 sp1Var = PermissionsActivity.f;
                    permissionsActivity.a();
                } else {
                    permissionsActivity.requestPermissions(PermissionsActivity.b(permissionsActivity.c), 6937);
                }
                break;
        }
    }
}
