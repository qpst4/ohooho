package defpackage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.preference.Preference;
import com.quickcursor.R;
import com.quickcursor.android.activities.settings.CursorSettings;
import com.quickcursor.android.activities.settings.b;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class br implements e4, zp0, aq0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ CursorSettings.a c;

    public /* synthetic */ br(CursorSettings.a aVar, int i) {
        this.b = i;
        this.c = aVar;
    }

    @Override // defpackage.zp0
    public boolean a(Preference preference, Object obj) {
        this.c.l0(l11.w((String) obj));
        return true;
    }

    @Override // defpackage.e4
    public void b(Object obj) {
        CursorSettings.a aVar = this.c;
        d4 d4Var = (d4) obj;
        StringBuilder sb = new StringBuilder("ImagePicker result code: ");
        int i = d4Var.b;
        Intent intent = d4Var.c;
        sb.append(i);
        si0.a(sb.toString());
        if (d4Var.b != -1 || intent == null || intent.getData() == null) {
            yb0.z("Error on selecting cursor image.", 0);
            return;
        }
        Uri data = intent.getData();
        si0.a("ImagePicker URI result: " + data);
        try {
            pn0.t().R(MediaStore.Images.Media.getBitmap(aVar.Z().getContentResolver(), data));
            ((SharedPreferences) pn0.t().d).edit().putFloat(oq0.z.name(), 0.5f).putFloat(oq0.A.name(), 0.5f).apply();
            CursorSettings.G(aVar.i0, yq.j(pn0.t().m()));
            aVar.h0.a(new s4(15));
            new er(aVar.Z(), pn0.t().p(), pn0.t().r(), new b(aVar));
        } catch (Exception e) {
            si0.b("Error onImagePicked(): " + e);
        }
    }

    @Override // defpackage.aq0
    public boolean c(Preference preference) {
        int i = this.b;
        CursorSettings.a aVar = this.c;
        int i2 = 1;
        switch (i) {
            case 2:
                new er(aVar.Z(), pn0.t().p(), pn0.t().r(), new b(aVar));
                break;
            case 3:
                jl1 jl1Var = new jl1(aVar.o());
                jl1Var.m(R.string.are_you_sure);
                jl1Var.g(R.string.confirmation_reset_cursor_settings);
                ((x6) jl1Var.c).c = R.drawable.icon_warning;
                jl1Var.k(android.R.string.yes, new z2(4, aVar));
                jl1Var.h(android.R.string.no, null);
                jl1Var.n();
                break;
            default:
                sa0 sa0Var = new sa0(aVar);
                sa0Var.a = ta0.b;
                sa0Var.b = new String[]{"image/png"};
                sa0Var.c = 256;
                sa0Var.d = 256;
                sa0Var.b(new xp(i2, aVar));
                break;
        }
        return true;
    }
}
