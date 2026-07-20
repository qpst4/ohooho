package defpackage;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class jp0 extends iz {
    public final int e;
    public EditText f;
    public final a3 g;

    public jp0(hz hzVar, int i) {
        super(hzVar);
        this.e = R.drawable.design_password_eye;
        this.g = new a3(12, this);
        if (i != 0) {
            this.e = i;
        }
    }

    @Override // defpackage.iz
    public final void b() {
        p();
    }

    @Override // defpackage.iz
    public final int c() {
        return R.string.password_toggle_content_description;
    }

    @Override // defpackage.iz
    public final int d() {
        return this.e;
    }

    @Override // defpackage.iz
    public final View.OnClickListener f() {
        return this.g;
    }

    @Override // defpackage.iz
    public final boolean j() {
        return true;
    }

    @Override // defpackage.iz
    public final boolean k() {
        EditText editText = this.f;
        return !(editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod));
    }

    @Override // defpackage.iz
    public final void l(EditText editText) {
        this.f = editText;
        p();
    }

    @Override // defpackage.iz
    public final void q() {
        EditText editText = this.f;
        if (editText != null) {
            if (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224) {
                this.f.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

    @Override // defpackage.iz
    public final void r() {
        EditText editText = this.f;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
