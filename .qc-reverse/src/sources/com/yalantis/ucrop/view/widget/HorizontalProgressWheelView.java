package com.yalantis.ucrop.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.quickcursor.R;
import defpackage.p80;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class HorizontalProgressWheelView extends View {
    public final Rect b;
    public p80 c;
    public float d;
    public final Paint e;
    public final Paint f;
    public final int g;
    public final int h;
    public final int i;
    public boolean j;
    public float k;
    public int l;

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.b = new Rect();
        this.l = getContext().getColor(R.color.ucrop_color_widget_rotate_mid_line);
        this.g = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_width_horizontal_wheel_progress_line);
        this.h = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_height_horizontal_wheel_progress_line);
        this.i = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_margin_horizontal_wheel_progress_line);
        Paint paint = new Paint(1);
        this.e = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.e.setStrokeWidth(this.g);
        this.e.setColor(getResources().getColor(R.color.ucrop_color_progress_wheel_line));
        Paint paint2 = new Paint(this.e);
        this.f = paint2;
        paint2.setColor(this.l);
        this.f.setStrokeCap(Paint.Cap.ROUND);
        this.f.setStrokeWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_width_middle_wheel_progress_line));
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect = this.b;
        Canvas canvas2 = canvas;
        canvas.getClipBounds(rect);
        int iWidth = rect.width() / (this.g + this.i);
        float f = this.k % (r8 + r7);
        int i = 0;
        while (true) {
            int i2 = this.h;
            if (i >= iWidth) {
                canvas.drawLine(rect.centerX(), rect.centerY() - (i2 / 2.0f), rect.centerX(), (i2 / 2.0f) + rect.centerY(), this.f);
                return;
            }
            int i3 = iWidth / 4;
            Paint paint = this.e;
            if (i < i3) {
                paint.setAlpha((int) ((i / i3) * 255.0f));
            } else if (i > (iWidth * 3) / 4) {
                paint.setAlpha((int) (((iWidth - i) / i3) * 255.0f));
            } else {
                paint.setAlpha(255);
            }
            float f2 = -f;
            canvas2.drawLine(rect.left + f2 + ((r7 + r8) * i), rect.centerY() - (i2 / 4.0f), f2 + rect.left + ((r7 + r8) * i), (i2 / 4.0f) + rect.centerY(), this.e);
            i++;
            canvas2 = canvas;
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.d = motionEvent.getX();
            return true;
        }
        if (action == 1) {
            p80 p80Var = this.c;
            if (p80Var != null) {
                this.j = false;
                p80Var.b();
            }
        } else if (action == 2) {
            float x = motionEvent.getX() - this.d;
            if (x != 0.0f) {
                if (!this.j) {
                    this.j = true;
                    p80 p80Var2 = this.c;
                    if (p80Var2 != null) {
                        p80Var2.c();
                    }
                }
                this.k -= x;
                postInvalidate();
                this.d = motionEvent.getX();
                p80 p80Var3 = this.c;
                if (p80Var3 != null) {
                    p80Var3.a(-x);
                    return true;
                }
            }
        }
        return true;
    }

    public void setMiddleLineColor(int i) {
        this.l = i;
        this.f.setColor(i);
        invalidate();
    }

    public void setScrollingListener(p80 p80Var) {
        this.c = p80Var;
    }
}
