package defpackage;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.chip.Chip;
import com.quickcursor.R;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class gk extends y {
    public static final Rect o = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    public static final ix p = new ix(17);
    public static final c70 q = new c70(17);
    public final AccessibilityManager h;
    public final Chip i;
    public o00 j;
    public final /* synthetic */ Chip n;
    public final Rect d = new Rect();
    public final Rect e = new Rect();
    public final Rect f = new Rect();
    public final int[] g = new int[2];
    public int k = Integer.MIN_VALUE;
    public int l = Integer.MIN_VALUE;
    public int m = Integer.MIN_VALUE;

    public gk(Chip chip, Chip chip2) {
        this.n = chip;
        this.i = chip2;
        this.h = (AccessibilityManager) chip2.getContext().getSystemService("accessibility");
        chip2.setFocusable(true);
        WeakHashMap weakHashMap = uf1.a;
        if (chip2.getImportantForAccessibility() == 0) {
            chip2.setImportantForAccessibility(1);
        }
    }

    @Override // defpackage.y
    public final sp1 b(View view) {
        if (this.j == null) {
            this.j = new o00(this);
        }
        return this.j;
    }

    @Override // defpackage.y
    public final void d(View view, n0 n0Var) {
        AccessibilityNodeInfo accessibilityNodeInfo = n0Var.a;
        this.a.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        Chip chip = this.n;
        hk hkVar = chip.f;
        accessibilityNodeInfo.setCheckable(hkVar != null && hkVar.R);
        accessibilityNodeInfo.setClickable(chip.isClickable());
        n0Var.i(chip.getAccessibilityClassName());
        n0Var.l(chip.getText());
    }

    public final boolean j(int i) {
        if (this.l != i) {
            return false;
        }
        this.l = Integer.MIN_VALUE;
        if (i == 1) {
            Chip chip = this.n;
            chip.n = false;
            chip.refreshDrawableState();
        }
        p(i, 8);
        return true;
    }

    public final n0 k(int i) {
        AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain();
        n0 n0Var = new n0(accessibilityNodeInfoObtain);
        accessibilityNodeInfoObtain.setEnabled(true);
        accessibilityNodeInfoObtain.setFocusable(true);
        n0Var.i("android.view.View");
        Rect rect = o;
        accessibilityNodeInfoObtain.setBoundsInParent(rect);
        accessibilityNodeInfoObtain.setBoundsInScreen(rect);
        Chip chip = this.i;
        accessibilityNodeInfoObtain.setParent(chip);
        AccessibilityNodeInfo accessibilityNodeInfo = n0Var.a;
        if (i == 1) {
            Chip chip2 = this.n;
            CharSequence closeIconContentDescription = chip2.getCloseIconContentDescription();
            if (closeIconContentDescription != null) {
                accessibilityNodeInfo.setContentDescription(closeIconContentDescription);
            } else {
                CharSequence text = chip2.getText();
                accessibilityNodeInfo.setContentDescription(chip2.getContext().getString(R.string.mtrl_chip_close_icon_content_description, TextUtils.isEmpty(text) ? "" : text).trim());
            }
            accessibilityNodeInfo.setBoundsInParent(chip2.getCloseIconTouchBoundsInt());
            n0Var.b(h0.e);
            accessibilityNodeInfo.setEnabled(chip2.isEnabled());
        } else {
            accessibilityNodeInfo.setContentDescription("");
            accessibilityNodeInfo.setBoundsInParent(Chip.x);
        }
        if (n0Var.g() == null && accessibilityNodeInfoObtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        Rect rect2 = this.e;
        n0Var.f(rect2);
        if (rect2.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int actions = accessibilityNodeInfoObtain.getActions();
        if ((actions & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((actions & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        accessibilityNodeInfoObtain.setPackageName(chip.getContext().getPackageName());
        n0Var.b = i;
        accessibilityNodeInfoObtain.setSource(chip, i);
        if (this.k == i) {
            accessibilityNodeInfoObtain.setAccessibilityFocused(true);
            n0Var.a(128);
        } else {
            accessibilityNodeInfoObtain.setAccessibilityFocused(false);
            n0Var.a(64);
        }
        boolean z = this.l == i;
        if (z) {
            n0Var.a(2);
        } else if (accessibilityNodeInfoObtain.isFocusable()) {
            n0Var.a(1);
        }
        accessibilityNodeInfoObtain.setFocused(z);
        int[] iArr = this.g;
        chip.getLocationOnScreen(iArr);
        Rect rect3 = this.d;
        accessibilityNodeInfoObtain.getBoundsInScreen(rect3);
        if (rect3.equals(rect)) {
            n0Var.f(rect3);
            rect3.offset(iArr[0] - chip.getScrollX(), iArr[1] - chip.getScrollY());
        }
        Rect rect4 = this.f;
        if (chip.getLocalVisibleRect(rect4)) {
            rect4.offset(iArr[0] - chip.getScrollX(), iArr[1] - chip.getScrollY());
            if (rect3.intersect(rect4)) {
                accessibilityNodeInfoObtain.setBoundsInScreen(rect3);
                if (!rect3.isEmpty() && chip.getWindowVisibility() == 0) {
                    Object parent = chip.getParent();
                    while (true) {
                        if (parent instanceof View) {
                            View view = (View) parent;
                            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                                break;
                            }
                            parent = view.getParent();
                        } else if (parent != null) {
                            accessibilityNodeInfoObtain.setVisibleToUser(true);
                        }
                    }
                }
            }
        }
        return n0Var;
    }

    public final void l(ArrayList arrayList) {
        hk hkVar;
        arrayList.add(0);
        Rect rect = Chip.x;
        Chip chip = this.n;
        if (!chip.c() || (hkVar = chip.f) == null || !hkVar.L || chip.i == null) {
            return;
        }
        arrayList.add(1);
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x0154  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean m(int r21, android.graphics.Rect r22) {
        /*
            Method dump skipped, instruction units count: 499
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gk.m(int, android.graphics.Rect):boolean");
    }

    public final n0 n(int i) {
        if (i != -1) {
            return k(i);
        }
        Chip chip = this.i;
        AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(chip);
        n0 n0Var = new n0(accessibilityNodeInfoObtain);
        WeakHashMap weakHashMap = uf1.a;
        chip.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoObtain);
        ArrayList arrayList = new ArrayList();
        l(arrayList);
        if (accessibilityNodeInfoObtain.getChildCount() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            n0Var.a.addChild(chip, ((Integer) arrayList.get(i2)).intValue());
        }
        return n0Var;
    }

    public final boolean o(int i) {
        int i2;
        Chip chip = this.i;
        if ((!chip.isFocused() && !chip.requestFocus()) || (i2 = this.l) == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            j(i2);
        }
        if (i == Integer.MIN_VALUE) {
            return false;
        }
        this.l = i;
        if (i == 1) {
            Chip chip2 = this.n;
            chip2.n = true;
            chip2.refreshDrawableState();
        }
        p(i, 8);
        return true;
    }

    public final void p(int i, int i2) {
        View view;
        ViewParent parent;
        AccessibilityEvent accessibilityEventObtain;
        if (i == Integer.MIN_VALUE || !this.h.isEnabled() || (parent = (view = this.i).getParent()) == null) {
            return;
        }
        if (i != -1) {
            accessibilityEventObtain = AccessibilityEvent.obtain(i2);
            n0 n0VarN = n(i);
            accessibilityEventObtain.getText().add(n0VarN.g());
            AccessibilityNodeInfo accessibilityNodeInfo = n0VarN.a;
            accessibilityEventObtain.setContentDescription(accessibilityNodeInfo.getContentDescription());
            accessibilityEventObtain.setScrollable(accessibilityNodeInfo.isScrollable());
            accessibilityEventObtain.setPassword(accessibilityNodeInfo.isPassword());
            accessibilityEventObtain.setEnabled(accessibilityNodeInfo.isEnabled());
            accessibilityEventObtain.setChecked(accessibilityNodeInfo.isChecked());
            if (accessibilityEventObtain.getText().isEmpty() && accessibilityEventObtain.getContentDescription() == null) {
                throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
            }
            accessibilityEventObtain.setClassName(accessibilityNodeInfo.getClassName());
            accessibilityEventObtain.setSource(view, i);
            accessibilityEventObtain.setPackageName(view.getContext().getPackageName());
        } else {
            accessibilityEventObtain = AccessibilityEvent.obtain(i2);
            view.onInitializeAccessibilityEvent(accessibilityEventObtain);
        }
        parent.requestSendAccessibilityEvent(view, accessibilityEventObtain);
    }
}
