package defpackage;

import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class qh0 implements View.OnTouchListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ qh0(int i, Object obj) {
        this.b = i;
        this.c = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int i = this.b;
        Object obj = this.c;
        switch (i) {
            case 0:
                rh0 rh0Var = (rh0) obj;
                oh0 oh0Var = rh0Var.s;
                Handler handler = rh0Var.w;
                h9 h9Var = rh0Var.A;
                int action = motionEvent.getAction();
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (action == 0 && h9Var != null && h9Var.isShowing() && x >= 0 && x < h9Var.getWidth() && y >= 0 && y < h9Var.getHeight()) {
                    handler.postDelayed(oh0Var, 250L);
                } else if (action == 1) {
                    handler.removeCallbacks(oh0Var);
                }
                return false;
            default:
                if (((Checkable) view).isChecked()) {
                    return ((GestureDetector) obj).onTouchEvent(motionEvent);
                }
                return false;
        }
    }
}
