package defpackage;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class jr extends g1 {
    public static final l3 k = new l3(jr.class, R.string.action_category_general, R.string.action_value_cut, R.string.action_title_cut, R.string.action_detail_cut, R.drawable.icon_action_cut, 255, 0, Boolean.FALSE, null, null);

    public static boolean m(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("ACTION_ARGUMENT_SELECTION_START_INT", 0);
        bundle.putInt("ACTION_ARGUMENT_SELECTION_END_INT", accessibilityNodeInfo.getText().length());
        accessibilityNodeInfo.performAction(131072, bundle);
        boolean zPerformAction = accessibilityNodeInfo.performAction(65536);
        accessibilityNodeInfo.recycle();
        return zPerformAction;
    }

    @Override // defpackage.g1
    public final void g() {
        try {
            if (m(zy0.n(this.f))) {
                return;
            }
            AsyncTask.execute(new c(18, this));
        } catch (Exception unused) {
        }
    }
}
