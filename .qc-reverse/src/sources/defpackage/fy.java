package defpackage;

import android.widget.EditText;
import androidx.appcompat.widget.SwitchCompat;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class fy extends qx {
    public final /* synthetic */ int a = 0;
    public final WeakReference b;

    public fy(EditText editText) {
        this.b = new WeakReference(editText);
    }

    @Override // defpackage.qx
    public void a() {
        switch (this.a) {
            case 1:
                SwitchCompat switchCompat = (SwitchCompat) this.b.get();
                if (switchCompat != null) {
                    switchCompat.c();
                }
                break;
        }
    }

    @Override // defpackage.qx
    public final void b() {
        int i = this.a;
        WeakReference weakReference = this.b;
        switch (i) {
            case 0:
                gy.a((EditText) weakReference.get(), 1);
                break;
            default:
                SwitchCompat switchCompat = (SwitchCompat) weakReference.get();
                if (switchCompat != null) {
                    switchCompat.c();
                }
                break;
        }
    }

    public fy(SwitchCompat switchCompat) {
        this.b = new WeakReference(switchCompat);
    }
}
