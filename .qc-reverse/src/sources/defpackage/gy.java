package defpackage;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class gy implements TextWatcher {
    public final EditText b;
    public fy c;
    public boolean d = true;

    public gy(EditText editText) {
        this.b = editText;
    }

    public static void a(EditText editText, int i) {
        int length;
        if (i == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            sx sxVarA = sx.a();
            if (editableText == null) {
                length = 0;
            } else {
                sxVarA.getClass();
                length = editableText.length();
            }
            sxVarA.e(editableText, 0, length);
            if (selectionStart >= 0 && selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionStart, selectionEnd);
            } else if (selectionStart >= 0) {
                Selection.setSelection(editableText, selectionStart);
            } else if (selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionEnd);
            }
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) throws Throwable {
        EditText editText = this.b;
        if (editText.isInEditMode() || !this.d || sx.k == null || i2 > i3 || !(charSequence instanceof Spannable)) {
            return;
        }
        int iB = sx.a().b();
        if (iB != 0) {
            if (iB == 1) {
                sx.a().e((Spannable) charSequence, i, i3 + i);
                return;
            } else if (iB != 3) {
                return;
            }
        }
        sx sxVarA = sx.a();
        if (this.c == null) {
            this.c = new fy(editText);
        }
        sxVarA.f(this.c);
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
