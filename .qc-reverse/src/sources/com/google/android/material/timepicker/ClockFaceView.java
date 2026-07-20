package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import com.quickcursor.R;
import defpackage.at0;
import defpackage.pn;
import defpackage.qn;
import defpackage.uf1;
import defpackage.un;
import defpackage.xy0;
import defpackage.yb0;
import defpackage.yk;
import defpackage.ys0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
class ClockFaceView extends at0 implements yk {
    public final int[] A;
    public final float[] B;
    public final int C;
    public final int D;
    public final int E;
    public final int F;
    public final String[] G;
    public float H;
    public final ColorStateList I;
    public final ClockHandView u;
    public final Rect v;
    public final RectF w;
    public final Rect x;
    public final SparseArray y;
    public final c z;

    public ClockFaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.v = new Rect();
        this.w = new RectF();
        this.x = new Rect();
        SparseArray sparseArray = new SparseArray();
        this.y = sparseArray;
        this.B = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ys0.e, R.attr.materialClockStyle, R.style.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList colorStateListI = yb0.i(context, typedArrayObtainStyledAttributes, 1);
        this.I = colorStateListI;
        LayoutInflater.from(context).inflate(R.layout.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R.id.material_clock_hand);
        this.u = clockHandView;
        this.C = resources.getDimensionPixelSize(R.dimen.material_clock_hand_padding);
        int colorForState = colorStateListI.getColorForState(new int[]{android.R.attr.state_selected}, colorStateListI.getDefaultColor());
        this.A = new int[]{colorForState, colorForState, colorStateListI.getDefaultColor()};
        clockHandView.d.add(this);
        int defaultColor = xy0.p(context, R.color.material_timepicker_clockface).getDefaultColor();
        ColorStateList colorStateListI2 = yb0.i(context, typedArrayObtainStyledAttributes, 0);
        setBackgroundColor(colorStateListI2 != null ? colorStateListI2.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new b(this));
        setFocusable(true);
        typedArrayObtainStyledAttributes.recycle();
        this.z = new c(this);
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        this.G = strArr;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int size = sparseArray.size();
        boolean z = false;
        for (int i = 0; i < Math.max(this.G.length, size); i++) {
            TextView textView = (TextView) sparseArray.get(i);
            if (i >= this.G.length) {
                removeView(textView);
                sparseArray.remove(i);
            } else {
                if (textView == null) {
                    textView = (TextView) layoutInflaterFrom.inflate(R.layout.material_clockface_textview, (ViewGroup) this, false);
                    sparseArray.put(i, textView);
                    addView(textView);
                }
                textView.setText(this.G[i]);
                textView.setTag(R.id.material_value_index, Integer.valueOf(i));
                int i2 = (i / 12) + 1;
                textView.setTag(R.id.material_clock_level, Integer.valueOf(i2));
                z = i2 > 1 ? true : z;
                uf1.n(textView, this.z);
                textView.setTextColor(this.I);
            }
        }
        ClockHandView clockHandView2 = this.u;
        if (clockHandView2.c && !z) {
            clockHandView2.n = 1;
        }
        clockHandView2.c = z;
        clockHandView2.invalidate();
        this.D = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_height);
        this.E = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_width);
        this.F = resources.getDimensionPixelSize(R.dimen.material_clock_size);
    }

    @Override // defpackage.at0
    public final void m() {
        un unVar = new un();
        unVar.b(this);
        HashMap map = new HashMap();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getId() != R.id.circle_center && !"skip".equals(childAt.getTag())) {
                int i2 = (Integer) childAt.getTag(R.id.material_clock_level);
                if (i2 == null) {
                    i2 = 1;
                }
                if (!map.containsKey(i2)) {
                    map.put(i2, new ArrayList());
                }
                ((List) map.get(i2)).add(childAt);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            List list = (List) entry.getValue();
            int iIntValue = ((Integer) entry.getKey()).intValue();
            int iRound = this.s;
            if (iIntValue == 2) {
                iRound = Math.round(iRound * 0.66f);
            }
            Iterator it = list.iterator();
            float size = 0.0f;
            while (it.hasNext()) {
                int id = ((View) it.next()).getId();
                Integer numValueOf = Integer.valueOf(id);
                HashMap map2 = unVar.c;
                if (!map2.containsKey(numValueOf)) {
                    map2.put(Integer.valueOf(id), new pn());
                }
                qn qnVar = ((pn) map2.get(Integer.valueOf(id))).d;
                qnVar.z = R.id.circle_center;
                qnVar.A = iRound;
                qnVar.B = size;
                size += 360.0f / list.size();
            }
        }
        unVar.a(this);
        setConstraintSet(null);
        requestLayout();
        int i3 = 0;
        while (true) {
            SparseArray sparseArray = this.y;
            if (i3 >= sparseArray.size()) {
                return;
            }
            ((TextView) sparseArray.get(i3)).setVisibility(0);
            i3++;
        }
    }

    public final void n() {
        SparseArray sparseArray;
        Rect rect;
        RectF rectF;
        RectF rectF2 = this.u.h;
        float f = Float.MAX_VALUE;
        TextView textView = null;
        int i = 0;
        while (true) {
            sparseArray = this.y;
            int size = sparseArray.size();
            rect = this.v;
            rectF = this.w;
            if (i >= size) {
                break;
            }
            TextView textView2 = (TextView) sparseArray.get(i);
            if (textView2 != null) {
                textView2.getHitRect(rect);
                rectF.set(rect);
                rectF.union(rectF2);
                float fHeight = rectF.height() * rectF.width();
                if (fHeight < f) {
                    textView = textView2;
                    f = fHeight;
                }
            }
            i++;
        }
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            TextView textView3 = (TextView) sparseArray.get(i2);
            if (textView3 != null) {
                textView3.setSelected(textView3 == textView);
                textView3.getHitRect(rect);
                rectF.set(rect);
                textView3.getLineBounds(0, this.x);
                rectF.inset(r8.left, r8.top);
                textView3.getPaint().setShader(!RectF.intersects(rectF2, rectF) ? null : new RadialGradient(rectF2.centerX() - rectF.left, rectF2.centerY() - rectF.top, 0.5f * rectF2.width(), this.A, this.B, Shader.TileMode.CLAMP));
                textView3.invalidate();
            }
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(1, this.G.length, false, 1));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        n();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int iMax = (int) (this.F / Math.max(Math.max(this.D / displayMetrics.heightPixels, this.E / displayMetrics.widthPixels), 1.0f));
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMax, 1073741824);
        setMeasuredDimension(iMax, iMax);
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec);
    }
}
