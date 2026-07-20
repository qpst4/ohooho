package com.quickcursor.android.preferences;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.preference.SwitchPreference;
import com.quickcursor.App;
import com.quickcursor.R;
import defpackage.a3;
import defpackage.lc1;
import defpackage.ms0;
import defpackage.nq0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class CustomSwitchPreference extends SwitchPreference {
    public Drawable W;
    public Runnable X;
    public AppCompatImageView Y;
    public View Z;

    public CustomSwitchPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 0);
        M(context, attributeSet);
    }

    public final void M(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, ms0.a, 0, 0);
        try {
            this.W = lc1.A(App.c, typedArrayObtainStyledAttributes.getResourceId(0, 0));
        } catch (Exception unused) {
            this.W = null;
        }
        typedArrayObtainStyledAttributes.recycle();
        this.F = R.layout.preference_custom_switch;
    }

    public final void N(boolean z) {
        AppCompatImageView appCompatImageView = this.Y;
        if (appCompatImageView != null) {
            boolean z2 = false;
            int i = this.W == null ? 8 : 0;
            appCompatImageView.setVisibility(i);
            this.Z.setVisibility(i);
            this.Y.setImageDrawable(this.W);
            if (i == 0) {
                if (z && j()) {
                    z2 = true;
                }
                this.Y.setAlpha(z2 ? 1.0f : 0.3f);
                this.Y.setEnabled(z2);
            }
        }
    }

    @Override // androidx.preference.Preference
    public final boolean a(Object obj) {
        N(((Boolean) obj).booleanValue());
        return super.a(obj);
    }

    @Override // androidx.preference.SwitchPreference, androidx.preference.Preference
    public final void o(nq0 nq0Var) {
        super.o(nq0Var);
        View view = nq0Var.a;
        this.Z = view.findViewById(R.id.custom_separator);
        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.custom_button);
        this.Y = appCompatImageView;
        appCompatImageView.setOnClickListener(new a3(4, this));
        N(this.O);
    }

    public CustomSwitchPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        M(context, attributeSet);
    }

    public CustomSwitchPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        M(context, attributeSet);
    }

    public CustomSwitchPreference(Context context) {
        super(context, null);
        M(context, null);
    }
}
