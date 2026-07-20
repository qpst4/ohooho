package defpackage;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class d9 {
    public final TextView a;
    public final sp1 b;

    public d9(TextView textView) {
        this.a = textView;
        this.b = new sp1(textView);
    }

    public final InputFilter[] a(InputFilter[] inputFilterArr) {
        return ((tk0) this.b.c).k(inputFilterArr);
    }

    public final void b(AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = this.a.getContext().obtainStyledAttributes(attributeSet, zs0.i, i, 0);
        try {
            boolean z = typedArrayObtainStyledAttributes.hasValue(14) ? typedArrayObtainStyledAttributes.getBoolean(14, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            d(z);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void c(boolean z) {
        ((tk0) this.b.c).B(z);
    }

    public final void d(boolean z) {
        ((tk0) this.b.c).C(z);
    }
}
