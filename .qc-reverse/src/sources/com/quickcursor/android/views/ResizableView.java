package com.quickcursor.android.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.quickcursor.App;
import com.quickcursor.R;
import defpackage.ey0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ResizableView extends View {
    public final int b;
    public final int c;
    public final Paint d;
    public final Paint e;
    public final Paint f;
    public final Paint g;
    public final int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;

    public ResizableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int iA = ey0.a(40);
        this.b = iA;
        this.c = iA * 2;
        this.o = -1;
        this.h = ey0.a(3);
        Paint paint = new Paint(1);
        this.g = paint;
        paint.setColor(App.c.getColor(R.color.activity_window_config_window_handler));
        Paint paint2 = this.g;
        Paint.Style style = Paint.Style.FILL;
        paint2.setStyle(style);
        this.g.setTextAlign(Paint.Align.CENTER);
        this.g.setTextSize(30.0f);
        Paint paint3 = new Paint(1);
        this.d = paint3;
        paint3.setColor(App.c.getColor(R.color.activity_window_config_window_background));
        this.d.setStyle(style);
        Paint paint4 = new Paint(1);
        this.e = paint4;
        Paint.Style style2 = Paint.Style.STROKE;
        paint4.setStyle(style2);
        this.e.setStrokeWidth(this.h);
        this.e.setColor(App.c.getColor(R.color.activity_window_config_window_border));
        Paint paint5 = new Paint(1);
        this.f = paint5;
        paint5.setStyle(style2);
        this.f.setStrokeWidth(this.h);
        this.f.setColor(App.c.getColor(R.color.activity_window_config_window_handler));
    }

    public final void a(Canvas canvas, int i, int i2, int i3, int i4) {
        Path path = new Path();
        float f = i2;
        path.moveTo(i3 + i, f);
        float f2 = i;
        path.lineTo(f2, f);
        path.lineTo(f2, i2 + i4);
        canvas.drawPath(path, this.f);
    }

    public final void b(int i, int i2, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int i5 = this.c;
        layoutParams.width = Math.max(i5, i3 - i);
        getLayoutParams().height = Math.max(i5, i4 - i2);
        requestLayout();
        setX(i);
        setY(i2);
        requestLayout();
    }

    public Rect getRect() {
        return new Rect((int) getX(), (int) getY(), (int) (getX() + getWidth()), (int) (getY() + getHeight()));
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int i = this.h;
        int i2 = i * 2;
        float f = width;
        float f2 = height;
        canvas.drawRect(0.0f, 0.0f, f, f2, this.d);
        canvas.drawRect(0.0f, 0.0f, f, f2, this.e);
        int i3 = i * 4;
        a(canvas, i2, i2, i3, i3);
        int i4 = width - i2;
        int i5 = i * (-4);
        a(canvas, i4, i2, i5, i3);
        int i6 = height - i2;
        a(canvas, i2, i6, i3, i5);
        a(canvas, i4, i6, i5, i5);
        Paint.Align align = Paint.Align.LEFT;
        Paint paint = this.g;
        paint.setTextAlign(align);
        canvas.drawText(((int) getX()) + ", " + ((int) getY()), i3, i * 8, paint);
        paint.setTextAlign(Paint.Align.RIGHT);
        canvas.drawText((((int) getX()) + width) + ", " + (((int) getY()) + height), i4 - i2, height - i3, paint);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r13) {
        /*
            Method dump skipped, instruction units count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quickcursor.android.views.ResizableView.onTouchEvent(android.view.MotionEvent):boolean");
    }
}
