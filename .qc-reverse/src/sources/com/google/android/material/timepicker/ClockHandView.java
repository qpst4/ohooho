package com.google.android.material.timepicker;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.quickcursor.R;
import defpackage.i1;
import defpackage.s7;
import defpackage.uf1;
import defpackage.yk;
import defpackage.ys0;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
class ClockHandView extends View {
    public final ValueAnimator b;
    public boolean c;
    public final ArrayList d;
    public final int e;
    public final float f;
    public final Paint g;
    public final RectF h;
    public final int i;
    public float j;
    public boolean k;
    public double l;
    public int m;
    public int n;

    public ClockHandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.materialClockStyle);
        this.b = new ValueAnimator();
        this.d = new ArrayList();
        Paint paint = new Paint();
        this.g = paint;
        this.h = new RectF();
        this.n = 1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ys0.f, R.attr.materialClockStyle, R.style.Widget_MaterialComponents_TimePicker_Clock);
        i1.T(context, R.attr.motionDurationLong2, 200);
        i1.U(context, R.attr.motionEasingEmphasizedInterpolator, s7.b);
        this.m = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.e = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.i = getResources().getDimensionPixelSize(R.dimen.material_clock_hand_stroke_width);
        this.f = r4.getDimensionPixelSize(R.dimen.material_clock_hand_center_dot_radius);
        int color = typedArrayObtainStyledAttributes.getColor(0, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        a(0.0f);
        ViewConfiguration.get(context).getScaledTouchSlop();
        WeakHashMap weakHashMap = uf1.a;
        setImportantForAccessibility(2);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void a(float f) {
        ValueAnimator valueAnimator = this.b;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        float f2 = f % 360.0f;
        this.j = f2;
        this.l = Math.toRadians(f2 - 90.0f);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        int i = this.n;
        int iRound = this.m;
        if (i == 2) {
            iRound = Math.round(iRound * 0.66f);
        }
        float f3 = width;
        float f4 = iRound;
        float fCos = (((float) Math.cos(this.l)) * f4) + f3;
        float fSin = (f4 * ((float) Math.sin(this.l))) + height;
        float f5 = this.e;
        this.h.set(fCos - f5, fSin - f5, fCos + f5, fSin + f5);
        ArrayList arrayList = this.d;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ClockFaceView clockFaceView = (ClockFaceView) ((yk) obj);
            if (Math.abs(clockFaceView.H - f2) > 0.001f) {
                clockFaceView.H = f2;
                clockFaceView.n();
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        int i = this.n;
        int iRound = this.m;
        if (i == 2) {
            iRound = Math.round(iRound * 0.66f);
        }
        float f = width;
        float f2 = iRound;
        float fCos = (((float) Math.cos(this.l)) * f2) + f;
        float f3 = height;
        float fSin = (f2 * ((float) Math.sin(this.l))) + f3;
        Paint paint = this.g;
        paint.setStrokeWidth(0.0f);
        canvas.drawCircle(fCos, fSin, this.e, paint);
        double dSin = Math.sin(this.l);
        paint.setStrokeWidth(this.i);
        canvas.drawLine(f, f3, width + ((int) (Math.cos(this.l) * d)), height + ((int) (d * dSin)), paint);
        canvas.drawCircle(f, f3, this.f, paint);
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.b.isRunning()) {
            return;
        }
        a(this.j);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        int actionMasked = motionEvent.getActionMasked();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        boolean z3 = false;
        if (actionMasked == 0) {
            this.k = false;
            z = true;
            z2 = false;
        } else if (actionMasked == 1 || actionMasked == 2) {
            z2 = this.k;
            if (this.c) {
                this.n = ((float) Math.hypot((double) (x - ((float) (getWidth() / 2))), (double) (y - ((float) (getHeight() / 2))))) <= ((float) Math.round(((float) this.m) * 0.66f)) + i1.p(getContext(), 12) ? 2 : 1;
            }
            z = false;
        } else {
            z2 = false;
            z = false;
        }
        boolean z4 = this.k;
        int degrees = (int) Math.toDegrees(Math.atan2(y - (getHeight() / 2), x - (getWidth() / 2)));
        int i = degrees + 90;
        if (i < 0) {
            i = degrees + 450;
        }
        float f = i;
        boolean z5 = this.j != f;
        if (z && z5) {
            z3 = true;
        } else if (z5 || z2) {
            a(f);
            z3 = true;
        }
        this.k = z4 | z3;
        return true;
    }
}
