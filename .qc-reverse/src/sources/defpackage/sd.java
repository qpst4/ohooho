package defpackage;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import com.quickcursor.R;
import com.quickcursor.android.services.CursorAccessibilityService;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class sd implements DialogInterface.OnClickListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ Runnable c;

    public /* synthetic */ sd(Runnable runnable, int i) {
        this.b = i;
        this.c = runnable;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = this.b;
        Runnable runnable = this.c;
        switch (i2) {
            case 0:
                SharedPreferences sharedPreferences = (SharedPreferences) pn0.t().d;
                oq0 oq0Var = oq0.g;
                String strD = oq0.d(sharedPreferences, oq0Var);
                ((SharedPreferences) pn0.e.d).edit().clear().commit();
                ((SharedPreferences) pn0.t().d).edit().putString(oq0Var.name(), strD).apply();
                pn0.t().X(248);
                pn0.t().Q(true);
                ((SharedPreferences) pn0.t().d).edit().putBoolean(oq0.j.name(), true).apply();
                pn0.t().Y();
                if (zq0.b.c()) {
                    pn0.t().Z();
                }
                CursorAccessibilityService.k(true);
                lv.b();
                yb0.y(R.string.backup_settings_reset_success, 1);
                si0.b("Reset settings done");
                runnable.run();
                break;
            default:
                runnable.run();
                break;
        }
    }
}
