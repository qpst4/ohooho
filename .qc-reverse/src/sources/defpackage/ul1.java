package defpackage;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ul1 extends af {
    public volatile int A;
    public volatile yk1 B;
    public volatile sl1 C;
    public volatile fo1 D;
    public final z7 z;

    public ul1(ix ixVar, z7 z7Var) {
        super(ixVar, z7Var);
        this.A = 0;
        this.z = z7Var;
    }

    public final /* synthetic */ void A(gs0 gs0Var, ir0 ir0Var) {
        super.e(gs0Var, ir0Var);
    }

    public final synchronized boolean B() {
        if (this.A == 2 && this.B != null) {
            if (this.C != null) {
                return true;
            }
        }
        return false;
    }

    public final zn1 C(int i) {
        if (!B()) {
            pn1.g("BillingClientTesting", "Billing Override Service is not ready.");
            D(106, 28, zl1.a("Billing Override Service connection is disconnected.", -1));
            return new wn1();
        }
        jl1 jl1Var = new jl1(i, this);
        bs1 bs1Var = new bs1();
        bs1Var.c = new gs1();
        fs1 fs1Var = new fs1(bs1Var);
        bs1Var.b = fs1Var;
        bs1Var.a = jl1.class;
        try {
            jl1Var.o(bs1Var);
            bs1Var.a = "billingOverrideService.getBillingOverride";
            return fs1Var;
        } catch (Exception e) {
            qp1 qp1Var = new qp1(e);
            f01 f01Var = as1.g;
            ds1 ds1Var = fs1Var.c;
            if (f01Var.a0(ds1Var, null, qp1Var)) {
                as1.c(ds1Var);
            }
            return fs1Var;
        }
    }

    public final void D(int i, int i2, df dfVar) {
        sq1 sq1VarB = vl1.b(i, i2, dfVar);
        Objects.requireNonNull(sq1VarB, "ApiFailure should not be null");
        this.g.b0(sq1VarB);
    }

    public final void E(int i, Consumer consumer, Runnable runnable) {
        fo1 fo1Var;
        ao1 ao1Var;
        ao1 fo1Var2;
        zn1 zn1VarC = C(i);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        synchronized (this) {
            try {
                if (this.D == null) {
                    ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
                    this.D = scheduledExecutorServiceNewSingleThreadScheduledExecutor instanceof fo1 ? (fo1) scheduledExecutorServiceNewSingleThreadScheduledExecutor : new fo1(scheduledExecutorServiceNewSingleThreadScheduledExecutor);
                }
                fo1Var = this.D;
            } finally {
            }
        }
        if (!zn1VarC.isDone()) {
            ho1 ho1Var = new ho1();
            ho1Var.i = zn1VarC;
            nc ncVar = new nc();
            ncVar.c = ho1Var;
            ho1Var.j = fo1Var.schedule(ncVar, 28500L, timeUnit);
            zn1VarC.a(ncVar, tn1.b);
            zn1VarC = ho1Var;
        }
        t3 t3Var = new t3(this, i, consumer, runnable);
        synchronized (this) {
            try {
                if (this.x == null) {
                    ExecutorService executorServiceL = l();
                    if (executorServiceL instanceof ao1) {
                        fo1Var2 = (ao1) executorServiceL;
                    } else {
                        fo1Var2 = executorServiceL instanceof ScheduledExecutorService ? new fo1((ScheduledExecutorService) executorServiceL) : new ao1(executorServiceL);
                    }
                    this.x = fo1Var2;
                }
                ao1Var = this.x;
            } finally {
            }
        }
        zn1VarC.a(new vn1(zn1VarC, 0, t3Var), ao1Var);
    }

    @Override // defpackage.af
    public final void a(c1 c1Var, s1 s1Var) {
        E(3, new ll1(s1Var), new qv0(this, c1Var, s1Var, 3));
    }

    @Override // defpackage.af
    public final void b() {
        synchronized (this) {
            wq1 wq1VarD = vl1.d(27);
            Objects.requireNonNull(wq1VarD, "ApiSuccess should not be null");
            this.g.c0(wq1VarD);
            try {
                try {
                    if (this.C != null && this.B != null) {
                        pn1.f("BillingClientTesting", "Unbinding from Billing Override Service.");
                        this.z.unbindService(this.C);
                        this.C = new sl1(this);
                    }
                    this.B = null;
                    if (this.D != null) {
                        this.D.shutdownNow();
                        this.D = null;
                    }
                } catch (RuntimeException e) {
                    pn1.h("BillingClientTesting", "There was an exception while ending Billing Override Service connection!", e);
                }
                this.A = 3;
            } catch (Throwable th) {
                this.A = 3;
                throw th;
            }
        }
        super.b();
    }

    @Override // defpackage.af
    public final df d(z7 z7Var, cf cfVar) {
        int iIntValue = 0;
        try {
            iIntValue = ((Integer) C(2).get(28500L, TimeUnit.MILLISECONDS)).intValue();
        } catch (TimeoutException e) {
            D(114, 28, zl1.t);
            pn1.h("BillingClientTesting", "Asynchronous call to Billing Override Service timed out.", e);
        } catch (Exception e2) {
            if (e2 instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            D(107, 28, zl1.t);
            pn1.h("BillingClientTesting", "An error occurred while retrieving billing override.", e2);
        }
        if (iIntValue > 0) {
            df dfVarA = zl1.a("Billing override value was set by a license tester.", iIntValue);
            D(105, 2, dfVarA);
            y(dfVarA);
            return dfVarA;
        }
        try {
            return super.d(z7Var, cfVar);
        } catch (Exception e3) {
            df dfVar = zl1.i;
            D(115, 2, dfVar);
            pn1.h("BillingClientTesting", "An internal error occurred.", e3);
            return dfVar;
        }
    }

    @Override // defpackage.af
    public final void e(gs0 gs0Var, final ir0 ir0Var) {
        E(7, new Consumer() { // from class: il1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ArrayList arrayList = new ArrayList();
                ir0Var.e((df) obj, arrayList);
            }
        }, new qv0(this, gs0Var, ir0Var, 2));
    }

    @Override // defpackage.af
    public final void g(sp1 sp1Var) {
        synchronized (this) {
            if (B()) {
                pn1.f("BillingClientTesting", "Billing Override Service connection is valid. No need to re-initialize.");
                wq1 wq1VarD = vl1.d(26);
                Objects.requireNonNull(wq1VarD, "ApiSuccess should not be null");
                this.g.c0(wq1VarD);
            } else {
                int i = 1;
                if (this.A == 1) {
                    pn1.g("BillingClientTesting", "Client is already in the process of connecting to Billing Override Service.");
                } else if (this.A == 3) {
                    pn1.g("BillingClientTesting", "Billing Override Service Client was already closed and can't be reused. Please create another instance.");
                    D(38, 26, zl1.a("Billing Override Service connection is disconnected.", -1));
                } else {
                    this.A = 1;
                    pn1.f("BillingClientTesting", "Starting Billing Override Service setup.");
                    this.C = new sl1(this);
                    Intent intent = new Intent("com.google.android.apps.play.billingtestcompanion.BillingOverrideService.BIND");
                    intent.setPackage("com.google.android.apps.play.billingtestcompanion");
                    List<ResolveInfo> listQueryIntentServices = this.z.getPackageManager().queryIntentServices(intent, 0);
                    if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
                        i = 41;
                    } else {
                        ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
                        if (serviceInfo != null) {
                            String str = serviceInfo.packageName;
                            String str2 = serviceInfo.name;
                            if (!Objects.equals(str, "com.google.android.apps.play.billingtestcompanion") || str2 == null) {
                                pn1.g("BillingClientTesting", "The device doesn't have valid Play Billing Lab.");
                            } else {
                                ComponentName componentName = new ComponentName(str, str2);
                                Intent intent2 = new Intent(intent);
                                intent2.setComponent(componentName);
                                if (this.z.bindService(intent2, this.C, 1)) {
                                    pn1.f("BillingClientTesting", "Billing Override Service was bonded successfully.");
                                } else {
                                    pn1.g("BillingClientTesting", "Connection to Billing Override Service is blocked.");
                                }
                            }
                            i = 39;
                        }
                    }
                    this.A = 0;
                    pn1.f("BillingClientTesting", "Billing Override Service unavailable on device.");
                    D(i, 26, zl1.a("Billing Override Service unavailable on device.", 2));
                }
            }
        }
        super.g(sp1Var);
    }

    public final /* synthetic */ void z(c1 c1Var, s1 s1Var) {
        super.a(c1Var, s1Var);
    }

    public ul1(ix ixVar, z7 z7Var, sf sfVar) {
        super(ixVar, z7Var, sfVar);
        this.A = 0;
        this.z = z7Var;
    }
}
