package defpackage;

import android.text.Editable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class vx extends Editable.Factory {
    public static final Object a = new Object();
    public static volatile vx b;
    public static Class c;

    @Override // android.text.Editable.Factory
    public final Editable newEditable(CharSequence charSequence) {
        Class cls = c;
        return cls != null ? new s11(cls, charSequence) : super.newEditable(charSequence);
    }
}
