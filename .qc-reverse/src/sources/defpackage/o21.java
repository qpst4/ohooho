package defpackage;

import android.graphics.Point;
import com.quickcursor.R;
import com.quickcursor.android.drawables.globals.EdgeActionsDrawable;
import com.quickcursor.android.services.CursorAccessibilityService;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class o21 extends g1 {
    public static final l3 l = new l3(o21.class, R.string.action_category_quick_cursor, R.string.action_value_start_gesture_recorder, R.string.action_title_start_gesture_recorder, R.string.action_detail_start_gesture_recorder, R.drawable.icon_action_start_gesture_recorder, 31, 16384, Boolean.FALSE, null, null);
    public j60 k;

    public o21() {
        super(i3.empty, e1.continuousAfterPositioned);
    }

    @Override // defpackage.g1
    public final void e() {
        j60 j60Var = this.k;
        if (j60Var != null) {
            Point point = this.a;
            int i = point.x;
            int i2 = point.y;
            t51 t51Var = j60Var.d;
            t51Var.a = i;
            t51Var.b = i2;
        }
    }

    @Override // defpackage.g1
    public final void g() {
        n();
    }

    @Override // defpackage.g1
    public final void h() {
        j60 j60Var = this.k;
        Point point = this.a;
        int i = point.x;
        int i2 = point.y;
        j60Var.b.cancel(false);
        t51 t51Var = j60Var.d;
        t51Var.a = i;
        t51Var.b = i2;
        long jCurrentTimeMillis = System.currentTimeMillis() - j60Var.c;
        t51 t51Var2 = j60Var.d;
        t51Var2.c = (int) jCurrentTimeMillis;
        if (jCurrentTimeMillis == 0) {
            j60Var.a.remove(t51Var2);
        }
        CursorAccessibilityService.q.o.z();
        CursorAccessibilityService cursorAccessibilityService = this.f;
        CopyOnWriteArrayList copyOnWriteArrayList = this.k.a;
        lk0 lk0Var = new lk0(9, this);
        pn0 pn0Var = l60.a;
        new ko(cursorAccessibilityService, copyOnWriteArrayList, lk0Var);
    }

    @Override // defpackage.g1
    public final void i() {
        n();
    }

    public final void m() {
        this.h = f1.ended;
        j60 j60Var = this.k;
        if (j60Var != null) {
            j60Var.b.cancel(false);
            j60Var.a.clear();
            r60.l = null;
            r60.i.o();
            EdgeActionsDrawable edgeActionsDrawable = r60.n;
            if (edgeActionsDrawable != null) {
                edgeActionsDrawable.k = edgeActionsDrawable.i;
                Iterator it = edgeActionsDrawable.j.iterator();
                while (it.hasNext()) {
                    ((sw) it.next()).k = 0.0f;
                }
                Iterator it2 = edgeActionsDrawable.k.iterator();
                while (it2.hasNext()) {
                    ((sw) it2.next()).k = 0.0f;
                }
            }
            r60.c.invalidate();
            this.k = null;
        }
        CursorAccessibilityService.q.o.n();
    }

    public final void n() {
        ar arVar = CursorAccessibilityService.q.o;
        arVar.n = this;
        arVar.G(ar.q);
        CursorAccessibilityService.q.o.C();
        if (this.k == null) {
            Point point = this.a;
            this.k = new j60(point.x, point.y);
        }
    }
}
