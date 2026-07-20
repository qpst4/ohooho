package defpackage;

import android.os.Message;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.preference.Preference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class l1 implements View.OnClickListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ l1(int i, Object obj) {
        this.b = i;
        this.c = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Message message;
        Message message2;
        Message message3;
        int i = this.b;
        Message messageObtain = null;
        messageObtain = null;
        Object obj = this.c;
        switch (i) {
            case 0:
                ((e2) obj).a();
                break;
            case 1:
                a7 a7Var = (a7) obj;
                if (view == a7Var.i && (message3 = a7Var.k) != null) {
                    messageObtain = Message.obtain(message3);
                } else if (view == a7Var.l && (message2 = a7Var.n) != null) {
                    messageObtain = Message.obtain(message2);
                } else if (view == a7Var.o && (message = a7Var.q) != null) {
                    messageObtain = Message.obtain(message);
                }
                if (messageObtain != null) {
                    messageObtain.sendToTarget();
                }
                a7Var.G.obtainMessage(1, a7Var.b).sendToTarget();
                break;
            case 2:
                hc0 hc0Var = (hc0) obj;
                hc0Var.J(hc0Var.H());
                break;
            case 3:
                zj0 zj0Var = (zj0) obj;
                int i2 = zj0Var.c0;
                if (i2 == 2) {
                    zj0Var.i0(1);
                } else if (i2 == 1) {
                    zj0Var.i0(2);
                }
                break;
            case 4:
                ((Preference) obj).x(view);
                break;
            case 5:
                es0 es0Var = (es0) obj;
                es0Var.J(es0Var.H());
                break;
            case 6:
                w01 w01Var = (w01) obj;
                if (w01Var.b.t() != null) {
                    xy0.z(w01Var.b.t(), w01Var.j, w01Var.k);
                }
                break;
            default:
                u61 u61Var = ((Toolbar) obj).N;
                cl0 cl0Var = u61Var != null ? u61Var.c : null;
                if (cl0Var != null) {
                    cl0Var.collapseActionView();
                }
                break;
        }
    }
}
