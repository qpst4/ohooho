package defpackage;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.widget.TextView;
import com.yalantis.ucrop.UCropActivity;
import com.yalantis.ucrop.view.GestureCropImageView;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class wc1 implements p81, p80 {
    public final /* synthetic */ int a;
    public final /* synthetic */ UCropActivity b;

    public /* synthetic */ wc1(UCropActivity uCropActivity, int i) {
        this.a = i;
        this.b = uCropActivity;
    }

    @Override // defpackage.p80
    public void a(float f) {
        int i = this.a;
        UCropActivity uCropActivity = this.b;
        switch (i) {
            case 1:
                GestureCropImageView gestureCropImageView = uCropActivity.M;
                float f2 = f / 42.0f;
                RectF rectF = gestureCropImageView.t;
                float fCenterX = rectF.centerX();
                float fCenterY = rectF.centerY();
                Matrix matrix = gestureCropImageView.h;
                if (f2 != 0.0f) {
                    matrix.postRotate(f2, fCenterX, fCenterY);
                    gestureCropImageView.setImageMatrix(matrix);
                    p81 p81Var = gestureCropImageView.k;
                    if (p81Var != null) {
                        float[] fArr = gestureCropImageView.g;
                        matrix.getValues(fArr);
                        double d = fArr[1];
                        matrix.getValues(fArr);
                        float f3 = (float) (-(Math.atan2(d, fArr[0]) * 57.29577951308232d));
                        TextView textView = ((wc1) p81Var).b.V;
                        if (textView != null) {
                            textView.setText(String.format(Locale.getDefault(), "%.1f°", Float.valueOf(f3)));
                        }
                    }
                }
                break;
            default:
                GestureCropImageView gestureCropImageView2 = uCropActivity.M;
                if (f <= 0.0f) {
                    float maxScale = (((uCropActivity.M.getMaxScale() - uCropActivity.M.getMinScale()) / 15000.0f) * f) + gestureCropImageView2.getCurrentScale();
                    RectF rectF2 = gestureCropImageView2.t;
                    float fCenterX2 = rectF2.centerX();
                    float fCenterY2 = rectF2.centerY();
                    if (maxScale >= gestureCropImageView2.getMinScale()) {
                        gestureCropImageView2.h(maxScale / gestureCropImageView2.getCurrentScale(), fCenterX2, fCenterY2);
                    }
                } else {
                    float maxScale2 = (((uCropActivity.M.getMaxScale() - uCropActivity.M.getMinScale()) / 15000.0f) * f) + gestureCropImageView2.getCurrentScale();
                    RectF rectF3 = gestureCropImageView2.t;
                    gestureCropImageView2.i(maxScale2, rectF3.centerX(), rectF3.centerY());
                }
                break;
        }
    }

    @Override // defpackage.p80
    public void b() {
        int i = this.a;
        UCropActivity uCropActivity = this.b;
        switch (i) {
            case 1:
                uCropActivity.M.setImageToWrapCropBounds(true);
                break;
            default:
                uCropActivity.M.setImageToWrapCropBounds(true);
                break;
        }
    }

    @Override // defpackage.p80
    public void c() {
        int i = this.a;
        UCropActivity uCropActivity = this.b;
        switch (i) {
            case 1:
                uCropActivity.M.f();
                break;
            default:
                uCropActivity.M.f();
                break;
        }
    }

    public void d(float f) {
        TextView textView = this.b.W;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf((int) (f * 100.0f))));
        }
    }
}
