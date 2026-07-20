package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.quickcursor.R;
import com.quickcursor.android.activities.settings.TrackerActionsSettings;
import com.quickcursor.android.views.settings.ActionsRecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class p71 extends j30 implements z3 {
    public final List Y = s71.e.c;
    public View Z;
    public ActionsRecyclerView a0;

    @Override // defpackage.j30
    public final View K(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        ((TrackerActionsSettings) Z()).L(-1);
        NestedScrollView nestedScrollView = (NestedScrollView) layoutInflater.inflate(R.layout.actions_recycler_list_fragment, viewGroup, false);
        ((TextView) nestedScrollView.findViewById(android.R.id.title)).setText(R.string.tracker_actions_list_title);
        ActionsRecyclerView actionsRecyclerView = (ActionsRecyclerView) nestedScrollView.findViewById(R.id.recycler_view);
        this.a0 = actionsRecyclerView;
        actionsRecyclerView.i0(this.Y, this);
        this.Z = nestedScrollView.findViewById(R.id.add_action);
        h0();
        xr.I(this.Z, zq0.b.c());
        return nestedScrollView;
    }

    @Override // defpackage.z3
    public final void e() {
        h0();
        s71.e.c();
        pn0.t().getClass();
        pn0.V();
        ((TrackerActionsSettings) Z()).K();
    }

    @Override // defpackage.z3
    public final void g(int i) {
        ((TrackerActionsSettings) Z()).H((j71) this.Y.get(i));
    }

    @Override // defpackage.z3
    public final void h(int i) {
        r2.o0(l(), n3.b(2), new ArrayList(), Arrays.asList(n3.nothing, n3.gestureSwipe, n3.expandNotifications, n3.expandQuickSettings, n3.temporarilyDisable, n3.takeScreenshot, n3.multiTap), new o01(i, 2, this));
    }

    public final void h0() {
        if (this.Y.size() >= 15 || !zq0.b.c()) {
            this.Z.setOnClickListener(null);
            xr.I(this.Z, false);
        } else {
            this.Z.setOnClickListener(new a3(15, this));
            xr.I(this.Z, true);
        }
    }

    @Override // defpackage.z3
    public final void j(int i) {
        ((TrackerActionsSettings) Z()).H((j71) this.Y.get(i));
    }
}
