package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.AbsSavedState;
import defpackage.hq0;
import defpackage.t01;
import defpackage.vs0;
import defpackage.zy;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class PreferenceGroup extends Preference {
    public final t01 O;
    public final ArrayList P;
    public boolean Q;
    public int R;
    public boolean S;
    public int T;

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, 0);
        this.O = new t01(0);
        new Handler(Looper.getMainLooper());
        this.Q = true;
        this.R = 0;
        this.S = false;
        this.T = Integer.MAX_VALUE;
        this.P = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, vs0.i, i, 0);
        this.Q = typedArrayObtainStyledAttributes.getBoolean(2, typedArrayObtainStyledAttributes.getBoolean(2, true));
        if (typedArrayObtainStyledAttributes.hasValue(1)) {
            int i3 = typedArrayObtainStyledAttributes.getInt(1, typedArrayObtainStyledAttributes.getInt(1, Integer.MAX_VALUE));
            if (i3 != Integer.MAX_VALUE && TextUtils.isEmpty(this.m)) {
                Log.e("PreferenceGroup", getClass().getSimpleName().concat(" should have a key defined if it contains an expandable preference"));
            }
            this.T = i3;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final Preference J(CharSequence charSequence) {
        Preference preferenceJ;
        if (charSequence == null) {
            zy.n("Key cannot be null");
            return null;
        }
        if (TextUtils.equals(this.m, charSequence)) {
            return this;
        }
        int size = this.P.size();
        for (int i = 0; i < size; i++) {
            Preference preferenceK = K(i);
            if (TextUtils.equals(preferenceK.m, charSequence)) {
                return preferenceK;
            }
            if ((preferenceK instanceof PreferenceGroup) && (preferenceJ = ((PreferenceGroup) preferenceK).J(charSequence)) != null) {
                return preferenceJ;
            }
        }
        return null;
    }

    public final Preference K(int i) {
        return (Preference) this.P.get(i);
    }

    @Override // androidx.preference.Preference
    public final void b(Bundle bundle) {
        super.b(bundle);
        int size = this.P.size();
        for (int i = 0; i < size; i++) {
            K(i).b(bundle);
        }
    }

    @Override // androidx.preference.Preference
    public final void c(Bundle bundle) {
        super.c(bundle);
        int size = this.P.size();
        for (int i = 0; i < size; i++) {
            K(i).c(bundle);
        }
    }

    @Override // androidx.preference.Preference
    public final void l(boolean z) {
        super.l(z);
        int size = this.P.size();
        for (int i = 0; i < size; i++) {
            Preference preferenceK = K(i);
            if (preferenceK.w == z) {
                preferenceK.w = !z;
                preferenceK.l(preferenceK.G());
                preferenceK.k();
            }
        }
    }

    @Override // androidx.preference.Preference
    public final void m() {
        super.m();
        this.S = true;
        int size = this.P.size();
        for (int i = 0; i < size; i++) {
            K(i).m();
        }
    }

    @Override // androidx.preference.Preference
    public final void q() {
        super.q();
        this.S = false;
        int size = this.P.size();
        for (int i = 0; i < size; i++) {
            K(i).q();
        }
    }

    @Override // androidx.preference.Preference
    public final void s(Parcelable parcelable) {
        if (!parcelable.getClass().equals(hq0.class)) {
            super.s(parcelable);
            return;
        }
        hq0 hq0Var = (hq0) parcelable;
        this.T = hq0Var.b;
        super.s(hq0Var.getSuperState());
    }

    @Override // androidx.preference.Preference
    public final Parcelable t() {
        super.t();
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        return new hq0(this.T);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0);
    }
}
