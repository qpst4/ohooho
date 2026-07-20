package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import java.util.BitSet;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ik0 extends Drawable implements xz0 {
    public static final Paint x;
    public hk0 b;
    public final vz0[] c;
    public final vz0[] d;
    public final BitSet e;
    public boolean f;
    public final Matrix g;
    public final Path h;
    public final Path i;
    public final RectF j;
    public final RectF k;
    public final Region l;
    public final Region m;
    public mz0 n;
    public final Paint o;
    public final Paint p;
    public final kz0 q;
    public final tb0 r;
    public final oz0 s;
    public PorterDuffColorFilter t;
    public PorterDuffColorFilter u;
    public final RectF v;
    public final boolean w;

    static {
        Paint paint = new Paint(1);
        x = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public ik0(hk0 hk0Var) {
        this.c = new vz0[4];
        this.d = new vz0[4];
        int i = 8;
        this.e = new BitSet(8);
        this.g = new Matrix();
        this.h = new Path();
        this.i = new Path();
        this.j = new RectF();
        this.k = new RectF();
        this.l = new Region();
        this.m = new Region();
        Paint paint = new Paint(1);
        this.o = paint;
        Paint paint2 = new Paint(1);
        this.p = paint2;
        this.q = new kz0();
        this.s = Looper.getMainLooper().getThread() == Thread.currentThread() ? nz0.a : new oz0();
        this.v = new RectF();
        this.w = true;
        this.b = hk0Var;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        m();
        l(getState());
        this.r = new tb0(i, this);
    }

    public final void b(RectF rectF, Path path) {
        hk0 hk0Var = this.b;
        this.s.a(hk0Var.a, hk0Var.i, rectF, this.r, path);
        if (this.b.h != 1.0f) {
            Matrix matrix = this.g;
            matrix.reset();
            float f = this.b.h;
            matrix.setScale(f, f, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(matrix);
        }
        path.computeBounds(this.v, true);
    }

    public final int c(int i) {
        int i2;
        hk0 hk0Var = this.b;
        float f = hk0Var.m + 0.0f + hk0Var.l;
        nx nxVar = hk0Var.b;
        if (nxVar == null || !nxVar.a || wl.f(i, 255) != nxVar.d) {
            return i;
        }
        float fMin = (nxVar.e <= 0.0f || f <= 0.0f) ? 0.0f : Math.min(((((float) Math.log1p(f / r3)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        int iAlpha = Color.alpha(i);
        int iZ = xr.z(fMin, wl.f(i, 255), nxVar.b);
        if (fMin > 0.0f && (i2 = nxVar.c) != 0) {
            iZ = wl.d(wl.f(i2, nx.f), iZ);
        }
        return wl.f(iZ, iAlpha);
    }

    public final void d(Canvas canvas) {
        if (this.e.cardinality() > 0) {
            Log.w("ik0", "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        int i = this.b.o;
        Path path = this.h;
        kz0 kz0Var = this.q;
        if (i != 0) {
            canvas.drawPath(path, kz0Var.a);
        }
        for (int i2 = 0; i2 < 4; i2++) {
            vz0 vz0Var = this.c[i2];
            int i3 = this.b.n;
            Matrix matrix = vz0.b;
            vz0Var.a(matrix, kz0Var, i3, canvas);
            this.d[i2].a(matrix, kz0Var, this.b.n, canvas);
        }
        if (this.w) {
            int iSin = (int) (Math.sin(Math.toRadians(0.0d)) * ((double) this.b.o));
            int iCos = (int) (Math.cos(Math.toRadians(0.0d)) * ((double) this.b.o));
            canvas.translate(-iSin, -iCos);
            canvas.drawPath(path, x);
            canvas.translate(iSin, iCos);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        PorterDuffColorFilter porterDuffColorFilter = this.t;
        Paint paint = this.o;
        paint.setColorFilter(porterDuffColorFilter);
        int alpha = paint.getAlpha();
        int i = this.b.k;
        paint.setAlpha(((i + (i >>> 7)) * alpha) >>> 8);
        PorterDuffColorFilter porterDuffColorFilter2 = this.u;
        Paint paint2 = this.p;
        paint2.setColorFilter(porterDuffColorFilter2);
        paint2.setStrokeWidth(this.b.j);
        int alpha2 = paint2.getAlpha();
        int i2 = this.b.k;
        paint2.setAlpha(((i2 + (i2 >>> 7)) * alpha2) >>> 8);
        boolean z = this.f;
        Path path = this.h;
        if (z) {
            float f = -(h() ? paint2.getStrokeWidth() / 2.0f : 0.0f);
            mz0 mz0Var = this.b.a;
            lz0 lz0VarF = mz0Var.f();
            bp o4Var = mz0Var.e;
            if (!(o4Var instanceof hv0)) {
                o4Var = new o4(f, o4Var);
            }
            lz0VarF.e = o4Var;
            bp o4Var2 = mz0Var.f;
            if (!(o4Var2 instanceof hv0)) {
                o4Var2 = new o4(f, o4Var2);
            }
            lz0VarF.f = o4Var2;
            bp o4Var3 = mz0Var.h;
            if (!(o4Var3 instanceof hv0)) {
                o4Var3 = new o4(f, o4Var3);
            }
            lz0VarF.h = o4Var3;
            bp o4Var4 = mz0Var.g;
            if (!(o4Var4 instanceof hv0)) {
                o4Var4 = new o4(f, o4Var4);
            }
            lz0VarF.g = o4Var4;
            mz0 mz0VarA = lz0VarF.a();
            this.n = mz0VarA;
            float f2 = this.b.i;
            RectF rectFG = g();
            RectF rectF = this.k;
            rectF.set(rectFG);
            float strokeWidth = h() ? paint2.getStrokeWidth() / 2.0f : 0.0f;
            rectF.inset(strokeWidth, strokeWidth);
            this.s.a(mz0VarA, f2, rectF, null, this.i);
            b(g(), path);
            this.f = false;
        }
        hk0 hk0Var = this.b;
        hk0Var.getClass();
        if (hk0Var.n > 0 && !this.b.a.e(g()) && !path.isConvex() && Build.VERSION.SDK_INT < 29) {
            canvas.save();
            canvas.translate((int) (Math.sin(Math.toRadians(0.0d)) * ((double) this.b.o)), (int) (Math.cos(Math.toRadians(0.0d)) * ((double) this.b.o)));
            if (this.w) {
                RectF rectF2 = this.v;
                int iWidth = (int) (rectF2.width() - getBounds().width());
                int iHeight = (int) (rectF2.height() - getBounds().height());
                if (iWidth < 0 || iHeight < 0) {
                    s1.f("Invalid shadow bounds. Check that the treatments result in a valid path.");
                    return;
                }
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap((this.b.n * 2) + ((int) rectF2.width()) + iWidth, (this.b.n * 2) + ((int) rectF2.height()) + iHeight, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap);
                float f3 = (getBounds().left - this.b.n) - iWidth;
                float f4 = (getBounds().top - this.b.n) - iHeight;
                canvas2.translate(-f3, -f4);
                d(canvas2);
                canvas.drawBitmap(bitmapCreateBitmap, f3, f4, (Paint) null);
                bitmapCreateBitmap.recycle();
                canvas.restore();
            } else {
                d(canvas);
                canvas.restore();
            }
        }
        hk0 hk0Var2 = this.b;
        Paint.Style style = hk0Var2.p;
        if (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL) {
            e(canvas, paint, path, hk0Var2.a, g());
        }
        if (h()) {
            f(canvas);
        }
        paint.setAlpha(alpha);
        paint2.setAlpha(alpha2);
    }

    public final void e(Canvas canvas, Paint paint, Path path, mz0 mz0Var, RectF rectF) {
        if (!mz0Var.e(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float fA = mz0Var.f.a(rectF) * this.b.i;
            canvas.drawRoundRect(rectF, fA, fA, paint);
        }
    }

    public void f(Canvas canvas) {
        mz0 mz0Var = this.n;
        RectF rectFG = g();
        RectF rectF = this.k;
        rectF.set(rectFG);
        boolean zH = h();
        Paint paint = this.p;
        float strokeWidth = zH ? paint.getStrokeWidth() / 2.0f : 0.0f;
        rectF.inset(strokeWidth, strokeWidth);
        e(canvas, paint, this.i, mz0Var, rectF);
    }

    public final RectF g() {
        Rect bounds = getBounds();
        RectF rectF = this.j;
        rectF.set(bounds);
        return rectF;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.b.k;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.b.getClass();
        if (this.b.a.e(g())) {
            outline.setRoundRect(getBounds(), this.b.a.e.a(g()) * this.b.i);
        } else {
            RectF rectFG = g();
            Path path = this.h;
            b(rectFG, path);
            lc1.j0(outline, path);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        Rect rect2 = this.b.g;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        Rect bounds = getBounds();
        Region region = this.l;
        region.set(bounds);
        RectF rectFG = g();
        Path path = this.h;
        b(rectFG, path);
        Region region2 = this.m;
        region2.setPath(path, region);
        region.op(region2, Region.Op.DIFFERENCE);
        return region;
    }

    public final boolean h() {
        Paint.Style style = this.b.p;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.p.getStrokeWidth() > 0.0f;
    }

    public final void i(Context context) {
        this.b.b = new nx(context);
        n();
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        this.f = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (super.isStateful()) {
            return true;
        }
        ColorStateList colorStateList = this.b.e;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        this.b.getClass();
        ColorStateList colorStateList2 = this.b.d;
        if (colorStateList2 != null && colorStateList2.isStateful()) {
            return true;
        }
        ColorStateList colorStateList3 = this.b.c;
        return colorStateList3 != null && colorStateList3.isStateful();
    }

    public final void j(float f) {
        hk0 hk0Var = this.b;
        if (hk0Var.m != f) {
            hk0Var.m = f;
            n();
        }
    }

    public final void k(ColorStateList colorStateList) {
        hk0 hk0Var = this.b;
        if (hk0Var.c != colorStateList) {
            hk0Var.c = colorStateList;
            onStateChange(getState());
        }
    }

    public final boolean l(int[] iArr) {
        boolean z;
        Paint paint;
        int color;
        int colorForState;
        Paint paint2;
        int color2;
        int colorForState2;
        if (this.b.c == null || color2 == (colorForState2 = this.b.c.getColorForState(iArr, (color2 = (paint2 = this.o).getColor())))) {
            z = false;
        } else {
            paint2.setColor(colorForState2);
            z = true;
        }
        if (this.b.d == null || color == (colorForState = this.b.d.getColorForState(iArr, (color = (paint = this.p).getColor())))) {
            return z;
        }
        paint.setColor(colorForState);
        return true;
    }

    public final boolean m() {
        PorterDuffColorFilter porterDuffColorFilter;
        PorterDuffColorFilter porterDuffColorFilter2 = this.t;
        PorterDuffColorFilter porterDuffColorFilter3 = this.u;
        hk0 hk0Var = this.b;
        ColorStateList colorStateList = hk0Var.e;
        PorterDuff.Mode mode = hk0Var.f;
        if (colorStateList == null || mode == null) {
            int color = this.o.getColor();
            int iC = c(color);
            porterDuffColorFilter = iC != color ? new PorterDuffColorFilter(iC, PorterDuff.Mode.SRC_IN) : null;
        } else {
            porterDuffColorFilter = new PorterDuffColorFilter(c(colorStateList.getColorForState(getState(), 0)), mode);
        }
        this.t = porterDuffColorFilter;
        this.b.getClass();
        this.u = null;
        this.b.getClass();
        return (Objects.equals(porterDuffColorFilter2, this.t) && Objects.equals(porterDuffColorFilter3, this.u)) ? false : true;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.b = new hk0(this.b);
        return this;
    }

    public final void n() {
        hk0 hk0Var = this.b;
        float f = hk0Var.m + 0.0f;
        hk0Var.n = (int) Math.ceil(0.75f * f);
        this.b.o = (int) Math.ceil(f * 0.25f);
        m();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.f = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable, defpackage.z41
    public boolean onStateChange(int[] iArr) {
        boolean z = l(iArr) || m();
        if (z) {
            invalidateSelf();
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        hk0 hk0Var = this.b;
        if (hk0Var.k != i) {
            hk0Var.k = i;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.b.getClass();
        super.invalidateSelf();
    }

    @Override // defpackage.xz0
    public final void setShapeAppearanceModel(mz0 mz0Var) {
        this.b.a = mz0Var;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.b.e = colorStateList;
        m();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        hk0 hk0Var = this.b;
        if (hk0Var.f != mode) {
            hk0Var.f = mode;
            m();
            super.invalidateSelf();
        }
    }

    public ik0(Context context, AttributeSet attributeSet, int i, int i2) {
        this(mz0.b(context, attributeSet, i, i2).a());
    }

    public ik0(mz0 mz0Var) {
        this(new hk0(mz0Var));
    }

    public ik0() {
        this(new mz0());
    }
}
