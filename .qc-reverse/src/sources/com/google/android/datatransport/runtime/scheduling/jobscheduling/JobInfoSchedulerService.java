package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import defpackage.d91;
import defpackage.hd;
import defpackage.k2;
import defpackage.qd1;
import defpackage.ra;
import defpackage.vd1;
import defpackage.vq0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class JobInfoSchedulerService extends JobService {
    public static final /* synthetic */ int b = 0;

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i = jobParameters.getExtras().getInt("priority");
        int i2 = jobParameters.getExtras().getInt("attemptNumber");
        d91.b(getApplicationContext());
        ra raVarA = hd.a();
        raVarA.R(string);
        raVarA.e = vq0.b(i);
        if (string2 != null) {
            raVarA.d = Base64.decode(string2, 0);
        }
        vd1 vd1Var = d91.a().d;
        vd1Var.e.execute(new qd1(vd1Var, raVarA.m(), i2, new k2(this, 13, jobParameters)));
        return true;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
