package defpackage;

import android.os.Bundle;
import androidx.preference.Preference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class hh extends t1 {
    @Override // defpackage.t1, defpackage.d3, defpackage.gq0, defpackage.j30
    public final void J(Bundle bundle) {
        super.J(bundle);
        Preference preferenceH0 = h0("brightnessCalibrate");
        if (preferenceH0 != null) {
            preferenceH0.g = new r1(5, this);
        }
    }
}
