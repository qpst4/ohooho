package defpackage;

import android.graphics.Paint;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class je1 extends me1 {
    public f9 d;
    public float e;
    public f9 f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public Paint.Cap l;
    public Paint.Join m;
    public float n;

    @Override // defpackage.le1
    public final boolean a() {
        return this.f.d() || this.d.d();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001e  */
    @Override // defpackage.le1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(int[] r6) {
        /*
            r5 = this;
            f9 r0 = r5.f
            boolean r1 = r0.d()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L1e
            java.lang.Object r1 = r0.d
            android.content.res.ColorStateList r1 = (android.content.res.ColorStateList) r1
            int r4 = r1.getDefaultColor()
            int r1 = r1.getColorForState(r6, r4)
            int r4 = r0.b
            if (r1 == r4) goto L1e
            r0.b = r1
            r0 = r2
            goto L1f
        L1e:
            r0 = r3
        L1f:
            f9 r5 = r5.d
            boolean r1 = r5.d()
            if (r1 == 0) goto L3a
            java.lang.Object r1 = r5.d
            android.content.res.ColorStateList r1 = (android.content.res.ColorStateList) r1
            int r4 = r1.getDefaultColor()
            int r6 = r1.getColorForState(r6, r4)
            int r1 = r5.b
            if (r6 == r1) goto L3a
            r5.b = r6
            goto L3b
        L3a:
            r2 = r3
        L3b:
            r5 = r0 | r2
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.je1.b(int[]):boolean");
    }

    public float getFillAlpha() {
        return this.h;
    }

    public int getFillColor() {
        return this.f.b;
    }

    public float getStrokeAlpha() {
        return this.g;
    }

    public int getStrokeColor() {
        return this.d.b;
    }

    public float getStrokeWidth() {
        return this.e;
    }

    public float getTrimPathEnd() {
        return this.j;
    }

    public float getTrimPathOffset() {
        return this.k;
    }

    public float getTrimPathStart() {
        return this.i;
    }

    public void setFillAlpha(float f) {
        this.h = f;
    }

    public void setFillColor(int i) {
        this.f.b = i;
    }

    public void setStrokeAlpha(float f) {
        this.g = f;
    }

    public void setStrokeColor(int i) {
        this.d.b = i;
    }

    public void setStrokeWidth(float f) {
        this.e = f;
    }

    public void setTrimPathEnd(float f) {
        this.j = f;
    }

    public void setTrimPathOffset(float f) {
        this.k = f;
    }

    public void setTrimPathStart(float f) {
        this.i = f;
    }
}
