package defpackage;

import android.content.Intent;
import com.quickcursor.App;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class nf0 extends g1 {
    public static final l3 k = new l3(nf0.class, R.string.action_category_launch, R.string.action_value_launch_camera, R.string.action_title_launch_camera, R.string.action_detail_launch_camera, R.drawable.icon_action_launch_camera, 511, 0, Boolean.FALSE, null, null);

    @Override // defpackage.g1
    public final void g() {
        Intent intent = new Intent("android.media.action.STILL_IMAGE_CAMERA");
        intent.setFlags(268435456);
        App.c.startActivity(intent);
    }
}
