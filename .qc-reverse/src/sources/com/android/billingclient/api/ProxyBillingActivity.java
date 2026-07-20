package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import defpackage.pn1;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ProxyBillingActivity extends Activity {
    public ResultReceiver b;
    public ResultReceiver c;
    public boolean d;
    public boolean e;
    public int f;

    public final Intent a() {
        Intent intent = new Intent("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
        intent.setPackage(getApplicationContext().getPackageName());
        return intent;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0091  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onActivityResult(int r8, int r9, android.content.Intent r10) {
        /*
            Method dump skipped, instruction units count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.ProxyBillingActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        PendingIntent pendingIntent;
        super.onCreate(bundle);
        if (bundle != null) {
            pn1.f("ProxyBillingActivity", "Launching Play Store billing flow from savedInstanceState");
            this.d = bundle.getBoolean("send_cancelled_broadcast_if_finished", false);
            if (bundle.containsKey("result_receiver")) {
                this.b = (ResultReceiver) bundle.getParcelable("result_receiver");
            } else if (bundle.containsKey("in_app_message_result_receiver")) {
                this.c = (ResultReceiver) bundle.getParcelable("in_app_message_result_receiver");
            }
            this.e = bundle.getBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false);
            this.f = bundle.getInt("activity_code", 100);
            return;
        }
        pn1.f("ProxyBillingActivity", "Launching Play Store billing flow");
        this.f = 100;
        if (getIntent().hasExtra("BUY_INTENT")) {
            pendingIntent = (PendingIntent) getIntent().getParcelableExtra("BUY_INTENT");
            if (getIntent().hasExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT") && getIntent().getBooleanExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false)) {
                this.e = true;
                this.f = 110;
            }
        } else if (getIntent().hasExtra("SUBS_MANAGEMENT_INTENT")) {
            pendingIntent = (PendingIntent) getIntent().getParcelableExtra("SUBS_MANAGEMENT_INTENT");
            this.b = (ResultReceiver) getIntent().getParcelableExtra("result_receiver");
        } else if (getIntent().hasExtra("IN_APP_MESSAGE_INTENT")) {
            pendingIntent = (PendingIntent) getIntent().getParcelableExtra("IN_APP_MESSAGE_INTENT");
            this.c = (ResultReceiver) getIntent().getParcelableExtra("in_app_message_result_receiver");
            this.f = 101;
        } else {
            pendingIntent = null;
        }
        try {
            this.d = true;
            startIntentSenderForResult(pendingIntent.getIntentSender(), this.f, new Intent(), 0, 0, 0);
        } catch (IntentSender.SendIntentException e) {
            pn1.h("ProxyBillingActivity", "Got exception while trying to start a purchase flow.", e);
            ResultReceiver resultReceiver = this.b;
            if (resultReceiver != null) {
                resultReceiver.send(6, null);
            } else {
                ResultReceiver resultReceiver2 = this.c;
                if (resultReceiver2 != null) {
                    resultReceiver2.send(0, null);
                } else {
                    Intent intentA = a();
                    if (this.e) {
                        intentA.putExtra("IS_FIRST_PARTY_PURCHASE", true);
                    }
                    intentA.putExtra("RESPONSE_CODE", 6);
                    intentA.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
                    sendBroadcast(intentA);
                }
            }
            this.d = false;
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        if (isFinishing() && this.d) {
            Intent intentA = a();
            intentA.putExtra("RESPONSE_CODE", 1);
            intentA.putExtra("DEBUG_MESSAGE", "Billing dialog closed.");
            int i = this.f;
            if (i == 110 || i == 100) {
                intentA.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
            }
            sendBroadcast(intentA);
        }
    }

    @Override // android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ResultReceiver resultReceiver = this.b;
        if (resultReceiver != null) {
            bundle.putParcelable("result_receiver", resultReceiver);
        }
        ResultReceiver resultReceiver2 = this.c;
        if (resultReceiver2 != null) {
            bundle.putParcelable("in_app_message_result_receiver", resultReceiver2);
        }
        bundle.putBoolean("send_cancelled_broadcast_if_finished", this.d);
        bundle.putBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", this.e);
        bundle.putInt("activity_code", this.f);
    }
}
