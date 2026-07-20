package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import com.quickcursor.R;
import defpackage.fp1;
import defpackage.nq0;
import defpackage.vj;
import defpackage.vs0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class CheckBoxPreference extends TwoStatePreference {
    public final vj T;

    /* JADX WARN: Illegal instructions before constructor call */
    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        int iG = fp1.g(context, R.attr.checkBoxPreferenceStyle, android.R.attr.checkBoxPreferenceStyle);
        super(context, attributeSet, iG, 0);
        this.T = new vj(this, 0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, vs0.b, iG, 0);
        String string = typedArrayObtainStyledAttributes.getString(5);
        this.P = string == null ? typedArrayObtainStyledAttributes.getString(0) : string;
        if (this.O) {
            k();
        }
        String string2 = typedArrayObtainStyledAttributes.getString(4);
        this.Q = string2 == null ? typedArrayObtainStyledAttributes.getString(1) : string2;
        if (!this.O) {
            k();
        }
        this.S = typedArrayObtainStyledAttributes.getBoolean(3, typedArrayObtainStyledAttributes.getBoolean(2, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void L(View view) {
        boolean z = view instanceof CompoundButton;
        if (z) {
            ((CompoundButton) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.O);
        }
        if (z) {
            ((CompoundButton) view).setOnCheckedChangeListener(this.T);
        }
    }

    @Override // androidx.preference.Preference
    public final void o(nq0 nq0Var) {
        super.o(nq0Var);
        L(nq0Var.r(android.R.id.checkbox));
        K(nq0Var.r(android.R.id.summary));
    }

    @Override // androidx.preference.Preference
    public final void x(View view) {
        w();
        if (((AccessibilityManager) this.b.getSystemService("accessibility")).isEnabled()) {
            L(view.findViewById(android.R.id.checkbox));
            K(view.findViewById(android.R.id.summary));
        }
    }
}
