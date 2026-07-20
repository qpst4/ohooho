package defpackage;

import android.content.Intent;
import com.canhub.cropper.CropImageActivity;
import com.quickcursor.android.activities.settings.CursorSettings;
import com.quickcursor.android.activities.settings.TrackerSettings;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class xp implements v40 {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ xp(int i, Object obj) {
        this.b = i;
        this.c = obj;
    }

    @Override // defpackage.v40
    public final Object g(Object obj) {
        int i = this.b;
        Object obj2 = this.c;
        switch (i) {
            case 0:
                int i2 = CropImageActivity.H;
                ((r30) obj).getClass();
                ((CropImageActivity) obj2).G();
                break;
            case 1:
                ((CursorSettings.a) obj2).l0.a((Intent) obj);
                break;
            case 2:
                ((TrackerSettings.a) obj2).j0.a((Intent) obj);
                break;
            default:
                ((wa1) obj2).n0.a((Intent) obj);
                break;
        }
        return null;
    }
}
