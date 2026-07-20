package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.tabs.TabLayout;
import com.quickcursor.R;
import com.quickcursor.android.views.VerticalTabLayout;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ma1 extends j30 {
    public TabLayout Y;
    public VerticalTabLayout Z;

    @Override // defpackage.j30
    public final View K(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(R.layout.trigger_mode_simple_triggers_layout, viewGroup, false);
        TabLayout tabLayout = (TabLayout) viewInflate.findViewById(R.id.portraitTabLayout);
        this.Y = tabLayout;
        if (tabLayout != null) {
            b41 b41VarJ = tabLayout.j();
            b41VarJ.a(R.string.trigger_tab_general_tab_title);
            b41 b41VarJ2 = this.Y.j();
            b41VarJ2.a(R.string.trigger_tab_design_tab_title);
            b41 b41VarJ3 = this.Y.j();
            b41VarJ3.a(R.string.trigger_tab_actions_tab_title);
            this.Y.b(b41VarJ);
            this.Y.b(b41VarJ2);
            this.Y.b(b41VarJ3);
            this.Y.a(new p4(2, this));
        }
        VerticalTabLayout verticalTabLayout = (VerticalTabLayout) viewInflate.findViewById(R.id.landscapeTabLayout);
        this.Z = verticalTabLayout;
        if (verticalTabLayout != null) {
            ze1 ze1VarH = verticalTabLayout.h();
            ze1VarH.a(R.string.trigger_tab_general_tab_title);
            ze1 ze1VarH2 = this.Z.h();
            ze1VarH2.a(R.string.trigger_tab_design_tab_title);
            ze1 ze1VarH3 = this.Z.h();
            ze1VarH3.a(R.string.trigger_tab_actions_tab_title);
            this.Z.a(ze1VarH);
            this.Z.a(ze1VarH2);
            this.Z.a(ze1VarH3);
            VerticalTabLayout verticalTabLayout2 = this.Z;
            q4 q4Var = new q4(1, this);
            ArrayList arrayList = verticalTabLayout2.E;
            if (!arrayList.contains(q4Var)) {
                arrayList.add(q4Var);
            }
        }
        h0(0);
        return viewInflate;
    }

    public final void h0(int i) {
        j30 wa1Var;
        if (i == 1) {
            ((wq0) Z()).f();
            wa1Var = new wa1(null);
        } else if (i != 2) {
            ((wq0) Z()).i();
            wa1Var = new a11();
        } else {
            ((wq0) Z()).i();
            wa1Var = new ua1(null);
        }
        y30 y30VarL = l();
        y30VarL.getClass();
        ld ldVar = new ld(y30VarL);
        ldVar.j(R.anim.fragment_fade_in, R.anim.fragment_fade_out);
        ldVar.i(R.id.tabFragment, wa1Var);
        ldVar.e(false);
    }
}
