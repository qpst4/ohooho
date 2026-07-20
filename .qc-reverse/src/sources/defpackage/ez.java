package defpackage;

import android.text.Editable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ez extends i51 {
    public final /* synthetic */ hz b;

    public ez(hz hzVar) {
        this.b = hzVar;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        this.b.b().a();
    }

    @Override // defpackage.i51, android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.b.b().b();
    }
}
