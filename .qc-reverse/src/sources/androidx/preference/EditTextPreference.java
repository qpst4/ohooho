package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import com.quickcursor.R;
import defpackage.fp1;
import defpackage.ix;
import defpackage.jx;
import defpackage.vs0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class EditTextPreference extends DialogPreference {
    public String U;

    /* JADX WARN: Illegal instructions before constructor call */
    public EditTextPreference(Context context, AttributeSet attributeSet) {
        int iG = fp1.g(context, R.attr.editTextPreferenceStyle, android.R.attr.editTextPreferenceStyle);
        super(context, attributeSet, iG, 0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, vs0.d, iG, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(0, typedArrayObtainStyledAttributes.getBoolean(0, false))) {
            if (ix.h == null) {
                ix.h = new ix(13);
            }
            this.M = ix.h;
            k();
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public final boolean G() {
        return TextUtils.isEmpty(this.U) || super.G();
    }

    public final void K(String str) {
        boolean zG = G();
        this.U = str;
        z(str);
        boolean zG2 = G();
        if (zG2 != zG) {
            l(zG2);
        }
        k();
    }

    @Override // androidx.preference.Preference
    public final Object r(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    @Override // androidx.preference.Preference
    public final void s(Parcelable parcelable) {
        if (!parcelable.getClass().equals(jx.class)) {
            super.s(parcelable);
            return;
        }
        jx jxVar = (jx) parcelable;
        super.s(jxVar.getSuperState());
        K(jxVar.b);
    }

    @Override // androidx.preference.Preference
    public final Parcelable t() {
        super.t();
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.s) {
            return absSavedState;
        }
        jx jxVar = new jx();
        jxVar.b = this.U;
        return jxVar;
    }

    @Override // androidx.preference.Preference
    public final void u(Object obj) {
        K(g((String) obj));
    }
}
