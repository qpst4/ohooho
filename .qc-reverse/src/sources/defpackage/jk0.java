package defpackage;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class jk0<S> extends op0 {
    public int Z;
    public fi a0;

    @Override // defpackage.j30
    public final void J(Bundle bundle) {
        super.J(bundle);
        if (bundle == null) {
            bundle = this.h;
        }
        this.Z = bundle.getInt("THEME_RES_ID_KEY");
        if (bundle.getParcelable("DATE_SELECTOR_KEY") == null) {
            this.a0 = (fi) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        } else {
            s1.d();
        }
    }

    @Override // defpackage.j30
    public final View K(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        layoutInflater.cloneInContext(new ContextThemeWrapper(u(), this.Z));
        throw null;
    }

    @Override // defpackage.j30
    public final void S(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.Z);
        bundle.putParcelable("DATE_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.a0);
    }
}
