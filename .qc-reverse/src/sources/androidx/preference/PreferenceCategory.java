package androidx.preference;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import com.quickcursor.R;
import defpackage.fp1;
import defpackage.nq0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class PreferenceCategory extends PreferenceGroup {
    public PreferenceCategory(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, fp1.g(context, R.attr.preferenceCategoryStyle, android.R.attr.preferenceCategoryStyle), 0);
    }

    @Override // androidx.preference.Preference
    public final boolean G() {
        return !super.j();
    }

    @Override // androidx.preference.Preference
    public final boolean j() {
        return false;
    }

    @Override // androidx.preference.Preference
    public final void o(nq0 nq0Var) {
        super.o(nq0Var);
        if (Build.VERSION.SDK_INT >= 28) {
            nq0Var.a.setAccessibilityHeading(true);
        }
    }
}
