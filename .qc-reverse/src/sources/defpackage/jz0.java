package defpackage;

import android.content.Intent;
import android.os.Bundle;
import com.quickcursor.android.activities.SettingsActivity;
import com.quickcursor.android.activities.settings.TriggersSettings;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class jz0 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ SettingsActivity.a c;

    public /* synthetic */ jz0(SettingsActivity.a aVar, int i) {
        this.b = i;
        this.c = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        SettingsActivity.a aVar = this.c;
        switch (i) {
            case 0:
                if (!pn0.t().B()) {
                    aVar.l0.w();
                } else {
                    aVar.k0.w();
                }
                break;
            case 1:
                aVar.k0.w();
                break;
            default:
                Intent intent = new Intent(aVar.o(), (Class<?>) TriggersSettings.class);
                Bundle bundle = new Bundle();
                bundle.putBoolean(ey0.d() ? "landscape" : "portrait", true);
                intent.putExtras(bundle);
                aVar.f0(intent);
                break;
        }
    }
}
