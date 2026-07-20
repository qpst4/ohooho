package defpackage;

import android.accessibilityservice.AccessibilityService;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class zy0 extends g1 {
    public static final l3 k = new l3(zy0.class, R.string.action_category_general, R.string.action_value_select_all, R.string.action_title_select_all, R.string.action_detail_select_all, R.drawable.icon_action_select_all, 255, 0, Boolean.FALSE, null, null);

    public static AccessibilityNodeInfo m(AccessibilityNodeInfo accessibilityNodeInfo, AccessibilityNodeInfo.AccessibilityAction accessibilityAction) {
        if (accessibilityNodeInfo == null) {
            return null;
        }
        if (accessibilityNodeInfo.isFocused() && accessibilityNodeInfo.getActionList().contains(accessibilityAction)) {
            return accessibilityNodeInfo;
        }
        int childCount = accessibilityNodeInfo.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                AccessibilityNodeInfo accessibilityNodeInfoM = m(accessibilityNodeInfo.getChild(i), accessibilityAction);
                if (accessibilityNodeInfoM != null) {
                    return accessibilityNodeInfoM;
                }
            }
        }
        accessibilityNodeInfo.recycle();
        return null;
    }

    public static AccessibilityNodeInfo n(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo accessibilityNodeInfoFindFocus = accessibilityService.getRootInActiveWindow().findFocus(1);
        return accessibilityNodeInfoFindFocus == null ? accessibilityService.getRootInActiveWindow().findFocus(2) : accessibilityNodeInfoFindFocus;
    }

    public static boolean o(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("ACTION_ARGUMENT_SELECTION_START_INT", 0);
        bundle.putInt("ACTION_ARGUMENT_SELECTION_END_INT", accessibilityNodeInfo.getText().length());
        boolean zPerformAction = accessibilityNodeInfo.performAction(131072, bundle);
        accessibilityNodeInfo.recycle();
        return zPerformAction;
    }

    @Override // defpackage.g1
    public final void g() {
        try {
            if (o(n(this.f))) {
                return;
            }
            AsyncTask.execute(new lk0(7, this));
        } catch (Exception unused) {
        }
    }
}
