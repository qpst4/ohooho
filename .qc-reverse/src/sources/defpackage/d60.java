package defpackage;

import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class d60 extends g1 {
    public static final l3 k = new l3(d60.class, R.string.action_category_gestures, R.string.action_value_gesture_open_app_menu, R.string.action_title_gesture_open_app_menu, R.string.action_detail_gesture_open_app_menu, R.drawable.icon_action_gesture_open_app_menu, 31, 1, Boolean.FALSE, null, null);

    public d60() {
        super(i3.onRelease, e1.instant);
    }

    @Override // defpackage.g1
    public final void g() {
        int iC = ey0.c();
        boolean z = this.a.x < iC / 2;
        o60.m(this.f, z ? 0 : iC - 1, ey0.b() / 4, z ? m60.RIGHT : m60.LEFT, n60.LONG, 75, 1);
    }
}
