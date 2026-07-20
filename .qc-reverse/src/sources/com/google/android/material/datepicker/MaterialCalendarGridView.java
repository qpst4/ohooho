package com.google.android.material.datepicker;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import defpackage.fk0;
import defpackage.uf1;
import defpackage.vj0;
import defpackage.wd1;
import defpackage.zl0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
final class MaterialCalendarGridView extends GridView {
    public final boolean b;

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        wd1.c(null);
        if (fk0.m0(getContext(), R.attr.windowFullscreen)) {
            setNextFocusLeftId(com.quickcursor.R.id.cancel_button);
            setNextFocusRightId(com.quickcursor.R.id.confirm_button);
        }
        this.b = fk0.m0(getContext(), com.quickcursor.R.attr.nestedScrollable);
        uf1.n(this, new vj0(2));
    }

    public final zl0 a() {
        return (zl0) super.getAdapter();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final Adapter getAdapter() {
        return (zl0) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ((zl0) super.getAdapter()).notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        zl0 zl0Var = (zl0) super.getAdapter();
        zl0Var.getClass();
        int iMax = Math.max(zl0Var.a(), getFirstVisiblePosition());
        int iMin = Math.min(zl0Var.c(), getLastVisiblePosition());
        zl0Var.getItem(iMax);
        zl0Var.getItem(iMin);
        throw null;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onFocusChanged(boolean z, int i, Rect rect) {
        if (!z) {
            super.onFocusChanged(false, i, rect);
            return;
        }
        if (i == 33) {
            setSelection(((zl0) super.getAdapter()).c());
        } else if (i == 130) {
            setSelection(((zl0) super.getAdapter()).a());
        } else {
            super.onFocusChanged(true, i, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!super.onKeyDown(i, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= ((zl0) super.getAdapter()).a()) {
            return true;
        }
        if (19 != i) {
            return false;
        }
        setSelection(((zl0) super.getAdapter()).a());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onMeasure(int i, int i2) {
        if (!this.b) {
            super.onMeasure(i, i2);
            return;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof zl0)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), zl0.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final void setSelection(int i) {
        if (i < ((zl0) super.getAdapter()).a()) {
            super.setSelection(((zl0) super.getAdapter()).a());
        } else {
            super.setSelection(i);
        }
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final ListAdapter getAdapter() {
        return (zl0) super.getAdapter();
    }
}
