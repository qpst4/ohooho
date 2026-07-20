package defpackage;

import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class vc1 extends ReplacementSpan {
    public final uc1 c;
    public TextPaint f;
    public final Paint.FontMetricsInt b = new Paint.FontMetricsInt();
    public short d = -1;
    public float e = 1.0f;

    public vc1(uc1 uc1Var) {
        f01.k("rasterizer cannot be null", uc1Var);
        this.c = uc1Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0042  */
    @Override // android.text.style.ReplacementSpan
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void draw(android.graphics.Canvas r19, java.lang.CharSequence r20, int r21, int r22, float r23, int r24, int r25, int r26, android.graphics.Paint r27) {
        /*
            r18 = this;
            r0 = r18
            r1 = r20
            r2 = r27
            boolean r3 = r1 instanceof android.text.Spanned
            r4 = 0
            if (r3 == 0) goto L4a
            android.text.Spanned r1 = (android.text.Spanned) r1
            java.lang.Class<android.text.style.CharacterStyle> r3 = android.text.style.CharacterStyle.class
            r5 = r21
            r6 = r22
            java.lang.Object[] r1 = r1.getSpans(r5, r6, r3)
            android.text.style.CharacterStyle[] r1 = (android.text.style.CharacterStyle[]) r1
            int r3 = r1.length
            if (r3 == 0) goto L42
            int r3 = r1.length
            r5 = 0
            r6 = 1
            if (r3 != r6) goto L26
            r3 = r1[r5]
            if (r3 != r0) goto L26
            goto L42
        L26:
            android.text.TextPaint r3 = r0.f
            if (r3 != 0) goto L31
            android.text.TextPaint r3 = new android.text.TextPaint
            r3.<init>()
            r0.f = r3
        L31:
            r4 = r3
            r4.set(r2)
        L35:
            int r3 = r1.length
            if (r5 >= r3) goto L40
            r3 = r1[r5]
            r3.updateDrawState(r4)
            int r5 = r5 + 1
            goto L35
        L40:
            r10 = r4
            goto L52
        L42:
            boolean r1 = r2 instanceof android.text.TextPaint
            if (r1 == 0) goto L40
            r4 = r2
            android.text.TextPaint r4 = (android.text.TextPaint) r4
            goto L40
        L4a:
            boolean r1 = r2 instanceof android.text.TextPaint
            if (r1 == 0) goto L40
            r4 = r2
            android.text.TextPaint r4 = (android.text.TextPaint) r4
            goto L40
        L52:
            if (r10 == 0) goto L82
            int r1 = r10.bgColor
            if (r1 == 0) goto L82
            short r1 = r0.d
            float r1 = (float) r1
            float r8 = r23 + r1
            r1 = r24
            float r7 = (float) r1
            r1 = r26
            float r9 = (float) r1
            int r1 = r10.getColor()
            android.graphics.Paint$Style r3 = r10.getStyle()
            int r4 = r10.bgColor
            r10.setColor(r4)
            android.graphics.Paint$Style r4 = android.graphics.Paint.Style.FILL
            r10.setStyle(r4)
            r5 = r19
            r6 = r23
            r5.drawRect(r6, r7, r8, r9, r10)
            r10.setStyle(r3)
            r10.setColor(r1)
        L82:
            sx r1 = defpackage.sx.a()
            r1.getClass()
            r1 = r25
            float r1 = (float) r1
            if (r10 == 0) goto L8f
            goto L90
        L8f:
            r10 = r2
        L90:
            uc1 r0 = r0.c
            g7 r2 = r0.b
            java.lang.Object r3 = r2.e
            android.graphics.Typeface r3 = (android.graphics.Typeface) r3
            android.graphics.Typeface r4 = r10.getTypeface()
            r10.setTypeface(r3)
            int r0 = r0.a
            int r13 = r0 * 2
            java.lang.Object r0 = r2.d
            r12 = r0
            char[] r12 = (char[]) r12
            r14 = 2
            r11 = r19
            r15 = r23
            r16 = r1
            r17 = r10
            r11.drawText(r12, r13, r14, r15, r16, r17)
            r10.setTypeface(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vc1.draw(android.graphics.Canvas, java.lang.CharSequence, int, int, float, int, int, int, android.graphics.Paint):void");
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Paint.FontMetricsInt fontMetricsInt2 = this.b;
        paint.getFontMetricsInt(fontMetricsInt2);
        float fAbs = Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f;
        uc1 uc1Var = this.c;
        this.e = fAbs / (uc1Var.b().a(14) != 0 ? ((ByteBuffer) r8.d).getShort(r1 + r8.a) : (short) 0);
        ul0 ul0VarB = uc1Var.b();
        int iA = ul0VarB.a(14);
        if (iA != 0) {
            ((ByteBuffer) ul0VarB.d).getShort(iA + ul0VarB.a);
        }
        short s = (short) ((uc1Var.b().a(12) != 0 ? ((ByteBuffer) r5.d).getShort(r7 + r5.a) : (short) 0) * this.e);
        this.d = s;
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return s;
    }
}
