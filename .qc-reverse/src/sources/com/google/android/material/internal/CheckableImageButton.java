package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import defpackage.e9;
import defpackage.uf1;
import defpackage.xj;
import defpackage.yj;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class CheckableImageButton extends e9 implements Checkable {
    public static final int[] h = {R.attr.state_checked};
    public boolean e;
    public boolean f;
    public boolean g;

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, com.quickcursor.R.attr.imageButtonStyle);
        this.f = true;
        this.g = true;
        uf1.n(this, new xj(0, this));
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.e;
    }

    @Override // android.widget.ImageView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        return this.e ? View.mergeDrawableStates(super.onCreateDrawableState(i + 1), h) : super.onCreateDrawableState(i);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof yj)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        yj yjVar = (yj) parcelable;
        super.onRestoreInstanceState(yjVar.b);
        setChecked(yjVar.d);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        yj yjVar = new yj(super.onSaveInstanceState());
        yjVar.d = this.e;
        return yjVar;
    }

    public void setCheckable(boolean z) {
        if (this.f != z) {
            this.f = z;
            sendAccessibilityEvent(0);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (!this.f || this.e == z) {
            return;
        }
        this.e = z;
        refreshDrawableState();
        sendAccessibilityEvent(2048);
    }

    public void setPressable(boolean z) {
        this.g = z;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        if (this.g) {
            super.setPressed(z);
        }
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.e);
    }
}
