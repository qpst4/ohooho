package defpackage;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class vo extends g1 {
    public static final wa k;
    public static final l3 l;

    static {
        wa waVar = new wa();
        waVar.put("copyMode", uo.clipboard.toString());
        k = waVar;
        l = new l3(vo.class, R.string.action_category_general, R.string.action_value_copy, R.string.action_title_copy, R.string.action_detail_copy, R.drawable.icon_action_copy, 31, 0, Boolean.TRUE, new s1(23), null);
    }

    public vo() {
        super(i3.empty, e1.onReleaseAndPositioned);
    }

    public static String m(AccessibilityNodeInfo accessibilityNodeInfo, int i, int i2) {
        if (accessibilityNodeInfo == null) {
            return null;
        }
        Rect rect = new Rect();
        accessibilityNodeInfo.getBoundsInScreen(rect);
        if (rect.contains(i, i2)) {
            int childCount = accessibilityNodeInfo.getChildCount();
            if (childCount > 0) {
                for (int i3 = 0; i3 < childCount; i3++) {
                    String strM = m(accessibilityNodeInfo.getChild(i3), i, i2);
                    if (strM != null) {
                        return strM;
                    }
                }
            }
            CharSequence text = accessibilityNodeInfo.getText();
            if (text != null && text.length() > 0) {
                accessibilityNodeInfo.recycle();
                return text.toString();
            }
            CharSequence contentDescription = accessibilityNodeInfo.getContentDescription();
            if (contentDescription != null && contentDescription.length() > 0) {
                accessibilityNodeInfo.recycle();
                return contentDescription.toString();
            }
        }
        accessibilityNodeInfo.recycle();
        return null;
    }

    @Override // defpackage.g1
    public final void g() {
        uo uoVarValueOf;
        Point point = this.a;
        int i = point.x;
        int i2 = point.y;
        if (pn0.t().D()) {
            r60.h(pn0.t().x(), i, i2);
        }
        try {
            String strN = n(i, i2);
            if (strN != null && strN.length() > 0) {
                try {
                    uoVarValueOf = uo.valueOf((String) this.g.get("copyMode"));
                } catch (Exception unused) {
                    uoVarValueOf = uo.clipboard;
                }
                if (uoVarValueOf == uo.clipboard) {
                    ClipboardManager clipboardManager = (ClipboardManager) this.f.getSystemService("clipboard");
                    ClipData clipDataNewPlainText = ClipData.newPlainText("clipboard", strN);
                    if (clipboardManager != null && clipDataNewPlainText != null) {
                        clipboardManager.setPrimaryClip(clipDataNewPlainText);
                        return;
                    }
                    yb0.y(R.string.action_copy_couldnt_save_to_clipboard, 0);
                    return;
                }
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.TEXT", strN);
                Intent intentCreateChooser = Intent.createChooser(intent, "");
                intentCreateChooser.setFlags(268435456);
                this.f.startActivity(intentCreateChooser);
                return;
            }
        } catch (Exception e) {
            si0.a("Exception: " + e);
        }
        si0.a("Couldn't copy text from cursor position.");
        yb0.y(R.string.action_copy_couldnt_copy, 0);
    }

    public final String n(int i, int i2) {
        String strM;
        Rect rect = new Rect();
        for (AccessibilityWindowInfo accessibilityWindowInfo : this.f.getWindows()) {
            accessibilityWindowInfo.getBoundsInScreen(rect);
            if (rect.contains(i, i2) && (strM = m(accessibilityWindowInfo.getRoot(), i, i2)) != null) {
                accessibilityWindowInfo.recycle();
                return strM;
            }
            accessibilityWindowInfo.recycle();
        }
        return m(this.f.getRootInActiveWindow(), i, i2);
    }
}
