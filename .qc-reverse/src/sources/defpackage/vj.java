package defpackage;

import android.widget.CompoundButton;
import androidx.preference.CheckBoxPreference;
import androidx.preference.SwitchPreference;
import androidx.preference.SwitchPreferenceCompat;
import androidx.preference.TwoStatePreference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class vj implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ TwoStatePreference b;

    public /* synthetic */ vj(TwoStatePreference twoStatePreference, int i) {
        this.a = i;
        this.b = twoStatePreference;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        int i = this.a;
        TwoStatePreference twoStatePreference = this.b;
        switch (i) {
            case 0:
                CheckBoxPreference checkBoxPreference = (CheckBoxPreference) twoStatePreference;
                if (!checkBoxPreference.a(Boolean.valueOf(z))) {
                    compoundButton.setChecked(!z);
                } else {
                    checkBoxPreference.J(z);
                }
                break;
            case 1:
                SwitchPreference switchPreference = (SwitchPreference) twoStatePreference;
                if (!switchPreference.a(Boolean.valueOf(z))) {
                    compoundButton.setChecked(!z);
                } else {
                    switchPreference.J(z);
                }
                break;
            default:
                SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) twoStatePreference;
                if (!switchPreferenceCompat.a(Boolean.valueOf(z))) {
                    compoundButton.setChecked(!z);
                } else {
                    switchPreferenceCompat.J(z);
                }
                break;
        }
    }
}
