package defpackage;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import com.quickcursor.App;
import com.quickcursor.R;
import com.quickcursor.android.activities.settings.EdgeActionsSettings;
import com.quickcursor.android.views.settings.EdgeBarConstraintLayout;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class nw extends e9 {
    public final int e;
    public final int f;
    public lw g;
    public ValueAnimator h;
    public boolean i;

    public nw(Context context, lw lwVar, Boolean bool) {
        super(context, null);
        this.e = App.c.getColor(R.color.edge_action_background_tint_pressed);
        this.f = App.c.getColor(R.color.edge_action_background_tint);
        this.i = false;
        this.g = lwVar;
        if (bool.booleanValue()) {
            setLayoutParams(new LinearLayout.LayoutParams(-1, 0, lwVar.j()));
        } else {
            setLayoutParams(new LinearLayout.LayoutParams(0, -1, lwVar.j()));
        }
        a();
        setOnClickListener(new a3(7, this));
        setOnLongClickListener(new View.OnLongClickListener() { // from class: mw
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                nw nwVar = this.b;
                EdgeActionsSettings edgeActionsSettings = (EdgeActionsSettings) nwVar.getContext();
                boolean z = nwVar.i;
                edgeActionsSettings.getClass();
                nwVar.b(!nwVar.i);
                EdgeBarConstraintLayout edgeBarConstraintLayout = null;
                for (EdgeBarConstraintLayout edgeBarConstraintLayout2 : edgeActionsSettings.P) {
                    edgeBarConstraintLayout2.m(nwVar);
                    if (edgeBarConstraintLayout2.E.a(nwVar) > -1) {
                        if (z) {
                            edgeActionsSettings.M(edgeBarConstraintLayout2);
                        } else {
                            edgeActionsSettings.N(edgeBarConstraintLayout2);
                        }
                        edgeBarConstraintLayout = edgeBarConstraintLayout2;
                    }
                }
                if (!z) {
                    edgeActionsSettings.G(new qw(nwVar, edgeBarConstraintLayout));
                }
                return true;
            }
        });
    }

    public final void a() {
        ((LinearLayout.LayoutParams) getLayoutParams()).weight = this.g.j();
        int iA = ey0.a(12);
        setAdjustViewBounds(true);
        setPadding(iA, iA, iA, iA);
        setImageDrawable(this.g.d(getContext()));
        Resources resources = getResources();
        ThreadLocal threadLocal = ew0.a;
        setBackground(resources.getDrawable(R.drawable.edge_action, null));
        setBackgroundTintList(getContext().getColorStateList(this.i ? R.color.edge_action_background_tint_pressed : R.color.edge_action_background_tint));
        requestLayout();
    }

    public final void b(boolean z) {
        boolean z2 = this.i;
        if (z2 == z) {
            return;
        }
        this.i = !z2;
        ValueAnimator valueAnimator = this.h;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.h.cancel();
        }
        int i = this.e;
        int i2 = this.f;
        if (z) {
            this.h = ValueAnimator.ofInt(i2, i);
        } else {
            this.h = ValueAnimator.ofInt(i, i2);
        }
        this.h.setDuration(200L);
        this.h.setEvaluator(new ArgbEvaluator());
        this.h.addUpdateListener(new o3(2, this));
        this.h.start();
    }

    public lw getEdgeAction() {
        return this.g;
    }

    @Override // android.view.View
    public final boolean isPressed() {
        return this.i;
    }
}
