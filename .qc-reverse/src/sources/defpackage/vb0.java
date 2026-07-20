package defpackage;

import android.graphics.Point;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class vb0 extends g1 {
    public static final l3 k = new l3(vb0.class, R.string.action_category_quick_cursor, R.string.action_value_input_dispatcher_bug, R.string.action_title_input_dispatcher_bug, R.string.action_detail_input_dispatcher_bug, R.drawable.icon_action_multi_tap, 31, 0, Boolean.FALSE, null, null);

    public vb0() {
        super(i3.empty, e1.onReleaseAndPositioned);
    }

    @Override // defpackage.g1
    public final void g() {
        Point point = this.a;
        l60.b(point.x, point.y, 2);
    }
}
