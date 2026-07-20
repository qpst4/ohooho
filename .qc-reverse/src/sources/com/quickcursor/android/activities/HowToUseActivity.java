package com.quickcursor.android.activities;

import android.content.Intent;
import android.os.Bundle;
import com.quickcursor.R;
import defpackage.b61;
import defpackage.c;
import defpackage.di0;
import defpackage.lc1;
import defpackage.s10;
import defpackage.xv0;
import defpackage.yb0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class HowToUseActivity extends di0 {
    public static final /* synthetic */ int C = 0;
    public final s10 B = new s10(null);

    @Override // defpackage.di0, defpackage.z7, defpackage.pm, defpackage.om, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        lc1.h0(this);
        if (xv0.d.a().q()) {
            setContentView(R.layout.how_to_use_activity);
            b61.b(new c(27, this), 5L);
        } else {
            yb0.y(R.string.toast_tutorial_available_only_in_simple_mode, 0);
            startActivity(new Intent(this, (Class<?>) MainActivity.class));
            finish();
        }
    }

    @Override // defpackage.z7, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        this.B.i.f();
    }

    @Override // defpackage.z7, android.app.Activity
    public final void onPause() {
        super.onPause();
        this.B.i.f();
    }

    @Override // defpackage.di0, defpackage.z7, android.app.Activity
    public final void onResume() {
        super.onResume();
        lc1.e(this);
        this.B.j();
    }
}
