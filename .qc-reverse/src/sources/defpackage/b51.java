package defpackage;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class b51 implements TextWatcher {
    public int b;
    public final /* synthetic */ EditText c;
    public final /* synthetic */ TextInputLayout d;

    public b51(TextInputLayout textInputLayout, EditText editText) {
        this.d = textInputLayout;
        this.c = editText;
        this.b = editText.getLineCount();
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        TextInputLayout textInputLayout = this.d;
        textInputLayout.u(!textInputLayout.B0, false);
        if (textInputLayout.l) {
            textInputLayout.n(editable);
        }
        if (textInputLayout.t) {
            textInputLayout.v(editable);
        }
        EditText editText = this.c;
        int lineCount = editText.getLineCount();
        int i = this.b;
        if (lineCount != i) {
            if (lineCount < i) {
                WeakHashMap weakHashMap = uf1.a;
                int minimumHeight = editText.getMinimumHeight();
                int i2 = textInputLayout.u0;
                if (minimumHeight != i2) {
                    editText.setMinimumHeight(i2);
                }
            }
            this.b = lineCount;
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
