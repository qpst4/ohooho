package defpackage;

import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class as implements gb1 {
    @Override // defpackage.gb1
    public final fb1 a(i70 i70Var, mc1 mc1Var) {
        if (mc1Var.a() == Date.class) {
            return new bs();
        }
        return null;
    }

    public final String toString() {
        return "DefaultDateTypeAdapter#DEFAULT_STYLE_FACTORY";
    }
}
