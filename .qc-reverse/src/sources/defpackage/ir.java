package defpackage;

import android.os.Bundle;
import androidx.preference.DialogPreference;
import com.quickcursor.android.preferences.DetailedListPreference;
import com.quickcursor.android.preferences.SeekBarDialogPreference;
import com.rarepebble.colorpicker.ColorPreference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ir extends gq0 {
    @Override // defpackage.gq0
    public final void j0(DialogPreference dialogPreference) {
        if (dialogPreference instanceof ColorPreference) {
            String str = ((ColorPreference) dialogPreference).m;
            ul ulVar = new ul();
            Bundle bundle = new Bundle(1);
            bundle.putString("key", str);
            ulVar.c0(bundle);
            ulVar.d0(this);
            y30 y30Var = this.t;
            if (y30Var != null) {
                ulVar.j0(y30Var, str);
                t().getWindow().setSoftInputMode(2);
                return;
            }
            return;
        }
        if (dialogPreference instanceof DetailedListPreference) {
            String str2 = dialogPreference.m;
            kt ktVar = new kt();
            Bundle bundle2 = new Bundle(1);
            bundle2.putString("key", str2);
            ktVar.c0(bundle2);
            ktVar.d0(this);
            ktVar.j0(x(), str2);
            return;
        }
        if (!(dialogPreference instanceof SeekBarDialogPreference)) {
            super.j0(dialogPreference);
            return;
        }
        String str3 = dialogPreference.m;
        ry0 ry0Var = new ry0();
        Bundle bundle3 = new Bundle(1);
        bundle3.putString("key", str3);
        ry0Var.c0(bundle3);
        ry0Var.d0(this);
        ry0Var.j0(x(), str3);
    }
}
