package defpackage;

import android.accessibilityservice.GestureDescription;
import android.graphics.Path;
import android.graphics.Point;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class mt0 extends g1 {
    public static final l3 o = new l3(mt0.class, R.string.action_category_quick_cursor, R.string.action_value_realtime_gesture, R.string.action_title_realtime_gesture, R.string.action_detail_realtime_gesture, R.drawable.icon_action_realtime_gesture, 31, 32768, Boolean.FALSE, null, null);
    public GestureDescription.StrokeDescription k;
    public boolean l;
    public Point m;
    public final lt0 n;

    public mt0() {
        super(i3.empty, e1.continuousAfterPositioned);
        this.l = false;
        this.m = null;
        this.n = new lt0(this);
    }

    public static void m(String str) {
        si0.b("RealtimeGestureAction error: ".concat(str));
        r60.i.o();
        r60.c.invalidate();
    }

    @Override // defpackage.g1
    public final void e() {
        if (this.l || this.a.equals(this.m)) {
            return;
        }
        GestureDescription.Builder builder = new GestureDescription.Builder();
        Path path = new Path();
        Point point = this.m;
        path.moveTo(point.x, point.y);
        Point point2 = this.a;
        path.lineTo(point2.x, point2.y);
        GestureDescription.StrokeDescription strokeDescriptionContinueStroke = this.k.continueStroke(path, 0L, 1L, true);
        this.k = strokeDescriptionContinueStroke;
        builder.addStroke(strokeDescriptionContinueStroke);
        this.m = new Point(this.a);
        this.l = true;
        if (l60.i(this.f, builder.build(), this.n)) {
            return;
        }
        m("onCursorMove");
    }

    @Override // defpackage.g1
    public final void g() {
        r60.i.n();
        r60.c.invalidate();
        Path path = new Path();
        Point point = this.a;
        path.moveTo(point.x, point.y);
        Point point2 = this.a;
        path.lineTo(point2.x, point2.y);
        this.k = c0.d(path);
        this.m = new Point(this.a);
        GestureDescription.Builder builder = new GestureDescription.Builder();
        builder.addStroke(this.k);
        this.l = true;
        if (l60.i(this.f, builder.build(), this.n)) {
            return;
        }
        m("onDispatch");
    }

    @Override // defpackage.g1
    public final void h() {
        if (this.l) {
            b61.b(new lk0(6, this), 1L);
            return;
        }
        GestureDescription.Builder builder = new GestureDescription.Builder();
        Path path = new Path();
        Point point = this.m;
        path.moveTo(point.x, point.y);
        Point point2 = this.a;
        path.lineTo(point2.x, point2.y);
        GestureDescription.StrokeDescription strokeDescriptionContinueStroke = this.k.continueStroke(path, 0L, 1L, false);
        this.k = strokeDescriptionContinueStroke;
        builder.addStroke(strokeDescriptionContinueStroke);
        this.m = new Point(this.a);
        this.l = true;
        if (!l60.i(this.f, builder.build(), this.n)) {
            m("onEnd");
        }
        r60.i.o();
        r60.c.invalidate();
    }
}
