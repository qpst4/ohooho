package defpackage;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiActivity;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class vj1 extends ak1 {
    public final /* synthetic */ Intent b;
    public final /* synthetic */ GoogleApiActivity c;

    public vj1(Intent intent, GoogleApiActivity googleApiActivity) {
        this.b = intent;
        this.c = googleApiActivity;
    }

    @Override // defpackage.ak1
    public final void a() {
        Intent intent = this.b;
        if (intent != null) {
            this.c.startActivityForResult(intent, 2);
        }
    }
}
