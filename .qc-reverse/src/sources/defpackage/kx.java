package defpackage;

import android.R;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.preference.EditTextPreference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class kx extends dq0 {
    public EditText w0;
    public CharSequence x0;
    public final nc y0 = new nc(6, this);
    public long z0 = -1;

    @Override // defpackage.dq0, defpackage.wt, defpackage.j30
    public final void J(Bundle bundle) {
        super.J(bundle);
        if (bundle == null) {
            this.x0 = ((EditTextPreference) k0()).U;
        } else {
            this.x0 = bundle.getCharSequence("EditTextPreferenceDialogFragment.text");
        }
    }

    @Override // defpackage.dq0, defpackage.wt, defpackage.j30
    public final void S(Bundle bundle) {
        super.S(bundle);
        bundle.putCharSequence("EditTextPreferenceDialogFragment.text", this.x0);
    }

    @Override // defpackage.dq0
    public final void l0(View view) {
        super.l0(view);
        EditText editText = (EditText) view.findViewById(R.id.edit);
        this.w0 = editText;
        if (editText == null) {
            s1.f("Dialog view must contain an EditText with id @android:id/edit");
            return;
        }
        editText.requestFocus();
        this.w0.setText(this.x0);
        EditText editText2 = this.w0;
        editText2.setSelection(editText2.getText().length());
        ((EditTextPreference) k0()).getClass();
    }

    @Override // defpackage.dq0
    public final void m0(boolean z) {
        if (z) {
            String string = this.w0.getText().toString();
            EditTextPreference editTextPreference = (EditTextPreference) k0();
            if (editTextPreference.a(string)) {
                editTextPreference.K(string);
            }
        }
    }

    public final void o0() {
        long j = this.z0;
        if (j == -1 || j + 1000 <= SystemClock.currentThreadTimeMillis()) {
            return;
        }
        EditText editText = this.w0;
        if (editText == null || !editText.isFocused()) {
            this.z0 = -1L;
            return;
        }
        if (((InputMethodManager) this.w0.getContext().getSystemService("input_method")).showSoftInput(this.w0, 0)) {
            this.z0 = -1L;
            return;
        }
        EditText editText2 = this.w0;
        nc ncVar = this.y0;
        editText2.removeCallbacks(ncVar);
        this.w0.postDelayed(ncVar, 50L);
    }
}
