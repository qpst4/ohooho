package defpackage;

import android.os.Build;
import android.os.Bundle;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class k00 extends d3 {
    public final /* synthetic */ int j0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k00(int i, Map map, int i2) {
        super(i, map);
        this.j0 = i2;
    }

    @Override // defpackage.d3, defpackage.gq0, defpackage.j30
    public final void J(Bundle bundle) {
        switch (this.j0) {
            case 0:
                super.J(bundle);
                h0("expandToggle").B(Build.VERSION.SDK_INT >= 31);
                break;
            default:
                super.J(bundle);
                int i = 19;
                h0("profile0").f = new r1(i, this);
                h0("profile1").f = new r1(i, this);
                h0("profile2").f = new r1(i, this);
                break;
        }
    }
}
