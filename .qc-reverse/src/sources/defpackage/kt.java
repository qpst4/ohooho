package defpackage;

import android.os.Bundle;
import com.quickcursor.R;
import com.quickcursor.android.preferences.DetailedListPreference;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class kt extends dq0 {
    public int[] A0;
    public boolean[] B0;
    public String C0;
    public int w0;
    public CharSequence[] x0;
    public CharSequence[] y0;
    public CharSequence[] z0;

    @Override // defpackage.dq0, defpackage.wt, defpackage.j30
    public final void J(Bundle bundle) {
        super.J(bundle);
        if (bundle != null) {
            this.w0 = bundle.getInt("DetailedListPreferenceDialogFragment.index", 0);
            this.x0 = bundle.getCharSequenceArray("DetailedListPreferenceDialogFragment.entries");
            this.y0 = bundle.getCharSequenceArray("DetailedListPreferenceDialogFragment.entryDetails");
            this.z0 = bundle.getCharSequenceArray("DetailedListPreferenceDialogFragment.entryValues");
            this.A0 = bundle.getIntArray("DetailedListPreferenceDialogFragment.entryIcons");
            this.B0 = bundle.getBooleanArray("DetailedListPreferenceDialogFragment.entryFree");
            this.C0 = bundle.getString("DetailedListPreferenceDialogFragment.dialogTitle");
            return;
        }
        DetailedListPreference detailedListPreference = (DetailedListPreference) k0();
        CharSequence[] charSequenceArr = detailedListPreference.U;
        CharSequence[] charSequenceArr2 = detailedListPreference.V;
        if (charSequenceArr == null || charSequenceArr2 == null) {
            s1.f("ListPreference requires an entries array and an entryValues array.");
            return;
        }
        this.w0 = detailedListPreference.K(detailedListPreference.W);
        this.x0 = detailedListPreference.U;
        this.y0 = detailedListPreference.a0;
        this.z0 = charSequenceArr2;
        this.A0 = detailedListPreference.b0;
        this.B0 = detailedListPreference.Z;
        this.C0 = detailedListPreference.d0;
    }

    @Override // defpackage.dq0, defpackage.wt, defpackage.j30
    public final void S(Bundle bundle) {
        super.S(bundle);
        bundle.putInt("DetailedListPreferenceDialogFragment.index", this.w0);
        bundle.putCharSequenceArray("DetailedListPreferenceDialogFragment.entries", this.x0);
        bundle.putCharSequenceArray("DetailedListPreferenceDialogFragment.entryDetails", this.y0);
        bundle.putCharSequenceArray("DetailedListPreferenceDialogFragment.entryValues", this.z0);
        bundle.putIntArray("DetailedListPreferenceDialogFragment.entryIcons", this.A0);
        bundle.putBooleanArray("DetailedListPreferenceDialogFragment.entryIcons", this.B0);
        bundle.putString("DetailedListPreferenceDialogFragment.dialogTitle", this.C0);
    }

    @Override // defpackage.dq0
    public final void m0(boolean z) {
        int i;
        if (!z || (i = this.w0) < 0) {
            return;
        }
        String string = this.z0[i].toString();
        DetailedListPreference detailedListPreference = (DetailedListPreference) k0();
        if (detailedListPreference.a(string)) {
            detailedListPreference.M(string);
        }
    }

    @Override // defpackage.dq0
    public final void n0(jl1 jl1Var) {
        ArrayList arrayList = new ArrayList();
        boolean zC = zq0.b.c();
        int i = 0;
        while (true) {
            CharSequence[] charSequenceArr = this.x0;
            Boolean boolValueOf = null;
            if (i >= charSequenceArr.length) {
                break;
            }
            CharSequence charSequence = charSequenceArr[i];
            CharSequence[] charSequenceArr2 = this.y0;
            CharSequence charSequence2 = charSequenceArr2 == null ? null : charSequenceArr2[i];
            int[] iArr = this.A0;
            Integer numValueOf = iArr == null ? null : Integer.valueOf(iArr[i]);
            boolean[] zArr = this.B0;
            if (zArr != null && !zC) {
                boolValueOf = Boolean.valueOf(zArr[i]);
            }
            arrayList.add(new jt(charSequence, charSequence2, numValueOf, boolValueOf));
            i++;
        }
        jl1Var.f(new z6(R.layout.detailed_list_preference_row, u(), arrayList), new z2(6, this));
        String str = this.C0;
        if (str != null) {
            ((x6) jl1Var.c).e = str;
        }
        jl1Var.l(null, null);
    }
}
