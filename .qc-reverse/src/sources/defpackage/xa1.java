package defpackage;

import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.quickcursor.R;
import com.quickcursor.android.services.CursorAccessibilityService;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class xa1 {
    public boolean a;
    public Object b;
    public Object c;
    public Serializable d = new HashMap();
    public Object e;

    public xa1(boolean z) {
        this.a = z;
        e();
    }

    public static void i(View view, db dbVar) {
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) view.getLayoutParams();
        layoutParams.width = dbVar.f();
        layoutParams.height = dbVar.c();
        layoutParams.x = dbVar.d();
        layoutParams.y = dbVar.e();
    }

    public HashMap a(f91 f91Var) {
        HashMap map = new HashMap();
        boolean zEquals = f91Var.g().equals("Floating");
        CursorAccessibilityService cursorAccessibilityService = (CursorAccessibilityService) this.c;
        if (zEquals) {
            String string = cursorAccessibilityService.getString(R.string.preview_area_snap);
            int i = dn.i0;
            map.put("snapLeft", b(string, i));
            map.put("snapRight", b(((CursorAccessibilityService) this.c).getString(R.string.preview_area_snap), i));
        } else {
            map.put("trigger", b(cursorAccessibilityService.getString(R.string.preview_area_trigger), dn.i0));
        }
        if (!this.a) {
            map.put("move", b(((CursorAccessibilityService) this.c).getString(R.string.preview_area_tracker), dn.j0));
            map.put("cursor", b(((CursorAccessibilityService) this.c).getString(R.string.preview_area_cursor), dn.k0));
        }
        for (View view : map.values()) {
            try {
                ((WindowManager) this.b).addView(view, view.getLayoutParams());
            } catch (Exception unused) {
                si0.a("TriggersOverlayView createAndAddViews exception.");
            }
        }
        return map;
    }

    public TextView b(String str, int i) {
        TextView textView = new TextView((CursorAccessibilityService) this.c);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(0, 0, 2032, 792, -3);
        layoutParams.gravity = 51;
        layoutParams.x = 0;
        layoutParams.y = 0;
        if (Build.VERSION.SDK_INT >= 29) {
            textView.setForceDarkAllowed(false);
        }
        textView.setLayoutParams(layoutParams);
        textView.setBackgroundColor(i);
        textView.setText(str);
        textView.setTextColor(Color.argb(30, 255, 255, 255));
        textView.setGravity(17);
        return textView;
    }

    public void c(Integer num, f91 f91Var) {
        HashMap map = (HashMap) this.d;
        if (f91Var == null) {
            return;
        }
        try {
            if (!map.containsKey(num)) {
                map.put(num, a(f91Var));
            }
            j((Map) map.get(num), f91Var);
        } catch (Exception e) {
            si0.a("drawTrigger exception: " + e);
            yb0.A(R.string.general_error_toast);
        }
    }

    public void d(Integer num, f91 f91Var) {
        try {
            b61 b61Var = (b61) this.e;
            if (b61Var != null) {
                b61Var.a();
            } else {
                si0.a("drawTriggerWithTimeout clearTimer null");
                yb0.A(R.string.general_error_toast);
            }
            c(num, f91Var);
        } catch (Exception e) {
            si0.a("drawTriggerWithTimeout exception: " + e);
            yb0.A(R.string.general_error_toast);
        }
    }

    public void e() {
        CursorAccessibilityService cursorAccessibilityService;
        if (((CursorAccessibilityService) this.c) == null && (cursorAccessibilityService = CursorAccessibilityService.q) != null) {
            this.c = cursorAccessibilityService;
            this.b = (WindowManager) cursorAccessibilityService.getSystemService("window");
            this.e = new b61(new lk0(23, this), 2000L);
        }
    }

    public void f() {
        HashMap map = (HashMap) this.d;
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            h((Map) it.next());
        }
        map.clear();
    }

    public void g(Integer num) {
        HashMap map = (HashMap) this.d;
        try {
            Map map2 = (Map) map.get(num);
            if (map2 == null) {
                return;
            }
            h(map2);
            map.remove(num);
        } catch (Exception e) {
            si0.a("removeTrigger exception: " + e);
            yb0.A(R.string.general_error_toast);
        }
    }

    public void h(Map map) {
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            try {
                ((WindowManager) this.b).removeView((View) it.next());
            } catch (Exception e) {
                si0.a("removeTriggersViews exception: " + e);
                yb0.A(R.string.general_error_toast);
            }
        }
    }

    public void j(Map map, f91 f91Var) {
        if (f91Var.g().equals("Floating")) {
            float fH = e20.H(f91Var.f());
            i((View) map.get("snapLeft"), new db(fH, ey0.b(), 0.0f, 0.0f));
            i((View) map.get("snapRight"), new db(fH, ey0.b(), ey0.c() - r0, 0.0f));
        } else {
            i((View) map.get("trigger"), f91Var.h());
        }
        if (!this.a) {
            i((View) map.get("move"), f91Var.f());
            i((View) map.get("cursor"), f91Var.c());
        }
        for (View view : map.values()) {
            ((WindowManager) this.b).updateViewLayout(view, view.getLayoutParams());
        }
    }

    public void k() {
        boolean z;
        Exception exc;
        String strConcat;
        boolean z2;
        Boolean bool;
        if (this.a) {
            synchronized (this.b) {
                z = this.a;
            }
            if (!z) {
                throw new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
            }
            synchronized (this.b) {
                exc = (Exception) this.e;
            }
            if (exc == null) {
                synchronized (this.b) {
                    z2 = false;
                    if (this.a && ((Exception) this.e) == null) {
                        z2 = true;
                    }
                }
                if (z2) {
                    synchronized (this.b) {
                        if (!this.a) {
                            throw new IllegalStateException("Task is not yet complete");
                        }
                        Exception exc2 = (Exception) this.e;
                        if (exc2 != null) {
                            throw new cm(exc2);
                        }
                        bool = (Boolean) this.d;
                    }
                    strConcat = "result ".concat(String.valueOf(bool));
                } else {
                    strConcat = "unknown issue";
                }
            } else {
                strConcat = "failure";
            }
        }
    }
}
