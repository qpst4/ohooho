package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.quickcursor.R;
import com.quickcursor.android.activities.settings.EdgeActionsSettings;
import com.quickcursor.android.views.settings.ActionsRecyclerView;
import com.quickcursor.android.views.settings.EdgeBarLinearLayout;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class rw extends j30 implements bx, z3 {
    public final dx Y;
    public final String Z;
    public final zw a0;
    public View b0;
    public ActionsRecyclerView c0;

    public rw(String str, dx dxVar, zw zwVar) {
        this.Z = str;
        this.Y = dxVar;
        this.a0 = zwVar;
    }

    @Override // defpackage.j30
    public final View K(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        int i;
        i = 0;
        NestedScrollView nestedScrollView = (NestedScrollView) layoutInflater.inflate(R.layout.actions_recycler_list_fragment, viewGroup, false);
        TextView textView = (TextView) nestedScrollView.findViewById(android.R.id.title);
        String str = this.Z;
        str.getClass();
        switch (str) {
            case "bottom":
                i = R.string.edge_actions_bar_title_bottom;
                break;
            case "top":
                i = R.string.edge_actions_bar_title_top;
                break;
            case "left":
                i = R.string.edge_actions_bar_title_left;
                break;
            case "right":
                i = R.string.edge_actions_bar_title_right;
                break;
        }
        textView.setText(lc1.K(i));
        ActionsRecyclerView actionsRecyclerView = (ActionsRecyclerView) nestedScrollView.findViewById(R.id.recycler_view);
        this.c0 = actionsRecyclerView;
        actionsRecyclerView.i0(this.Y.d(), this);
        this.b0 = nestedScrollView.findViewById(R.id.add_action);
        h0();
        xr.I(this.b0, zq0.b.c());
        return nestedScrollView;
    }

    @Override // defpackage.z3
    public final void e() {
        h0();
        ((EdgeActionsSettings) Z()).L(this.Y);
    }

    @Override // defpackage.bx
    public final Runnable f() {
        return this.a0;
    }

    @Override // defpackage.z3
    public final void g(int i) {
        EdgeBarLinearLayout edgeBarLinearLayout = ((EdgeActionsSettings) Z()).J(this.Y).E;
        edgeBarLinearLayout.getClass();
        try {
            edgeBarLinearLayout.getChildAt(i).performLongClick();
        } catch (Exception unused) {
        }
    }

    @Override // defpackage.z3
    public final void h(int i) {
        EdgeBarLinearLayout edgeBarLinearLayout = ((EdgeActionsSettings) Z()).J(this.Y).E;
        edgeBarLinearLayout.getClass();
        try {
            edgeBarLinearLayout.getChildAt(i).performClick();
        } catch (Exception unused) {
        }
    }

    public final void h0() {
        int iC = this.Y.c();
        View view = this.b0;
        if (iC < 10) {
            view.setOnClickListener(new a3(8, this));
            xr.I(this.b0, true);
        } else {
            view.setOnClickListener(null);
            xr.I(this.b0, false);
        }
    }

    @Override // defpackage.bx
    public final String i() {
        int i;
        String str = this.Z;
        str.getClass();
        i = 0;
        switch (str) {
            case "bottom":
                i = R.string.edge_actions_bar_subtitle_bottom;
                break;
            case "top":
                i = R.string.edge_actions_bar_subtitle_top;
                break;
            case "left":
                i = R.string.edge_actions_bar_subtitle_left;
                break;
            case "right":
                i = R.string.edge_actions_bar_subtitle_right;
                break;
        }
        return lc1.K(i);
    }

    @Override // defpackage.z3
    public final void j(int i) {
        EdgeBarLinearLayout edgeBarLinearLayout = ((EdgeActionsSettings) Z()).J(this.Y).E;
        edgeBarLinearLayout.getClass();
        try {
            edgeBarLinearLayout.getChildAt(i).performLongClick();
        } catch (Exception unused) {
        }
    }

    @Override // defpackage.bx
    public final j30 b() {
        return this;
    }
}
