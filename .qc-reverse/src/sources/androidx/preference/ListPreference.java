package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.AbsSavedState;
import com.quickcursor.R;
import defpackage.fp1;
import defpackage.ix;
import defpackage.sh0;
import defpackage.vs0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ListPreference extends DialogPreference {
    public CharSequence[] U;
    public final CharSequence[] V;
    public String W;
    public String X;
    public boolean Y;

    public ListPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, vs0.e, i, i2);
        CharSequence[] textArray = typedArrayObtainStyledAttributes.getTextArray(2);
        this.U = textArray == null ? typedArrayObtainStyledAttributes.getTextArray(0) : textArray;
        CharSequence[] textArray2 = typedArrayObtainStyledAttributes.getTextArray(3);
        this.V = textArray2 == null ? typedArrayObtainStyledAttributes.getTextArray(1) : textArray2;
        if (typedArrayObtainStyledAttributes.getBoolean(4, typedArrayObtainStyledAttributes.getBoolean(4, false))) {
            if (ix.i == null) {
                ix.i = new ix(20);
            }
            this.M = ix.i;
            k();
        }
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, vs0.g, i, i2);
        String string = typedArrayObtainStyledAttributes2.getString(33);
        this.X = string == null ? typedArrayObtainStyledAttributes2.getString(7) : string;
        typedArrayObtainStyledAttributes2.recycle();
    }

    @Override // androidx.preference.Preference
    public final void E(CharSequence charSequence) {
        super.E(charSequence);
        if (charSequence == null) {
            this.X = null;
        } else {
            this.X = ((String) charSequence).toString();
        }
    }

    public final int K(String str) {
        CharSequence[] charSequenceArr;
        if (str == null || (charSequenceArr = this.V) == null) {
            return -1;
        }
        for (int length = charSequenceArr.length - 1; length >= 0; length--) {
            if (TextUtils.equals(charSequenceArr[length].toString(), str)) {
                return length;
            }
        }
        return -1;
    }

    public final CharSequence L() {
        CharSequence[] charSequenceArr;
        int iK = K(this.W);
        if (iK < 0 || (charSequenceArr = this.U) == null) {
            return null;
        }
        return charSequenceArr[iK];
    }

    public final void M(String str) {
        boolean zEquals = TextUtils.equals(this.W, str);
        if (zEquals && this.Y) {
            return;
        }
        this.W = str;
        this.Y = true;
        z(str);
        if (zEquals) {
            return;
        }
        k();
    }

    @Override // androidx.preference.Preference
    public CharSequence i() {
        ix ixVar = this.M;
        if (ixVar != null) {
            return ixVar.j(this);
        }
        CharSequence charSequenceL = L();
        CharSequence charSequenceI = super.i();
        String str = this.X;
        if (str != null) {
            if (charSequenceL == null) {
                charSequenceL = "";
            }
            String str2 = String.format(str, charSequenceL);
            if (!TextUtils.equals(str2, charSequenceI)) {
                Log.w("ListPreference", "Setting a summary with a String formatting marker is no longer supported. You should use a SummaryProvider instead.");
                return str2;
            }
        }
        return charSequenceI;
    }

    @Override // androidx.preference.Preference
    public final Object r(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    @Override // androidx.preference.Preference
    public final void s(Parcelable parcelable) {
        if (!parcelable.getClass().equals(sh0.class)) {
            super.s(parcelable);
            return;
        }
        sh0 sh0Var = (sh0) parcelable;
        super.s(sh0Var.getSuperState());
        M(sh0Var.b);
    }

    @Override // androidx.preference.Preference
    public final Parcelable t() {
        super.t();
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.s) {
            return absSavedState;
        }
        sh0 sh0Var = new sh0();
        sh0Var.b = this.W;
        return sh0Var;
    }

    @Override // androidx.preference.Preference
    public final void u(Object obj) {
        M(g((String) obj));
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, fp1.g(context, R.attr.dialogPreferenceStyle, android.R.attr.dialogPreferenceStyle), 0);
    }
}
