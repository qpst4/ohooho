package com.android.billingclient.api;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.android.billingclient.api.ProxyBillingActivityV2;
import defpackage.cc0;
import defpackage.e4;
import defpackage.f4;
import defpackage.k4;
import defpackage.pm;
import defpackage.pn1;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ProxyBillingActivityV2 extends pm {
    public k4 u;
    public k4 v;
    public ResultReceiver w;
    public ResultReceiver x;

    @Override // defpackage.pm, defpackage.om, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        final int i = 0;
        this.u = (k4) t(new e4(this) { // from class: jm1
            public final /* synthetic */ ProxyBillingActivityV2 c;

            {
                this.c = this;
            }

            @Override // defpackage.e4
            public final void b(Object obj) {
                int i2 = i;
                ProxyBillingActivityV2 proxyBillingActivityV2 = this.c;
                d4 d4Var = (d4) obj;
                switch (i2) {
                    case 0:
                        Intent intent = d4Var.c;
                        int i3 = pn1.d(intent, "ProxyBillingActivityV2").a;
                        ResultReceiver resultReceiver = proxyBillingActivityV2.w;
                        if (resultReceiver != null) {
                            resultReceiver.send(i3, intent != null ? intent.getExtras() : null);
                        }
                        int i4 = d4Var.b;
                        if (i4 != -1 || i3 != 0) {
                            pn1.g("ProxyBillingActivityV2", "Alternative billing only dialog finished with resultCode " + i4 + " and billing's responseCode: " + i3);
                        }
                        proxyBillingActivityV2.finish();
                        break;
                    default:
                        Intent intent2 = d4Var.c;
                        int i5 = pn1.d(intent2, "ProxyBillingActivityV2").a;
                        ResultReceiver resultReceiver2 = proxyBillingActivityV2.x;
                        if (resultReceiver2 != null) {
                            resultReceiver2.send(i5, intent2 != null ? intent2.getExtras() : null);
                        }
                        int i6 = d4Var.b;
                        if (i6 != -1 || i5 != 0) {
                            pn1.g("ProxyBillingActivityV2", "External offer dialog finished with resultCode: " + i6 + " and billing's responseCode: " + i5);
                        }
                        proxyBillingActivityV2.finish();
                        break;
                }
            }
        }, new f4(3));
        final int i2 = 1;
        this.v = (k4) t(new e4(this) { // from class: jm1
            public final /* synthetic */ ProxyBillingActivityV2 c;

            {
                this.c = this;
            }

            @Override // defpackage.e4
            public final void b(Object obj) {
                int i22 = i2;
                ProxyBillingActivityV2 proxyBillingActivityV2 = this.c;
                d4 d4Var = (d4) obj;
                switch (i22) {
                    case 0:
                        Intent intent = d4Var.c;
                        int i3 = pn1.d(intent, "ProxyBillingActivityV2").a;
                        ResultReceiver resultReceiver = proxyBillingActivityV2.w;
                        if (resultReceiver != null) {
                            resultReceiver.send(i3, intent != null ? intent.getExtras() : null);
                        }
                        int i4 = d4Var.b;
                        if (i4 != -1 || i3 != 0) {
                            pn1.g("ProxyBillingActivityV2", "Alternative billing only dialog finished with resultCode " + i4 + " and billing's responseCode: " + i3);
                        }
                        proxyBillingActivityV2.finish();
                        break;
                    default:
                        Intent intent2 = d4Var.c;
                        int i5 = pn1.d(intent2, "ProxyBillingActivityV2").a;
                        ResultReceiver resultReceiver2 = proxyBillingActivityV2.x;
                        if (resultReceiver2 != null) {
                            resultReceiver2.send(i5, intent2 != null ? intent2.getExtras() : null);
                        }
                        int i6 = d4Var.b;
                        if (i6 != -1 || i5 != 0) {
                            pn1.g("ProxyBillingActivityV2", "External offer dialog finished with resultCode: " + i6 + " and billing's responseCode: " + i5);
                        }
                        proxyBillingActivityV2.finish();
                        break;
                }
            }
        }, new f4(3));
        if (bundle != null) {
            if (bundle.containsKey("alternative_billing_only_dialog_result_receiver")) {
                this.w = (ResultReceiver) bundle.getParcelable("alternative_billing_only_dialog_result_receiver");
                return;
            } else {
                if (bundle.containsKey("external_payment_dialog_result_receiver")) {
                    this.x = (ResultReceiver) bundle.getParcelable("external_payment_dialog_result_receiver");
                    return;
                }
                return;
            }
        }
        pn1.f("ProxyBillingActivityV2", "Launching Play Store billing dialog");
        if (getIntent().hasExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT")) {
            PendingIntent pendingIntent = (PendingIntent) getIntent().getParcelableExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT");
            this.w = (ResultReceiver) getIntent().getParcelableExtra("alternative_billing_only_dialog_result_receiver");
            k4 k4Var = this.u;
            pendingIntent.getClass();
            IntentSender intentSender = pendingIntent.getIntentSender();
            intentSender.getClass();
            k4Var.a(new cc0(intentSender, null, 0, 0));
            return;
        }
        if (getIntent().hasExtra("external_payment_dialog_pending_intent")) {
            PendingIntent pendingIntent2 = (PendingIntent) getIntent().getParcelableExtra("external_payment_dialog_pending_intent");
            this.x = (ResultReceiver) getIntent().getParcelableExtra("external_payment_dialog_result_receiver");
            k4 k4Var2 = this.v;
            pendingIntent2.getClass();
            IntentSender intentSender2 = pendingIntent2.getIntentSender();
            intentSender2.getClass();
            k4Var2.a(new cc0(intentSender2, null, 0, 0));
        }
    }

    @Override // defpackage.pm, defpackage.om, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ResultReceiver resultReceiver = this.w;
        if (resultReceiver != null) {
            bundle.putParcelable("alternative_billing_only_dialog_result_receiver", resultReceiver);
        }
        ResultReceiver resultReceiver2 = this.x;
        if (resultReceiver2 != null) {
            bundle.putParcelable("external_payment_dialog_result_receiver", resultReceiver2);
        }
    }
}
