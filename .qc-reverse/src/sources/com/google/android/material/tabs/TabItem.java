package com.google.android.material.tabs;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import defpackage.ra;
import defpackage.ys0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class TabItem extends View {
    public final CharSequence b;
    public final Drawable c;
    public final int d;

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ra raVarL = ra.L(context, attributeSet, ys0.C);
        TypedArray typedArray = (TypedArray) raVarL.c;
        this.b = typedArray.getText(2);
        this.c = raVarL.y(0);
        this.d = typedArray.getResourceId(1, 0);
        raVarL.O();
    }
}
