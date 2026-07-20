package defpackage;

import android.graphics.RectF;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.canhub.cropper.CropOverlayView;
import com.yalantis.ucrop.view.GestureCropImageView;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class rq extends ScaleGestureDetector.SimpleOnScaleGestureListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ View b;

    public /* synthetic */ rq(View view, int i) {
        this.a = i;
        this.b = view;
    }

    @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        int i = this.a;
        View view = this.b;
        switch (i) {
            case 0:
                scaleGestureDetector.getClass();
                CropOverlayView cropOverlayView = (CropOverlayView) view;
                RectF rectFG = cropOverlayView.h.g();
                float focusX = scaleGestureDetector.getFocusX();
                float focusY = scaleGestureDetector.getFocusY();
                float currentSpanY = scaleGestureDetector.getCurrentSpanY() / 2.0f;
                float currentSpanX = scaleGestureDetector.getCurrentSpanX() / 2.0f;
                float f = focusY - currentSpanY;
                float f2 = focusX - currentSpanX;
                float f3 = focusX + currentSpanX;
                float f4 = focusY + currentSpanY;
                if (f2 < f3 && f <= f4 && f2 >= 0.0f && f3 <= cropOverlayView.h.c() && f >= 0.0f && f4 <= cropOverlayView.h.b()) {
                    rectFG.set(f2, f, f3, f4);
                    vq vqVar = cropOverlayView.h;
                    vqVar.getClass();
                    vqVar.a.set(rectFG);
                    cropOverlayView.invalidate();
                }
                break;
            default:
                GestureCropImageView gestureCropImageView = (GestureCropImageView) view;
                gestureCropImageView.h(scaleGestureDetector.getScaleFactor(), gestureCropImageView.I, gestureCropImageView.J);
                break;
        }
        return true;
    }
}
