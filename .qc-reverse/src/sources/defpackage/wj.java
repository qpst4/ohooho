package defpackage;

import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class wj extends di0 {
    public sf B;

    /* JADX WARN: Removed duplicated region for block: B:36:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void F() {
        /*
            Method dump skipped, instruction units count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wj.F():void");
    }

    @Override // defpackage.di0, defpackage.z7, defpackage.pm, defpackage.om, android.app.Activity
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
        } catch (Exception e) {
            si0.b("Activity onCreate is crashing: " + e.getMessage());
            if (getIntent().getBooleanExtra("clean_restart", false)) {
                finish();
                return;
            }
            Intent intent = getIntent();
            intent.putExtra("clean_restart", true);
            intent.addFlags(65536);
            finish();
            startActivity(intent);
        }
    }

    @Override // defpackage.z7, android.app.Activity
    public void onDestroy() {
        try {
            super.onDestroy();
        } catch (Exception unused) {
        }
    }

    @Override // defpackage.z7, android.app.Activity
    public final void onPause() {
        super.onPause();
        sf sfVar = this.B;
        if (sfVar != null) {
            af afVar = sfVar.c;
            if (afVar != null) {
                afVar.b();
            }
            this.B = null;
        }
    }

    @Override // defpackage.di0, defpackage.z7, android.app.Activity
    public void onResume() {
        super.onResume();
        F();
    }
}
