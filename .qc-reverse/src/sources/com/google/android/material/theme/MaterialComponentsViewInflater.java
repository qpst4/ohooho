package com.google.android.material.theme;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.button.MaterialButton;
import com.quickcursor.R;
import defpackage.a8;
import defpackage.c8;
import defpackage.ck0;
import defpackage.f01;
import defpackage.gk0;
import defpackage.i1;
import defpackage.j9;
import defpackage.kk0;
import defpackage.oj0;
import defpackage.qa;
import defpackage.xy0;
import defpackage.yb0;
import defpackage.ys0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class MaterialComponentsViewInflater extends qa {
    @Override // defpackage.qa
    public final a8 a(Context context, AttributeSet attributeSet) {
        return new oj0(context, attributeSet);
    }

    @Override // defpackage.qa
    public final AppCompatButton b(Context context, AttributeSet attributeSet) {
        return new MaterialButton(context, attributeSet);
    }

    @Override // defpackage.qa
    public final c8 c(Context context, AttributeSet attributeSet) {
        return new ck0(context, attributeSet);
    }

    @Override // defpackage.qa
    public final j9 d(Context context, AttributeSet attributeSet) {
        gk0 gk0Var = new gk0(xy0.L(context, attributeSet, R.attr.radioButtonStyle, R.style.Widget_MaterialComponents_CompoundButton_RadioButton), attributeSet);
        Context context2 = gk0Var.getContext();
        TypedArray typedArrayE = f01.E(context2, attributeSet, ys0.s, R.attr.radioButtonStyle, R.style.Widget_MaterialComponents_CompoundButton_RadioButton, new int[0]);
        if (typedArrayE.hasValue(0)) {
            gk0Var.setButtonTintList(yb0.i(context2, typedArrayE, 0));
        }
        gk0Var.g = typedArrayE.getBoolean(1, false);
        typedArrayE.recycle();
        return gk0Var;
    }

    @Override // defpackage.qa
    public final AppCompatTextView e(Context context, AttributeSet attributeSet) {
        kk0 kk0Var = new kk0(xy0.L(context, attributeSet, android.R.attr.textViewStyle, 0), attributeSet, android.R.attr.textViewStyle);
        Context context2 = kk0Var.getContext();
        if (i1.S(context2, R.attr.textAppearanceLineHeightEnabled, true)) {
            Resources.Theme theme = context2.getTheme();
            int[] iArr = ys0.v;
            TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, iArr, android.R.attr.textViewStyle, 0);
            int iG = kk0.g(context2, typedArrayObtainStyledAttributes, 1, 2);
            typedArrayObtainStyledAttributes.recycle();
            if (iG == -1) {
                TypedArray typedArrayObtainStyledAttributes2 = theme.obtainStyledAttributes(attributeSet, iArr, android.R.attr.textViewStyle, 0);
                int resourceId = typedArrayObtainStyledAttributes2.getResourceId(0, -1);
                typedArrayObtainStyledAttributes2.recycle();
                if (resourceId != -1) {
                    TypedArray typedArrayObtainStyledAttributes3 = theme.obtainStyledAttributes(resourceId, ys0.u);
                    int iG2 = kk0.g(kk0Var.getContext(), typedArrayObtainStyledAttributes3, 1, 2);
                    typedArrayObtainStyledAttributes3.recycle();
                    if (iG2 >= 0) {
                        kk0Var.setLineHeight(iG2);
                    }
                }
            }
        }
        return kk0Var;
    }
}
