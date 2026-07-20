package com.yalantis.ucrop.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.quickcursor.R;
import defpackage.so0;
import defpackage.yc1;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class OverlayView extends View {
    public so0 A;
    public boolean B;
    public final RectF b;
    public final RectF c;
    public int d;
    public int e;
    public float[] f;
    public int g;
    public int h;
    public float i;
    public float[] j;
    public boolean k;
    public boolean l;
    public boolean m;
    public int n;
    public final Path o;
    public final Paint p;
    public final Paint q;
    public final Paint r;
    public final Paint s;
    public int t;
    public float u;
    public float v;
    public int w;
    public final int x;
    public final int y;
    public final int z;

    public OverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.b = new RectF();
        this.c = new RectF();
        this.j = null;
        this.o = new Path();
        this.p = new Paint(1);
        this.q = new Paint(1);
        this.r = new Paint(1);
        this.s = new Paint(1);
        this.t = 0;
        this.u = -1.0f;
        this.v = -1.0f;
        this.w = -1;
        this.x = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_corner_touch_threshold);
        this.y = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_min_size);
        this.z = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_corner_touch_area_line_length);
    }

    public final void a() {
        RectF rectF = this.b;
        float f = rectF.left;
        float f2 = rectF.top;
        float f3 = rectF.right;
        float f4 = rectF.bottom;
        this.f = new float[]{f, f2, f3, f2, f3, f4, f, f4};
        rectF.centerX();
        rectF.centerY();
        this.j = null;
        Path path = this.o;
        path.reset();
        path.addCircle(rectF.centerX(), rectF.centerY(), Math.min(rectF.width(), rectF.height()) / 2.0f, Path.Direction.CW);
    }

    public RectF getCropViewRect() {
        return this.b;
    }

    public int getFreestyleCropMode() {
        return this.t;
    }

    public so0 getOverlayViewChangeListener() {
        return this.A;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        boolean z = this.m;
        RectF rectF = this.b;
        if (z) {
            canvas.clipPath(this.o, Region.Op.DIFFERENCE);
        } else {
            canvas.clipRect(rectF, Region.Op.DIFFERENCE);
        }
        canvas.drawColor(this.n);
        canvas.restore();
        if (this.m) {
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), Math.min(rectF.width(), rectF.height()) / 2.0f, this.p);
        }
        if (this.l) {
            if (this.j == null && !rectF.isEmpty()) {
                this.j = new float[(this.h * 4) + (this.g * 4)];
                int i = 0;
                for (int i2 = 0; i2 < this.g; i2++) {
                    float[] fArr = this.j;
                    fArr[i] = rectF.left;
                    float f = i2 + 1.0f;
                    fArr[i + 1] = ((f / (this.g + 1)) * rectF.height()) + rectF.top;
                    float[] fArr2 = this.j;
                    int i3 = i + 3;
                    fArr2[i + 2] = rectF.right;
                    i += 4;
                    fArr2[i3] = ((f / (this.g + 1)) * rectF.height()) + rectF.top;
                }
                for (int i4 = 0; i4 < this.h; i4++) {
                    float f2 = i4 + 1.0f;
                    this.j[i] = ((f2 / (this.h + 1)) * rectF.width()) + rectF.left;
                    float[] fArr3 = this.j;
                    fArr3[i + 1] = rectF.top;
                    int i5 = i + 3;
                    fArr3[i + 2] = ((f2 / (this.h + 1)) * rectF.width()) + rectF.left;
                    i += 4;
                    this.j[i5] = rectF.bottom;
                }
            }
            float[] fArr4 = this.j;
            if (fArr4 != null) {
                canvas.drawLines(fArr4, this.q);
            }
        }
        if (this.k) {
            canvas.drawRect(rectF, this.r);
        }
        if (this.t != 0) {
            canvas.save();
            RectF rectF2 = this.c;
            rectF2.set(rectF);
            int i6 = this.z;
            float f3 = i6;
            float f4 = -i6;
            rectF2.inset(f3, f4);
            Region.Op op = Region.Op.DIFFERENCE;
            canvas.clipRect(rectF2, op);
            rectF2.set(rectF);
            rectF2.inset(f4, f3);
            canvas.clipRect(rectF2, op);
            canvas.drawRect(rectF, this.s);
            canvas.restore();
        }
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            this.d = width - paddingLeft;
            this.e = height - paddingTop;
            if (this.B) {
                this.B = false;
                setTargetAspectRatio(this.i);
            }
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        RectF rectF = this.b;
        if (rectF.isEmpty() || this.t == 0) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if ((motionEvent.getAction() & 255) == 0) {
            double d = this.x;
            int i2 = -1;
            for (int i3 = 0; i3 < 8; i3 += 2) {
                double dSqrt = Math.sqrt(Math.pow(y - this.f[i3 + 1], 2.0d) + Math.pow(x - this.f[i3], 2.0d));
                if (dSqrt < d) {
                    i2 = i3 / 2;
                    d = dSqrt;
                }
            }
            int i4 = (this.t == 1 && i2 < 0 && rectF.contains(x, y)) ? 4 : i2;
            this.w = i4;
            boolean z = i4 != -1;
            if (!z) {
                this.u = -1.0f;
                this.v = -1.0f;
                return z;
            }
            if (this.u < 0.0f) {
                this.u = x;
                this.v = y;
            }
            return z;
        }
        if ((motionEvent.getAction() & 255) != 2) {
            i = 1;
        } else if (motionEvent.getPointerCount() == 1) {
            if (this.w != -1) {
                float fMin = Math.min(Math.max(x, getPaddingLeft()), getWidth() - getPaddingRight());
                float fMin2 = Math.min(Math.max(y, getPaddingTop()), getHeight() - getPaddingBottom());
                RectF rectF2 = this.c;
                rectF2.set(rectF);
                int i5 = this.w;
                if (i5 == 0) {
                    rectF2.set(fMin, fMin2, rectF.right, rectF.bottom);
                } else if (i5 == 1) {
                    rectF2.set(rectF.left, fMin2, fMin, rectF.bottom);
                } else if (i5 == 2) {
                    rectF2.set(rectF.left, rectF.top, fMin, fMin2);
                } else {
                    if (i5 != 3) {
                        if (i5 == 4) {
                            rectF2.offset(fMin - this.u, fMin2 - this.v);
                            if (rectF2.left > getLeft() && rectF2.top > getTop() && rectF2.right < getRight() && rectF2.bottom < getBottom()) {
                                rectF.set(rectF2);
                                a();
                                postInvalidate();
                            }
                        }
                        this.u = fMin;
                        this.v = fMin2;
                        return true;
                    }
                    rectF2.set(fMin, rectF.top, rectF.right, fMin2);
                }
                float fHeight = rectF2.height();
                float f = this.y;
                boolean z2 = fHeight >= f;
                boolean z3 = rectF2.width() >= f;
                rectF.set(z3 ? rectF2.left : rectF.left, z2 ? rectF2.top : rectF.top, z3 ? rectF2.right : rectF.right, z2 ? rectF2.bottom : rectF.bottom);
                if (z2 || z3) {
                    a();
                    postInvalidate();
                }
                this.u = fMin;
                this.v = fMin2;
                return true;
            }
            i = 1;
        } else {
            i = 1;
        }
        if ((motionEvent.getAction() & 255) != i) {
            return false;
        }
        this.u = -1.0f;
        this.v = -1.0f;
        this.w = -1;
        so0 so0Var = this.A;
        if (so0Var == null) {
            return false;
        }
        ((yc1) so0Var).a.b.setCropRect(rectF);
        return false;
    }

    public void setCircleDimmedLayer(boolean z) {
        this.m = z;
    }

    public void setCropFrameColor(int i) {
        this.r.setColor(i);
    }

    public void setCropFrameStrokeWidth(int i) {
        this.r.setStrokeWidth(i);
    }

    public void setCropGridColor(int i) {
        this.q.setColor(i);
    }

    public void setCropGridColumnCount(int i) {
        this.h = i;
        this.j = null;
    }

    public void setCropGridRowCount(int i) {
        this.g = i;
        this.j = null;
    }

    public void setCropGridStrokeWidth(int i) {
        this.q.setStrokeWidth(i);
    }

    public void setDimmedColor(int i) {
        this.n = i;
    }

    @Deprecated
    public void setFreestyleCropEnabled(boolean z) {
        this.t = z ? 1 : 0;
    }

    public void setFreestyleCropMode(int i) {
        this.t = i;
        postInvalidate();
    }

    public void setOverlayViewChangeListener(so0 so0Var) {
        this.A = so0Var;
    }

    public void setShowCropFrame(boolean z) {
        this.k = z;
    }

    public void setShowCropGrid(boolean z) {
        this.l = z;
    }

    public void setTargetAspectRatio(float f) {
        this.i = f;
        int i = this.d;
        if (i <= 0) {
            this.B = true;
            return;
        }
        int i2 = (int) (i / f);
        int i3 = this.e;
        RectF rectF = this.b;
        if (i2 > i3) {
            int i4 = (i - ((int) (i3 * f))) / 2;
            rectF.set(getPaddingLeft() + i4, getPaddingTop(), getPaddingLeft() + r7 + i4, getPaddingTop() + this.e);
        } else {
            int i5 = (i3 - i2) / 2;
            rectF.set(getPaddingLeft(), getPaddingTop() + i5, getPaddingLeft() + this.d, getPaddingTop() + i2 + i5);
        }
        so0 so0Var = this.A;
        if (so0Var != null) {
            ((yc1) so0Var).a.b.setCropRect(rectF);
        }
        a();
        postInvalidate();
    }
}
