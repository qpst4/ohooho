package defpackage;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class z90 extends vb {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;

    public /* synthetic */ z90(int i, Object obj) {
        this.j = i;
        this.k = obj;
    }

    @Override // defpackage.vb
    public IOException l(IOException iOException) {
        switch (this.j) {
            case 0:
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            case 1:
                SocketTimeoutException socketTimeoutException2 = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException2.initCause(iOException);
                }
                return socketTimeoutException2;
            default:
                return super.l(iOException);
        }
    }

    @Override // defpackage.vb
    public final void m() {
        int i = this.j;
        Object obj = this.k;
        switch (i) {
            case 0:
                aa0 aa0Var = (aa0) obj;
                if (aa0Var.d(6)) {
                    aa0Var.d.u(aa0Var.c, 6);
                    return;
                }
                return;
            case 1:
                Socket socket = (Socket) obj;
                try {
                    socket.close();
                    return;
                } catch (AssertionError e) {
                    if (e.getCause() == null || e.getMessage() == null || !e.getMessage().contains("getsockname failed")) {
                        throw e;
                    }
                    tn0.a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e);
                    return;
                } catch (Exception e2) {
                    tn0.a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e2);
                    return;
                }
            default:
                ((ht0) obj).a();
                return;
        }
    }

    public void n() {
        if (k()) {
            throw l(null);
        }
    }
}
