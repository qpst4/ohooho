package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import com.quickcursor.R;
import defpackage.em0;
import defpackage.fp1;
import defpackage.vs0;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class MultiSelectListPreference extends DialogPreference {
    public final CharSequence[] U;
    public final CharSequence[] V;
    public final HashSet W;

    /* JADX WARN: Illegal instructions before constructor call */
    public MultiSelectListPreference(Context context, AttributeSet attributeSet) {
        int iG = fp1.g(context, R.attr.dialogPreferenceStyle, android.R.attr.dialogPreferenceStyle);
        super(context, attributeSet, iG, 0);
        this.W = new HashSet();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, vs0.f, iG, 0);
        CharSequence[] textArray = typedArrayObtainStyledAttributes.getTextArray(2);
        this.U = textArray == null ? typedArrayObtainStyledAttributes.getTextArray(0) : textArray;
        CharSequence[] textArray2 = typedArrayObtainStyledAttributes.getTextArray(3);
        this.V = textArray2 == null ? typedArrayObtainStyledAttributes.getTextArray(1) : textArray2;
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void K(Set set) {
        HashSet hashSet = this.W;
        hashSet.clear();
        hashSet.addAll(set);
        A(set);
        k();
    }

    @Override // androidx.preference.Preference
    public final Object r(TypedArray typedArray, int i) {
        CharSequence[] textArray = typedArray.getTextArray(i);
        HashSet hashSet = new HashSet();
        for (CharSequence charSequence : textArray) {
            hashSet.add(charSequence.toString());
        }
        return hashSet;
    }

    @Override // androidx.preference.Preference
    public final void s(Parcelable parcelable) {
        if (!parcelable.getClass().equals(em0.class)) {
            super.s(parcelable);
            return;
        }
        em0 em0Var = (em0) parcelable;
        super.s(em0Var.getSuperState());
        K(em0Var.b);
    }

    @Override // androidx.preference.Preference
    public final Parcelable t() {
        super.t();
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.s) {
            return absSavedState;
        }
        em0 em0Var = new em0();
        em0Var.b = this.W;
        return em0Var;
    }

    @Override // androidx.preference.Preference
    public final void u(Object obj) {
        K(h((Set) obj));
    }
}
