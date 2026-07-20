package defpackage;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class dy extends tk0 {
    public final TextView l;
    public final zx m;
    public boolean n = true;

    public dy(TextView textView) {
        this.l = textView;
        this.m = new zx(textView);
    }

    @Override // defpackage.tk0
    public final void B(boolean z) {
        if (z) {
            TextView textView = this.l;
            textView.setTransformationMethod(L(textView.getTransformationMethod()));
        }
    }

    @Override // defpackage.tk0
    public final void C(boolean z) {
        this.n = z;
        TextView textView = this.l;
        textView.setTransformationMethod(L(textView.getTransformationMethod()));
        textView.setFilters(k(textView.getFilters()));
    }

    @Override // defpackage.tk0
    public final TransformationMethod L(TransformationMethod transformationMethod) {
        return this.n ? ((transformationMethod instanceof hy) || (transformationMethod instanceof PasswordTransformationMethod)) ? transformationMethod : new hy(transformationMethod) : transformationMethod instanceof hy ? ((hy) transformationMethod).b : transformationMethod;
    }

    @Override // defpackage.tk0
    public final InputFilter[] k(InputFilter[] inputFilterArr) {
        if (!this.n) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i = 0; i < inputFilterArr.length; i++) {
                InputFilter inputFilter = inputFilterArr[i];
                if (inputFilter instanceof zx) {
                    sparseArray.put(i, inputFilter);
                }
            }
            if (sparseArray.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArray.size()];
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (sparseArray.indexOfKey(i3) < 0) {
                    inputFilterArr2[i2] = inputFilterArr[i3];
                    i2++;
                }
            }
            return inputFilterArr2;
        }
        int length2 = inputFilterArr.length;
        int i4 = 0;
        while (true) {
            zx zxVar = this.m;
            if (i4 >= length2) {
                InputFilter[] inputFilterArr3 = new InputFilter[inputFilterArr.length + 1];
                System.arraycopy(inputFilterArr, 0, inputFilterArr3, 0, length2);
                inputFilterArr3[length2] = zxVar;
                return inputFilterArr3;
            }
            if (inputFilterArr[i4] == zxVar) {
                return inputFilterArr;
            }
            i4++;
        }
    }

    @Override // defpackage.tk0
    public final boolean q() {
        return this.n;
    }
}
