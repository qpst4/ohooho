package defpackage;

import android.net.Uri;
import com.canhub.cropper.CropImageActivity;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class aq extends j50 implements v40 {
    @Override // defpackage.v40
    public final Object g(Object obj) {
        zp zpVar = (zp) obj;
        zpVar.getClass();
        CropImageActivity cropImageActivity = (CropImageActivity) this.c;
        int i = CropImageActivity.H;
        cropImageActivity.getClass();
        int iOrdinal = zpVar.ordinal();
        if (iOrdinal == 0) {
            File fileCreateTempFile = File.createTempFile("tmp_image_file", ".png", cropImageActivity.getCacheDir());
            fileCreateTempFile.createNewFile();
            fileCreateTempFile.deleteOnExit();
            Uri uriO = lc1.O(cropImageActivity, fileCreateTempFile);
            cropImageActivity.E = uriO;
            cropImageActivity.G.a(uriO);
        } else {
            if (iOrdinal != 1) {
                throw new cm();
            }
            cropImageActivity.F.a("image/*");
        }
        return ow0.h;
    }
}
