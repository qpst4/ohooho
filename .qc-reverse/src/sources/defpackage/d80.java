package defpackage;

import android.text.InputFilter;
import android.text.Spanned;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class d80 implements InputFilter {
    public final InputFilter.LengthFilter a = new InputFilter.LengthFilter(6);

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        return (i2 - i == 8 && i4 - i3 == spanned.length()) ? charSequence.subSequence(2, 8) : this.a.filter(charSequence, i, i2, spanned, i3, i4);
    }
}
