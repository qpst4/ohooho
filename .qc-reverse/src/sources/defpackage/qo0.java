package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class qo0 implements LeadingMarginSpan {
    public final ij0 b;
    public final String c;
    public final Paint d = qn0.c;
    public int e;

    public qo0(ij0 ij0Var, String str) {
        this.b = ij0Var;
        this.c = str;
    }

    @Override // android.text.style.LeadingMarginSpan
    public final void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        int i8;
        if (z && (charSequence instanceof Spanned) && ((Spanned) charSequence).getSpanStart(this) == i6) {
            Paint paint2 = this.d;
            paint2.set(paint);
            ij0 ij0Var = this.b;
            ij0Var.getClass();
            paint2.setColor(paint2.getColor());
            int i9 = ij0Var.c;
            if (i9 != 0) {
                paint2.setStrokeWidth(i9);
            }
            String str = this.c;
            int iMeasureText = (int) (paint2.measureText(str) + 0.5f);
            int i10 = ij0Var.a;
            if (iMeasureText > i10) {
                this.e = iMeasureText;
                i10 = iMeasureText;
            } else {
                this.e = 0;
            }
            if (i2 > 0) {
                i8 = ((i10 * i2) + i) - iMeasureText;
            } else {
                i8 = (i10 - iMeasureText) + (i2 * i10) + i;
            }
            canvas.drawText(str, i8, i4, paint2);
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public final int getLeadingMargin(boolean z) {
        return Math.max(this.e, this.b.a);
    }
}
