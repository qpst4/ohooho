package defpackage;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.preference.PreferenceScreen;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class y6 extends Handler {
    public final /* synthetic */ int a = 0;
    public Object b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y6(gq0 gq0Var, Looper looper) {
        super(looper);
        this.b = gq0Var;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (this.a) {
            case 0:
                int i = message.what;
                if (i == -3 || i == -2 || i == -1) {
                    ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) ((WeakReference) this.b).get(), message.what);
                    break;
                } else if (i == 1) {
                    ((DialogInterface) message.obj).dismiss();
                    break;
                }
                break;
            default:
                if (message.what == 1) {
                    gq0 gq0Var = (gq0) this.b;
                    PreferenceScreen preferenceScreen = gq0Var.Z.g;
                    if (preferenceScreen != null) {
                        gq0Var.a0.setAdapter(new jq0(preferenceScreen));
                        preferenceScreen.m();
                    }
                    break;
                }
                break;
        }
    }

    public /* synthetic */ y6() {
    }
}
