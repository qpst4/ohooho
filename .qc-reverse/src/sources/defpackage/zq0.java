package defpackage;

import android.util.Log;
import com.quickcursor.App;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class zq0 {
    public static final zq0 b;
    public dz a;

    static {
        zq0 zq0Var = new zq0();
        zq0Var.a = null;
        try {
            zq0Var.a = dz.a(lj0.a(lj0.a), App.c, bz.c, cz.c);
        } catch (IOException | GeneralSecurityException e) {
            String localizedMessage = e.getLocalizedMessage();
            Objects.requireNonNull(localizedMessage);
            Log.e("ProRepository", localizedMessage);
            yb0.z("Quick Cursor Error: can't create repository. Please email me at support@quickcursor.app", 1);
        }
        b = zq0Var;
    }

    public final void a() {
        pn0.t().Y();
        az azVar = (az) this.a.edit();
        azVar.putString(xq0.proState.name(), yq0.no.name());
        azVar.apply();
        lv.b();
    }

    public final yq0 b() {
        try {
            String string = this.a.getString(xq0.proState.name(), null);
            if (string != null && string.equals("yes")) {
                string = yq0.lifetime.name();
            }
            return yq0.valueOf(string);
        } catch (Exception unused) {
            this.a();
            return yq0.no;
        }
    }

    public final boolean c() {
        yq0 yq0VarB = b();
        return yq0VarB == yq0.lifetime || yq0VarB == yq0.subscription;
    }
}
