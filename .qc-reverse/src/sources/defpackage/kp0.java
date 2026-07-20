package defpackage;

import android.os.AsyncTask;
import android.view.accessibility.AccessibilityNodeInfo;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class kp0 extends g1 {
    public static final l3 k = new l3(kp0.class, R.string.action_category_general, R.string.action_value_paste, R.string.action_title_paste, R.string.action_detail_paste, R.drawable.icon_action_paste, 511, 0, Boolean.FALSE, null, null);

    @Override // defpackage.g1
    public final void g() {
        boolean zPerformAction;
        try {
            AccessibilityNodeInfo accessibilityNodeInfoN = zy0.n(this.f);
            if (accessibilityNodeInfoN != null) {
                zPerformAction = accessibilityNodeInfoN.performAction(32768);
                accessibilityNodeInfoN.recycle();
            } else {
                zPerformAction = false;
            }
            if (zPerformAction) {
                return;
            }
            AsyncTask.execute(new lk0(1, this));
        } catch (Exception unused) {
        }
    }
}
