package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class hf0 implements i50, Serializable {
    public final int b;

    public hf0(int i) {
        this.b = i;
    }

    @Override // defpackage.i50
    public final int b() {
        return this.b;
    }

    public final String toString() {
        tu0.a.getClass();
        String string = getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }
}
