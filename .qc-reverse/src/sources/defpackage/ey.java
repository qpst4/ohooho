package defpackage;

import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ey extends tk0 {
    public final dy l;

    public ey(TextView textView) {
        this.l = new dy(textView);
    }

    @Override // defpackage.tk0
    public final void B(boolean z) {
        if (sx.k != null) {
            this.l.B(z);
        }
    }

    @Override // defpackage.tk0
    public final void C(boolean z) {
        boolean z2 = sx.k != null;
        dy dyVar = this.l;
        if (z2) {
            dyVar.C(z);
        } else {
            dyVar.n = z;
        }
    }

    @Override // defpackage.tk0
    public final TransformationMethod L(TransformationMethod transformationMethod) {
        return !(sx.k != null) ? transformationMethod : this.l.L(transformationMethod);
    }

    @Override // defpackage.tk0
    public final InputFilter[] k(InputFilter[] inputFilterArr) {
        return !(sx.k != null) ? inputFilterArr : this.l.k(inputFilterArr);
    }

    @Override // defpackage.tk0
    public final boolean q() {
        return this.l.n;
    }
}
