package com.quickcursor.android.preferences;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import androidx.preference.Preference;
import com.quickcursor.R;
import defpackage.a3;
import defpackage.jz0;
import defpackage.ms0;
import defpackage.nq0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ButtonPreference extends Preference {
    public jz0 O;
    public String P;
    public final Drawable Q;
    public AppCompatButton R;

    public ButtonPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O = null;
        if (attributeSet == null) {
            this.P = "";
            this.Q = null;
        } else {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, ms0.c, 0, 0);
            this.P = typedArrayObtainStyledAttributes.getString(1);
            this.Q = typedArrayObtainStyledAttributes.getDrawable(0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.preference.Preference
    public final void o(nq0 nq0Var) {
        super.o(nq0Var);
        AppCompatButton appCompatButton = (AppCompatButton) nq0Var.a.findViewById(R.id.button);
        this.R = appCompatButton;
        appCompatButton.setText(this.P);
        this.R.setCompoundDrawablesWithIntrinsicBounds(this.Q, (Drawable) null, (Drawable) null, (Drawable) null);
        this.R.setOnClickListener(new a3(2, this));
    }
}
