package defpackage;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.preference.Preference;
import com.quickcursor.android.services.CursorAccessibilityService;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class va1 implements e4, aq0 {
    public final /* synthetic */ wa1 b;

    public /* synthetic */ va1(wa1 wa1Var) {
        this.b = wa1Var;
    }

    @Override // defpackage.e4
    public void b(Object obj) {
        wa1 wa1Var = this.b;
        d4 d4Var = (d4) obj;
        StringBuilder sb = new StringBuilder("ImagePicker result code: ");
        int i = d4Var.b;
        Intent intent = d4Var.c;
        sb.append(i);
        si0.a(sb.toString());
        if (d4Var.b != -1 || intent == null || intent.getData() == null) {
            yb0.z("Error on selecting trigger image.", 0);
            return;
        }
        Uri data = intent.getData();
        si0.a("ImagePicker URI result: " + data);
        try {
            wa1Var.l0.y(MediaStore.Images.Media.getBitmap(wa1Var.Z().getContentResolver(), data));
            xv0.d.c();
            CursorAccessibilityService.j();
        } catch (Exception e) {
            si0.b("Error onImagePicked(): " + e);
        }
    }

    @Override // defpackage.aq0
    public boolean c(Preference preference) {
        wa1 wa1Var = this.b;
        sa0 sa0Var = new sa0(wa1Var);
        sa0Var.a = ta0.b;
        sa0Var.b = new String[]{"image/png"};
        sa0Var.c = 256;
        sa0Var.d = 256;
        sa0Var.b(new xp(3, wa1Var));
        return true;
    }
}
