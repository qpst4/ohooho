package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import com.quickcursor.R;
import defpackage.fp1;
import defpackage.j30;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class PreferenceScreen extends PreferenceGroup {
    public final boolean U;

    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, fp1.g(context, R.attr.preferenceScreenStyle, android.R.attr.preferenceScreenStyle), 0);
        this.U = true;
    }

    @Override // androidx.preference.Preference
    public final void p() {
        j30 j30Var;
        if (this.n != null || this.o != null || this.P.size() == 0 || (j30Var = this.c.j) == null) {
            return;
        }
        for (j30Var = this.c.j; j30Var != null; j30Var = j30Var.w) {
        }
    }
}
