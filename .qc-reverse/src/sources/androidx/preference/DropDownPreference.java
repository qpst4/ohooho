package androidx.preference;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import com.quickcursor.R;
import defpackage.cv;
import defpackage.nq0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class DropDownPreference extends ListPreference {
    public final ArrayAdapter Z;
    public Spinner a0;
    public final cv b0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DropDownPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.dropdownPreferenceStyle, 0);
        this.b0 = new cv(0, this);
        ArrayAdapter arrayAdapter = new ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item);
        this.Z = arrayAdapter;
        arrayAdapter.clear();
        CharSequence[] charSequenceArr = this.U;
        if (charSequenceArr != null) {
            for (CharSequence charSequence : charSequenceArr) {
                arrayAdapter.add(charSequence.toString());
            }
        }
    }

    @Override // androidx.preference.Preference
    public final void k() {
        super.k();
        ArrayAdapter arrayAdapter = this.Z;
        if (arrayAdapter != null) {
            arrayAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.preference.Preference
    public final void o(nq0 nq0Var) {
        int length;
        CharSequence[] charSequenceArr;
        Spinner spinner = (Spinner) nq0Var.a.findViewById(R.id.spinner);
        this.a0 = spinner;
        spinner.setAdapter((SpinnerAdapter) this.Z);
        this.a0.setOnItemSelectedListener(this.b0);
        Spinner spinner2 = this.a0;
        String str = this.W;
        if (str == null || (charSequenceArr = this.V) == null) {
            length = -1;
        } else {
            length = charSequenceArr.length - 1;
            while (length >= 0) {
                if (TextUtils.equals(charSequenceArr[length].toString(), str)) {
                    break;
                } else {
                    length--;
                }
            }
            length = -1;
        }
        spinner2.setSelection(length);
        super.o(nq0Var);
    }

    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    public final void p() {
        this.a0.performClick();
    }
}
