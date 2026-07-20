package defpackage;

import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class el0 extends FrameLayout implements fl {
    public final CollapsibleActionView b;

    /* JADX WARN: Multi-variable type inference failed */
    public el0(View view) {
        super(view.getContext());
        this.b = (CollapsibleActionView) view;
        addView(view);
    }
}
