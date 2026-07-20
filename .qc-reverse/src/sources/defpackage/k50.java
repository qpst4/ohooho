package defpackage;

import android.content.Intent;
import android.os.Bundle;
import com.github.dhaval2404.imagepicker.ImagePickerActivity;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class k50 extends le {
    public final String[] b;

    public k50(ImagePickerActivity imagePickerActivity) {
        super(imagePickerActivity);
        Intent intent = imagePickerActivity.getIntent();
        intent.getClass();
        Bundle extras = intent.getExtras();
        String[] stringArray = (extras == null ? new Bundle() : extras).getStringArray("extra.mime_types");
        this.b = stringArray == null ? new String[0] : stringArray;
    }
}
