package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import androidx.appcompat.widget.SwitchCompat;
import com.quickcursor.R;
import defpackage.nq0;
import defpackage.vj;
import defpackage.vs0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class SwitchPreferenceCompat extends TwoStatePreference {
    public final vj T;
    public final String U;
    public final String V;

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.switchPreferenceCompatStyle, 0);
        this.T = new vj(this, 2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, vs0.m, R.attr.switchPreferenceCompatStyle, 0);
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
        boolean z = view instanceof SwitchCompat;
        if (z) {
            ((SwitchCompat) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.O);
        }
        if (z) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.setTextOn(this.U);
            switchCompat.setTextOff(this.V);
            switchCompat.setOnCheckedChangeListener(this.T);
        }
    }

    @Override // androidx.preference.Preference
    public final void o(nq0 nq0Var) {
        super.o(nq0Var);
        L(nq0Var.r(R.id.switchWidget));
        K(nq0Var.r(android.R.id.summary));
    }

    @Override // androidx.preference.Preference
    public final void x(View view) {
        w();
        if (((AccessibilityManager) this.b.getSystemService("accessibility")).isEnabled()) {
            L(view.findViewById(R.id.switchWidget));
            K(view.findViewById(android.R.id.summary));
        }
    }
}
