package defpackage;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ne1 {
    public static final Matrix p = new Matrix();
    public final Path a;
    public final Path b;
    public final Matrix c;
    public Paint d;
    public Paint e;
    public PathMeasure f;
    public final ke1 g;
    public float h;
    public float i;
    public float j;
    public float k;
    public int l;
    public String m;
    public Boolean n;
    public final kb o;

    public ne1(ne1 ne1Var) {
        this.c = new Matrix();
        this.h = 0.0f;
        this.i = 0.0f;
        this.j = 0.0f;
        this.k = 0.0f;
        this.l = 255;
        this.m = null;
        this.n = null;
        kb kbVar = new kb(0);
        this.o = kbVar;
        this.g = new ke1(ne1Var.g, kbVar);
        this.a = new Path(ne1Var.a);
        this.b = new Path(ne1Var.b);
        this.h = ne1Var.h;
        this.i = ne1Var.i;
        this.j = ne1Var.j;
        this.k = ne1Var.k;
        this.l = ne1Var.l;
        this.m = ne1Var.m;
        String str = ne1Var.m;
        if (str != null) {
            kbVar.put(str, this);
        }
        this.n = ne1Var.n;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(ke1 ke1Var, Matrix matrix, Canvas canvas, int i, int i2) {
        int i3;
        float f;
        int i4;
        float f2;
        Matrix matrix2 = ke1Var.a;
        ArrayList arrayList = ke1Var.b;
        matrix2.set(matrix);
        Matrix matrix3 = ke1Var.a;
        matrix3.preConcat(ke1Var.j);
        canvas.save();
        char c = 0;
        int i5 = 0;
        while (i5 < arrayList.size()) {
            le1 le1Var = (le1) arrayList.get(i5);
            if (le1Var instanceof ke1) {
                a((ke1) le1Var, matrix3, canvas, i, i2);
            } else if (le1Var instanceof me1) {
                me1 me1Var = (me1) le1Var;
                float f3 = i / this.j;
                float f4 = i2 / this.k;
                float fMin = Math.min(f3, f4);
                Matrix matrix4 = this.c;
                matrix4.set(matrix3);
                matrix4.postScale(f3, f4);
                float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
                matrix3.mapVectors(fArr);
                float fHypot = (float) Math.hypot(fArr[c], fArr[1]);
                boolean z = c;
                i3 = i5;
                float fHypot2 = (float) Math.hypot(fArr[2], fArr[3]);
                float f5 = (fArr[z ? 1 : 0] * fArr[3]) - (fArr[1] * fArr[2]);
                float fMax = Math.max(fHypot, fHypot2);
                float fAbs = fMax > 0.0f ? Math.abs(f5) / fMax : 0.0f;
                if (fAbs != 0.0f) {
                    Path path = this.a;
                    path.reset();
                    lp0[] lp0VarArr = me1Var.a;
                    if (lp0VarArr != null) {
                        lp0.b(lp0VarArr, path);
                    }
                    Path path2 = this.b;
                    path2.reset();
                    if (me1Var instanceof ie1) {
                        path2.setFillType(me1Var.c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                        path2.addPath(path, matrix4);
                        canvas.clipPath(path2);
                    } else {
                        je1 je1Var = (je1) me1Var;
                        float f6 = je1Var.i;
                        if (f6 != 0.0f || je1Var.j != 1.0f) {
                            float f7 = je1Var.k;
                            float f8 = (f6 + f7) % 1.0f;
                            float f9 = (je1Var.j + f7) % 1.0f;
                            if (this.f == null) {
                                this.f = new PathMeasure();
                            }
                            this.f.setPath(path, z);
                            float length = this.f.getLength();
                            float f10 = f8 * length;
                            float f11 = f9 * length;
                            path.reset();
                            PathMeasure pathMeasure = this.f;
                            if (f10 > f11) {
                                pathMeasure.getSegment(f10, length, path, true);
                                f = 0.0f;
                                this.f.getSegment(0.0f, f11, path, true);
                            } else {
                                f = 0.0f;
                                pathMeasure.getSegment(f10, f11, path, true);
                            }
                            path.rLineTo(f, f);
                        }
                        path2.addPath(path, matrix4);
                        f9 f9Var = je1Var.f;
                        if (((Shader) f9Var.c) == null && f9Var.b == 0) {
                            f2 = 255.0f;
                            i4 = 16777215;
                        } else {
                            if (this.e == null) {
                                i4 = 16777215;
                                Paint paint = new Paint(1);
                                this.e = paint;
                                paint.setStyle(Paint.Style.FILL);
                            } else {
                                i4 = 16777215;
                            }
                            Paint paint2 = this.e;
                            Shader shader = (Shader) f9Var.c;
                            if (shader != null) {
                                shader.setLocalMatrix(matrix4);
                                paint2.setShader(shader);
                                paint2.setAlpha(Math.round(je1Var.h * 255.0f));
                                f2 = 255.0f;
                            } else {
                                paint2.setShader(null);
                                paint2.setAlpha(255);
                                int i6 = f9Var.b;
                                float f12 = je1Var.h;
                                PorterDuff.Mode mode = qe1.k;
                                f2 = 255.0f;
                                paint2.setColor((i6 & i4) | (((int) (Color.alpha(i6) * f12)) << 24));
                            }
                            paint2.setColorFilter(null);
                            path2.setFillType(je1Var.c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                            canvas.drawPath(path2, paint2);
                        }
                        f9 f9Var2 = je1Var.d;
                        if (((Shader) f9Var2.c) != null || f9Var2.b != 0) {
                            if (this.d == null) {
                                Paint paint3 = new Paint(1);
                                this.d = paint3;
                                paint3.setStyle(Paint.Style.STROKE);
                            }
                            Paint paint4 = this.d;
                            Paint.Join join = je1Var.m;
                            if (join != null) {
                                paint4.setStrokeJoin(join);
                            }
                            Paint.Cap cap = je1Var.l;
                            if (cap != null) {
                                paint4.setStrokeCap(cap);
                            }
                            paint4.setStrokeMiter(je1Var.n);
                            Shader shader2 = (Shader) f9Var2.c;
                            if (shader2 != null) {
                                shader2.setLocalMatrix(matrix4);
                                paint4.setShader(shader2);
                                paint4.setAlpha(Math.round(je1Var.g * f2));
                            } else {
                                paint4.setShader(null);
                                paint4.setAlpha(255);
                                int i7 = f9Var2.b;
                                float f13 = je1Var.g;
                                PorterDuff.Mode mode2 = qe1.k;
                                paint4.setColor((i7 & i4) | (((int) (Color.alpha(i7) * f13)) << 24));
                            }
                            paint4.setColorFilter(null);
                            paint4.setStrokeWidth(je1Var.e * fMin * fAbs);
                            canvas.drawPath(path2, paint4);
                        }
                    }
                }
                i5 = i3 + 1;
                c = 0;
            }
            i3 = i5;
            i5 = i3 + 1;
            c = 0;
        }
        canvas.restore();
    }

    public float getAlpha() {
        return getRootAlpha() / 255.0f;
    }

    public int getRootAlpha() {
        return this.l;
    }

    public void setAlpha(float f) {
        setRootAlpha((int) (f * 255.0f));
    }

    public void setRootAlpha(int i) {
        this.l = i;
    }

    public ne1() {
        this.c = new Matrix();
        this.h = 0.0f;
        this.i = 0.0f;
        this.j = 0.0f;
        this.k = 0.0f;
        this.l = 255;
        this.m = null;
        this.n = null;
        this.o = new kb(0);
        this.g = new ke1();
        this.a = new Path();
        this.b = new Path();
    }
}
