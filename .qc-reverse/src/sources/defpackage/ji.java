package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.github.dhaval2404.imagepicker.ImagePickerActivity;
import com.quickcursor.R;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ji extends le {
    public static final String[] d = {"android.permission.CAMERA"};
    public File b;
    public final File c;

    public ji(ImagePickerActivity imagePickerActivity) {
        super(imagePickerActivity);
        Intent intent = imagePickerActivity.getIntent();
        intent.getClass();
        Bundle extras = intent.getExtras();
        this.c = a((extras == null ? new Bundle() : extras).getString("extra.save_directory"));
    }

    public static String[] d(Context context) {
        ArrayList arrayList = new ArrayList();
        String str = d[0];
        context.getClass();
        str.getClass();
        String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
        if (strArr != null && strArr.length != 0) {
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (fc0.b(strArr[i], str)) {
                    arrayList.add(str);
                    break;
                }
                i++;
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        zy.r("null cannot be cast to non-null type kotlin.Array<T>");
        return null;
    }

    @Override // defpackage.le
    public final void b() {
        File file = this.b;
        if (file != null) {
            file.delete();
        }
        this.b = null;
    }

    public final void e() {
        if (new Intent("android.media.action.IMAGE_CAPTURE").resolveActivity(getPackageManager()) == null) {
            c(R.string.error_camera_app_not_found);
            return;
        }
        String[] strArrD = d(this);
        int length = strArrD.length;
        int i = 0;
        while (true) {
            ImagePickerActivity imagePickerActivity = this.a;
            if (i >= length) {
                File fileW = i1.w(this.c, null);
                this.b = fileW;
                if (fileW == null || !fileW.exists()) {
                    c(R.string.error_failed_to_create_camera_image_file);
                    return;
                }
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra("output", q10.d(this, getPackageName() + getString(R.string.image_picker_provider_authority_suffix), fileW));
                imagePickerActivity.startActivityForResult(intent, 4281);
                return;
            }
            String str = strArrD[i];
            str.getClass();
            if (xy0.f(this, str) != 0) {
                xy0.z(imagePickerActivity, d(imagePickerActivity), 4282);
                return;
            }
            i++;
        }
    }
}
