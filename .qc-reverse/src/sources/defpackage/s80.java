package defpackage;

import android.content.DialogInterface;
import com.quickcursor.android.activities.HowToUseActivity;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s80 implements DialogInterface.OnCancelListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ s80(int i, Object obj) {
        this.b = i;
        this.c = obj;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        int i = this.b;
        Object obj = this.c;
        switch (i) {
            case 0:
                int i2 = HowToUseActivity.C;
                ((HowToUseActivity) obj).finish();
                break;
            default:
                ((Runnable) obj).run();
                break;
        }
    }
}
