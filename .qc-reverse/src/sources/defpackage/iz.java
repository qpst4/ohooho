package defpackage;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class iz {
    public final TextInputLayout a;
    public final hz b;
    public final Context c;
    public final CheckableImageButton d;

    public iz(hz hzVar) {
        this.a = hzVar.b;
        this.b = hzVar;
        this.c = hzVar.getContext();
        this.d = hzVar.h;
    }

    public int c() {
        return 0;
    }

    public int d() {
        return 0;
    }

    public View.OnFocusChangeListener e() {
        return null;
    }

    public View.OnClickListener f() {
        return null;
    }

    public View.OnFocusChangeListener g() {
        return null;
    }

    public r1 h() {
        return null;
    }

    public boolean i(int i) {
        return true;
    }

    public boolean j() {
        return this instanceof ev;
    }

    public boolean k() {
        return false;
    }

    public final void p() {
        this.b.f(false);
    }

    public void a() {
    }

    public void b() {
    }

    public void q() {
    }

    public void r() {
    }

    public void l(EditText editText) {
    }

    public void m(n0 n0Var) {
    }

    public void n(AccessibilityEvent accessibilityEvent) {
    }

    public void o(boolean z) {
    }
}
