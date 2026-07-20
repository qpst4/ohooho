package defpackage;

import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import com.google.android.material.internal.CheckableImageButton;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 implements AccessibilityManager.TouchExplorationStateChangeListener {
    public final r1 a;

    public a0(r1 r1Var) {
        this.a = r1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a0) {
            return this.a.equals(((a0) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z) {
        ev evVar = (ev) this.a.c;
        AutoCompleteTextView autoCompleteTextView = evVar.h;
        if (autoCompleteTextView == null || autoCompleteTextView.getInputType() != 0) {
            return;
        }
        CheckableImageButton checkableImageButton = evVar.d;
        int i = z ? 2 : 1;
        WeakHashMap weakHashMap = uf1.a;
        checkableImageButton.setImportantForAccessibility(i);
    }
}
