package com.quickcursor.android.activities;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.View;
import android.widget.Button;
import com.quickcursor.R;
import com.quickcursor.android.activities.BatteryOptimizationsActivity;
import defpackage.a;
import defpackage.di0;
import defpackage.lc1;
import defpackage.qc;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class BatteryOptimizationsActivity extends di0 {
    public static final /* synthetic */ int B = 0;

    @Override // defpackage.di0, defpackage.z7, defpackage.pm, defpackage.om, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        lc1.h0(this);
        setContentView(R.layout.battery_optimization_activity);
        Optional.ofNullable(v()).ifPresent(new a(3));
    }

    @Override // defpackage.di0, defpackage.z7, android.app.Activity
    public final void onResume() {
        boolean z;
        super.onResume();
        lc1.e(this);
        Button button = (Button) findViewById(R.id.buttonOpenDoze);
        boolean zIsIgnoringBatteryOptimizations = ((PowerManager) getSystemService("power")).isIgnoringBatteryOptimizations("com.quickcursor");
        button.setEnabled(!zIsIgnoringBatteryOptimizations);
        final int i = 0;
        if (zIsIgnoringBatteryOptimizations) {
            button.setText(R.string.battery_optimizations_battery_optimization_disabled);
            button.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_checked, 0, 0, 0);
        } else {
            button.setText(R.string.battery_optimizations_battery_optimization_open);
            button.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_open, 0, 0, 0);
        }
        final int i2 = 1;
        button.setOnClickListener(new View.OnClickListener(this) { // from class: ve
            public final /* synthetic */ BatteryOptimizationsActivity c;

            {
                this.c = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3 = i2;
                BatteryOptimizationsActivity batteryOptimizationsActivity = this.c;
                switch (i3) {
                    case 0:
                        int i4 = BatteryOptimizationsActivity.B;
                        try {
                            f01.J(batteryOptimizationsActivity, "https://dontkillmyapp.com");
                        } catch (Exception unused) {
                            return;
                        }
                        break;
                    default:
                        int i5 = BatteryOptimizationsActivity.B;
                        batteryOptimizationsActivity.startActivity(new Intent("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS"));
                        break;
                }
            }
        });
        final Intent intent = new Intent("android.settings.APP_BATTERY_SETTINGS");
        intent.setData(Uri.parse("package:com.quickcursor"));
        final boolean z2 = getPackageManager().resolveActivity(intent, 0) != null;
        qc.b.getClass();
        qc qcVar = (qc) qc.c.a();
        qcVar.getClass();
        List<ApplicationInfo> installedApplications = getPackageManager().getInstalledApplications(0);
        installedApplications.getClass();
        Iterator<ApplicationInfo> it = installedApplications.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (qcVar.a.contains(it.next().packageName) && qcVar.c(this, false)) {
                z = true;
                break;
            }
        }
        if (!z2 && !z) {
            i2 = 0;
        }
        findViewById(R.id.cardViewOem).setVisibility(i2 != 0 ? 0 : 8);
        if (i2 != 0) {
            findViewById(R.id.buttonOEMBatterySettings).setOnClickListener(new View.OnClickListener() { // from class: we
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Intent intent2 = intent;
                    int i3 = BatteryOptimizationsActivity.B;
                    BatteryOptimizationsActivity batteryOptimizationsActivity = this.b;
                    try {
                        if (z2) {
                            batteryOptimizationsActivity.startActivity(intent2);
                            return;
                        }
                        qc.b.getClass();
                        if (!((qc) qc.c.a()).c(batteryOptimizationsActivity, true)) {
                            throw new Exception("AutoStartPermissionHelper Error");
                        }
                    } catch (Exception unused) {
                        yb0.y(R.string.battery_optimizations_toast_error, 1);
                    }
                }
            });
        }
        findViewById(R.id.buttonDontKillMyApp).setOnClickListener(new View.OnClickListener(this) { // from class: ve
            public final /* synthetic */ BatteryOptimizationsActivity c;

            {
                this.c = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3 = i;
                BatteryOptimizationsActivity batteryOptimizationsActivity = this.c;
                switch (i3) {
                    case 0:
                        int i4 = BatteryOptimizationsActivity.B;
                        try {
                            f01.J(batteryOptimizationsActivity, "https://dontkillmyapp.com");
                        } catch (Exception unused) {
                            return;
                        }
                        break;
                    default:
                        int i5 = BatteryOptimizationsActivity.B;
                        batteryOptimizationsActivity.startActivity(new Intent("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS"));
                        break;
                }
            }
        });
    }
}
