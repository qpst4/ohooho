package com.quickcursor.android.activities;

import android.os.Bundle;
import android.widget.TextView;
import com.quickcursor.R;
import defpackage.a;
import defpackage.di0;
import defpackage.lc1;
import defpackage.ra;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class OpenSourceActivity extends di0 {
    public static final /* synthetic */ int B = 0;

    @Override // defpackage.di0, defpackage.z7, defpackage.pm, defpackage.om, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        lc1.h0(this);
        setContentView(R.layout.markdown_activity);
        Optional.ofNullable(v()).ifPresent(new a(12));
        ra.n(this).S((TextView) findViewById(R.id.markdown), getString(R.string.markdown_open_source));
    }

    @Override // defpackage.di0, defpackage.z7, android.app.Activity
    public final void onResume() {
        super.onResume();
        lc1.e(this);
    }
}
