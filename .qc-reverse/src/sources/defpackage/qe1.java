package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import java.io.IOException;
import java.util.ArrayDeque;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class qe1 extends he1 {
    public static final PorterDuff.Mode k = PorterDuff.Mode.SRC_IN;
    public oe1 c;
    public PorterDuffColorFilter d;
    public ColorFilter e;
    public boolean f;
    public boolean g;
    public final float[] h;
    public final Matrix i;
    public final Rect j;

    public qe1() {
        this.g = true;
        this.h = new float[9];
        this.i = new Matrix();
        this.j = new Rect();
        oe1 oe1Var = new oe1();
        oe1Var.c = null;
        oe1Var.d = k;
        oe1Var.b = new ne1();
        this.c = oe1Var;
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.b;
        if (drawable == null) {
            return false;
        }
        drawable.canApplyTheme();
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Paint paint;
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        Rect rect = this.j;
        copyBounds(rect);
        if (rect.width() <= 0 || rect.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.e;
        if (colorFilter == null) {
            colorFilter = this.d;
        }
        Matrix matrix = this.i;
        canvas.getMatrix(matrix);
        float[] fArr = this.h;
        matrix.getValues(fArr);
        float fAbs = Math.abs(fArr[0]);
        float fAbs2 = Math.abs(fArr[4]);
        float fAbs3 = Math.abs(fArr[1]);
        float fAbs4 = Math.abs(fArr[3]);
        if (fAbs3 != 0.0f || fAbs4 != 0.0f) {
            fAbs = 1.0f;
            fAbs2 = 1.0f;
        }
        int iWidth = (int) (rect.width() * fAbs);
        int iMin = Math.min(2048, iWidth);
        int iMin2 = Math.min(2048, (int) (rect.height() * fAbs2));
        if (iMin <= 0 || iMin2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(rect.left, rect.top);
        if (isAutoMirrored() && getLayoutDirection() == 1) {
            canvas.translate(rect.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        rect.offsetTo(0, 0);
        oe1 oe1Var = this.c;
        Bitmap bitmap = oe1Var.f;
        if (bitmap == null || iMin != bitmap.getWidth() || iMin2 != oe1Var.f.getHeight()) {
            oe1Var.f = Bitmap.createBitmap(iMin, iMin2, Bitmap.Config.ARGB_8888);
            oe1Var.k = true;
        }
        boolean z = this.g;
        oe1 oe1Var2 = this.c;
        if (!z) {
            oe1Var2.f.eraseColor(0);
            Canvas canvas2 = new Canvas(oe1Var2.f);
            ne1 ne1Var = oe1Var2.b;
            ne1Var.a(ne1Var.g, ne1.p, canvas2, iMin, iMin2);
        } else if (oe1Var2.k || oe1Var2.g != oe1Var2.c || oe1Var2.h != oe1Var2.d || oe1Var2.j != oe1Var2.e || oe1Var2.i != oe1Var2.b.getRootAlpha()) {
            oe1 oe1Var3 = this.c;
            oe1Var3.f.eraseColor(0);
            Canvas canvas3 = new Canvas(oe1Var3.f);
            ne1 ne1Var2 = oe1Var3.b;
            ne1Var2.a(ne1Var2.g, ne1.p, canvas3, iMin, iMin2);
            oe1 oe1Var4 = this.c;
            oe1Var4.g = oe1Var4.c;
            oe1Var4.h = oe1Var4.d;
            oe1Var4.i = oe1Var4.b.getRootAlpha();
            oe1Var4.j = oe1Var4.e;
            oe1Var4.k = false;
        }
        oe1 oe1Var5 = this.c;
        if (oe1Var5.b.getRootAlpha() >= 255 && colorFilter == null) {
            paint = null;
        } else {
            if (oe1Var5.l == null) {
                Paint paint2 = new Paint();
                oe1Var5.l = paint2;
                paint2.setFilterBitmap(true);
            }
            oe1Var5.l.setAlpha(oe1Var5.b.getRootAlpha());
            oe1Var5.l.setColorFilter(colorFilter);
            paint = oe1Var5.l;
        }
        canvas.drawBitmap(oe1Var5.f, (Rect) null, rect, paint);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.b;
        return drawable != null ? drawable.getAlpha() : this.c.b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return this.c.getChangingConfigurations() | super.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.b;
        return drawable != null ? drawable.getColorFilter() : this.e;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.b != null) {
            return new pe1(this.b.getConstantState());
        }
        this.c.a = getChangingConfigurations();
        return this.c;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.b;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.c.b.i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.b;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.c.b.h;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int i;
        char c;
        int i2;
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
            return;
        }
        oe1 oe1Var = this.c;
        oe1Var.b = new ne1();
        TypedArray typedArrayU = fp1.u(resources, theme, attributeSet, i1.c);
        oe1 oe1Var2 = this.c;
        ne1 ne1Var = oe1Var2.b;
        int i3 = !fp1.p(xmlPullParser, "tintMode") ? -1 : typedArrayU.getInt(6, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        if (i3 == 3) {
            mode = PorterDuff.Mode.SRC_OVER;
        } else if (i3 != 5) {
            if (i3 != 9) {
                switch (i3) {
                    case 14:
                        mode = PorterDuff.Mode.MULTIPLY;
                        break;
                    case 15:
                        mode = PorterDuff.Mode.SCREEN;
                        break;
                    case 16:
                        mode = PorterDuff.Mode.ADD;
                        break;
                }
            } else {
                mode = PorterDuff.Mode.SRC_ATOP;
            }
        }
        oe1Var2.d = mode;
        ColorStateList colorStateListA = null;
        int i4 = 1;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "tint") != null) {
            TypedValue typedValue = new TypedValue();
            typedArrayU.getValue(1, typedValue);
            int i5 = typedValue.type;
            if (i5 == 2) {
                throw new UnsupportedOperationException("Failed to resolve attribute at index 1: " + typedValue);
            }
            if (i5 < 28 || i5 > 31) {
                Resources resources2 = typedArrayU.getResources();
                int resourceId = typedArrayU.getResourceId(1, 0);
                ThreadLocal threadLocal = vl.a;
                try {
                    colorStateListA = vl.a(resources2, resources2.getXml(resourceId), theme);
                } catch (Exception e) {
                    Log.e("CSLCompat", "Failed to inflate ColorStateList.", e);
                }
            } else {
                colorStateListA = ColorStateList.valueOf(typedValue.data);
            }
        }
        ColorStateList colorStateList = colorStateListA;
        if (colorStateList != null) {
            oe1Var2.c = colorStateList;
        }
        boolean z = oe1Var2.e;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "autoMirrored") != null) {
            z = typedArrayU.getBoolean(5, z);
        }
        oe1Var2.e = z;
        float f = ne1Var.j;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "viewportWidth") != null) {
            f = typedArrayU.getFloat(7, f);
        }
        ne1Var.j = f;
        float f2 = ne1Var.k;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "viewportHeight") != null) {
            f2 = typedArrayU.getFloat(8, f2);
        }
        ne1Var.k = f2;
        if (ne1Var.j <= 0.0f) {
            throw new XmlPullParserException(typedArrayU.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (f2 <= 0.0f) {
            throw new XmlPullParserException(typedArrayU.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        ne1Var.h = typedArrayU.getDimension(3, ne1Var.h);
        float dimension = typedArrayU.getDimension(2, ne1Var.i);
        ne1Var.i = dimension;
        if (ne1Var.h <= 0.0f) {
            throw new XmlPullParserException(typedArrayU.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (dimension <= 0.0f) {
            throw new XmlPullParserException(typedArrayU.getPositionDescription() + "<vector> tag requires height > 0");
        }
        float alpha = ne1Var.getAlpha();
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "alpha") != null) {
            alpha = typedArrayU.getFloat(4, alpha);
        }
        ne1Var.setAlpha(alpha);
        String string = typedArrayU.getString(0);
        if (string != null) {
            ne1Var.m = string;
            ne1Var.o.put(string, ne1Var);
        }
        typedArrayU.recycle();
        oe1Var.a = getChangingConfigurations();
        oe1Var.k = true;
        oe1 oe1Var3 = this.c;
        ne1 ne1Var2 = oe1Var3.b;
        ArrayDeque arrayDeque = new ArrayDeque();
        ke1 ke1Var = ne1Var2.g;
        kb kbVar = ne1Var2.o;
        arrayDeque.push(ke1Var);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z2 = true;
        while (eventType != i4 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                ke1 ke1Var2 = (ke1) arrayDeque.peek();
                i = depth;
                if ("path".equals(name)) {
                    je1 je1Var = new je1();
                    je1Var.e = 0.0f;
                    je1Var.g = 1.0f;
                    je1Var.h = 1.0f;
                    je1Var.i = 0.0f;
                    je1Var.j = 1.0f;
                    je1Var.k = 0.0f;
                    Paint.Cap cap = Paint.Cap.BUTT;
                    je1Var.l = cap;
                    Paint.Join join = Paint.Join.MITER;
                    je1Var.m = join;
                    je1Var.n = 4.0f;
                    TypedArray typedArrayU2 = fp1.u(resources, theme, attributeSet, i1.e);
                    if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "pathData") != null) {
                        String string2 = typedArrayU2.getString(0);
                        if (string2 != null) {
                            je1Var.b = string2;
                        }
                        String string3 = typedArrayU2.getString(2);
                        if (string3 != null) {
                            je1Var.a = xr.f(string3);
                        }
                        je1Var.f = fp1.j(typedArrayU2, xmlPullParser, theme, "fillColor", 1);
                        float f3 = je1Var.h;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "fillAlpha") != null) {
                            f3 = typedArrayU2.getFloat(12, f3);
                        }
                        je1Var.h = f3;
                        int i6 = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeLineCap") != null ? typedArrayU2.getInt(8, -1) : -1;
                        je1Var.l = i6 != 0 ? i6 != 1 ? i6 != 2 ? je1Var.l : Paint.Cap.SQUARE : Paint.Cap.ROUND : cap;
                        int i7 = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeLineJoin") != null ? typedArrayU2.getInt(9, -1) : -1;
                        je1Var.m = i7 != 0 ? i7 != 1 ? i7 != 2 ? je1Var.m : Paint.Join.BEVEL : Paint.Join.ROUND : join;
                        float f4 = je1Var.n;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeMiterLimit") != null) {
                            f4 = typedArrayU2.getFloat(10, f4);
                        }
                        je1Var.n = f4;
                        je1Var.d = fp1.j(typedArrayU2, xmlPullParser, theme, "strokeColor", 3);
                        float f5 = je1Var.g;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeAlpha") != null) {
                            f5 = typedArrayU2.getFloat(11, f5);
                        }
                        je1Var.g = f5;
                        float f6 = je1Var.e;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeWidth") != null) {
                            f6 = typedArrayU2.getFloat(4, f6);
                        }
                        je1Var.e = f6;
                        float f7 = je1Var.j;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathEnd") != null) {
                            f7 = typedArrayU2.getFloat(6, f7);
                        }
                        je1Var.j = f7;
                        float f8 = je1Var.k;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathOffset") != null) {
                            f8 = typedArrayU2.getFloat(7, f8);
                        }
                        je1Var.k = f8;
                        float f9 = je1Var.i;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathStart") != null) {
                            f9 = typedArrayU2.getFloat(5, f9);
                        }
                        je1Var.i = f9;
                        int i8 = je1Var.c;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "fillType") != null) {
                            i8 = typedArrayU2.getInt(13, i8);
                        }
                        je1Var.c = i8;
                    }
                    typedArrayU2.recycle();
                    ke1Var2.b.add(je1Var);
                    if (je1Var.getPathName() != null) {
                        kbVar.put(je1Var.getPathName(), je1Var);
                    }
                    oe1Var3.a = oe1Var3.a;
                    z2 = false;
                    c = '\b';
                } else {
                    c = '\b';
                    if ("clip-path".equals(name)) {
                        ie1 ie1Var = new ie1();
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "pathData") != null) {
                            TypedArray typedArrayU3 = fp1.u(resources, theme, attributeSet, i1.f);
                            String string4 = typedArrayU3.getString(0);
                            if (string4 != null) {
                                ie1Var.b = string4;
                            }
                            String string5 = typedArrayU3.getString(1);
                            if (string5 != null) {
                                ie1Var.a = xr.f(string5);
                            }
                            ie1Var.c = !fp1.p(xmlPullParser, "fillType") ? 0 : typedArrayU3.getInt(2, 0);
                            typedArrayU3.recycle();
                        }
                        ke1Var2.b.add(ie1Var);
                        if (ie1Var.getPathName() != null) {
                            kbVar.put(ie1Var.getPathName(), ie1Var);
                        }
                        oe1Var3.a = oe1Var3.a;
                    } else if ("group".equals(name)) {
                        ke1 ke1Var3 = new ke1();
                        TypedArray typedArrayU4 = fp1.u(resources, theme, attributeSet, i1.d);
                        float f10 = ke1Var3.c;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "rotation") != null) {
                            f10 = typedArrayU4.getFloat(5, f10);
                        }
                        ke1Var3.c = f10;
                        ke1Var3.d = typedArrayU4.getFloat(1, ke1Var3.d);
                        ke1Var3.e = typedArrayU4.getFloat(2, ke1Var3.e);
                        float f11 = ke1Var3.f;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "scaleX") != null) {
                            f11 = typedArrayU4.getFloat(3, f11);
                        }
                        ke1Var3.f = f11;
                        float f12 = ke1Var3.g;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "scaleY") != null) {
                            f12 = typedArrayU4.getFloat(4, f12);
                        }
                        ke1Var3.g = f12;
                        float f13 = ke1Var3.h;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "translateX") != null) {
                            f13 = typedArrayU4.getFloat(6, f13);
                        }
                        ke1Var3.h = f13;
                        float f14 = ke1Var3.i;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "translateY") != null) {
                            f14 = typedArrayU4.getFloat(7, f14);
                        }
                        ke1Var3.i = f14;
                        String string6 = typedArrayU4.getString(0);
                        if (string6 != null) {
                            ke1Var3.k = string6;
                        }
                        ke1Var3.c();
                        typedArrayU4.recycle();
                        ke1Var2.b.add(ke1Var3);
                        arrayDeque.push(ke1Var3);
                        if (ke1Var3.getGroupName() != null) {
                            kbVar.put(ke1Var3.getGroupName(), ke1Var3);
                        }
                        oe1Var3.a = oe1Var3.a;
                    }
                }
                i2 = 1;
            } else {
                i = depth;
                c = '\b';
                i2 = 1;
                if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                    arrayDeque.pop();
                }
            }
            eventType = xmlPullParser.next();
            i4 = i2;
            depth = i;
        }
        if (z2) {
            throw new XmlPullParserException("no path defined");
        }
        this.d = a(oe1Var.c, oe1Var.d);
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.b;
        return drawable != null ? drawable.isAutoMirrored() : this.c.e;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (super.isStateful()) {
            return true;
        }
        oe1 oe1Var = this.c;
        if (oe1Var == null) {
            return false;
        }
        ne1 ne1Var = oe1Var.b;
        if (ne1Var.n == null) {
            ne1Var.n = Boolean.valueOf(ne1Var.g.a());
        }
        if (ne1Var.n.booleanValue()) {
            return true;
        }
        ColorStateList colorStateList = this.c.c;
        return colorStateList != null && colorStateList.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f && super.mutate() == this) {
            oe1 oe1Var = this.c;
            oe1 oe1Var2 = new oe1();
            oe1Var2.c = null;
            oe1Var2.d = k;
            if (oe1Var != null) {
                oe1Var2.a = oe1Var.a;
                ne1 ne1Var = new ne1(oe1Var.b);
                oe1Var2.b = ne1Var;
                if (oe1Var.b.e != null) {
                    ne1Var.e = new Paint(oe1Var.b.e);
                }
                if (oe1Var.b.d != null) {
                    oe1Var2.b.d = new Paint(oe1Var.b.d);
                }
                oe1Var2.c = oe1Var.c;
                oe1Var2.d = oe1Var.d;
                oe1Var2.e = oe1Var.e;
            }
            this.c = oe1Var2;
            this.f = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        boolean z;
        PorterDuff.Mode mode;
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        oe1 oe1Var = this.c;
        ColorStateList colorStateList = oe1Var.c;
        if (colorStateList == null || (mode = oe1Var.d) == null) {
            z = false;
        } else {
            this.d = a(colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        ne1 ne1Var = oe1Var.b;
        if (ne1Var.n == null) {
            ne1Var.n = Boolean.valueOf(ne1Var.g.a());
        }
        if (ne1Var.n.booleanValue()) {
            boolean zB = oe1Var.b.g.b(iArr);
            oe1Var.k |= zB;
            if (zB) {
                invalidateSelf();
                return true;
            }
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public final void scheduleSelf(Runnable runnable, long j) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else if (this.c.b.getRootAlpha() != i) {
            this.c.b.setRootAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setAutoMirrored(z);
        } else {
            this.c.e = z;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.e = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setTint(i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
            return;
        }
        oe1 oe1Var = this.c;
        if (oe1Var.c != colorStateList) {
            oe1Var.c = colorStateList;
            this.d = a(colorStateList, oe1Var.d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setTintMode(mode);
            return;
        }
        oe1 oe1Var = this.c;
        if (oe1Var.d != mode) {
            oe1Var.d = mode;
            this.d = a(oe1Var.c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.b;
        return drawable != null ? drawable.setVisible(z, z2) : super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    public qe1(oe1 oe1Var) {
        this.g = true;
        this.h = new float[9];
        this.i = new Matrix();
        this.j = new Rect();
        this.c = oe1Var;
        this.d = a(oe1Var.c, oe1Var.d);
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }
}
