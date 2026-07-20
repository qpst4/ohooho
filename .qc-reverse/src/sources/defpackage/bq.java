package defpackage;

import android.graphics.RectF;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import com.canhub.cropper.CropOverlayView;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class bq extends Animation implements Animation.AnimationListener {
    public final ImageView b;
    public final CropOverlayView c;
    public final float[] d;
    public final float[] e;
    public final RectF f;
    public final RectF g;
    public final float[] h;
    public final float[] i;

    public bq(ImageView imageView, CropOverlayView cropOverlayView) {
        imageView.getClass();
        cropOverlayView.getClass();
        this.b = imageView;
        this.c = cropOverlayView;
        this.d = new float[8];
        this.e = new float[8];
        this.f = new RectF();
        this.g = new RectF();
        this.h = new float[9];
        this.i = new float[9];
        setDuration(300L);
        setFillAfter(true);
        setInterpolator(new AccelerateDecelerateInterpolator());
        setAnimationListener(this);
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float f, Transformation transformation) {
        transformation.getClass();
        RectF rectF = new RectF();
        RectF rectF2 = this.f;
        float f2 = rectF2.left;
        RectF rectF3 = this.g;
        rectF.left = ((rectF3.left - f2) * f) + f2;
        float f3 = rectF2.top;
        rectF.top = ((rectF3.top - f3) * f) + f3;
        float f4 = rectF2.right;
        rectF.right = ((rectF3.right - f4) * f) + f4;
        float f5 = rectF2.bottom;
        rectF.bottom = ((rectF3.bottom - f5) * f) + f5;
        float[] fArr = new float[8];
        for (int i = 0; i < 8; i++) {
            float f6 = this.d[i];
            fArr[i] = ((this.e[i] - f6) * f) + f6;
        }
        CropOverlayView cropOverlayView = this.c;
        cropOverlayView.setCropWindowRect(rectF);
        ImageView imageView = this.b;
        cropOverlayView.h(fArr, imageView.getWidth(), imageView.getHeight());
        cropOverlayView.invalidate();
        float[] fArr2 = new float[9];
        for (int i2 = 0; i2 < 9; i2++) {
            float f7 = this.h[i2];
            fArr2[i2] = ((this.i[i2] - f7) * f) + f7;
        }
        imageView.getImageMatrix().setValues(fArr2);
        imageView.invalidate();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        animation.getClass();
        this.b.clearAnimation();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
        animation.getClass();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        animation.getClass();
    }
}
