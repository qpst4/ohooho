package com.yalantis.ucrop.view;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.TextView;
import defpackage.p81;
import defpackage.pq;
import defpackage.qw0;
import defpackage.wc1;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class GestureCropImageView extends pq {
    public ScaleGestureDetector F;
    public qw0 G;
    public GestureDetector H;
    public float I;
    public float J;
    public boolean K;
    public boolean L;
    public int M;

    public GestureCropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.K = true;
        this.L = true;
        this.M = 5;
    }

    public int getDoubleTapScaleSteps() {
        return this.M;
    }

    public float getDoubleTapTargetScale() {
        return getCurrentScale() * ((float) Math.pow(getMaxScale() / getMinScale(), 1.0f / this.M));
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) == 0) {
            f();
        }
        if (motionEvent.getPointerCount() > 1) {
            this.I = (motionEvent.getX(1) + motionEvent.getX(0)) / 2.0f;
            this.J = (motionEvent.getY(1) + motionEvent.getY(0)) / 2.0f;
        }
        this.H.onTouchEvent(motionEvent);
        if (this.L) {
            this.F.onTouchEvent(motionEvent);
        }
        if (this.K) {
            qw0 qw0Var = this.G;
            qw0Var.getClass();
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                qw0Var.c = motionEvent.getX();
                qw0Var.d = motionEvent.getY();
                qw0Var.e = motionEvent.findPointerIndex(motionEvent.getPointerId(0));
                qw0Var.g = 0.0f;
                qw0Var.h = true;
            } else if (actionMasked == 1) {
                qw0Var.e = -1;
            } else if (actionMasked != 2) {
                if (actionMasked == 5) {
                    qw0Var.a = motionEvent.getX();
                    qw0Var.b = motionEvent.getY();
                    qw0Var.f = motionEvent.findPointerIndex(motionEvent.getPointerId(motionEvent.getActionIndex()));
                    qw0Var.g = 0.0f;
                    qw0Var.h = true;
                } else if (actionMasked == 6) {
                    qw0Var.f = -1;
                }
            } else if (qw0Var.e != -1 && qw0Var.f != -1 && motionEvent.getPointerCount() > qw0Var.f) {
                float x = motionEvent.getX(qw0Var.e);
                float y = motionEvent.getY(qw0Var.e);
                float x2 = motionEvent.getX(qw0Var.f);
                float y2 = motionEvent.getY(qw0Var.f);
                if (qw0Var.h) {
                    qw0Var.g = 0.0f;
                    qw0Var.h = false;
                } else {
                    float f = qw0Var.a;
                    float degrees = (((float) Math.toDegrees((float) Math.atan2(y2 - y, x2 - x))) % 360.0f) - (((float) Math.toDegrees((float) Math.atan2(qw0Var.b - qw0Var.d, f - qw0Var.c))) % 360.0f);
                    qw0Var.g = degrees;
                    if (degrees < -180.0f) {
                        qw0Var.g = degrees + 360.0f;
                    } else if (degrees > 180.0f) {
                        qw0Var.g = degrees - 360.0f;
                    }
                }
                GestureCropImageView gestureCropImageView = (GestureCropImageView) qw0Var.i.c;
                float f2 = qw0Var.g;
                float f3 = gestureCropImageView.I;
                float f4 = gestureCropImageView.J;
                Matrix matrix = gestureCropImageView.h;
                if (f2 != 0.0f) {
                    matrix.postRotate(f2, f3, f4);
                    gestureCropImageView.setImageMatrix(matrix);
                    p81 p81Var = gestureCropImageView.k;
                    if (p81Var != null) {
                        float[] fArr = gestureCropImageView.g;
                        matrix.getValues(fArr);
                        double d = fArr[1];
                        matrix.getValues(fArr);
                        float f5 = (float) (-(Math.atan2(d, fArr[0]) * 57.29577951308232d));
                        TextView textView = ((wc1) p81Var).b.V;
                        if (textView != null) {
                            textView.setText(String.format(Locale.getDefault(), "%.1f°", Float.valueOf(f5)));
                        }
                    }
                }
                qw0Var.a = x2;
                qw0Var.b = y2;
                qw0Var.c = x;
                qw0Var.d = y;
            }
        }
        if ((motionEvent.getAction() & 255) == 1) {
            setImageToWrapCropBounds(true);
        }
        return true;
    }

    public void setDoubleTapScaleSteps(int i) {
        this.M = i;
    }

    public void setRotateEnabled(boolean z) {
        this.K = z;
    }

    public void setScaleEnabled(boolean z) {
        this.L = z;
    }
}
