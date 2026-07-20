package defpackage;

import android.os.Bundle;
import androidx.preference.MultiSelectListPreference;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class gm0 extends dq0 {
    public final HashSet w0 = new HashSet();
    public boolean x0;
    public CharSequence[] y0;
    public CharSequence[] z0;

    @Override // defpackage.dq0, defpackage.wt, defpackage.j30
    public final void J(Bundle bundle) {
        super.J(bundle);
        HashSet hashSet = this.w0;
        if (bundle != null) {
            hashSet.clear();
            hashSet.addAll(bundle.getStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values"));
            this.x0 = bundle.getBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", false);
            this.y0 = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries");
            this.z0 = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues");
            return;
        }
        MultiSelectListPreference multiSelectListPreference = (MultiSelectListPreference) k0();
        CharSequence[] charSequenceArr = multiSelectListPreference.U;
        CharSequence[] charSequenceArr2 = multiSelectListPreference.V;
        if (charSequenceArr == null || charSequenceArr2 == null) {
            s1.f("MultiSelectListPreference requires an entries array and an entryValues array.");
            return;
        }
        hashSet.clear();
        hashSet.addAll(multiSelectListPreference.W);
        this.x0 = false;
        this.y0 = multiSelectListPreference.U;
        this.z0 = charSequenceArr2;
    }

    @Override // defpackage.dq0, defpackage.wt, defpackage.j30
    public final void S(Bundle bundle) {
        super.S(bundle);
        bundle.putStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values", new ArrayList<>(this.w0));
        bundle.putBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", this.x0);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries", this.y0);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues", this.z0);
    }

    @Override // defpackage.dq0
    public final void m0(boolean z) {
        if (z && this.x0) {
            MultiSelectListPreference multiSelectListPreference = (MultiSelectListPreference) k0();
            HashSet hashSet = this.w0;
            if (multiSelectListPreference.a(hashSet)) {
                multiSelectListPreference.K(hashSet);
            }
        }
        this.x0 = false;
    }

    @Override // defpackage.dq0
    public final void n0(jl1 jl1Var) {
        int length = this.z0.length;
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            zArr[i] = this.w0.contains(this.z0[i].toString());
        }
        CharSequence[] charSequenceArr = this.y0;
        fm0 fm0Var = new fm0(this);
        x6 x6Var = (x6) jl1Var.c;
        x6Var.r = charSequenceArr;
        x6Var.z = fm0Var;
        x6Var.v = zArr;
        x6Var.w = true;
    }
}
