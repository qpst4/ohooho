package defpackage;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class al0 implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, ol0 {
    public g31 b;
    public b7 c;
    public gh0 d;

    @Override // defpackage.ol0
    public final void a(zk0 zk0Var, boolean z) {
        b7 b7Var;
        if ((z || zk0Var == this.b) && (b7Var = this.c) != null) {
            b7Var.dismiss();
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        g31 g31Var = this.b;
        gh0 gh0Var = this.d;
        if (gh0Var.g == null) {
            gh0Var.g = new fh0(gh0Var);
        }
        g31Var.q(gh0Var.g.getItem(i), null, 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.d.a(this.b, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        g31 g31Var = this.b;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.c.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.c.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                g31Var.c(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return g31Var.performShortcut(i, keyEvent, 0);
    }

    @Override // defpackage.ol0
    public final boolean s(zk0 zk0Var) {
        return false;
    }
}
