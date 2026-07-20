package defpackage;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import com.canhub.cropper.CropImageActivity;
import com.canhub.cropper.CropImageView;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class vf extends o31 implements z40 {
    public final /* synthetic */ int f;
    public /* synthetic */ Object g;
    public final /* synthetic */ mp h;
    public final /* synthetic */ Object i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ vf(mp mpVar, Object obj, jo joVar, int i) {
        super(joVar);
        this.f = i;
        this.h = mpVar;
        this.i = obj;
    }

    @Override // defpackage.z40
    public final Object f(Object obj, Object obj2) throws Throwable {
        mp mpVar = (mp) obj;
        jo joVar = (jo) obj2;
        switch (this.f) {
            case 0:
                vf vfVar = (vf) h(joVar, mpVar);
                ow0 ow0Var = ow0.h;
                vfVar.i(ow0Var);
                return ow0Var;
            default:
                vf vfVar2 = (vf) h(joVar, mpVar);
                ow0 ow0Var2 = ow0.h;
                vfVar2.i(ow0Var2);
                return ow0Var2;
        }
    }

    @Override // defpackage.o31
    public final jo h(jo joVar, Object obj) {
        int i = this.f;
        Object obj2 = this.i;
        mp mpVar = this.h;
        switch (i) {
            case 0:
                vf vfVar = new vf((yf) mpVar, (uf) obj2, joVar, 0);
                vfVar.g = obj;
                return vfVar;
            default:
                vf vfVar2 = new vf((cg) mpVar, (bg) obj2, joVar, 1);
                vfVar2.g = obj;
                return vfVar2;
        }
    }

    @Override // defpackage.o31
    public final Object i(Object obj) throws Throwable {
        CropImageView cropImageView;
        CropImageView cropImageView2;
        CropImageView cropImageView3;
        CropImageView cropImageView4;
        int i = this.f;
        mp mpVar = this.h;
        Object obj2 = this.i;
        switch (i) {
            case 0:
                uf ufVar = (uf) obj2;
                yb0.C(obj);
                if (!i1.C((mp) this.g) || (cropImageView = (CropImageView) ((yf) mpVar).c.get()) == null) {
                    Bitmap bitmap = ufVar.a;
                    if (bitmap != null) {
                        bitmap.recycle();
                    }
                } else {
                    cropImageView.N = null;
                    cropImageView.h();
                    gq gqVar = cropImageView.D;
                    if (gqVar != null) {
                        Uri uri = ufVar.b;
                        Exception exc = ufVar.c;
                        float[] cropPoints = cropImageView.getCropPoints();
                        cropImageView.getCropRect();
                        cropImageView.getWholeImageRect();
                        cropImageView.getRotatedDegrees();
                        int i2 = ufVar.d;
                        cropPoints.getClass();
                        ((CropImageActivity) gqVar).F(uri, exc, i2);
                    }
                }
                return ow0.h;
            default:
                bg bgVar = (bg) obj2;
                yb0.C(obj);
                if (!i1.C((mp) this.g) || (cropImageView2 = (CropImageView) ((cg) mpVar).f.get()) == null) {
                    Bitmap bitmap2 = bgVar.b;
                    if (bitmap2 != null) {
                        bitmap2.recycle();
                    }
                } else {
                    cropImageView2.M = null;
                    cropImageView2.h();
                    Exception exc2 = bgVar.g;
                    if (exc2 == null) {
                        int i3 = bgVar.d;
                        cropImageView2.k = i3;
                        cropImageView2.m = bgVar.e;
                        cropImageView2.n = bgVar.f;
                        cropImageView2.f(bgVar.b, 0, bgVar.a, bgVar.c, i3);
                    }
                    kq kqVar = cropImageView2.C;
                    if (kqVar != null) {
                        CropImageActivity cropImageActivity = (CropImageActivity) kqVar;
                        if (exc2 == null) {
                            cq cqVar = cropImageActivity.B;
                            if (cqVar == null) {
                                fc0.S("cropImageOptions");
                                throw null;
                            }
                            Rect rect = cqVar.X;
                            if (rect != null && (cropImageView4 = cropImageActivity.C) != null) {
                                cropImageView4.setCropRect(rect);
                            }
                            cq cqVar2 = cropImageActivity.B;
                            if (cqVar2 == null) {
                                fc0.S("cropImageOptions");
                                throw null;
                            }
                            int i4 = cqVar2.Y;
                            if (i4 > 0 && (cropImageView3 = cropImageActivity.C) != null) {
                                cropImageView3.setRotatedDegrees(i4);
                            }
                            cq cqVar3 = cropImageActivity.B;
                            if (cqVar3 == null) {
                                fc0.S("cropImageOptions");
                                throw null;
                            }
                            if (cqVar3.h0) {
                                cropImageActivity.E();
                            }
                        } else {
                            cropImageActivity.F(null, exc2, 1);
                        }
                    }
                }
                return ow0.h;
        }
    }
}
