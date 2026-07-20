package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.Switch;
import defpackage.fp1;
import defpackage.nq0;
import defpackage.vj;
import defpackage.vs0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class SwitchPreference extends TwoStatePreference {
    public final vj T;
    public final String U;
    public final String V;

    public SwitchPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.T = new vj(this, 1);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, vs0.l, i, i2);
        String string = typedArrayObtainStyledAttributes.getString(7);
        this.P = string == null ? typedArrayObtainStyledAttributes.getString(0) : string;
        if (this.O) {
            k();
        }
        String string2 = typedArrayObtainStyledAttributes.getString(6);
        this.Q = string2 == null ? typedArrayObtainStyledAttributes.getString(1) : string2;
        if (!this.O) {
            k();
        }
        String string3 = typedArrayObtainStyledAttributes.getString(9);
        this.U = string3 == null ? typedArrayObtainStyledAttributes.getString(3) : string3;
        k();
        String string4 = typedArrayObtainStyledAttributes.getString(8);
        this.V = string4 == null ? typedArrayObtainStyledAttributes.getString(4) : string4;
        k();
        this.S = typedArrayObtainStyledAttributes.getBoolean(5, typedArrayObtainStyledAttributes.getBoolean(2, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void L(View view) {
        boolean z = view instanceof Switch;
        if (z) {
            ((Switch) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.O);
        }
        if (z) {
            Switch r4 = (Switch) view;
            r4.setTextOn(this.U);
            r4.setTextOff(this.V);
            r4.setOnCheckedChangeListener(this.T);
        }
    }

    @Override // androidx.preference.Preference
    public void o(nq0 nq0Var) {
        super.o(nq0Var);
        L(nq0Var.r(R.id.switch_widget));
        K(nq0Var.r(R.id.summary));
    }

    @Override // androidx.preference.Preference
    public final void x(View view) {
        w();
        if (((AccessibilityManager) this.b.getSystemService("accessibility")).isEnabled()) {
            L(view.findViewById(R.id.switch_widget));
            K(view.findViewById(R.id.summary));
        }
    }

    public SwitchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, fp1.g(context, com.quickcursor.R.attr.switchPreferenceStyle, R.attr.switchPreferenceStyle), 0);
    }
}
