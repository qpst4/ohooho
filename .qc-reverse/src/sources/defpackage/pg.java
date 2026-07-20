package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class pg implements LeadingMarginSpan {
    public final /* synthetic */ int b;
    public final ij0 c;
    public final Rect d;
    public final Paint e;

    public pg(ij0 ij0Var, int i) {
        this.b = i;
        switch (i) {
            case 1:
                this.d = qn0.a;
                this.e = qn0.c;
                this.c = ij0Var;
                break;
            default:
                this.d = qn0.a;
                this.e = qn0.c;
                this.c = ij0Var;
                break;
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public final void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        int width;
        int i8 = this.b;
        ij0 ij0Var = this.c;
        Paint paint2 = this.e;
        Rect rect = this.d;
        switch (i8) {
            case 0:
                int i9 = ij0Var.b;
                if (i9 == 0) {
                    i9 = (int) ((ij0Var.a * 0.25f) + 0.5f);
                }
                paint2.set(paint);
                ij0Var.getClass();
                int iC = fp1.c(paint2.getColor(), 25);
                paint2.setStyle(Paint.Style.FILL);
                paint2.setColor(iC);
                int i10 = i2 * i9;
                int i11 = i + i10;
                int i12 = i10 + i11;
                rect.set(Math.min(i11, i12), i3, Math.max(i11, i12), i5);
                canvas.drawRect(rect, paint2);
                break;
            default:
                int i13 = ((i5 - i3) / 2) + i3;
                paint2.set(paint);
                ij0Var.getClass();
                paint2.setColor(fp1.c(paint2.getColor(), 25));
                paint2.setStyle(Paint.Style.FILL);
                int i14 = ij0Var.f;
                if (i14 >= 0) {
                    paint2.setStrokeWidth(i14);
                }
                int strokeWidth = (int) ((((int) (paint2.getStrokeWidth() + 0.5f)) / 2.0f) + 0.5f);
                if (i2 > 0) {
                    width = canvas.getWidth();
                } else {
                    width = i;
                    i -= canvas.getWidth();
                }
                rect.set(i, i13 - strokeWidth, width, i13 + strokeWidth);
                canvas.drawRect(rect, paint2);
                break;
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public final int getLeadingMargin(boolean z) {
        switch (this.b) {
            case 0:
                return this.c.a;
            default:
                return 0;
        }
    }
}
