package defpackage;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.os.Bundle;
import com.quickcursor.App;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class kf0 extends g1 {
    public static final l3 k = new l3(kf0.class, R.string.action_category_launch, R.string.action_value_launch_app, R.string.action_title_launch_app, R.string.action_detail_launch_app, R.drawable.icon_action_launch_app, 511, 0, Boolean.TRUE, new zy(14), null);

    @Override // defpackage.g1
    public final void g() {
        Context context = App.c;
        PackageManager packageManager = context.getPackageManager();
        try {
            boolean zBooleanValue = ((Boolean) this.g.getOrDefault("windowed", Boolean.valueOf(dn.z2))).booleanValue();
            Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage((String) this.g.get("packageName"));
            if (!zBooleanValue) {
                launchIntentForPackage.addFlags(268435456);
                context.startActivity(launchIntentForPackage);
                return;
            }
            jf0 jf0VarValueOf = jf0.valueOf((String) this.g.getOrDefault("windowedMode", dn.A2));
            Rect rectG = yb0.g((String) this.g.getOrDefault("windowConfig", ""));
            ActivityOptions activityOptionsMakeBasic = ActivityOptions.makeBasic();
            activityOptionsMakeBasic.setLaunchBounds(rectG);
            if (jf0VarValueOf == jf0.MODE1) {
                launchIntentForPackage.setAction("android.intent.action.MAIN");
                launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
                launchIntentForPackage.setFlags(402657280);
                Bundle bundle = activityOptionsMakeBasic.toBundle();
                bundle.putInt("android.activity.windowingMode", 5);
                context.startActivity(launchIntentForPackage, bundle);
                return;
            }
            if (jf0VarValueOf == jf0.MODE2) {
                launchIntentForPackage.setAction("android.intent.action.MAIN");
                launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
                launchIntentForPackage.setFlags(268435456);
                Bundle bundle2 = activityOptionsMakeBasic.toBundle();
                bundle2.putInt("android.activity.windowingMode", 5);
                context.startActivity(launchIntentForPackage, bundle2);
                return;
            }
            if (jf0VarValueOf == jf0.MODE3) {
                Bundle bundle3 = activityOptionsMakeBasic.toBundle();
                bundle3.putInt("android.activity.windowingMode", 5);
                context.startActivity(launchIntentForPackage, bundle3);
            } else if (jf0VarValueOf == jf0.MODE4) {
                context.startActivity(launchIntentForPackage, activityOptionsMakeBasic.toBundle());
            }
        } catch (Exception e) {
            si0.b("LaunchAppAction onDispatch error: " + e.getMessage());
        }
    }
}
