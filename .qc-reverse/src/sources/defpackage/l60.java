package defpackage;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Path;
import android.graphics.Rect;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import android.widget.LinearLayout;
import com.quickcursor.App;
import com.quickcursor.R;
import com.quickcursor.android.services.CursorAccessibilityService;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class l60 extends AccessibilityService.GestureResultCallback {
    public static final pn0 a = pn0.t();
    public static final lc b;
    public static GestureDescription.StrokeDescription c;
    public static final k60 d;

    static {
        lc lcVar = new lc();
        lcVar.a = 25L;
        lcVar.c = 0L;
        lcVar.b = 0L;
        b = lcVar;
        d = new k60();
    }

    public static void a(AccessibilityService accessibilityService, int i, int i2, boolean z) {
        DisplayMetrics displayMetrics = ey0.a;
        if (i < 0 || i2 < 0 || i > ey0.c() || i2 > ey0.b()) {
            return;
        }
        if (oq0.a((SharedPreferences) a.d, oq0.M0)) {
            f(accessibilityService, 16, i, i2);
            return;
        }
        GestureDescription.Builder builder = new GestureDescription.Builder();
        Path path = new Path();
        float f = i;
        float f2 = i2;
        path.moveTo(f, f2);
        path.lineTo(f, f2);
        builder.addStroke(new GestureDescription.StrokeDescription(path, 0L, 5L));
        h(accessibilityService, builder.build(), z);
    }

    public static void b(int i, int i2, int i3) {
        if (i3 > 6) {
            si0.b("inputDispatcherBugActionDispatch abandon. Couldn't fix the issue with 6 multi taps.");
            return;
        }
        try {
            j81 j81Var = new j81(i, i2, i3);
            si0.a("inputDispatcherBugActionDispatch(" + j81Var + ")");
            CursorAccessibilityService.q.o.e.b(new zy(3), j81Var);
            c(j81Var);
        } catch (Exception e) {
            si0.a("inputDispatcherBugActionDispatch crash: " + e);
        }
    }

    public static void c(j81 j81Var) {
        ar arVar = CursorAccessibilityService.q.o;
        if (arVar != null) {
            arVar.z();
        }
        GestureDescription.Builder builder = new GestureDescription.Builder();
        int i = j81Var.b;
        int i2 = j81Var.c;
        Path path = new Path();
        float f = i;
        float f2 = i2;
        path.moveTo(f, f2);
        path.lineTo(f, f2);
        builder.addStroke(new GestureDescription.StrokeDescription(path, 0L, 5L));
        int i3 = i2 < ey0.b() + (-5) ? 1 : -1;
        for (int i4 = 1; i4 < j81Var.d; i4++) {
            i2 += i3;
            Path path2 = new Path();
            float f3 = i2;
            path2.moveTo(f, f3);
            path2.lineTo(f, f3);
            builder.addStroke(new GestureDescription.StrokeDescription(path2, 0L, 5L));
        }
        si0.a("inputDispatcherBugMultiTapDispatch(" + j81Var + "): " + i(CursorAccessibilityService.q, builder.build(), null));
    }

    public static GestureDescription d(GestureDescription gestureDescription) {
        int i = ey0.g;
        if (i == 0) {
            return gestureDescription;
        }
        GestureDescription.Builder builder = new GestureDescription.Builder();
        GestureDescription.StrokeDescription stroke = gestureDescription.getStroke(0);
        Path path = stroke.getPath();
        path.offset(i, 0.0f);
        GestureDescription.StrokeDescription strokeDescription = c;
        if (strokeDescription == null) {
            c = c0.e(path, stroke.getStartTime(), stroke.getDuration(), stroke.willContinue());
        } else {
            c = strokeDescription.continueStroke(path, stroke.getStartTime(), stroke.getDuration(), stroke.willContinue());
        }
        builder.addStroke(c);
        if (!c.willContinue()) {
            c = null;
        }
        return builder.build();
    }

    public static void e() {
        if (oq0.a((SharedPreferences) pn0.t().d, oq0.k)) {
            lc lcVar = b;
            lcVar.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            if (jCurrentTimeMillis - lcVar.c > lcVar.a) {
                lcVar.b = 0L;
            }
            lcVar.c = jCurrentTimeMillis;
            long j = lcVar.b + 1;
            lcVar.b = j;
            si0.b("Gesture failed. Fail counter: " + j);
            if (j >= 5) {
                WeakReference weakReference = eu.e;
                if (weakReference == null || weakReference.get() == null || !((eu) eu.e.get()).d) {
                    final eu euVar = new eu(CursorAccessibilityService.q);
                    LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) euVar.getContext().getSystemService("layout_inflater")).inflate(R.layout.dispatch_gesture_bug, (ViewGroup) null);
                    final int i = 0;
                    linearLayout.findViewById(R.id.restartAccessibilityService).setOnClickListener(new View.OnClickListener() { // from class: du
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            int i2 = i;
                            eu euVar2 = euVar;
                            switch (i2) {
                                case 0:
                                    euVar2.b();
                                    try {
                                        lc1.b0(App.c);
                                    } catch (Exception unused) {
                                        return;
                                    }
                                    break;
                                default:
                                    euVar2.b();
                                    try {
                                        Intent intentCreateChooser = Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.parse(dn.k)), lc1.K(R.string.choose_email_client_popup_title));
                                        intentCreateChooser.addFlags(268435456);
                                        App.c.startActivity(intentCreateChooser);
                                    } catch (Exception unused2) {
                                        return;
                                    }
                                    break;
                            }
                        }
                    });
                    final int i2 = 1;
                    linearLayout.findViewById(R.id.contactOnEmail).setOnClickListener(new View.OnClickListener() { // from class: du
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            int i22 = i2;
                            eu euVar2 = euVar;
                            switch (i22) {
                                case 0:
                                    euVar2.b();
                                    try {
                                        lc1.b0(App.c);
                                    } catch (Exception unused) {
                                        return;
                                    }
                                    break;
                                default:
                                    euVar2.b();
                                    try {
                                        Intent intentCreateChooser = Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.parse(dn.k)), lc1.K(R.string.choose_email_client_popup_title));
                                        intentCreateChooser.addFlags(268435456);
                                        App.c.startActivity(intentCreateChooser);
                                    } catch (Exception unused2) {
                                        return;
                                    }
                                    break;
                            }
                        }
                    });
                    euVar.a(linearLayout);
                    eu.e = new WeakReference(euVar);
                }
            }
        }
    }

    public static boolean f(AccessibilityService accessibilityService, int i, int i2, int i3) {
        Rect rect = new Rect();
        for (AccessibilityWindowInfo accessibilityWindowInfo : accessibilityService.getWindows()) {
            accessibilityWindowInfo.getBoundsInScreen(rect);
            if (rect.contains(i2, i3) && g(accessibilityWindowInfo.getRoot(), i, i2, i3)) {
                accessibilityWindowInfo.recycle();
                return true;
            }
            accessibilityWindowInfo.recycle();
        }
        return false;
    }

    public static boolean g(AccessibilityNodeInfo accessibilityNodeInfo, int i, int i2, int i3) {
        if (accessibilityNodeInfo == null) {
            return false;
        }
        Rect rect = new Rect();
        accessibilityNodeInfo.getBoundsInScreen(rect);
        if (!rect.contains(i2, i3)) {
            accessibilityNodeInfo.recycle();
            return false;
        }
        int childCount = accessibilityNodeInfo.getChildCount();
        if (childCount > 0) {
            for (int i4 = 0; i4 < childCount; i4++) {
                if (g(accessibilityNodeInfo.getChild(i4), i, i2, i3)) {
                    return true;
                }
            }
        }
        boolean zPerformAction = accessibilityNodeInfo.performAction(i);
        accessibilityNodeInfo.recycle();
        return zPerformAction;
    }

    public static void h(AccessibilityService accessibilityService, GestureDescription gestureDescription, boolean z) {
        try {
            if (App.d) {
                gestureDescription = d(gestureDescription);
            }
            if (!z) {
                accessibilityService.dispatchGesture(gestureDescription, null, null);
            } else {
                if (accessibilityService.dispatchGesture(gestureDescription, d, null)) {
                    return;
                }
                e();
            }
        } catch (Exception unused) {
            if (z) {
                e();
            }
        }
    }

    public static boolean i(AccessibilityService accessibilityService, GestureDescription gestureDescription, AccessibilityService.GestureResultCallback gestureResultCallback) {
        try {
            if (App.d) {
                gestureDescription = d(gestureDescription);
            }
            return accessibilityService.dispatchGesture(gestureDescription, gestureResultCallback, null);
        } catch (Exception unused) {
            return false;
        }
    }
}
