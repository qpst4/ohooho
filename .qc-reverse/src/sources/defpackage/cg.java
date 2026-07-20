package defpackage;

import android.content.Context;
import android.net.Uri;
import android.util.DisplayMetrics;
import com.canhub.cropper.CropImageView;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class cg implements mp {
    public final Context b;
    public final Uri c;
    public final int d;
    public final int e;
    public final WeakReference f;
    public gd0 g = new bd0();

    public cg(Context context, CropImageView cropImageView, Uri uri) {
        this.b = context;
        this.c = uri;
        this.f = new WeakReference(cropImageView);
        DisplayMetrics displayMetrics = cropImageView.getResources().getDisplayMetrics();
        float f = displayMetrics.density;
        double d = f > 1.0f ? 1.0d / ((double) f) : 1.0d;
        this.d = (int) (((double) displayMetrics.widthPixels) * d);
        this.e = (int) (((double) displayMetrics.heightPixels) * d);
    }

    @Override // defpackage.mp
    public final ep b() {
        rs rsVar = iu.a;
        q70 q70Var = dj0.a;
        gd0 gd0Var = this.g;
        q70Var.getClass();
        return xy0.t(q70Var, gd0Var);
    }
}
