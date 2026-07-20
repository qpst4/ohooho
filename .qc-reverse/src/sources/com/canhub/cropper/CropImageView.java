package com.canhub.cropper;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.Pair;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import defpackage.bq;
import defpackage.cg;
import defpackage.cq;
import defpackage.dq;
import defpackage.eq;
import defpackage.fc0;
import defpackage.fq;
import defpackage.gd0;
import defpackage.gg;
import defpackage.gq;
import defpackage.hq;
import defpackage.iq;
import defpackage.iu;
import defpackage.jl1;
import defpackage.jo;
import defpackage.jq;
import defpackage.kq;
import defpackage.lq;
import defpackage.mq;
import defpackage.qq;
import defpackage.rq;
import defpackage.vq;
import defpackage.xf;
import defpackage.zc0;
import java.lang.ref.WeakReference;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class CropImageView extends FrameLayout implements qq {
    public int A;
    public hq B;
    public kq C;
    public gq D;
    public Uri E;
    public int F;
    public float G;
    public float H;
    public float I;
    public RectF J;
    public int K;
    public boolean L;
    public WeakReference M;
    public WeakReference N;
    public Uri O;
    public final ImageView b;
    public final CropOverlayView c;
    public final Matrix d;
    public final Matrix e;
    public final ProgressBar f;
    public final float[] g;
    public final float[] h;
    public bq i;
    public Bitmap j;
    public int k;
    public int l;
    public boolean m;
    public boolean n;
    public int o;
    public int p;
    public int q;
    public mq r;
    public boolean s;
    public boolean t;
    public boolean u;
    public String v;
    public float w;
    public int x;
    public boolean y;
    public boolean z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public CropImageView(android.content.Context r53, android.util.AttributeSet r54) {
        /*
            Method dump skipped, instruction units count: 797
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.canhub.cropper.CropImageView.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public final void a(float f, float f2, boolean z, boolean z2) {
        if (this.j != null) {
            if (f <= 0.0f || f2 <= 0.0f) {
                return;
            }
            Matrix matrix = this.d;
            Matrix matrix2 = this.e;
            matrix.invert(matrix2);
            CropOverlayView cropOverlayView = this.c;
            cropOverlayView.getClass();
            RectF cropWindowRect = cropOverlayView.getCropWindowRect();
            matrix2.mapRect(cropWindowRect);
            matrix.reset();
            matrix.postTranslate((f - r0.getWidth()) / 2.0f, (f2 - r0.getHeight()) / 2.0f);
            d();
            int i = this.l;
            float[] fArr = this.g;
            if (i > 0) {
                Rect rect = gg.a;
                fArr.getClass();
                matrix.postRotate(i, (gg.n(fArr) + gg.o(fArr)) / 2.0f, (gg.p(fArr) + gg.l(fArr)) / 2.0f);
                d();
            }
            Rect rect2 = gg.a;
            fArr.getClass();
            float fMin = Math.min(f / (gg.o(fArr) - gg.n(fArr)), f2 / (gg.l(fArr) - gg.p(fArr)));
            mq mqVar = this.r;
            mq mqVar2 = mq.b;
            mq mqVar3 = mq.c;
            if (mqVar == mqVar2 || ((mqVar == mq.d && fMin < 1.0f) || (fMin > 1.0f && this.z))) {
                matrix.postScale(fMin, fMin, (gg.n(fArr) + gg.o(fArr)) / 2.0f, (gg.p(fArr) + gg.l(fArr)) / 2.0f);
                d();
            } else if (mqVar == mqVar3) {
                this.G = Math.max(getWidth() / (gg.o(fArr) - gg.n(fArr)), getHeight() / (gg.l(fArr) - gg.p(fArr)));
            }
            boolean z3 = this.m;
            float f3 = this.G;
            float f4 = z3 ? -f3 : f3;
            if (this.n) {
                f3 = -f3;
            }
            matrix.postScale(f4, f3, (gg.n(fArr) + gg.o(fArr)) / 2.0f, (gg.p(fArr) + gg.l(fArr)) / 2.0f);
            d();
            matrix.mapRect(cropWindowRect);
            if (this.r == mqVar3 && z && !z2) {
                this.H = 0.0f;
                this.I = 0.0f;
            } else if (z) {
                this.H = f > gg.o(fArr) - gg.n(fArr) ? 0.0f : Math.max(Math.min((f / 2.0f) - cropWindowRect.centerX(), -gg.n(fArr)), getWidth() - gg.o(fArr)) / f4;
                this.I = f2 <= gg.l(fArr) - gg.p(fArr) ? Math.max(Math.min((f2 / 2.0f) - cropWindowRect.centerY(), -gg.p(fArr)), getHeight() - gg.l(fArr)) / f3 : 0.0f;
            } else {
                this.H = Math.min(Math.max(this.H * f4, -cropWindowRect.left), (-cropWindowRect.right) + f) / f4;
                this.I = Math.min(Math.max(this.I * f3, -cropWindowRect.top), (-cropWindowRect.bottom) + f2) / f3;
            }
            matrix.postTranslate(this.H * f4, this.I * f3);
            cropWindowRect.offset(this.H * f4, this.I * f3);
            cropOverlayView.setCropWindowRect(cropWindowRect);
            d();
            cropOverlayView.invalidate();
            ImageView imageView = this.b;
            if (z2) {
                bq bqVar = this.i;
                bqVar.getClass();
                System.arraycopy(fArr, 0, bqVar.e, 0, 8);
                bqVar.g.set(bqVar.c.getCropWindowRect());
                matrix.getValues(bqVar.i);
                imageView.startAnimation(this.i);
            } else {
                imageView.setImageMatrix(matrix);
            }
            i(false);
        }
    }

    public final void b() {
        Bitmap bitmap = this.j;
        if (bitmap != null && (this.q > 0 || this.E != null)) {
            bitmap.getClass();
            bitmap.recycle();
        }
        this.j = null;
        this.q = 0;
        this.E = null;
        this.F = 1;
        this.l = 0;
        this.G = 1.0f;
        this.H = 0.0f;
        this.I = 0.0f;
        this.d.reset();
        this.J = null;
        this.K = 0;
        this.b.setImageBitmap(null);
        g();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(boolean r13, boolean r14) {
        /*
            Method dump skipped, instruction units count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.canhub.cropper.CropImageView.c(boolean, boolean):void");
    }

    public final void d() {
        float[] fArr = this.g;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        this.j.getClass();
        fArr[2] = r4.getWidth();
        fArr[3] = 0.0f;
        this.j.getClass();
        fArr[4] = r6.getWidth();
        this.j.getClass();
        fArr[5] = r6.getHeight();
        fArr[6] = 0.0f;
        this.j.getClass();
        fArr[7] = r9.getHeight();
        Matrix matrix = this.d;
        matrix.mapPoints(fArr);
        float[] fArr2 = this.h;
        fArr2[0] = 0.0f;
        fArr2[1] = 0.0f;
        fArr2[2] = 100.0f;
        fArr2[3] = 0.0f;
        fArr2[4] = 100.0f;
        fArr2[5] = 100.0f;
        fArr2[6] = 0.0f;
        fArr2[7] = 100.0f;
        matrix.mapPoints(fArr2);
    }

    public final void e(int i) {
        if (this.j != null) {
            int i2 = i < 0 ? (i % 360) + 360 : i % 360;
            CropOverlayView cropOverlayView = this.c;
            cropOverlayView.getClass();
            boolean z = !cropOverlayView.A && ((46 <= i2 && i2 < 135) || (216 <= i2 && i2 < 305));
            RectF rectF = gg.c;
            rectF.set(cropOverlayView.getCropWindowRect());
            float fHeight = (z ? rectF.height() : rectF.width()) / 2.0f;
            float fWidth = (z ? rectF.width() : rectF.height()) / 2.0f;
            if (z) {
                boolean z2 = this.m;
                this.m = this.n;
                this.n = z2;
            }
            Matrix matrix = this.d;
            Matrix matrix2 = this.e;
            matrix.invert(matrix2);
            float[] fArr = gg.d;
            fArr[0] = rectF.centerX();
            fArr[1] = rectF.centerY();
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 1.0f;
            fArr[5] = 0.0f;
            matrix2.mapPoints(fArr);
            this.l = (this.l + i2) % 360;
            a(getWidth(), getHeight(), true, false);
            float[] fArr2 = gg.e;
            matrix.mapPoints(fArr2, fArr);
            float fSqrt = this.G / ((float) Math.sqrt(Math.pow(fArr2[5] - fArr2[3], 2.0d) + Math.pow(fArr2[4] - fArr2[2], 2.0d)));
            this.G = fSqrt;
            this.G = Math.max(fSqrt, 1.0f);
            a(getWidth(), getHeight(), true, false);
            matrix.mapPoints(fArr2, fArr);
            float fSqrt2 = (float) Math.sqrt(Math.pow(fArr2[5] - fArr2[3], 2.0d) + Math.pow(fArr2[4] - fArr2[2], 2.0d));
            float f = fHeight * fSqrt2;
            float f2 = fWidth * fSqrt2;
            float f3 = fArr2[0];
            float f4 = fArr2[1];
            rectF.set(f3 - f, f4 - f2, f3 + f, f4 + f2);
            cropOverlayView.g();
            cropOverlayView.setCropWindowRect(rectF);
            a(getWidth(), getHeight(), true, false);
            c(false, false);
            RectF cropWindowRect = cropOverlayView.getCropWindowRect();
            cropOverlayView.e(cropWindowRect);
            vq vqVar = cropOverlayView.h;
            vqVar.getClass();
            vqVar.a.set(cropWindowRect);
        }
    }

    public final void f(Bitmap bitmap, int i, Uri uri, int i2, int i3) {
        Bitmap bitmap2 = this.j;
        if (bitmap2 == null || !fc0.b(bitmap2, bitmap)) {
            b();
            this.j = bitmap;
            this.b.setImageBitmap(bitmap);
            this.E = uri;
            this.q = i;
            this.F = i2;
            this.l = i3;
            a(getWidth(), getHeight(), true, false);
            CropOverlayView cropOverlayView = this.c;
            if (cropOverlayView != null) {
                cropOverlayView.g();
                g();
            }
        }
    }

    public final void g() {
        CropOverlayView cropOverlayView = this.c;
        if (cropOverlayView != null) {
            cropOverlayView.setVisibility((!this.t || this.j == null) ? 4 : 0);
        }
    }

    public final Pair<Integer, Integer> getAspectRatio() {
        CropOverlayView cropOverlayView = this.c;
        cropOverlayView.getClass();
        return new Pair<>(Integer.valueOf(cropOverlayView.getAspectRatioX()), Integer.valueOf(cropOverlayView.getAspectRatioY()));
    }

    public final dq getCornerShape() {
        CropOverlayView cropOverlayView = this.c;
        cropOverlayView.getClass();
        return cropOverlayView.getCornerShape();
    }

    public final String getCropLabelText() {
        return this.v;
    }

    public final int getCropLabelTextColor() {
        return this.x;
    }

    public final float getCropLabelTextSize() {
        return this.w;
    }

    public final float[] getCropPoints() {
        CropOverlayView cropOverlayView = this.c;
        cropOverlayView.getClass();
        RectF cropWindowRect = cropOverlayView.getCropWindowRect();
        float f = cropWindowRect.left;
        float f2 = cropWindowRect.top;
        float f3 = cropWindowRect.right;
        float f4 = cropWindowRect.bottom;
        float[] fArr = {f, f2, f3, f2, f3, f4, f, f4};
        Matrix matrix = this.d;
        Matrix matrix2 = this.e;
        matrix.invert(matrix2);
        matrix2.mapPoints(fArr);
        float[] fArr2 = new float[8];
        for (int i = 0; i < 8; i++) {
            fArr2[i] = fArr[i] * this.F;
        }
        return fArr2;
    }

    public final Rect getCropRect() {
        int i = this.F;
        Bitmap bitmap = this.j;
        if (bitmap == null) {
            return null;
        }
        float[] cropPoints = getCropPoints();
        int width = bitmap.getWidth() * i;
        int height = i * bitmap.getHeight();
        Rect rect = gg.a;
        CropOverlayView cropOverlayView = this.c;
        cropOverlayView.getClass();
        return gg.m(cropPoints, width, height, cropOverlayView.A, cropOverlayView.getAspectRatioX(), cropOverlayView.getAspectRatioY());
    }

    public final eq getCropShape() {
        CropOverlayView cropOverlayView = this.c;
        cropOverlayView.getClass();
        return cropOverlayView.getCropShape();
    }

    public final RectF getCropWindowRect() {
        CropOverlayView cropOverlayView = this.c;
        if (cropOverlayView != null) {
            return cropOverlayView.getCropWindowRect();
        }
        return null;
    }

    public final Bitmap getCroppedImage() {
        jl1 jl1VarE;
        Bitmap bitmap = this.j;
        if (bitmap == null) {
            return null;
        }
        Uri uri = this.E;
        CropOverlayView cropOverlayView = this.c;
        if (uri == null || this.F <= 1) {
            Rect rect = gg.a;
            float[] cropPoints = getCropPoints();
            int i = this.l;
            cropOverlayView.getClass();
            jl1VarE = gg.e(bitmap, cropPoints, i, cropOverlayView.A, cropOverlayView.getAspectRatioX(), cropOverlayView.getAspectRatioY(), this.m, this.n);
        } else {
            Rect rect2 = gg.a;
            Context context = getContext();
            context.getClass();
            Uri uri2 = this.E;
            float[] cropPoints2 = getCropPoints();
            int i2 = this.l;
            Bitmap bitmap2 = this.j;
            bitmap2.getClass();
            int width = bitmap2.getWidth() * this.F;
            Bitmap bitmap3 = this.j;
            bitmap3.getClass();
            int height = bitmap3.getHeight() * this.F;
            cropOverlayView.getClass();
            jl1VarE = gg.c(context, uri2, cropPoints2, i2, width, height, cropOverlayView.A, cropOverlayView.getAspectRatioX(), cropOverlayView.getAspectRatioY(), 0, 0, this.m, this.n);
        }
        return gg.r((Bitmap) jl1VarE.c, 0, 0, lq.d);
    }

    public final Uri getCustomOutputUri() {
        return this.O;
    }

    public final fq getGuidelines() {
        CropOverlayView cropOverlayView = this.c;
        cropOverlayView.getClass();
        return cropOverlayView.getGuidelines();
    }

    public final int getImageResource() {
        return this.q;
    }

    public final Uri getImageUri() {
        return this.E;
    }

    public final int getMaxZoom() {
        return this.A;
    }

    public final int getRotatedDegrees() {
        return this.l;
    }

    public final mq getScaleType() {
        return this.r;
    }

    public final Rect getWholeImageRect() {
        int i = this.F;
        Bitmap bitmap = this.j;
        if (bitmap == null) {
            return null;
        }
        return new Rect(0, 0, bitmap.getWidth() * i, bitmap.getHeight() * i);
    }

    public final void h() {
        this.f.setVisibility(this.y && ((this.j == null && this.M != null) || this.N != null) ? 0 : 4);
    }

    public final void i(boolean z) {
        Bitmap bitmap = this.j;
        CropOverlayView cropOverlayView = this.c;
        if (bitmap != null && !z) {
            Rect rect = gg.a;
            float[] fArr = this.h;
            fArr.getClass();
            float fO = (this.F * 100.0f) / (gg.o(fArr) - gg.n(fArr));
            float fL = (this.F * 100.0f) / (gg.l(fArr) - gg.p(fArr));
            cropOverlayView.getClass();
            float width = getWidth();
            float height = getHeight();
            vq vqVar = cropOverlayView.h;
            vqVar.e = width;
            vqVar.f = height;
            vqVar.k = fO;
            vqVar.l = fL;
        }
        cropOverlayView.getClass();
        cropOverlayView.h(z ? null : this.g, getWidth(), getHeight());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.o <= 0 || this.p <= 0) {
            i(true);
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = this.o;
        layoutParams.height = this.p;
        setLayoutParams(layoutParams);
        if (this.j == null) {
            i(true);
            return;
        }
        float f = i3 - i;
        float f2 = i4 - i2;
        a(f, f2, true, false);
        RectF rectF = this.J;
        if (rectF == null) {
            if (this.L) {
                this.L = false;
                c(false, false);
                return;
            }
            return;
        }
        int i5 = this.K;
        if (i5 != this.k) {
            this.l = i5;
            a(f, f2, true, false);
            this.K = 0;
        }
        this.d.mapRect(this.J);
        CropOverlayView cropOverlayView = this.c;
        if (cropOverlayView != null) {
            cropOverlayView.setCropWindowRect(rectF);
        }
        c(false, false);
        if (cropOverlayView != null) {
            RectF cropWindowRect = cropOverlayView.getCropWindowRect();
            cropOverlayView.e(cropWindowRect);
            vq vqVar = cropOverlayView.h;
            vqVar.getClass();
            vqVar.a.set(cropWindowRect);
        }
        this.J = null;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int width;
        int height;
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        Bitmap bitmap = this.j;
        if (bitmap == null) {
            setMeasuredDimension(size, size2);
            return;
        }
        if (size2 == 0) {
            size2 = bitmap.getHeight();
        }
        double width2 = size < bitmap.getWidth() ? ((double) size) / ((double) bitmap.getWidth()) : Double.POSITIVE_INFINITY;
        double height2 = size2 < bitmap.getHeight() ? ((double) size2) / ((double) bitmap.getHeight()) : Double.POSITIVE_INFINITY;
        if (width2 == Double.POSITIVE_INFINITY && height2 == Double.POSITIVE_INFINITY) {
            width = bitmap.getWidth();
            height = bitmap.getHeight();
        } else if (width2 <= height2) {
            height = (int) (((double) bitmap.getHeight()) * width2);
            width = size;
        } else {
            width = (int) (((double) bitmap.getWidth()) * height2);
            height = size2;
        }
        if (mode == Integer.MIN_VALUE) {
            size = Math.min(width, size);
        } else if (mode != 1073741824) {
            size = width;
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(height, size2);
        } else if (mode2 != 1073741824) {
            size2 = height;
        }
        this.o = size;
        this.p = size2;
        setMeasuredDimension(size, size2);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0067  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onRestoreInstanceState(android.os.Parcelable r10) {
        /*
            Method dump skipped, instruction units count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.canhub.cropper.CropImageView.onRestoreInstanceState(android.os.Parcelable):void");
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Uri uriS;
        if (this.E == null && this.j == null && this.q < 1) {
            return super.onSaveInstanceState();
        }
        Bundle bundle = new Bundle();
        if (this.s && this.E == null && this.q < 1) {
            Rect rect = gg.a;
            Context context = getContext();
            context.getClass();
            Bitmap bitmap = this.j;
            Uri uri = this.O;
            try {
                bitmap.getClass();
                uriS = gg.s(context, bitmap, Bitmap.CompressFormat.JPEG, 95, uri);
            } catch (Exception e) {
                Log.w("AIC", "Failed to write bitmap to temp file for image-cropper save instance state", e);
                uriS = null;
            }
        } else {
            uriS = this.E;
        }
        if (uriS != null && this.j != null) {
            String string = UUID.randomUUID().toString();
            string.getClass();
            Rect rect2 = gg.a;
            gg.g = new Pair(string, new WeakReference(this.j));
            bundle.putString("LOADED_IMAGE_STATE_BITMAP_KEY", string);
        }
        WeakReference weakReference = this.M;
        cg cgVar = weakReference != null ? (cg) weakReference.get() : null;
        if (cgVar != null) {
            bundle.putParcelable("LOADING_IMAGE_URI", cgVar.c);
        }
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putParcelable("LOADED_IMAGE_URI", uriS);
        bundle.putInt("LOADED_IMAGE_RESOURCE", this.q);
        bundle.putInt("LOADED_SAMPLE_SIZE", this.F);
        bundle.putInt("DEGREES_ROTATED", this.l);
        CropOverlayView cropOverlayView = this.c;
        cropOverlayView.getClass();
        bundle.putParcelable("INITIAL_CROP_RECT", cropOverlayView.getInitialCropWindowRect());
        RectF rectF = gg.c;
        rectF.set(cropOverlayView.getCropWindowRect());
        Matrix matrix = this.d;
        Matrix matrix2 = this.e;
        matrix.invert(matrix2);
        matrix2.mapRect(rectF);
        bundle.putParcelable("CROP_WINDOW_RECT", rectF);
        eq cropShape = cropOverlayView.getCropShape();
        cropShape.getClass();
        bundle.putString("CROP_SHAPE", cropShape.name());
        bundle.putBoolean("CROP_AUTO_ZOOM_ENABLED", this.z);
        bundle.putInt("CROP_MAX_ZOOM", this.A);
        bundle.putBoolean("CROP_FLIP_HORIZONTALLY", this.m);
        bundle.putBoolean("CROP_FLIP_VERTICALLY", this.n);
        bundle.putBoolean("SHOW_CROP_LABEL", this.u);
        return bundle;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.L = i3 > 0 && i4 > 0;
    }

    public final void setAutoZoomEnabled(boolean z) {
        if (this.z != z) {
            this.z = z;
            c(false, false);
            CropOverlayView cropOverlayView = this.c;
            cropOverlayView.getClass();
            cropOverlayView.invalidate();
        }
    }

    public final void setCenterMoveEnabled(boolean z) {
        CropOverlayView cropOverlayView = this.c;
        cropOverlayView.getClass();
        if (cropOverlayView.g != z) {
            cropOverlayView.g = z;
            c(false, false);
            cropOverlayView.invalidate();
        }
    }

    public final void setCornerShape(dq dqVar) {
        CropOverlayView cropOverlayView = this.c;
        cropOverlayView.getClass();
        dqVar.getClass();
        cropOverlayView.setCropCornerShape(dqVar);
    }

    public final void setCropLabelText(String str) {
        str.getClass();
        this.v = str;
        CropOverlayView cropOverlayView = this.c;
        if (cropOverlayView != null) {
            cropOverlayView.setCropLabelText(str);
        }
    }

    public final void setCropLabelTextColor(int i) {
        this.x = i;
        CropOverlayView cropOverlayView = this.c;
        if (cropOverlayView != null) {
            cropOverlayView.setCropLabelTextColor(i);
        }
    }

    public final void setCropLabelTextSize(float f) {
        this.w = getCropLabelTextSize();
        CropOverlayView cropOverlayView = this.c;
        if (cropOverlayView != null) {
            cropOverlayView.setCropLabelTextSize(f);
        }
    }

    public final void setCropRect(Rect rect) {
        CropOverlayView cropOverlayView = this.c;
        cropOverlayView.getClass();
        cropOverlayView.setInitialCropWindowRect(rect);
    }

    public final void setCropShape(eq eqVar) {
        CropOverlayView cropOverlayView = this.c;
        cropOverlayView.getClass();
        eqVar.getClass();
        cropOverlayView.setCropShape(eqVar);
    }

    public final void setCustomOutputUri(Uri uri) {
        this.O = uri;
    }

    public final void setFixedAspectRatio(boolean z) {
        CropOverlayView cropOverlayView = this.c;
        cropOverlayView.getClass();
        cropOverlayView.setFixedAspectRatio(z);
    }

    public final void setFlippedHorizontally(boolean z) {
        if (this.m != z) {
            this.m = z;
            a(getWidth(), getHeight(), true, false);
        }
    }

    public final void setFlippedVertically(boolean z) {
        if (this.n != z) {
            this.n = z;
            a(getWidth(), getHeight(), true, false);
        }
    }

    public final void setGuidelines(fq fqVar) {
        CropOverlayView cropOverlayView = this.c;
        cropOverlayView.getClass();
        fqVar.getClass();
        cropOverlayView.setGuidelines(fqVar);
    }

    public final void setImageBitmap(Bitmap bitmap) {
        CropOverlayView cropOverlayView = this.c;
        cropOverlayView.getClass();
        cropOverlayView.setInitialCropWindowRect(null);
        f(bitmap, 0, null, 1, 0);
    }

    public final void setImageCropOptions(cq cqVar) {
        cqVar.getClass();
        boolean z = cqVar.o;
        boolean z2 = cqVar.m;
        boolean z3 = cqVar.k;
        setScaleType(cqVar.j);
        this.O = cqVar.Q;
        CropOverlayView cropOverlayView = this.c;
        if (cropOverlayView != null) {
            cropOverlayView.setInitialAttributeValues(cqVar);
        }
        setMultiTouchEnabled(cqVar.p);
        setCenterMoveEnabled(cqVar.q);
        setShowCropOverlay(z3);
        setShowProgressBar(z2);
        setAutoZoomEnabled(z);
        setMaxZoom(cqVar.s);
        setFlippedHorizontally(cqVar.d0);
        setFlippedVertically(cqVar.e0);
        this.z = z;
        this.t = z3;
        this.y = z2;
        this.f.setIndeterminateTintList(ColorStateList.valueOf(cqVar.n));
    }

    public final void setImageResource(int i) {
        if (i != 0) {
            CropOverlayView cropOverlayView = this.c;
            cropOverlayView.getClass();
            cropOverlayView.setInitialCropWindowRect(null);
            f(BitmapFactory.decodeResource(getResources(), i), i, null, 1, 0);
        }
    }

    public final void setImageUriAsync(Uri uri) {
        cg cgVar;
        if (uri != null) {
            WeakReference weakReference = this.M;
            jo joVar = null;
            if (weakReference != null && (cgVar = (cg) weakReference.get()) != null) {
                gd0 gd0Var = cgVar.g;
                gd0Var.k(new zc0(gd0Var.n(), null, gd0Var));
            }
            b();
            CropOverlayView cropOverlayView = this.c;
            cropOverlayView.getClass();
            cropOverlayView.setInitialCropWindowRect(null);
            Context context = getContext();
            context.getClass();
            WeakReference weakReference2 = new WeakReference(new cg(context, this, uri));
            this.M = weakReference2;
            cg cgVar2 = (cg) weakReference2.get();
            if (cgVar2 != null) {
                cgVar2.g = fc0.z(cgVar2, iu.a, new xf(cgVar2, joVar, 1));
            }
            h();
        }
    }

    public final void setMaxZoom(int i) {
        if (this.A == i || i <= 0) {
            return;
        }
        this.A = i;
        c(false, false);
        CropOverlayView cropOverlayView = this.c;
        cropOverlayView.getClass();
        cropOverlayView.invalidate();
    }

    public final void setMultiTouchEnabled(boolean z) {
        CropOverlayView cropOverlayView = this.c;
        cropOverlayView.getClass();
        if (cropOverlayView.f != z) {
            cropOverlayView.f = z;
            if (z && cropOverlayView.e == null) {
                cropOverlayView.e = new ScaleGestureDetector(cropOverlayView.getContext(), new rq(cropOverlayView, 0));
            }
            c(false, false);
            cropOverlayView.invalidate();
        }
    }

    public final void setOnCropImageCompleteListener(gq gqVar) {
        this.D = gqVar;
    }

    public final void setOnSetCropOverlayMovedListener(hq hqVar) {
        this.B = hqVar;
    }

    public final void setOnSetImageUriCompleteListener(kq kqVar) {
        this.C = kqVar;
    }

    public final void setRotatedDegrees(int i) {
        int i2 = this.l;
        if (i2 != i) {
            e(i - i2);
        }
    }

    public final void setSaveBitmapToInstanceState(boolean z) {
        this.s = z;
    }

    public final void setScaleType(mq mqVar) {
        mqVar.getClass();
        if (mqVar != this.r) {
            this.r = mqVar;
            this.G = 1.0f;
            this.I = 0.0f;
            this.H = 0.0f;
            CropOverlayView cropOverlayView = this.c;
            if (cropOverlayView != null) {
                cropOverlayView.g();
            }
            requestLayout();
        }
    }

    public final void setShowCropLabel(boolean z) {
        if (this.u != z) {
            this.u = z;
            CropOverlayView cropOverlayView = this.c;
            if (cropOverlayView != null) {
                cropOverlayView.setCropperTextLabelVisibility(z);
            }
        }
    }

    public final void setShowCropOverlay(boolean z) {
        if (this.t != z) {
            this.t = z;
            g();
        }
    }

    public final void setShowProgressBar(boolean z) {
        if (this.y != z) {
            this.y = z;
            h();
        }
    }

    public final void setSnapRadius(float f) {
        if (f >= 0.0f) {
            CropOverlayView cropOverlayView = this.c;
            cropOverlayView.getClass();
            cropOverlayView.setSnapRadius(f);
        }
    }

    public final void setOnCropWindowChangedListener(jq jqVar) {
    }

    public final void setOnSetCropOverlayReleasedListener(iq iqVar) {
    }
}
