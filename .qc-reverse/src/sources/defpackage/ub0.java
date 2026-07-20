package defpackage;

import android.content.Intent;
import android.net.Uri;
import androidx.preference.Preference;
import com.quickcursor.R;
import com.quickcursor.android.activities.settings.InputDispatcherBug;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ub0 implements zp0, aq0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ InputDispatcherBug.a c;

    public /* synthetic */ ub0(InputDispatcherBug.a aVar, int i) {
        this.b = i;
        this.c = aVar;
    }

    @Override // defpackage.zp0
    public boolean a(Preference preference, Object obj) {
        this.c.h0.a(new s4(15));
        return true;
    }

    @Override // defpackage.aq0
    public boolean c(Preference preference) {
        int i = this.b;
        InputDispatcherBug.a aVar = this.c;
        switch (i) {
            case 1:
                aVar.f0(Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.parse(dn.k)), lc1.K(R.string.choose_email_client_popup_title)));
                break;
            case 2:
                f01.J(aVar.u(), lc1.K(R.string.input_dispatcher_github_issue));
                break;
            default:
                f01.J(aVar.u(), lc1.K(R.string.input_dispatcher_google_issue));
                break;
        }
        return true;
    }
}
