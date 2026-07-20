package defpackage;

import java.io.IOException;
import java.io.StringWriter;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class pd0 {
    public final td0 b() {
        if (this instanceof td0) {
            return (td0) this;
        }
        zy.s("Not a JSON Object: ", this);
        return null;
    }

    public String c() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public final String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            ae0 ae0Var = new ae0(stringWriter);
            ae0Var.i = 1;
            kc1.z.getClass();
            qd0.e(ae0Var, this);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
