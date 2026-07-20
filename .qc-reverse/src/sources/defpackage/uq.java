package defpackage;

import android.content.Intent;
import android.os.Bundle;
import com.github.dhaval2404.imagepicker.ImagePickerActivity;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class uq extends le {
    public final int b;
    public final int c;
    public final boolean d;
    public final float e;
    public final float f;
    public File g;
    public final File h;

    public uq(ImagePickerActivity imagePickerActivity) {
        super(imagePickerActivity);
        Intent intent = imagePickerActivity.getIntent();
        intent.getClass();
        Bundle extras = intent.getExtras();
        extras = extras == null ? new Bundle() : extras;
        this.b = extras.getInt("extra.max_width", 0);
        this.c = extras.getInt("extra.max_height", 0);
        this.d = extras.getBoolean("extra.crop", false);
        this.e = extras.getFloat("extra.crop_x", 0.0f);
        this.f = extras.getFloat("extra.crop_y", 0.0f);
        this.h = a(extras.getString("extra.save_directory"));
    }

    @Override // defpackage.le
    public final void b() {
        File file = this.g;
        if (file != null) {
            file.delete();
        }
        this.g = null;
    }
}
