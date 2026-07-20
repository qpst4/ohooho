package defpackage;

import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class fz {
    public final /* synthetic */ hz a;

    public fz(hz hzVar) {
        this.a = hzVar;
    }

    public final void a(TextInputLayout textInputLayout) {
        hz hzVar = this.a;
        ez ezVar = hzVar.w;
        if (hzVar.t == textInputLayout.getEditText()) {
            return;
        }
        EditText editText = hzVar.t;
        if (editText != null) {
            editText.removeTextChangedListener(ezVar);
            if (hzVar.t.getOnFocusChangeListener() == hzVar.b().e()) {
                hzVar.t.setOnFocusChangeListener(null);
            }
        }
        EditText editText2 = textInputLayout.getEditText();
        hzVar.t = editText2;
        if (editText2 != null) {
            editText2.addTextChangedListener(ezVar);
        }
        hzVar.b().l(hzVar.t);
        hzVar.j(hzVar.b());
    }
}
