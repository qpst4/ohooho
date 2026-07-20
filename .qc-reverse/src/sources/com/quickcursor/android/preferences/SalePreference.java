package com.quickcursor.android.preferences;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.preference.Preference;
import com.quickcursor.App;
import com.quickcursor.R;
import defpackage.jx0;
import defpackage.nq0;
import defpackage.xg;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class SalePreference extends Preference {
    public View O;
    public xg P;

    public SalePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void J(boolean z) {
        View view = this.O;
        if (view == null) {
            this.P = new xg((Runnable) new jx0(this, z));
        } else {
            view.setBackgroundColor(z ? App.c.getColor(R.color.colorAccentTransparentSale) : 0);
            this.O.findViewById(R.id.saleImage).setVisibility(z ? 0 : 4);
        }
    }

    @Override // androidx.preference.Preference
    public final void o(nq0 nq0Var) {
        super.o(nq0Var);
        this.O = nq0Var.a;
        xg xgVar = this.P;
        if (xgVar != null) {
            xgVar.d();
        }
    }
}
