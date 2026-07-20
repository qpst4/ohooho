package defpackage;

import com.quickcursor.android.drawables.globals.trackers.TrackerDrawable;
import com.quickcursor.android.services.CursorAccessibilityService;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class m71 {
    public final ar a;
    public final CursorAccessibilityService b;
    public boolean c;
    public List d;
    public j71 e;
    public boolean f;
    public g1 g;
    public int h;

    public m71(ar arVar, CursorAccessibilityService cursorAccessibilityService) {
        this.a = arVar;
        this.b = cursorAccessibilityService;
    }

    public final boolean a() {
        g1 g1Var;
        g1 g1Var2;
        if (this.g == null) {
            return false;
        }
        TrackerDrawable trackerDrawable = r60.h;
        int i = trackerDrawable.H;
        trackerDrawable.r(trackerDrawable.i, trackerDrawable.j);
        r60.c.invalidate();
        g1 g1Var3 = this.g;
        ar arVar = this.a;
        if (g1Var3 != null && g1Var3.l() && this.g.d()) {
            this.g.c();
            this.g = null;
            if (this.f) {
                arVar.o();
                return true;
            }
        } else {
            if (i != this.h || (g1Var = this.g) == null || g1Var.l()) {
                return false;
            }
            f01.R(this.c);
            this.g.b(true, true);
            if (this.f && (g1Var2 = this.g) != null && g1Var2.h == f1.ended) {
                arVar.o();
            }
        }
        return true;
    }
}
