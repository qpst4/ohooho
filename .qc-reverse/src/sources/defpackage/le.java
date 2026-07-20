package defpackage;

import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Environment;
import com.github.dhaval2404.imagepicker.ImagePickerActivity;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class le extends ContextWrapper {
    public final ImagePickerActivity a;

    public le(ImagePickerActivity imagePickerActivity) {
        super(imagePickerActivity);
        this.a = imagePickerActivity;
    }

    public final File a(String str) {
        if (str != null) {
            return new File(str);
        }
        File externalFilesDir = getExternalFilesDir(Environment.DIRECTORY_DCIM);
        if (externalFilesDir == null) {
            externalFilesDir = this.a.getFilesDir();
        }
        externalFilesDir.getClass();
        return externalFilesDir;
    }

    public final void c(int i) {
        String string = getString(i);
        string.getClass();
        b();
        ImagePickerActivity imagePickerActivity = this.a;
        imagePickerActivity.getClass();
        Intent intent = new Intent();
        intent.putExtra("extra.error", string);
        imagePickerActivity.setResult(64, intent);
        imagePickerActivity.finish();
    }

    public void b() {
    }
}
