package defpackage;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import com.quickcursor.App;
import com.quickcursor.R;
import com.quickcursor.android.views.settings.ActionsRecyclerView;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class q3 extends ns {
    public final /* synthetic */ ActionsRecyclerView t;

    public q3(ActionsRecyclerView actionsRecyclerView) {
        this.t = actionsRecyclerView;
    }

    @Override // defpackage.ns, defpackage.vt0
    public final boolean a(pu0 pu0Var, rm0 rm0Var, rm0 rm0Var2) {
        int i = 0;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(App.c.getColor(R.color.colorAccent), 0);
        valueAnimatorOfInt.setDuration(500L);
        valueAnimatorOfInt.setEvaluator(new ArgbEvaluator());
        valueAnimatorOfInt.addUpdateListener(new o3(i, pu0Var));
        valueAnimatorOfInt.addListener(new p3(this, i, pu0Var));
        valueAnimatorOfInt.start();
        return false;
    }
}
