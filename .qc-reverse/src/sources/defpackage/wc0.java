package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class wc0 extends qp0 {
    public final Method c;
    public final Method d;

    public wc0(Method method, Method method2) {
        this.c = method;
        this.d = method2;
    }

    @Override // defpackage.qp0
    public final void f(SSLSocket sSLSocket, String str, List list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            ArrayList arrayListB = qp0.b(list);
            this.c.invoke(sSLParameters, arrayListB.toArray(new String[arrayListB.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw be1.a("unable to set ssl parameters", e);
        }
    }

    @Override // defpackage.qp0
    public final String i(SSLSocket sSLSocket) {
        try {
            String str = (String) this.d.invoke(sSLSocket, null);
            if (str != null) {
                if (!str.equals("")) {
                    return str;
                }
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw be1.a("unable to get selected protocols", e);
        }
    }
}
