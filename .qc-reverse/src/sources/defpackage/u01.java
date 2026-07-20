package defpackage;

import android.view.View;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class u01 {
    public int a = 0;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int e = R.layout.mi_fragment_simple_slide;
    public boolean f = true;
    public boolean g = true;
    public int h = 0;
    public View.OnClickListener i = null;

    public final w01 a() {
        if (this.a != 0) {
            return new w01(this);
        }
        zy.n("You must set a background.");
        return null;
    }
}
