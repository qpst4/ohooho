package com.yalantis.ucrop.view.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.quickcursor.R;
import defpackage.ps0;
import defpackage.qb;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class AspectRatioTextView extends AppCompatTextView {
    public final Rect i;
    public final Paint j;
    public final int k;
    public float l;
    public String m;
    public float n;
    public float o;

    public AspectRatioTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.i = new Rect();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ps0.a);
        setGravity(1);
        this.m = typedArrayObtainStyledAttributes.getString(0);
        this.n = typedArrayObtainStyledAttributes.getFloat(1, 0.0f);
        float f = typedArrayObtainStyledAttributes.getFloat(2, 0.0f);
        this.o = f;
        float f2 = this.n;
        if (f2 == 0.0f || f == 0.0f) {
            this.l = 0.0f;
        } else {
            this.l = f2 / f;
        }
        this.k = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_size_dot_scale_text_view);
        Paint paint = new Paint(1);
        this.j = paint;
        paint.setStyle(Paint.Style.FILL);
        h();
        g(getResources().getColor(R.color.ucrop_color_widget_active));
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void g(int i) {
        Paint paint = this.j;
        if (paint != null) {
            paint.setColor(i);
        }
        setTextColor(new ColorStateList(new int[][]{new int[]{android.R.attr.state_selected}, new int[]{0}}, new int[]{i, getContext().getColor(R.color.ucrop_color_widget)}));
    }

    public final void h() {
        if (!TextUtils.isEmpty(this.m)) {
            setText(this.m);
            return;
        }
        Locale locale = Locale.US;
        setText(((int) this.n) + ":" + ((int) this.o));
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isSelected()) {
            canvas.getClipBounds(this.i);
            float f = (r0.right - r0.left) / 2.0f;
            float f2 = r0.bottom - (r0.top / 2.0f);
            int i = this.k;
            canvas.drawCircle(f, f2 - (i * 1.5f), i / 2.0f, this.j);
        }
    }

    public void setActiveColor(int i) {
        g(i);
        invalidate();
    }

    public void setAspectRatio(qb qbVar) {
        this.m = qbVar.b;
        float f = qbVar.c;
        this.n = f;
        float f2 = qbVar.d;
        this.o = f2;
        if (f == 0.0f || f2 == 0.0f) {
            this.l = 0.0f;
        } else {
            this.l = f / f2;
        }
        h();
    }
}
