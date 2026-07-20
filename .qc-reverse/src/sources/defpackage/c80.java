package defpackage;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class c80 implements ql, TextWatcher {
    public final /* synthetic */ EditText b;
    public final /* synthetic */ f9 c;

    public c80(EditText editText, f9 f9Var) {
        this.b = editText;
        this.c = f9Var;
    }

    @Override // defpackage.ql
    public final void a(f9 f9Var) {
        int iHSVToColor = Color.HSVToColor(f9Var.b, (float[]) f9Var.c);
        EditText editText = this.b;
        String str = editText.getFilters() == e80.a ? String.format("%06x", Integer.valueOf(iHSVToColor & 16777215)) : String.format("%08x", Integer.valueOf(iHSVToColor));
        editText.removeTextChangedListener(this);
        editText.setText(str);
        editText.addTextChangedListener(this);
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        int i4;
        try {
            i4 = (int) (Long.parseLong(charSequence.toString(), 16) & 4294967295L);
        } catch (NumberFormatException unused) {
            i4 = -7829368;
        }
        if (this.b.getFilters() == e80.a) {
            i4 |= -16777216;
        }
        f9 f9Var = this.c;
        Color.colorToHSV(i4, (float[]) f9Var.c);
        f9Var.b = Color.alpha(i4);
        f9Var.f(this);
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
