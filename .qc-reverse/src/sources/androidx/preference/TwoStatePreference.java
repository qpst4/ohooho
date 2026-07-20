package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import defpackage.db1;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TwoStatePreference extends Preference {
    public boolean O;
    public CharSequence P;
    public CharSequence Q;
    public boolean R;
    public boolean S;

    public TwoStatePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 0);
    }

    @Override // androidx.preference.Preference
    public final boolean G() {
        boolean z = this.S;
        boolean z2 = this.O;
        if (!z) {
            z2 = !z2;
        }
        return z2 || super.G();
    }

    public void J(boolean z) {
        boolean z2 = this.O != z;
        if (z2 || !this.R) {
            this.O = z;
            this.R = true;
            if (H()) {
                boolean z3 = !z;
                boolean zH = H();
                String str = this.m;
                if (zH) {
                    z3 = this.c.b().getBoolean(str, z3);
                }
                if (z != z3) {
                    SharedPreferences.Editor editorA = this.c.a();
                    editorA.putBoolean(str, z);
                    I(editorA);
                }
            }
            if (z2) {
                l(G());
                k();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void K(android.view.View r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof android.widget.TextView
            if (r0 != 0) goto L5
            goto L4c
        L5:
            android.widget.TextView r4 = (android.widget.TextView) r4
            boolean r0 = r3.O
            r1 = 0
            if (r0 == 0) goto L1b
            java.lang.CharSequence r0 = r3.P
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L1b
            java.lang.CharSequence r0 = r3.P
            r4.setText(r0)
        L19:
            r0 = r1
            goto L2e
        L1b:
            boolean r0 = r3.O
            if (r0 != 0) goto L2d
            java.lang.CharSequence r0 = r3.Q
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L2d
            java.lang.CharSequence r0 = r3.Q
            r4.setText(r0)
            goto L19
        L2d:
            r0 = 1
        L2e:
            if (r0 == 0) goto L3e
            java.lang.CharSequence r3 = r3.i()
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 != 0) goto L3e
            r4.setText(r3)
            r0 = r1
        L3e:
            if (r0 != 0) goto L41
            goto L43
        L41:
            r1 = 8
        L43:
            int r3 = r4.getVisibility()
            if (r1 == r3) goto L4c
            r4.setVisibility(r1)
        L4c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.TwoStatePreference.K(android.view.View):void");
    }

    @Override // androidx.preference.Preference
    public void p() {
        boolean z = !this.O;
        if (a(Boolean.valueOf(z))) {
            J(z);
        }
    }

    @Override // androidx.preference.Preference
    public final Object r(TypedArray typedArray, int i) {
        return Boolean.valueOf(typedArray.getBoolean(i, false));
    }

    @Override // androidx.preference.Preference
    public final void s(Parcelable parcelable) {
        if (!parcelable.getClass().equals(db1.class)) {
            super.s(parcelable);
            return;
        }
        db1 db1Var = (db1) parcelable;
        super.s(db1Var.getSuperState());
        J(db1Var.b);
    }

    @Override // androidx.preference.Preference
    public final Parcelable t() {
        super.t();
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.s) {
            return absSavedState;
        }
        db1 db1Var = new db1();
        db1Var.b = this.O;
        return db1Var;
    }

    @Override // androidx.preference.Preference
    public final void u(Object obj) {
        if (obj == null) {
            obj = Boolean.FALSE;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        if (H()) {
            zBooleanValue = this.c.b().getBoolean(this.m, zBooleanValue);
        }
        J(zBooleanValue);
    }
}
