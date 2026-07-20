package defpackage;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.yalantis.ucrop.UCropActivity;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.widget.AspectRatioTextView;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class xc1 implements View.OnClickListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ UCropActivity c;

    public /* synthetic */ xc1(UCropActivity uCropActivity, int i) {
        this.b = i;
        this.c = uCropActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.b;
        UCropActivity uCropActivity = this.c;
        switch (i) {
            case 0:
                GestureCropImageView gestureCropImageView = uCropActivity.M;
                AspectRatioTextView aspectRatioTextView = (AspectRatioTextView) ((ViewGroup) view).getChildAt(0);
                if (view.isSelected()) {
                    if (aspectRatioTextView.l != 0.0f) {
                        float f = aspectRatioTextView.n;
                        float f2 = aspectRatioTextView.o;
                        aspectRatioTextView.n = f2;
                        aspectRatioTextView.o = f;
                        aspectRatioTextView.l = f2 / f;
                    }
                    aspectRatioTextView.h();
                }
                gestureCropImageView.setTargetAspectRatio(aspectRatioTextView.l);
                uCropActivity.M.setImageToWrapCropBounds(true);
                if (!view.isSelected()) {
                    ArrayList arrayList = uCropActivity.U;
                    int size = arrayList.size();
                    int i2 = 0;
                    while (i2 < size) {
                        Object obj = arrayList.get(i2);
                        i2++;
                        ViewGroup viewGroup = (ViewGroup) obj;
                        viewGroup.setSelected(viewGroup == view);
                    }
                }
                break;
            case 1:
                GestureCropImageView gestureCropImageView2 = uCropActivity.M;
                float f3 = -gestureCropImageView2.getCurrentAngle();
                RectF rectF = gestureCropImageView2.t;
                float fCenterX = rectF.centerX();
                float fCenterY = rectF.centerY();
                Matrix matrix = gestureCropImageView2.h;
                if (f3 != 0.0f) {
                    matrix.postRotate(f3, fCenterX, fCenterY);
                    gestureCropImageView2.setImageMatrix(matrix);
                    p81 p81Var = gestureCropImageView2.k;
                    if (p81Var != null) {
                        float[] fArr = gestureCropImageView2.g;
                        matrix.getValues(fArr);
                        double d = fArr[1];
                        matrix.getValues(fArr);
                        float f4 = (float) (-(Math.atan2(d, fArr[0]) * 57.29577951308232d));
                        TextView textView = ((wc1) p81Var).b.V;
                        if (textView != null) {
                            textView.setText(String.format(Locale.getDefault(), "%.1f°", Float.valueOf(f4)));
                        }
                    }
                }
                uCropActivity.M.setImageToWrapCropBounds(true);
                break;
            case 2:
                GestureCropImageView gestureCropImageView3 = uCropActivity.M;
                RectF rectF2 = gestureCropImageView3.t;
                float fCenterX2 = rectF2.centerX();
                float fCenterY2 = rectF2.centerY();
                Matrix matrix2 = gestureCropImageView3.h;
                matrix2.postRotate(90.0f, fCenterX2, fCenterY2);
                gestureCropImageView3.setImageMatrix(matrix2);
                p81 p81Var2 = gestureCropImageView3.k;
                if (p81Var2 != null) {
                    float[] fArr2 = gestureCropImageView3.g;
                    matrix2.getValues(fArr2);
                    double d2 = fArr2[1];
                    matrix2.getValues(fArr2);
                    float f5 = (float) (-(Math.atan2(d2, fArr2[0]) * 57.29577951308232d));
                    TextView textView2 = ((wc1) p81Var2).b.V;
                    if (textView2 != null) {
                        textView2.setText(String.format(Locale.getDefault(), "%.1f°", Float.valueOf(f5)));
                    }
                }
                uCropActivity.M.setImageToWrapCropBounds(true);
                break;
            default:
                if (!view.isSelected()) {
                    int id = view.getId();
                    Bitmap.CompressFormat compressFormat = UCropActivity.e0;
                    uCropActivity.G(id);
                }
                break;
        }
    }
}
