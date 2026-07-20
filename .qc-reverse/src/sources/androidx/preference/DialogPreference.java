package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.quickcursor.R;
import defpackage.fp1;
import defpackage.gq0;
import defpackage.vs0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class DialogPreference extends Preference {
    public final CharSequence O;
    public final String P;
    public final Drawable Q;
    public final String R;
    public final String S;
    public final int T;

    public DialogPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, vs0.c, i, i2);
        String string = typedArrayObtainStyledAttributes.getString(9);
        string = string == null ? typedArrayObtainStyledAttributes.getString(0) : string;
        this.O = string;
        if (string == null) {
            this.O = this.i;
        }
        String string2 = typedArrayObtainStyledAttributes.getString(8);
        this.P = string2 == null ? typedArrayObtainStyledAttributes.getString(1) : string2;
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(6);
        this.Q = drawable == null ? typedArrayObtainStyledAttributes.getDrawable(2) : drawable;
        String string3 = typedArrayObtainStyledAttributes.getString(11);
        this.R = string3 == null ? typedArrayObtainStyledAttributes.getString(3) : string3;
        String string4 = typedArrayObtainStyledAttributes.getString(10);
        this.S = string4 == null ? typedArrayObtainStyledAttributes.getString(4) : string4;
        this.T = typedArrayObtainStyledAttributes.getResourceId(7, typedArrayObtainStyledAttributes.getResourceId(5, 0));
        typedArrayObtainStyledAttributes.recycle();
    }

    public CharSequence J() {
        return this.O;
    }

    @Override // androidx.preference.Preference
    public void p() {
        gq0 gq0Var = this.c.i;
        if (gq0Var != null) {
            gq0Var.j0(this);
        }
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, fp1.g(context, R.attr.dialogPreferenceStyle, android.R.attr.dialogPreferenceStyle), 0);
    }
}
