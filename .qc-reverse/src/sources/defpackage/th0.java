package defpackage;

import android.os.Bundle;
import androidx.preference.ListPreference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class th0 extends dq0 {
    public int w0;
    public CharSequence[] x0;
    public CharSequence[] y0;

    @Override // defpackage.dq0, defpackage.wt, defpackage.j30
    public final void J(Bundle bundle) {
        super.J(bundle);
        if (bundle != null) {
            this.w0 = bundle.getInt("ListPreferenceDialogFragment.index", 0);
            this.x0 = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entries");
            this.y0 = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entryValues");
            return;
        }
        ListPreference listPreference = (ListPreference) k0();
        CharSequence[] charSequenceArr = listPreference.U;
        CharSequence[] charSequenceArr2 = listPreference.V;
        if (charSequenceArr == null || charSequenceArr2 == null) {
            s1.f("ListPreference requires an entries array and an entryValues array.");
            return;
        }
        this.w0 = listPreference.K(listPreference.W);
        this.x0 = listPreference.U;
        this.y0 = charSequenceArr2;
    }

    @Override // defpackage.dq0, defpackage.wt, defpackage.j30
    public final void S(Bundle bundle) {
        super.S(bundle);
        bundle.putInt("ListPreferenceDialogFragment.index", this.w0);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entries", this.x0);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entryValues", this.y0);
    }

    @Override // defpackage.dq0
    public final void m0(boolean z) {
        int i;
        if (!z || (i = this.w0) < 0) {
            return;
        }
        String string = this.y0[i].toString();
        ListPreference listPreference = (ListPreference) k0();
        if (listPreference.a(string)) {
            listPreference.M(string);
        }
    }

    @Override // defpackage.dq0
    public final void n0(jl1 jl1Var) {
        CharSequence[] charSequenceArr = this.x0;
        int i = this.w0;
        tl tlVar = new tl(1, this);
        x6 x6Var = (x6) jl1Var.c;
        x6Var.r = charSequenceArr;
        x6Var.t = tlVar;
        x6Var.y = i;
        x6Var.x = true;
        jl1Var.l(null, null);
    }
}
