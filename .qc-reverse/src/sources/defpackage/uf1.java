package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.appcompat.widget.AppCompatEditText;
import com.quickcursor.R;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class uf1 {
    public static WeakHashMap a = null;
    public static Field b = null;
    public static boolean c = false;
    public static final int[] d = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
    public static final gf1 e = new gf1();
    public static final if1 f = new if1();

    public static ng1 a(View view) {
        if (a == null) {
            a = new WeakHashMap();
        }
        ng1 ng1Var = (ng1) a.get(view);
        if (ng1Var != null) {
            return ng1Var;
        }
        ng1 ng1Var2 = new ng1(view);
        a.put(view, ng1Var2);
        return ng1Var2;
    }

    public static wi1 b(View view, wi1 wi1Var) {
        WindowInsets windowInsetsG = wi1Var.g();
        if (windowInsetsG != null) {
            WindowInsets windowInsetsA = Build.VERSION.SDK_INT >= 30 ? rf1.a(view, windowInsetsG) : jf1.a(view, windowInsetsG);
            if (!windowInsetsA.equals(windowInsetsG)) {
                return wi1.h(view, windowInsetsA);
            }
        }
        return wi1Var;
    }

    public static boolean c(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList arrayList = tf1.d;
        tf1 tf1Var = (tf1) view.getTag(R.id.tag_unhandled_key_event_manager);
        if (tf1Var == null) {
            tf1Var = new tf1();
            tf1Var.a = null;
            tf1Var.b = null;
            tf1Var.c = null;
            view.setTag(R.id.tag_unhandled_key_event_manager, tf1Var);
        }
        if (keyEvent.getAction() == 0) {
            WeakHashMap weakHashMap = tf1Var.a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList arrayList2 = tf1.d;
            if (!arrayList2.isEmpty()) {
                synchronized (arrayList2) {
                    try {
                        if (tf1Var.a == null) {
                            tf1Var.a = new WeakHashMap();
                        }
                        for (int size = arrayList2.size() - 1; size >= 0; size--) {
                            ArrayList arrayList3 = tf1.d;
                            View view2 = (View) ((WeakReference) arrayList3.get(size)).get();
                            if (view2 == null) {
                                arrayList3.remove(size);
                            } else {
                                tf1Var.a.put(view2, Boolean.TRUE);
                                for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                    tf1Var.a.put((View) parent, Boolean.TRUE);
                                }
                            }
                        }
                    } finally {
                    }
                }
            }
        }
        View viewA = tf1Var.a(view);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (viewA != null && !KeyEvent.isModifierKey(keyCode)) {
                if (tf1Var.b == null) {
                    tf1Var.b = new SparseArray();
                }
                tf1Var.b.put(keyCode, new WeakReference(viewA));
            }
        }
        return viewA != null;
    }

    public static View.AccessibilityDelegate d(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return qf1.a(view);
        }
        if (c) {
            return null;
        }
        if (b == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                b = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                c = true;
                return null;
            }
        }
        try {
            Object obj = b.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            c = true;
            return null;
        }
    }

    public static CharSequence e(View view) {
        Object tag;
        if (Build.VERSION.SDK_INT >= 28) {
            tag = pf1.a(view);
        } else {
            tag = view.getTag(R.id.tag_accessibility_pane_title);
            if (!CharSequence.class.isInstance(tag)) {
                tag = null;
            }
        }
        return (CharSequence) tag;
    }

    public static ArrayList f(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_accessibility_actions);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(R.id.tag_accessibility_actions, arrayList2);
        return arrayList2;
    }

    public static String[] g(AppCompatEditText appCompatEditText) {
        return Build.VERSION.SDK_INT >= 31 ? sf1.a(appCompatEditText) : (String[]) appCompatEditText.getTag(R.id.tag_on_receive_content_mime_types);
    }

    public static void h(View view, int i) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z = e(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(i);
                if (z) {
                    accessibilityEventObtain.getText().add(e(view));
                    if (view.getImportantForAccessibility() == 0) {
                        view.setImportantForAccessibility(1);
                    }
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i != 32) {
                if (view.getParent() != null) {
                    try {
                        view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i);
                        return;
                    } catch (AbstractMethodError e2) {
                        Log.e("ViewCompat", view.getParent().getClass().getSimpleName().concat(" does not fully implement ViewParent"), e2);
                        return;
                    }
                }
                return;
            }
            AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
            view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.setEventType(32);
            accessibilityEventObtain2.setContentChangeTypes(i);
            accessibilityEventObtain2.setSource(view);
            view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.getText().add(e(view));
            accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
        }
    }

    public static wi1 i(View view, wi1 wi1Var) {
        WindowInsets windowInsetsG = wi1Var.g();
        if (windowInsetsG != null) {
            WindowInsets windowInsetsB = jf1.b(view, windowInsetsG);
            if (!windowInsetsB.equals(windowInsetsG)) {
                return wi1.h(view, windowInsetsB);
            }
        }
        return wi1Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static go j(View view, go goVar) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + goVar + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return sf1.b(view, goVar);
        }
        g51 g51Var = (g51) view.getTag(R.id.tag_on_receive_content_listener);
        eo0 eo0Var = e;
        if (g51Var == null) {
            if (view instanceof eo0) {
                eo0Var = (eo0) view;
            }
            return eo0Var.a(goVar);
        }
        go goVarA = g51.a(view, goVar);
        if (goVarA == null) {
            return null;
        }
        if (view instanceof eo0) {
            eo0Var = (eo0) view;
        }
        return eo0Var.a(goVarA);
    }

    public static void k(View view, int i) {
        ArrayList arrayListF = f(view);
        for (int i2 = 0; i2 < arrayListF.size(); i2++) {
            if (((h0) arrayListF.get(i2)).a() == i) {
                arrayListF.remove(i2);
                return;
            }
        }
    }

    public static void l(View view, h0 h0Var, a1 a1Var) {
        h0 h0Var2 = new h0(null, h0Var.b, null, a1Var, h0Var.c);
        View.AccessibilityDelegate accessibilityDelegateD = d(view);
        y yVar = accessibilityDelegateD == null ? null : accessibilityDelegateD instanceof x ? ((x) accessibilityDelegateD).a : new y(accessibilityDelegateD);
        if (yVar == null) {
            yVar = new y();
        }
        n(view, yVar);
        k(view, h0Var2.a());
        f(view).add(h0Var2);
        h(view, 0);
    }

    public static void m(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            qf1.b(view, context, iArr, attributeSet, typedArray, i, 0);
        }
    }

    public static void n(View view, y yVar) {
        if (yVar == null && (d(view) instanceof x)) {
            yVar = new y();
        }
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
        view.setAccessibilityDelegate(yVar == null ? null : yVar.b);
    }

    public static void o(View view, CharSequence charSequence) {
        new hf1(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28, 1).d(view, charSequence);
        if1 if1Var = f;
        if (charSequence == null) {
            if1Var.b.remove(view);
            view.removeOnAttachStateChangeListener(if1Var);
            view.getViewTreeObserver().removeOnGlobalLayoutListener(if1Var);
        } else {
            if1Var.b.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(if1Var);
            if (view.isAttachedToWindow()) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(if1Var);
            }
        }
    }
}
