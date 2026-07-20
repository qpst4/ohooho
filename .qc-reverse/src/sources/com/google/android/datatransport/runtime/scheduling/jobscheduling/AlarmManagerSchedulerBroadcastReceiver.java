package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import defpackage.d91;
import defpackage.hd;
import defpackage.qd1;
import defpackage.ra;
import defpackage.s4;
import defpackage.vd1;
import defpackage.vq0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {
    public static final /* synthetic */ int a = 0;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter("extras");
        int iIntValue = Integer.valueOf(intent.getData().getQueryParameter("priority")).intValue();
        int i = intent.getExtras().getInt("attemptNumber");
        d91.b(context);
        ra raVarA = hd.a();
        raVarA.R(queryParameter);
        raVarA.e = vq0.b(iIntValue);
        if (queryParameter2 != null) {
            raVarA.d = Base64.decode(queryParameter2, 0);
        }
        vd1 vd1Var = d91.a().d;
        vd1Var.e.execute(new qd1(vd1Var, raVarA.m(), i, new s4(1)));
    }
}
